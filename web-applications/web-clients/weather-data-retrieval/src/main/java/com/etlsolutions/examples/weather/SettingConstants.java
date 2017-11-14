package com.etlsolutions.examples.weather;

import java.io.File;

/**
 *
 * @author zc
 */
public final class SettingConstants {
    
    public static final String CONFIG_FILE_PATH_KEY = "configFilePath";
    
    public static final String DATA_DIRECTORY_PATH_KEY = "dataDirectoryPath";
    
    public static final String LOCATION_ID_KEY = "locationID";
    
    public static final String FORCAST_METHOD_KEY = "forcastMethod";
    
    public static final String USER_TOEKN_KEY = "userToken";

    public static final String START_TIME_KEY = "startTime"; 
    
   /**
    * The time to stop the application. This parameter is only valid for multiple processes.
    */
    public static final String STOP_TIME_KEY = "stopTime";
    
    
    public static final String RUN_MULTIPLE_KEY = "runMultiple";
    
    public static final String STOP_PROCESS_KEY = "stop.process";
    
    
    public static final String APPLICATION_HOME = System.getProperty("user.home") + File.separator + ".weatherDataRetrieval";
    
    public static final String DEFAULT_CONFIG_FILE_PATH = APPLICATION_HOME + File.separator + "props" + File.separator + "config.properties";

    public static final String DEFAULT_DATA_DIRECTORY_PATH = APPLICATION_HOME + File.separator + "data";    
    
    public static final String DEFAULT_LOCATION_ID = "350232";
    
    public static final String DEFAULT_FORCAST_METHOD = "3hourly";
    
    public static final String DEFAULT_USER_TOEKN = "8412a27d-b855-4b0c-8b2d-b8b8f5285ae8";  
    
    public static final String DEFAULT_TIMEZONE = "GMT-0:00";
    
    public static final String DEFAULT_DATETIME_FORMAT = "HH:mm:ss dd/MM/YYYY";
    
    public static final boolean DEFAULT_RUN_MULTIPLE = false;
    
    public static final String URL_BASE = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/xml/locationID?res=forcastMethod&key=userToken";
    
    public static final long ONE_DAY_IN_SECOND = 24 * 3600;
    
    public static final String RUNNING_CONFIG_FILE_PATH = APPLICATION_HOME + File.separator + "props" + File.separator + "running.properties";    
    
    static {
        System.setProperty("metweather.home", APPLICATION_HOME);
    }

    private SettingConstants() {
    }
}
