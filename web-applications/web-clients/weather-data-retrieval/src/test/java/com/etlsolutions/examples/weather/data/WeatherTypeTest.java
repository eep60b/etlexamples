package com.etlsolutions.examples.weather.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
     * Test of getValue method, of class WeatherType.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        WeatherType instance = null;
        Integer expResult = null;
        Integer result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
