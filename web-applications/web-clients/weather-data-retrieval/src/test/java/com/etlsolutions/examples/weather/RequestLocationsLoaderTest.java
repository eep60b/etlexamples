/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author zc
 */
public class RequestLocationsLoaderTest {
    
    public RequestLocationsLoaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class RequestLocationsLoader.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        RequestLocationsLoader expResult = null;
        RequestLocationsLoader result = RequestLocationsLoader.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class RequestLocationsLoader.
     */
    @Test
    public void testLoad() throws Exception {
        System.out.println("load");
        String path = "";
        RequestLocationsLoader instance = new RequestLocationsLoader();
        List<RequestLocation> expResult = null;
        List<RequestLocation> result = instance.load(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
