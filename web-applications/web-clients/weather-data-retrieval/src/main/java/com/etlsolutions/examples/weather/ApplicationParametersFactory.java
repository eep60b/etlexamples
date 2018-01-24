package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.apache.log4j.Logger;

/**
 * The ApplicationParametersFactory class is a factory class which create the
 * parameter object for the application.
 *
 * @author zc
 */
public final class ApplicationParametersFactory {

    private static final ApplicationParametersFactory INSTANCE = new ApplicationParametersFactory();

    private final Properties properties = new Properties();
    private File configFile;

    private ApplicationParametersFactory() {
    }

    public static final ApplicationParametersFactory getInstance() {
        return INSTANCE;
    }

    public synchronized ApplicationParameters loadApplicationParameters(String[] args) throws Exception {

        Options options = new Options();
        options.addOption(CONFIG_FILE_PATH_KEY, true, "The config file path");
        options.addOption(DATA_DIRECTORY_PATH_KEY, true, "The data file path");
        options.addOption(ADDITIONAL_DATA_PATH_KEY, true, "The additional data paths.");
        options.addOption(BASE_DATA_PATH_KEY, true, "The base data path.");
        options.addOption(DATA_ENCODING_KEY, true, "The data encoding method.");
        options.addOption(DATA_FILE_EXTENSION_KEY, true, "The data file extension.");
        options.addOption(INTERVAL_MINUTES_KEY, true, "The interval in minutes to retrieval data.");
        options.addOption(REQUEST_LOCATIONS_FILE_PATH_KEY, true, "The path where the location file to be loaded.");
        options.addOption(RESOURCE_PROPERTIES_FILE_PATH_KEY, true, "The path where the resource properties files to be loaded.");
        options.addOption(DATETIME_FORMAT_KEY, true, "The date time format.");
        options.addOption(DELIMITER_KEY, true, "The delimiter to separate the data fields.");

        CommandLineParser parser = new PosixParser();
        CommandLine commandLine = parser.parse(options, args);

        String configFilePath = commandLine.getOptionValue(CONFIG_FILE_PATH_KEY);
        String dataDirecotryPath = commandLine.getOptionValue(DATA_DIRECTORY_PATH_KEY);
        String additionalDataPathString = commandLine.getOptionValue(ADDITIONAL_DATA_PATH_KEY);
        String baseDataPathString = commandLine.getOptionValue(BASE_DATA_PATH_KEY);
        String dataEncoding = commandLine.getOptionValue(DATA_ENCODING_KEY);
        String dataFileExtension = commandLine.getOptionValue(DATA_FILE_EXTENSION_KEY);
        String intervalMinutes = commandLine.getOptionValue(INTERVAL_MINUTES_KEY);
        String requestLocationfilePath = commandLine.getOptionValue(REQUEST_LOCATIONS_FILE_PATH_KEY);
        String requestPropertiesFilePath = commandLine.getOptionValue(RESOURCE_PROPERTIES_FILE_PATH_KEY);
        String datetimeFormat = commandLine.getOptionValue(DATETIME_FORMAT_KEY);
        String delimiter = commandLine.getOptionValue(DELIMITER_KEY);

        configFilePath = configFilePath == null ? DEFAULT_CONFIG_FILE_PATH : configFilePath;
        configFile = new File(configFilePath);
        
        Logger logger = Logger.getLogger(ApplicationParametersFactory.class);
        if (configFile.isFile()) {
            logger.info("\nTry to load the configuration parameters from " + configFilePath + ".");
            properties.load(new FileInputStream(configFile));
            logger.info("The configuration parameters have been successfully loaded.");
        } else {
            logger.warn("\nNo configuration file can be found. Use the embedded parameters.");            
        }

        String savedDataPath = properties.getProperty(DATA_DIRECTORY_PATH_KEY);
        String savedAdditionalDataPathString = properties.getProperty(ADDITIONAL_DATA_PATH_KEY);
        String savedBaseDataPathString = properties.getProperty(BASE_DATA_PATH_KEY);
        String savedDataEncoding = properties.getProperty(DATA_ENCODING_KEY);
        String savedDataFileExtension = properties.getProperty(DATA_FILE_EXTENSION_KEY);
        String savedIntervalMinutes = properties.getProperty(INTERVAL_MINUTES_KEY);
        String savedRequestLocationfilePath = properties.getProperty(REQUEST_LOCATIONS_FILE_PATH_KEY);
        String savedRequestPropertiesFilePath = properties.getProperty(RESOURCE_PROPERTIES_FILE_PATH_KEY);
        String savedDatetimeFormat = properties.getProperty(DATETIME_FORMAT_KEY);
        String savedDelimiter = properties.getProperty(DELIMITER_KEY);

        dataDirecotryPath = dataDirecotryPath == null ? (savedDataPath == null ? DEFAULT_DATA_DIRECTORY_PATH : savedDataPath) : dataDirecotryPath;

        additionalDataPathString = additionalDataPathString == null ? (savedAdditionalDataPathString == null ? DEFAULT_ADDITIONAL_DATA_PATH : savedAdditionalDataPathString) : additionalDataPathString;
        baseDataPathString = baseDataPathString == null ? (savedBaseDataPathString == null ? DEFAULT_BASE_DATA_PATH : savedBaseDataPathString) : baseDataPathString;
        dataEncoding = dataEncoding == null ? (savedDataEncoding == null ? DEFAULT_DATA_ENCODING : savedDataEncoding) : dataEncoding;
        dataFileExtension = dataFileExtension == null ? (savedDataFileExtension == null ? DEFAULT_DATA_FILE_EXTENSION : savedDataFileExtension) : dataFileExtension;
        intervalMinutes = intervalMinutes == null ? savedIntervalMinutes : intervalMinutes;

        requestLocationfilePath = requestLocationfilePath == null ? (savedRequestLocationfilePath == null ? DEFAULT_REQUEST_LOCATIONS_FILE_PATH : savedRequestLocationfilePath) : requestLocationfilePath;
        requestPropertiesFilePath = requestPropertiesFilePath == null ? (savedRequestPropertiesFilePath == null ? DEFAULT_RESORRCE_PROPERTIES_FILE_PATH : savedRequestPropertiesFilePath) : requestPropertiesFilePath;
        List<RequestConfig> requestConfigs = RequestConfigLoader.getInstance().load(requestPropertiesFilePath, requestLocationfilePath);
        
        datetimeFormat = datetimeFormat == null ? (savedDatetimeFormat == null ? DEFAULT_DATETIME_FORMAT : savedDatetimeFormat) : datetimeFormat;
        delimiter = delimiter == null ? (savedDelimiter == null ? DEFAULT_DELIMITER : savedDelimiter) : delimiter;
        
        properties.clear();
        properties.setProperty(DATA_DIRECTORY_PATH_KEY, dataDirecotryPath);
        properties.setProperty(ADDITIONAL_DATA_PATH_KEY, additionalDataPathString);
        properties.setProperty(BASE_DATA_PATH_KEY, baseDataPathString);
        properties.setProperty(DATA_ENCODING_KEY, dataEncoding);
        properties.setProperty(DATA_FILE_EXTENSION_KEY, dataFileExtension);
        properties.setProperty(INTERVAL_MINUTES_KEY, intervalMinutes);
        properties.setProperty(REQUEST_LOCATIONS_FILE_PATH_KEY, requestLocationfilePath);
        properties.setProperty(RESOURCE_PROPERTIES_FILE_PATH_KEY, requestPropertiesFilePath);
        properties.setProperty(DATETIME_FORMAT_KEY, datetimeFormat);
        properties.setProperty(DELIMITER_KEY, delimiter);
        
        return new ApplicationParameters(configFilePath, dataDirecotryPath, requestConfigs, additionalDataPathString.replace(",", "\n").split("\n"), baseDataPathString, dataEncoding, dataFileExtension, intervalMinutes, datetimeFormat, delimiter);
    }

    public synchronized void saveParameters() throws IOException {
        
        if(configFile == null) {
            return;
        }
        
        configFile.getParentFile().mkdirs();
        configFile.createNewFile();
        properties.store(new FileOutputStream(configFile), URL_BASE);
    }
}
