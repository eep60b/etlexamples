package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        options.addOption(LOCATION_ID_KEY, true, "The location ID");
        options.addOption(FORCAST_METHOD_KEY, true, "The forcast method");
        options.addOption(USER_TOEKN_KEY, true, "The user token");
        options.addOption(START_TIME_KEY, true, "The start time");
        options.addOption(STOP_TIME_KEY, true, "The stop time");
        options.addOption(RUN_MULTIPLE_KEY, true, "Whether to run multiple");

        CommandLineParser parser = new PosixParser();
        CommandLine commandLine = parser.parse(options, args);

        String configFilePath = commandLine.getOptionValue(CONFIG_FILE_PATH_KEY);
        String dataDirecotryPath = commandLine.getOptionValue(DATA_DIRECTORY_PATH_KEY);
        String locationId = commandLine.getOptionValue(LOCATION_ID_KEY);
        String forcastMethod = commandLine.getOptionValue(FORCAST_METHOD_KEY);
        String userToken = commandLine.getOptionValue(USER_TOEKN_KEY);
        String startTimeString = commandLine.getOptionValue(START_TIME_KEY);
        String stopTimeString = commandLine.getOptionValue(STOP_TIME_KEY);
        String runMultipleString = commandLine.getOptionValue(RUN_MULTIPLE_KEY);
        
        configFile = new File(configFilePath == null ? DEFAULT_CONFIG_FILE_PATH : configFilePath);
        if (configFile.isFile()) {
            properties.load(new FileInputStream(configFile));
        }
        
        String savedDataPath = properties.getProperty(DATA_DIRECTORY_PATH_KEY);
        String savedLocationId = properties.getProperty(LOCATION_ID_KEY);
        String savedForcastMethod = properties.getProperty(FORCAST_METHOD_KEY);
        String savedUserToken = properties.getProperty(USER_TOEKN_KEY);

        dataDirecotryPath = dataDirecotryPath == null ? (savedDataPath == null ? DEFAULT_DATA_DIRECTORY_PATH : savedDataPath) : dataDirecotryPath;
        locationId = locationId == null ? (savedLocationId == null ? DEFAULT_LOCATION_ID : savedLocationId) : locationId;
        forcastMethod = forcastMethod == null ? (savedForcastMethod == null ? DEFAULT_FORCAST_METHOD : savedForcastMethod) : forcastMethod;
        userToken = userToken == null ? (savedUserToken == null ? DEFAULT_USER_TOEKN : savedUserToken) : userToken;

        Date currentDate = new Date();
        Date startDate = (startTimeString == null || startTimeString.trim().isEmpty()) ?  currentDate : dateFormat.parse(startTimeString);
        Date stopDate = (stopTimeString == null || stopTimeString.trim().isEmpty()) ? new Date(currentDate.getTime() + ONE_DAY_IN_SECOND) : dateFormat.parse(stopTimeString);
        boolean runMultiple = runMultipleString == null ? false : Boolean.parseBoolean(commandLine.getOptionValue(RUN_MULTIPLE_KEY));

        String url = URL_BASE.replace(LOCATION_ID_KEY, locationId).replace(FORCAST_METHOD_KEY, forcastMethod).replace(USER_TOEKN_KEY, userToken);
        
        properties.setProperty(DATA_DIRECTORY_PATH_KEY, dataDirecotryPath);
        properties.setProperty(LOCATION_ID_KEY, locationId);
        properties.setProperty(FORCAST_METHOD_KEY, forcastMethod);
        properties.setProperty(USER_TOEKN_KEY, userToken);
        
        return new ApplicationParameters(dataDirecotryPath, url, forcastMethod, startDate, stopDate, runMultiple);
    }

    public synchronized void saveParameters(ApplicationParameters parameters) throws IOException {
        configFile.getParentFile().mkdirs();
        configFile.createNewFile();
        properties.store(new FileOutputStream(configFile), URL_BASE);
    }
}
