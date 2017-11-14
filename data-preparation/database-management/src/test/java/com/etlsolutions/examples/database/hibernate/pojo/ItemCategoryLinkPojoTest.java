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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.data.api.ItemCategoryLink;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class ItemCategoryLinkPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemCategoryLinkPojoTest {

    private final ItemCommonDetailPojo itemCommonDetailPojo = Mockito.mock(ItemCommonDetailPojo.class);
    private final ItemCommonDetailPojo itemCommonDetailPojo1 = Mockito.mock(ItemCommonDetailPojo.class);
    private final CategoryPojo categoryPojo = Mockito.mock(CategoryPojo.class);
    private final CategoryPojo categoryPojo2 = Mockito.mock(CategoryPojo.class);
    private final ItemCategoryLink itemCategoryLink = Mockito.mock(ItemCategoryLink.class);

    private final ItemCategoryLinkPojo instance = new ItemCategoryLinkPojo(itemCommonDetailPojo, categoryPojo);
    private final ItemCategoryLinkPojo instance00 = new ItemCategoryLinkPojo(itemCommonDetailPojo, categoryPojo);
    private final ItemCategoryLinkPojo instance01 = new ItemCategoryLinkPojo(itemCommonDetailPojo1, categoryPojo);
    private final ItemCategoryLinkPojo instance02 = new ItemCategoryLinkPojo(itemCommonDetailPojo, categoryPojo2);
    private final ItemCategoryLinkPojo instance03 = new ItemCategoryLinkPojo(null, null);
    private final ItemCategoryLinkPojo instance04 = new ItemCategoryLinkPojo();
    private final ItemCategoryLinkPojo instance05 = new HibernateProxyItemCategoryLinkPojo(new ItemCategoryLinkPojo(itemCommonDetailPojo, categoryPojo));
    private final ItemCategoryLinkPojo instance06 = new ItemCategoryLinkPojo( new ItemCommonDetailPojo(), new CategoryPojo());
    
    @Before
    public void setUp() {

        Mockito.when(itemCategoryLink.getItemCommonDetail()).thenReturn(itemCommonDetailPojo);
        Mockito.when(itemCategoryLink.getCategory()).thenReturn(categoryPojo);
        Mockito.when(itemCommonDetailPojo.getId()).thenReturn(219);
        Mockito.when(categoryPojo.getId()).thenReturn(333);
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetailPojo, instance.getItemCommonDetail());
        assertNull(instance03.getItemCommonDetail());
        assertNull(instance04.getItemCommonDetail());
        assertNull(instance05.getItemCommonDetail());
    }

    /**
     * Test of getCategory method.
     */
    @Test
    public void testGetCategory() {

        assertEquals(categoryPojo, instance.getCategory());
        assertNull(instance03.getCategory());
        assertNull(instance04.getCategory());
        assertNull(instance05.getCategory());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {
        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(itemCategoryLink));
        assertTrue(instance05.hasSameConstraint(instance));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        Mockito.when(itemCommonDetailPojo.hasSameParameters(itemCommonDetailPojo1)).thenReturn(Boolean.TRUE);
        Mockito.when(categoryPojo.hasSameParameters(categoryPojo2)).thenReturn(Boolean.TRUE);
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance02));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(itemCategoryLink));
        assertTrue(instance05.hasSameParameters(instance));

        Mockito.when(itemCommonDetailPojo.hasSameParameters(itemCommonDetailPojo1)).thenReturn(Boolean.FALSE);
        Mockito.when(categoryPojo.hasSameParameters(categoryPojo2)).thenReturn(Boolean.FALSE);
        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance.hashCode(), instance.hashCode());

    }

    /**
     * Test of equals method, of class ItemCategoryLinkPojo.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance05));
        assertTrue(instance05.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(itemCategoryLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of getItemCommonDetailId method.
     */
    @Test
    public void testGetItemCommonDetailId() {

        assertEquals(219, instance.getItemCommonDetailId());
        assertEquals(0, instance03.getItemCommonDetailId());
        assertEquals(0, instance04.getItemCommonDetailId());
        assertEquals(0, instance05.getItemCommonDetailId());
    }

    /**
     * Test of getCategoryId method.
     */
    @Test
    public void testGetCategoryId() {

        assertEquals(333, instance.getCategoryId());
        assertEquals(0, instance03.getCategoryId());
        assertEquals(0, instance04.getCategoryId());
        assertEquals(0, instance05.getCategoryId());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance06));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyItemCategoryLinkPojo extends ItemCategoryLinkPojo implements HibernateProxy {

        private static final long serialVersionUID = 919001646200396012L;

        private final ItemCategoryLinkPojo pojo;

        public HibernateProxyItemCategoryLinkPojo(ItemCategoryLinkPojo pojo) {

            this.pojo = pojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {

                @Override
                public ItemCategoryLinkPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
