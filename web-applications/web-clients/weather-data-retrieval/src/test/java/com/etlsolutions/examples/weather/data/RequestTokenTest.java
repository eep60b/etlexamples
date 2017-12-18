package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class RequestToken.
 *
 * @author zc
 */
public final class RequestTokenTest {

    
    private final String value = "oeur1n39hao";    
    private final RequestToken instance = new RequestToken(value);

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertEquals("oeur1n39hao", instance.getValue());
    }
}
