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
import java.math.BigDecimal;
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
@Table(name = "sold_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoldItem.findAll", query = "SELECT s FROM SoldItem s"),
    @NamedQuery(name = "SoldItem.findBySoldItemId", query = "SELECT s FROM SoldItem s WHERE s.soldItemId = :soldItemId"),
    @NamedQuery(name = "SoldItem.findByQuantity", query = "SELECT s FROM SoldItem s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SoldItem.findByUnitPrice", query = "SELECT s FROM SoldItem s WHERE s.unitPrice = :unitPrice")})
public class SoldItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sold_item_id")
    private Integer soldItemId;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    @ManyToOne
    private Invoice invoiceId;
    @JoinColumn(name = "item_common_detail_id", referencedColumnName = "item_common_detail_id")
    @ManyToOne
    private ItemCommonDetail itemCommonDetailId;

    public SoldItem() {
    }

    public SoldItem(Integer soldItemId) {
        this.soldItemId = soldItemId;
    }

    public SoldItem(Integer soldItemId, int quantity, BigDecimal unitPrice) {
        this.soldItemId = soldItemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Integer getSoldItemId() {
        return soldItemId;
    }

    public void setSoldItemId(Integer soldItemId) {
        this.soldItemId = soldItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
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
        hash += (soldItemId != null ? soldItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoldItem)) {
            return false;
        }
        SoldItem other = (SoldItem) object;
        if ((this.soldItemId == null && other.soldItemId != null) || (this.soldItemId != null && !this.soldItemId.equals(other.soldItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.entity.SoldItem[ soldItemId=" + soldItemId + " ]";
    }
    
}
