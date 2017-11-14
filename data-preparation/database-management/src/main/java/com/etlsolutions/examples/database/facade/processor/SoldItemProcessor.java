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
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.InvoicePojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.SoldItemPojo;

/**
 * The SoldItemProcessor class
 *
 * @author Zhipeng Chang
 */
public final class SoldItemProcessor extends AbstractIdentifiableEdentityProcessor<SoldItemPojo, SoldItem> {

    private final ItemCommonDetailProcessor itemCommonDetailProcessor;
    private final InvoiceProcessor invoiceProcessor;

    /**
     * Construct a SoldItemProcessor object using the given BookshopFacade
     * object.
     *
     * @param facade
     */
    public SoldItemProcessor(BookshopFacade facade) {

        super(facade);
        itemCommonDetailProcessor = new ItemCommonDetailProcessor(facade);
        invoiceProcessor = new InvoiceProcessor(facade);
    }

    @Override
    public SoldItemPojo retrieve(SoldItem soldItem) {

        ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.retrieve(soldItem.getItemCommonDetail());
        InvoicePojo invoicePojo = invoiceProcessor.retrieve(soldItem.getInvoice());

        if (itemCommonDetailPojo == null || invoicePojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_SOLD_ITEM_BY_UNIQUE_CONSTRAINT, soldItem,
                new StringKeyValuePair(KeyNames.SOLD_ITEM_COMMON_DETAIL, itemCommonDetailPojo), new StringKeyValuePair(KeyNames.SOLD_ITEM_INVOICE, invoicePojo));
    }

    @Override
    protected SoldItemPojo doSave(SoldItem soldItem) {
        SoldItemPojo pojo = retrieve(soldItem);

        if (pojo == null) {
            ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.save(soldItem.getItemCommonDetail());
            InvoicePojo invoicePojo = invoiceProcessor.save(soldItem.getInvoice());

            return new SoldItemPojo(itemCommonDetailPojo, invoicePojo, soldItem.getQuantity(), soldItem.getUnitPrice());
        }

        return pojo;
    }
}
