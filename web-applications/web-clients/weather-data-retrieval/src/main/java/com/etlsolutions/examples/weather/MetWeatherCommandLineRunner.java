package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * The MetWeatherCommandLineRunner class is the main class to run the
 * application.
 *
 * @author zc
 */
public final class MetWeatherCommandLineRunner {

    static {
        System.setProperty("metweather.home", APPLICATION_HOME);
    }

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(MetWeatherCommandLineRunner.class);

        try {

            ApplicationParametersFactory factory = ApplicationParametersFactory.getInstance();
            ApplicationParameters parameters = factory.loadApplicationParameters(args);

            logger.info("\n\n\nStart to retrieve data...");
            logger.info(new Date().toString());
            logger.info("\nConfigurations:");
            logger.info(parameters.toString() + "\n");

            if (parameters.isRunMultiple()) {
                new MultipleProcessor().process(parameters);
            } else {
                new SingleProcessor().process(parameters);
            }

            factory.saveParameters(parameters);

            logger.info("Run success.");

        } catch (Throwable th) {
            logger.error("Run failed.", th);
            System.exit(-1);
        }
    }
}
