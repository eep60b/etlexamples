package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test  of class PrecipitationProbability.
 *
 * @author zc
 */
public final class PrecipitationProbabilityTest {

    private final PrecipitationProbability instance = PrecipitationProbability.getInstance("56.37");
    
    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
        
        assertEquals(56.37, instance.getValue(), 0.0);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Precipitation Probability: 56.73", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("P", instance.getShortName());
    }
}
