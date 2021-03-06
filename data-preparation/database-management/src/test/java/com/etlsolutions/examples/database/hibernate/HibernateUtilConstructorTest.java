/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.hibernate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test of class HibernateUtil.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class HibernateUtilConstructorTest {

    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws Exception {
        Constructor[] constructors = HibernateUtil.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);

        Constructor constructor = constructors[0];
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
