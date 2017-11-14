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

import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.data.api.ItemCategoryLink;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * Test of class ItemCategoryLinkEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ItemCategoryLinkEntity.class, ItemCommonDetailEntity.class, CategoryEntity.class})
public class ItemCategoryLinkEntityTest {

    private final ItemCommonDetailEntity itemCommonDetailEntity = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetailEntity itemCommonDetailEntity1 = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);
    private final CategoryEntity categoryEntity = PowerMockito.mock(CategoryEntity.class);
    private final CategoryEntity categoryEntity2 = PowerMockito.mock(CategoryEntity.class);
    private final Category category = Mockito.mock(Category.class);
    private final ItemCategoryLink itemCategoryLink = Mockito.mock(ItemCategoryLink.class);

    private final ItemCategoryLinkEntity instance = new ItemCategoryLinkEntity(itemCommonDetailEntity, categoryEntity);
    private final ItemCategoryLinkEntity instance00 = new ItemCategoryLinkEntity(itemCommonDetailEntity, categoryEntity);
    private final ItemCategoryLinkEntity instance01 = new ItemCategoryLinkEntity(itemCommonDetailEntity, categoryEntity);
    private final ItemCategoryLinkEntity instance02 = new ItemCategoryLinkEntity(itemCommonDetailEntity, categoryEntity);
    private ItemCategoryLinkEntity instance03;
    private ItemCategoryLinkEntity instance04;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(ItemCommonDetailEntity.class).withArguments(itemCommonDetail).thenReturn(itemCommonDetailEntity);
        PowerMockito.whenNew(CategoryEntity.class).withArguments(category).thenReturn(categoryEntity);

        Mockito.when(itemCategoryLink.getCategory()).thenReturn(categoryEntity);
        Mockito.when(itemCategoryLink.getItemCommonDetail()).thenReturn(itemCommonDetailEntity);

        instance03 = new ItemCategoryLinkEntity(itemCommonDetail, category);
        instance04 = new ItemCategoryLinkEntity(itemCategoryLink);
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetailEntity, instance.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance03.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance04.getItemCommonDetail());
    }

    /**
     * Test of getCategory method.
     */
    @Test
    public void testGetCategory() {

        assertEquals(categoryEntity, instance.getCategory());
        assertEquals(categoryEntity, instance03.getCategory());
        assertEquals(categoryEntity, instance04.getCategory());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance03));
        assertTrue(instance.hasSameParameters(instance04));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance03));
        assertTrue(instance.equals(instance04));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(itemCategoryLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method
     */
    @Test
    public void testToString() {

        assertEquals("ItemCategoryLinkEntity{item barcode=", instance.toString());
    }
}
