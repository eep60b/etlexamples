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
 * Test of class RelativeHumidity.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RelativeHumidity.class, Logger.class})
public final class RelativeHumidityTest {

    private final Logger logger = Mockito.mock(Logger.class);

    private final RelativeHumidity instance = RelativeHumidity.getInstance("100");
    

    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }  
    
    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("Humid", instance.getShortName());
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {
        
        assertEquals(RelativeHumidity.getInstance("100"), instance);
        assertEquals(RelativeHumidity.getInstance(RelativeHumidity.UNKNOW_VALUE), RelativeHumidity.getInstance("aaa"));
              
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Relative humidity: 100.0", instance.toString());
    }
}
