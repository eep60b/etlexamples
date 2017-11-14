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

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableInvoice;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The InvoiceSpi interface defines an object which contains information of an
 * invoice. The object has setters to set its fields.
 *
 * @author Zhipeng Chang
 * @param <C> - The customer object type.
 * @param <A> - The concrete type of deliver address objects.
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface InvoiceSpi<C extends Customer, A extends Address> extends IdentifiableInvoice, IdentifiableSpi {

    /**
     * Set the customer information for this invoice.
     *
     * @param customer - The object contains customer information.
     */
    void setCustomer(C customer);

    /**
     * Set the delivery address for this invoice.
     *
     * @param deliveryAddress
     */
    void setDeliveryAddress(A deliveryAddress);

    /**
     * Set the invoice date for this invoice.
     * @param invoiceDate
     */
    void setInvoiceDate(Date invoiceDate);

    /**
     * Set the total amount of money to be paid for this invoice.
     * @param total
     */
    void setTotal(BigDecimal total);

    /**
     * Set the validity type for this invoice.
     *
     * @param validity - The validity type to be set.
     */
    void setValidity(InvoiceValidity validity);

    /**
     * Set the invoice reference number.
     * @param referenceNumber
     */
    void setReferenceNumber(String referenceNumber);
}
