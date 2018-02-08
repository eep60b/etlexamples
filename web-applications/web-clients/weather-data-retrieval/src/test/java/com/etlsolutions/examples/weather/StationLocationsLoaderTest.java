package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestLocation;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * Test of class StationLocationsLoader.
 *
 * @author zc
 */
public final class StationLocationsLoaderTest {

    
    
    private final StationLocationsLoader instance = new StationLocationsLoader();
    @Before
    public void setUp() {
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {
        
        assertSame(StationLocationsLoader.getInstance(), instance);
    }

    /**
     * Test of load method, of class StationLocationsLoader.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        String path = "";
        
        List<RequestLocation> expResult = null;
        List<RequestLocation> result = instance.load(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
