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

import com.etlsolutions.examples.data.api.ItemCommonDetail;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zhipeng
 */
public class CategoryPojoTest {
    
    public CategoryPojoTest() {
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
     * Test of getId method, of class CategoryPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        CategoryPojo instance = new CategoryPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class CategoryPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        CategoryPojo instance = new CategoryPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class CategoryPojo.
     */
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        CategoryPojo instance = new CategoryPojo();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class CategoryPojo.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String categoryName = "";
        CategoryPojo instance = new CategoryPojo();
        instance.setName(categoryName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemCommonDetails method, of class CategoryPojo.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        CategoryPojo instance = new CategoryPojo();
        Set<ItemCommonDetail> expResult = null;
        Set<ItemCommonDetail> result = instance.getItemCommonDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemCommonDetails method, of class CategoryPojo.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        Set<ItemCommonDetail> items = null;
        CategoryPojo instance = new CategoryPojo();
        instance.setItemCommonDetails(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class CategoryPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        CategoryPojo instance = new CategoryPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class CategoryPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        CategoryPojo instance = new CategoryPojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
