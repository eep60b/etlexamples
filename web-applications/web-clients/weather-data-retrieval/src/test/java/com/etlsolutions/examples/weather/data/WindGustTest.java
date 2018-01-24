package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableDoubleParser;
import com.etlsolutions.examples.weather.RecoverableIntParser;
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
 * Test of class WindGust.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({WindGust.class, Logger.class})
public final class WindGustTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final WindGust instance1 = WindGust.getInstance("12.4");
    private final WindGust instance2 = WindGust.getInstance(WindSpeed.getInstance("12.4"));    

    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }  
    
    /**
     * Test of constructors.
     */
    @Test
    public void testConstructors() {

        assertTrue(instance1.getValue() == 12.4);
        assertTrue(instance2.getValue() == 12.4);
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {
        assertEquals("WdGst", instance1.getShortName());
    }
}
