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

import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.data.spi.PaymentDetailIdSpi;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * The PaymentDetailIdPojo class is generated automatically then modified
 * manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - generated by NetBeans.
 * @version 1.0.1 - Added implementation of Address.
 */
@Embeddable
public class PaymentDetailIdPojo implements Serializable, PaymentDetailIdSpi {

    private static final long serialVersionUID = 40764031270282057L;    
    
    @Column(name = "payment_detail_id", unique = true, nullable = false)
    private int id;
    
    @Enumerated(EnumType.STRING)    
    @Column(name = "payment_type", nullable = false, length = 11)
    private PaymentType paymentType;

    public PaymentDetailIdPojo() {
    }

    public PaymentDetailIdPojo(int paymentDetailId, PaymentType paymentType) {
        this.id = paymentDetailId;
        this.paymentType = paymentType;
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
    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    @Override
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object other) {
        
        if ((this == other)) {
            return true;
        }
        
        if ((other == null)) {
            return false;
        }
        
        if (!(other instanceof PaymentDetailIdPojo)) {
            return false;
        }
        
        PaymentDetailIdPojo castOther = (PaymentDetailIdPojo) other;

        return (this.getId() == castOther.getId())
                && ((this.getPaymentType() == null ? castOther.getPaymentType() == null : this.getPaymentType().equals(castOther.getPaymentType())) || (this.getPaymentType() != null && castOther.getPaymentType() != null && this.getPaymentType().equals(castOther.getPaymentType())));
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getId();
        result = 37 * result + (getPaymentType() == null ? 0 : this.getPaymentType().hashCode());
        return result;
    }

}