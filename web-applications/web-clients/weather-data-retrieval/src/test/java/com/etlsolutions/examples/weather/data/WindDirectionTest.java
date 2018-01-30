package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of enum WindDirection.
 *
 * @author zc
 */
public final class WindDirectionTest {

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertTrue(WindDirection.ESE.getValue() == 1125);
    }

    /**
     * Test of getWindDirection method.
     */
    @Test
    public void testGetWindDirection() {

        assertTrue(WindDirection.getWindDirection(1350) == WindDirection.SE);
        assertTrue(WindDirection.getWindDirection(1345) == WindDirection.UNKOWN);
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("WdDrc", WindDirection.NE.getShortName());
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Wind direction: SSW", WindDirection.SSW.toString());
    }
}
