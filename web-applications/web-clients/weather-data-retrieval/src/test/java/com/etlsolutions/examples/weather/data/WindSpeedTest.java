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
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({WindSpeed.class, Logger.class})
public final class WindSpeedTest {
    
    private final Logger logger = Mockito.mock(Logger.class);
    
    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }  

    /**
     * Test of getInstance method, of class WindSpeed.
     */
    @Test
    public void testGetInstance_String_String() {
        System.out.println("getInstance");
        String value = "";
        String name = "";
        WindSpeed expResult = null;
        WindSpeed result = WindSpeed.getInstance(value, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class WindSpeed.
     */
    @Test
    public void testGetInstance_String() {
        System.out.println("getInstance");
        String value = "";
        WindSpeed expResult = null;
        WindSpeed result = WindSpeed.getInstance(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShortName method, of class WindSpeed.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        WindSpeed instance = null;
        String expResult = "";
        String result = instance.getShortName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class WindSpeed.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WindSpeed instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
