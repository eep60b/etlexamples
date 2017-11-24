package com.etlsolutions.examples.weather;

import java.io.File;

/**
 *
 * @author zc
 */
public final class SettingConstants {

    //The configuration keys:
    public static final String CONFIG_FILE_PATH_KEY = "configFilePath";

    public static final String DATA_DIRECTORY_PATH_KEY = "dataDirectoryPath";

    public static final String START_TIME_KEY = "startTime";

    /**
     * The time to stop the application. This parameter is only valid for
     * multiple processes.
     */
    public static final String STOP_TIME_KEY = "stopTime";

    public static final String RUN_MULTIPLE_KEY = "runMultiple";

    public static final String STOP_PROCESS_KEY = "stop.process";

    public static final String ADDITIONAL_DATA_PATH_KEY = "addtionalDataPath";

    public static final String DATA_ENCODING_KEY = "dataEncoding";

    public static final String DATA_FILE_EXTENSION_KEY = "dataFileEtension";

    public static final String INTERVAL_MINUTES_KEY = "intervalMinutes";

    public static final String REQUEST_LOCATIONS_FILE_PATH_KEY = "requestLocationFilePath";

    public static final String RESOURCE_PROPERTIES_FILE_PATH_KEY = "resourcePropertiesFilePath";
    
    public static final String DATETIME_FORMAT_KEY = "datetimeFormat";
    
    public static final String DELIMITER_KEY = "delimiter";

    public static final String REQUEST_METHOD_TOKEN = "requestMethodToken";

    public static final String LOCATION_TOKEN = "locationID";

    public static final String REQUEST_INTERVAL_TOKEN = "requestIntervalToken";

    public static final String REQUEST_TOEKN = "requestToken";

    public static final String APPLICATION_HOME = System.getProperty("user.home") + File.separator + ".weatherDataRetrieval";

    public static final String DEFAULT_CONFIG_FILE_PATH = APPLICATION_HOME + File.separator + "props" + File.separator + "config.properties";

    public static final String DEFAULT_DATA_DIRECTORY_PATH = System.getProperty("user.home") + File.separator + "Dropbox/Family/Houses/Garden/Environment/Weather/Data";

    public static final String DEFAULT_TIMEZONE = "GMT-0:00";

    /**
     * The default format (MM/dd/YYYY HH:mm:ss) for the data and time. This format is valid for the Igor program.
     * 
     * Example: 22/11/2017 15:00:00
     */
    public static final String DEFAULT_DATETIME_FORMAT = "MM/dd/YYYY HH:mm:ss";
    
    public static final String DEFAULT_DELIMITER = ",";

    public static final String DEFAULT_RUN_MULTIPLE = "true";

    public static final String DEFAULT_ADDITIONAL_DATA_PATH = APPLICATION_HOME + File.separator + "data";

    public static final String DEFAULT_DATA_ENCODING = "ASCII";

    public static final String DEFAULT_DATA_FILE_EXTENSION = ".dat";

    public static final String DEFAULT_INTERVAL_MINUTES = "1";

    public static final String DEFAULT_REQUEST_LOCATIONS_FILE_PATH = DEFAULT_DATA_DIRECTORY_PATH + File.separator + "locations" + File.separator + "request-locations.xml";

    public static final String DEFAULT_STATION_LOCATIONS_FILE_PATH = DEFAULT_DATA_DIRECTORY_PATH + File.separator + "locations" + File.separator + "station-locations.xml";

    public static final String DEFAULT_RESORRCE_PROPERTIES_FILE_PATH = APPLICATION_HOME + File.separator + "props/resources";

    public static final String URL_BASE = "http://datapoint.metoffice.gov.uk/public/data/val/requestMethodToken/all/xml/locationID?res=requestIntervalToken&key=requestToken";

    public static final String DATA_LOGGING_DIRECTORY_PATH = APPLICATION_HOME + File.separator + "data/log";

    public static final String RUNNING_CONFIG_FILE_PATH = APPLICATION_HOME + File.separator + "props" + File.separator + "running.properties";

    public static final String RESOURCES_PROPERTIES_FILE_EXTENSION = ".properties";

    public static final String RUNNING_LOCK_FILE_PATH = APPLICATION_HOME + File.separator + "lock/.wf.lock";

    public static final String EMBEDDED_LOCATIONS_FILE_PATH = "/sources/request-locations.xml";
    
    public static final int MAXIMUM_LOCATION_ID_LENGTH = 6;

    private SettingConstants() {
    }
}
