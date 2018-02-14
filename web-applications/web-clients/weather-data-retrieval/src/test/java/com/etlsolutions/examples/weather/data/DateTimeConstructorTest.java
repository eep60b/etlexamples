package com.etlsolutions.examples.weather.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class DateTime.
 *
 * @author zc
 */
public final class DateTimeConstructorTest {

    /**
     * Test of constructor2.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    @SuppressWarnings("UseSpecificCatch")
    public void testConstructor() throws Exception {

        Constructor<?>[] constructors = DateTime.class.getDeclaredConstructors();

        assertEquals(2, constructors.length);

        Constructor<?> constructor1 = constructors[0];
        assertTrue(Modifier.isPrivate(constructor1.getModifiers()));
        try {
            constructor1.setAccessible(true);
            constructor1.newInstance(new Date());
        } catch (Exception ex) {
            assertTrue(ex instanceof InvocationTargetException);
        }

        Constructor<?> constructor2 = constructors[1];
        assertTrue(Modifier.isPrivate(constructor2.getModifiers()));
        try {
            constructor2.setAccessible(true);
            constructor2.newInstance("2018-09-09", "12:00:00");
        } catch (Exception ex) {
            assertTrue(ex instanceof InvocationTargetException);
        }
    }
}
