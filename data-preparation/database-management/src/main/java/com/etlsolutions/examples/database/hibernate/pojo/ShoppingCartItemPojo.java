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
// Generated 19-Nov-2015 11:29:31 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.ShoppingCartItem;
import com.etlsolutions.examples.data.spi.ShoppingCartItemSpi;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 * The ShoppingCartItemPojo class is generated automatically then modified
 * manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.1.0 - Use the integer type for the field "shoppingCartId".
 * @version 1.1.1 - Change the field name from "shoppingCartId" to "id".
 * @veriion 1.2.0 - Add implementation of ShoppingCartItemSpi.
 */
public class ShoppingCartItemPojo implements Serializable, ShoppingCartItemSpi<CustomerPojo, ItemCommonDetailPojo> {

    private static final long serialVersionUID = 191575447119997870L;

    private int id;
    private CustomerPojo customer;
    private ItemCommonDetailPojo itemCommonDetail;
    private int unitNumber;

    /**
     * Construct an empty default object. All integer fields are zero. all the
     * set fields will be empty. All other fields are null.
     */
    public ShoppingCartItemPojo() {
    }

    /**
     * Construct an object with the given ID and the unit number.
     *
     * @param id - The given ID.
     * @param unitNumber - The unit number which indicates how many item in the
     * shopping cart.
     */
    public ShoppingCartItemPojo(int id, int unitNumber) {
        this.id = id;
        this.unitNumber = unitNumber;
    }

    /**
     * Construct an object using the given customer information, item
     * information and how many items of this kind in the shopping cart.
     *
     * @param customer
     * @param itemCommonDetail
     * @param unitNumber
     */
    public ShoppingCartItemPojo(CustomerPojo customer, ItemCommonDetailPojo itemCommonDetail, int unitNumber) {
        this.customer = customer;
        this.itemCommonDetail = itemCommonDetail;
        this.unitNumber = unitNumber;
    }

    /**
     *
     * @param id
     * @param customer
     * @param itemCommonDetail
     * @param unitNumber
     */
    public ShoppingCartItemPojo(int id, CustomerPojo customer, ItemCommonDetailPojo itemCommonDetail, int unitNumber) {
        this(customer, itemCommonDetail, unitNumber);
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public CustomerPojo getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(CustomerPojo customer) {
        this.customer = customer;
    }

    @Override
    public ItemCommonDetailPojo getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public void setItemCommonDetail(ItemCommonDetailPojo itemCommonDetail) {
        this.itemCommonDetail = itemCommonDetail;
    }

    @Override
    public int getUnitNumber() {
        return this.unitNumber;
    }

    @Override
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public boolean hasSameConstraint(ShoppingCartItem shoppingCartItem) {

        if (this == shoppingCartItem) {
            return true;
        }

        if (shoppingCartItem == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return shoppingCartItem.hasSameConstraint(((ShoppingCartItem) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (shoppingCartItem instanceof HibernateProxy) {
            return hasSameConstraint(((ShoppingCartItem) (((HibernateProxy) shoppingCartItem).getHibernateLazyInitializer().getImplementation())));
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

        if (this instanceof HibernateProxy) {
            return shoppingCartItem.hasSameParameters(((ShoppingCartItem) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (shoppingCartItem instanceof HibernateProxy) {
            return hasSameParameters(((ShoppingCartItem) (((HibernateProxy) shoppingCartItem).getHibernateLazyInitializer().getImplementation())));
        }

        if (unitNumber != shoppingCartItem.getUnitNumber()) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(itemCommonDetail, shoppingCartItem.getItemCommonDetail()) && ConstrainableUtilities.hasSameParameters(customer, shoppingCartItem.getCustomer());
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.customer);
        hash = 47 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 47 * hash + this.unitNumber;
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
        
        final ShoppingCartItemPojo other = (ShoppingCartItemPojo) obj;
        if (this.id != other.id) {
            return false;
        }
        
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        
        if (!Objects.equals(this.itemCommonDetail, other.itemCommonDetail)) {
            return false;
        }
        
        return this.unitNumber == other.unitNumber;
    }

    @Override
    public String toString() {
        return "ShoppingCartItemPojo{" + "customer=" + customer == null ? null : customer.getUsername() + ", item=" + itemCommonDetail == null ? null : itemCommonDetail.getName() + '}';
    }
    
    
}