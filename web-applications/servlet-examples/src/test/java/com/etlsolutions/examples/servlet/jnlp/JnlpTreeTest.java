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
package com.etlsolutions.examples.servlet.jnlp;

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
public class JnlpTreeTest {
    
    public JnlpTreeTest() {
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
     * Test of getCodebase method, of class JnlpTree.
     */
    @Test
    public void testGetCodebase() {
        System.out.println("getCodebase");
        JnlpTree instance = null;
        String expResult = "";
        String result = instance.getCodebase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHref method, of class JnlpTree.
     */
    @Test
    public void testGetHref() {
        System.out.println("getHref");
        JnlpTree instance = null;
        String expResult = "";
        String result = instance.getHref();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class JnlpTree.
     */
    @Test
    public void testGetVersion() {
        System.out.println("getVersion");
        JnlpTree instance = null;
        String expResult = "";
        String result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInformation method, of class JnlpTree.
     */
    @Test
    public void testGetInformation() {
        System.out.println("getInformation");
        JnlpTree instance = null;
        JnlpInformation expResult = null;
        JnlpInformation result = instance.getInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecurity method, of class JnlpTree.
     */
    @Test
    public void testGetSecurity() {
        System.out.println("getSecurity");
        JnlpTree instance = null;
        JnlpSecurity expResult = null;
        JnlpSecurity result = instance.getSecurity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResources method, of class JnlpTree.
     */
    @Test
    public void testGetResources() {
        System.out.println("getResources");
        JnlpTree instance = null;
        JnlpResources expResult = null;
        JnlpResources result = instance.getResources();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplicationDesc method, of class JnlpTree.
     */
    @Test
    public void testGetApplicationDesc() {
        System.out.println("getApplicationDesc");
        JnlpTree instance = null;
        JnlpApplicationDesc expResult = null;
        JnlpApplicationDesc result = instance.getApplicationDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class JnlpTree.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        JnlpTree instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class JnlpTree.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        JnlpTree instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class JnlpTree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        JnlpTree instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
