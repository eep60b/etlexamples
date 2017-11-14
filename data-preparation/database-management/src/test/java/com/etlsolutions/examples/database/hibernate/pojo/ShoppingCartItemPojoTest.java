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

import com.etlsolutions.examples.data.api.ShoppingCartItem;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class ShoppingCartItemPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ShoppingCartItemPojoTest {

    private final int id = 239423;
    private final int id1 = 981234;
    private final CustomerPojo customer = Mockito.mock(CustomerPojo.class);
    private final CustomerPojo customer2 = Mockito.mock(CustomerPojo.class);
    private final ItemCommonDetailPojo itemCommonDetail = Mockito.mock(ItemCommonDetailPojo.class);
    private final ItemCommonDetailPojo itemCommonDetail3 = Mockito.mock(ItemCommonDetailPojo.class);
    private final int unitNumber = 21;
    private final int unitNumber4 = 12;
    private final ShoppingCartItem shoppingCartItem = Mockito.mock(ShoppingCartItem.class);

    private final ShoppingCartItemPojo instance   = new ShoppingCartItemPojo(id, customer, itemCommonDetail, unitNumber);
    private final ShoppingCartItemPojo instance00 = new ShoppingCartItemPojo(id, customer, itemCommonDetail, unitNumber);
    private final ShoppingCartItemPojo instance01 = new ShoppingCartItemPojo(id1, customer, itemCommonDetail, unitNumber);
    private final ShoppingCartItemPojo instance02 = new ShoppingCartItemPojo(id, customer2, itemCommonDetail, unitNumber);
    private final ShoppingCartItemPojo instance03 = new ShoppingCartItemPojo(id, customer, itemCommonDetail3, unitNumber);
    private final ShoppingCartItemPojo instance04 = new ShoppingCartItemPojo(id, customer, itemCommonDetail, unitNumber4);
    private final ShoppingCartItemPojo instance05 = new ShoppingCartItemPojo();
    private final ShoppingCartItemPojo instance06 = new ShoppingCartItemPojo(id, unitNumber);
    private final ShoppingCartItemPojo instance07 = new ShoppingCartItemPojo(customer, itemCommonDetail, unitNumber);
    private final ShoppingCartItemPojo instance08 = new HibernateProxyShoppingCartItemPojo(new ShoppingCartItemPojo(id, customer, itemCommonDetail, unitNumber));
    private final ShoppingCartItemPojo instance09   = new ShoppingCartItemPojo(id, new CustomerPojo(), new ItemCommonDetailPojo(), unitNumber);    

    @Before
    public void setUp() {

        Mockito.when(shoppingCartItem.getCustomer()).thenReturn(customer);
        Mockito.when(shoppingCartItem.getItemCommonDetail()).thenReturn(itemCommonDetail);
        Mockito.when(shoppingCartItem.getUnitNumber()).thenReturn(21);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(239423, instance.getId());
        assertEquals(0, instance05.getId());
        assertEquals(239423, instance06.getId());
        assertEquals(0, instance07.getId());
        assertEquals(0, instance08.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(8798);
        assertEquals(8798, instance.getId());
    }

    /**
     * Test of getCustomer method.
     */
    @Test
    public void testGetCustomer() {

        assertEquals(customer, instance.getCustomer());
        assertNull(instance05.getCustomer());
        assertNull(instance06.getCustomer());
        assertEquals(customer, instance07.getCustomer());
        assertNull(instance08.getCustomer());
    }

    /**
     * Test of setCustomer method.
     */
    @Test
    public void testSetCustomer() {

        CustomerPojo customer1 = Mockito.mock(CustomerPojo.class);
        instance.setCustomer(customer1);
        assertEquals(customer1, instance.getCustomer());
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetail, instance.getItemCommonDetail());
        assertNull(instance05.getItemCommonDetail());
        assertNull(instance06.getItemCommonDetail());
        assertEquals(itemCommonDetail, instance07.getItemCommonDetail());
        assertNull(instance08.getItemCommonDetail());
    }

    /**
     * Test of setItemCommonDetail method.
     */
    @Test
    public void testSetItemCommonDetail() {

        ItemCommonDetailPojo itemCommonDetail1 = Mockito.mock(ItemCommonDetailPojo.class);
        instance.setItemCommonDetail(itemCommonDetail1);
        assertEquals(itemCommonDetail1, instance.getItemCommonDetail());
    }

    /**
     * Test of getUnitNumber method.
     */
    @Test
    public void testGetUnitNumber() {

        assertEquals(21, instance.getUnitNumber());
        assertEquals(0, instance05.getUnitNumber());
        assertEquals(21, instance06.getUnitNumber());
        assertEquals(21, instance07.getUnitNumber());
        assertEquals(0, instance08.getUnitNumber());
    }

    /**
     * Test of setUnitNumber method.
     */
    @Test
    public void testSetUnitNumber() {

        instance.setUnitNumber(30);
        assertEquals(30, instance.getUnitNumber());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance08.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(shoppingCartItem));

        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance08.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(shoppingCartItem));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));

    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance08));
        assertTrue(instance08.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(shoppingCartItem));
        assertFalse(instance.equals(null));
    }
   
    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance09));
    } 
    
    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyShoppingCartItemPojo extends ShoppingCartItemPojo implements HibernateProxy {

        private static final long serialVersionUID = 171691979344627052L;
                
        private final ShoppingCartItemPojo pojo;

        public HibernateProxyShoppingCartItemPojo(ShoppingCartItemPojo pojo) {

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
                public ShoppingCartItemPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }

}
