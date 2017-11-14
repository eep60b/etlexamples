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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AuthorPojo.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public class AuthorPojoTest {
    
    private final AuthorPojo instance = new AuthorPojo();
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        
        assertEquals(0, instance.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {
        
        int id = 89878;        
        instance.setId(id);
        assertEquals(id, instance.getId());        
    }

    /**
     * Test of getPerson method, of class AuthorPojo.
     */
    @Test
    public void testGetPersonalDetail() {
        System.out.println("getPerson");
        AuthorPojo instance = new AuthorPojo();
        PersonalDetailPojo expResult = null;
        PersonalDetailPojo result = instance.getPersonalDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonalDetail method, of class AuthorPojo.
     */
    @Test
    public void testSetPerson() {
        System.out.println("setPerson");
        PersonalDetailPojo person = null;
        AuthorPojo instance = new AuthorPojo();
        instance.setPersonalDetail(person);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class AuthorPojo.
     */
    @Test
    public void testGetAuthorPhoto() {
        System.out.println("getAuthorPhoto");
        AuthorPojo instance = new AuthorPojo();
        byte[] expResult = null;
        byte[] result = instance.getImage();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class AuthorPojo.
     */
    @Test
    public void testSetAuthorPhoto() {
        System.out.println("setAuthorPhoto");
        byte[] authorPhoto = null;
        AuthorPojo instance = new AuthorPojo();
        instance.setImage(authorPhoto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBiography method, of class AuthorPojo.
     */
    @Test
    public void testGetAuthorBiography() {
        System.out.println("getAuthorBiography");
        AuthorPojo instance = new AuthorPojo();
        byte[] expResult = null;
        byte[] result = instance.getBiography();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBiography method, of class AuthorPojo.
     */
    @Test
    public void testSetAuthorBiography() {
        System.out.println("setAuthorBiography");
        byte[] authorBiography = null;
        AuthorPojo instance = new AuthorPojo();
        instance.setBiography(authorBiography);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWebpageUrl method, of class AuthorPojo.
     */
    @Test
    public void testGetWebpageUrl() {
        System.out.println("getWebpageUrl");
        AuthorPojo instance = new AuthorPojo();
        String expResult = "";
        String result = instance.getWebpageUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWebpageUrl method, of class AuthorPojo.
     */
    @Test
    public void testSetWebpageUrl() {
        System.out.println("setWebpageUrl");
        String webpageUrl = "";
        AuthorPojo instance = new AuthorPojo();
        instance.setWebpageUrl(webpageUrl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBooks method, of class AuthorPojo.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        AuthorPojo instance = new AuthorPojo();
        Set<Book> expResult = null;
        Set<Book> result = instance.getBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBooks method, of class AuthorPojo.
     */
    @Test
    public void testSetBooks() {
        System.out.println("setBooks");
        Set<Book> books = null;
        AuthorPojo instance = new AuthorPojo();
        instance.setBooks(books);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class AuthorPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        AuthorPojo instance = new AuthorPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class AuthorPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        AuthorPojo instance = new AuthorPojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
