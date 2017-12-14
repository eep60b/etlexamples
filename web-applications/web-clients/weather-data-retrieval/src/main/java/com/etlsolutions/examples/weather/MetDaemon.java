package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.util.Date;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.log4j.Logger;

/**
 * The MetDaemon class is a JVSC daemon which can be run as a linux service.
 *
 * @author zc
 */
public class MetDaemon implements Daemon {

    static {
        System.setProperty(APPLICATION_USERHOME_KEY, DEFAULT_APPLICATION_USERHOME);
    }

    private final Logger logger = Logger.getLogger(MetDaemon.class);
    private Thread myThread;
    private boolean stopped = false;
    private final SingleProcessor singleProcessor = new SingleProcessor();
    private int count = 1;
    private final long delayTime = 1000;

    @Override
    public void init(DaemonContext daemonContext) throws Exception {

        /*
         * Construct objects and initialize variables here.
         * You can access the command line arguments that would normally be passed to your main() 
         * method as follows:
         */
        String[] args = daemonContext.getArguments();

        logger.info("Start to load the configurations...");
        logger.info(new Date().toString());
        ApplicationParametersFactory factory = ApplicationParametersFactory.getInstance();
        final ApplicationParameters parameters = factory.loadApplicationParameters(args);
        logger.info("\nConfigurations:");
        logger.info(parameters.toString() + "\n");

        myThread = new Thread() {

            @Override
            public synchronized void start() {
                MetDaemon.this.stopped = false;
                super.start();
            }

            @Override
            @SuppressWarnings("SleepWhileInLoop")
            public void run() {

                logger.info("\nStart to retrieve data...");

                while (!stopped) {
                    
                    String currentTime = new Date().toString();
                    
                    try {

                        singleProcessor.process(parameters);

                        logger.info("\nNo." + count);
                        logger.info("Data recorded at " + currentTime);
                        logger.info("Data location:            " + parameters.getDataDirectoryPath());
                        logger.info("Data additional location: " + parameters.getAdditionalDataDirectoryPaths());
                        count++;
                        Thread.sleep(parameters.getIntervalMiliSeconds());
                    } catch (Exception ex) {
                        logger.error("Process error occured at " + currentTime + ".", ex);
                        System.err.println("Process error occured at " + currentTime + ".\n" + ex);
                        System.exit(-1);
                    }
                }
            }
        };
    }

    @Override
    public void start() {

        String startMessage = new Date().toString() + ":  Start the metd service.";
        logger.info(startMessage);
        System.out.println(startMessage);
        myThread.start();
        String startSuccessMessage = new Date().toString() + ":  The metd service has been successfully started.";
        logger.info(startSuccessMessage);
        System.out.println(startSuccessMessage);
    }

    @Override
    public void stop() throws Exception {

        stopped = true;
        try {
            String stopServiceMessage = new Date().toString() + ":  Stop the metd service.";
            logger.info(stopServiceMessage);
            System.out.println(stopServiceMessage);
            myThread.join(delayTime);
            String stopSuccessMessage = new Date().toString() + ":  The metd service has been successfully stopped.";
            logger.info(stopSuccessMessage);
            System.out.println(stopSuccessMessage);

        } catch (InterruptedException e) {

            String message = "Failed to stop the metd service.";
            logger.error(message, e);
            System.err.println(message);
            System.err.println(e.getMessage());
            System.err.println("Force to terminate the metd service.");
            System.exit(-1);
        }
    }

    @Override
    public void destroy() {
        myThread = null;
        String destroyMessage = "The metd service thread has been destroyed.";
        logger.info(destroyMessage);
        System.out.println(destroyMessage);
    }
}
