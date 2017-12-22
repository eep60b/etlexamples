package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class WindGust.
 *
 * @author zc
 */
public final class WindGustTest {

    private final WindGust instance1 = WindGust.getInstance("12.4");
    private final WindGust instance2 = WindGust.getInstance(WindSpeed.getInstance("12.4"));    
    /**
     * Test of constructors.
     */
    @Test
    public void testConstructors() {

        assertTrue(instance1.getValue() == 12.4);
        assertTrue(instance2.getValue() == 12.4);
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {
        assertEquals("WdGst", instance1.getShortName());
    }
}
