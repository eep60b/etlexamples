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
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.InvoicePojo;

/**
 * The InvoiceProcessor class contains methods which save the operations which
 * are related to the invoice column in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class InvoiceProcessor extends AbstractIdentifiableEdentityProcessor<InvoicePojo, Invoice> {

    /**
     * Construct an InvoiceProcessor object using the given BookshopFacade object.
     *
     * @param facade
     */
    public InvoiceProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    protected InvoicePojo doSave(Invoice invoice) {

        InvoicePojo pojo = retrieve(invoice);
        if (pojo == null) {
            CustomerPojo customer = new CustomerProcessor(facade).save(invoice.getCustomer());
            AddressPojo address = new AddressProcessor(facade).save(invoice.getDeliveryAddress());
            pojo = new InvoicePojo(customer, address, invoice.getInvoiceDate(), invoice.getTotal(), invoice.getValidity(), invoice.getReferenceNumber());
        }

        return pojo;
    }

    @Override
    public InvoicePojo retrieve(Invoice invoice) {

        return findConstraintableWithSameParameters(QueryNames.FIND_INVOICE_BY_UNIQUE_CONSTRAINT, invoice,
                new StringKeyValuePair(KeyNames.INVOICE_REFERENCE_NUMBER, invoice.getReferenceNumber()));
    }
}
