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

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.ItemCategoryLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableItemCategoryLink;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class ItemCategoryLinkPojo implements Serializable, IdentifiableItemCategoryLink {

    private static final long serialVersionUID = 937335098716315546L;

    private ItemCommonDetailPojo itemCommonDetail;
    private CategoryPojo category;

    public ItemCategoryLinkPojo() {
    }

    /**
     *
     * @param ItemCommonDetailPojo
     * @param category
     */
    public ItemCategoryLinkPojo(ItemCommonDetailPojo ItemCommonDetailPojo, CategoryPojo category) {
        this.itemCommonDetail = ItemCommonDetailPojo;
        this.category = category;
    }

    @Override
    public ItemCommonDetailPojo getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public CategoryPojo getCategory() {
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

        if (this instanceof HibernateProxy) {
            return itemCategoryLink.hasSameParameters(((ItemCategoryLink) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (itemCategoryLink instanceof HibernateProxy) {
            return hasSameConstraint(((ItemCategoryLink) (((HibernateProxy) itemCategoryLink).getHibernateLazyInitializer().getImplementation())));
        }

        if (!ConstrainableUtilities.hasSameConstraint(itemCommonDetail, itemCategoryLink.getItemCommonDetail())) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(category, itemCategoryLink.getCategory());
    }

    @Override
    public boolean hasSameParameters(ItemCategoryLink itemCategoryLink) {

        if (this == itemCategoryLink) {
            return true;
        }

        if (itemCategoryLink == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return itemCategoryLink.hasSameParameters(((ItemCategoryLink) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (itemCategoryLink instanceof HibernateProxy) {
            return hasSameParameters(((ItemCategoryLink) (((HibernateProxy) itemCategoryLink).getHibernateLazyInitializer().getImplementation())));
        }

        if (!ConstrainableUtilities.hasSameParameters(itemCommonDetail, itemCategoryLink.getItemCommonDetail())) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(category, itemCategoryLink.getCategory());
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 73 * hash + Objects.hashCode(this.category);
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

        final ItemCategoryLinkPojo other = (ItemCategoryLinkPojo) obj;

        if (!Objects.equals(this.itemCommonDetail, other.itemCommonDetail)) {
            return false;
        }

        return Objects.equals(this.category, other.category);
    }

    @Override
    public int getItemCommonDetailId() {
        return itemCommonDetail == null ? 0 : itemCommonDetail.getId();
    }

    @Override
    public int getCategoryId() {
        return category == null ? 0 : category.getId();
    }
}
