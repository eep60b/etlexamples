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

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(new RequestToken(value).hashCode(), instance.hashCode());
        assertNotEquals(new RequestToken("oeur1n39haoaa").hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(new RequestToken(value)));
        assertFalse(instance.equals(new RequestToken("oeur1n39haoaa")));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("RequestToken{value=oeur1n39hao}", instance.toString());
    }
}
