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
package com.etlsolutions.examples.mainwebapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zhipeng
 */
@Entity
@Table(name = "amexcard_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmexcardPayment.findAll", query = "SELECT a FROM AmexcardPayment a"),
    @NamedQuery(name = "AmexcardPayment.findByPaymentId", query = "SELECT a FROM AmexcardPayment a WHERE a.paymentId = :paymentId"),
    @NamedQuery(name = "AmexcardPayment.findByCardNumber", query = "SELECT a FROM AmexcardPayment a WHERE a.cardNumber = :cardNumber"),
    @NamedQuery(name = "AmexcardPayment.findBySecurityCode", query = "SELECT a FROM AmexcardPayment a WHERE a.securityCode = :securityCode"),
    @NamedQuery(name = "AmexcardPayment.findByExpireDate", query = "SELECT a FROM AmexcardPayment a WHERE a.expireDate = :expireDate")})
public class AmexcardPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Basic(optional = false)
    @Column(name = "card_number")
    private String cardNumber;
    @Basic(optional = false)
    @Column(name = "security_code")
    private String securityCode;
    @Basic(optional = false)
    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date expireDate;
    @JoinColumns({
        @JoinColumn(name = "payment_detail_id", referencedColumnName = "payment_detail_id"),
        @JoinColumn(name = "payment_type", referencedColumnName = "payment_type")})
    @ManyToOne
    private PaymentDetail paymentDetail;
    @JoinColumn(name = "person_address_link_id", referencedColumnName = "link_id")
    @ManyToOne
    private PersonAddressLink personAddressLinkId;

    public AmexcardPayment() {
    }

    public AmexcardPayment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public AmexcardPayment(Integer paymentId, String cardNumber, String securityCode, Date expireDate) {
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expireDate = expireDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public PersonAddressLink getPersonAddressLinkId() {
        return personAddressLinkId;
    }

    public void setPersonAddressLinkId(PersonAddressLink personAddressLinkId) {
        this.personAddressLinkId = personAddressLinkId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmexcardPayment)) {
            return false;
        }
        AmexcardPayment other = (AmexcardPayment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.AmexcardPayment[ paymentId=" + paymentId + " ]";
    }
    
}
