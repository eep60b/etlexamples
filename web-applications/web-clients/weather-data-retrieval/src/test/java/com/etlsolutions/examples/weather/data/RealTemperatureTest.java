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
 * Test of class RealTemperature.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RealTemperature.class, Logger.class})
public final class RealTemperatureTest {

    private final Logger logger = Mockito.mock(Logger.class);

    private final RealTemperature instance = RealTemperature.getInstance("10.9");
    
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

        assertEquals(RealTemperature.getInstance("10.9"), instance);
        assertNotSame(RealTemperature.getInstance("10.9"), instance);
    }    
    
    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Real temperature 10.9", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("Tempt", instance.getShortName());
    }

}
