package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class ApplicationParameters.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ApplicationParameters.class, RequestConfig.class, Logger.class})
public final class ApplicationParametersTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final String configFilePath = "onaofdoa";
    private final String dataDirectoryPath = "lnad99aa233";
    private final List<RequestConfig> requestConfigs = Arrays.asList(PowerMockito.mock(RequestConfig.class), PowerMockito.mock(RequestConfig.class));
    private final String[] additionalDataDirectoryPaths = {"inlafdqla", "     ", "afafa.txt", null};
    private final String baseDataDirectoryPath = "lnad99aa233";
    private final String dataEncoding = "ASCII";
    private final String dataFileExtension = ".dat";
    private final String intervalInMinutes = "30";
    private final String datetimeFormat = "yyyy-MM/dd HH:mm:ss";
    private final String delimiter = "_";

    private final ApplicationParameters instance = new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter);

    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
        File configFile = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("onaofdoa").thenReturn(configFile);
        Mockito.when(configFile.getAbsolutePath()).thenReturn("/home/onaofdoa");

        File dataDirectory = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments(dataDirectoryPath).thenReturn(dataDirectory);
        Mockito.when(dataDirectory.getAbsolutePath()).thenReturn("data/datadir/aaa");
        
        File additionalFile1 = Mockito.mock(File.class);
        File additionalFile2 = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("inlafdqla").thenReturn(additionalFile1);
        PowerMockito.whenNew(File.class).withArguments("afafa.txt").thenReturn(additionalFile2);
        Mockito.when(additionalFile1.getAbsolutePath()).thenReturn("/temp/aaax/inlafdql.dat");
        Mockito.when(additionalFile2.getAbsolutePath()).thenReturn("home/afafa.txt");

        File baseDataDirectory = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments(baseDataDirectoryPath).thenReturn(baseDataDirectory);
        Mockito.when(baseDataDirectory.getAbsolutePath()).thenReturn("onedrive/aaa/lnad99aa233");
    }

    /**
     * Test of getConfigFilePath method.
     */
    @Test
    public void testGetConfigFilePath() {

        assertEquals("/home/onaofdoa", instance.getConfigFilePath());
    }

    /**
     * Test of getDataDirectoryPath method.
     */
    @Test
    public void testGetDataDirectoryPath() {

        assertEquals("data/datadir/aaa", instance.getDataDirectoryPath());
    }

    /**
     * Test of getRequestConfigs method.
     */
    @Test
    public void testGetRequestConfigs() {

        assertEquals(requestConfigs, instance.getRequestConfigs());
    }

    /**
     * Test of getAddtionalDataPaths method.
     */
    @Test
    public void testGetAddtionalDataPaths() {

        assertEquals(Arrays.asList("inlafdqla", "linn232", "afafa.txt"), instance.getAdditionalDataDirectoryPaths());
    }

    /**
     * Test of getDataEncoding method.
     */
    @Test
    public void testGetDataEncoding() {

        assertEquals("ASCII", instance.getDataEncoding());
    }

    /**
     * Test of getDataFileExtension method.
     */
    @Test
    public void testGetDataFileExtension() {
        assertEquals(".dat", instance.getDataFileExtension());

    }

    /**
     * Test of getDatetimeFormat method.
     */
    @Test
    public void testGetDatetimeFormat() {

        assertEquals(new SimpleDateFormat(datetimeFormat), instance.getDatetimeFormat());
    }

    /**
     * Test of getDelimiter method.
     */
    @Test
    public void testGetDelimiter() {

        assertEquals("_", instance.getDelimiter());
    }

    /**
     * Test of getAdditionalDataDirectoryPaths method.
     */
    @Test
    public void testGetAdditionalDataDirectoryPaths() {

        assertEquals(Arrays.asList("/temp/aaax/inlafdql.dat", "home/afafa.txt"), instance.getAdditionalDataDirectoryPaths());
    }

    /**
     * Test of getBaseDataDirectoryPath method.
     */
    @Test
    public void testGetBaseDataDirectoryPath() {

        assertEquals("onedrive/aaa/lnad99aa233", instance.getBaseDataDirectoryPath());
        assertEquals("", new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, "       ", dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).getBaseDataDirectoryPath());
        assertEquals("", new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, null, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).getBaseDataDirectoryPath());
    }

    /**
     * Test of getIntervalInMinutes method.
     */
    @Test
    public void testGetIntervalInMinutes() {

        assertEquals(30, instance.getIntervalInMinutes());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());

        assertNotEquals(new ApplicationParameters("nowcFilePath", dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, "newdataDirePath", requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, Arrays.asList(PowerMockito.mock(RequestConfig.class)), additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, new String[]{"21121", ",diiald"}, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, "newAbDataDirectoryh", dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, "UTF-16", dataFileExtension, intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, "abc", intervalInMinutes, datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, "8", datetimeFormat, delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, "HH:MM yyyy.mm.DD", delimiter).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, "/").hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter)));

        assertFalse(instance.equals(new ApplicationParameters("nowcFilePath", dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, "newdataDirePath", requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, Arrays.asList(PowerMockito.mock(RequestConfig.class)), additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, new String[]{"21121", ",diiald"}, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, "newAbDataDirectoryh", dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, "UTF-16", dataFileExtension, intervalInMinutes, datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, "abc", intervalInMinutes, datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, "8", datetimeFormat, delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, "HH:MM yyyy.mm.DD", delimiter)));
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, "/")));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));        
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Configuration file =       /home/onaofdoa\n"
                + "Request configs =          " + requestConfigs + "\n"
                + "Data file directory =      data/datadir/aaa\n"
                + "Addtional data directory = [/temp/aaax/inlafdql.dat,home/afafa.txt]\n"
                + "Base data directory =      onedrive/aaa/lnad99aa233\n"
                + "Data encoding  =           ASCII\n"
                + "Data file extension  =     .dat\n"
                + "Interval in minutes  =     30\n"
                + "Date time format =         yyyy-MM/dd HH:mm:ss\n"
                + "Delimiter =                [_]"
                , instance.toString());
    }
}
