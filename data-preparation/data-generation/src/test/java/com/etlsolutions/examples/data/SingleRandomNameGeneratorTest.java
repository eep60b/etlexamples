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
public class SingleRandomNameGeneratorTest {
    
    public SingleRandomNameGeneratorTest() {
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
     * Test of refresh method, of class SingleRandomNameGenerator.
     */
    @Test
    public void testRefresh() throws Exception {
        System.out.println("refresh");
        SingleRandomNameGenerator instance = null;
        instance.refresh();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compose method, of class SingleRandomNameGenerator.
     */
    @Test
    public void testCompose() {
        System.out.println("compose");
        int syls = 0;
        SingleRandomNameGenerator instance = null;
        String expResult = "";
        String result = instance.compose(syls);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
