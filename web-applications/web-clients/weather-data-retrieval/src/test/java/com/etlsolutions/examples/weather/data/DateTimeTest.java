package com.etlsolutions.examples.weather.data;

import java.util.Date;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class DateTime.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DateTime.class, Logger.class})
public final class DateTimeTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final Date dateTime = new Date(1423819371983L);
    private final DateTime instance = DateTime.getInstance(dateTime);

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(DateTime.class)).thenReturn(logger);
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance_Date() {

        assertEquals(DateTime.getInstance(dateTime), instance);
        assertNotSame(DateTime.getInstance(dateTime), instance);
        assertEquals(new Date(0), DateTime.getInstance(null).getDateTime());
        Mockito.verify(logger).warn(Mockito.eq("Invalid date/time value: null"), Mockito.any(NullPointerException.class));
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance_String_String() {

         assertEquals(DateTime.getInstance("2017-12-28z", "720"), DateTime.getInstance("   2017-12-28Z   ", "720"));
        assertNotSame(DateTime.getInstance("2017-12-28z", "720"), DateTime.getInstance("   2017-12-28Z   ", "720"));       
        assertEquals(new Date(1514462400000L), DateTime.getInstance("   2017-12-28Z   ", "720").getDateTime());
        assertEquals(new Date(0), DateTime.getInstance("2017-12-28a", "720").getDateTime());
        Mockito.verify(logger).warn(Mockito.eq("Invalid date/time value: 2017-12-28a/720"), Mockito.any(NullPointerException.class));
    }

    /**
     * Test of getDateTime method.
     */
    @Test
    public void testGetDateTime() {

        assertEquals(new Date(1423819371983L), instance.getDateTime());
    }

    /**
     * Test of getYear method.
     */
    @Test
    public void testGetYear() {

        assertEquals("2015", instance.getYear());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("DTime", instance.getShortName());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(DateTime.getInstance(dateTime).hashCode(), instance.hashCode());
        assertNotEquals(DateTime.getInstance(new Date(1423819371981L)).hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(DateTime.getInstance(new Date(1423819371983L))));
        assertFalse(instance.equals(DateTime.getInstance(new Date(1423819371981L))));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));       
    }

    /**
     * Test of compareTo method.
     */
    @Test
    public void testCompareTo() {

        assertEquals(dateTime.compareTo(new Date(1514462400000L)), instance.compareTo(DateTime.getInstance("   2017-12-28Z   ", "720")));
        
        Comparable<DateTime> comparable = DateTime.getInstance(dateTime);
        
        assertEquals(dateTime.compareTo(new Date(1514462400000L)), comparable.compareTo(DateTime.getInstance("   2017-12-28Z   ", "720")));        
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Fri Feb 13 09:22:51 GMT 2015", instance.toString());
    }
}
