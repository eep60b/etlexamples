package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.io.PrintStream;
import java.net.ConnectException;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * The MetThreadService class is a JVSC daemon which can be run as a linux
 * service.
 *
 * @author zc
 */
public final class MetThreadService {

    private final Logger logger = Logger.getLogger(MetThreadService.class);
    private final MetServiceExceptionHandler exceptionHandler = new MetServiceExceptionHandler(logger);
    private final PrintStream printStream = System.out;
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
                int minutes = parameters.getIntervalInMinutes();
                while (!stopped) {

                    String currentTime = new Date().toString();

                    try {

                        if (minutes >= parameters.getIntervalInMinutes()) {

                            logger.info("\nNo." + count);
                            boolean success = singleProcessor.process(parameters);

                            if (success) {
                                logger.info("Data successfully recorded at " + currentTime);
                                logger.info("Data location:            " + parameters.getDataDirectoryPath());
                                logger.info("Data additional location: " + parameters.getAdditionalDataDirectoryPaths());
                            } else {
                                logger.warn("Failed to record data at " + currentTime);
                            }

                            count++;
                            minutes = 0;

                        } else {
                            minutes++;
                            Thread.sleep(MILI_SECONDS_PER_MINUTE);
                        }

                    } catch (ConnectException ex) {

                        exceptionHandler.handleWarning(ex);

                    } catch (Exception ex) {
                        exceptionHandler.handleError(ex, "Process error occured");
                        return;
                    }
                }
            }
        };
    }

    public void start() {

        stopped = false;
        String startMessage = new Date().toString() + ":  Start the metd service.";
        logger.info(startMessage);
        printStream.println(startMessage);
        myThread.start();
        String startSuccessMessage = new Date().toString() + ":  The metd service has been successfully started.";
        logger.info(startSuccessMessage);
        printStream.println(startSuccessMessage);
    }

    public void stop() {

        stopped = true;
        try {
            String stopServiceMessage = "\n\n" + new Date().toString() + ":  Stop the metd service.";
            logger.info(stopServiceMessage);
            printStream.println(stopServiceMessage);
            myThread.join(delayTime);
            String stopSuccessMessage = new Date().toString() + ":  The metd service has been successfully stopped.";
            logger.info(stopSuccessMessage);
            printStream.println(stopSuccessMessage);

        } catch (Exception ex) {
            
            exceptionHandler.handleError(ex, "Failed to stop the metd service");
        }
    }

    public void destroy() {
        myThread = null;
        String destroyMessage = "The metd service thread has been destroyed.";
        logger.info(destroyMessage);
        printStream.println(destroyMessage);
    }
}
