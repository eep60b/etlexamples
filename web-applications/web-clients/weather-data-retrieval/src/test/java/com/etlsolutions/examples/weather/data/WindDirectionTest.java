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
public class WindDirectionTest {
    
    public WindDirectionTest() {
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
     * Test of values method, of class WindDirection.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        WindDirection[] expResult = null;
        WindDirection[] result = WindDirection.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class WindDirection.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        WindDirection expResult = null;
        WindDirection result = WindDirection.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class WindDirection.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        WindDirection instance = null;
        Integer expResult = null;
        Integer result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWindDirection method, of class WindDirection.
     */
    @Test
    public void testGetWindDirection_int() {
        System.out.println("getWindDirection");
        int value = 0;
        WindDirection expResult = null;
        WindDirection result = WindDirection.getWindDirection(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWindDirection method, of class WindDirection.
     */
    @Test
    public void testGetWindDirection_String() {
        System.out.println("getWindDirection");
        String code = "";
        WindDirection expResult = null;
        WindDirection result = WindDirection.getWindDirection(code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShortName method, of class WindDirection.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        WindDirection instance = null;
        String expResult = "";
        String result = instance.getShortName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
