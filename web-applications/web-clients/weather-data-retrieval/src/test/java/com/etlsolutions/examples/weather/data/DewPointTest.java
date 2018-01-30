package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableDoubleParser;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class DewPoint.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DewPoint.class, Logger.class})
public final class DewPointTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final DewPoint instance = DewPoint.getInstance("    34.11    ");

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
    public void testGetInstance() {
        
        assertEquals(DewPoint.getInstance("34.11"), instance);
        assertNotSame(DewPoint.getInstance("34.11"), instance);    }
    
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
