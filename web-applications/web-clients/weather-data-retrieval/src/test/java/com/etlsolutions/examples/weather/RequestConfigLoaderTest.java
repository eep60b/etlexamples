package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestConfig;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class RequestConfigLoader.
 *
 * @author zc
 */
public final class RequestConfigLoaderTest {

    private final RequestConfigLoader instance = RequestConfigLoader.getInstance();

    @Before
    public void setUp() {
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
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        String resourcePropertiesFilesPath = "";
        String requestLocationsPath = "";
        List<RequestConfig> expResult = null;
        List<RequestConfig> result = instance.load(resourcePropertiesFilesPath, requestLocationsPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
