package com.etlsolutions.examples.weather;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test of class ProcrunService.
 *
 * @author zc
 */
public final class ProcrunServiceConstructorTest {

    /**
     * Test of constructor.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws Exception {

        Constructor<?>[] constructors =  ProcrunService.class.getDeclaredConstructors();

        assertEquals(1, constructors.length);

        Constructor<?> constructor = constructors[0];
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
