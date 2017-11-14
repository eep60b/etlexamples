/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.base.log;

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
public class SystemLoggerTest {
    
    public SystemLoggerTest() {
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
     * Test of error method, of class SystemLogger.
     */
    @Test
    public void testError_3args() {
        System.out.println("error");
        Class sourceClass = null;
        String message = "";
        Throwable t = null;
        SystemLogger.error(sourceClass, message, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of error method, of class SystemLogger.
     */
    @Test
    public void testError_Class_String() {
        System.out.println("error");
        Class sourceClass = null;
        String message = "";
        SystemLogger.error(sourceClass, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of info method, of class SystemLogger.
     */
    @Test
    public void testInfo_3args() {
        System.out.println("info");
        Class sourceClass = null;
        String message = "";
        Throwable t = null;
        SystemLogger.info(sourceClass, message, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of info method, of class SystemLogger.
     */
    @Test
    public void testInfo_Class_String() {
        System.out.println("info");
        Class sourceClass = null;
        String message = "";
        SystemLogger.info(sourceClass, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of warn method, of class SystemLogger.
     */
    @Test
    public void testWarn_3args() {
        System.out.println("warn");
        Class sourceClass = null;
        String message = "";
        Throwable t = null;
        SystemLogger.warn(sourceClass, message, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of warn method, of class SystemLogger.
     */
    @Test
    public void testWarn_Class_String() {
        System.out.println("warn");
        Class sourceClass = null;
        String message = "";
        SystemLogger.warn(sourceClass, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fatal method, of class SystemLogger.
     */
    @Test
    public void testFatal_3args() {
        System.out.println("fatal");
        Class sourceClass = null;
        String message = "";
        Throwable t = null;
        SystemLogger.fatal(sourceClass, message, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fatal method, of class SystemLogger.
     */
    @Test
    public void testFatal_Class_String() {
        System.out.println("fatal");
        Class sourceClass = null;
        String message = "";
        SystemLogger.fatal(sourceClass, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
