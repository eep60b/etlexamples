package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of enum PressureTendency.
 *
 * @author zc
 */
public final class PressureTendencyTest {

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertTrue(PressureTendency.R.getValue() == 2);
    }

    /**
     * Test of getPressureTendencyByValue method.
     */
    @Test
    public void testGetPressureTendencyByValue() {

        assertEquals(PressureTendency.S, PressureTendency.getPressureTendencyByValue("0"));
    }

    /**
     * Test of getPressureTendency method.
     */
    @Test
    public void testGetPressureTendency() {

        assertEquals(PressureTendency.FR, PressureTendency.getPressureTendency("falling then rising"));
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
