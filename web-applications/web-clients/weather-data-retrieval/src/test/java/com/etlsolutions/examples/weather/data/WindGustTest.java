package com.etlsolutions.examples.weather.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class WindGust.
 *
 * @author zc
 */
public final class WindGustTest {

    private final WindGust instance1 = new WindGust("12.4");
    private final WindGust instance2 = new WindGust(new WindSpeed("12.4"));    
    /**
     * Test of constructors.
     */
    @Test
    public void testConstructors() {

        assertTrue(instance1.getValue() == 12.4);
        assertTrue(instance2.getValue() == 12.4);
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {
        assertEquals("WdGst", instance1.getShortName());
    }
}
