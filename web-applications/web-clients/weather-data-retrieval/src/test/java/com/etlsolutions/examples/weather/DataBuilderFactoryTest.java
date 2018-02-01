package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestMethod;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class DataBuilderFactory.
 *
 * @author zc
 */
public final class DataBuilderFactoryTest {

    private final DataBuilderFactory instance = DataBuilderFactory.getInstance();

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertEquals(DataBuilderFactory.getInstance(), instance);
    }

    /**
     * Test of createDataBuilder method.
     */
    @Test
    public void testCreateDataBuilder() {

        assertTrue(instance.createDataBuilder(RequestMethod.FCS_3HOURLY) instanceof Wxfcs3hourlyDataBuilder);
        assertTrue(instance.createDataBuilder(RequestMethod.OBS_HOURLY) instanceof WxobsHourlyDataBuilder);
    }

    /**
     * Test of createDataBuilder method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateDataBuilder_exception() {

        instance.createDataBuilder(Mockito.eq(RequestMethod.FCS_3HOURLY));
    }
}
