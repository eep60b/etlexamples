package com.etlsolutions.examples.weather.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class WeatherType.
 *
 * @author zc
 */
public final class WeatherTypeTest {

    @Before
    public void setUp() {
    }

    /**
     * Test of getWeatherType method.
     */
    @Test
    public void testGetWeatherType() {

        assertEquals(WeatherType.DRIZZLE, WeatherType.getWeatherType("11"));
    }

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertEquals(11, WeatherType.DRIZZLE.getValue(), 0);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("WeatherType: hail shower day", WeatherType.HAIL_SHOWER_DAY.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("WType", WeatherType.CLEAR_NIGHT.getShortName());
    }
}
