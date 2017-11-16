package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class MultipleProcessor {

    @SuppressWarnings("SleepWhileInLoop")
    public void process(ApplicationParameters parameters) throws Exception {

        Logger logger = Logger.getLogger(MultipleProcessor.class);
        FileLock lock = null;
        FileChannel channel = null;
        File lockFile = new File(RUNNING_LOCK_FILE_PATH);
        try {      
            
            if (lockFile.isFile()) {
                throw new IOException("There is another instance running. Try to close it and run again.");
            } else {
                FileUtils.writeStringToFile(lockFile, "Once this file appears, there is an instance which is running. \nClose the instance if you want to run a new instance. \nThis file will be automatically deleted after the closure of the running instance.", parameters.getDataEncoding(), false);
            }
            
            channel = new RandomAccessFile(lockFile, "rw").getChannel();

            // Use the lockFile channel to create a lock on the lockFile.
            // This method blocks until it can retrieve the lock.
            lock = channel.lock();
            
            int count = 1;
            Properties runningProperties = new Properties();
            SingleProcessor singleProcessor = new SingleProcessor();
            Date stopDate = parameters.getStopTime();
            File file = new File(RUNNING_CONFIG_FILE_PATH);
            if (!file.isFile()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            while (stopDate == null || stopDate.getTime() >= new Date().getTime()) {
                logger.info("Recording: " + count);
                runningProperties.load(new FileInputStream(file));
                String stopProcess = runningProperties.getProperty(STOP_PROCESS_KEY);

                if (stopProcess == null || stopProcess.trim().isEmpty()) {

                    runningProperties.setProperty(STOP_PROCESS_KEY, "false");
                    runningProperties.store(new FileOutputStream(file), "reset");

                } else if (stopProcess.trim().equalsIgnoreCase("true")) {

                    runningProperties.setProperty(STOP_PROCESS_KEY, "false");
                    runningProperties.store(new FileOutputStream(file), "reset");
                    logger.info("\nProcess interrupted at " + new Date().toString());
                    break;

                } else {
                    singleProcessor.process(parameters);
                }

                logger.info("Recorded at " + new Date().toString());
                logger.info("\nWaiting....");
                Thread.sleep(parameters.getIntervalMiliSeconds());
                count++;
            }
        } finally {
            
            //Release the lock.
            if (lock != null) {
                lock.release();
            }

            // Close the lockFile
            if (channel != null) {
                channel.close();
            }
            
            lockFile.delete();
        }
    }
}
