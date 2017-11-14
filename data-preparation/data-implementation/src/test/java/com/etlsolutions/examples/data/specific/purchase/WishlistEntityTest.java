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

import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
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
 * Test of class WishlistEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({WishlistEntity.class, CustomerEntity.class})
public final class WishlistEntityTest {

    private final CustomerEntity customerEntity = PowerMockito.mock(CustomerEntity.class);
    private final CustomerEntity customerEntity1 = PowerMockito.mock(CustomerEntity.class);
    private final Customer customer = Mockito.mock(Customer.class);
    private final String name = "kdlyhh";
    private final String name2 = "8h3a8a";
    private final NameWrapper nameWrapper = new NameWrapper("kdlyhh");
    private final Wishlist wishlist = Mockito.mock(Wishlist.class);

    private final WishlistEntity instance = new WishlistEntity(customerEntity, name);
    private final WishlistEntity instance00 = new WishlistEntity(customerEntity, name);
    private final WishlistEntity instance01 = new WishlistEntity(customerEntity1, name);
    private final WishlistEntity instance02 = new WishlistEntity(customerEntity, name2);
    private final WishlistEntity instance03 = new WishlistEntity(customerEntity, nameWrapper);
    private WishlistEntity instance04;
    private WishlistEntity instance05;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(CustomerEntity.class).withArguments(customer).thenReturn(customerEntity);
        Mockito.when(wishlist.getCustomer()).thenReturn(customerEntity);
        Mockito.when(wishlist.getName()).thenReturn(name);

        instance04 = new WishlistEntity(customer, name);
        instance05 = new WishlistEntity(wishlist);
    }

    /**
     * Test of getCustomer method.
     */
    @Test
    public void testGetCustomer() {

        assertEquals(customerEntity, instance.getCustomer());
        assertEquals(customerEntity, instance03.getCustomer());
        assertEquals(customerEntity, instance04.getCustomer());
        assertEquals(customerEntity, instance05.getCustomer());
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {

        assertEquals("kdlyhh", instance.getName());
        assertEquals("kdlyhh", instance03.getName());
        assertEquals("kdlyhh", instance04.getName());
        assertEquals("kdlyhh", instance05.getName());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());

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

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(wishlist));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        Mockito.when(customerEntity.getUsername()).thenReturn("iasoo3");
        assertEquals("WishlistEntity{name=kdlyhh, customer=iasoo3}", instance.toString());

    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(wishlist));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(wishlist));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
    }

}
