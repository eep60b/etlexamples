/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.maplist;

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
public class SequenceIdGenerationDefinitionTest {
    
    public SequenceIdGenerationDefinitionTest() {
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
     * Test of getStart method, of class SequenceIdGenerationDefinition.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        SequenceIdGenerationDefinition instance = null;
        int expResult = 0;
        int result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStep method, of class SequenceIdGenerationDefinition.
     */
    @Test
    public void testGetStep() {
        System.out.println("getStep");
        SequenceIdGenerationDefinition instance = null;
        int expResult = 0;
        int result = instance.getStep();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class SequenceIdGenerationDefinition.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        SequenceIdGenerationDefinition instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class SequenceIdGenerationDefinition.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        SequenceIdGenerationDefinition instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class SequenceIdGenerationDefinition.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        SequenceIdGenerationDefinition instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
