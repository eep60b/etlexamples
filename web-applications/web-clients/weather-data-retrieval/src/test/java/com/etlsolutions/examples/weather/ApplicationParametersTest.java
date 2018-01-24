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
    private final String[] additionalDataDirectoryPaths = {"inlafdqla", "linn232", "afafa.txt"};
    private final String basDataDirectoryPath = "lnad99aa233";
    private final String dataEncoding = "ASCII";
    private final String dataFileExtension = ".dat";
    private final String intervalInMinutes = "30";
    private final String datetimeFormat = "yyyy-MM/dd HH:mm:ss";
    private final String delimiter = "_";

    private final ApplicationParameters instance = new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, basDataDirectoryPath, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter);

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
        File configFile = Mockito.mock(File.class); 
        PowerMockito.whenNew(File.class).withArguments("onaofdoa").thenReturn(configFile);
        Mockito.when(configFile.getAbsolutePath()).thenReturn("/home/onaofdoa");
        
        
    }

    @After
    public void tearDown() throws Exception {
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

        assertEquals("lnad99aa233", instance.getDataDirectoryPath());
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
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("", instance.toString());
    }

    /**
     * Test of getAdditionalDataDirectoryPaths method, of class ApplicationParameters.
     */
    @Test
    public void testGetAdditionalDataDirectoryPaths() {
        System.out.println("getAdditionalDataDirectoryPaths");
        ApplicationParameters instance = null;
        List<String> expResult = null;
        List<String> result = instance.getAdditionalDataDirectoryPaths();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntervalInMinutes method, of class ApplicationParameters.
     */
    @Test
    public void testGetIntervalInMinutes() {
        System.out.println("getIntervalInMinutes");
        ApplicationParameters instance = null;
        int expResult = 0;
        int result = instance.getIntervalInMinutes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ApplicationParameters.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ApplicationParameters instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ApplicationParameters.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ApplicationParameters instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseDataDirectoryPath method, of class ApplicationParameters.
     */
    @Test
    public void testGetBaseDataDirectoryPath() {
        System.out.println("getBaseDataDirectoryPath");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getBaseDataDirectoryPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
