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

import com.etlsolutions.examples.data.api.PaypalPayment;
import com.etlsolutions.examples.data.spi.PaypalPaymentSpi;
import com.etlsolutions.examples.ha.control.QueryNames;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * The PaypalPaymentPojo class is generated automatically then modified manually.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0 - generated by NetBeans.
 * @version 1.0.1 - Add the implementation of PaypalPaymentSpi.
 * @version 1.2.0 - Override the equal and hashCode methods.
 */
@Entity
@Table(name = "paypal_payment", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "payment_detail_id"))
@NamedQueries({
        @NamedQuery(name = QueryNames.findPaypalPayments, query = "from PaypalPaymentPojo")
})
public class PaypalPaymentPojo implements Serializable, PaypalPaymentSpi<PaymentDetailPojo> {

    @Id
    @Column(name = "payment_id", unique = true, nullable = false)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "payment_detail_id", referencedColumnName = "payment_detail_id", unique = true),
        @JoinColumn(name = "payment_type", referencedColumnName = "payment_type")})
    private PaymentDetailPojo paymentDetail;
    
    @Column(name = "paypal_account_id", nullable = false, length = 100)
    private String paypalAccountId;
    
    @Column(name = "paypal_identity_token", nullable = false, length = 100)
    private String paypalIdentityToken;

    public PaypalPaymentPojo() {
    }

    public PaypalPaymentPojo(int id, PaymentDetailPojo payment, String paypalAccountId, String paypalIdentityToken) {
        this.id = id;
        this.paymentDetail = payment;
        this.paypalAccountId = paypalAccountId;
        this.paypalIdentityToken = paypalIdentityToken;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public PaymentDetailPojo getPaymentDetail() {
       return paymentDetail; 
    }    
    
    @Override
    public void setPaymentDetail(PaymentDetailPojo paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    @Override
    public String getPaypalAccountId() {
        return this.paypalAccountId;
    }

    @Override
    public void setPaypalAccountId(String paypalAccountId) {
        this.paypalAccountId = paypalAccountId;
    }

    @Override
    public String getPaypalIdentityToken() {
        return this.paypalIdentityToken;
    }

    @Override
    public void setPaypalIdentityToken(String paypalIdentifyToken) {
        this.paypalIdentityToken = paypalIdentifyToken;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        //This code should be kept to show a method to compare the class. 
        //For Hibernate directly comparison of the class names is no good since 
        //its children should be considered as equals when their IDs are the same. 
        if (Hibernate.getClass(this) != Hibernate.getClass(obj)) {
            return false;
        }
        
        final PaypalPaymentPojo other = (PaypalPaymentPojo) obj;
        return this.id == other.id;
    }

    @Override
    public boolean hasSameConstraint(PaypalPayment constraintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasSameParameters(PaypalPayment constraintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}