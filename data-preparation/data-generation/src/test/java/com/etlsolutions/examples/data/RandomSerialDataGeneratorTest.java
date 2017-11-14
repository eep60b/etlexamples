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

import java.util.List;
import java.util.Map;
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
public class RandomSerialDataGeneratorTest {
    
    public RandomSerialDataGeneratorTest() {
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
     * Test of getDataMap method, of class RandomSerialDataGenerator.
     */
    @Test
    public void testGetDataMap() {
        System.out.println("getDataMap");
        int limit = 0;
        int length = 0;
        int start = 0;
        int step = 0;
        RandomSerialDataGenerator instance = new RandomSerialDataGenerator();
        Map<Integer, Integer> expResult = null;
        Map<Integer, Integer> result = instance.getDataMap(limit, length, start, step);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataList method, of class RandomSerialDataGenerator.
     */
    @Test
    public void testGetDataList() {
        System.out.println("getDataList");
        int limit = 0;
        int length = 0;
        RandomSerialDataGenerator instance = new RandomSerialDataGenerator();
        List<Integer> expResult = null;
        List<Integer> result = instance.getDataList(limit, length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
