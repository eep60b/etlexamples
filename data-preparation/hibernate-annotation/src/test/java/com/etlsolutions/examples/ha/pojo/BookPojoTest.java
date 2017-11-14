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

import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.UOM;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
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
public class BookPojoTest {
    
    private final BookPojo instance = new BookPojo();
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
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
        
        int bookId = 93412;
        instance.setId(bookId);
        assertEquals(bookId, instance.getId());
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {
        System.out.println("getItem");
        BookPojo instance = new BookPojo();
        ItemCommonDetailPojo expResult = null;
        ItemCommonDetailPojo result = instance.getItemCommonDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemCommonDetail method, of class BookPojo.
     */
    @Test
    public void testSetItemCommonDetail() {
        System.out.println("setItem");
        ItemCommonDetailPojo item = null;
        BookPojo instance = new BookPojo();
        instance.setItemCommonDetail(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublisher method, of class BookPojo.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        BookPojo instance = new BookPojo();
        PublisherPojo expResult = null;
        PublisherPojo result = instance.getPublisher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPublisher method, of class BookPojo.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        PublisherPojo publisher = null;
        BookPojo instance = new BookPojo();
        instance.setPublisher(publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsbn method, of class BookPojo.
     */
    @Test
    public void testGetBookIsbn() {
        System.out.println("getBookIsbn");
        BookPojo instance = new BookPojo();
        String expResult = "";
        String result = instance.getIsbn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsbn method, of class BookPojo.
     */
    @Test
    public void testSetBookIsbn() {
        System.out.println("setBookIsbn");
        String bookIsbn = "";
        BookPojo instance = new BookPojo();
        instance.setIsbn(bookIsbn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPdf method, of class BookPojo.
     */
    @Test
    public void testGetBookPdfContent() {
        System.out.println("getBookPdfContent");
        BookPojo instance = new BookPojo();
        byte[] expResult = null;
        byte[] result = instance.getPdf();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPdf method, of class BookPojo.
     */
    @Test
    public void testSetBookPdfContent() {
        System.out.println("setBookPdfContent");
        byte[] bookPdfContent = null;
        BookPojo instance = new BookPojo();
        instance.setPdf(bookPdfContent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdition method, of class BookPojo.
     */
    @Test
    public void testGetBookEdition() {
        System.out.println("getBookEdition");
        BookPojo instance = new BookPojo();
        Integer expResult = null;
        Integer result = instance.getEdition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEdition method, of class BookPojo.
     */
    @Test
    public void testSetBookEdition() {
        System.out.println("setBookEdition");
        Integer bookEdition = null;
        BookPojo instance = new BookPojo();
        instance.setEdition(bookEdition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublishDate method, of class BookPojo.
     */
    @Test
    public void testGetPublishDate() {
        System.out.println("getPublishDate");
        BookPojo instance = new BookPojo();
        Date expResult = null;
        Date result = instance.getPublishDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPublishDate method, of class BookPojo.
     */
    @Test
    public void testSetPublishDate() {
        System.out.println("setPublishDate");
        Date publishDate = null;
        BookPojo instance = new BookPojo();
        instance.setPublishDate(publishDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class BookPojo.
     */
    @Test
    public void testGetBookWidth() {
        System.out.println("getBookWidth");
        BookPojo instance = new BookPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class BookPojo.
     */
    @Test
    public void testSetBookWidth() {
        System.out.println("setBookWidth");
        BigDecimal bookWidth = null;
        BookPojo instance = new BookPojo();
        instance.setWidth(bookWidth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class BookPojo.
     */
    @Test
    public void testGetBookLength() {
        System.out.println("getBookLength");
        BookPojo instance = new BookPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLength method, of class BookPojo.
     */
    @Test
    public void testSetBookLength() {
        System.out.println("setBookLength");
        BigDecimal bookLength = null;
        BookPojo instance = new BookPojo();
        instance.setLength(bookLength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThickness method, of class BookPojo.
     */
    @Test
    public void testGetBookThickness() {
        System.out.println("getBookThickness");
        BookPojo instance = new BookPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getThickness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setThickness method, of class BookPojo.
     */
    @Test
    public void testSetBookThickness() {
        System.out.println("setBookThickness");
        BigDecimal bookThickness = null;
        BookPojo instance = new BookPojo();
        instance.setThickness(bookThickness);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUom method, of class BookPojo.
     */
    @Test
    public void testGetDimensionUnit() {
        System.out.println("getDimensionUnit");
        BookPojo instance = new BookPojo();
        String expResult = "";
        assertEquals(expResult, instance.getUom());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUom method, of class BookPojo.
     */
    @Test
    public void testSetDimensionUnit() {
        System.out.println("setDimensionUnit");
        String dimensionUnit = "";
        BookPojo instance = new BookPojo();
        instance.setUom(UOM.IN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormat method.
     */
    @Test
    public void testGetBookFormat() {
        System.out.println("getBookFormat");
        BookPojo instance = new BookPojo();
        String expResult = "";
        assertEquals(expResult, instance.getFormat());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormat method, of class BookPojo.
     */
    @Test
    public void testSetBookFormat() {
        
        instance.setFormat(BookFormat.HARDCOVER);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLanguage method, of class BookPojo.
     */
    @Test
    public void testGetBookLanguage() {
        System.out.println("getBookLanguage");
        BookPojo instance = new BookPojo();
        String expResult = "";
        assertEquals(expResult, instance.getLanguage());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLanguage method.
     */
    @Test
    public void testSetBookLanguage() {
        
        instance.setLanguage(LanguageCode.FR);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthors method, of class BookPojo.
     */
    @Test
    public void testGetAuthors() {
        System.out.println("getAuthors");
        BookPojo instance = new BookPojo();
        Set<Author> expResult = null;
        Set<Author> result = instance.getAuthors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthors method, of class BookPojo.
     */
    @Test
    public void testSetAuthors() {
        System.out.println("setAuthors");
        Set<Author> authors = null;
        BookPojo instance = new BookPojo();
        instance.setAuthors(authors);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class BookPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        BookPojo instance = new BookPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class BookPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        BookPojo instance = new BookPojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
