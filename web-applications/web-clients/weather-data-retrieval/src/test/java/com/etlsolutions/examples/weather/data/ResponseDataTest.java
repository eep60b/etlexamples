package com.etlsolutions.examples.weather.data;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ResponseData.
 *
 * @author zc
 */
public final class ResponseDataTest {

    private final DateTime dateTime = DateTime.getInstance(new Date(193419299791L));
    private final List<Valuable> valuables = Arrays.asList(FeelTemperature.getInstance("29.11"), PressureTendency.RF);

    private final ResponseData instance = new ResponseData(dateTime, valuables);

    /**
     * Test of getDateTime method.
     */
    @Test
    public void testGetDateTime() {

        assertEquals(dateTime, instance.getDateTime());
    }

    /**
     * Test of getOutputString method.
     */
    @Test
    public void testGetOutputString() {

        assertEquals("1976,02,17,15,34,59&29.11&1", instance.getOutputString(new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss"), "&"));
    }

    /**
     * Test of getTitle method.
     */
    @Test
    public void testGetTitle() {

        assertEquals("DTime--1182a£FTemp--1182a£PrTdc--1182a", instance.getTitle("£", "--1182a"));
    }

    /**
     * Test of getValuables method.
     */
    @Test
    public void testGetValuables() {

        assertEquals(valuables, instance.getValuables());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(new ResponseData(dateTime, valuables).hashCode(), instance.hashCode());
        assertNotEquals(new ResponseData(DateTime.getInstance(new Date(193419299793L)), valuables).hashCode(), instance.hashCode());
        assertNotEquals(new ResponseData(dateTime, Arrays.asList(FeelTemperature.getInstance("29.11"), PressureTendency.F)).hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(new ResponseData(dateTime, valuables)));
        assertFalse(instance.equals(new ResponseData(DateTime.getInstance(new Date(193419299793L)), valuables)));
        assertFalse(instance.equals(new ResponseData(dateTime, Arrays.asList(FeelTemperature.getInstance("29.11"), PressureTendency.F))));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }
}
