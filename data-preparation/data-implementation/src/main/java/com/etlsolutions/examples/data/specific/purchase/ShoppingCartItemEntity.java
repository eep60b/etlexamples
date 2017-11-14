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
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.ShoppingCartItem;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.general.wrapper.QuantityWapper;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.util.Objects;

/**
 * The ShoppingCartItemEntity class represents a shopping cart.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ThreadSafe
@DataClass
public final class ShoppingCartItemEntity implements ShoppingCartItem {

    private final CustomerEntity customer;
    private final ItemCommonDetailEntity itemCommonDetail;
    private final int quantity;

    /**
     *
     * @param customer
     * @param itemCommonDetail
     * @param quantity
     */
    public ShoppingCartItemEntity(Customer customer, ItemCommonDetail itemCommonDetail, int quantity) {

        this.customer = customer instanceof CustomerEntity ? (CustomerEntity) customer : new CustomerEntity(new PersonAddressLinkEntity(customer.getPersonAddressLink()), new ImageBytes(customer.getImage()), new PersonalPassword(customer.getPassword()), new PersonalUsername(customer.getUsername()));
        this.itemCommonDetail = itemCommonDetail instanceof ItemCommonDetailEntity ? (ItemCommonDetailEntity) itemCommonDetail : new ItemCommonDetailEntity(itemCommonDetail);
        this.quantity = quantity;
    }    
        /**
     *
     * @param customer
     * @param itemCommonDetail
     * @param quantity
     */
    public ShoppingCartItemEntity(Customer customer, ItemCommonDetail itemCommonDetail, QuantityWapper quantity) {

        this.customer = customer instanceof CustomerEntity ? (CustomerEntity) customer : new CustomerEntity(customer);
        this.itemCommonDetail = itemCommonDetail instanceof ItemCommonDetailEntity ? (ItemCommonDetailEntity) itemCommonDetail : new ItemCommonDetailEntity(itemCommonDetail);
        this.quantity = quantity.getValue();
    }
    
    /**
     *
     * @param shoppingCartItem
     */
    public ShoppingCartItemEntity(ShoppingCartItem shoppingCartItem) {
        this(shoppingCartItem.getCustomer(), shoppingCartItem.getItemCommonDetail(), new QuantityWapper(shoppingCartItem.getUnitNumber()));
    }



    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public ItemCommonDetail getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public int getUnitNumber() {
        return quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.customer);
        hash = 89 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 89 * hash + this.quantity;
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

        if (getClass() != obj.getClass()) {
            return false;
        }

        final ShoppingCartItemEntity other = (ShoppingCartItemEntity) obj;

        return this.quantity == other.quantity && Objects.equals(this.itemCommonDetail, other.itemCommonDetail) && Objects.equals(this.customer, other.customer);
    }

    @Override
    public boolean hasSameConstraint(ShoppingCartItem shoppingCartItem) {

        if (this == shoppingCartItem) {
            return true;
        }

        if (shoppingCartItem == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(itemCommonDetail, shoppingCartItem.getItemCommonDetail()) && ConstrainableUtilities.hasSameConstraint(customer, shoppingCartItem.getCustomer());
    }

    @Override
    public boolean hasSameParameters(ShoppingCartItem shoppingCartItem) {

        if (this == shoppingCartItem) {
            return true;
        }

        if (shoppingCartItem == null) {
            return false;
        }

        if (getUnitNumber() != shoppingCartItem.getUnitNumber()) {
            return false;
        }

        if (!customer.hasSameParameters(shoppingCartItem.getCustomer())) {
            return false;
        }

        return itemCommonDetail.hasSameParameters(shoppingCartItem.getItemCommonDetail());
    }

    @Override
    public String toString() {
        return "ShoppingCartItemEntity{customer=" + customer + ", itemCommonDetail=" + itemCommonDetail + '}';
    }
}
