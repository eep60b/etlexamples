/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.weather;

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
public class ApplicationParametersFactoryTest {
    
    public ApplicationParametersFactoryTest() {
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
     * Test of getInstance method, of class ApplicationParametersFactory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ApplicationParametersFactory expResult = null;
        ApplicationParametersFactory result = ApplicationParametersFactory.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadApplicationParameters method, of class ApplicationParametersFactory.
     */
    @Test
    public void testLoadApplicationParameters() throws Exception {
        System.out.println("loadApplicationParameters");
        String[] args = null;
        ApplicationParametersFactory instance = null;
        ApplicationParameters expResult = null;
        ApplicationParameters result = instance.loadApplicationParameters(args);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveParameters method, of class ApplicationParametersFactory.
     */
    @Test
    public void testSaveParameters() throws Exception {
        System.out.println("saveParameters");
        ApplicationParameters parameters = null;
        ApplicationParametersFactory instance = null;
        instance.saveParameters(parameters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
