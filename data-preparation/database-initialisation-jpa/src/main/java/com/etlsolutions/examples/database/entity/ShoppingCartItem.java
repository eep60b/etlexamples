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
package com.etlsolutions.examples.database.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "shopping_cart_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingCartItem.findAll", query = "SELECT s FROM ShoppingCartItem s"),
    @NamedQuery(name = "ShoppingCartItem.findByShoppingCartItemId", query = "SELECT s FROM ShoppingCartItem s WHERE s.shoppingCartItemId = :shoppingCartItemId"),
    @NamedQuery(name = "ShoppingCartItem.findByUnitNumber", query = "SELECT s FROM ShoppingCartItem s WHERE s.unitNumber = :unitNumber")})
public class ShoppingCartItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "shopping_cart_item_id")
    private Integer shoppingCartItemId;
    @Basic(optional = false)
    @Column(name = "unit_number")
    private int unitNumber;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "item_common_detail_id", referencedColumnName = "item_common_detail_id")
    @ManyToOne
    private ItemCommonDetail itemCommonDetailId;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Integer shoppingCartItemId) {
        this.shoppingCartItemId = shoppingCartItemId;
    }

    public ShoppingCartItem(Integer shoppingCartItemId, int unitNumber) {
        this.shoppingCartItemId = shoppingCartItemId;
        this.unitNumber = unitNumber;
    }

    public Integer getShoppingCartItemId() {
        return shoppingCartItemId;
    }

    public void setShoppingCartItemId(Integer shoppingCartItemId) {
        this.shoppingCartItemId = shoppingCartItemId;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public ItemCommonDetail getItemCommonDetailId() {
        return itemCommonDetailId;
    }

    public void setItemCommonDetailId(ItemCommonDetail itemCommonDetailId) {
        this.itemCommonDetailId = itemCommonDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingCartItemId != null ? shoppingCartItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingCartItem)) {
            return false;
        }
        ShoppingCartItem other = (ShoppingCartItem) object;
        if ((this.shoppingCartItemId == null && other.shoppingCartItemId != null) || (this.shoppingCartItemId != null && !this.shoppingCartItemId.equals(other.shoppingCartItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.entity.ShoppingCartItem[ shoppingCartItemId=" + shoppingCartItemId + " ]";
    }
    
}
