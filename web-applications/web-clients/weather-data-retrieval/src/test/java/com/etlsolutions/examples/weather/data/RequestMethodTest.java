package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.RequestMethod.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of enum RequestMethod.
 *
 * @author zc
 */
public final class RequestMethodTest {

    /**
     * Test of values method.
     */
    @Test
    public void testValues() {
        assertArrayEquals(new RequestMethod[]{OBS_HOURLY, FCS_3HOURLY}, RequestMethod.values());
    }

    /**
     * Test of getMethodToken method.
     */
    @Test
    public void testGetMethodToken() {

        assertEquals("wxobs", OBS_HOURLY.getMethodToken());
        assertEquals("wxfcs", FCS_3HOURLY.getMethodToken());
    }

    /**
     * Test of getInterval method.
     */
    @Test
    public void testGetInterval() {

        assertEquals("hourly", OBS_HOURLY.getInterval());
        assertEquals("3hourly", FCS_3HOURLY.getInterval());
    }

    /**
     * Test of getAbbreviation method.
     */
    @Test
    public void testGetAbbreviation() {

        assertEquals("obs1h", OBS_HOURLY.getAbbreviation());
        assertEquals("fcs3h", FCS_3HOURLY.getAbbreviation());
    }

    /**
     * Test of getRequesttMethod method.
     */
    @Test
    public void testGetRequesttMethod() {

        assertEquals(OBS_HOURLY, RequestMethod.getRequesttMethod("wxobs", "hourly"));
        assertEquals(FCS_3HOURLY, RequestMethod.getRequesttMethod("wxfcs", "3hourly"));

        try {
            RequestMethod.getRequesttMethod("wxobs", "3hourly");
        } catch (IllegalArgumentException ex) {
            assertEquals("Unknow forecast method code.", ex.getMessage());
        }
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Hourly observation", OBS_HOURLY.toString());
        assertEquals("3 hourly forecase", FCS_3HOURLY.toString());
    }
}
