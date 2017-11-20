package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

/**
 *
 * @author zc
 */
public final class ApplicationParametersFactory {

    private static final ApplicationParametersFactory INSTANCE = new ApplicationParametersFactory();

    private final Properties properties = new Properties();
    private final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss DD/MM/YYYY");
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
        options.addOption(START_TIME_KEY, true, "The start time");
        options.addOption(STOP_TIME_KEY, true, "The stop time");
        options.addOption(RUN_MULTIPLE_KEY, true, "Whether to run multiple");
        options.addOption(ADDITIONAL_DATA_PATH_KEY, true, "The additional data paths.");
        options.addOption(DATA_ENCODING_KEY, true, "The data encoding method.");
        options.addOption(DATA_FILE_PREFIX_KEY, true, "The data file prefix.");
        options.addOption(DATA_FILE_EXTENSION_KEY, true, "The data file extension.");
        options.addOption(INTERVAL_MINUTES_KEY, true, "The interval in minutes to retrieval data.");
        options.addOption(REQUEST_LOCATIONS_FILE_PATH_KEY, true, "The path where the location file to be loaded.");
        options.addOption(RESOURCE_PROPERTIES_FILE_PATH_KEY, true, "The path where the resource properties files to be loaded.");
        
        CommandLineParser parser = new PosixParser();
        CommandLine commandLine = parser.parse(options, args);

        String configFilePath = commandLine.getOptionValue(CONFIG_FILE_PATH_KEY);
        String dataDirecotryPath = commandLine.getOptionValue(DATA_DIRECTORY_PATH_KEY);
        String startTimeString = commandLine.getOptionValue(START_TIME_KEY);
        String stopTimeString = commandLine.getOptionValue(STOP_TIME_KEY);
        String runMultipleString = commandLine.getOptionValue(RUN_MULTIPLE_KEY);
        String additionalDataPathString = commandLine.getOptionValue(ADDITIONAL_DATA_PATH_KEY);
        String dataEncoding = commandLine.getOptionValue(DATA_ENCODING_KEY);
        String dataFilePrefix = commandLine.getOptionValue(DATA_FILE_PREFIX_KEY);
        String dataFileExtension = commandLine.getOptionValue(DATA_FILE_EXTENSION_KEY);
        String intervalMinutes = commandLine.getOptionValue(INTERVAL_MINUTES_KEY);
        String requestLocationfilePath = commandLine.getOptionValue(REQUEST_LOCATIONS_FILE_PATH_KEY);
        String requestPropertiesFilePath = commandLine.getOptionValue(RESOURCE_PROPERTIES_FILE_PATH_KEY);
        

        configFile = new File(configFilePath == null ? DEFAULT_CONFIG_FILE_PATH : configFilePath);
        if (configFile.isFile()) {
            properties.load(new FileInputStream(configFile));
        }

        String savedDataPath = properties.getProperty(DATA_DIRECTORY_PATH_KEY);
        String savedRunMultiple = properties.getProperty(RUN_MULTIPLE_KEY);
        String savedAdditionalDataPathString = properties.getProperty(ADDITIONAL_DATA_PATH_KEY);
        String savedDataEncoding = properties.getProperty(DATA_ENCODING_KEY);
        String savedDataFilePrefix = properties.getProperty(DATA_FILE_PREFIX_KEY);
        String savedDataFileExtension = properties.getProperty(DATA_FILE_EXTENSION_KEY);
        String savedIntervalMinutes = properties.getProperty(INTERVAL_MINUTES_KEY);
        String savedRequestLocationfilePath =  properties.getProperty(REQUEST_LOCATIONS_FILE_PATH_KEY);
        String savedRequestPropertiesFilePath =  properties.getProperty(RESOURCE_PROPERTIES_FILE_PATH_KEY);
        
        dataDirecotryPath = dataDirecotryPath == null ? (savedDataPath == null ? DEFAULT_DATA_DIRECTORY_PATH : savedDataPath) : dataDirecotryPath;

        Date currentDate = new Date();
        Date startDate = (startTimeString == null || startTimeString.trim().isEmpty()) ? currentDate : dateFormat.parse(startTimeString);
        Date stopDate = (stopTimeString == null || stopTimeString.trim().isEmpty()) ? null : dateFormat.parse(stopTimeString);

        runMultipleString = runMultipleString == null ? (savedRunMultiple == null ? DEFAULT_RUN_MULTIPLE : savedRunMultiple) : commandLine.getOptionValue(RUN_MULTIPLE_KEY);
        additionalDataPathString = additionalDataPathString == null ? (savedAdditionalDataPathString == null ? DEFAULT_ADDITIONAL_DATA_PATH : savedAdditionalDataPathString) : additionalDataPathString;
        dataEncoding = dataEncoding == null ? (savedDataEncoding == null ? DEFAULT_DATA_ENCODING : savedDataEncoding) : dataEncoding;
        dataFilePrefix = dataFilePrefix == null ? (savedDataFilePrefix == null ? DEFAULT_DATA_FILE_PREFIX : savedDataFilePrefix) : dataFilePrefix;
        dataFileExtension = dataFileExtension == null ? (savedDataFileExtension == null ? DEFAULT_DATA_FILE_EXTENSION : savedDataFileExtension) : dataFileExtension;
        intervalMinutes = intervalMinutes == null ? (savedIntervalMinutes == null ? DEFAULT_INTERVAL_MINUTES : savedIntervalMinutes) : intervalMinutes;
        requestLocationfilePath = requestLocationfilePath == null ? (savedRequestLocationfilePath == null ? DEFAULT_ADDITIONAL_DATA_PATH : savedRequestLocationfilePath) : requestLocationfilePath;
        requestPropertiesFilePath = requestPropertiesFilePath == null ? (savedRequestPropertiesFilePath == null ? DEFAULT_RESORRCE_PROPERTIES_FILE_PATH : savedRequestPropertiesFilePath) : requestPropertiesFilePath;
        List<RequestSource> requestSources = RequestSourceLoader.getInstance().load(requestPropertiesFilePath, requestLocationfilePath);
    
        properties.setProperty(DATA_DIRECTORY_PATH_KEY, dataDirecotryPath);
        properties.setProperty(RUN_MULTIPLE_KEY, runMultipleString);
        properties.setProperty(ADDITIONAL_DATA_PATH_KEY, additionalDataPathString);
        properties.setProperty(DATA_ENCODING_KEY, dataEncoding);
        properties.setProperty(DATA_FILE_PREFIX_KEY, dataFilePrefix);
        properties.setProperty(DATA_FILE_EXTENSION_KEY, dataFileExtension);
        properties.setProperty(INTERVAL_MINUTES_KEY, intervalMinutes);
        properties.setProperty(REQUEST_LOCATIONS_FILE_PATH_KEY, requestLocationfilePath);
        properties.setProperty(RESOURCE_PROPERTIES_FILE_PATH_KEY, requestPropertiesFilePath);
        
        return new ApplicationParameters(dataDirecotryPath, requestSources, startDate, stopDate, Boolean.parseBoolean(runMultipleString), additionalDataPathString.split("\n"), dataEncoding, dataFileExtension, intervalMinutes);
    }

    public synchronized void saveParameters(ApplicationParameters parameters) throws IOException {
        configFile.getParentFile().mkdirs();
        configFile.createNewFile();
        properties.store(new FileOutputStream(configFile), URL_BASE);
    }
}
