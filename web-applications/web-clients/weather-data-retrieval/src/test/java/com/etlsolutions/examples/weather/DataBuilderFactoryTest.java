package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestMethod;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Test of class DataBuilderFactory.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RequestMethod.class})  //DO NOT add DataBuilderFactory.class here.
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

        RequestMethod newMethod = PowerMockito.mock(RequestMethod.class);
        Whitebox.setInternalState(newMethod, "name", "xMethod");
        Whitebox.setInternalState(newMethod, "ordinal", 2);

        PowerMockito.mockStatic(RequestMethod.class);
        PowerMockito.when(RequestMethod.values()).thenReturn(new RequestMethod[] {RequestMethod.FCS_3HOURLY, RequestMethod.OBS_HOURLY, newMethod});
        instance.createDataBuilder(newMethod);
    }
}
