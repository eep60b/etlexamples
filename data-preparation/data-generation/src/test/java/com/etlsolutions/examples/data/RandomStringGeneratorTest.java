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

import com.etlsolutions.examples.base.configuration.SystemConstants;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Test of class RandomStringGenerator.
 *
 * @author Zhipeng Chang
 * @version 1.0.0
 * @since 1.0.0
 */
public final class RandomStringGeneratorTest {

    private final RandomStringGenerator instance = new RandomStringGenerator();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of generateString(int minLength, int maxLength, Set charSet) method.
     */
    @Test
    public void testGenerateString_3args() {
        //Run 100 times
        for (int i = 0; i < 100; i++) {
            assertTrue(instance.generateString(4, 20, SystemConstants.BASIC_26_CHARACTER_SET).length() >= 4);
            assertTrue(instance.generateString(4, 20, SystemConstants.BASIC_26_CHARACTER_SET).length() <= 20);
        }
    }

    /**
     * Test of generateString(int minLength, int maxLength, Set charSet) method.
     *
     */
    @Test
    public void testGenerateString_3args_NotSame() {
        assertNotEquals(instance.generateString(2, 20, SystemConstants.BASIC_26_CHARACTER_SET), instance.generateString(2, 20, SystemConstants.BASIC_26_CHARACTER_SET));
    }

    /**
     * Test of generateString(int maxLength, Set charSet) method.
     */
    @Test
    public void testGenerateString_int_Set() {
        //Run 100 times
        for (int i = 0; i < 100; i++) {
            assertTrue(instance.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET).length() >= 1);
            assertTrue(instance.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET).length() <= 20);
        }
    }

    /**
     * Test of generateString(int maxLength, Se charSet) method.
     */
    @Test
    public void testGenerateString_int_Set_NotSame() {
        assertNotEquals(instance.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET), instance.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET));
    }

    /**
     * Test of generateString(int minLength, int maxLength) method.
     *
     */
    @Test
    public void testGenerateString_int_int() {
        assertTrue(instance.generateString(4, 20).length() >= 4);
        assertTrue(instance.generateString(4, 20).length() <= 20);
    }

    /**
     * Test of generateString(int minLength, int maxLength) method.
     *
     */
    @Test
    public void testGenerateString_int() {
        assertTrue(instance.generateString(20).length() >= 4);
        assertTrue(instance.generateString(20).length() <= 20);
    }

    /**
     * Test of generateFixedLengthString method, of class RandomStringGenerator.
     */
    @Test
    public void testGenerateFixedLengthString() {
        assertEquals(5, instance.generateFixedLengthString(5, SystemConstants.BASIC_26_CHARACTER_SET).length());
        assertNotEquals(instance.generateFixedLengthString(5, SystemConstants.BASIC_26_CHARACTER_SET), instance.generateFixedLengthString(5, SystemConstants.BASIC_26_CHARACTER_SET));
    }

    /**
     * Test of generateFixedLengthString method, of class RandomStringGenerator.
     */
    @Test
    public void testGenerateFixedLengthString_int_Set() {
        System.out.println("generateFixedLengthString");
        int length = 0;
        Set<Character> charSet = null;
        RandomStringGenerator instance = new RandomStringGenerator();
        String expResult = "";
        String result = instance.generateFixedLengthString(length, charSet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateFixedLengthString method, of class RandomStringGenerator.
     */
    @Test
    public void testGenerateFixedLengthString_int() {
        System.out.println("generateFixedLengthString");
        int length = 0;
        RandomStringGenerator instance = new RandomStringGenerator();
        String expResult = "";
        String result = instance.generateFixedLengthString(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateStringFromList method, of class RandomStringGenerator.
     */
    @Test
    public void testGenerateStringFromList() {
        System.out.println("generateStringFromList");
        List<String> list = null;
        RandomStringGenerator instance = new RandomStringGenerator();
        String expResult = "";
        String result = instance.generateStringFromList(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateStringFromArray method, of class RandomStringGenerator.
     */
    @Test
    public void testGenerateStringFromArray() {
        System.out.println("generateStringFromArray");
        String[] list = null;
        RandomStringGenerator instance = new RandomStringGenerator();
        String expResult = "";
        String result = instance.generateStringFromArray(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateFixedLengthDigitalString method, of class RandomStringGenerator.
     */
    @Test
    public void testGenerateFixedLengthDigitalString() {
        System.out.println("generateFixedLengthDigitalString");
        int length = 0;
        RandomStringGenerator instance = new RandomStringGenerator();
        String expResult = "";
        String result = instance.generateFixedLengthDigitalString(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateVariableLengthDigitalString method, of class RandomStringGenerator.
     */
    @Test
    public void testGenerateVariableLengthDigitalString() {
        System.out.println("generateVariableLengthDigitalString");
        int maxLength = 0;
        RandomStringGenerator instance = new RandomStringGenerator();
        String expResult = "";
        String result = instance.generateVariableLengthDigitalString(maxLength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
