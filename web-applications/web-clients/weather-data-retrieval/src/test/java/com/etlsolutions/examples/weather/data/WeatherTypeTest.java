package com.etlsolutions.examples.weather.data;

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
public class WeatherTypeTest {
    
    public WeatherTypeTest() {
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
     * Test of values method, of class WeatherType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        WeatherType[] expResult = null;
        WeatherType[] result = WeatherType.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class WeatherType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        WeatherType expResult = null;
        WeatherType result = WeatherType.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class WeatherType.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        WeatherType instance = null;
        int expResult = 0;
        int result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeatherType method, of class WeatherType.
     */
    @Test
    public void testGetWeatherType() {
        System.out.println("getWeatherType");
        String value = "";
        WeatherType expResult = null;
        WeatherType result = WeatherType.getWeatherType(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeatherTypeByCode method, of class WeatherType.
     */
    @Test
    public void testGetWeatherTypeByCode() {
        System.out.println("getWeatherTypeByCode");
        String code = "";
        WeatherType expResult = null;
        WeatherType result = WeatherType.getWeatherTypeByCode(code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

        assertEquals("", WeatherType.HAIL_SHOWER_DAY.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("WType", WeatherType.CLEAR_NIGHT.getShortName());
    }
    
}
