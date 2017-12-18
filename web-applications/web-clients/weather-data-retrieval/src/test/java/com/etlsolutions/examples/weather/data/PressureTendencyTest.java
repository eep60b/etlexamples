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
public class PressureTendencyTest {
    
    public PressureTendencyTest() {
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
     * Test of values method, of class PressureTendency.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        PressureTendency[] expResult = null;
        PressureTendency[] result = PressureTendency.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class PressureTendency.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        PressureTendency expResult = null;
        PressureTendency result = PressureTendency.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class PressureTendency.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        PressureTendency instance = null;
        Integer expResult = null;
        Integer result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPressureTendencyByValue method, of class PressureTendency.
     */
    @Test
    public void testGetPressureTendencyByValue() {
        System.out.println("getPressureTendencyByValue");
        String value = "";
        PressureTendency expResult = null;
        PressureTendency result = PressureTendency.getPressureTendencyByValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPressureTendency method, of class PressureTendency.
     */
    @Test
    public void testGetPressureTendency() {
        System.out.println("getPressureTendency");
        String name = "";
        PressureTendency expResult = null;
        PressureTendency result = PressureTendency.getPressureTendency(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PressureTendency.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PressureTendency instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShortName method, of class PressureTendency.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        PressureTendency instance = null;
        String expResult = "";
        String result = instance.getShortName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
