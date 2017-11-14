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

import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.data.api.WishlistItemLink;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
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
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({WishlistItemLinkEntity.class, ItemCommonDetailEntity.class, WishlistEntity.class})
public final class WishlistItemLinkEntityTest {

    private final ItemCommonDetailEntity itemCommonDetailEntity = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetailEntity itemCommonDetailEntity1 = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);
    private final WishlistEntity wishlistEntity = PowerMockito.mock(WishlistEntity.class);
    private final WishlistEntity wishlistEntity2 = PowerMockito.mock(WishlistEntity.class);
    private final Wishlist wishlist = Mockito.mock(Wishlist.class);
    private final WishlistItemLink wishlistItemLink = Mockito.mock(WishlistItemLink.class);

    private final WishlistItemLinkEntity instance = new WishlistItemLinkEntity(itemCommonDetailEntity, wishlistEntity);
    private final WishlistItemLinkEntity instance00 = new WishlistItemLinkEntity(itemCommonDetailEntity, wishlistEntity);
    private final WishlistItemLinkEntity instance01 = new WishlistItemLinkEntity(itemCommonDetailEntity1, wishlistEntity);
    private final WishlistItemLinkEntity instance02 = new WishlistItemLinkEntity(itemCommonDetailEntity, wishlistEntity2);
    private WishlistItemLinkEntity instance03;
    private WishlistItemLinkEntity instance04;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(ItemCommonDetailEntity.class).withArguments(itemCommonDetail).thenReturn(itemCommonDetailEntity);
        PowerMockito.whenNew(WishlistEntity.class).withArguments(wishlist).thenReturn(wishlistEntity);
        Mockito.when(wishlistItemLink.getItemCommonDetail()).thenReturn(itemCommonDetailEntity);
        Mockito.when(wishlistItemLink.getWishlist()).thenReturn(wishlistEntity);

        instance03 = new WishlistItemLinkEntity(itemCommonDetail, wishlist);
        instance04 = new WishlistItemLinkEntity(wishlistItemLink);
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
     * Test of getWishlist method.
     */
    @Test
    public void testGetWishlist() {

        assertEquals(wishlistEntity, instance.getWishlist());
        assertEquals(wishlistEntity, instance03.getWishlist());
        assertEquals(wishlistEntity, instance04.getWishlist());
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
        assertTrue(instance.hasSameConstraint(wishlistItemLink));

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
        assertTrue(instance.hasSameParameters(wishlistItemLink));

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
        assertFalse(instance.equals(wishlistItemLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("", instance.toString());
    }
}
