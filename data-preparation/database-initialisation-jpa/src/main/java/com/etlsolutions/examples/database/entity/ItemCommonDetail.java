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
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "item_common_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCommonDetail.findAll", query = "SELECT i FROM ItemCommonDetail i"),
    @NamedQuery(name = "ItemCommonDetail.findByItemCommonDetailId", query = "SELECT i FROM ItemCommonDetail i WHERE i.itemCommonDetailId = :itemCommonDetailId"),
    @NamedQuery(name = "ItemCommonDetail.findByItemName", query = "SELECT i FROM ItemCommonDetail i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "ItemCommonDetail.findByListPrice", query = "SELECT i FROM ItemCommonDetail i WHERE i.listPrice = :listPrice"),
    @NamedQuery(name = "ItemCommonDetail.findBySalePrice", query = "SELECT i FROM ItemCommonDetail i WHERE i.salePrice = :salePrice"),
    @NamedQuery(name = "ItemCommonDetail.findByCurrencyCode", query = "SELECT i FROM ItemCommonDetail i WHERE i.currencyCode = :currencyCode"),
    @NamedQuery(name = "ItemCommonDetail.findByRanking", query = "SELECT i FROM ItemCommonDetail i WHERE i.ranking = :ranking"),
    @NamedQuery(name = "ItemCommonDetail.findByDescription", query = "SELECT i FROM ItemCommonDetail i WHERE i.description = :description"),
    @NamedQuery(name = "ItemCommonDetail.findByAvailability", query = "SELECT i FROM ItemCommonDetail i WHERE i.availability = :availability"),
    @NamedQuery(name = "ItemCommonDetail.findByAvailabilityNumber", query = "SELECT i FROM ItemCommonDetail i WHERE i.availabilityNumber = :availabilityNumber"),
    @NamedQuery(name = "ItemCommonDetail.findByBarcode", query = "SELECT i FROM ItemCommonDetail i WHERE i.barcode = :barcode")})
public class ItemCommonDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "item_common_detail_id")
    private Integer itemCommonDetailId;
    @Basic(optional = false)
    @Column(name = "item_name")
    private String itemName;
    @Lob
    @Column(name = "image")
    private byte[] image;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "list_price")
    private BigDecimal listPrice;
    @Basic(optional = false)
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @Basic(optional = false)
    @Column(name = "currency_code")
    private String currencyCode;
    @Basic(optional = false)
    @Column(name = "ranking")
    private int ranking;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "availability")
    private String availability;
    @Column(name = "availability_number")
    private Integer availabilityNumber;
    @Basic(optional = false)
    @Column(name = "barcode")
    private String barcode;
    @ManyToMany(mappedBy = "itemCommonDetailSet")
    private Set<Category> categorySet;
    @JoinTable(name = "wishlist_item_link", joinColumns = {
        @JoinColumn(name = "item_common_detail_id", referencedColumnName = "item_common_detail_id")}, inverseJoinColumns = {
        @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id")})
    @ManyToMany
    private Set<Wishlist> wishlistSet;
    @OneToOne(mappedBy = "itemCommonDetailId")
    private Book book;
    @OneToMany(mappedBy = "itemCommonDetailId")
    private Set<SoldItem> soldItemSet;
    @OneToMany(mappedBy = "itemCommonDetailId")
    private Set<Review> reviewSet;
    @OneToMany(mappedBy = "itemCommonDetailId")
    private Set<ShoppingCartItem> shoppingCartItemSet;

    public ItemCommonDetail() {
    }

    public ItemCommonDetail(Integer itemCommonDetailId) {
        this.itemCommonDetailId = itemCommonDetailId;
    }

    public ItemCommonDetail(Integer itemCommonDetailId, String itemName, BigDecimal listPrice, BigDecimal salePrice, String currencyCode, int ranking, String availability, String barcode) {
        this.itemCommonDetailId = itemCommonDetailId;
        this.itemName = itemName;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.currencyCode = currencyCode;
        this.ranking = ranking;
        this.availability = availability;
        this.barcode = barcode;
    }

    public Integer getItemCommonDetailId() {
        return itemCommonDetailId;
    }

    public void setItemCommonDetailId(Integer itemCommonDetailId) {
        this.itemCommonDetailId = itemCommonDetailId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Integer getAvailabilityNumber() {
        return availabilityNumber;
    }

    public void setAvailabilityNumber(Integer availabilityNumber) {
        this.availabilityNumber = availabilityNumber;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @XmlTransient
    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    @XmlTransient
    public Set<Wishlist> getWishlistSet() {
        return wishlistSet;
    }

    public void setWishlistSet(Set<Wishlist> wishlistSet) {
        this.wishlistSet = wishlistSet;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @XmlTransient
    public Set<SoldItem> getSoldItemSet() {
        return soldItemSet;
    }

    public void setSoldItemSet(Set<SoldItem> soldItemSet) {
        this.soldItemSet = soldItemSet;
    }

    @XmlTransient
    public Set<Review> getReviewSet() {
        return reviewSet;
    }

    public void setReviewSet(Set<Review> reviewSet) {
        this.reviewSet = reviewSet;
    }

    @XmlTransient
    public Set<ShoppingCartItem> getShoppingCartItemSet() {
        return shoppingCartItemSet;
    }

    public void setShoppingCartItemSet(Set<ShoppingCartItem> shoppingCartItemSet) {
        this.shoppingCartItemSet = shoppingCartItemSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCommonDetailId != null ? itemCommonDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCommonDetail)) {
            return false;
        }
        ItemCommonDetail other = (ItemCommonDetail) object;
        if ((this.itemCommonDetailId == null && other.itemCommonDetailId != null) || (this.itemCommonDetailId != null && !this.itemCommonDetailId.equals(other.itemCommonDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.entity.ItemCommonDetail[ itemCommonDetailId=" + itemCommonDetailId + " ]";
    }
    
}
