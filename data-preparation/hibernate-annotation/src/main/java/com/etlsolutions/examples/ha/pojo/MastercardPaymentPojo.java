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
package com.etlsolutions.examples.ha.pojo;
// Generated 10-Nov-2015 10:41:48 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.data.api.MastercardPayment;
import com.etlsolutions.examples.data.spi.MastercardPaymentSpi;
import com.etlsolutions.examples.ha.control.QueryNames;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * The MastercardPaymentPojo class is generated automatically then modified manually.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0 - generated by NetBeans.
 * @version 1.0.1 - Added implementation of Address.
 */
@Entity
@Table(name = "mastercard_payment", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "payment_detail_id"))
@NamedQueries({
        @NamedQuery(name = QueryNames.findMastercardPayments, query = "from MastercardPaymentPojo")
})
public class MastercardPaymentPojo implements Serializable, MastercardPaymentSpi<PaymentDetailPojo, PersonAddressLinkPojo> {

    @Id
    @Column(name = "payment_id", unique = true, nullable = false)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "payment_detail_id", referencedColumnName = "payment_detail_id", unique = true),
        @JoinColumn(name = "payment_type", referencedColumnName = "payment_type")})
    private PaymentDetailPojo paymentDetail;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_address_link_id")
    private PersonAddressLinkPojo personAddressLink;
    
    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;
    
    @Column(name = "security_code", nullable = false, length = 3)
    private String securityCode;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false, length = 13)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "expire_date", nullable = false, length = 13)
    private Date expireDate;

    /**
     * Construct a default object with no fields initialised.
     */
    public MastercardPaymentPojo() {
    }

    /**
     * 
     * @param id
     * @param paymentDetail
     * @param cardNumber
     * @param securityCode
     * @param startDate
     * @param expireDate 
     */
    public MastercardPaymentPojo(int id, PaymentDetailPojo paymentDetail, String cardNumber, String securityCode, Date startDate, Date expireDate) {
        this.id = id;
        this.paymentDetail = paymentDetail;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.startDate = startDate;
        this.expireDate = expireDate;
    }

    /**
     * 
     * @param id
     * @param paymentDetail
     * @param personAddressLink
     * @param cardNumber
     * @param securityCode
     * @param startDate
     * @param expireDate 
     */
    public MastercardPaymentPojo(int id, PaymentDetailPojo paymentDetail, PersonAddressLinkPojo personAddressLink, String cardNumber, String securityCode, Date startDate, Date expireDate) {
        this.id = id;
        this.paymentDetail = paymentDetail;
        this.personAddressLink = personAddressLink;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.startDate = startDate;
        this.expireDate = expireDate;
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
    public PaymentDetailPojo getPaymentDetail() {
        return this.paymentDetail;
    }

    @Override
    public void setPaymentDetail(PaymentDetailPojo paymentDetail) {
        this.paymentDetail = paymentDetail;
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
        return this.startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getExpireDate() {
        return this.expireDate;
    }

    @Override
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean hasSameConstraint(MastercardPayment constraintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasSameParameters(MastercardPayment constraintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
