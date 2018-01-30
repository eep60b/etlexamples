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
 * Test of AbstractDoubleValuable class.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AbstractDoubleValuable.class, Logger.class})
public final class AbstractDoubleValuableTest {

    private final Logger logger = Mockito.mock(Logger.class);

    private AbstractDoubleValuable instance1;
    private AbstractDoubleValuable instance2;

    @Before
    public void setUp() {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(RecoverableDoubleParser.class)).thenReturn(logger);
        instance1 = new AbstractDoubleValuable("334.2", "Dmm") {

            @Override
            public String getShortName() {
                return "thissho";
            }
        };

        instance2 = new AbstractDoubleValuable("334.2H", "Dmm") {

            @Override
            public String getShortName() {
                return "thissho";
            }
        };
    }

    @Test
    public void testGetValue() {
        assertEquals(334.2, instance1.getValue(), 0);
    }

    @Test
    public void testGetValue_Unknown() {
        assertEquals(-100, instance2.getValue(), 0);
    }
}
