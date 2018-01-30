package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableDoubleParser;
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
 * Test of class WindSpeed.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({WindSpeed.class, Logger.class})
public final class WindSpeedTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final WindSpeed instance1 = WindSpeed.getInstance("75.5", "Wind speed");
    private final WindSpeed instance2 = WindSpeed.getInstance("75.5");
    
    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance_String_String() {

        assertEquals(WindSpeed.getInstance("75.5", "Wind speed"), instance1);
        assertNotSame(WindSpeed.getInstance("75.5", "Wind speed"), instance1);
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance_String() {

        assertEquals(WindSpeed.getInstance("75.5"), instance2);
        assertNotSame(WindSpeed.getInstance("75.5"), instance2);
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("WnSpd", instance1.getShortName());
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        
        assertEquals("Wind speed: 75.5", instance1.toString());
    }
}
