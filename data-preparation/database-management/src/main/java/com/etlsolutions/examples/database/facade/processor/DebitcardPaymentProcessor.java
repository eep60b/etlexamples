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
import com.etlsolutions.examples.data.api.DebitcardPayment;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.DebitcardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;

/**
 * The DebitcardPaymentProcessor class contains methods to process the operations
 * associated to DEBITCARD_PAYMENT table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class DebitcardPaymentProcessor extends AbstractIdentifiableEdentityProcessor<DebitcardPaymentPojo, DebitcardPayment> {

    private final PaymentDetailProcessor paymentDetailProcessor;

    /**
     * 
     * @param facade 
     */
    public DebitcardPaymentProcessor(BookshopFacade facade) {
        super(facade);
        paymentDetailProcessor = new PaymentDetailProcessor(facade);
    }

    @Override
    public DebitcardPaymentPojo retrieve(DebitcardPayment debitcardPayment) {

        PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.retrieve(debitcardPayment.getPaymentDetail());

        if (paymentDetailPojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_DEBITCARD_PAYMENT_BY_UNIQUE_CONSTRAINT, debitcardPayment, new StringKeyValuePair(KeyNames.DEBITCARD_PAYMENT_PAYMENT_DETAIL, paymentDetailPojo));

    }

    @Override
    protected DebitcardPaymentPojo doSave(DebitcardPayment debitcardPayment) {
        DebitcardPaymentPojo pojo = retrieve(debitcardPayment);

        if (pojo == null) {
            PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.save(debitcardPayment.getPaymentDetail());
            PersonAddressLinkPojo personAddressLinkPojo = new PersonAddressLinkProcessor(facade).save(debitcardPayment.getPersonAddressLink());
            return new DebitcardPaymentPojo(personAddressLinkPojo, paymentDetailPojo, debitcardPayment.getCardNumber(), debitcardPayment.getSecurityCode(), debitcardPayment.getIssueNumber(), debitcardPayment.getStartDate(), debitcardPayment.getExpireDate());
        }

        return pojo;
    }
}
