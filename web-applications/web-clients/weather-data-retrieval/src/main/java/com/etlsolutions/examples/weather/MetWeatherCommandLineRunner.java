package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import org.apache.log4j.Logger;


/**
 *
 * @author zc
 */
public final class MetWeatherCommandLineRunner {

    static {
        System.setProperty("metweather.home", APPLICATION_HOME);
    }    
    
    public static void main(String[] args) throws Throwable {
        
        Logger logger = Logger.getLogger(MetWeatherCommandLineRunner.class);
        
        try{
            
            ApplicationParametersFactory factory = ApplicationParametersFactory.getInstance();
            ApplicationParameters parameters = factory.loadApplicationParameters(args);
            
            logger.info("Start to retrieve data...\nConfigurations:");
            logger.info(parameters);
            
            if(parameters.isRunMultiple()) {
                new MultipleProcessor().process(parameters);
            } else {
                new SingleProcessor().process(parameters);
            }
            
            factory.saveParameters(parameters);
            
            logger.info("Run success.");
            
        } catch (Throwable th) {
            logger.error("Failed.", th);
            throw th;
        }
    }
}
