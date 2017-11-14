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

import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.general.wrapper.QuantityWapper;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.utility.NumberUtilities;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The SoldItemEntity class represents an item which is sold.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SoldItemEntity implements SoldItem {

    private final InvoiceEntity invoice;
    private final ItemCommonDetailEntity itemCommonDetail;
    private final int quantity;
    private final UnitPrice unitprice;

    /**
     * Construct an AddressEntity object using the given parameters.
     *
     * @param invoice - The invoice of this item.
     * @param itemCommonDetail - The item detail.
     * @param quantity - How many items are sold in the invoice.
     * @param unitprice - The item price in the invoice.
     */
    public SoldItemEntity(Invoice invoice, ItemCommonDetail itemCommonDetail, int quantity, BigDecimal unitprice) {
        this.invoice = invoice instanceof InvoiceEntity ? (InvoiceEntity) invoice : new InvoiceEntity(invoice);
        this.itemCommonDetail = itemCommonDetail instanceof ItemCommonDetailEntity ? (ItemCommonDetailEntity) itemCommonDetail : new ItemCommonDetailEntity(itemCommonDetail);
        this.quantity = quantity;
        this.unitprice = new UnitPrice(unitprice);
    }
    
    /**
     * Construct an AddressEntity object using the given parameters.
     *
     * @param invoice - The invoice of this item.
     * @param itemCommonDetail - The item detail.
     * @param quantity - How many items are sold in the invoice.
     * @param unitprice - The item price in the invoice.
     */
    public SoldItemEntity(Invoice invoice, ItemCommonDetail itemCommonDetail, QuantityWapper quantity, UnitPrice unitprice) {
        this(invoice, itemCommonDetail, quantity.getValue(), unitprice.getValue());
    }

    /**
     * Construct an AddressEntity object using the given SoldItem object.
     * @param soldItem - The specified SoldItem object.
     * 
     * @throws NullPointerException if the specified SoldItem object is null.
     */
    public SoldItemEntity(SoldItem soldItem) {
        this(soldItem.getInvoice(), soldItem.getItemCommonDetail(), soldItem.getQuantity(), soldItem.getUnitPrice());
    }

    @Override
    public InvoiceEntity getInvoice() {
        return invoice;
    }

    @Override
    public ItemCommonDetailEntity getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getUnitPrice() {
        return unitprice == null ? null : unitprice.getValue();
    }

    @Override
    public int hashCode() {
        
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.quantity);
        hash = 17 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 17 * hash + Objects.hashCode(this.invoice);
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

        final SoldItemEntity other = (SoldItemEntity) obj;

        return this.quantity == other.quantity && Objects.equals(this.unitprice, other.unitprice) && Objects.equals(this.itemCommonDetail, other.itemCommonDetail) && Objects.equals(this.invoice, other.invoice);
    }

    @Override
    public boolean hasSameConstraint(SoldItem soldItem) {

        if (this == soldItem) {
            return true;
        }

        if (soldItem == null) {
            return false;
        }
        
        return ConstrainableUtilities.hasSameConstraint(invoice , soldItem.getInvoice()) && ConstrainableUtilities.hasSameConstraint(itemCommonDetail, soldItem.getItemCommonDetail());
    }

    @Override
    public boolean hasSameParameters(SoldItem soldItem) {

        if (this == soldItem) {
            return true;
        }

        if (soldItem == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(invoice , soldItem.getInvoice()) && ConstrainableUtilities.hasSameParameters(itemCommonDetail, soldItem.getItemCommonDetail()) && NumberUtilities.equals(getUnitPrice(), soldItem.getUnitPrice(), 2);
    }
}
