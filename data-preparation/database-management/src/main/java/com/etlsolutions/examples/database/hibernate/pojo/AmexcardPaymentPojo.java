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
package com.etlsolutions.examples.database.hibernate.pojo;
// Generated 19-Nov-2015 11:29:31 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.AmexcardPayment;
import com.etlsolutions.examples.data.spi.AmexcardPaymentSpi;
import com.etlsolutions.examples.utility.CalendarUtilities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 * The AmexcardPaymentPojo class is generated automatically then modified
 * manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.0.1 - Change the field name from "addressId" to "id".
 * @version 1.1.0 - Use the integer type for id.
 * @version 1.1.1 - Add the static field "serialVersionUID".
 * @version 1.2.0 - Add equals and hashCode methods.
 * @version 1.3.0 - Implement the AmexcardPaymentSpi interface.
 */
public class AmexcardPaymentPojo implements Serializable, AmexcardPaymentSpi<PaymentDetailPojo, PersonAddressLinkPojo> {

    private static final long serialVersionUID = 806254786708924725L;

    private int id;
    private PersonAddressLinkPojo personAddressLink;
    private PaymentDetailPojo paymentDetail;
    private String cardNumber;
    private String securityCode;
    private Date expireDate;

    /**
     * Construct an empty default object. All integer fields are zero. all the
     * set fields will be empty. All other fields are null.
     */
    public AmexcardPaymentPojo() {
    }

    /**
     * Construct an object with the minimum initialisation. The personal
     * information and address will be taken from payment detail.
     *
     * @param id - The payment ID.
     * @param PaymentDetail - The payment detail information.
     * @param cardNumber - The card number in string format.
     * @param securityCode - The security number in string format.
     * @param expireDate - the expire date.
     */
    public AmexcardPaymentPojo(int id, PaymentDetailPojo PaymentDetail, String cardNumber, String securityCode, Date expireDate) {
        this.id = id;
        this.paymentDetail = PaymentDetail;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expireDate = expireDate == null ? null: new Date(expireDate.getTime());
    }

    /**
     * Construct an object with all fields except ID are initialised.
     *
     * @param personAddressLink - The personal information and address for this
     * card. This could be different from the customer information in the
     * payment detail.
     * @param PaymentDetail - The payment detail information.
     * @param cardNumber - The card number in string format.
     * @param securityCode - The security number in string format.
     * @param expireDate - the expire date.
     */
    public AmexcardPaymentPojo(PersonAddressLinkPojo personAddressLink, PaymentDetailPojo PaymentDetail, String cardNumber, String securityCode, Date expireDate) {
        this.paymentDetail = PaymentDetail;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expireDate = expireDate == null ? null: new Date(expireDate.getTime());
        this.personAddressLink = personAddressLink;
    }

    /**
     * Construct an object with all fields are initialised.
     *
     * @param id - The payment ID.
     * @param personAddressLink - The personal information and address for this
     * card. This could be different from the customer information in the
     * payment detail.
     * @param PaymentDetail - The payment detail information.
     * @param cardNumber - The card number in string format.
     * @param securityCode - The security number in string format.
     * @param expireDate - the expire date.
     */
    public AmexcardPaymentPojo(int id, PersonAddressLinkPojo personAddressLink, PaymentDetailPojo PaymentDetail, String cardNumber, String securityCode, Date expireDate) {
        this(id, PaymentDetail, cardNumber, securityCode, expireDate);
        this.personAddressLink = personAddressLink;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public PersonAddressLinkPojo getPersonAddressLink() {
        return this.personAddressLink;
    }

    @Override
    public void setPersonAddressLink(PersonAddressLinkPojo personAddressLink) {
        this.personAddressLink = personAddressLink;
    }

    @Override
    public PaymentDetailPojo getPaymentDetail() {
        return this.paymentDetail;
    }

    @Override
    public void setPaymentDetail(PaymentDetailPojo paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    @Override
    public String getCardNumber() {
        return this.cardNumber;
    }

    @Override
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String getSecurityCode() {
        return this.securityCode;
    }

    @Override
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public Date getExpireDate() {
        return expireDate == null ? null : new Date(expireDate.getTime());
    }

    @Override
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate == null ? null: new Date(expireDate.getTime());
    }

    @Override
    public int hashCode() {
        
        if(this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }
                
        int hash = 5;
        hash = 19 * hash + this.getId();
        hash = 19 * hash + Objects.hashCode(this.personAddressLink);
        hash = 19 * hash + Objects.hashCode(this.paymentDetail);
        hash = 19 * hash + Objects.hashCode(this.cardNumber);
        hash = 19 * hash + Objects.hashCode(this.securityCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if(this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if(obj instanceof HibernateProxy) {
            return equals(((HibernateProxy)obj).getHibernateLazyInitializer().getImplementation());
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }

        final AmexcardPaymentPojo other = (AmexcardPaymentPojo) obj;
        if (this.getId() != other.getId()) {
            return false;
        }

        if (!Objects.equals(this.personAddressLink, other.personAddressLink)) {
            return false;
        }

        if (!Objects.equals(this.paymentDetail, other.paymentDetail)) {
            return false;
        }

        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }

        if (!Objects.equals(this.securityCode, other.securityCode)) {
            return false;
        }        
        
        return CalendarUtilities.areSameDates(this.expireDate, other.expireDate);
    }

    @Override
    public boolean hasSameConstraint(AmexcardPayment amexcardPayment) {
        
        if(this == amexcardPayment) {
            return true;
        }

        if(amexcardPayment == null) {
            return false;
        }
        
        if(this instanceof HibernateProxy) {
            return amexcardPayment.hasSameConstraint(((AmexcardPayment)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if(amexcardPayment instanceof HibernateProxy) {
            return hasSameConstraint(((AmexcardPayment)(((HibernateProxy)amexcardPayment).getHibernateLazyInitializer().getImplementation())));
        }        
               
        return ConstrainableUtilities.hasSameConstraint(paymentDetail, amexcardPayment.getPaymentDetail());
    }

    @Override
    public boolean hasSameParameters(AmexcardPayment amexcardPayment) {

        if (this == amexcardPayment) {
            return true;
        }

        if(amexcardPayment == null) {
            return false;
        }
        
        if(this instanceof HibernateProxy) {
            return amexcardPayment.hasSameParameters(((AmexcardPayment)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if(amexcardPayment instanceof HibernateProxy) {
            return hasSameParameters(((AmexcardPayment)(((HibernateProxy)amexcardPayment).getHibernateLazyInitializer().getImplementation())));
        }        
               
        if(!ConstrainableUtilities.hasSameParameters(paymentDetail, amexcardPayment.getPaymentDetail())){
            return false;
        }

        if (!ConstrainableUtilities.hasSameParameters(personAddressLink, amexcardPayment.getPersonAddressLink())) {
            return false;
        }

        if (!Objects.equals(cardNumber, amexcardPayment.getCardNumber())) {
            return false;
        }

        if(!Objects.equals(securityCode, amexcardPayment.getSecurityCode())) {
            return false;
        }
        
        return CalendarUtilities.areSameDates(expireDate, amexcardPayment.getExpireDate());
    }

    @Override
    public String toString() {
        
        String payment;
        
        if(paymentDetail == null || paymentDetail.getInvoice() == null) {
            payment = "null";
        } else {
            payment = paymentDetail.getInvoice().getReferenceNumber();
        }
        
        return "AmexcardPaymentPojo{invoice reference number=" + payment + ", card number=" + cardNumber + '}';
    }
}
