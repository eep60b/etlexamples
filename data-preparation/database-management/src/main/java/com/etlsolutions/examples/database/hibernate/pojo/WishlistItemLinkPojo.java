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

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.WishlistItemLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableWishlistItemLink;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 * The WishlistItemLinkPojo class represents a link between a wishlist and an item.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class WishlistItemLinkPojo implements Serializable, IdentifiableWishlistItemLink {

    private static final long serialVersionUID = 814716572566501260L;

    private ItemCommonDetailPojo itemCommonDetail;
    private WishlistPojo wishlist;

    public WishlistItemLinkPojo() {
    }

    public WishlistItemLinkPojo(WishlistPojo wishlist, ItemCommonDetailPojo itemCommonDetail) {
        this.itemCommonDetail = itemCommonDetail;
        this.wishlist = wishlist;
    }

    @Override
    public ItemCommonDetailPojo getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public WishlistPojo getWishlist() {
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

        if (this instanceof HibernateProxy) {
            return wishlistItemLink.hasSameConstraint(((WishlistItemLink) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (wishlistItemLink instanceof HibernateProxy) {
            return hasSameConstraint(((WishlistItemLink) (((HibernateProxy) wishlistItemLink).getHibernateLazyInitializer().getImplementation())));
        }
        
        return ConstrainableUtilities.hasSameConstraint(itemCommonDetail, wishlistItemLink.getItemCommonDetail()) && ConstrainableUtilities.hasSameConstraint(wishlist, wishlistItemLink.getWishlist());
    }

    @Override
    public boolean hasSameParameters(WishlistItemLink wishlistItemLink) {

        if (this == wishlistItemLink) {
            return true;
        }

        if (wishlistItemLink == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return wishlistItemLink.hasSameParameters(((WishlistItemLink) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (wishlistItemLink instanceof HibernateProxy) {
            return hasSameParameters(((WishlistItemLink) (((HibernateProxy) wishlistItemLink).getHibernateLazyInitializer().getImplementation())));
        }

        return ConstrainableUtilities.hasSameParameters(itemCommonDetail, wishlistItemLink.getItemCommonDetail()) && ConstrainableUtilities.hasSameParameters(wishlist, wishlistItemLink.getWishlist());
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 37 * hash + Objects.hashCode(this.wishlist);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if (obj instanceof HibernateProxy) {
            return equals(((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation());
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final WishlistItemLinkPojo other = (WishlistItemLinkPojo) obj;

        if (!Objects.equals(this.itemCommonDetail, other.itemCommonDetail)) {
            return false;
        }
        return Objects.equals(this.wishlist, other.wishlist);
    }

    @Override
    public String toString() {
        return "WishlistItemLinkPojo{item ID=" + (itemCommonDetail==null ? 0 : itemCommonDetail.getId()) + ", wishlist ID=" 
                + (wishlist == null ? 0 : wishlist.getId()) + '}';
    }

    @Override
    public int getItemCommonDetailId() {
        return itemCommonDetail == null ? 0 : itemCommonDetail.getId();
    }

    @Override
    public int getWishlistId() {
        return wishlist == null ? 0 : wishlist.getId();
    }
}
