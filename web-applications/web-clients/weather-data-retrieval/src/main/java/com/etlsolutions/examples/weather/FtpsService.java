package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.MILI_SECONDS_PER_MINUTE;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class FtpsService {

    private final Logger logger = Logger.getLogger(FtpsService.class);
    private final long delayTime = 1000;
    private final JSch jsch = new JSch();

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

                logger.info("\nStart to copy data...");
                int minutes = parameters.getIntervalInMinutes();

                while (!stopped) {

                    try {

                        if (minutes >= parameters.getIntervalInMinutes()) {

                            Session session = jsch.getSession(parameters.getFtpsServerUsername(), parameters.getFtpsServerName(), 22);
                            session.setConfig("StrictHostKeyChecking", "no");
                            session.setPassword(parameters.getFtpsServerPassword());
                            session.connect();
                            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
                            sftpChannel.connect();

                            File[] files = new File(parameters.getDataDirectoryPath()).listFiles();
                            try {
                                for (File file : files) {
                                    String filename = file.getName();
                                    if (file.isFile() && filename.toLowerCase().endsWith(parameters.getDataFileExtension())) {

                                        InputStream inputStream = sftpChannel.get(parameters.getFtpsRemoteSourceDirectory() + "/" + filename);
                                        FileUtils.copyInputStreamToFile(inputStream, new File(parameters.getFtpsLocalTargetDirecotry() + File.separator + filename));
                                    }
                                }
                            } finally {
                                sftpChannel.exit();
                                session.disconnect();
                            }
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
            myThread.join(delayTime);
            myThread = null;

        } catch (Exception ex) {

            logger.warn("Failed to stop the FTPS service", ex);
        }
    }
}
