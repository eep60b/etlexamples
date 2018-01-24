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

        assertEquals("ReVis", instance.getShortName());
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertEquals(RealVisibility.getInstance("2100.0"), instance);
        assertNotSame(RealVisibility.getInstance("2100.0"), instance);
        assertEquals(RealVisibility.UNKNOW_VALUE, RealVisibility.getInstance("afaldfain0"));
    }

    /**
     * Test of toString method, of class RealVisibility.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RealVisibility instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
