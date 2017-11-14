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
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.data.constant.KeyNames;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.api.ItemCategoryLink;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.CategoryPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCategoryLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import java.util.Set;

/**
 * The ItemCategoryLinkProcessor class process the operations for an
 * ItemCategoryLink object passed in from the constructor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemCategoryLinkProcessor extends AbstractProcessor<ItemCategoryLink> {

    private final ItemCommonDetailProcessor itemCommonDetailProcessor;
    private final CategoryProcessor categoryProcessor;

    /**
     * Construct an object with the given facade object.
     *
     * @param facade - The given facade.
     */
    public ItemCategoryLinkProcessor(BookshopFacade facade) {
        super(facade);
        itemCommonDetailProcessor = new ItemCommonDetailProcessor(facade);
        categoryProcessor = new CategoryProcessor(facade);
    }

    @Override
    public ItemCategoryLinkPojo save(ItemCategoryLink itemCategoryLink) {

        ItemCategoryLinkPojo linkPojo = retrieve(itemCategoryLink);

        if (linkPojo == null) {

            ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.save(itemCategoryLink.getItemCommonDetail());
            CategoryPojo categoryPojo = categoryProcessor.save(itemCategoryLink.getCategory());

            Set<CategoryPojo> categories = itemCommonDetailPojo.getCategories();
            categories.add(categoryPojo);            
            itemCommonDetailPojo.setCategories(categories);
            
            Set<ItemCommonDetail> itemCommonDetails = categoryPojo.getItemCommonDetails();
            itemCommonDetails.add(itemCommonDetailPojo);
            categoryPojo.setItemCommonDetails(itemCommonDetails);

            facade.update(itemCommonDetailPojo, categoryPojo);
            linkPojo = new ItemCategoryLinkPojo(itemCommonDetailPojo, categoryPojo);
        }
        
        return linkPojo;
    }

    @Override
    public ItemCategoryLinkPojo retrieve(ItemCategoryLink itemCategoryLink) {

        ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.retrieve(itemCategoryLink.getItemCommonDetail());
        CategoryPojo categoryPojo = categoryProcessor.retrieve(itemCategoryLink.getCategory());

        if (itemCommonDetailPojo == null || categoryPojo == null) {
            return null;
        }

        if (facade.retrieveList(QueryNames.SELECT_FEOM_ITEM_CATEGORY_LINK,
                new StringKeyValuePair(KeyNames.ITEM_CATEGORY_LINK_ITEM_COMMON_DETAIL_ID, itemCommonDetailPojo.getId()),
                new StringKeyValuePair(KeyNames.ITEM_CATEGORY_LINK_CATEGORY_ID, categoryPojo.getId())).isEmpty()) {
            return null;
        }

        return new ItemCategoryLinkPojo(itemCommonDetailPojo, categoryPojo);

    }
}
