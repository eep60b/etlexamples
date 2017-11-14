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
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The WishlistEntity class is a simple implementation of the Wishlist
 * interface. It can represent an entry of the wishlist table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
public final class WishlistEntity implements Wishlist {

    private final CustomerEntity customer;
    private final String wishlistName;

    /**
     * Construct an object with the given Customer object and NameWrapper
     * object.
     *
     * @param customer - The given Customer object.
     * @param wishlistName - The NameWrapper object.
     * @throws NullPointerException if the Customer object is null.
     */
    public WishlistEntity(Customer customer, String wishlistName) {
        this.customer = customer instanceof CustomerEntity ? (CustomerEntity) customer : new CustomerEntity(customer);
        this.wishlistName = wishlistName;
    }

    /**
     * Construct an object with the given Customer object and name string.
     *
     * @param customer - The given Customer object.
     * @param wishlistName - The name string
     */
    public WishlistEntity(Customer customer, NameWrapper wishlistName) {
        this(customer, wishlistName.getValue());
    }

    /**
     * Construct an object with the given Wishlist object.
     *
     * @param wishlist - The specified Wishlist object.
     */
    public WishlistEntity(Wishlist wishlist) {
        this(wishlist.getCustomer(), wishlist.getName());
    }

    @Override
    public CustomerEntity getCustomer() {
        return customer;
    }

    @Override
    public String getName() {
        return wishlistName;
    }

    @Override
    public int hashCode() {

        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.customer);
        hash = 41 * hash + Objects.hashCode(this.wishlistName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final WishlistEntity other = (WishlistEntity) obj;

        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }

        return Objects.equals(this.wishlistName, other.wishlistName);
    }

    @Override
    public String toString() {

        return "WishlistEntity{name=" + getName() + ", customer=" + customer.getUsername() + '}';
    }

    @Override
    public boolean hasSameConstraint(Wishlist wishlist) {

        if (this == wishlist) {
            return true;
        }

        if (wishlist == null) {
            return false;
        }

        return Objects.equals(getName(), wishlist.getName()) && ConstrainableUtilities.hasSameConstraint(customer, wishlist.getCustomer());
    }

    @Override
    public boolean hasSameParameters(Wishlist wishlist) {
        if (this == wishlist) {
            return true;
        }

        if (wishlist == null) {
            return false;
        }

        return Objects.equals(getName(), wishlist.getName()) && ConstrainableUtilities.hasSameParameters(customer, wishlist.getCustomer());
    }
}
