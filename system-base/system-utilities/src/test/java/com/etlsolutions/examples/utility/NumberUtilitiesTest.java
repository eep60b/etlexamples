/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class NumberUtilitiesTest {
    
    public NumberUtilitiesTest() {
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
     * Test of equals method, of class NumberUtilities.
     */
    @Test
    public void testEquals_3args() {
        System.out.println("equals");
        BigDecimal bigDecimal1 = null;
        BigDecimal bigDecimal2 = null;
        int scale = 0;
        boolean expResult = false;
        boolean result = NumberUtilities.equals(bigDecimal1, bigDecimal2, scale);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class NumberUtilities.
     */
    @Test
    public void testEquals_4args() {
        System.out.println("equals");
        BigDecimal bigDecimal1 = null;
        BigDecimal bigDecimal2 = null;
        int scale = 0;
        RoundingMode roundingMode = null;
        boolean expResult = false;
        boolean result = NumberUtilities.equals(bigDecimal1, bigDecimal2, scale, roundingMode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
