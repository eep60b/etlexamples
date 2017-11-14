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
import com.etlsolutions.examples.data.api.ShoppingCartItem;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ShoppingCartItemPojo;

/**
 * The ShoppingCartItemProcessor class contains methods which process operations
 * associated to the SHOPPING_CART table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ShoppingCartItemProcessor extends AbstractIdentifiableEdentityProcessor<ShoppingCartItemPojo, ShoppingCartItem> {

    private final ItemCommonDetailProcessor itemCommonDetailProcessor;
    private final CustomerProcessor customerProcessor;

    /**
     * Construct an object using the given BookshopFacade object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public ShoppingCartItemProcessor(BookshopFacade facade) {

        super(facade);
        itemCommonDetailProcessor = new ItemCommonDetailProcessor(facade);
        customerProcessor = new CustomerProcessor(facade);
    }

    @Override
    public ShoppingCartItemPojo retrieve(ShoppingCartItem shoppingCartItem) {

        ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.retrieve(shoppingCartItem.getItemCommonDetail());
        CustomerPojo customerPojo = customerProcessor.retrieve(shoppingCartItem.getCustomer());

        if (itemCommonDetailPojo == null || customerPojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_SHOPPING_CART_ITEM_BY_UNIQUE_CONSTRAINT, shoppingCartItem,
                new StringKeyValuePair(KeyNames.SHOPPING_CART_ITEM_COMMON_DETAIL, itemCommonDetailPojo),
                new StringKeyValuePair(KeyNames.SHOPPING_CART_ITEM_CUSTOMER, customerPojo));
    }

    @Override
    protected ShoppingCartItemPojo doSave(ShoppingCartItem shoppingCartItem) {

        ShoppingCartItemPojo pojo = retrieve(shoppingCartItem);

        if (pojo == null) {
            ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.save(shoppingCartItem.getItemCommonDetail());
            CustomerPojo customerPojo = customerProcessor.save(shoppingCartItem.getCustomer());
            return new ShoppingCartItemPojo(customerPojo, itemCommonDetailPojo, shoppingCartItem.getUnitNumber());
        }

        return pojo;
    }
}
