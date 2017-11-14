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

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.specific.purchase.InvoiceEntity;
import com.etlsolutions.examples.utility.NumberUtilities;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The PaymentDetailEntity class represents a payment in details.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ThreadSafe
public final class PaymentDetailEntity implements PaymentDetail {

    private final InvoiceEntity invoice;
    private final PaymentSubtotal paymentSubtotal;
    private final CurrencyCode currencyType;
    private final PaymentType paymentType;

    /**
     * Construct an object using the information in the given PaymentDetail
     * object.
     *
     * @param paymentDetail - The given PaymentDetail object.
     *
     * @throws NullPointerException if the given PaymentDetail object is null.
     */
    public PaymentDetailEntity(PaymentDetail paymentDetail) {

        this(paymentDetail.getInvoice(), paymentDetail.getSubtotal(), paymentDetail.getCurrencyCode(), paymentDetail.getPaymentType());
    }

    /**
     * Construct an object using the given parameters.
     *
     * @param invoice - The invoice which this payment will be made for.
     * @param paymentSubtotal - The payment subtotal.
     * @param currencyType - The currency type.
     * @param paymentType - The payment type (e.g. Visa, Master, etc)
     */
    public PaymentDetailEntity(Invoice invoice, BigDecimal paymentSubtotal, CurrencyCode currencyType, PaymentType paymentType) {
        this(invoice, new PaymentSubtotal(paymentSubtotal), currencyType, paymentType);

    }

    /**
     * Construct an object using the given parameters.
     *
     * @param invoice
     * @param paymentSubtotal
     * @param currencyType
     * @param paymentType
     */
    public PaymentDetailEntity(Invoice invoice, PaymentSubtotal paymentSubtotal, CurrencyCode currencyType, PaymentType paymentType) {

        this.invoice = invoice instanceof InvoiceEntity ? (InvoiceEntity) invoice : new InvoiceEntity(invoice);
        this.paymentSubtotal = paymentSubtotal;
        this.currencyType = currencyType;
        this.paymentType = paymentType;
    }

    @Override
    public BigDecimal getSubtotal() {
        return paymentSubtotal.getValue();
    }

    @Override
    public CurrencyCode getCurrencyCode() {
        return currencyType;
    }

    @Override
    public PaymentType getPaymentType() {
        return paymentType;
    }

    @Override
    public InvoiceEntity getInvoice() {
        return invoice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.invoice);
        hash = 53 * hash + Objects.hashCode(this.currencyType);
        hash = 53 * hash + Objects.hashCode(this.paymentType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final PaymentDetailEntity other = (PaymentDetailEntity) obj;

        return this.currencyType == other.currencyType && this.paymentType == other.paymentType && Objects.equals(this.paymentSubtotal, other.paymentSubtotal) && Objects.equals(this.invoice, other.invoice);
    }

    @Override
    public boolean hasSameConstraint(PaymentDetail paymentDetail) {

        if (this == paymentDetail) {
            return true;
        }

        if (paymentDetail == null) {
            return false;
        }

        return getPaymentType() == paymentDetail.getPaymentType() && ConstrainableUtilities.hasSameConstraint(invoice, paymentDetail.getInvoice());
    }

    @Override
    public boolean hasSameParameters(PaymentDetail paymentDetail) {

        if (this == paymentDetail) {
            return true;
        }

        if (paymentDetail == null) {
            return false;
        }

        if (getCurrencyCode() != paymentDetail.getCurrencyCode() || getPaymentType() != paymentDetail.getPaymentType()) {
            return false;
        }

        return NumberUtilities.equals(getSubtotal(), paymentDetail.getSubtotal(), 2) && ConstrainableUtilities.hasSameParameters(invoice, paymentDetail.getInvoice());
    }

    @Override
    public String toString() {
        return "PaymentDetailEntity{invoice reference number=" + invoice.getReferenceNumber() + ", payment type=" + paymentType + '}';
    }

}
