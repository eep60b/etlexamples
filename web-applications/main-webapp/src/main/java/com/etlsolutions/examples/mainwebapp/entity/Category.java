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
package com.etlsolutions.examples.mainwebapp.entity;

import com.etlsolutions.examples.data.general.Nameable;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhipeng
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryId", query = "SELECT c FROM Category c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "Category.findByCategoryName", query = "SELECT c FROM Category c WHERE c.name = :categoryName")})
public class Category implements Serializable, Nameable {

    private static final long serialVersionUID = 574398774788873989L;
    // @Max(value=?)  //if you know range of your decimal fields consider using these annotations to enforce field validation
    @Min(value = 1)
    @Id
    @Basic(optional = false)
    @Column(name = "category_id")
    private int categoryId;
    @Basic(optional = false)
    @Column(name = "category_name")
    private String name;
    @JoinTable(name = "item_category_link", joinColumns = {
        @JoinColumn(name = "category_id", referencedColumnName = "category_id")}, inverseJoinColumns = {
        @JoinColumn(name = "item_common_detail_id", referencedColumnName = "item_common_detail_id")})
    @ManyToMany
    private Collection<ItemCommonDetail> itemCommonDetailCollection;

    public Category() {
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.name = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<ItemCommonDetail> getItemCommonDetailCollection() {
        return itemCommonDetailCollection;
    }

    public void setItemCommonDetailCollection(Collection<ItemCommonDetail> itemCommonDetailCollection) {
        this.itemCommonDetailCollection = itemCommonDetailCollection;
    }

    @Override
    public int hashCode() {
        return categoryId;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        return this.categoryId == other.categoryId;
        }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.Category[ categoryId=" + categoryId + " ]";
    }
}
