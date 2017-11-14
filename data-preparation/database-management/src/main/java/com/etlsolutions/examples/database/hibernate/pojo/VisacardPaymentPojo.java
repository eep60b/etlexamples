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
import com.etlsolutions.examples.data.api.VisacardPayment;
import com.etlsolutions.examples.data.spi.VisacardPaymentSpi;
import com.etlsolutions.examples.utility.CalendarUtilities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 * The VisacardPaymentPojo class is generated automatically then modified
 * manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.1.0 - Use the integer type for the field "paymentId".
 * @version 1.1.1 - Change the field name from "paymentId" to "id".
 */
public class VisacardPaymentPojo implements Serializable, VisacardPaymentSpi<PaymentDetailPojo, PersonAddressLinkPojo> {

    private static final long serialVersionUID = 837258074697055794L;

    private int id;
    private PersonAddressLinkPojo personAddressLink;
    private PaymentDetailPojo paymentDetail;
    private String cardNumber;
    private String securityCode;
    private Date startDate;
    private Date expireDate;

    /**
     * Construct an empty default object. All integer fields are zero. all the
     * set fields will be empty. All other fields are null.
     */
    public VisacardPaymentPojo() {
    }

    /**
     * Construct an object with only the compulsory fields.
     *
     * @param id
     * @param paymentDetail
     * @param cardNumber
     * @param securityCode
     * @param startDate
     * @param expireDate
     */
    public VisacardPaymentPojo(int id, PaymentDetailPojo paymentDetail, String cardNumber, String securityCode, Date startDate, Date expireDate) {
        this.id = id;
        this.paymentDetail = paymentDetail;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.startDate = startDate == null ? null : new Date(startDate.getTime());
        this.expireDate = expireDate == null ? null : new Date(expireDate.getTime());
    }

    /**
     *
     * @param personAddressLink
     * @param paymentDetail
     * @param cardNumber
     * @param securityCode
     * @param startDate
     * @param expireDate
     */
    public VisacardPaymentPojo(PersonAddressLinkPojo personAddressLink, PaymentDetailPojo paymentDetail, String cardNumber, String securityCode, Date startDate, Date expireDate) {
        this.personAddressLink = personAddressLink;
        this.paymentDetail = paymentDetail;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.startDate = startDate == null ? null : new Date(startDate.getTime());
        this.expireDate = expireDate == null ? null : new Date(expireDate.getTime());
    }

    /**
     *
     * @param id
     * @param personAddressLink
     * @param paymentDetail
     * @param cardNumber
     * @param securityCode
     * @param startDate
     * @param expireDate
     */
    public VisacardPaymentPojo(int id, PersonAddressLinkPojo personAddressLink, PaymentDetailPojo paymentDetail, String cardNumber, String securityCode, Date startDate, Date expireDate) {
        this(personAddressLink, paymentDetail, cardNumber, securityCode, startDate, expireDate);
        this.id = id;
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
    public Date getStartDate() {
        return startDate == null ? null : new Date(startDate.getTime());
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate == null ? null : new Date(startDate.getTime());
    }

    @Override
    public Date getExpireDate() {
        return expireDate == null ? null : new Date(expireDate.getTime());
    }

    @Override
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate == null ? null : new Date(expireDate.getTime());
    }

    @Override
    public boolean hasSameConstraint(VisacardPayment visacardPayment) {

        if (this == visacardPayment) {
            return true;
        }

        if (visacardPayment == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return visacardPayment.hasSameConstraint(((VisacardPayment) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (visacardPayment instanceof HibernateProxy) {
            return hasSameConstraint(((VisacardPayment) (((HibernateProxy) visacardPayment).getHibernateLazyInitializer().getImplementation())));
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

        if (this instanceof HibernateProxy) {
            return visacardPayment.hasSameParameters(((VisacardPayment) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (visacardPayment instanceof HibernateProxy) {
            return hasSameParameters(((VisacardPayment) (((HibernateProxy) visacardPayment).getHibernateLazyInitializer().getImplementation())));
        }

        if (!ConstrainableUtilities.hasSameParameters(paymentDetail, visacardPayment.getPaymentDetail())) {
            return false;
        }

        if (!ConstrainableUtilities.hasSameParameters(personAddressLink, visacardPayment.getPersonAddressLink())) {
            return false;
        }

        if (!Objects.equals(cardNumber, visacardPayment.getCardNumber())) {
            return false;
        }

        if (!Objects.equals(securityCode, visacardPayment.getSecurityCode())) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(this.startDate, visacardPayment.getStartDate())) {
            return false;
        }

        return CalendarUtilities.areSameDates(expireDate, visacardPayment.getExpireDate());
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.personAddressLink);
        hash = 41 * hash + Objects.hashCode(this.paymentDetail);
        hash = 41 * hash + Objects.hashCode(this.cardNumber);
        hash = 41 * hash + Objects.hashCode(this.securityCode);
        hash = 41 * hash + Objects.hashCode(this.startDate);
        hash = 41 * hash + Objects.hashCode(this.expireDate);
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

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if (obj instanceof HibernateProxy) {
            return equals(((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation());
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final VisacardPaymentPojo other = (VisacardPaymentPojo) obj;
        if (this.id != other.id) {
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

        if (!CalendarUtilities.areSameDates(this.startDate, other.startDate)) {
            return false;
        }

        return CalendarUtilities.areSameDates(this.expireDate, other.expireDate);
    }

    @Override
    public String toString() {
        return "VisacardPaymentPojo{invoice reference number=" + (paymentDetail == null ? null : (paymentDetail.getInvoice() == null ? null : paymentDetail.getInvoice().getReferenceNumber())) + ", card number=" + cardNumber + '}';
    }
}
