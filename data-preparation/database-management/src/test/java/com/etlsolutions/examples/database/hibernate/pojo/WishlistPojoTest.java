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

import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class WishlistPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class WishlistPojoTest {

    private final int id = 23914;
    private final int id1 = 23314;
    private final CustomerPojo customerPojo = Mockito.mock(CustomerPojo.class);
    private final CustomerPojo customerPojo2 = Mockito.mock(CustomerPojo.class);
    private final String name = "wusgBane";
    private final String name3 = "ppppec";
    private final ItemCommonDetailPojo itemCommonDetailPojo1 = Mockito.mock(ItemCommonDetailPojo.class);
    private final ItemCommonDetailPojo itemCommonDetailPojo2 = Mockito.mock(ItemCommonDetailPojo.class);
    private final ItemCommonDetailPojo itemCommonDetailPojo3 = Mockito.mock(ItemCommonDetailPojo.class);
    private final ItemCommonDetailPojo itemCommonDetailPojo4 = Mockito.mock(ItemCommonDetailPojo.class);
    private final Set<ItemCommonDetail> itemCommonDetailPojos = new HashSet<>(Arrays.asList(itemCommonDetailPojo1, itemCommonDetailPojo2, itemCommonDetailPojo3));
    private final Set<ItemCommonDetail> itemCommonDetailPojos4 = new HashSet<>(Arrays.asList(itemCommonDetailPojo1, itemCommonDetailPojo4));
    private final Set<ItemCommonDetail> itemCommonDetailPojos5 = null;

    private final Wishlist wishlist = Mockito.mock(Wishlist.class);

    private final WishlistPojo instance = new WishlistPojo(id, customerPojo, name, itemCommonDetailPojos);
    private final WishlistPojo instance00 = new WishlistPojo(id, customerPojo, name, itemCommonDetailPojos);
    private final WishlistPojo instance01 = new WishlistPojo(id1, customerPojo, name, itemCommonDetailPojos);
    private final WishlistPojo instance02 = new WishlistPojo(id, customerPojo2, name, itemCommonDetailPojos);
    private final WishlistPojo instance03 = new WishlistPojo(id, customerPojo, name3, itemCommonDetailPojos);
    private final WishlistPojo instance04 = new WishlistPojo(id, customerPojo, name, itemCommonDetailPojos4);
    private final WishlistPojo instance05 = new WishlistPojo(id, customerPojo, name, itemCommonDetailPojos5);
    private final WishlistPojo instance06 = new WishlistPojo();
    private final WishlistPojo instance07 = new WishlistPojo(customerPojo, name);
    private final WishlistPojo instance08 = new WishlistPojo(id, customerPojo, name);
    private final WishlistPojo instance09 = new HibernateProxyWishlistPojo(new WishlistPojo(id, customerPojo, name, itemCommonDetailPojos));
    private final WishlistPojo instance10 = new WishlistPojo(id, new CustomerPojo(), name);

    @Before
    public void setUp() {

        Mockito.when(wishlist.getCustomer()).thenReturn(customerPojo);
        Mockito.when(wishlist.getName()).thenReturn(name);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetId() {

        assertEquals(23914, instance.getId());
        assertEquals(0, instance06.getId());
        assertEquals(0, instance07.getId());
        assertEquals(23914, instance08.getId());
        assertEquals(0, instance09.getId());
    }

    @Test
    public void testSetId() {

        instance.setId(879);
        assertEquals(879, instance.getId());
    }

    @Test
    public void testGetCustomer() {

        assertEquals(customerPojo, instance.getCustomer());
        assertNull(instance06.getCustomer());
        assertEquals(customerPojo, instance07.getCustomer());
        assertEquals(customerPojo, instance08.getCustomer());
        assertNull(instance09.getCustomer());
    }

    @Test
    public void testSetCustomer() {

        CustomerPojo customer = new CustomerPojo();
        instance.setCustomer(customer);
        assertEquals(customer, instance.getCustomer());
    }

    @Test
    public void testGetName() {

        assertEquals("wusgBane", instance.getName());
        assertNull(instance06.getName());
        assertEquals("wusgBane", instance07.getName());
        assertEquals("wusgBane", instance08.getName());
        assertNull(instance09.getName());
    }

    @Test
    public void testSetName() {

        instance.setName("setName");
        assertEquals("setName", instance.getName());
    }

    @Test
    public void testGetItemCommonDetails() {

        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetailPojo1, itemCommonDetailPojo2, itemCommonDetailPojo3)), instance.getItemCommonDetails());
        instance.getItemCommonDetails().clear();
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetailPojo1, itemCommonDetailPojo2, itemCommonDetailPojo3)), instance.getItemCommonDetails());
        itemCommonDetailPojos.clear();
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetailPojo1, itemCommonDetailPojo2, itemCommonDetailPojo3)), instance.getItemCommonDetails());

        assertNull(instance05.getItemCommonDetails());
        assertTrue(instance06.getItemCommonDetails().isEmpty());
        assertTrue(instance07.getItemCommonDetails().isEmpty());
        assertTrue(instance08.getItemCommonDetails().isEmpty());
        assertTrue(instance09.getItemCommonDetails().isEmpty());
    }

    @Test
    public void testSetItemCommonDetails() {

        Set<ItemCommonDetail> itemCommonDetails = new HashSet<>(Arrays.asList(itemCommonDetailPojo1));
        instance.setItemCommonDetails(itemCommonDetails);
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetailPojo1)), instance.getItemCommonDetails());

        itemCommonDetails.add(Mockito.mock(ItemCommonDetail.class));
        assertEquals(new HashSet<>(Arrays.asList(itemCommonDetailPojo1)), instance.getItemCommonDetails());

        instance.setItemCommonDetails(null);
        assertNull(instance.getItemCommonDetails());
    }

    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance09.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(wishlist));

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
        assertTrue(instance.hasSameParameters(instance04));
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance09.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(wishlist));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());

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

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance04));
        assertTrue(instance.equals(instance09));
        assertTrue(instance09.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(wishlist));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("WishlistPojo{id=23914, customer=null, name=wusgBane}", instance.toString());
        Mockito.when(customerPojo.getUsername()).thenReturn("idanka");
        assertEquals("WishlistPojo{id=23914, customer=idanka, name=wusgBane}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance10));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyWishlistPojo extends WishlistPojo implements HibernateProxy {

        private static final long serialVersionUID = 15755437769380470L;
        private final WishlistPojo pojo;

        public HibernateProxyWishlistPojo(WishlistPojo pojo) {

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
                public WishlistPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }

}
