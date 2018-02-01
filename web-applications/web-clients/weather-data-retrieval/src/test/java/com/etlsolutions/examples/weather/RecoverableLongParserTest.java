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
 * Test of class RecoverableLongParser.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RecoverableLongParser.class, Logger.class})
public final class RecoverableLongParserTest {

    private final Logger logger = Mockito.mock(Logger.class);

    private final RecoverableLongParser instance = RecoverableLongParser.getInstance();

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

        assertSame(RecoverableLongParser.getInstance(), instance);
    }

    /**
     * Test of parseNumber method.
     */
    @Test
    public void testParseNumber() {

        assertEquals(18563L, instance.parseNumber("18563"), 0);
    }
}
