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

import com.etlsolutions.examples.data.api.WishlistItemLink;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class WishlistItemLinkPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class WishlistItemLinkPojoTest {

    private final WishlistPojo wishlist = Mockito.mock(WishlistPojo.class);
    private final WishlistPojo wishlist1 = Mockito.mock(WishlistPojo.class);
    private final ItemCommonDetailPojo itemCommonDetail = Mockito.mock(ItemCommonDetailPojo.class);
    private final ItemCommonDetailPojo itemCommonDetail2 = Mockito.mock(ItemCommonDetailPojo.class);
    private final WishlistItemLink wishlistItemLink = Mockito.mock(WishlistItemLink.class);

    private final WishlistItemLinkPojo instance = new WishlistItemLinkPojo(wishlist, itemCommonDetail);
    private final WishlistItemLinkPojo instance00 = new WishlistItemLinkPojo(wishlist, itemCommonDetail);
    private final WishlistItemLinkPojo instance01 = new WishlistItemLinkPojo(wishlist1, itemCommonDetail);
    private final WishlistItemLinkPojo instance02 = new WishlistItemLinkPojo(wishlist, itemCommonDetail2);
    private final WishlistItemLinkPojo instance03 = new WishlistItemLinkPojo(null, null);
    private final WishlistItemLinkPojo instance04 = new WishlistItemLinkPojo();
    private final WishlistItemLinkPojo instance05 = new HibernateProxyWishlistItemLinkPojo(new WishlistItemLinkPojo(wishlist, itemCommonDetail));
    private final WishlistItemLinkPojo instance06 = new WishlistItemLinkPojo(new WishlistPojo(), new ItemCommonDetailPojo());    

    @Before
    public void setUp() {
        Mockito.when(wishlistItemLink.getItemCommonDetail()).thenReturn(itemCommonDetail);
        Mockito.when(wishlistItemLink.getWishlist()).thenReturn(wishlist);
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetail, instance.getItemCommonDetail());
        assertNull(instance03.getItemCommonDetail());
        assertNull(instance04.getItemCommonDetail());
        assertNull(instance05.getItemCommonDetail());
    }

    /**
     * Test of getWishlist method.
     */
    @Test
    public void testGetWishlist() {

        assertEquals(wishlist, instance.getWishlist());
        assertNull(instance03.getWishlist());
        assertNull(instance04.getWishlist());
        assertNull(instance05.getWishlist());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance05.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(wishlistItemLink));

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
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance05.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(wishlistItemLink));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());

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
        assertTrue(instance.equals(instance05));
        assertTrue(instance05.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(wishlistItemLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("WishlistItemLinkPojo{item ID=0, wishlist ID=0}", instance.toString());
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
    private final class HibernateProxyWishlistItemLinkPojo extends WishlistItemLinkPojo implements HibernateProxy {

        private static final long serialVersionUID = 7L;
        private final WishlistItemLinkPojo pojo;

        public HibernateProxyWishlistItemLinkPojo(WishlistItemLinkPojo pojo) {

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
                public WishlistItemLinkPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }

    /**
     * Test of getItemCommonDetailId method.
     */
    @Test
    public void testGetItemCommonDetailId() {
        
        Mockito.when(itemCommonDetail.getId()).thenReturn(9382);
        assertEquals(9382, instance.getItemCommonDetailId());
        
        assertEquals(0, instance03.getItemCommonDetailId());
    }

    /**
     * Test of getWishlistId method.
     */
    @Test
    public void testGetWishlistId() {
        
        Mockito.when(wishlist.getId()).thenReturn(56353);
        assertEquals(56353, instance.getWishlistId());
        
        assertEquals(0, instance03.getWishlistId());
    }
}
