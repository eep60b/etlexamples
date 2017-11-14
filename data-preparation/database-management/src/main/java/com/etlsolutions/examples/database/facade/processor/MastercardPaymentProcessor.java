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
import com.etlsolutions.examples.data.api.MastercardPayment;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.MastercardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class MastercardPaymentProcessor extends AbstractIdentifiableEdentityProcessor<MastercardPaymentPojo, MastercardPayment> {

    /**
     * 
     */
    private final PaymentDetailProcessor paymentDetailProcessor;

    /**
     * Construct a MastercardPaymentProcessor object using the given
     * BookshopFacade object.
     *
     * @param facade
     */
    public MastercardPaymentProcessor(BookshopFacade facade) {
        super(facade);
        paymentDetailProcessor = new PaymentDetailProcessor(facade);
    }

    @Override
    public MastercardPaymentPojo retrieve(MastercardPayment mastercardPayment) {

        PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.retrieve(mastercardPayment.getPaymentDetail());

        if (paymentDetailPojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_MASTERCARD_PAYMENT_BY_UNIQUE_CONSTRAINT, mastercardPayment, new StringKeyValuePair(KeyNames.MASTERCARD_PAYMENT_PAYMENT_DETAIL, paymentDetailPojo));
    }

    @Override
    protected MastercardPaymentPojo doSave(MastercardPayment mastercardPayment) {
        MastercardPaymentPojo pojo = retrieve(mastercardPayment);

        if (pojo == null) {
            PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.save(mastercardPayment.getPaymentDetail());
            PersonAddressLinkPojo personAddressLinkPojo = new PersonAddressLinkProcessor(facade).save(mastercardPayment.getPersonAddressLink());
            pojo = new MastercardPaymentPojo(personAddressLinkPojo, paymentDetailPojo, mastercardPayment.getCardNumber(), mastercardPayment.getSecurityCode(), mastercardPayment.getStartDate(), mastercardPayment.getExpireDate());
        }

        return pojo;
    }
}
