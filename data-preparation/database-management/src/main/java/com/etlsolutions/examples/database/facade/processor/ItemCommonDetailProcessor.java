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
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;

/**
 * The ItemCommonDetailProcessor class process the operations for an
 * ItemCommonDetail object.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemCommonDetailProcessor extends AbstractIdentifiableEdentityProcessor<ItemCommonDetailPojo, ItemCommonDetail> {

    /**
     * Construct an object using the given facade object.
     *
     * @param facade - The given facade.
     */
    public ItemCommonDetailProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    public ItemCommonDetailPojo retrieve(ItemCommonDetail itemCommonDetail) {

        return findConstraintableWithSameParameters(QueryNames.FIND_ITEM_COMMON_DETAIL_BY_UNIQUE_CONSTRAINT, itemCommonDetail,
                new StringKeyValuePair(KeyNames.ITEM_COMMON_DETAIL_BARCODE, itemCommonDetail.getBarcode()));
    }

    @Override
    protected ItemCommonDetailPojo doSave(ItemCommonDetail itemCommonDetail) {

        ItemCommonDetailPojo pojo = retrieve(itemCommonDetail);
        return pojo == null ? new ItemCommonDetailPojo(itemCommonDetail) : pojo;
    }
}
