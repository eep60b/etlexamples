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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class SerialisationUtilities.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SerialisationUtilitiesTest {

    public SerialisationUtilitiesTest() {
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
     * Test of isSerializable method, of class SerialisationUtilities.
     */
    @Test
    public void testIsSerializable() {
        System.out.println("isSerializable");
        Serializable serializable = null;
        boolean expResult = false;
        boolean result = SerialisationUtilities.isSerializable(serializable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class SerialisationUtilities.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Serializable serializable = null;
        Object expResult = null;
        Object result = SerialisationUtilities.clone(serializable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serialize method, of class SerialisationUtilities.
     */
    @Test
    public void testSerialize_Serializable_String() throws Exception {
        System.out.println("serialize");
        Serializable serializable = null;
        String path = "";
        SerialisationUtilities.serialize(serializable, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serialize method, of class SerialisationUtilities.
     */
    @Test
    public void testSerialize_Serializable_File() throws Exception {
        System.out.println("serialize");
        Serializable serializable = null;
        File file = null;
        SerialisationUtilities.serialize(serializable, file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serialize method, of class SerialisationUtilities.
     */
    @Test
    public void testSerialize_Serializable_OutputStream() {
        System.out.println("serialize");
        Serializable serializable = null;
        OutputStream outputStream = null;
        SerialisationUtilities.serialize(serializable, outputStream);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serialize method, of class SerialisationUtilities.
     */
    @Test
    public void testSerialize_Serializable() {
        System.out.println("serialize");
        Serializable serializable = null;
        SerialisationUtilities instance = null;
        byte[] expResult = null;
        byte[] result = instance.serialize(serializable);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserialize method, of class SerialisationUtilities.
     */
    @Test
    public void testDeserialize_String() throws Exception {
        System.out.println("deserialize");
        String path = "";
        Object expResult = null;
        Object result = SerialisationUtilities.deserialize(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserialize method, of class SerialisationUtilities.
     */
    @Test
    public void testDeserialize_File() throws Exception {
        System.out.println("deserialize");
        File file = null;
        Object expResult = null;
        Object result = SerialisationUtilities.deserialize(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserialize method, of class SerialisationUtilities.
     */
    @Test
    public void testDeserialize_InputStream() {
        System.out.println("deserialize");
        InputStream inputStream = null;
        Object expResult = null;
        Object result = SerialisationUtilities.deserialize(inputStream);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserialize method, of class SerialisationUtilities.
     */
    @Test
    public void testDeserialize_byteArr() {
        System.out.println("deserialize");
        byte[] objectData = null;
        Object expResult = null;
        Object result = SerialisationUtilities.deserialize(objectData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
