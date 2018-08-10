package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 * The FtpsService class provides methods to fulfil a service to download data
 * files from a FTPS server.
 *
 * @author zc
 */
public final class FtpsService {

    private final Logger logger = Logger.getLogger(FtpsService.class);
    private final FtpsFileRetriever retriever = new FtpsFileRetriever();

    private Thread myThread;
    private boolean stopped;

    /**
     *
     * @param parameters
     * @throws Exception
     */
    public void init(final ApplicationParameters parameters) throws Exception {

        logger.info("\n\nStart to use FTPS to copy data from the linux server " + parameters.getFtpsServerName());

        myThread = new Thread() {

            @Override
            public synchronized void start() {
                FtpsService.this.stopped = false;
                super.start();
            }

            @Override
            @SuppressWarnings({"SleepWhileInLoop", "UseSpecificCatch"})
            public void run() {

                logger.info("\nStart to copy data from Linux server: " + parameters.getFtpsServerName());
                int minutes = parameters.getIntervalInMinutes();

                while (!stopped) {

                    try {

                        if (minutes >= parameters.getIntervalInMinutes()) {

                            retriever.copyFiles(parameters);
                            logger.info("Data files successfully copied from the linux server.");
                            logger.info("Copied file location:            " + parameters.getFtpsLocalTargetDirecotries());
                            minutes = 0;

                        } else {
                            minutes++;
                            Thread.sleep(THREAD_SLEEP_TIME);
                        }

                    } catch (Exception ex) {

                        //If an error occurs, try again after a while unless the thread cannot be put into sleep.
                        try {

                            Thread.sleep(THREAD_SLEEP_TIME);

                        } catch (InterruptedException iex) {
                            stopped = true;
                            logger.warn("Failed to put the thread into sleap.", iex);
                        }
                        logger.warn("Failed to copy data from the server " + parameters.getFtpsServerName(), ex);
                    }
                }
            }
        };
    }

    /**
     * Start this service.
     */
    public void start() {
        try {
            Thread.sleep(FTPS_START_DELAY_TIME);
            stopped = false;
            myThread.start();
        } catch (InterruptedException ex) {
            logger.warn("Failed to set the delay start time for the FTPS service", ex);
        } catch (Throwable th) {
            logger.warn("Failed to start the FTPS service.", th);
        }
    }

    public void stop() {

        stopped = true;
        try {

            if (myThread == null) {
                return;
            }

            myThread.join(THREAD_JOIN_DELAY_TIME);

        } catch (Exception ex) {

            logger.warn("Failed to stop the FTPS service", ex);
        } finally {
            myThread = null;
        }
    }
}
