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

import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.VisacardPayment;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Date;
import java.util.Objects;

/**
 * The VisacardPaymentEntity class is the minimum implementation of the
 * VisacardPayment interface.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class VisacardPaymentEntity implements VisacardPayment {

    private final PaymentDetailEntity paymentDetail;
    private final PersonAddressLinkEntity personAddressLink;
    private final StartDate startDate;
    private final String cardNumber;
    private final ExpireDate expireDate;
    private final String securityCode;

    public VisacardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, StartDate startDate, String cardNumber, ExpireDate expireDate, String securityCode) {
        this.paymentDetail = paymentDetail instanceof PaymentDetailEntity ? (PaymentDetailEntity) paymentDetail : new PaymentDetailEntity(paymentDetail);
        this.personAddressLink = personAddressLink instanceof PersonAddressLinkEntity ? (PersonAddressLinkEntity) personAddressLink : new PersonAddressLinkEntity(personAddressLink);
        this.startDate = startDate;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.securityCode = securityCode;
    }

    public VisacardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, StartDate startDate, PaymentCardNumber cardNumber, ExpireDate expireDate, SecurityCode securityCode) {

        this(paymentDetail, personAddressLink, startDate, cardNumber.getValue(), expireDate, securityCode.getValue());
    }

    public VisacardPaymentEntity(VisacardPayment visacardPayment) {

        this(visacardPayment.getPaymentDetail(), visacardPayment.getPersonAddressLink(), new StartDate(visacardPayment.getStartDate()), visacardPayment.getCardNumber(), new ExpireDate(visacardPayment.getExpireDate()), visacardPayment.getSecurityCode());
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

        final VisacardPaymentEntity other = (VisacardPaymentEntity) obj;

        return Objects.equals(this.securityCode, other.securityCode)
                && Objects.equals(this.cardNumber, other.cardNumber)
                && Objects.equals(this.startDate, other.startDate)
                && Objects.equals(this.expireDate, other.expireDate)
                && Objects.equals(this.paymentDetail, other.paymentDetail)
                && Objects.equals(this.personAddressLink, other.personAddressLink);
    }

    @Override
    public boolean hasSameConstraint(VisacardPayment visacardPayment) {

        if (this == visacardPayment) {
            return true;
        }

        if (visacardPayment == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(paymentDetail, visacardPayment.getPaymentDetail());
    }

    @Override
    public boolean hasSameParameters(VisacardPayment visacardPayment) {

        if (this == visacardPayment) {
            return true;
        }

        if (visacardPayment == null) {
            return false;
        }

        return Objects.equals(getCardNumber(), visacardPayment.getCardNumber())
                && Objects.equals(getSecurityCode(), visacardPayment.getSecurityCode())
                && CalendarUtilities.areSameDates(getStartDate(), visacardPayment.getStartDate())
                && CalendarUtilities.areSameDates(getExpireDate(), visacardPayment.getExpireDate())
                && ConstrainableUtilities.hasSameParameters(paymentDetail, visacardPayment.getPaymentDetail())
                && ConstrainableUtilities.hasSameParameters(personAddressLink, visacardPayment.getPersonAddressLink());
    }
}
