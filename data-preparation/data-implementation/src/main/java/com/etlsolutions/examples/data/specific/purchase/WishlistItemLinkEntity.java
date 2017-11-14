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

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.data.api.WishlistItemLink;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 *
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
public final class WishlistItemLinkEntity implements WishlistItemLink {
    
    private final ItemCommonDetailEntity itemCommonDetail;
    private final WishlistEntity wishlist;

    /**
     * 
     * @param itemCommonDetail
     * @param wishlist 
     */
    public WishlistItemLinkEntity(ItemCommonDetail itemCommonDetail, Wishlist wishlist) {
        this.itemCommonDetail = itemCommonDetail instanceof ItemCommonDetailEntity ? (ItemCommonDetailEntity) itemCommonDetail : new ItemCommonDetailEntity(itemCommonDetail);
        this.wishlist = wishlist instanceof WishlistEntity ? (WishlistEntity) wishlist : new WishlistEntity(wishlist);
    }

    /**
     * 
     * @param wishlistItemLink 
     */
    public WishlistItemLinkEntity(WishlistItemLink wishlistItemLink) {
        this( wishlistItemLink.getItemCommonDetail(), wishlistItemLink.getWishlist());
    }

    @Override
    public ItemCommonDetailEntity getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public WishlistEntity getWishlist() {
        return wishlist;
    }

    @Override
    public boolean hasSameConstraint(WishlistItemLink wishlistItemLink) {

        if (this == wishlistItemLink) {
            return true;
        }

        if (wishlistItemLink == null) {
            return false;
        }
        
        return ConstrainableUtilities.hasSameConstraint(itemCommonDetail, wishlistItemLink.getItemCommonDetail())
                && ConstrainableUtilities.hasSameConstraint(wishlist, wishlistItemLink.getWishlist());

    }

    @Override
    public boolean hasSameParameters(WishlistItemLink wishlistItemLink) {

        if (this == wishlistItemLink) {
            return true;
        }

        if (wishlistItemLink == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(itemCommonDetail, wishlistItemLink.getItemCommonDetail())
                && ConstrainableUtilities.hasSameParameters(wishlist, wishlistItemLink.getWishlist());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 29 * hash + Objects.hashCode(this.wishlist);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final WishlistItemLinkEntity other = (WishlistItemLinkEntity) obj;
        
        if (!Objects.equals(this.itemCommonDetail, other.itemCommonDetail)) {
            return false;
        }
        
        return Objects.equals(this.wishlist, other.wishlist);
    }

    @Override
    public String toString() {
        return "WishlistItemLinkEntity{" + "itemCommonDetail=" + itemCommonDetail + ", wishlist=" + wishlist + '}';
    }
}
