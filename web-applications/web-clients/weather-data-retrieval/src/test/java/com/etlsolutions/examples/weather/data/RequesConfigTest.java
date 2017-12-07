/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RequesConfigTest {
    
    public RequesConfigTest() {
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
     * Test of getRequestMethod method, of class RequesConfig.
     */
    @Test
    public void testGetRequestMethod() {
        System.out.println("getRequestMethod");
        RequesConfig instance = null;
        RequestMethod expResult = null;
        RequestMethod result = instance.getRequestMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestLocation method, of class RequesConfig.
     */
    @Test
    public void testGetRequestLocation() {
        System.out.println("getRequestLocation");
        RequesConfig instance = null;
        RequestLocation expResult = null;
        RequestLocation result = instance.getRequestLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestToken method, of class RequesConfig.
     */
    @Test
    public void testGetRequestToken() {
        System.out.println("getRequestToken");
        RequesConfig instance = null;
        RequestToken expResult = null;
        RequestToken result = instance.getRequestToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class RequesConfig.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        RequesConfig instance = null;
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RequesConfig.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RequesConfig instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
