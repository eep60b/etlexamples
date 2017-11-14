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
package com.etlsolutions.examples.data.bean;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class SimpleBookJavaBean.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SimpleBookJavaBeanTest {

    private final int id = 432;
    private final int id1 = 6675;
    private final String bookName = "Book Name";
    private final String bookName2 = "yashoko";
    private final Date publishedDate = new Date(123460L);
    private final Date publishedDate3 = new Date(57421481431L);
    private final Date publishedDate4 = null;
    
    private final SimpleBookJavaBean instance = new SimpleBookJavaBean(id, bookName, publishedDate);
    private final SimpleBookJavaBean instance00 = new SimpleBookJavaBean(id, bookName, publishedDate);
    private final SimpleBookJavaBean instance01 = new SimpleBookJavaBean(id1, bookName, publishedDate);
    private final SimpleBookJavaBean instance02 = new SimpleBookJavaBean(id, bookName2, publishedDate);
    private final SimpleBookJavaBean instance03 = new SimpleBookJavaBean(id, bookName, publishedDate3);
    private final SimpleBookJavaBean instance04 = new SimpleBookJavaBean(id, bookName, publishedDate4);
    private final SimpleBookJavaBean instance2 = new SimpleBookJavaBean();

    @Before
    public void setUp() {
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        assertEquals(432, instance.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(6846);
        assertEquals(6846, instance.getId());
    }

    /**
     * Test of getBookName method.
     */
    @Test
    public void testGetBookName() {
        assertEquals("Book Name", instance.getBookName());
    }

    /**
     * Test of setBookName method.
     */
    @Test
    public void testSetBookName() {

        instance.setBookName("new Name");
        assertEquals("new Name", instance.getBookName());
    }

    /**
     * Test of getPublishedDate method.
     */
    @Test
    public void testGetPublishedDate() {

        assertEquals(new Date(123460L), instance.getPublishedDate());
        instance.getPublishedDate().setTime(23891231930L);
        assertEquals(new Date(123460L), instance.getPublishedDate());
        publishedDate.setTime(23891231930L);
        assertEquals(new Date(123460L), instance.getPublishedDate());
        
        assertNull(instance04.getPublishedDate());
    }

    /**
     * Test of setPublishedDate method.
     */
    @Test
    public void testSetPublishedDate() {

        Date publishedDateK = new Date(834189414378L);
        instance.setPublishedDate(publishedDateK);
        assertEquals(new Date(834189414378L), instance.getPublishedDate());
        publishedDateK.setTime(23891231930L);
        assertEquals(new Date(834189414378L), instance.getPublishedDate());
        
        instance.setPublishedDate(null);
        assertNull(instance.getPublishedDate());        
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance00));
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("SimpleBookJavaBean{id=432, bookName=Book Name, publishedDate=Thu Jan 01 01:02:03 GMT 1970}", instance.toString());
    }
}
