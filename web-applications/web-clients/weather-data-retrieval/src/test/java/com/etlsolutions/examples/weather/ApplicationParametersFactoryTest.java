package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.URL_BASE;
import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
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

/**
 * Test of class ApplicationParametersFactory.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ApplicationParametersFactory.class, Logger.class, RequestConfigLoader.class, RecoverableIntParser.class})
public final class ApplicationParametersFactoryTest {

    private final Properties properties = Mockito.mock(Properties.class);
    private final File configFile = Mockito.mock(File.class);
    private final Logger logger = Mockito.mock(Logger.class);
    private final RequestConfigLoader requestConfigLoader = PowerMockito.mock(RequestConfigLoader.class);
    @SuppressWarnings("unchecked")
    private final List<RequestConfig> requestConfigs = Mockito.mock(List.class);
    private final ApplicationParameters applicationParameters = new ApplicationParameters("configFilePath", "dataDirectoryPath", requestConfigs,
            new String[]{"addtionalDataPath1\naddtionalDataPath2", "addtionalDataPath3"}, "aaa", "ASKII", "", ".fxt", "mmYYYYHH/ss/dd", "/");

    private final ApplicationParametersFactory instance = ApplicationParametersFactory.getInstance();

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(Properties.class).withNoArguments().thenReturn(properties);

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(ApplicationParametersFactory.class)).thenReturn(logger);
        Mockito.when(Logger.getLogger(RecoverableIntParser.class)).thenReturn(logger);
        
        PowerMockito.whenNew(File.class).withArguments("configFilePath").thenReturn(configFile);

        PowerMockito.mockStatic(RequestConfigLoader.class);
        Mockito.when(RequestConfigLoader.getInstance()).thenReturn(requestConfigLoader);
        Mockito.when(requestConfigLoader.load("resourcePropertiesFilePath", "requestLocationFilePath")).thenReturn(requestConfigs);
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

        String[] args = {"-configFilePath", "configFilePath", "-dataDirectoryPath", "dataDirectoryPath", "-addtionalDataPath", "addtionalDataPath1\naddtionalDataPath2,addtionalDataPath3",
            "-baseDataPath", "aaa", "-dataEncoding", "ASKII", "-dataFileEtension", ".fxt", "-intervalMinutes", "11", "-requestLocationFilePath", "requestLocationFilePath",
            "-resourcePropertiesFilePath", "resourcePropertiesFilePath", "-datetimeFormat", "mmYYYYHH/ss/dd", "-delimiter", "/"};

        assertEquals(applicationParameters, instance.loadApplicationParameters(args));
    }

    /**
     * Test of loadApplicationParameters method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadApplicationParameters_from_properties() throws Exception {

        ApplicationParameters expectedResult = new ApplicationParameters("configFilePath", "dataDirectoryPath", requestConfigs,
                new String[]{"addtionalDataPath1\naddtionalDataPath2", "addtionalDataPath3"}, "aaa", "ASKII", "", ".fxt", "mmYYYYHH/ss/dd", "/");

        assertEquals(expectedResult, instance.loadApplicationParameters(null));
    }

    /**
     * Test of loadApplicationParameters method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadApplicationParameters_default() throws Exception {

        Mockito.when(properties.getProperty("configFilePath")).thenReturn("configFilePath");
        Mockito.when(properties.getProperty("dataDirectoryPath")).thenReturn("dataDirectoryPath");
        Mockito.when(properties.getProperty("addtionalDataPath")).thenReturn("addtionalDataPath1\naddtionalDataPath2,addtionalDataPath3");
        Mockito.when(properties.getProperty("baseDataPath")).thenReturn("aaa");
        Mockito.when(properties.getProperty("dataEncoding")).thenReturn("ASKII");
        Mockito.when(properties.getProperty("dataFileEtension")).thenReturn(".fxt");
        Mockito.when(properties.getProperty("intervalMinutes")).thenReturn("11");
        Mockito.when(properties.getProperty("requestLocationFilePath")).thenReturn("requestLocationFilePath");
        Mockito.when(properties.getProperty("resourcePropertiesFilePath")).thenReturn("resourcePropertiesFilePath");
        Mockito.when(properties.getProperty("datetimeFormat")).thenReturn("mmYYYYHH/ss/dd");
        Mockito.when(properties.getProperty("delimiter")).thenReturn("/");
        
        assertEquals(applicationParameters, instance.loadApplicationParameters(null));
    }

    /**
     * Test of saveParameters method.
     *
     * @throws Exception
     */
    @Test
    public void testSaveParameters() throws Exception {

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


        String[] args = {"-configFilePath", "configFilePath"};
        PowerMockito.whenNew(File.class).withArguments("configFilePath").thenReturn(null);

        instance.loadApplicationParameters(args);

        instance.saveParameters();

        Mockito.verifyZeroInteractions(properties);
    }
}
