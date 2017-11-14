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

import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class CategoryPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class CategoryPojoTest {
    
    private final int id = 23932;
    private final int id1 = 9931;
    private final String name = "catcatlS";
    private final String name2 = "dkcatl";
    private final ItemCommonDetail itemCommonDetail1 = Mockito.mock(ItemCommonDetail.class);
    private final ItemCommonDetail itemCommonDetail2 = Mockito.mock(ItemCommonDetail.class);
    private final ItemCommonDetail itemCommonDetail3 = Mockito.mock(ItemCommonDetail.class);
    private final ItemCommonDetail itemCommonDetail4 = Mockito.mock(ItemCommonDetail.class);
    private final Set<ItemCommonDetail> itemCommonDetails = new HashSet<>(Arrays.asList(itemCommonDetail1, itemCommonDetail2, itemCommonDetail3));
    private final Set<ItemCommonDetail> itemCommonDetails3 = new HashSet<>(Arrays.asList(itemCommonDetail2, itemCommonDetail4));
    private final Set<ItemCommonDetail> itemCommonDetails4 = null;
    private final Category category = Mockito.mock(Category.class);
    
    private final CategoryPojo instance = new CategoryPojo(id, name, itemCommonDetails);
    private final CategoryPojo instance00 = new CategoryPojo(id, name, itemCommonDetails);
    private final CategoryPojo instance01 = new CategoryPojo(id1, name, itemCommonDetails);
    private final CategoryPojo instance02 = new CategoryPojo(id, name2, itemCommonDetails);
    private final CategoryPojo instance03 = new CategoryPojo(id, name, itemCommonDetails3);
    private final CategoryPojo instance04 = new CategoryPojo(id, name, itemCommonDetails4);
    private final CategoryPojo instance05 = new CategoryPojo();
    private final CategoryPojo instance06 = new CategoryPojo(id, name);
    private final CategoryPojo instance07 = new CategoryPojo(name, itemCommonDetails);
    private final CategoryPojo instance08 = new HibernateProxyCategoryPojo(new CategoryPojo(id, name, itemCommonDetails));
    private CategoryPojo instance09;
    
    @Before
    public void setUp() {
        Mockito.when(category.getName()).thenReturn(name);
        instance09 = new CategoryPojo(category);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        
        assertEquals(23932, instance.getId());
        assertEquals(0, instance05.getId());
        assertEquals(23932, instance06.getId());
        assertEquals(0, instance07.getId());
        assertEquals(0, instance09.getId());
        assertEquals(0, instance08.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {
        
        instance.setId(675);
        assertEquals(675, instance.getId());
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {
        
        assertEquals("catcatlS", instance.getName());
        assertNull(instance05.getName());
        assertEquals("catcatlS", instance06.getName());
        assertEquals("catcatlS", instance07.getName());
        assertEquals("catcatlS", instance09.getName());
        assertNull(instance08.getName());
    }

    /**
     * Test of setName method.
     */
    @Test
    public void testSetName() {
        
        instance.setName("new name");
        assertEquals("new name", instance.getName());
    }

    /**
     * Test of getItemCommonDetails method.
     */
    @Test
    public void testGetItemCommonDetails() {
        
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetail1, itemCommonDetail2, itemCommonDetail3)), instance.getItemCommonDetails());
        instance.getItemCommonDetails().clear();
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetail1, itemCommonDetail2, itemCommonDetail3)), instance.getItemCommonDetails());
        itemCommonDetails.clear();
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetail1, itemCommonDetail2, itemCommonDetail3)), instance.getItemCommonDetails());
        
        assertNull(instance04.getItemCommonDetails());
        assertTrue(instance05.getItemCommonDetails().isEmpty());
        assertTrue(instance06.getItemCommonDetails().isEmpty());
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetail1, itemCommonDetail2, itemCommonDetail3)), instance07.getItemCommonDetails());
        assertTrue(instance09.getItemCommonDetails().isEmpty());
        assertTrue(instance08.getItemCommonDetails().isEmpty());
    }

    /**
     * Test of setItemCommonDetails method.
     */
    @Test
    public void testSetItemCommonDetails() {
        
        Set<ItemCommonDetail> itemCommonDetailsX = new HashSet<>(Arrays.asList(itemCommonDetail3, itemCommonDetail4));
        instance.setItemCommonDetails(itemCommonDetailsX);
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetail3, itemCommonDetail4)), instance.getItemCommonDetails());
        itemCommonDetailsX.clear();
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetail3, itemCommonDetail4)), instance.getItemCommonDetails());
        instance.setItemCommonDetails(null);
        assertNull(instance.getItemCommonDetails());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {
        
        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance08.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(category));
        
        assertFalse(instance.hasSameConstraint(null));
        assertFalse(instance05.hasSameConstraint(instance02));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance03));
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance08.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(category));
        
        assertFalse(instance.hasSameParameters(null));
        assertFalse(instance05.hasSameParameters(instance02));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        
        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        
        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {
        
        assertTrue(instance.equals(instance06));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance03));
        assertTrue(instance.equals(instance08));
        assertTrue(instance08.equals(instance));
        
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(null));
        assertFalse(instance.equals(category));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        
        assertEquals("CategoryPojo{id=23932, name=catcatlS}", instance.toString());
        assertEquals("CategoryPojo{id=0, name=null}", instance05.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {
        
        assertTrue(SerialisationUtilities.isSerializable(instance05));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyCategoryPojo extends CategoryPojo implements HibernateProxy {
        
        private static final long serialVersionUID = 99273646322363848L;
        
        private final CategoryPojo pojo;
        
        public HibernateProxyCategoryPojo(CategoryPojo pojo) {
            
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
                public CategoryPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
