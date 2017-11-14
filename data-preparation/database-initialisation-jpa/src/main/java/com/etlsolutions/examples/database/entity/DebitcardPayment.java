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
package com.etlsolutions.examples.database.entity;

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
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "debitcard_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DebitcardPayment.findAll", query = "SELECT d FROM DebitcardPayment d"),
    @NamedQuery(name = "DebitcardPayment.findByPaymentId", query = "SELECT d FROM DebitcardPayment d WHERE d.paymentId = :paymentId"),
    @NamedQuery(name = "DebitcardPayment.findByCardNumber", query = "SELECT d FROM DebitcardPayment d WHERE d.cardNumber = :cardNumber"),
    @NamedQuery(name = "DebitcardPayment.findBySecurityCode", query = "SELECT d FROM DebitcardPayment d WHERE d.securityCode = :securityCode"),
    @NamedQuery(name = "DebitcardPayment.findByIssueNumber", query = "SELECT d FROM DebitcardPayment d WHERE d.issueNumber = :issueNumber"),
    @NamedQuery(name = "DebitcardPayment.findByStartDate", query = "SELECT d FROM DebitcardPayment d WHERE d.startDate = :startDate"),
    @NamedQuery(name = "DebitcardPayment.findByExpireDate", query = "SELECT d FROM DebitcardPayment d WHERE d.expireDate = :expireDate")})
public class DebitcardPayment implements Serializable {
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
    @Column(name = "issue_number")
    private Integer issueNumber;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
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

    public DebitcardPayment() {
    }

    public DebitcardPayment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public DebitcardPayment(Integer paymentId, String cardNumber, String securityCode, Date startDate, Date expireDate) {
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.startDate = startDate;
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

    public Integer getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
        if (!(object instanceof DebitcardPayment)) {
            return false;
        }
        DebitcardPayment other = (DebitcardPayment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.entity.DebitcardPayment[ paymentId=" + paymentId + " ]";
    }
    
}
