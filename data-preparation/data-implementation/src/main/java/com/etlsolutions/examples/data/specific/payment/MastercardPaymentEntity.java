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
package com.etlsolutions.examples.data.specific.payment;

import com.etlsolutions.examples.data.api.MastercardPayment;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import java.util.Date;
import java.util.Objects;

/**
 * The MastercardPaymentEntity class is the minimum implementation of the
 * MastercardPayment interface.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class MastercardPaymentEntity implements MastercardPayment {

    private final PaymentDetailEntity paymentDetail;
    private final PersonAddressLinkEntity personAddressLink;
    private final StartDate startDate;
    private final String cardNumber;
    private final ExpireDate expireDate;
    private final String securityCode;

    /**
     *
     * @param paymentDetail
     * @param personAddressLink
     * @param startDate
     * @param cardNumber
     * @param expireDate
     * @param securityCode
     */
    public MastercardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, StartDate startDate, String cardNumber, ExpireDate expireDate, String securityCode) {

        this.paymentDetail = paymentDetail instanceof PaymentDetailEntity ? (PaymentDetailEntity) paymentDetail : new PaymentDetailEntity(paymentDetail);
        this.personAddressLink = personAddressLink instanceof PersonAddressLinkEntity ? (PersonAddressLinkEntity) personAddressLink : new PersonAddressLinkEntity(personAddressLink);
        this.startDate = startDate;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.securityCode = securityCode;
    }

    public MastercardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, StartDate startDate, PaymentCardNumber cardNumber, ExpireDate expireDate, SecurityCode securityCode) {
        this(paymentDetail, personAddressLink, startDate, cardNumber.getValue(), expireDate, securityCode.getValue());
    }

    public MastercardPaymentEntity(MastercardPayment mastercardPayment) {
        this(mastercardPayment.getPaymentDetail(), mastercardPayment.getPersonAddressLink(),
                new StartDate(mastercardPayment.getStartDate()), new PaymentCardNumber(mastercardPayment.getCardNumber()),
                new ExpireDate(mastercardPayment.getExpireDate()), new SecurityCode(mastercardPayment.getSecurityCode()));

    }

    @Override
    public Date getStartDate() {
        return startDate.getValue();
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public Date getExpireDate() {
        return expireDate.getValue();
    }

    @Override
    public PersonAddressLink getPersonAddressLink() {
        return personAddressLink;
    }

    @Override
    public String getSecurityCode() {
        return securityCode;
    }

    @Override
    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.paymentDetail);
        hash = 59 * hash + Objects.hashCode(this.personAddressLink);
        hash = 59 * hash + Objects.hashCode(this.cardNumber);
        hash = 59 * hash + Objects.hashCode(this.securityCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final MastercardPaymentEntity other = (MastercardPaymentEntity) obj;

        return Objects.equals(this.securityCode, other.securityCode)
                && Objects.equals(this.cardNumber, other.cardNumber)
                && Objects.equals(this.startDate, other.startDate)
                && Objects.equals(this.expireDate, other.expireDate)
                && Objects.equals(this.paymentDetail, other.paymentDetail)
                && Objects.equals(this.personAddressLink, other.personAddressLink);
    }

    @Override
    public boolean hasSameConstraint(MastercardPayment payment) {

        if (this == payment) {
            return true;
        }

        if (payment == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(paymentDetail, payment.getPaymentDetail());
    }

    @Override
    public boolean hasSameParameters(MastercardPayment payment) {

        if (this == payment) {
            return true;
        }

        if (payment == null) {
            return false;
        }

        return Objects.equals(getCardNumber(), payment.getCardNumber())
                && Objects.equals(getSecurityCode(), payment.getSecurityCode())
                && CalendarUtilities.areSameDates(getStartDate(), payment.getStartDate())
                && CalendarUtilities.areSameDates(getExpireDate(), payment.getExpireDate())
                && ConstrainableUtilities.hasSameParameters(paymentDetail, payment.getPaymentDetail())
                && ConstrainableUtilities.hasSameParameters(personAddressLink, payment.getPersonAddressLink());
    }
}
