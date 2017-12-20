package com.etlsolutions.examples.weather.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public final class RealVisibilityTest {
    

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getShortName method, of class RealVisibility.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        RealVisibility instance = null;
        String expResult = "";
        String result = instance.getShortName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
