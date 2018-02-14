package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequestToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
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
 * Test of class RequestConfigLoader.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RequestConfigLoader.class, FileInputStream.class, RequestConfig.class, Logger.class, RequestLocationsLoader.class, RequestLocation.class,
    RequestMethod.class, RequestToken.class, EmbeddedInputStreamProvider.class, FileUtils.class})
public final class RequestConfigLoaderTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final String resourcePropertiesFilesPath = "resourcePropertiesFilesPathA";
    private final String requestLocationsPath = "questLocationsPathX";
    private final RequestLocationsLoader requestLocationsLoader = PowerMockito.mock(RequestLocationsLoader.class);
    private final File resourcePropertiesFiles = Mockito.mock(File.class);

    private final Properties properties1 = Mockito.mock(Properties.class);
    private final Properties properties2 = Mockito.mock(Properties.class);
    private final Properties properties3 = Mockito.mock(Properties.class);
    private final FileInputStream fileInputStream1 = Mockito.mock(FileInputStream.class);
    private final FileInputStream fileInputStream2 = Mockito.mock(FileInputStream.class);
    private final FileInputStream fileInputStream3 = Mockito.mock(FileInputStream.class);
    private final File resourcePropertiesFile1 = Mockito.mock(File.class);
    private final File resourcePropertiesFile2 = Mockito.mock(File.class);
    private final File resourcePropertiesFile3 = Mockito.mock(File.class);
    private final File resourcePropertiesFile4 = Mockito.mock(File.class);
    private final RequestLocation requestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation requestLocation2 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation requestLocation3 = PowerMockito.mock(RequestLocation.class);

    private final RequestMethod requesttMethod1 = PowerMockito.mock(RequestMethod.class);
    private final RequestMethod requesttMethod2 = PowerMockito.mock(RequestMethod.class);
    private final RequestMethod requesttMethod3 = PowerMockito.mock(RequestMethod.class);
    private final RequestToken requestToken1 = PowerMockito.mock(RequestToken.class);
    private final RequestToken requestToken2 = PowerMockito.mock(RequestToken.class);
    private final RequestToken requestToken3 = PowerMockito.mock(RequestToken.class);
    private final RequestConfig requestConfig1 = PowerMockito.mock(RequestConfig.class);
    private final RequestConfig requestConfig2 = PowerMockito.mock(RequestConfig.class);
    private final RequestConfig requestConfig3 = PowerMockito.mock(RequestConfig.class);
    private final EmbeddedInputStreamProvider provider = PowerMockito.mock(EmbeddedInputStreamProvider.class);
    private final InputStream directoryInputStream = Mockito.mock(InputStream.class);
    private final InputStreamReader inputStreamReader = Mockito.mock(InputStreamReader.class);
    private final BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
    private final File embeddedDirectory = Mockito.mock(File.class);
    private final File embeddedFile1 = Mockito.mock(File.class);
    private final File embeddedFile2 = Mockito.mock(File.class);
    private final File embeddedFile3 = Mockito.mock(File.class);
    private final File embeddedFile4 = Mockito.mock(File.class);

    private final InputStream inputStream1 = Mockito.mock(InputStream.class);
    private final InputStream inputStream2 = Mockito.mock(InputStream.class);

    private final InOrder inOrder = Mockito.inOrder(logger, properties1, properties2, properties3);

    private final RequestConfigLoader instance = RequestConfigLoader.getInstance();

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RequestConfigLoader.class)).thenReturn(logger);

        PowerMockito.mockStatic(RequestLocationsLoader.class);
        Mockito.when(RequestLocationsLoader.getInstance()).thenReturn(requestLocationsLoader);
        Mockito.when(requestLocationsLoader.load(requestLocationsPath, DEFAULT_REQUEST_LOCATIONS_FILE_PATH, EMBEDDED_REQUEST_LOCATIONS_FILE_PATH)).thenReturn(Arrays.asList(requestLocation1, requestLocation2, requestLocation3));

        Mockito.when(requestLocation1.getId()).thenReturn("44278");
        Mockito.when(requestLocation2.getId()).thenReturn("83462");
        Mockito.when(requestLocation3.getId()).thenReturn("1233");

        PowerMockito.whenNew(File.class).withArguments(resourcePropertiesFilesPath).thenReturn(resourcePropertiesFiles);
        Mockito.when(resourcePropertiesFiles.getAbsolutePath()).thenReturn(resourcePropertiesFilesPath);
        PowerMockito.whenNew(FileInputStream.class).withArguments(resourcePropertiesFiles).thenReturn(fileInputStream1);
        PowerMockito.whenNew(Properties.class).withNoArguments().thenReturn(properties1).thenReturn(properties2).thenReturn(properties3);

        PowerMockito.whenNew(FileInputStream.class).withArguments(resourcePropertiesFile1).thenReturn(fileInputStream1);
        PowerMockito.whenNew(FileInputStream.class).withArguments(resourcePropertiesFile2).thenReturn(fileInputStream2);
        PowerMockito.whenNew(FileInputStream.class).withArguments(resourcePropertiesFile3).thenReturn(fileInputStream3);

        Mockito.when(resourcePropertiesFile1.getName()).thenReturn("afammkk.properties");
        Mockito.when(resourcePropertiesFile2.getName()).thenReturn("fadfkdi.properties");
        Mockito.when(resourcePropertiesFile3.getName()).thenReturn("sfs.properties");
        Mockito.when(resourcePropertiesFile4.getName()).thenReturn("sfs.propert");
        Mockito.when(resourcePropertiesFile1.getAbsolutePath()).thenReturn("paifa/afla/afammkk.properties");
        Mockito.when(resourcePropertiesFile2.getAbsolutePath()).thenReturn("9laf;/fadfkdi.properties");
        Mockito.when(resourcePropertiesFile3.getAbsolutePath()).thenReturn("kai/fkskkk//sfs.properties");

        Mockito.when(properties1.getProperty(LOCATION_TOKEN)).thenReturn("44278");
        Mockito.when(properties2.getProperty(LOCATION_TOKEN)).thenReturn("83462");
        Mockito.when(properties3.getProperty(LOCATION_TOKEN)).thenReturn("1233");

        PowerMockito.mockStatic(RequestMethod.class);
        Mockito.when(properties1.getProperty(REQUEST_METHOD_TOKEN)).thenReturn("fonanda");
        Mockito.when(properties1.getProperty(REQUEST_INTERVAL_TOKEN)).thenReturn("15");
        Mockito.when(RequestMethod.getRequesttMethod("fonanda", "15")).thenReturn(requesttMethod1);
        Mockito.when(properties2.getProperty(REQUEST_METHOD_TOKEN)).thenReturn("ooam1j");
        Mockito.when(properties2.getProperty(REQUEST_INTERVAL_TOKEN)).thenReturn("1");
        Mockito.when(RequestMethod.getRequesttMethod("ooam1j", "1")).thenReturn(requesttMethod2);
        Mockito.when(properties3.getProperty(REQUEST_METHOD_TOKEN)).thenReturn("liado21");
        Mockito.when(properties3.getProperty(REQUEST_INTERVAL_TOKEN)).thenReturn("30");
        Mockito.when(RequestMethod.getRequesttMethod("liado21", "30")).thenReturn(requesttMethod3);

        Mockito.when(properties1.getProperty(REQUEST_TOEKN)).thenReturn("213-14819o-149");
        PowerMockito.whenNew(RequestToken.class).withArguments("213-14819o-149").thenReturn(requestToken1);
        Mockito.when(properties2.getProperty(REQUEST_TOEKN)).thenReturn("97431-14134-44365");
        PowerMockito.whenNew(RequestToken.class).withArguments("97431-14134-44365").thenReturn(requestToken2);
        Mockito.when(properties3.getProperty(REQUEST_TOEKN)).thenReturn("954-789802-4028");
        PowerMockito.whenNew(RequestToken.class).withArguments("954-789802-4028").thenReturn(requestToken3);

        PowerMockito.whenNew(RequestConfig.class).withArguments(requesttMethod1, requestLocation1, requestToken1).thenReturn(requestConfig1);
        PowerMockito.whenNew(RequestConfig.class).withArguments(requesttMethod2, requestLocation2, requestToken2).thenReturn(requestConfig2);
        PowerMockito.whenNew(RequestConfig.class).withArguments(requesttMethod3, requestLocation3, requestToken3).thenReturn(requestConfig3);

        PowerMockito.mockStatic(EmbeddedInputStreamProvider.class);
        Mockito.when(EmbeddedInputStreamProvider.getInstance()).thenReturn(provider);
        Mockito.when(provider.getInputStream(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH)).thenReturn(directoryInputStream);
        PowerMockito.whenNew(InputStreamReader.class).withArguments(directoryInputStream).thenReturn(inputStreamReader);
        PowerMockito.whenNew(BufferedReader.class).withArguments(inputStreamReader).thenReturn(bufferedReader);

        Mockito.when(bufferedReader.readLine()).thenReturn("directory").thenReturn("file1.properties").thenReturn("file2.properties").thenReturn("file3.properties").thenReturn("file3.txt").thenReturn(null);
        PowerMockito.whenNew(File.class).withArguments(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + "directory").thenReturn(embeddedDirectory);
        PowerMockito.whenNew(File.class).withArguments(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + "file1.properties").thenReturn(embeddedFile1);
        PowerMockito.whenNew(File.class).withArguments(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + "file2.properties").thenReturn(embeddedFile2);
        PowerMockito.whenNew(File.class).withArguments(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + "file3.properties").thenReturn(embeddedFile3);
        PowerMockito.whenNew(File.class).withArguments(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + "file3.txt").thenReturn(embeddedFile4);
        Mockito.when(embeddedFile1.isFile()).thenReturn(Boolean.TRUE);
        Mockito.when(embeddedFile2.isFile()).thenReturn(Boolean.TRUE);
        Mockito.when(embeddedFile3.isFile()).thenReturn(Boolean.FALSE);
        Mockito.when(embeddedFile4.isFile()).thenReturn(Boolean.TRUE);
        Mockito.when(provider.getInputStream(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + "file1.properties")).thenReturn(inputStream1);
        Mockito.when(provider.getInputStream(EMBEDDED_REQUEST_CONFIG_DIRECTORY_PATH + "/" + "file2.properties")).thenReturn(inputStream2);
        PowerMockito.whenNew(File.class).withArguments("resourcePropertiesFilesPathA/file1.properties").thenReturn(resourcePropertiesFile1);
        PowerMockito.whenNew(File.class).withArguments("resourcePropertiesFilesPathA/file2.properties").thenReturn(resourcePropertiesFile2);

        PowerMockito.mockStatic(FileUtils.class);
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertSame(RequestConfigLoader.getInstance(), instance);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testLoad() throws Exception {

        Mockito.when(resourcePropertiesFiles.isFile()).thenReturn(Boolean.TRUE);

        List<RequestConfig> result = instance.load(resourcePropertiesFilesPath, requestLocationsPath);

        assertEquals(Arrays.asList(requestConfig1), result);

        inOrder.verify(logger).info("\nTry to load request configurations from resourcePropertiesFilesPathA.");
        inOrder.verify(properties1).load(fileInputStream1);
        inOrder.verify(logger).info("The request configurations have been loaded successfully from resourcePropertiesFilesPathA.");
        inOrder.verify(logger).info("\n1 sets of request configurations have been loaded successfully.");

        //The results should not changable.
        result.remove(0);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_directory() throws Exception {

        Mockito.when(resourcePropertiesFiles.isDirectory()).thenReturn(Boolean.TRUE);
        Mockito.when(resourcePropertiesFiles.listFiles()).thenReturn(new File[]{resourcePropertiesFile1, resourcePropertiesFile2, resourcePropertiesFile3, resourcePropertiesFile4});

        assertEquals(Arrays.asList(requestConfig1, requestConfig2, requestConfig3), instance.load(resourcePropertiesFilesPath, requestLocationsPath));

        inOrder.verify(logger).info("\nTry to load request configurations from paifa/afla/afammkk.properties.");
        inOrder.verify(properties1).load(fileInputStream1);
        inOrder.verify(logger).info("The request configurations have been loaded successfully from paifa/afla/afammkk.properties.");
        inOrder.verify(logger).info("\nTry to load request configurations from 9laf;/fadfkdi.properties.");
        inOrder.verify(properties2).load(fileInputStream2);
        inOrder.verify(logger).info("The request configurations have been loaded successfully from 9laf;/fadfkdi.properties.");
        inOrder.verify(logger).info("\nTry to load request configurations from kai/fkskkk//sfs.properties.");
        inOrder.verify(properties3).load(fileInputStream3);
        inOrder.verify(logger).info("The request configurations have been loaded successfully from kai/fkskkk//sfs.properties.");

        inOrder.verify(logger).info("\n3 sets of request configurations have been loaded successfully.");
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = IOException.class)
    public void testLoad_exception() throws Exception {

        Mockito.when(resourcePropertiesFiles.isDirectory()).thenReturn(Boolean.TRUE);
        Mockito.when(resourcePropertiesFiles.listFiles()).thenReturn(new File[]{});

        assertEquals(Arrays.asList(requestConfig1, requestConfig2, requestConfig3), instance.load(resourcePropertiesFilesPath, requestLocationsPath));

        inOrder.verify(logger).info("\nTry to load request configurations from paifa/afla/afammkk.properties.");
        inOrder.verify(logger).error("There is no valid configuration found.");
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoad_embedded() throws Exception {

        IOException ex = Mockito.mock(IOException.class);

        PowerMockito.doThrow(ex).when(FileUtils.class);
        FileUtils.copyInputStreamToFile(inputStream2, resourcePropertiesFile2);

        assertEquals(Arrays.asList(requestConfig1, requestConfig2), instance.load(resourcePropertiesFilesPath, requestLocationsPath));

        inOrder.verify(logger).warn("\nThe request configuration file path resourcePropertiesFilesPathA does not exist.");
        inOrder.verify(logger).info("Try to find request configuration files from the embedded directory.");
        inOrder.verify(logger).info("Try to load request configurations from the embedded file file1.properties.");
        inOrder.verify(properties1).load(inputStream1);
        inOrder.verify(logger).info("The request configurations has been successfully loaded from the embedded file file1.properties.");
        inOrder.verify(logger).info("The request location file file1.properties has been copied to paifa/afla/afammkk.properties.");

        inOrder.verify(logger).info("Try to load request configurations from the embedded file file2.properties.");
        inOrder.verify(properties2).load(inputStream2);
        inOrder.verify(logger).info("The request configurations has been successfully loaded from the embedded file file2.properties.");
        inOrder.verify(logger).warn("Failed to copy the request location file file2.properties to 9laf;/fadfkdi.properties.", ex);

        PowerMockito.mockStatic(FileUtils.class);
        FileUtils.copyInputStreamToFile(inputStream1, resourcePropertiesFile1);
    }

    /**
     * Test of load method.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testLoad_invalid_ID() throws Exception {

        Mockito.when(properties1.getProperty(LOCATION_TOKEN)).thenReturn("34278");

        instance.load(resourcePropertiesFilesPath, requestLocationsPath);
    }
}
