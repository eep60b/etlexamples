package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class UvIndex.
 *
 * @author zc
 */
public final class UvIndexTest {

    private final UvIndex instance = UvIndex.getInstance("94");

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
        assertTrue(instance.getValue() == 94);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("UV Index: 94", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("UvIdx", instance.getShortName());
    }
}
