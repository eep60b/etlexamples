package com.etlsolutions.examples.weather.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class RequestLocation.
 *
 * @author zc
 */
public final class RequestLocationTest {

    private final String id = "923281";
    private final String name = "inalld";
    private final double latitude = 21.92311;
    private final double longitude = -13.91323;
    private final double elevation = 221.31321;

    private final RequestLocation instance = new RequestLocation(id, name, latitude, longitude, elevation);

    @Before
    public void setUp() {
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals("923281", instance.getId());
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {

        assertEquals("inalld", instance.getName());
    }

    /**
     * Test of getLatitude method.
     */
    @Test
    public void testGetLatitude() {
        
        assertEquals(21.92311, instance.getLatitude(), 0.0);
    }

    /**
     * Test of getLongitude method.
     */
    @Test
    public void testGetLongitude() {
        
        assertEquals(-13.91323, instance.getLongitude(), 0.0);
    }

    /**
     * Test of getElevation method, of class RequestLocation.
     */
    @Test
    public void testGetElevation() {
        System.out.println("getElevation");
        RequestLocation instance = null;
        double expResult = 0.0;
        double result = instance.getElevation();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class RequestLocation.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        RequestLocation instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class RequestLocation.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        RequestLocation instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RequestLocation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RequestLocation instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
