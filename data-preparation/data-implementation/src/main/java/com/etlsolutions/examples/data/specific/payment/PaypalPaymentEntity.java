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

import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PaypalPayment;
import java.util.Objects;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaypalPaymentEntity implements PaypalPayment {

    private final PaymentDetailEntity paymentDetail;
    private final PaypalAccountId paypalAccountIdColumn;
    private final PaypalIdentifyToken paypalIdentifyTokenColumn;
    
    public PaypalPaymentEntity(PaypalPayment paypalPayment) {
        this(paypalPayment.getPaymentDetail(), new PaypalAccountId(paypalPayment.getPaypalAccountId()), 
                new PaypalIdentifyToken(paypalPayment.getPaypalIdentityToken()));
    }

    public PaypalPaymentEntity(PaymentDetail paymentDetail, PaypalAccountId paypalAccountIdColumn, PaypalIdentifyToken paypalIdentifyTokenColumn) {
        this.paymentDetail = new PaymentDetailEntity(paymentDetail);
        this.paypalAccountIdColumn = paypalAccountIdColumn;
        this.paypalIdentifyTokenColumn = paypalIdentifyTokenColumn;
    }

    @Override
    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }   
    
    @Override
    public String getPaypalAccountId() {
        return paypalAccountIdColumn.getValue();
    }

    @Override
    public String getPaypalIdentityToken() {
        return paypalIdentifyTokenColumn.getValue();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.paymentDetail);
        hash = 41 * hash + Objects.hashCode(this.paypalAccountIdColumn);
        hash = 41 * hash + Objects.hashCode(this.paypalIdentifyTokenColumn);
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
        final PaypalPaymentEntity other = (PaypalPaymentEntity) obj;
        if (!Objects.equals(this.paymentDetail, other.paymentDetail)) {
            return false;
        }
        if (!Objects.equals(this.paypalAccountIdColumn, other.paypalAccountIdColumn)) {
            return false;
        }
        return Objects.equals(this.paypalIdentifyTokenColumn, other.paypalIdentifyTokenColumn);
    }
    
    @Override
    public boolean hasSameConstraint(PaypalPayment paypalPayment) {

        if (this == paypalPayment) {
            return true;
        }

        if (paypalPayment == null) {
            return false;
        }
        
        PaymentDetail pd = paypalPayment.getPaymentDetail();

        return paymentDetail == pd ||(paymentDetail != null && paymentDetail.hasSameConstraint(pd));
    }

    @Override
    public boolean hasSameParameters(PaypalPayment paypalPayment) {

        if (this == paypalPayment) {
            return true;
        }

        if (paypalPayment == null) {
            return false;
        }

        if (!Objects.equals(getPaypalAccountId(), paypalPayment.getPaypalAccountId())) {
            return false;
        }

        if (!Objects.equals(getPaypalIdentityToken(), paypalPayment.getPaypalIdentityToken())) {
            return false;
        }

        PaymentDetail pd = paypalPayment.getPaymentDetail();
        return paymentDetail == pd ||(paymentDetail != null && paymentDetail.hasSameParameters(pd));
    }

}
