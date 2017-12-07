package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequesConfig;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class ApplicationParameters.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ApplicationParameters.class, RequesConfig.class})
public final class ApplicationParametersTest {

    private final String configFilePath = "onaofdoa";
    private final String dataDirectoryPath = "lnad99aa233";
    private final List<RequesConfig> requestConfigs = Arrays.asList(PowerMockito.mock(RequesConfig.class), PowerMockito.mock(RequesConfig.class));
    private final String[] additionalDataDirectoryPaths = {"inlafdqla", "linn232", "afafa.txt"};
    private final String dataEncoding = "ASCII";
    private final String dataFileExtension = ".dat";
    private final String intervalInMinutes = "30";
    private final String datetimeFormat = "yyyy-MM/dd HH:mm:ss";
    private final String delimiter = "_";

    private final ApplicationParameters instance = new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter);

    @Before
    public void setUp() {
    }

    @Test
    public void testGetConfigFilePath() {

        String expResult = "";
        String result = instance.getConfigFilePath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataDirectoryPath method, of class ApplicationParameters.
     */
    @Test
    public void testGetDataDirectoryPath() {
        System.out.println("getDataDirectoryPath");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getDataDirectoryPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestConfigs method, of class ApplicationParameters.
     */
    @Test
    public void testGetRequestConfigs() {
        System.out.println("getRequestConfigs");
        ApplicationParameters instance = null;
        List<RequesConfig> expResult = null;
        List<RequesConfig> result = instance.getRequestConfigs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddtionalDataPaths method, of class ApplicationParameters.
     */
    @Test
    public void testGetAddtionalDataPaths() {
        System.out.println("getAddtionalDataPaths");
        ApplicationParameters instance = null;
        List<String> expResult = null;
        List<String> result = instance.getAdditionalDataDirectoryPaths();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataEncoding method, of class ApplicationParameters.
     */
    @Test
    public void testGetDataEncoding() {
        System.out.println("getDataEncoding");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getDataEncoding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataFileExtension method, of class ApplicationParameters.
     */
    @Test
    public void testGetDataFileExtension() {
        System.out.println("getDataFileExtension");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getDataFileExtension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntervalMiliSeconds method, of class ApplicationParameters.
     */
    @Test
    public void testGetIntervalMiliSeconds() {
        System.out.println("getIntervalMiliSeconds");
        ApplicationParameters instance = null;
        long expResult = 0L;
        long result = instance.getIntervalMiliSeconds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatetimeFormat method, of class ApplicationParameters.
     */
    @Test
    public void testGetDatetimeFormat() {
        System.out.println("getDatetimeFormat");
        ApplicationParameters instance = null;
        DateFormat expResult = null;
        DateFormat result = instance.getDatetimeFormat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDelimiter method, of class ApplicationParameters.
     */
    @Test
    public void testGetDelimiter() {
        System.out.println("getDelimiter");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.getDelimiter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ApplicationParameters.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ApplicationParameters instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
