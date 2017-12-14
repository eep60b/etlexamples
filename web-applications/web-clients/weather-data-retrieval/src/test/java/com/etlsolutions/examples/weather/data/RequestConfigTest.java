package com.etlsolutions.examples.weather.data;

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
public final class RequestConfigTest {
    
    public RequestConfigTest() {
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
     * Test of getRequestMethod method, of class RequestConfig.
     */
    @Test
    public void testGetRequestMethod() {
        System.out.println("getRequestMethod");
        RequestConfig instance = null;
        RequestMethod expResult = null;
        RequestMethod result = instance.getRequestMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestLocation method, of class RequestConfig.
     */
    @Test
    public void testGetRequestLocation() {
        System.out.println("getRequestLocation");
        RequestConfig instance = null;
        RequestLocation expResult = null;
        RequestLocation result = instance.getRequestLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestToken method, of class RequestConfig.
     */
    @Test
    public void testGetRequestToken() {
        System.out.println("getRequestToken");
        RequestConfig instance = null;
        RequestToken expResult = null;
        RequestToken result = instance.getRequestToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class RequestConfig.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        RequestConfig instance = null;
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RequestConfig.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RequestConfig instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
