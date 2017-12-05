package com.etlsolutions.examples.weather;

import java.io.File;

/**
 *
 * @author zc
 */
public final class SettingConstants {

    //The configuration keys:
    
    /**
     * The key to find the configuration file.
     */
    public static final String CONFIG_FILE_PATH_KEY = "configFilePath";

    /**
     * The key to find the data directory.
     */
    public static final String DATA_DIRECTORY_PATH_KEY = "dataDirectoryPath";

    /**
     * The key to find the additional data directories.
     */
    public static final String ADDITIONAL_DATA_PATH_KEY = "addtionalDataPath";

    /**
     * The key to find the data encoding.
     */
    public static final String DATA_ENCODING_KEY = "dataEncoding";

    /**
     * The key to find the data file extension.
     */
    public static final String DATA_FILE_EXTENSION_KEY = "dataFileEtension";

    
    public static final String INTERVAL_MINUTES_KEY = "intervalMinutes";

    public static final String REQUEST_LOCATIONS_FILE_PATH_KEY = "requestLocationFilePath";

    public static final String RESOURCE_PROPERTIES_FILE_PATH_KEY = "resourcePropertiesFilePath";

    public static final String DATETIME_FORMAT_KEY = "datetimeFormat";

    /**
     * The key to find the data delimiter.
     */
    public static final String DELIMITER_KEY = "delimiter";

    public static final String REQUEST_METHOD_TOKEN = "requestMethodToken";

    public static final String LOCATION_TOKEN = "locationID";

    public static final String REQUEST_INTERVAL_TOKEN = "requestIntervalToken";

    public static final String REQUEST_TOEKN = "requestToken";

    //Use the target directory if it exists. The direcory exists only when it is in the develop mode.
    private static final String TARGET_DIRECTORY_NAME = "target";
    public static final String APPLICATION_HOME = new File(TARGET_DIRECTORY_NAME ).isDirectory() ? TARGET_DIRECTORY_NAME : ".";
    
    public static final String DEFAULT_CONFIG_FILE_PATH = APPLICATION_HOME + File.separator + "props" + File.separator + "config.properties";

    public static final String DEFAULT_DATA_DIRECTORY_PATH = APPLICATION_HOME + File.separator + "data";

    public static final String DEFAULT_TIMEZONE = "GMT-0:00";

    /**
     * The default format (MM/dd/yyyy HH:mm:ss) for the data and time. This
     * format is valid for the Igor program.
     *
     * Example: 22/11/2017 15:00:00
     */
    public static final String DEFAULT_DATETIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

    public static final String DEFAULT_DELIMITER = ",";

    public static final String DEFAULT_ADDITIONAL_DATA_PATH = "";

    public static final String DEFAULT_DATA_ENCODING = "ASCII";

    public static final String DEFAULT_DATA_FILE_EXTENSION = ".dat";

    public static final String DEFAULT_INTERVAL_MINUTES = "1";

    public static final String DEFAULT_REQUEST_LOCATIONS_FILE_PATH = DEFAULT_DATA_DIRECTORY_PATH + File.separator + "locations" + File.separator + "request-locations.xml";

    public static final String DEFAULT_STATION_LOCATIONS_FILE_PATH = DEFAULT_DATA_DIRECTORY_PATH + File.separator + "locations" + File.separator + "station-locations.xml";

    public static final String DEFAULT_RESORRCE_PROPERTIES_FILE_PATH = APPLICATION_HOME + File.separator + "props/resources";

    public static final String URL_BASE = "http://datapoint.metoffice.gov.uk/public/data/val/requestMethodToken/all/xml/locationID?res=requestIntervalToken&key=requestToken";

    public static final String RESOURCES_PROPERTIES_FILE_EXTENSION = ".properties";

    public static final String EMBEDDED_LOCATIONS_FILE_PATH = "/data/locations/request-locations.xml";

    public static final String EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH = "/props/resources";

    public static final int MAXIMUM_LOCATION_ID_LENGTH = 6;

    private SettingConstants() {
    }
}
