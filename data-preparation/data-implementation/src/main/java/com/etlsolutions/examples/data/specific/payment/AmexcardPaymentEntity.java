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

import com.etlsolutions.examples.data.api.AmexcardPayment;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Date;
import java.util.Objects;

/**
 * The AmexcardPaymentEntity class contains the information about a payment made
 * by an American Express card.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
public final class AmexcardPaymentEntity implements AmexcardPayment {

    private final PaymentDetailEntity paymentDetail;
    private final PersonAddressLinkEntity personAddressLink;
    private final String cardNumber;
    private final ExpireDate expireDate;
    private final String securityCode;

    /**
     * Construct an object using the given parameters.
     *
     * @param paymentDetail - The payment details.
     * @param personAddressLink - The address of the person who holds this card.
     * @param cardNumber - The card number.
     * @param expireDate - The expire date.
     * @param securityCode - The security code.
     */
    private AmexcardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, String cardNumber, ExpireDate expireDate, String securityCode) {
        this.paymentDetail = paymentDetail instanceof PaymentDetailEntity ? (PaymentDetailEntity) paymentDetail : new PaymentDetailEntity(paymentDetail);
        this.personAddressLink = personAddressLink instanceof PersonAddressLinkEntity ? (PersonAddressLinkEntity) personAddressLink : new PersonAddressLinkEntity(personAddressLink);
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.securityCode = securityCode;
    }

    /**
     * Construct an object using the given parameters.
     *
     * @param paymentDetail - The payment details.
     * @param personAddressLink - The address of the person who holds this card.
     * @param cardNumber - The card number.
     * @param expireDate - The expire date.
     * @param securityCode - The security code.
     */
    public AmexcardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, PaymentCardNumber cardNumber, ExpireDate expireDate, SecurityCode securityCode) {
        this.paymentDetail = paymentDetail instanceof PaymentDetailEntity ? (PaymentDetailEntity) paymentDetail : new PaymentDetailEntity(paymentDetail);
        this.personAddressLink = personAddressLink instanceof PersonAddressLinkEntity ? (PersonAddressLinkEntity) personAddressLink : new PersonAddressLinkEntity(personAddressLink);
        this.cardNumber = cardNumber.getValue();
        this.expireDate = expireDate;
        this.securityCode = securityCode.getValue();
    }

    /**
     * Construct an object using the given AmexcardPayment object.
     * @param amexcardPayment - The specified AmexcardPayment object.
     */
    public AmexcardPaymentEntity(AmexcardPayment amexcardPayment) {
        this(amexcardPayment.getPaymentDetail(), amexcardPayment.getPersonAddressLink(),
                amexcardPayment.getCardNumber(), new ExpireDate(amexcardPayment.getExpireDate()), amexcardPayment.getSecurityCode());
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
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.paymentDetail);
        hash = 53 * hash + Objects.hashCode(this.cardNumber);
        hash = 53 * hash + Objects.hashCode(this.personAddressLink);
        hash = 53 * hash + Objects.hashCode(this.securityCode);
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
        final AmexcardPaymentEntity other = (AmexcardPaymentEntity) obj;

        return Objects.equals(this.cardNumber, other.cardNumber) && Objects.equals(this.securityCode, other.securityCode) && Objects.equals(this.personAddressLink, other.personAddressLink)
                && Objects.equals(this.expireDate, other.expireDate) && Objects.equals(this.paymentDetail, other.paymentDetail);
    }

    @Override
    public boolean hasSameConstraint(AmexcardPayment amexcardPayment) {

        if (this == amexcardPayment) {
            return true;
        }

        if (amexcardPayment == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(paymentDetail, amexcardPayment.getPaymentDetail());
    }

    @Override
    public boolean hasSameParameters(AmexcardPayment amexcardPayment) {

        if (this == amexcardPayment) {
            return true;
        }

        if (amexcardPayment == null) {
            return false;
        }

        return Objects.equals(getCardNumber(), amexcardPayment.getCardNumber())
                && Objects.equals(getSecurityCode(), amexcardPayment.getSecurityCode())
                && CalendarUtilities.areSameDates(getExpireDate(), amexcardPayment.getExpireDate())
                && ConstrainableUtilities.hasSameParameters(paymentDetail, amexcardPayment.getPaymentDetail())
                && ConstrainableUtilities.hasSameParameters(personAddressLink, amexcardPayment.getPersonAddressLink());
    }

    @Override
    public String toString() {
        return "AmexcardPaymentEntity{" + "paymentDetail=" + paymentDetail == null ? null : paymentDetail.getInvoice().getReferenceNumber() + ", cardNumber=" + cardNumber + '}';
    }
}
