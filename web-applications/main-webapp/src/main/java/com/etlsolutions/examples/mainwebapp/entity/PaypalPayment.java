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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zhipeng
 */
@Entity
@Table(name = "paypal_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaypalPayment.findAll", query = "SELECT p FROM PaypalPayment p"),
    @NamedQuery(name = "PaypalPayment.findByPaymentId", query = "SELECT p FROM PaypalPayment p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "PaypalPayment.findByPaypalAccountId", query = "SELECT p FROM PaypalPayment p WHERE p.paypalAccountId = :paypalAccountId"),
    @NamedQuery(name = "PaypalPayment.findByPaypalIdentityToken", query = "SELECT p FROM PaypalPayment p WHERE p.paypalIdentityToken = :paypalIdentityToken")})
public class PaypalPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Basic(optional = false)
    @Column(name = "paypal_account_id")
    private String paypalAccountId;
    @Basic(optional = false)
    @Column(name = "paypal_identity_token")
    private String paypalIdentityToken;
    @JoinColumns({
        @JoinColumn(name = "payment_detail_id", referencedColumnName = "payment_detail_id"),
        @JoinColumn(name = "payment_type", referencedColumnName = "payment_type")})
    @ManyToOne
    private PaymentDetail paymentDetail;

    public PaypalPayment() {
    }

    public PaypalPayment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PaypalPayment(Integer paymentId, String paypalAccountId, String paypalIdentityToken) {
        this.paymentId = paymentId;
        this.paypalAccountId = paypalAccountId;
        this.paypalIdentityToken = paypalIdentityToken;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaypalAccountId() {
        return paypalAccountId;
    }

    public void setPaypalAccountId(String paypalAccountId) {
        this.paypalAccountId = paypalAccountId;
    }

    public String getPaypalIdentityToken() {
        return paypalIdentityToken;
    }

    public void setPaypalIdentityToken(String paypalIdentityToken) {
        this.paypalIdentityToken = paypalIdentityToken;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
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
        if (!(object instanceof PaypalPayment)) {
            return false;
        }
        PaypalPayment other = (PaypalPayment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.PaypalPayment[ paymentId=" + paymentId + " ]";
    }
    
}
