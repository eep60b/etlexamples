/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.data;

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
public class RandomWordGeneratorTest {
    
    public RandomWordGeneratorTest() {
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
     * Test of init method, of class RandomWordGenerator.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        RandomWordGenerator instance = new RandomWordGenerator();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWord method, of class RandomWordGenerator.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");
        RandomWordGenerator instance = new RandomWordGenerator();
        String expResult = "";
        String result = instance.getWord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class RandomWordGenerator.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        RandomWordGenerator instance = new RandomWordGenerator();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
