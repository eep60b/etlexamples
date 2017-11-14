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

import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.data.api.ItemCategoryLink;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import java.util.Objects;

/**
 * The ItemCategoryLinkEntity class represents a link between an item and a
 * category.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemCategoryLinkEntity implements ItemCategoryLink {

    private final ItemCommonDetailEntity itemCommonDetail;
    private final CategoryEntity category;

    /**
     *
     * @param itemCommonDetail
     * @param category
     */
    public ItemCategoryLinkEntity(ItemCommonDetail itemCommonDetail, Category category) {

        this.itemCommonDetail = itemCommonDetail instanceof ItemCommonDetailEntity ? (ItemCommonDetailEntity) itemCommonDetail : new ItemCommonDetailEntity(itemCommonDetail);
        this.category = category instanceof CategoryEntity ? (CategoryEntity) category : new CategoryEntity(new NameWrapper(category.getName()));
    }

    /**
     * Construct an object using the given ItemCategoryLink object.
     * @param itemCategoryLink 
     */
    public ItemCategoryLinkEntity(ItemCategoryLink itemCategoryLink) {
        this(itemCategoryLink.getItemCommonDetail(), itemCategoryLink.getCategory());
    }

    @Override
    public ItemCommonDetailEntity getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public CategoryEntity getCategory() {
        return category;
    }

    @Override
    public boolean hasSameConstraint(ItemCategoryLink itemCategoryLink) {

        if (this == itemCategoryLink) {
            return true;
        }

        if (itemCategoryLink == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(category, itemCategoryLink.getCategory())
                && ConstrainableUtilities.hasSameConstraint(itemCommonDetail, itemCategoryLink.getItemCommonDetail());
    }

    @Override
    public boolean hasSameParameters(ItemCategoryLink itemCategoryLink) {

        if (this == itemCategoryLink) {
            return true;
        }

        if (itemCategoryLink == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(category, itemCategoryLink.getCategory())
                && ConstrainableUtilities.hasSameParameters(itemCommonDetail, itemCategoryLink.getItemCommonDetail());
     }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 41 * hash + Objects.hashCode(this.category);
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

        final ItemCategoryLinkEntity other = (ItemCategoryLinkEntity) obj;
        
        return Objects.equals(this.category, other.category) && Objects.equals(this.itemCommonDetail, other.itemCommonDetail);
    }

    @Override
    public String toString() {
        return "ItemCategoryLinkEntity{item barcode=" + itemCommonDetail == null ? null : itemCommonDetail.getBarcode() + ", category name=" + category == null ? null : category.getName() + '}';
    }
}
