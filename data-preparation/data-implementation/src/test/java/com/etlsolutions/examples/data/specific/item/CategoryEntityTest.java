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
package com.etlsolutions.examples.data.specific.item;

import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.api.Category;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 * Test of class CategoryEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class CategoryEntityTest {

    private final String categoryNameString = "knak category";
    private final NameWrapper categoryName = new NameWrapper(categoryNameString);
    private final NameWrapper categoryName1 = new NameWrapper("frunk dudp");

    private final Category category = Mockito.mock(Category.class);

    private final CategoryEntity instance = new CategoryEntity(categoryName);
    private final CategoryEntity instance00 = new CategoryEntity(categoryName);
    private final CategoryEntity instance01 = new CategoryEntity(categoryName1);
    private final CategoryEntity instance02 = new CategoryEntity(categoryNameString);
    private CategoryEntity instance03;

    @Before
    public void setUp() {

        Mockito.when(category.getName()).thenReturn(categoryNameString);
        instance03 = new CategoryEntity(category);
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {

        assertEquals("knak category", instance.getName());
        assertEquals("knak category", instance02.getName());
        assertEquals("knak category", instance03.getName());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance02.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance02));
        assertTrue(instance.equals(instance03));
        assertTrue(instance03.equals(instance));        
        
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("CategoryEntity{category name=knak category}", instance.toString());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance02));

        assertFalse(instance.hasSameConstraint(instance01));

        Mockito.when(category.getName()).thenReturn("knak category");
        assertTrue(instance.hasSameConstraint(category));

        Mockito.when(category.getName()).thenReturn("knak categoryA");
        assertFalse(instance.hasSameConstraint(category));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance02));

        assertFalse(instance.hasSameParameters(instance01));

        Mockito.when(category.getName()).thenReturn("knak category");
        assertTrue(instance.hasSameParameters(category));

        Mockito.when(category.getName()).thenReturn("knak categoryA");
        assertFalse(instance.hasSameParameters(category));
    }
}
