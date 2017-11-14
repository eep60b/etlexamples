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
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.api.VoucherPayment;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import java.util.Objects;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class VoucherPaymentEntity implements VoucherPayment {

    private final PaymentDetailEntity paymentDetail;
    private final VoucherEntity voucher;

    /**
     * 
     * @param voucherPayment 
     */
    public VoucherPaymentEntity(VoucherPayment voucherPayment) {
        this(voucherPayment.getPaymentDetail(), voucherPayment.getVoucher());
    }    
    
    /**
     * 
     * @param paymentDetail
     * @param voucher 
     */
    public VoucherPaymentEntity(PaymentDetail paymentDetail, Voucher voucher) {
        this.paymentDetail = paymentDetail instanceof PaymentDetailEntity ? (PaymentDetailEntity) paymentDetail : new PaymentDetailEntity(paymentDetail);
        this.voucher = voucher instanceof VoucherEntity ? (VoucherEntity) voucher : new VoucherEntity(voucher);
    }
    
    @Override
    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    @Override
    public Voucher getVoucher() {
        return voucher;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.paymentDetail);
        hash = 37 * hash + Objects.hashCode(this.voucher);
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
        final VoucherPaymentEntity other = (VoucherPaymentEntity) obj;
       
        return Objects.equals(this.paymentDetail, other.paymentDetail) && Objects.equals(this.voucher, other.voucher);
    }    
    
    @Override
    public boolean hasSameConstraint(VoucherPayment voucherPayment) {
        
        if(this == voucherPayment) {
            return true;
        }
        
        if(voucherPayment == null) {
            return false;
        }  
        
        return ConstrainableUtilities.hasSameConstraint(voucher, voucherPayment.getVoucher())
                && ConstrainableUtilities.hasSameConstraint(paymentDetail, voucherPayment.getPaymentDetail());
    }

    @Override
    public boolean hasSameParameters(VoucherPayment voucherPayment) {
        
        if(this == voucherPayment) {
            return true;
        }
        
        if(voucherPayment == null) {
            return false;
        }
        
        return ConstrainableUtilities.hasSameParameters(voucher, voucherPayment.getVoucher())
                && ConstrainableUtilities.hasSameParameters(paymentDetail, voucherPayment.getPaymentDetail());
    }

    @Override
    public String toString() {
        return "VoucherPaymentEntity{paymentDetail=" + paymentDetail + ", voucher=" + voucher + '}';
    }
}
