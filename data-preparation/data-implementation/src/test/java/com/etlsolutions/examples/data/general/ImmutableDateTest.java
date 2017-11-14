/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.data.general;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ImmutableDate.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ImmutableDateTest {

    private final Date date = new Date(190348191729471289L);

    private final ImmutableDate instance = new ImmutableDate(190348191729471289L);
    private final ImmutableDate instance00 = new ImmutableDate(190348191729471289L);
    private final ImmutableDate instance01 = new ImmutableDate(813941982729471289L);
    private final ImmutableDate instance02 = new ImmutableDate(date);

    /**
     * Test of constructors.
     */
    @Test
    public void testConstructors() {

        assertEquals(190348191729471289L, instance.getTime());
        assertEquals(190348191729471289L, instance02.getTime());

        long before = System.nanoTime();
        ImmutableDate instance03 = new ImmutableDate();
        long after = System.nanoTime();
        assertTrue(instance03.getTime() > before);
        assertTrue(instance03.getTime() < after);
    }

    /**
     * Test of setTime method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testSetTime() {

        instance.setTime(12129002940230L);
    }

    /**
     * Test of clone method.
     */
    @Test
    public void testClone() {

        ImmutableDate result = instance.clone();
        assertFalse(result == instance);
        assertEquals(instance, result);
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance02));
        assertTrue(instance02.equals(instance00));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(date));
        assertFalse(instance02.equals(date));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance02.hashCode(), instance.hashCode());
        assertEquals(date.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
    }

    /**
     * Test of getTimezoneOffset method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetTimezoneOffset() {

        instance.getTimezoneOffset();
    }

    /**
     * Test of toGMTString method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testToGMTString() {

        instance.toGMTString();
    }

    /**
     * Test of toLocaleString method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testToLocaleString() {

        instance.toLocaleString();
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("", instance.toString());
    }

    /**
     * Test of compareTo method.
     */
    @Test
    public void testCompareTo() {

        assertTrue(instance.compareTo(new ImmutableDate(903441290120130910L)) > 0);
        assertEquals(0, instance.compareTo(new ImmutableDate(190348191729471289L)));
        assertTrue(instance.compareTo(new ImmutableDate(1290120130910L)) < 0);
    }

    /**
     * Test of setSeconds method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testSetSeconds() {

        instance.setSeconds(423);

    }

    /**
     * Test of getSeconds method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetSeconds() {

        instance.getSeconds();
    }

    /**
     * Test of setMinutes method, of class ImmutableDate.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testSetMinutes() {

        instance.setMinutes(32);
    }

    /**
     * Test of getMinutes method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetMinutes() {
       
        instance.getMinutes();
    }

    /**
     * Test of setHours method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testSetHours() {

        instance.setHours(11);
    }

    /**
     * Test of getHours method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetHours() {
        
        instance.getHours();
    }

    /**
     * Test of getDay method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetDay() {
        
        instance.getDay();
    }

    /**
     * Test of setDate method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testSetDate() {

        instance.setDate(132);
    }

    /**
     * Test of getDate method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetDate() {
        
        instance.getDate();
    }

    /**
     * Test of setMonth method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testSetMonth() {
        
        instance.setMonth(5);
    }

    /**
     * Test of getMonth method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetMonth() {

        instance.getMonth();
    }

    /**
     * Test of setYear method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testSetYear() {

        instance.setYear(2011);
    }

    /**
     * Test of getYear method.
     */
    @Test(expected = UnsupportedOperationException.class)
    @SuppressWarnings("deprecation")
    public void testGetYear() {

        instance.getYear();
    }
}
