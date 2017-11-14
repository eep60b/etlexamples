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

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public class RandomNumberGeneratorTest {
    
    public RandomNumberGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateNumber method, of class RandomNumberGenerator.
     */
    @Test
    public void testGenerateNumber() {
        System.out.println("generateNumber");
        double min = 0.0;
        double max = 0.0;
        int scale = 0;
        RandomNumberGenerator instance = new RandomNumberGenerator();
        BigDecimal expResult = null;
        BigDecimal result = instance.generateNumber(min, max, scale);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generteRandomBytes method, of class RandomNumberGenerator.
     */
    @Test
    public void testGenerteRandomBytes() {
        System.out.println("generteRandomBytes");
        int length = 0;
        RandomNumberGenerator instance = new RandomNumberGenerator();
        byte[] expResult = null;
        byte[] result = instance.generteRandomBytes(length);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generatePositiveNumber method, of class RandomNumberGenerator.
     */
    @Test
    public void testGeneratePositiveNumber() {
        System.out.println("generatePositiveNumber");
        int max = 0;
        RandomNumberGenerator instance = new RandomNumberGenerator();
        int expResult = 0;
        int result = instance.generatePositiveNumber(max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandomNumberFromList method, of class RandomNumberGenerator.
     */
    @Test
    public void testGenerateRandomNumberFromList() {
        System.out.println("generateRandomNumberFromList");
        List<Integer> list = null;
        RandomNumberGenerator instance = new RandomNumberGenerator();
        int expResult = 0;
        int result = instance.generateRandomNumberFromList(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandomUniqueBytes method, of class RandomNumberGenerator.
     */
    @Test
    public void testGenerateRandomUniqueBytes() {
        System.out.println("generateRandomUniqueBytes");
        Set usedBytes = null;
        int length = 0;
        RandomNumberGenerator instance = new RandomNumberGenerator();
        byte[] expResult = null;
        byte[] result = instance.generateRandomUniqueBytes(usedBytes, length);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
