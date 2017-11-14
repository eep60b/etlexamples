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
import com.etlsolutions.examples.data.api.AmexcardPayment;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AmexcardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.utility.annotation.StatelessClass;

/**
 * The AmexcardPaymentProcessor class contains methods to process the operations
 * associated to AMEXCARD_PAYMENT table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@StatelessClass
public final class AmexcardPaymentProcessor extends AbstractIdentifiableEdentityProcessor<AmexcardPaymentPojo, AmexcardPayment> {

    
    private final PaymentDetailProcessor paymentDetailProcessor;
    
    /**
     * Construct an AmexcardPaymentProcessor object with the given
     * BookshopFacade object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public AmexcardPaymentProcessor(BookshopFacade facade) {
        super(facade);
        paymentDetailProcessor = new PaymentDetailProcessor(facade);
    }

    @Override
    protected AmexcardPaymentPojo doSave(AmexcardPayment amexcardPayment) {

        AmexcardPaymentPojo pojo = retrieve(amexcardPayment);
        
        if (pojo == null) {
            PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.save(amexcardPayment.getPaymentDetail());
            PersonAddressLinkPojo personAddressLinkPojo = new PersonAddressLinkProcessor(facade).save(amexcardPayment.getPersonAddressLink());
            return new AmexcardPaymentPojo(personAddressLinkPojo, paymentDetailPojo, amexcardPayment.getCardNumber(), amexcardPayment.getSecurityCode(), amexcardPayment.getExpireDate());
        }

        return pojo;
    }

    @Override
    public AmexcardPaymentPojo retrieve(AmexcardPayment amexcardPayment) {

        PaymentDetailPojo paymentDetailPojo = paymentDetailProcessor.retrieve(amexcardPayment.getPaymentDetail());

        if (paymentDetailPojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_AMEXCARD_PAYMENT_BY_UNIQUE_CONSTRAINT, amexcardPayment, new StringKeyValuePair(KeyNames.AMEXCARD_PAYMENT_PAYMENT_DETAIL, paymentDetailPojo));
    }
}
