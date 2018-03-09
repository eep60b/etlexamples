package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.MILI_SECONDS_PER_MINUTE;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class FtpsService {

    private final Logger logger = Logger.getLogger(FtpsService.class);
    private final long delayTime = 1000;
    private final FtpsFileRetriever retriever = new FtpsFileRetriever();

    private Thread myThread;
    private boolean stopped;

    public void init(ApplicationParameters parameters) throws Exception {

        logger.info("\n\nStart to use FTPS to copy data from the linux server " + parameters.getFtpsServerName());
        logger.info(new Date().toString());

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
                            logger.info("Copied file location:            " + parameters.getFtpsLocalTargetDirecotry());
                            minutes = 0;

                        } else {
                            minutes++;
                            Thread.sleep(MILI_SECONDS_PER_MINUTE);
                        }

                    } catch (Exception ex) {
                        logger.warn("Failed to copy data from the server " + parameters.getFtpsServerName(), ex);
                    }
                }
            }
        };
    }

    public void start() {

        stopped = false;
        myThread.start();
    }

    public void stop() {

        stopped = true;
        try {
            
            if (myThread == null) {
                return;
            }

            myThread.join(delayTime);
            myThread = null;

        } catch (Exception ex) {

            logger.warn("Failed to stop the FTPS service", ex);
        }
    }
}
