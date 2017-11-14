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
import javax.persistence.Embeddable;

/**
 *
 * @author Zhipeng
 */
@Embeddable
public class PaymentDetailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "payment_detail_id")
    private int paymentDetailId;
    @Basic(optional = false)
    @Column(name = "payment_type")
    private String paymentType;

    public PaymentDetailPK() {
    }

    public PaymentDetailPK(int paymentDetailId, String paymentType) {
        this.paymentDetailId = paymentDetailId;
        this.paymentType = paymentType;
    }

    public int getPaymentDetailId() {
        return paymentDetailId;
    }

    public void setPaymentDetailId(int paymentDetailId) {
        this.paymentDetailId = paymentDetailId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) paymentDetailId;
        hash += (paymentType != null ? paymentType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDetailPK)) {
            return false;
        }
        PaymentDetailPK other = (PaymentDetailPK) object;
        if (this.paymentDetailId != other.paymentDetailId) {
            return false;
        }
        if ((this.paymentType == null && other.paymentType != null) || (this.paymentType != null && !this.paymentType.equals(other.paymentType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.PaymentDetailPK[ paymentDetailId=" + paymentDetailId + ", paymentType=" + paymentType + " ]";
    }
    
}
