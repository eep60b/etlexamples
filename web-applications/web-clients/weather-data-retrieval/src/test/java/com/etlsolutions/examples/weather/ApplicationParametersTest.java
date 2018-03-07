package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
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
    private final String[] additionalDataDirectoryPaths = {"inlafdqla", "     ", "  afafa.txt", null};
    private final String baseDataDirectoryPath = "bbsasdatalnad99aa233";
    private final String dataEncoding = "ASCII";
    private final String dataFileExtension = ".dat";
    private final String intervalInMinutes = "30";
    private final String datetimeFormat = "yyyy-MM/dd HH:mm:ss";
    private final String delimiter = "_";
    private final String ftpsServerName = "myFtisSer";
    private final String ftpsUsername = "yyneyy";
    private final String ftpsPassword = "papidaopp";
    private final String ftpsRemoteSourceDiretory = "/ttppsp/tt";
    private final String ftpsLocalTargetDirectory = "  /ff/ fmyllooa;";

    private ApplicationParameters instance;

    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableIntParser.class)).thenReturn(logger);
        File configFile = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("onaofdoa").thenReturn(configFile);
        Mockito.when(configFile.getAbsolutePath()).thenReturn("/home/onaofdoa");

        File cfile = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("nowcFilePath").thenReturn(cfile);

        File dataDirectory = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments(dataDirectoryPath).thenReturn(dataDirectory);
        Mockito.when(dataDirectory.getAbsolutePath()).thenReturn("data/datadir/aaa");

        File dfile = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("newdataDirePath").thenReturn(dfile);

        File additionalFile1 = Mockito.mock(File.class);
        File additionalFile2 = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("inlafdqla").thenReturn(additionalFile1);
        PowerMockito.whenNew(File.class).withArguments("afafa.txt").thenReturn(additionalFile2);
        Mockito.when(additionalFile1.getAbsolutePath()).thenReturn("/temp/aaax/inlafdql.dat");
        Mockito.when(additionalFile2.getAbsolutePath()).thenReturn("home/afafa.txt");

        File a1file = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("21121").thenReturn(a1file);
        File a2file = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments(",diiald").thenReturn(a2file);

        File baseDataDirectory = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments(baseDataDirectoryPath).thenReturn(baseDataDirectory);
        Mockito.when(baseDataDirectory.getAbsolutePath()).thenReturn("onedrive/aaa/lnad99aa233");

        File bfile = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("newAbDataDirectoryh").thenReturn(bfile);

        File lfile = Mockito.mock(File.class);
        PowerMockito.whenNew(File.class).withArguments("/ff/ fmyllooa;").thenReturn(lfile);
        Mockito.when(lfile.getAbsolutePath()).thenReturn("pfiaoon/fflff/ff");

        instance = new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath,
                dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory);
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

        assertEquals(Arrays.asList("/temp/aaax/inlafdql.dat", "home/afafa.txt"), instance.getAdditionalDataDirectoryPaths());
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
        assertEquals("", new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, "       ",
                dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).getBaseDataDirectoryPath());
        assertEquals("", new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, null, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).getBaseDataDirectoryPath());
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

        assertEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());

        assertNotEquals(new ApplicationParameters("nowcFilePath", dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, "newdataDirePath", requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, Arrays.asList(PowerMockito.mock(RequestConfig.class)), additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, new String[]{"21121", ",diiald"}, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, "newAbDataDirectoryh", dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, "UTF-16", dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, "abc", intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, "8", datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, "HH:MM yyyy.mm.DD", delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
        assertNotEquals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, "/", ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory).hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        
        assertTrue(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, 
                baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, 
                ftpsPassword, ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));

        assertFalse(instance.equals(new ApplicationParameters("nowcFilePath", dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, "newdataDirePath", requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, Arrays.asList(PowerMockito.mock(RequestConfig.class)), additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, new String[]{"21121", ",diiald"}, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, "newAbDataDirectoryh", dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, "UTF-16", dataFileExtension, intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, "abc", intervalInMinutes, datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, "8", datetimeFormat, delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, "HH:MM yyyy.mm.DD", delimiter, ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
        assertFalse(instance.equals(new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, baseDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, "/", ftpsServerName, ftpsUsername, ftpsPassword,
                ftpsRemoteSourceDiretory, ftpsLocalTargetDirectory)));
        
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
                + "Addtional data directory = [/temp/aaax/inlafdql.dat, home/afafa.txt]\n"
                + "Base data directory =      onedrive/aaa/lnad99aa233\n"
                + "Data encoding  =           ASCII\n"
                + "Data file extension  =     .dat\n"
                + "Interval in minutes  =     30\n"
                + "Date time format =         yyyy-MM/dd HH:mm:ss\n"
                + "Delimiter =                [_]", instance.toString());
    }

    /**
     * Test of getFtpsServerName method, of class ApplicationParameters.
     */
    @Test
    public void testGetFtpsServerName() {
        System.out.println("getFtpsServerName");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getFtpsServerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFtpsServerUsername method, of class ApplicationParameters.
     */
    @Test
    public void testGetFtpsServerUsername() {
        System.out.println("getFtpsServerUsername");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getFtpsServerUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFtpsServerPassword method, of class ApplicationParameters.
     */
    @Test
    public void testGetFtpsServerPassword() {
        System.out.println("getFtpsServerPassword");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getFtpsServerPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFtpsRemoteSourceDirectory method, of class
     * ApplicationParameters.
     */
    @Test
    public void testGetFtpsRemoteSourceDirectory() {
        System.out.println("getFtpsRemoteSourceDirectory");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getFtpsRemoteSourceDirectory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFtpsLocalTargetDirecotry method, of class
     * ApplicationParameters.
     */
    @Test
    public void testGetFtpsLocalTargetDirecotry() {
        System.out.println("getFtpsLocalTargetDirecotry");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getFtpsLocalTargetDirecotry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
