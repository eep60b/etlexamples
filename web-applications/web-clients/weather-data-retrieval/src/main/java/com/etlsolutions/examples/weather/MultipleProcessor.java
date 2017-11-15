package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author zc
 */
public final class MultipleProcessor {

    @SuppressWarnings("SleepWhileInLoop")
    public void process(ApplicationParameters parameters) throws Exception {

        Logger logger = Logger.getLogger(MultipleProcessor.class);
        int count = 1;
        Properties runningProperties = new Properties();
        SingleProcessor singleProcessor = new SingleProcessor();
        Date stopDate = parameters.getStopDate();
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
                runningProperties.store(new FileOutputStream(RUNNING_CONFIG_FILE_PATH), "reset");
            
            } else if (stopProcess.trim().equalsIgnoreCase("true")) {
                
                runningProperties.setProperty(STOP_PROCESS_KEY, "false");
                runningProperties.store(new FileOutputStream(RUNNING_CONFIG_FILE_PATH), "reset");
                logger.info("Process interrupted.");
                break;
            
            } else {
                singleProcessor.process(parameters);
            }

            logger.info("Recorded. Waiting....");
            Thread.sleep(parameters.getIntervalMiliSeconds());
            count++;
        }
    }
}
