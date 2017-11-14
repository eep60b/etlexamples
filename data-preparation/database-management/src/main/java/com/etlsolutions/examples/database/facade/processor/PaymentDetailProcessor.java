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
 * distributed under the License idObjects distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.data.constant.KeyNames;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.InvoicePojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailIdPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The PaymentDetailProcessor class
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaymentDetailProcessor extends AbstractProcessor<PaymentDetail> {

    private final InvoiceProcessor invoiceProcessor;

    /**
     * Construct an object using the given facade.
     *
     * @param facade - The facade to be used.
     */
    public PaymentDetailProcessor(BookshopFacade facade) {
        super(facade);
        invoiceProcessor = new InvoiceProcessor(facade);
    }

    @Override
    public PaymentDetailPojo retrieve(PaymentDetail paymentDetail) {

        InvoicePojo invoice = invoiceProcessor.retrieve(paymentDetail.getInvoice());

        if (invoice == null) {
            return null;
        }

        List<PaymentDetailPojo> list = facade.retrieveList(QueryNames.FIND_PAYMENT_DETAIL_BY_UNIQUE_CONSTRAINT, new StringKeyValuePair(KeyNames.PAYMENT_INVOICE, invoice), new StringKeyValuePair(KeyNames.PAYMENT_TYPE, paymentDetail.getPaymentType()));
        for (PaymentDetailPojo pojo : list) {
            if (pojo.hasSameParameters(paymentDetail)) {
                return pojo;
            }
            throw new IllegalStateException("Error - There is an entry in the database with the same constraints as the object to be retrieved but some of its parameters are NOT the sase as the object to be retrieved .");
        }

        return null;
    }

    @Override
    public PaymentDetailPojo save(PaymentDetail paymentDetail) {

        PaymentDetailPojo pojo = retrieve(paymentDetail);
        if (pojo == null) {
            pojo = createPojo(paymentDetail);

            //There should be only one ID in the list. Therefore we don't check the list.
            List<Object> idObjects = facade.save(pojo);
            
            pojo.setIdObject((PaymentDetailIdPojo)idObjects.get(0));
        }

        return pojo;
    }

    public PaymentDetailPojo createPojo(PaymentDetail paymentDetail) {

        InvoicePojo invoice = invoiceProcessor.save(paymentDetail.getInvoice());

        List<PaymentDetailIdPojo> paymentDetailIdPojos = facade.retrieveList(QueryNames.FIND_ALL_PAYMENT_DETAIL_IDS);

        Set<Integer> ids = new HashSet<>();
        paymentDetailIdPojos.stream().forEach((paymentDetailIdPojo) -> {
            ids.add(paymentDetailIdPojo.getId());
        });
        
        PaymentType type = paymentDetail.getPaymentType();
        PaymentDetailIdPojo paymentDetailIdPojo = paymentDetailIdPojos.isEmpty() ? new PaymentDetailIdPojo(1, type) : new PaymentDetailIdPojo(paymentDetailIdPojos.size(), type);
        int id = paymentDetailIdPojo.getId();
        while (ids.contains(paymentDetailIdPojo.getId())) {
            paymentDetailIdPojo = new PaymentDetailIdPojo(id + 1, type);
        }

        return new PaymentDetailPojo(paymentDetailIdPojo, invoice, paymentDetail.getSubtotal(), paymentDetail.getCurrencyCode());

    }
}
