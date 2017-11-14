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
package com.etlsolutions.examples.data.specific.purchase;

import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * The InvoiceEntity class represents an invoice.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class InvoiceEntity implements Invoice {

    private final CustomerEntity customer;
    private final AddressEntity deliveryAddress;
    private final InvoiceDate invoiceDate;
    private final InvoiceSubtotal subtotal;
    private final InvoiceValidity validity;
    private final String referenceNumber;

    /**
     * Construct an object using the given parameters.
     *
     * @param customer - The customer of this invoice.
     * @param deliveryAddress - The customer delivery address.
     * @param invoiceDate - The date that this invoice produced.
     * @param subtotal - The subtotal on this invoice.
     * @param referenceNumber - The invoice reference number.
     * @param validity - The invoice validity.
     */
    private InvoiceEntity(Customer customer, Address deliveryAddress, InvoiceDate invoiceDate, InvoiceSubtotal subtotal, InvoiceValidity validity, String referenceNumber) {

        this.customer = customer instanceof CustomerEntity ? (CustomerEntity) customer : new CustomerEntity(customer);
        this.deliveryAddress = deliveryAddress instanceof AddressEntity ? (AddressEntity) deliveryAddress : new AddressEntity(deliveryAddress);
        this.invoiceDate = invoiceDate;
        this.subtotal = subtotal;
        this.referenceNumber = referenceNumber;
        this.validity = validity;        
    }    
    
    /**
     * Construct an object using the given parameters.
     *
     * @param customer - The customer of this invoice.
     * @param deliveryAddress - The customer delivery address.
     * @param invoiceDate - The date that this invoice produced.
     * @param subtotal - The subtotal on this invoice.
     * @param referenceNumber - The invoice reference number.
     * @param validity - The invoice validity.
     */
    public InvoiceEntity(Customer customer, Address deliveryAddress, InvoiceDate invoiceDate, InvoiceSubtotal subtotal, InvoiceReferenceNumber referenceNumber, InvoiceValidity validity) {

        this(customer, deliveryAddress, invoiceDate, subtotal, validity, referenceNumber.getValue());
    }

    /**
     * 
     * @param customer
     * @param deliveryAddress
     * @param invoiceDate
     * @param subtotal
     * @param invoiceValidity
     * @param referenceNumber 
     */
    public InvoiceEntity(Customer customer, Address deliveryAddress, Date invoiceDate, BigDecimal subtotal, InvoiceValidity invoiceValidity, String referenceNumber) {

        this(customer, deliveryAddress, new InvoiceDate(invoiceDate), new InvoiceSubtotal(subtotal), invoiceValidity , referenceNumber);
    }

    /**
     * Construct an object with the specified Invoice object.
     *
     * @param invoice - The specified invoice object.
     * @throws NullPointerException if the specified invoice object is null.
     */
    public InvoiceEntity(Invoice invoice) {

        this(invoice.getCustomer(), invoice.getDeliveryAddress(), invoice.getInvoiceDate(), invoice.getTotal(), invoice.getValidity(), invoice.getReferenceNumber());
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public Date getInvoiceDate() {
        return invoiceDate.getValue();
    }

    @Override
    public BigDecimal getTotal() {
        return subtotal.getValue();
    }

    @Override
    public AddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String getReferenceNumber() {
        return referenceNumber;
    }

    @Override
    public boolean hasSameConstraint(Invoice invoice) {

        if (this == invoice) {
            return true;
        }

        if (invoice == null) {
            return false;
        }

        return getReferenceNumber().equals(invoice.getReferenceNumber());
    }

    @Override
    public boolean hasSameParameters(Invoice invoice) {

        if (this == invoice) {
            return true;
        }

        if (invoice == null) {
            return false;
        }

        if (!customer.hasSameParameters(invoice.getCustomer())) {
            return false;
        }

        if (!deliveryAddress.hasSameParameters(invoice.getDeliveryAddress())) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(getInvoiceDate(), invoice.getInvoiceDate())) {
            return false;
        }

        if (!Objects.equals(getReferenceNumber(), invoice.getReferenceNumber())) {
            return false;
        }

        if (!Objects.equals(getTotal(), invoice.getTotal())) {
            return false;
        }

        return validity == invoice.getValidity();
    }

    @Override
    public InvoiceValidity getValidity() {
        return validity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.customer);
        hash = 13 * hash + Objects.hashCode(this.deliveryAddress);
        hash = 13 * hash + Objects.hashCode(this.validity);
        hash = 13 * hash + Objects.hashCode(this.referenceNumber);
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

        final InvoiceEntity other = (InvoiceEntity) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }

        if (!Objects.equals(this.invoiceDate, other.invoiceDate)) {
            return false;
        }

        if (!Objects.equals(this.subtotal, other.subtotal)) {
            return false;
        }

        return this.validity == other.validity;
    }

    @Override
    public String toString() {
        return "InvoiceEntity{refrence number=" + getReferenceNumber() + '}';
    }
}