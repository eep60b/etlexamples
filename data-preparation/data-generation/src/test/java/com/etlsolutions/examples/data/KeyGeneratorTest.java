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
package com.etlsolutions.examples.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * Test class KeyGenerator.
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class KeyGeneratorTest {

    private final KeyGenerator instance = new KeyGenerator();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of generateRandomKeySet method.
     */
    @Test
    public void testGenerateRandomKeySet_int() {
        assertEquals(5, instance.generateRandomKeySet(5).size());
    }
    
    /**
     * Test of generateRandomKeyList method.
     */
    @Test
    public void testGenerateRandomKeyList() {
        List<Long> result = instance.generateRandomKeyList(5);
        
        assertEquals(5, result.size());
        assertTrue(result.get(1) > result.get(0));
        assertTrue(result.get(2) > result.get(1));
        assertTrue(result.get(3) > result.get(2));
        assertTrue(result.get(4) > result.get(3));
    }

    /**
     * Test of generateSequenceKeyList method.
     */
    @Test
    public void testGenerateSequenceKeys() {

        List<Integer> expResult = Arrays.asList(new Integer[]{5, 8, 11, 14});
        assertEquals(expResult, instance.generateSequenceKeyList(4, 5, 3));
    }

    /**
     * Test of generateRandomKeyFromList method.
     */
    @Test
    public void testGenerateRandomKeyFromList() {

        List<Integer> list = Arrays.asList(new Integer[]{3, 234, 2542});
        assertTrue(list.contains(instance.generateRandomKeyFromList(list)));

    }

    /**
     * Test of generateRandomKeysFromList method.
     */
    @Test
    public void testGenerateRandomKeysFromList() {

        List<Integer> list = Arrays.asList(new Integer[]{3, 19, 234, 2542});

        List<Integer> result = instance.generateRandomKeysFromList(3, list);
        assertEquals(3, result.size());
        assertTrue(list.containsAll(result));
    }

    /**
     * Test of generateRandomKeySet method.
     */
    @Test
    public void testGenerateRandomKeySet() {
        Set<Integer> result = instance.generateRandomKeySet(139, 2579, 10);
        assertEquals(10, result.size());
        result.stream().forEach((i) -> {
            assertTrue(i > 139 && i < 2579);
        });
    }

    /**
     * Test of generateRandomKeySet method.
     */
    @Test
    public void testGenerateRandomKeySet_Min_Too_Large() {
        Set<Integer> result = instance.generateRandomKeySet(139, 138, 10);
        assertTrue(result.isEmpty());
    }
  
    /**
     * Test of generateRandomKeySet method.
     */
    @Test
    public void testGenerateRandomKeySet_Not_Enough_Range() {
        Set<Integer> result = instance.generateRandomKeySet(139, 147, 10);
        assertTrue(result.isEmpty());
    }    

    /**
     * Test of generateSequenceKeySet method.
     */
    @Test
    public void testGenerateSequenceKeySet() {
        assertEquals(new HashSet<>(Arrays.asList(new Integer[]{4, 7, 10, 13, 16})), instance.generateSequenceKeySet(5, 4, 3));
    }

    /**
     * Test of generateUniqueObjectArrayFromList method, of class KeyGenerator.
     */
    @Test
    public void testGenerateUniqueObjectFromList_Set_List() {
        System.out.println("generateUniqueObjectFromList");
        KeyGenerator instance = new KeyGenerator();
        Object expResult = null;
        Object result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateUniqueObjectArrayFromList method, of class KeyGenerator.
     */
    @Test
    public void testGenerateUniqueObjectFromList_Set_ListArr() {
        System.out.println("generateUniqueObjectFromList");
        Set<ConstraintArray> constraintArrays = null;
        List[] lists = null;
        KeyGenerator instance = new KeyGenerator();
        Object[] expResult = null;
        Object[] result = instance.generateUniqueObjectArrayFromList(constraintArrays, lists);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandomKeySet method, of class KeyGenerator.
     */
    @Test
    public void testGenerateRandomKeySet_3args() {
        System.out.println("generateRandomKeySet");
        int min = 0;
        int max = 0;
        int size = 0;
        KeyGenerator instance = new KeyGenerator();
        Set<Integer> expResult = null;
        Set<Integer> result = instance.generateRandomKeySet(min, max, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandomKey method, of class KeyGenerator.
     */
    @Test
    public void testGenerateRandomKey() {
        System.out.println("generateRandomKey");
        KeyGenerator instance = new KeyGenerator();
        int expResult = 0;
        int result = instance.generateRandomKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRamdonKeys method, of class KeyGenerator.
     */
    @Test
    public void testGenerateRamdonKeys() {
        System.out.println("generateRamdonKeys");
        int size = 0;
        KeyGenerator instance = new KeyGenerator();
        List<Integer> expResult = null;
        List<Integer> result = instance.generateRamdonKeys(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRamdonKeySet method, of class KeyGenerator.
     */
    @Test
    public void testGenerateRamdonKeySet() {
        System.out.println("generateRamdonKeySet");
        int size = 0;
        KeyGenerator instance = new KeyGenerator();
        Set<Integer> expResult = null;
        Set<Integer> result = instance.generateRamdonKeySet(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateSequenceKeyList method, of class KeyGenerator.
     */
    @Test
    public void testGenerateSequenceKeyList() {
        System.out.println("generateSequenceKeyList");
        int size = 0;
        int start = 0;
        int step = 0;
        KeyGenerator instance = new KeyGenerator();
        List<Integer> expResult = null;
        List<Integer> result = instance.generateSequenceKeyList(size, start, step);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateUniqueObjectFromList method, of class KeyGenerator.
     */
    @Test
    public void testGenerateUniqueObjectFromList() {
        System.out.println("generateUniqueObjectFromList");
        KeyGenerator instance = new KeyGenerator();
        Object expResult = null;
        Object result = instance.generateUniqueObjectFromList(null, null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateUniqueObjectArrayFromList method, of class KeyGenerator.
     */
    @Test
    public void testGenerateUniqueObjectArrayFromList() {
        System.out.println("generateUniqueObjectArrayFromList");
        Set<ConstraintArray> constraintArrays = null;
        List[] arrays = null;
        KeyGenerator instance = new KeyGenerator();
        Object[] expResult = null;
        Object[] result = instance.generateUniqueObjectArrayFromList(constraintArrays, arrays);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
