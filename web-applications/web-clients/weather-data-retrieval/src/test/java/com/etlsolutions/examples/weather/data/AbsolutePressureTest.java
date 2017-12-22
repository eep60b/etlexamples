package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AbsolutePressure.
 *
 * @author zc
 */
public final class AbsolutePressureTest {

    private final String value = "48.28";

    private final AbsolutePressure instance = AbsolutePressure.getInstance(value);


    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
        
        assertTrue(instance.getValue() == 48.28);
    }
    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        
        assertEquals("Pressure: 48.28", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("Press", instance.getShortName());
    }

}
