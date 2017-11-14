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

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zhipeng Chang
 */
public class DateTimeGeneratorTest {
    
    public DateTimeGeneratorTest() {
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
     * Test of generateRandomMiliSecondLong method, of class DateTimeGenerator.
     */
    @Test
    public void testGenerateRandomMiliSecondLong() {
        System.out.println("generateRandomMiliSecondLong");
        int maxSecond = 0;
        DateTimeGenerator instance = new DateTimeGenerator();
        long expResult = 0L;
        long result = instance.generateRandomMiliSecondLong(maxSecond);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandomOldDate method, of class DateTimeGenerator.
     */
    @Test
    public void testGenerateRandomOldDate() {
        System.out.println("generateRandomOldDate");
        long year = 0L;
        DateTimeGenerator instance = new DateTimeGenerator();
        Date expResult = null;
        Date result = instance.generateRandomOldDate(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandomFutureDate method, of class DateTimeGenerator.
     */
    @Test
    public void testGenerateRandomFutureDate() {
        System.out.println("generateRandomFutureDate");
        long year = 0L;
        DateTimeGenerator instance = new DateTimeGenerator();
        Object expResult = null;
        Object result = instance.generateRandomFutureDate(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
