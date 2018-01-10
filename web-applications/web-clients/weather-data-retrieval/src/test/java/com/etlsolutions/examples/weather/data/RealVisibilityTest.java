package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * Test of class RealVisibility.
 *
 * @author zc
 */
public final class RealVisibilityTest {

    private final RealVisibility instance = RealVisibility.getInstance("2100.0");
    
    /**
     * Test of class RealVisibility.
     */
    @Test
    public void testGetShortName() {

        assertEquals("ReVis", instance.getShortName());
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertEquals(RealVisibility.getInstance("2100.0"), instance);
        assertNotSame(RealVisibility.getInstance("2100.0"), instance);
        assertEquals(RealVisibility.UNKNOW_VALUE, RealVisibility.getInstance("afaldfain0"));
    }

    /**
     * Test of toString method, of class RealVisibility.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RealVisibility instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
