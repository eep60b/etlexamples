package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 *
 * @author zc
 */
public final class ApplicationParametersFactory {

    private final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss DD/MM/YYYY");
    
    
    public ApplicationParameters getApplicationParameters(String[] args) throws ParseException, IOException, java.text.ParseException {

        Options options = new Options();
        options.addOption(CONFIG_FILE_PATH_KEY, true, "The config file path");
        options.addOption(DATA_DIRECTORY_PATH_KEY, true, "The data file path");        
        options.addOption(LOCATION_ID_KEY, true, "The location ID"); 
        options.addOption(FORCAST_METHOD_KEY, true, "The forcast method"); 
        options.addOption(USER_TOEKN_KEY, true, "The user token"); 
        options.addOption(START_TIME_KEY, true, "The start time"); 
        options.addOption(STOP_TIME_KEY, true, "The stop time"); 
        
        CommandLineParser parser = new PosixParser();
        CommandLine commandLine = parser.parse(options, args);
        
        String configFilePath = commandLine.getOptionValue(CONFIG_FILE_PATH_KEY);
        String dataDirecotryPath = commandLine.getOptionValue(DATA_DIRECTORY_PATH_KEY);
        String locationId = commandLine.getOptionValue(LOCATION_ID_KEY);
        String forcastMethod = commandLine.getOptionValue(FORCAST_METHOD_KEY);
        String userToken = commandLine.getOptionValue(USER_TOEKN_KEY);
        String startTimeString = commandLine.getOptionValue(START_TIME_KEY);
        String stopTimeString = commandLine.getOptionValue(STOP_TIME_KEY);
        
        Properties properties = new Properties();
        properties.load(new FileInputStream(configFilePath == null ? null : DEFAULT_CONFIG_FILE_PATH));
        
        String savedDataPath = properties.getProperty(DATA_DIRECTORY_PATH_KEY);
        String savedLocationId = properties.getProperty(LOCATION_ID_KEY);
        String savedForcastMethod = properties.getProperty(FORCAST_METHOD_KEY);
        String savedUserToken = properties.getProperty(USER_TOEKN_KEY);
        
        dataDirecotryPath = dataDirecotryPath == null ? (savedDataPath == null ? DEFAULT_DATA_DIRECTORY_PATH : savedDataPath) : dataDirecotryPath;
        locationId = locationId == null ? (savedLocationId == null ? DEFAULT_LOCATION_ID : savedLocationId) : locationId;
        forcastMethod = forcastMethod == null ? (savedForcastMethod == null ? DEFAULT_FORCAST_METHOD : savedForcastMethod) : forcastMethod;
        userToken = userToken == null ? (savedUserToken == null ? DEFAULT_DATA_DIRECTORY_PATH : savedUserToken) : userToken;  
        
        Date currentDate = new Date();
        Date startDate = (startTimeString == null || startTimeString.trim().isEmpty()) ? dateFormat.parse(startTimeString) : currentDate;
        Date stopDate = (stopTimeString == null || stopTimeString.trim().isEmpty()) ? dateFormat.parse(stopTimeString) : new Date(currentDate.getTime() + ONE_DAY_IN_SECOND);
        
        String url = URL_BASE.replace(LOCATION_ID_KEY, locationId).replace(FORCAST_METHOD_KEY, forcastMethod).replace(USER_TOEKN_KEY, userToken);
        return new ApplicationParameters(dataDirecotryPath, url, forcastMethod, startDate, stopDate);
    }
}
