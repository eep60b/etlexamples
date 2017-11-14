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

import com.etlsolutions.examples.data.api.DebitcardPayment;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import java.util.Date;
import java.util.Objects;

/**
 * The DebitcardPaymentEntity class
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class DebitcardPaymentEntity implements DebitcardPayment {

    private final PaymentDetailEntity paymentDetail;
    private final PersonAddressLinkEntity personAddressLink;
    private final int issueNumber;
    private final StartDate startDate;
    private final String cardNumber;
    private final ExpireDate expireDate;
    private final String securityCode;


    public DebitcardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, int issueNumber, StartDate startDate, 
            String cardNumber, ExpireDate expireDate, String securityCode) {
        this.paymentDetail = paymentDetail instanceof PaymentDetailEntity ? (PaymentDetailEntity) paymentDetail : new PaymentDetailEntity(paymentDetail);
        this.personAddressLink = personAddressLink instanceof PersonAddressLinkEntity ? (PersonAddressLinkEntity) personAddressLink : new PersonAddressLinkEntity(personAddressLink);
        this.issueNumber = issueNumber;
        this.startDate = startDate;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.securityCode = securityCode;
    }    

    public DebitcardPaymentEntity(PaymentDetail paymentDetail, PersonAddressLink personAddressLink, IssueNumber issueNumber, StartDate startDate, 
            PaymentCardNumber cardNumber, ExpireDate expireDateColumn, SecurityCode securityCode) {
        this.paymentDetail = new PaymentDetailEntity(paymentDetail);
        this.personAddressLink = new PersonAddressLinkEntity(personAddressLink);
        this.issueNumber = issueNumber.getValue();
        this.startDate = startDate;
        this.cardNumber = cardNumber.getValue();
        this.expireDate = expireDateColumn;
        this.securityCode = securityCode.getValue();
    }    
    
    public DebitcardPaymentEntity(DebitcardPayment debitcardPayment) {
        this(debitcardPayment.getPaymentDetail(), debitcardPayment.getPersonAddressLink(), debitcardPayment.getIssueNumber(),
                new StartDate(debitcardPayment.getStartDate()), debitcardPayment.getCardNumber(), 
                new ExpireDate(debitcardPayment.getExpireDate()), debitcardPayment.getSecurityCode());
    }


    @Override
    public int getIssueNumber() {
        return issueNumber;
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
        hash = 71 * hash + Objects.hashCode(this.paymentDetail);
        hash = 71 * hash + Objects.hashCode(this.personAddressLink);
        hash = 71 * hash + Objects.hashCode(this.issueNumber);
        hash = 71 * hash + Objects.hashCode(this.startDate);
        hash = 71 * hash + Objects.hashCode(this.cardNumber);
        hash = 71 * hash + Objects.hashCode(this.securityCode);
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
        final DebitcardPaymentEntity other = (DebitcardPaymentEntity) obj;
        if (!Objects.equals(this.paymentDetail, other.paymentDetail)) {
            return false;
        }
        if (!Objects.equals(this.personAddressLink, other.personAddressLink)) {
            return false;
        }
        if (!Objects.equals(this.issueNumber, other.issueNumber)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        if (!Objects.equals(this.expireDate, other.expireDate)) {
            return false;
        }
        return Objects.equals(this.securityCode, other.securityCode);
    }

    @Override
    public boolean hasSameConstraint(DebitcardPayment debitcardPayment) {

        if(this == debitcardPayment) {
            return true;
        }
  
        if(debitcardPayment == null) {
            return false;
        }
        
        return ConstrainableUtilities.hasSameConstraint(paymentDetail, debitcardPayment.getPaymentDetail());
    }

    @Override
    public boolean hasSameParameters(DebitcardPayment debitcardPayment) {
        
        if(this == debitcardPayment) {
            return true;
        }
  
        if(debitcardPayment == null) {
            return false;
        }
        
        PaymentDetail p = debitcardPayment.getPaymentDetail();
        
        if(paymentDetail != p  && (paymentDetail != null && !paymentDetail.hasSameParameters(p))) {
            return false;
        }
        
        PersonAddressLink pe = debitcardPayment.getPersonAddressLink();
        
        if(personAddressLink != pe  && (personAddressLink != null && !personAddressLink.hasSameParameters(pe))) {
            return false;
        }
        
        if (!Objects.equals(getCardNumber(), debitcardPayment.getCardNumber())) {
            return false;
        }
        
        if (!Objects.equals(getSecurityCode(), debitcardPayment.getSecurityCode())) {
            return false;
        }
        
        if (getIssueNumber() != debitcardPayment.getIssueNumber()) {
            return false;
        }
        
        if (!CalendarUtilities.areSameDates(getStartDate(), debitcardPayment.getStartDate())) {
            return false;
        }
        
        return CalendarUtilities.areSameDates(getExpireDate(), debitcardPayment.getExpireDate());
    }

}
