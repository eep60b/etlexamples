package com.etlsolutions.examples.weather.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class RequestConfig.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RequestConfig.class, RequestMethod.class, RequestLocation.class, RequestToken.class})
public final class RequestConfigTest {

    private final RequestMethod requestMethod = PowerMockito.mock(RequestMethod.class);
    private final RequestLocation requestLocation = PowerMockito.mock(RequestLocation.class);
    private final RequestToken requestToken = PowerMockito.mock(RequestToken.class);

    private RequestConfig instance;
    
    @Before
    public void setUp() {
        
        Mockito.when(requestMethod.getMethodToken()).thenReturn("mmyya");
        Mockito.when(requestMethod.getInterval()).thenReturn("hourly");
        Mockito.when(requestLocation.getId()).thenReturn("55931");
        Mockito.when(requestToken.getValue()).thenReturn("1572-6847-7219-1430");
        instance = new RequestConfig(requestMethod, requestLocation, requestToken);
    }

    /**
     * Test of getRequestMethod method.
     */
    @Test
    public void testGetRequestMethod() {
        
        assertEquals(requestMethod, instance.getRequestMethod());
    }

    /**
     * Test of getRequestLocation method.
     */
    @Test
    public void testGetRequestLocation() {

        assertEquals(requestLocation, instance.getRequestLocation());
    }

    /**
     * Test of getRequestToken method.
     */
    @Test
    public void testGetRequestToken() {

        assertEquals(requestToken, instance.getRequestToken());
    }

    /**
     * Test of getUrl method.
     */
    @Test
    public void testGetUrl() {

        assertEquals("http://datapoint.metoffice.gov.uk/public/data/val/mmyya/all/xml/55931?res=hourly&key=1572-6847-7219-1430", instance.getUrl());
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        
        Mockito.when(requestMethod.toString()).thenReturn("myMethod");
        Mockito.when(requestLocation.toString()).thenReturn("myLocation");
        Mockito.when(requestToken.toString()).thenReturn("myToken");
        
        assertEquals("RequesConfig{" + "method=myMethod, location=myLocation, user token=myToken, url=http://datapoint.metoffice.gov.uk/public/data/val/mmyya/all/xml/55931?res=hourly&key=1572-6847-7219-1430}", instance.toString());
    }
}
