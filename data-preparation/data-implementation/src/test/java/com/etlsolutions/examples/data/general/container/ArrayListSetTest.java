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
package com.etlsolutions.examples.data.general.container;

import com.etlsolutions.examples.data.general.container.ArrayListSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ArrayListSet.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ArrayListSetTest {

    private final ArrayListSet<String> instance1 = new ArrayListSet<>();
    private final ArrayListSet<String> instance2 = new ArrayListSet<>(5);
    private final ArrayListSet<String> instance3 = new ArrayListSet<>(Arrays.asList("a", "db", "ccc", "ccc"));

    @Before
    public void setUp() {
    }

    /**
     * Test of constructor.
     */
    @Test
    public void testConstructor() {
        assertTrue(instance1.isEmpty());
        assertTrue(instance2.isEmpty());
        assertEquals(3, instance3.size());
        assertEquals("a", instance3.get(0));
        assertEquals("db", instance3.get(1));
        assertEquals("ccc", instance3.get(2));
    }

    /**
     * Test of contains method.
     */
    @Test
    public void testContains() {
        assertTrue(instance3.contains("a"));
        assertTrue(instance3.contains("db"));
        assertTrue(instance3.contains("ccc"));
        assertFalse(instance3.contains("dddd"));
    }

    /**
     * Test of indexOf method.
     */
    @Test
    public void testIndexOf() {
        assertEquals(0, instance3.indexOf("a"));
        assertEquals(1, instance3.indexOf("db"));
        assertEquals(2, instance3.indexOf("ccc"));
        assertEquals(-1, instance3.indexOf("ddd"));
    }

    /**
     * Test of clone method.
     *
     * @throws CloneNotSupportedException if the inner list does not support the
     * clone operation.
     */
    @Test
    public void testClone() throws CloneNotSupportedException {

        ArrayListSet<String> result = instance3.clone();
        assertEquals(instance3, result);
        assertFalse(instance3 == result);
    }

    /**
     * Test of toArray method, of class ArrayListSet.
     */
    @Test
    public void testToArray_0args() {

        assertArrayEquals(new Object[]{"a", "db", "ccc"}, instance3.toArray());
    }

    /**
     * Test of toArray method.
     */
    @Test
    public void testToArray_GenericType() {
        assertArrayEquals(new String[]{"a", "db", "ccc"}, instance3.toArray(new String[]{}));
    }

    /**
     * Test of get method.
     */
    @Test
    public void testGet() {
        assertEquals("db", instance3.get(1));
    }

    /**
     * Test of set method.
     */
    @Test
    public void testSet() {
        assertEquals("db", instance3.set(1, "dddd"));
        assertEquals("dddd", instance3.get(1));
        assertFalse(instance3.contains("db"));
    }

    /**
     * Test of set method.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSet_duplicated() {
        instance3.set(0, "db");
    }

    /**
     * Test of add method.
     */
    @Test
    public void testAdd_GenericType() {
        assertTrue(instance1.add("add"));
        assertEquals("add", instance1.get(0));
        assertEquals(1, instance1.size());

        assertTrue(instance2.add("add"));
        assertEquals("add", instance2.get(0));
        assertEquals(1, instance2.size());

        assertTrue(instance3.add("add"));
        assertEquals("add", instance3.get(3));
        assertEquals(4, instance3.size());
    }

    /**
     * Test of add method.
     */
    @Test
    public void testAdd_GenericType_False() {
        assertFalse(instance3.add("db"));
        assertEquals(3, instance3.size());
        assertEquals("ccc", instance3.get(2));
    }

    /**
     * Test of add method.
     */
    @Test
    public void testAdd_int_GenericType() {
        assertTrue(instance3.add(1, "add"));
        assertEquals("add", instance3.get(1));
        assertEquals(4, instance3.size());
    }

    /**
     * Test of add method.
     */
    @Test
    public void testAdd_int_GenericType_False() {
        assertFalse(instance3.add(0, "db"));
        assertEquals("a", instance3.get(0));
        assertEquals(3, instance3.size());
    }

    /**
     * Test of remove method.
     */
    @Test
    public void testRemove_int() {
        assertEquals("db", instance3.remove(1));
        assertEquals(2, instance3.size());
        assertFalse(instance3.contains("db"));
    }

    /**
     * Test of remove method.
     */
    @Test
    public void testRemove_object() {

        assertTrue(instance3.remove("db"));
        assertEquals(2, instance3.size());
        assertFalse(instance3.contains("db"));
    }

    /**
     * Test of remove method.
     */
    @Test
    public void testRemove_Object_false() {

        assertFalse(instance3.remove("b"));
        assertEquals(3, instance3.size());
        assertTrue(instance3.contains("db"));
    }

    /**
     * Test of clear method.
     */
    @Test
    public void testClear() {

        instance3.clear();
        assertTrue(instance3.isEmpty());
    }

    /**
     * Test of addAll method.
     */
    @Test
    public void testAddAll_Collection() {

        Collection<String> c = new HashSet<>(Arrays.asList("a", "db", "dddd"));
        assertTrue(instance3.addAll(c));
        assertEquals(4, instance3.size());
        assertEquals("dddd", instance3.get(3));
    }

    /**
     * Test of addAll method.
     */
    @Test
    public void testAddAll_Collection_false() {

        Collection<String> c = new HashSet<>(Arrays.asList("a", "db"));
        assertFalse(instance3.addAll(c));
        assertEquals(3, instance3.size());
    }

    /**
     * Test of addAll method.
     */
    @Test
    public void testAddAll_int_Collection() {
        Collection<String> c = new HashSet<>(Arrays.asList("a", "db", "dddd"));
        assertTrue(instance3.addAll(0, c));
        assertEquals(4, instance3.size());
        assertEquals("dddd", instance3.get(0));
    }

    /**
     * Test of addAll method.
     */
    @Test
    public void testAddAll_int_Collection_false() {

        Collection<String> c = new HashSet<>(Arrays.asList("a", "db"));
        assertFalse(instance3.addAll(0, c));
        assertEquals(3, instance3.size());
    }

    /**
     * Test of removeAll method.
     */
    @Test
    public void testRemoveAll() {
        Collection<String> c = new HashSet<>(Arrays.asList("a", "db", "dddd"));
        assertTrue(instance3.removeAll(c));
        assertEquals(1, instance3.size());
        assertEquals("ccc", instance3.get(0));
    }

    /**
     * Test of removeAll method.
     */
    @Test
    public void testRemoveAll_false() {
        Collection<String> c = new HashSet<>(Arrays.asList("aa", "bbb", "dddd"));
        assertFalse(instance3.removeAll(c));
        assertEquals(3, instance3.size());
        assertTrue(instance3.contains("a"));
    }

    /**
     * Test of retainAll method.
     */
    @Test
    public void testRetainAll() {
        Collection<String> c = new HashSet<>(Arrays.asList("a", "db", "dddd"));
        assertTrue(instance3.retainAll(c));
        assertEquals(2, instance3.size());
        assertEquals("a", instance3.get(0));
        assertEquals("db", instance3.get(1));
    }

    /**
     * Test of retainAll method.
     */
    @Test
    public void testRetainAll_false() {
        Collection<String> c = new HashSet<>(Arrays.asList("a", "db", "ccc"));
        assertFalse(instance3.retainAll(c));
        assertEquals(3, instance3.size());
        assertEquals("a", instance3.get(0));
        assertEquals("db", instance3.get(1));
        assertEquals("ccc", instance3.get(2));
    }

    /**
     * Test of subArrayListSet method.
     */
    @Test
    public void testSubArrayListSet() {
        
        instance1.add("a");
        instance1.add("db");
                
        assertEquals(instance1, instance3.subArrayListSet(0, 2));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        instance1.add("a");
        instance1.add("db");
        instance1.add("ccc");        

        assertEquals(instance1.hashCode(), instance3.hashCode());
    }
    
    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_false() {
        instance1.add("db");
        instance1.add("a");
        instance1.add("ccc");        

        assertNotEquals(instance1.hashCode(), instance3.hashCode());
    }    

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {
        instance1.add("a");
        instance1.add("db");
        instance1.add("ccc");   

        assertTrue(instance3.equals(instance1));
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_not_equal() {
        instance1.add("c");
        instance1.add("db");
        instance1.add("ccc");   

        assertFalse(instance3.equals(instance1));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_other_object() {
        instance1.add("a");
        instance1.add("db");
        instance1.add("ccc");   

        assertFalse(instance3.equals(new Object()));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_null() {
        assertFalse(instance3.equals(null));
    }    
  
    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        assertEquals("[a, db, ccc]", instance3.toString());
    }
}
