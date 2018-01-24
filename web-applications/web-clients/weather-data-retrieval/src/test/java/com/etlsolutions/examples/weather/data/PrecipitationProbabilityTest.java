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
 * Test  of class PrecipitationProbability.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PrecipitationProbability.class, Logger.class})
public final class PrecipitationProbabilityTest {

    private final Logger logger = Mockito.mock(Logger.class);    
    private final PrecipitationProbability instance = PrecipitationProbability.getInstance("56.37");
    

    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
    }      
    
    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
        
        assertEquals(56.37, instance.getValue(), 0.0);
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("PrecipitationProbability: 56.73", instance.toString());
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("PpPrb", instance.getShortName());
    }
}
