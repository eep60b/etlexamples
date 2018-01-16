package com.etlsolutions.examples.weather;

import java.util.Date;
import org.apache.log4j.Logger;

/**
 * The MetThreadService class is a JVSC daemon which can be run as a linux
 * service.
 *
 * @author zc
 */
public class MetThreadService {

    private final Logger logger = Logger.getLogger(MetThreadService.class);
    private Thread myThread;
    private boolean stopped;
    private final SingleProcessor singleProcessor = new SingleProcessor();
    private int count = 1;
    private final long delayTime = 1000;

    public void init(String[] args) throws Exception {

        logger.info("\n\nStart to load the configurations...");
        logger.info(new Date().toString());
        ApplicationParametersFactory factory = ApplicationParametersFactory.getInstance();
        final ApplicationParameters parameters = factory.loadApplicationParameters(args);
        logger.info("\nConfigurations:");
        logger.info(parameters.toString() + "\n");

        myThread = new Thread() {

            @Override
            public synchronized void start() {
                MetThreadService.this.stopped = false;
                super.start();
            }

            @Override
            @SuppressWarnings("SleepWhileInLoop")
            public void run() {

                logger.info("\nStart to retrieve data...");

                while (!stopped) {

                    String currentTime = new Date().toString();

                    try {

                        boolean success = singleProcessor.process(parameters);

                        logger.info("\nNo." + count);
                        if (success) {
                            logger.info("Data successfully recorded at " + currentTime);
                            logger.info("Data location:            " + parameters.getDataDirectoryPath());
                            logger.info("Data additional location: " + parameters.getAdditionalDataDirectoryPaths());
                        } else{
                            logger.info("Failed to record data at " + currentTime);
                        }
                        
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

    public void start() {

        stopped = false;
        String startMessage = new Date().toString() + ":  Start the metd service.";
        logger.info(startMessage);
        System.out.println(startMessage);
        myThread.start();
        String startSuccessMessage = new Date().toString() + ":  The metd service has been successfully started.";
        logger.info(startSuccessMessage);
        System.out.println(startSuccessMessage);
    }

    public void stop() throws Exception {

        stopped = true;
        try {
            String stopServiceMessage = "\n\n" + new Date().toString() + ":  Stop the metd service.";
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

    public void destroy() {
        myThread = null;
        String destroyMessage = "The metd service thread has been destroyed.";
        logger.info(destroyMessage);
        System.out.println(destroyMessage);
    }
}
