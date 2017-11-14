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
package com.etlsolutions.examples.ha.pojo;

import com.etlsolutions.examples.data.api.Book;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public class PublisherPojoTest {
    
    public PublisherPojoTest() {
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
     * Test of getId method, of class PublisherPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PublisherPojo instance = new PublisherPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class PublisherPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        PublisherPojo instance = new PublisherPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class PublisherPojo.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        PublisherPojo instance = new PublisherPojo();
        AddressPojo expResult = null;
        AddressPojo result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class PublisherPojo.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        AddressPojo address = null;
        PublisherPojo instance = new PublisherPojo();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class PublisherPojo.
     */
    @Test
    public void testGetPublisherName() {
        System.out.println("getPublisherName");
        PublisherPojo instance = new PublisherPojo();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class PublisherPojo.
     */
    @Test
    public void testSetPublisherName() {
        System.out.println("setPublisherName");
        String publisherName = "";
        PublisherPojo instance = new PublisherPojo();
        instance.setName(publisherName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBooks method, of class PublisherPojo.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        PublisherPojo instance = new PublisherPojo();
        Set<Book> expResult = null;
        Set<Book> result = instance.getBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBooks method, of class PublisherPojo.
     */
    @Test
    public void testSetBooks() {
        System.out.println("setBooks");
        Set<Book> books = null;
        PublisherPojo instance = new PublisherPojo();
        instance.setBooks(books);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
