/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequesConfig;
import java.text.DateFormat;
import java.util.Date;
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
public class ApplicationParametersTest {
    
    public ApplicationParametersTest() {
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
     * Test of getConfigFilePath method, of class ApplicationParameters.
     */
    @Test
    public void testGetConfigFilePath() {
        System.out.println("getConfigFilePath");
        ApplicationParameters instance = null;
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
     * Test of getStartTime method, of class ApplicationParameters.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        ApplicationParameters instance = null;
        Date expResult = null;
        Date result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStopTime method, of class ApplicationParameters.
     */
    @Test
    public void testGetStopTime() {
        System.out.println("getStopTime");
        ApplicationParameters instance = null;
        Date expResult = null;
        Date result = instance.getStopTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRunMultiple method, of class ApplicationParameters.
     */
    @Test
    public void testIsRunMultiple() {
        System.out.println("isRunMultiple");
        ApplicationParameters instance = null;
        boolean expResult = false;
        boolean result = instance.isRunMultiple();
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
        List<String> result = instance.getAddtionalDataPaths();
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
