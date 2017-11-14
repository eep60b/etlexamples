/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.base.configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class SystemConstants.
 *
 * @author Zhipeng Chang
 */
public final class SystemConstantsTest {

    /**
     * Test of constructor.
     *
     * @throws Exception
     */
    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws Exception {

        Constructor[] constructors = SystemConstants.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);

        Constructor constructor = constructors[0];
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
