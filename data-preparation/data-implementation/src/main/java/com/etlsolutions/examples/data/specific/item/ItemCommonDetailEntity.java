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
package com.etlsolutions.examples.data.specific.item;

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The ItemCommonDetailEntity class represent an entry of the ITEM_COMMON_DETAIL
 * table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class ItemCommonDetailEntity implements ItemCommonDetail {

    private final CurrencyCode currencyCode;
    private final AvailabilityType availabilityType;
    private final int availabilityNumber;
    private final String description;
    private final ItemImage image;
    private final String name;
    private final int ranking;
    private final ListPrice listPrice;
    private final SalePrice salePrice;
    private final String barcode;

    /**
     * Construct an object using the given parameters.
     *
     * @param currencyCode - The currency code.
     * @param availabilityType
     * @param availabilityNumber - How many is this kind of items available.
     * @param description - The item description.
     * @param image - The item image.
     * @param name - The item name.
     * @param ranking - The item ranking.
     * @param listPrice - The list price.
     * @param salePrice - The sale price.
     * @param barcode - The item barcode.
     */
    private ItemCommonDetailEntity(CurrencyCode currencyCode, AvailabilityType availabilityType, int availabilityNumber, String description, ItemImage image, String name, int ranking, ListPrice listPrice, SalePrice salePrice, String barcode) {
        
        this.currencyCode = currencyCode;
        this.availabilityType = availabilityType;
        this.availabilityNumber = availabilityNumber;
        this.description = description;
        this.image = image;
        this.name = name;
        this.ranking = ranking;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.barcode = barcode;
    }

    /**
     * Construct an object using the given parameters.
     *
     * @param currencyCode - The currency code.
     * @param availabilityType
     * @param availabilityNumber - How many is this kind of items available.
     * @param description - The item description.
     * @param image - The item image.
     * @param name - The item name.
     * @param ranking - The item ranking.
     * @param listPrice - The list price.
     * @param salePrice - The sale price.
     * @param barcode - The item barcode.
     */
    public ItemCommonDetailEntity(CurrencyCode currencyCode, AvailabilityType availabilityType, ItemAvailabilityNumber availabilityNumber, ItemDescription description, ItemImage image, NameWrapper name, ItemRanking ranking, ListPrice listPrice, SalePrice salePrice, ItemBarcode barcode) {
        
        this.currencyCode = currencyCode;
        this.availabilityType = availabilityType;
        this.availabilityNumber = availabilityNumber.getValue();
        this.description = description.getValue();
        this.image = image;
        this.name = name.getValue();
        this.ranking = ranking.getValue();
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.barcode = barcode.getValue();
    }

    /**
     * Construct an object using information in the given ItemCommonDetail
     * object.
     *
     * @param itemCommonDetail - The given ItemCommonDetail object.
     */
    public ItemCommonDetailEntity(ItemCommonDetail itemCommonDetail) {
        
        this(itemCommonDetail.getCurrencyCode(), itemCommonDetail.getAvailability(), itemCommonDetail.getAvailabilityNumber(), itemCommonDetail.getDescription(),
                new ItemImage(itemCommonDetail.getImage()), itemCommonDetail.getName(), itemCommonDetail.getRanking(), new ListPrice(itemCommonDetail.getListPrice()),
                new SalePrice(itemCommonDetail.getSalePrice()), itemCommonDetail.getBarcode());
    }

    @Override
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public AvailabilityType getAvailability() {
        return availabilityType;
    }

    @Override
    public int getAvailabilityNumber() {
        return availabilityNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public byte[] getImage() {
        return image.getValue();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRanking() {
        return ranking;
    }

    @Override
    public BigDecimal getListPrice() {
        return listPrice.getValue();
    }

    @Override
    public BigDecimal getSalePrice() {
        return salePrice.getValue();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.currencyCode);
        hash = 37 * hash + Objects.hashCode(this.availabilityType);
        hash = 37 * hash + Objects.hashCode(this.availabilityNumber);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.ranking);
        hash = 37 * hash + Objects.hashCode(this.barcode);
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

        final ItemCommonDetailEntity other = (ItemCommonDetailEntity) obj;

        if (this.currencyCode != other.currencyCode) {
            return false;
        }

        if (this.availabilityType != other.availabilityType) {
            return false;
        }

        if (!Objects.equals(this.availabilityNumber, other.availabilityNumber)) {
            return false;
        }

        if (!Objects.equals(this.description, other.description)) {
            return false;
        }

        if (!Objects.equals(this.image, other.image)) {
            return false;
        }

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        if (!Objects.equals(this.ranking, other.ranking)) {
            return false;
        }

        if (!Objects.equals(this.listPrice, other.listPrice)) {
            return false;
        }

        if (!Objects.equals(this.salePrice, other.salePrice)) {
            return false;
        }

        return Objects.equals(this.barcode, other.barcode);
    }

    @Override
    public String toString() {
        return "ItemCommonDetailEntity{" + "name=" + getName() + '}';
    }

    @Override
    public String getBarcode() {
        return barcode;
    }

    @Override
    public boolean hasSameConstraint(ItemCommonDetail itemCommonDetail) {

        if (this == itemCommonDetail) {
            return true;
        }

        if (itemCommonDetail == null) {
            return false;
        }

        return Objects.equals(barcode, itemCommonDetail.getBarcode());
    }

    @Override
    public boolean hasSameParameters(ItemCommonDetail itemCommonDetail) {

        if (this == itemCommonDetail) {
            return true;
        }

        if (itemCommonDetail == null) {
            return false;
        }

        if (currencyCode != itemCommonDetail.getCurrencyCode()) {
            return false;
        }

        if (availabilityType != itemCommonDetail.getAvailability()) {
            return false;
        }

        if (getAvailabilityNumber() != itemCommonDetail.getAvailabilityNumber()) {
            return false;
        }

        if (!Objects.equals(getDescription(), itemCommonDetail.getDescription())) {
            return false;
        }

        if (!Objects.deepEquals(getImage(), itemCommonDetail.getImage())) {
            return false;
        }

        if (!Objects.equals(getName(), itemCommonDetail.getName())) {
            return false;
        }

        if (getRanking() != itemCommonDetail.getRanking()) {
            return false;
        }

        if (!Objects.equals(getListPrice(), itemCommonDetail.getListPrice())) {
            return false;
        }

        if (!Objects.equals(getSalePrice(), itemCommonDetail.getSalePrice())) {
            return false;
        }

        return Objects.equals(getBarcode(), itemCommonDetail.getBarcode());
    }
}
