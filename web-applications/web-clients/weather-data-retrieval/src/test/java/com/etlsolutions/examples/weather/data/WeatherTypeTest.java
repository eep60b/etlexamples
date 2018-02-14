package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableIntParser;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.omg.CORBA.UNKNOWN;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class WeatherType.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({WeatherType.class, Logger.class, Integer.class})
public final class WeatherTypeTest {

    private final Logger logger = Mockito.mock(Logger.class);

    /**
     * Test of getWeatherType method.
     */
    @Test
    public void testGetWeatherType() {

        assertEquals(WeatherType.DRIZZLE, WeatherType.getWeatherType("11"));
    }
    
    /**
     * Test of getWeatherType method.
     */
    @Test
    public void testGetWeatherType_unknown_value() {
        
        assertEquals(WeatherType.UNKOWN, WeatherType.getWeatherType("12345"));

    }
    
    /**
     * Test of getWeatherType method.
     */
    @Test
    public void testGetWeatherType_exception() {
        
        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(WeatherType.class)).thenReturn(logger);
        
        NumberFormatException ex = Mockito.mock(NumberFormatException.class);

        PowerMockito.mockStatic(Integer.class);
        PowerMockito.doThrow(ex).when(Integer.class);
        Integer.parseInt("11ah");

        assertEquals(WeatherType.UNKOWN, WeatherType.getWeatherType("11ah"));

        Mockito.verify(logger).warn("Unknown weather type value: 11ah", ex);
    }

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertEquals(11, WeatherType.DRIZZLE.getValue(), 0);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("WeatherType: hail shower day", WeatherType.HAIL_SHOWER_DAY.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("WType", WeatherType.CLEAR_NIGHT.getShortName());
    }
}
