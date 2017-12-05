package com.etlsolutions.examples.weather;

import java.util.Date;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public class MetDaemon implements Daemon {

 
    static {
        System.setProperty("metweather.home", "/tmp/metdata/log");
    }
    
    private Thread myThread;
    private boolean stopped = false;
    private static int count;

    @Override
    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {
        /*
         * Construct objects and initialize variables here.
         * You can access the command line arguments that would normally be passed to your main() 
         * method as follows:
         */
        String[] args = daemonContext.getArguments();
        final Logger logger = Logger.getLogger(MetDaemon.class);

        logger.info("Start the service...");
        logger.info(new Date().toString());
        ApplicationParametersFactory factory = ApplicationParametersFactory.getInstance();
        final ApplicationParameters parameters = factory.loadApplicationParameters(args);

        logger.info("\nStart to retrieve data...");
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
                while (!stopped) {
                    String currentTime = new Date().toString();
                    try {
                        SingleProcessor singleProcessor = new SingleProcessor();
                        singleProcessor.process(parameters);
                        
                        logger.info("\nNo." + count);
                        logger.info("Data recorded at " + currentTime);
                        logger.info("Data location:            " + parameters.getDataDirectoryPath());
                        logger.info("Data additional location: " + parameters.getAddtionalDataPaths());
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
        myThread.start();
    }

    @Override
    public void stop() throws Exception {
        stopped = true;
        try {
            myThread.join(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            myThread.interrupt();
            throw e;
        }
    }

    @Override
    public void destroy() {
        myThread = null;
    }
}
