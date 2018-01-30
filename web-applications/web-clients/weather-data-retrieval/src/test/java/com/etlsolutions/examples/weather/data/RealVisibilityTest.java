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
 * Test of class RealVisibility.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RealVisibility.class, Logger.class})
public final class RealVisibilityTest {

    private final Logger logger = Mockito.mock(Logger.class);    
    private final RealVisibility instance = RealVisibility.getInstance("2100.0");
 

    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }  
    
    /**
     * Test of class RealVisibility.
     */
    @Test
    public void testGetShortName() {

        assertEquals("Vsblt", instance.getShortName());
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertEquals(RealVisibility.getInstance("2100.0"), instance);
        assertNotSame(RealVisibility.getInstance("2100.0"), instance);
        assertEquals(RealVisibility.getInstance(RealVisibility.UNKNOW_VALUE), RealVisibility.getInstance("afaldfain0"));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Real visibility: 2100", instance.toString());
    }
}
