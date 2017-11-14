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
package com.etlsolutions.examples.data.spi;

import com.etlsolutions.examples.data.api.identifiable.IdentifiablePaymentDetail;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.PaymentType;
import java.math.BigDecimal;

/**
 * The CardPayment interface represents a payment. One invoice can be paid by
 * several payments with different payment types.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @param <I>  - The InvoiceSpi object type. It must implement the InvoiceSpi interface. 
 * 
 * @version 1.0.0
 */
public interface PaymentDetailSpi<I extends Invoice> extends IdentifiablePaymentDetail, IdentifiableSpi {

    /**
     * Set the subtotal of this payment to the specified number.
     * @param subtotal - The subtotal to be set.
     */
    void setSubtotal(BigDecimal subtotal);

    /**
     * Set the currency code.
     * @param currencyCode - The CurrencyCode object.
     */
    void setCurrencyCode(CurrencyCode currencyCode);

    /**
     * 
     * @param invoice 
     */
    void setInvoice(I invoice);

    /**
     * Set the payment type.
     * @param paymentType - The PaymentType object.
     */
    void setPaymentType(PaymentType paymentType);

}
