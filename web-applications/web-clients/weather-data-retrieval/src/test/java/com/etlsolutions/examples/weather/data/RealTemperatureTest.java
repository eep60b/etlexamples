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

    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }

    /**
     * Test of toString method, of class RealTemperature.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RealTemperature instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShortName method, of class RealTemperature.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        RealTemperature instance = null;
        String expResult = "";
        String result = instance.getShortName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class RealTemperature.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        String value = "";
        RealTemperature expResult = null;
        RealTemperature result = RealTemperature.getInstance(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
