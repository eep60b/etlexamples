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
package com.etlsolutions.examples.data.specific.purchase;

import com.etlsolutions.examples.data.specific.purchase.ShoppingCartItemEntity;
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.ShoppingCartItem;
import com.etlsolutions.examples.data.general.wrapper.QuantityWapper;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class ShoppingCartItemEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ShoppingCartItemEntity.class, CustomerEntity.class, ItemCommonDetailEntity.class})
public final class ShoppingCartItemEntityTest {

    private final CustomerEntity customerEntity = PowerMockito.mock(CustomerEntity.class);
    private final CustomerEntity customerEntity1 = PowerMockito.mock(CustomerEntity.class);
    private final ItemCommonDetailEntity itemCommonDetailEntity = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetailEntity itemCommonDetailEntity2 = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final QuantityWapper quantity = new QuantityWapper(291);
    private final QuantityWapper quantityColumn3 = new QuantityWapper(665);

    private final ShoppingCartItem shoppingCartItem = Mockito.mock(ShoppingCartItem.class);
    private final Customer customer = Mockito.mock(Customer.class);
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);

    private final ShoppingCartItemEntity instance = new ShoppingCartItemEntity(customerEntity, itemCommonDetailEntity, quantity);
    private final ShoppingCartItemEntity instance0 = new ShoppingCartItemEntity(customerEntity, itemCommonDetailEntity, quantity);
    private final ShoppingCartItemEntity instance1 = new ShoppingCartItemEntity(customerEntity1, itemCommonDetailEntity, quantity);
    private final ShoppingCartItemEntity instance2 = new ShoppingCartItemEntity(customerEntity, itemCommonDetailEntity2, quantity);
    private final ShoppingCartItemEntity instance3 = new ShoppingCartItemEntity(customerEntity, itemCommonDetailEntity, quantityColumn3);
    private final ShoppingCartItemEntity instance4 = new ShoppingCartItemEntity(instance);
    private ShoppingCartItemEntity instance5;
    private ShoppingCartItemEntity instance6;
    private ShoppingCartItemEntity instance7;

    @Before
    public void setUp() throws Exception {

        Mockito.when(shoppingCartItem.getCustomer()).thenReturn(customerEntity);
        Mockito.when(shoppingCartItem.getItemCommonDetail()).thenReturn(itemCommonDetailEntity);
        Mockito.when(shoppingCartItem.getUnitNumber()).thenReturn(291);
        
        PowerMockito.whenNew(CustomerEntity.class).withArguments(customer).thenReturn(customerEntity);
        PowerMockito.whenNew(ItemCommonDetailEntity.class).withArguments(itemCommonDetail).thenReturn(itemCommonDetailEntity);
        
        
        instance5 = new ShoppingCartItemEntity(shoppingCartItem);
        instance6 = new ShoppingCartItemEntity(customer, itemCommonDetailEntity, quantity);
        instance7 = new ShoppingCartItemEntity(customerEntity, itemCommonDetail, quantity);
    }

    /**
     * Test of getCustomer method.
     */
    @Test
    public void testGetCustomer() {

        assertEquals(customerEntity, instance.getCustomer());
        assertEquals(customerEntity, instance4.getCustomer());
        assertEquals(customerEntity, instance5.getCustomer());
        assertEquals(customerEntity, instance6.getCustomer());
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetailEntity, instance.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance4.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance5.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance7.getItemCommonDetail());
    }

    /**
     * Test of getUnitNumber method.
     */
    @Test
    public void testGetUnitNumber() {

        assertTrue(instance.getUnitNumber() == 291);
        assertTrue(instance4.getUnitNumber() == 291);
        assertTrue(instance5.getUnitNumber() == 291);
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance0.hashCode(), instance.hashCode());
        assertEquals(instance4.hashCode(), instance.hashCode());
        assertEquals(instance5.hashCode(), instance.hashCode());
        assertEquals(instance6.hashCode(), instance.hashCode());
        assertEquals(instance7.hashCode(), instance.hashCode());

        assertNotEquals(instance1.hashCode(), instance.hashCode());
        assertNotEquals(instance2.hashCode(), instance.hashCode());
        assertNotEquals(instance3.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance0));
        assertTrue(instance.equals(instance4));
        assertTrue(instance.equals(instance5));
        assertTrue(instance.equals(instance6));
        assertTrue(instance.equals(instance7));

        assertFalse(instance.equals(instance1));
        assertFalse(instance.equals(instance2));
        assertFalse(instance.equals(instance3));
        assertFalse(instance.equals(shoppingCartItem));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        Mockito.when(customerEntity.hasSameConstraint(customer)).thenReturn(Boolean.TRUE);
        Mockito.when(customerEntity.hasSameConstraint(customerEntity)).thenReturn(Boolean.TRUE);
        Mockito.when(itemCommonDetailEntity.hasSameConstraint(itemCommonDetail)).thenReturn(Boolean.TRUE);
        Mockito.when(itemCommonDetailEntity.hasSameConstraint(itemCommonDetailEntity)).thenReturn(Boolean.TRUE);
        
        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance0));
        assertTrue(instance.hasSameConstraint(instance3));
        assertTrue(instance.hasSameConstraint(instance4));
        assertTrue(instance.hasSameConstraint(instance5));
        assertTrue(instance.hasSameConstraint(instance6));
        assertTrue(instance.hasSameConstraint(instance7));
        assertTrue(instance.hasSameConstraint(shoppingCartItem));

        assertFalse(instance.hasSameConstraint(instance1));
        assertFalse(instance.hasSameConstraint(instance2));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        Mockito.when(customerEntity.hasSameParameters(customer)).thenReturn(Boolean.TRUE);
        Mockito.when(customerEntity.hasSameParameters(customerEntity)).thenReturn(Boolean.TRUE);
        Mockito.when(itemCommonDetailEntity.hasSameParameters(itemCommonDetail)).thenReturn(Boolean.TRUE);
        Mockito.when(itemCommonDetailEntity.hasSameParameters(itemCommonDetailEntity)).thenReturn(Boolean.TRUE);
        
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance0));
        assertTrue(instance.hasSameParameters(instance4));
        assertTrue(instance.hasSameParameters(instance5));
        assertTrue(instance.hasSameParameters(instance6));
        assertTrue(instance.hasSameParameters(instance7));
        assertTrue(instance.hasSameParameters(shoppingCartItem));

        assertFalse(instance.hasSameParameters(instance1));
        assertFalse(instance.hasSameParameters(instance2));
        assertFalse(instance.hasSameParameters(instance3));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("ShoppingCartItemEntity{" + "customer=" + customerEntity + ", itemCommonDetail=" + itemCommonDetailEntity + '}', instance.toString());
    }
}
