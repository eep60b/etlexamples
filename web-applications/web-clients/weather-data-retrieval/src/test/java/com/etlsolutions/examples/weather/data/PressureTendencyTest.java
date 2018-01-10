package com.etlsolutions.examples.weather.data;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of enum PressureTendency.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PressureTendency.class, Logger.class})
public final class PressureTendencyTest {

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertTrue(PressureTendency.R.getValue() == 2);
    }

    /**
     * Test of getPressureTendencyByValue method.
     */
    @Test
    public void testGetPressureTendencyByValue() {

        assertEquals(PressureTendency.S, PressureTendency.getPressureTendencyByValue("0"));
    }

    /**
     * Test of getPressureTendency method.
     */
    @Test
    public void testGetPressureTendency() {

        assertEquals(PressureTendency.FR, PressureTendency.getPressureTendency("FR"));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("PressureTendency: steady", PressureTendency.S.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("PrTdc", PressureTendency.FR.getShortName());
    }
}
