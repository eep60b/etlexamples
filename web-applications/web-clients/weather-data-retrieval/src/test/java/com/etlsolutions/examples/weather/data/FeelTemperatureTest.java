package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class FeelTemperature.
 *
 * @author zc
 */
public final class FeelTemperatureTest {

    private final FeelTemperature instance = FeelTemperature.getInstance("73.82");

    /**
     * Test of toString method, of class FeelTemperature.
     */
    @Test
    public void testGetValue() {
        assertEquals(73.82, instance.getValue(), 0.0);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("FeelTemperature: 73.82", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("FTemp", instance.getShortName());
    }
}
