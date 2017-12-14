package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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
@PrepareForTest({ApplicationParameters.class, RequestConfig.class})
public final class ApplicationParametersTest {

    private final String configFilePath = "onaofdoa";
    private final String dataDirectoryPath = "lnad99aa233";
    private final List<RequestConfig> requestConfigs = Arrays.asList(PowerMockito.mock(RequestConfig.class), PowerMockito.mock(RequestConfig.class));
    private final String[] additionalDataDirectoryPaths = {"inlafdqla", "linn232", "afafa.txt"};
    private final String dataEncoding = "ASCII";
    private final String dataFileExtension = ".dat";
    private final String intervalInMinutes = "30";
    private final String datetimeFormat = "yyyy-MM/dd HH:mm:ss";
    private final String delimiter = "_";

    private final ApplicationParameters instance = new ApplicationParameters(configFilePath, dataDirectoryPath, requestConfigs, additionalDataDirectoryPaths, dataEncoding, dataFileExtension, intervalInMinutes, datetimeFormat, delimiter);

    @Before
    public void setUp() throws Exception {
        
        File configFile = Mockito.mock(File.class); 
        PowerMockito.whenNew(File.class).withArguments("onaofdoa").thenReturn(configFile);
        Mockito.when(configFile.getAbsolutePath()).thenReturn("/home/onaofdoa");
        
        
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
     * Test of getIntervalMiliSeconds method.
     */
    @Test
    public void testGetIntervalMiliSeconds() {
        
        assertEquals(1800000, instance.getIntervalMiliSeconds());
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
}
