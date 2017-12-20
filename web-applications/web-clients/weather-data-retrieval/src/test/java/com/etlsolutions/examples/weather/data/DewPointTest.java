package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class DewPoint.
 *
 * @author zc
 */
public final class DewPointTest {

    private final DewPoint instance = new DewPoint("34.11");
    
    /**
     * Test of toString method.
     */
    @Test
    public void testGetValue() {

        assertEquals(34.11, instance.getValue(), 0.0);
    }
    
    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Dew point: 34.11", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("DwPnt", instance.getShortName());
    }

}
