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
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.WishlistPojo;

/**
 * The WishlistProcessor class contains methods which process operations
 * associated to the WISHLIST table in database.
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class WishlistProcessor extends AbstractIdentifiableEdentityProcessor<WishlistPojo, Wishlist> {

    private final CustomerProcessor customerProcessor;

    /**
     * Construct an object with the given BookshopFacade object. 
     *
     * @param facade - The given BookshopFacade object. 
     */
    public WishlistProcessor(BookshopFacade facade) {
        super(facade);
        customerProcessor = new CustomerProcessor(facade);
    }

    @Override
    public WishlistPojo retrieve(Wishlist wishlist) {

        CustomerPojo customer = customerProcessor.retrieve(wishlist.getCustomer());

        return findConstraintableWithSameParameters(QueryNames.FIND_WISHLIST_BY_UNIQUE_CONSTRAINT, wishlist, new StringKeyValuePair(KeyNames.WISHLIST_NAME, wishlist.getName()), new StringKeyValuePair(KeyNames.WISHLIST_CUSTOMER, customer));
    }

    @Override
    protected WishlistPojo doSave(Wishlist wishlist) {

        WishlistPojo pojo = retrieve(wishlist);
        
        if (pojo == null) {

            CustomerPojo customer = customerProcessor.save(wishlist.getCustomer());
            pojo = new WishlistPojo(customer, wishlist.getName());
        }

        return pojo;
    }
}
