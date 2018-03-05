package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Test of class ApplicationParametersFactory.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ApplicationParametersFactory.class, Logger.class, RequestConfigLoader.class, RecoverableIntParser.class, ApplicationParameters.class})
public final class ApplicationParametersFactoryTest {

    private final Properties properties = Mockito.mock(Properties.class);
    private final File configFile = Mockito.mock(File.class);
    private final FileInputStream fileInputStream = Mockito.mock(FileInputStream.class);
    private final Logger logger = Mockito.mock(Logger.class);
    private final RequestConfigLoader requestConfigLoader = PowerMockito.mock(RequestConfigLoader.class);
    @SuppressWarnings("unchecked")
    private final List<RequestConfig> requestConfigs = Mockito.mock(List.class);
    private final ApplicationParameters applicationParameters = PowerMockito.mock(ApplicationParameters.class);

    private final Properties defaultProperties = Mockito.mock(Properties.class);
    private final File defaultConfigFile = Mockito.mock(File.class);
    private final FileInputStream defaultFileInputStream = Mockito.mock(FileInputStream.class);
    @SuppressWarnings("unchecked")
    private final List<RequestConfig> defRequestConfigs = Mockito.mock(List.class);
    private final ApplicationParameters defaultApplicationParameters = PowerMockito.mock(ApplicationParameters.class);

        @SuppressWarnings("unchecked")
    private final List<RequestConfig> embeddedRequestConfigs = Mockito.mock(List.class);
    private final ApplicationParameters embeddedApplicationParameters = PowerMockito.mock(ApplicationParameters.class);

    private final ApplicationParametersFactory instance = ApplicationParametersFactory.getInstance();

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(ApplicationParametersFactory.class)).thenReturn(logger);
        Mockito.when(Logger.getLogger(RecoverableIntParser.class)).thenReturn(logger);

        PowerMockito.whenNew(File.class).withArguments("configFilePath").thenReturn(configFile);
        PowerMockito.whenNew(FileInputStream.class).withArguments(configFile).thenReturn(fileInputStream);

        PowerMockito.mockStatic(RequestConfigLoader.class);
        Mockito.when(RequestConfigLoader.getInstance()).thenReturn(requestConfigLoader);
        Mockito.when(requestConfigLoader.load("resourcePropertiesFilePath", "requestLocationFilePath")).thenReturn(requestConfigs);

        PowerMockito.whenNew(ApplicationParameters.class).withArguments("configFilePath", "dataDirectoryPath", requestConfigs,
                new String[]{"addtionalDataPath1", "addtionalDataPath2", "addtionalDataPath3"}, "aaa", "ASKII", ".fxt", "11", "mmYYYYHH/ss/dd", "/").thenReturn(applicationParameters);

        PowerMockito.whenNew(File.class).withArguments(DEFAULT_CONFIG_FILE_PATH).thenReturn(defaultConfigFile);
        PowerMockito.whenNew(FileInputStream.class).withArguments(defaultConfigFile).thenReturn(defaultFileInputStream);
        Mockito.when(requestConfigLoader.load("defresourcePropertiesFilePath", "defrequestLocationFilePath")).thenReturn(defRequestConfigs);

        PowerMockito.whenNew(ApplicationParameters.class).withArguments(DEFAULT_CONFIG_FILE_PATH, "defdataDirectoryPath", defRequestConfigs,
                new String[]{"defaddtionalDataPath1", "defaddtionalDataPath2", "defaddtionalDataPath3"}, "defaaa", "ASKKK", ".dat", "30", "mm-YYYY-HH ss/dd", "#").thenReturn(defaultApplicationParameters);

        
        Mockito.when(requestConfigLoader.load(DEFAULT_RESORUCE_PROPERTIES_FILE_PATH, DEFAULT_REQUEST_LOCATIONS_FILE_PATH)).thenReturn(embeddedRequestConfigs);        
        PowerMockito.whenNew(ApplicationParameters.class).withArguments(DEFAULT_CONFIG_FILE_PATH, DEFAULT_DATA_DIRECTORY_PATH, embeddedRequestConfigs,
                new String[]{""}, DEFAULT_BASE_DATA_PATH, DEFAULT_DATA_ENCODING, DEFAULT_DATA_FILE_EXTENSION, DEFAULT_INTERVAL_MINUTES, DEFAULT_DATETIME_FORMAT, DEFAULT_DELIMITER).thenReturn(embeddedApplicationParameters);        
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertSame(ApplicationParametersFactory.getInstance(), instance);
    }

    /**
     * Test of loadApplicationParameters method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadApplicationParameters() throws Exception {

        InOrder inOrder = Mockito.inOrder(properties, logger);
        Whitebox.setInternalState(instance, "properties", properties);
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        String[] args = {"-configFilePath", "configFilePath", "-dataDirectoryPath", "dataDirectoryPath", "-additionalDataPath", "addtionalDataPath1\naddtionalDataPath2,addtionalDataPath3",
            "-baseDataPath", "aaa", "-dataEncoding", "ASKII", "-dataFileEtension", ".fxt", "-intervalMinutes", "11", "-requestLocationFilePath", "requestLocationFilePath",
            "-resourcePropertiesFilePath", "resourcePropertiesFilePath", "-datetimeFormat", "mmYYYYHH/ss/dd", "-delimiter", "/"};

        assertEquals(applicationParameters, instance.loadApplicationParameters(args));

        inOrder.verify(logger).info("\nTry to load the configuration parameters from configFilePath.");
        inOrder.verify(properties).load(fileInputStream);
        inOrder.verify(logger).info("The configuration parameters have been successfully loaded.");
        inOrder.verify(properties).clear();
        inOrder.verify(properties).setProperty(DATA_DIRECTORY_PATH_KEY, "dataDirectoryPath");
        inOrder.verify(properties).setProperty(ADDITIONAL_DATA_PATH_KEY, "addtionalDataPath1\naddtionalDataPath2,addtionalDataPath3");
        inOrder.verify(properties).setProperty(BASE_DATA_PATH_KEY, "aaa");
        inOrder.verify(properties).setProperty(DATA_ENCODING_KEY, "ASKII");
        inOrder.verify(properties).setProperty(DATA_FILE_EXTENSION_KEY, ".fxt");
        inOrder.verify(properties).setProperty(INTERVAL_MINUTES_KEY, "11");
        inOrder.verify(properties).setProperty(REQUEST_LOCATIONS_FILE_PATH_KEY, "requestLocationFilePath");
        inOrder.verify(properties).setProperty(RESOURCE_PROPERTIES_FILE_PATH_KEY, "resourcePropertiesFilePath");
        inOrder.verify(properties).setProperty(DATETIME_FORMAT_KEY, "mmYYYYHH/ss/dd");
        inOrder.verify(properties).setProperty(DELIMITER_KEY, "/");
    }

    /**
     * Test of loadApplicationParameters method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadApplicationParameters_default() throws Exception {

        InOrder inOrder = Mockito.inOrder(defaultConfigFile, defaultProperties, logger);
        Whitebox.setInternalState(instance, "properties", defaultProperties);
        Mockito.when(defaultConfigFile.isFile()).thenReturn(Boolean.TRUE);
        
        Mockito.when(defaultProperties.getProperty("dataDirectoryPath")).thenReturn("defdataDirectoryPath");
        Mockito.when(defaultProperties.getProperty("additionalDataPath")).thenReturn("defaddtionalDataPath1\ndefaddtionalDataPath2,defaddtionalDataPath3");
        Mockito.when(defaultProperties.getProperty("baseDataPath")).thenReturn("defaaa");
        Mockito.when(defaultProperties.getProperty("dataEncoding")).thenReturn("ASKKK");
        Mockito.when(defaultProperties.getProperty("dataFileEtension")).thenReturn(".dat");
        Mockito.when(defaultProperties.getProperty("intervalMinutes")).thenReturn("30");
        Mockito.when(defaultProperties.getProperty("requestLocationFilePath")).thenReturn("defrequestLocationFilePath");
        Mockito.when(defaultProperties.getProperty("resourcePropertiesFilePath")).thenReturn("defresourcePropertiesFilePath");
        Mockito.when(defaultProperties.getProperty("datetimeFormat")).thenReturn("mm-YYYY-HH ss/dd");
        Mockito.when(defaultProperties.getProperty("delimiter")).thenReturn("#");

        assertEquals(defaultApplicationParameters, instance.loadApplicationParameters(null));

        inOrder.verify(logger).info("\nTry to load the configuration parameters from " + DEFAULT_CONFIG_FILE_PATH + ".");
        inOrder.verify(defaultProperties).load(defaultFileInputStream);
        inOrder.verify(logger).info("The configuration parameters have been successfully loaded.");
        inOrder.verify(defaultProperties).clear();
        inOrder.verify(defaultProperties).setProperty(DATA_DIRECTORY_PATH_KEY, "defdataDirectoryPath");
        inOrder.verify(defaultProperties).setProperty(ADDITIONAL_DATA_PATH_KEY, "defaddtionalDataPath1\ndefaddtionalDataPath2,defaddtionalDataPath3");
        inOrder.verify(defaultProperties).setProperty(BASE_DATA_PATH_KEY, "defaaa");
        inOrder.verify(defaultProperties).setProperty(DATA_ENCODING_KEY, "ASKKK");
        inOrder.verify(defaultProperties).setProperty(DATA_FILE_EXTENSION_KEY, ".dat");
        inOrder.verify(defaultProperties).setProperty(INTERVAL_MINUTES_KEY, "30");
        inOrder.verify(defaultProperties).setProperty(REQUEST_LOCATIONS_FILE_PATH_KEY, "defrequestLocationFilePath");
        inOrder.verify(defaultProperties).setProperty(RESOURCE_PROPERTIES_FILE_PATH_KEY, "defresourcePropertiesFilePath");
        inOrder.verify(defaultProperties).setProperty(DATETIME_FORMAT_KEY, "mm-YYYY-HH ss/dd");
        inOrder.verify(defaultProperties).setProperty(DELIMITER_KEY, "#");
    }

    /**
     * Test of loadApplicationParameters method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadApplicationParameters_embedded() throws Exception {

        InOrder inOrder = Mockito.inOrder(properties, logger);
        Whitebox.setInternalState(instance, "properties", properties);

        assertEquals(embeddedApplicationParameters, instance.loadApplicationParameters(null));

        inOrder.verify(logger).warn("\nNo configuration file can be found. Use the embedded parameters.");
        inOrder.verify(properties).clear();
        inOrder.verify(properties).setProperty(DATA_DIRECTORY_PATH_KEY, DEFAULT_DATA_DIRECTORY_PATH);
        inOrder.verify(properties).setProperty(ADDITIONAL_DATA_PATH_KEY, DEFAULT_ADDITIONAL_DATA_PATH);
        inOrder.verify(properties).setProperty(BASE_DATA_PATH_KEY, DEFAULT_BASE_DATA_PATH);
        inOrder.verify(properties).setProperty(DATA_ENCODING_KEY, DEFAULT_DATA_ENCODING);
        inOrder.verify(properties).setProperty(DATA_FILE_EXTENSION_KEY, DEFAULT_DATA_FILE_EXTENSION);
        inOrder.verify(properties).setProperty(INTERVAL_MINUTES_KEY, DEFAULT_INTERVAL_MINUTES);
        inOrder.verify(properties).setProperty(REQUEST_LOCATIONS_FILE_PATH_KEY, DEFAULT_REQUEST_LOCATIONS_FILE_PATH);
        inOrder.verify(properties).setProperty(RESOURCE_PROPERTIES_FILE_PATH_KEY, DEFAULT_RESORUCE_PROPERTIES_FILE_PATH);
        inOrder.verify(properties).setProperty(DATETIME_FORMAT_KEY, DEFAULT_DATETIME_FORMAT);
        inOrder.verify(properties).setProperty(DELIMITER_KEY, DEFAULT_DELIMITER);

        Mockito.verify(properties, Mockito.never()).load(Mockito.any(FileInputStream.class));
    }

    /**
     * Test of saveParameters method.
     *
     * @throws Exception
     */
    @Test
    public void testSaveParameters() throws Exception {

        Whitebox.setInternalState(instance, "properties", properties);

        File parentFile = Mockito.mock(File.class);
        Mockito.when(configFile.getParentFile()).thenReturn(parentFile);
        FileOutputStream outputStream = Mockito.mock(FileOutputStream.class);
        PowerMockito.whenNew(FileOutputStream.class).withArguments(configFile).thenReturn(outputStream);
        String[] args = {"-configFilePath", "configFilePath"};

        InOrder inOrder = Mockito.inOrder(parentFile, configFile, properties);

        instance.loadApplicationParameters(args);

        instance.saveParameters();

        inOrder.verify(parentFile).mkdirs();
        inOrder.verify(configFile).createNewFile();
        inOrder.verify(properties).store(outputStream, "Met Weather Service");
    }

    /**
     * Test of saveParameters method.
     *
     * @throws Exception
     */
    @Test
    public void testSaveParameters_nullConfigFile() throws Exception {

        Whitebox.setInternalState(instance, "properties", properties);
        String[] args = {"-configFilePath", "configFilePath"};
        PowerMockito.whenNew(File.class).withArguments("configFilePath").thenReturn(null);

        instance.loadApplicationParameters(args);

        instance.saveParameters();

        Mockito.verify(properties, Mockito.never()).store(Mockito.any(FileOutputStream.class), Mockito.anyString());
    }
}
