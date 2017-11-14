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
package com.etlsolutions.examples.utility;

import java.io.File;
import java.util.Set;
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
public class FileUtilitiesTest {
    
    public FileUtilitiesTest() {
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
     * Test of readCharSet method, of class FileUtilities.
     */
    @Test
    public void testReadCharSet() throws Exception {
        System.out.println("readCharSet");
        File file = null;
        Set<Character> expResult = null;
        Set<Character> result = FileUtilities.readCharSet(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFileToString.
     */
    @Test
    public void testFileToString() throws Exception {
        System.out.println("readText");
        File file = null;
        String expResult = "";
        String result = FileUtilities.readFileToString(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyFile method, of class FileUtilities.
     */
    @Test
    public void testCopyFile() throws Exception {
        System.out.println("copyFile");
        File defaultConfigFile = null;
        File configFile = null;
        FileUtilities.copyFile(defaultConfigFile, configFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
