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
     * Test of getElevation method.
     */
    @Test
    public void testGetElevation() {

        assertEquals(221.31321, instance.getElevation(), 0.0);
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(new RequestLocation(id, name, latitude, longitude, elevation).hashCode(), instance.hashCode());
        assertNotEquals(new RequestLocation("2231", name, latitude, longitude, elevation).hashCode(), instance.hashCode());    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(new RequestLocation(id, name, latitude, longitude, elevation)));

        assertFalse(instance.equals(new RequestLocation("8862", name, latitude, longitude, elevation)));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("RequestLocation{id=923281,name=inalld}", instance.toString());
    }
}
