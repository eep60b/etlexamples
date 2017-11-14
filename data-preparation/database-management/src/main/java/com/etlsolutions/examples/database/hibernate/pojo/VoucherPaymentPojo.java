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

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.VoucherPayment;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableVoucherPayment;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 * The VoucherPaymentPojo class represents an entry for a voucher payment.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
public class VoucherPaymentPojo implements Serializable, IdentifiableVoucherPayment {

    private static final long serialVersionUID = 334621857982791666L;

    private PaymentDetailPojo paymentDetail;
    private VoucherPojo voucher;

    public VoucherPaymentPojo() {
    }

    /**
     * Construct an object with the payment detail and voucher.
     *
     * @param paymentDetail - The payment detail.
     * @param voucher - The voucher.
     */
    public VoucherPaymentPojo(PaymentDetailPojo paymentDetail, VoucherPojo voucher) {
        this.paymentDetail = paymentDetail;
        this.voucher = voucher;
    }

    @Override
    public PaymentDetailPojo getPaymentDetail() {
        return paymentDetail;
    }

    @Override
    public VoucherPojo getVoucher() {
        return voucher;
    }

    @Override
    public boolean hasSameConstraint(VoucherPayment voucherPayment) {
        
        if(this == voucherPayment) {
            return true;
        }
        
        if(voucherPayment == null) {
            return false;
        }
        
        if(this instanceof HibernateProxy) {
            return voucherPayment.hasSameConstraint(((VoucherPayment)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if(voucherPayment instanceof HibernateProxy) {
            return hasSameConstraint(((VoucherPayment)(((HibernateProxy)voucherPayment).getHibernateLazyInitializer().getImplementation())));
        }        
        
        return ConstrainableUtilities.hasSameConstraint(paymentDetail, voucherPayment.getPaymentDetail()) && ConstrainableUtilities.hasSameConstraint(voucher, voucherPayment.getVoucher());
    }

    @Override
    public boolean hasSameParameters(VoucherPayment voucherPayment) {
        
        if(this == voucherPayment) {
            return true;
        }
        
        if(voucherPayment == null) {
            return false;
        }
        
        if(this instanceof HibernateProxy) {
            return voucherPayment.hasSameParameters(((VoucherPayment)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if(voucherPayment instanceof HibernateProxy) {
            return hasSameParameters(((VoucherPayment)(((HibernateProxy)voucherPayment).getHibernateLazyInitializer().getImplementation())));
        }        
        
        return ConstrainableUtilities.hasSameParameters(paymentDetail, voucherPayment.getPaymentDetail()) && ConstrainableUtilities.hasSameParameters(voucher, voucherPayment.getVoucher());
    }

    @Override
    public int getVoucherId() {
        return voucher == null ? 0 : voucher.getId();
    }

    @Override
    public int getPaymentId() {
        return paymentDetail == null ? 0 : paymentDetail.getId();
    }

    @Override
    public int hashCode() {
                
        if(this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }
        
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.paymentDetail);
        hash = 97 * hash + Objects.hashCode(this.voucher);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        
        if(this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if(obj instanceof HibernateProxy) {
            return equals(((HibernateProxy)obj).getHibernateLazyInitializer().getImplementation());
        }        
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final VoucherPaymentPojo other = (VoucherPaymentPojo) obj;
        
        if (!Objects.equals(this.paymentDetail, other.paymentDetail)) {
            return false;
        }
        
        return Objects.equals(this.voucher, other.voucher);
    }

    @Override
    public String toString() {
        return "VoucherPaymentPojo{payment id=" + (paymentDetail == null ? "null" : paymentDetail.getId()) + ", voucher=" + (voucher == null ? "null" : voucher.getVoucherToken()) + '}';
    }
    
    
}
