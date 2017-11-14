package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author zc
 */
public class MultipleProcessor {

    private final Properties runningProperties = new Properties();
    private final SingleProcessor singleProcessor = new SingleProcessor();

    public synchronized void process(ApplicationParameters parameters, Date stopDate) throws Exception {

        while (stopDate != null && stopDate.compareTo(new Date()) >= 0) {
            runningProperties.load(new FileInputStream(RUNNING_CONFIG_FILE_PATH));
            String stopProcess = runningProperties.getProperty(STOP_PROCESS_KEY);

            if (stopProcess == null || stopProcess.trim().isEmpty()) {
                runningProperties.setProperty(STOP_PROCESS_KEY, "false");
                runningProperties.store(new FileOutputStream(RUNNING_CONFIG_FILE_PATH), "reset");
            }
            else if(stopProcess.trim().equalsIgnoreCase("true")) {
                runningProperties.setProperty(STOP_PROCESS_KEY, "false");
                break;
            }
            else {
               singleProcessor.process(parameters);
            }
                
        }
    }

}
