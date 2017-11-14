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
import com.etlsolutions.examples.data.api.PaypalPayment;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaypalPaymentPojo;

/**
 * The PaypalPaymentProcessor class contains methods which process the
 * operations associated to PAYPAL_PAYMENT table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaypalPaymentProcessor extends AbstractIdentifiableEdentityProcessor<PaypalPaymentPojo, PaypalPayment> {

    private final PaymentDetailProcessor paymentDetailProcessor;

    /**
     * Construct an object with the given facade object.
     *
     * @param facade - The given facade object.
     */
    public PaypalPaymentProcessor(BookshopFacade facade) {
        super(facade);
        paymentDetailProcessor = new PaymentDetailProcessor(facade);
    }

    @Override
    public PaypalPaymentPojo retrieve(PaypalPayment paypalPayment) {

        PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.retrieve(paypalPayment.getPaymentDetail());

        if (paymentDetailPojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_PAYPAL_PAYMENT_BY_UNIQUE_CONSTRAINT, paypalPayment, new StringKeyValuePair(KeyNames.PAYPAL_PAYMENT_DETAIL, paymentDetailPojo));
    }

    @Override
    protected PaypalPaymentPojo doSave(PaypalPayment paypalPayment) {

        PaypalPaymentPojo pojo = retrieve(paypalPayment);

        if (pojo == null) {

            PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.save(paypalPayment.getPaymentDetail());
            pojo = new PaypalPaymentPojo(paymentDetailPojo, paypalPayment.getPaypalAccountId(), paypalPayment.getPaypalIdentityToken());
        }

        return pojo;
    }
}
