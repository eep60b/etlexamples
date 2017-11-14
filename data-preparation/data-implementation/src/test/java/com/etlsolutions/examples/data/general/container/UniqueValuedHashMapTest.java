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

import com.etlsolutions.examples.data.general.container.UniqueValuedHashMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class UniqueValuedHashMap.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class UniqueValuedHashMapTest {

    private final Set<String> uniqueValueKeys = new HashSet<>(Arrays.asList(new String[]{"customerId", "bookId"}));

    private final int initialCapacity = 31;
    private final float loadFactor = 4.34F;
    private final Map<String, String> externalMap = new HashMap<>();

    private final UniqueValuedHashMap<String, String> instance1 = new UniqueValuedHashMap<>(uniqueValueKeys);
    private final UniqueValuedHashMap<String, String> instance2 = new UniqueValuedHashMap<>(uniqueValueKeys, initialCapacity);
    private final UniqueValuedHashMap<String, String> instance3 = new UniqueValuedHashMap<>(uniqueValueKeys, initialCapacity, loadFactor);
    private UniqueValuedHashMap<String, String> instance4;

    @Before
    public void setUp() {

        instance1.clear();
        instance1.put("id", "adljfalvc");
        instance1.put("customerId", "confdaiadnd");
        instance1.put("bookId", "afaafdaf");
        instance1.put("extraId", "diaafdda");

        instance2.clear();
        instance2.put("id", "adljfalvc");
        instance2.put("customerId", "confdaiadnd");
        instance2.put("bookId", "afaafdaf");
        instance2.put("extraId", "diaafdda");

        instance3.clear();
        instance3.put("id", "adljfalvc");
        instance3.put("customerId", "confdaiadnd");
        instance3.put("bookId", "afaafffdaf");
        instance3.put("extraId", "diaafdda");

        externalMap.clear();
        externalMap.put("id", "adljlvc");
        externalMap.put("customerId", "conadiadnd");
        externalMap.put("bookId", "afaaf");
        externalMap.put("extraId", "diandda");

        instance4 = new UniqueValuedHashMap<>(uniqueValueKeys, externalMap);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_Exception() {

        new UniqueValuedHashMap<>(uniqueValueKeys, new HashMap<>());
    }

    /**
     * Test of replaceAll method.
     */
    @Test
    public void testReplaceAll() {
        BiFunction<String, String, String> function1 = new MockBiFunction(instance1);
        instance1.replaceAll(function1);
        assertEquals("book_id", instance1.get("bookId"));

        BiFunction<String, String, String> function2 = new MockBiFunction(instance2);
        instance1.replaceAll(function2);
        assertEquals("book_id", instance1.get("bookId"));

        BiFunction<String, String, String> function3 = new MockBiFunction(instance3);
        instance1.replaceAll(function3);
        assertEquals("book_id", instance1.get("bookId"));

        BiFunction<String, String, String> function4 = new MockBiFunction(instance4);
        instance1.replaceAll(function4);
        assertEquals("book_id", instance1.get("bookId"));
    }

    /**
     * Test of replace(K, V) method.
     */
    @Test
    public void testReplace_GenericType_GenericType() {

        assertEquals("afaafdaf", instance1.replace("bookId", "newbookkit1"));
        assertEquals("newbookkit1", instance1.get("bookId"));
        assertEquals("newbookkit1", instance1.getUniqueValueMap().get("bookId"));

        assertEquals("afaafdaf", instance2.replace("bookId", "newbookkit2"));
        assertEquals("newbookkit2", instance2.get("bookId"));
        assertEquals("newbookkit2", instance2.getUniqueValueMap().get("bookId"));

        assertEquals("afaafffdaf", instance3.replace("bookId", "newbookkit3"));
        assertEquals("newbookkit3", instance3.get("bookId"));
        assertEquals("newbookkit3", instance3.getUniqueValueMap().get("bookId"));

        assertEquals("afaaf", instance4.replace("bookId", "newbookkit4"));
        assertEquals("newbookkit4", instance4.get("bookId"));
        assertEquals("newbookkit4", instance4.getUniqueValueMap().get("bookId"));

    }

    /**
     * Test of replace(K, V, V) method.
     */
    @Test
    public void testReplace_3args() {
        assertTrue(instance1.replace("bookId", "afaafdaf", "newbookkit1"));
        assertEquals("newbookkit1", instance1.get("bookId"));
        assertEquals("newbookkit1", instance1.getUniqueValueMap().get("bookId"));

        assertTrue(instance2.replace("bookId", "afaafdaf", "newbookkit2"));
        assertEquals("newbookkit2", instance2.get("bookId"));
        assertEquals("newbookkit2", instance2.getUniqueValueMap().get("bookId"));

        assertTrue(instance3.replace("bookId", "afaafffdaf", "newbookkit3"));
        assertEquals("newbookkit3", instance3.get("bookId"));
        assertEquals("newbookkit3", instance3.getUniqueValueMap().get("bookId"));

        assertTrue(instance4.replace("bookId", "afaaf", "newbookkit4"));
        assertEquals("newbookkit4", instance4.get("bookId"));
        assertEquals("newbookkit4", instance4.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of replace(K, V, V) method.
     */
    @Test
    public void testReplace_3args_false() {
        assertFalse(instance1.replace("bookId", "afaafdaf", "newb1"));
        assertEquals("afaafdaf", instance1.get("bookId"));
        assertEquals("afaafdaf", instance1.getUniqueValueMap().get("bookId"));

        assertFalse(instance2.replace("bookId", "afaafdaf", "newit2"));
        assertEquals("afaafdaf", instance2.get("bookId"));
        assertEquals("afaafdaf", instance2.getUniqueValueMap().get("bookId"));

        assertFalse(instance3.replace("bookId", "afaafffdaf", "newt3"));
        assertEquals("afaafffdaf", instance3.get("bookId"));
        assertEquals("afaafffdaf", instance3.getUniqueValueMap().get("bookId"));

        assertFalse(instance4.replace("bookId", "afaaf", "newbot4"));
        assertEquals("afaaf", instance4.get("bookId"));
        assertEquals("afaaf", instance4.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of putIfAbsent method.
     */
    @Test
    public void testPutIfAbsent() {

        String result = instance1.putIfAbsent("bookId", "aabb");
        assertEquals("afaafdaf", result);
        assertEquals("afaafdaf", instance1.get("bookId"));
        assertEquals("afaafdaf", instance1.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of putIfAbsent method.
     */
    @Test
    public void testPutIfAbsent_Ture() {
        instance1.clear();
        assertNull(instance1.get("bookId"));
        assertNull(instance1.getUniqueValueMap().get("bookId"));

        assertNull(instance1.putIfAbsent("bookId", "aabb"));
        assertEquals("aabb", instance1.get("bookId"));
        assertEquals("aabb", instance1.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of putAll method.
     */
    @Test
    public void testPutAll() {
        System.out.println("putAll");
        Map<String, String> m = new HashMap<>();
        m.put("bookId", "12121");
        m.put("extraId", "adffa");
        m.put("additional", "adn");

        instance1.putAll(m);

        assertEquals("12121", instance1.get("bookId"));
        assertEquals("12121", instance1.getUniqueValueMap().get("bookId"));

        assertEquals("adffa", instance1.get("extraId"));
        assertNull(instance1.getUniqueValueMap().get("extraId"));

        assertEquals("adn", instance1.get("additional"));
        assertNull(instance1.getUniqueValueMap().get("additional"));
    }

    /**
     * Test of put method.
     */
    @Test
    public void testPut() {

        assertEquals("afaafdaf", instance1.put("bookId", "aabbc"));
        assertEquals("aabbc", instance1.get("bookId"));
        assertEquals("aabbc", instance1.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of merge method.
     */
    @Test
    public void testMerge() {

        BiFunction<String, String, String> remappingFunction = new MockBiFunction(instance1);

        Object expResult = null;
        String result = instance1.merge("bookId", "aafs", remappingFunction);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class UniqueValuedHashMap.
     */
    @Test
    public void testRemove_Object_Object() {

        assertTrue(instance1.remove("bookId", "afaafdaf"));
        assertNull(instance1.get("bookId"));
        assertNull(instance1.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of remove method.
     */
    @Test
    public void testRemove_Object_Object_Not_The_Value() {

        assertFalse(instance1.remove("bookId", "aff"));
        assertEquals("afaafdaf", instance1.get("bookId"));
        assertEquals("afaafdaf", instance1.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of clear method.
     */
    @Test
    public void testClear() {
        instance1.clear();
        assertTrue(instance1.isEmpty());
        assertTrue(instance1.getUniqueValueMap().isEmpty());
    }

    /**
     * Test of remove method.
     */
    @Test
    public void testRemove_Object() {
        assertEquals("afaafdaf", instance1.remove("bookId"));
        assertNull(instance1.get("bookId"));
        assertNull(instance1.getUniqueValueMap().get("bookId"));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        UniqueValuedHashMap<String, String> instance = new UniqueValuedHashMap<>(uniqueValueKeys);
        instance.put("id", "adljfalvc");
        instance.put("customerId", "confdaiadnd");
        instance.put("bookId", "afaafdaf");
        instance.put("extraId", "diaafdda");
        assertEquals(instance.hashCode(), instance1.hashCode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_Not_Equals() {

        UniqueValuedHashMap<String, String> instance = new UniqueValuedHashMap<>(uniqueValueKeys);
        instance.put("id", "adljfalvc");
        instance.put("customerId", "cd");
        instance.put("bookId", "afaafdaf");
        instance.put("extraId", "diaafdda");
        assertNotEquals(instance.hashCode(), instance1.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {

        UniqueValuedHashMap<String, String> instance = new UniqueValuedHashMap<>(uniqueValueKeys);
        instance.put("id", "adl");
        instance.put("customerId", "confdaiadnd");
        instance.put("bookId", "afaafdaf");
        instance.put("extraId", "da");
        assertTrue(instance1.equals(instance));
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_Not_Equals() {

        UniqueValuedHashMap<String, String> instance = new UniqueValuedHashMap<>(uniqueValueKeys);
        instance.put("id", "adljfalvc");
        instance.put("customerId", "cnd");
        instance.put("bookId", "afaafdaf");
        instance.put("extraId", "diaafdda");
        assertFalse(instance1.equals(instance));
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_Null() {
        UniqueValuedHashMap<String, String> instance = null;
        assertFalse(instance1.equals(instance));
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_Different_Type() {

        assertFalse(instance1.equals(new HashMap<>()));
    }

    /**
     * Test of getUniqueValueKeys method.
     */
    @Test
    public void testGetUniqueValueKeys() {
        assertEquals(uniqueValueKeys, instance1.getUniqueValueKeys());
    }

    /**
     * Test of getUniqueValueKeys method.
     */
    @Test
    public void testGetUniqueValueKeys_Immutable() {
        Set<String> keys = instance1.getUniqueValueKeys();
        keys.clear();

        assertEquals(uniqueValueKeys, instance1.getUniqueValueKeys());
    }

    /**
     * Test of getUniqueValueMap method.
     */
    @Test
    public void testGetUniqueValueMap() {

        Map<String, String> result = instance1.getUniqueValueMap();
        assertEquals(2, result.size());
        assertEquals("afaafdaf", result.get("bookId"));
        assertEquals("confdaiadnd", result.get("customerId"));
    }

    /**
     * Test of getUniqueValueMap method.
     */
    @Test
    public void testGetUniqueValueMap_Immutable() {
        Map<String, String> result1 = instance1.getUniqueValueMap();
        result1.clear();

        Map<String, String> result = instance1.getUniqueValueMap();
        assertEquals(2, result.size());
        assertEquals("afaafdaf", result.get("bookId"));
        assertEquals("confdaiadnd", result.get("customerId"));
    }

    private static final class MockBiFunction implements BiFunction<String, String, String> {

        private final UniqueValuedHashMap<String, String> instance;

        private MockBiFunction(UniqueValuedHashMap<String, String> instance) {
            this.instance = instance;
        }

        @Override
        public String apply(String t, String u) {
            instance.put("bookId", "book_id");
            return "changed";
        }
    }

    /**
     * Test of clone method.
     */
    @Test
    public void testClone() {
        assertEquals(instance1, instance1.clone());
    }
}
