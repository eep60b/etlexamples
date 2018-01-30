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
 * Test of class RecoverableDoubleParser provides a parser to parse a string to
 * a integer number. If the operation fails, Error will be logged as warning
 * information instead of an exception being thrown out.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RecoverableDoubleParser.class, Logger.class})
public final class RecoverableDoubleParserTest {

    private final Logger logger = Mockito.mock(Logger.class);

    private final RecoverableDoubleParser instance = RecoverableDoubleParser.getInstance();

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

        assertEquals(RecoverableDoubleParser.getInstance(), instance);
    }

    /**
     * Test of parseNumber method.
     */
    @Test
    public void testParseNumber() {

        assertEquals(24.33, instance.parseNumber("24.33"), 0.0);
    }
}
