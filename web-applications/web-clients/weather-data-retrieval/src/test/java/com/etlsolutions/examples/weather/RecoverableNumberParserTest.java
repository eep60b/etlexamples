package com.etlsolutions.examples.weather;

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
 * Test of class RecoverableNumberParser.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RecoverableNumberParser.class, Logger.class, NumberFormatException.class})
public final class RecoverableNumberParserTest {

    
    private final Logger logger = Mockito.mock(Logger.class);
    private final RecoverableNumberParser<Integer> instance = new RecoverableNumberParserImpl();
    
    //Keep the logger mock to prevent the logger from printing to the output log.
    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableNumberParserImpl.class)).thenReturn(logger);
    }  

    /**
     * Test of parseNumber method.
     */
    @Test
    public void testParseNumber_3args() {
        
        assertTrue(instance.parseNumber("12", "59", "My value") == 12);
    }


    /**
     * Test of parseNumber method.
     */
    @Test
    public void testParseNumber_3args_exception() {

        
        assertTrue(instance.parseNumber("12H", "59", "My value") == 59);
        
        Mockito.verify(logger).warn(Mockito.anyString(), Mockito.any(NumberFormatException.class));
    }    
    
    private static class RecoverableNumberParserImpl extends RecoverableNumberParser<Integer> {

        @Override
        public Integer parseNumber(String value) {
            return Integer.parseInt(value);
        }
    }
}
