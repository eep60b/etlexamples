package com.etlsolutions.examples.weather.data;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Test of enum PressureTendency.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PressureTendency.class, Logger.class})
public final class PressureTendencyTest {

    private final Logger logger = Mockito.mock(Logger.class);

    @Before
    public void setUp() {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(PressureTendency.class)).thenReturn(logger);
    }

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
     * Test of getPressureTendencyByValue method.
     */
    @Test
    public void testGetPressureTendencyByValue_unkown_value() {

        assertEquals(PressureTendency.UNKOWN, PressureTendency.getPressureTendencyByValue("10"));

    }

    /**
     * Test of getPressureTendencyByValue method.
     */
    @Test
    public void testGetPressureTendencyByValue_exception() {

        NumberFormatException ex = Mockito.mock(NumberFormatException.class);

        PowerMockito.mockStatic(Integer.class);
        PowerMockito.doThrow(ex).when(Integer.class);
        Integer.parseInt("AAA");

        assertEquals(PressureTendency.UNKOWN, PressureTendency.getPressureTendencyByValue("AAA"));

        Mockito.verify(logger).warn("Unkown Pressure Tendency value: AAA", ex);
    }

    /**
     * Test of getPressureTendency method.
     */
    @Test
    public void testGetPressureTendency() {

        assertEquals(PressureTendency.FR, PressureTendency.getPressureTendency("FR"));
    }

    /**
     * Test of getPressureTendency method.
     */
    @Test
    public void testGetPressureTendency_unknown_value() {

        assertEquals(PressureTendency.UNKOWN, PressureTendency.getPressureTendency("AAAA"));
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
