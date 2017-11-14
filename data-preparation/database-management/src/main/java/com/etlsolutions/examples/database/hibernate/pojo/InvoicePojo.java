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
// Generated 19-Nov-2015 11:29:31 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.data.spi.InvoiceSpi;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.NumberUtilities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;

/**
 * The InvoicePojo class is generated automatically then modified manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.1.0 - Add the equals and hashCode methods.
 * @version 1.1.1 - Add the static field "serialVersionUID".
 * @version 1.1.2 - Add a non-set-object constructor.
 * @version 1.1.3 - Change the field name from "invoicId" to "id".
 * @version 1.2.0 - Use the integer type for the id field.
 * @version 1.2.1 - Set the initial capacities for the set fields.
 * @version 1.3.0 - Add the deliveryAddress field.
 * @version 1.4.0 - Add the implementation of InvoiceSpi.
 */
public class InvoicePojo implements Serializable, InvoiceSpi<CustomerPojo, AddressPojo> {

    private static final long serialVersionUID = 75537648906324949L;

    private int id;
    private CustomerPojo customer;
    private AddressPojo deliveryAddress;
    private Date invoiceDate;
    private BigDecimal total;
    private InvoiceValidity validity;
    private String referenceNumber;
    private Set<SoldItem> soldItems = new HashSet<>(5);
    private Set<PaymentDetail> paymentDetails = new HashSet<>(2);

    /**
     * Construct an empty default object. All integer fields are zero. all the
     * set fields will be empty. All other fields are null.
     */
    public InvoicePojo() {
    }

    /**
     * Construct an object with the minimum initialisation of fields.
     *
     * @param id - The invoice ID number.
     * @param customer - The customer information.
     * @param invoiceDate - The date when this invoice is produced.
     * @param total - The total price of this invoice.
     * @param validity - The invoice validity.
     * @param referenceNumber - The invoice reference number.
     */
    public InvoicePojo(int id, CustomerPojo customer, Date invoiceDate, BigDecimal total, InvoiceValidity validity, String referenceNumber) {
        this.id = id;
        this.customer = customer;
        this.invoiceDate = invoiceDate;
        this.total = total;
        this.validity = validity;
        this.referenceNumber = referenceNumber;
    }

    /**
     * Construct an object with the initialisation of all the fields except ID
     * and sets.
     *
     * @param customer - The customer information.
     * @param deliveryAddress - The delivery deliveryAddress of this invoice.
     * @param invoiceDate - The date when this invoice is produced.
     * @param total - The total price of this invoice.
     * @param validity - The invoice validity.
     * @param referenceNumber - The invoice reference number.
     */
    public InvoicePojo(CustomerPojo customer, AddressPojo deliveryAddress, Date invoiceDate, BigDecimal total,
            InvoiceValidity validity, String referenceNumber) {
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.invoiceDate = invoiceDate == null ? null : new Date(invoiceDate.getTime());
        this.total = total;
        this.validity = validity;
        this.referenceNumber = referenceNumber;
    }

    /**
     * Construct an object with the initialisation of all the fields except
     * sets.
     *
     * @param id
     * @param customer - The customer information.
     * @param deliveryAddress - The delivery deliveryAddress of this invoice.
     * @param invoiceDate - The date when this invoice is produced.
     * @param total - The total price of this invoice.
     * @param validity - The invoice validity.
     * @param referenceNumber - The invoice reference number.
     */
    public InvoicePojo(int id, CustomerPojo customer, AddressPojo deliveryAddress, Date invoiceDate, BigDecimal total,
            InvoiceValidity validity, String referenceNumber) {
        this(customer, deliveryAddress, invoiceDate, total, validity, referenceNumber);
        this.id = id;
    }

    /**
     * Construct an object with the initialisation of all the fields.
     *
     * @param id - The invoice ID number.
     * @param customer - The customer information.
     * @param deliveryAddress - The delivery deliveryAddress of this invoice.
     * @param invoiceDate - The date when this invoice is produced.
     * @param total - The total price of this invoice.
     * @param validity - The invoice validity.
     * @param referenceNumber - The invoice reference number.
     * @param soldItems - All the sold items in this invoice.
     * @param paymentDetails - All the payment details of this invoice.
     */
    public InvoicePojo(int id, CustomerPojo customer, AddressPojo deliveryAddress, Date invoiceDate, BigDecimal total,
            InvoiceValidity validity, String referenceNumber, Set<SoldItem> soldItems, Set<PaymentDetail> paymentDetails) {

        this(id, customer, deliveryAddress, invoiceDate, total, validity, referenceNumber);
        this.soldItems = soldItems == null ? null : new HashSet<>(soldItems);
        this.paymentDetails = paymentDetails == null ? null : new HashSet<>(paymentDetails);
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
    public CustomerPojo getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(CustomerPojo customer) {
        this.customer = customer;
    }

    @Override
    public AddressPojo getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public void setDeliveryAddress(AddressPojo deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public Date getInvoiceDate() {
        return invoiceDate == null ? null : new Date(invoiceDate.getTime());
    }

    @Override
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate == null ? null : new Date(invoiceDate.getTime());
    }

    @Override
    public BigDecimal getTotal() {
        return this.total;
    }

    @Override
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public InvoiceValidity getValidity() {
        return validity;
    }

    @Override
    public void setValidity(InvoiceValidity validity) {
        this.validity = validity;
    }

    @Override
    public String getReferenceNumber() {
        return referenceNumber;
    }

    @Override
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Set<SoldItem> getSoldItems() {
        return soldItems == null ? null : new HashSet<>(soldItems);
    }

    public void setSoldItems(Set<SoldItem> soldItems) {
        this.soldItems = soldItems == null ? null : new HashSet<>(soldItems);
    }

    public Set<PaymentDetail> getPaymentDetails() {
        return paymentDetails == null ? null : new HashSet<>(paymentDetails);
    }

    public void setPaymentDetails(Set<PaymentDetail> paymentDetails) {
        this.paymentDetails = paymentDetails == null ? null : new HashSet<>(paymentDetails);
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.customer);
        hash = 97 * hash + Objects.hashCode(this.deliveryAddress);
        hash = 97 * hash + Objects.hashCode(this.validity);
        hash = 97 * hash + Objects.hashCode(this.referenceNumber);
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

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if (obj instanceof HibernateProxy) {
            return equals(((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation());
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final InvoicePojo other = (InvoicePojo) obj;

        if (this.getId() != other.getId()) {
            return false;
        }

        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }

        if (!Objects.equals(this.deliveryAddress, other.deliveryAddress)) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(this.invoiceDate, other.invoiceDate)) {
            return false;
        }

        if (!NumberUtilities.equals(total, other.total, 2)) {
            return false;
        }

        if (this.validity != other.validity) {
            return false;
        }

        return Objects.equals(this.referenceNumber, other.referenceNumber);
    }

    @Override
    public boolean hasSameConstraint(Invoice invoice) {

        if (this == invoice) {
            return true;
        }

        if (invoice == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return invoice.hasSameConstraint(((Invoice) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (invoice instanceof HibernateProxy) {
            return hasSameConstraint(((Invoice) (((HibernateProxy) invoice).getHibernateLazyInitializer().getImplementation())));
        }

        return Objects.equals(referenceNumber, invoice.getReferenceNumber());
    }

    @Override
    public boolean hasSameParameters(Invoice invoice) {

        if (this == invoice) {
            return true;
        }

        if (invoice == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return invoice.hasSameParameters(((Invoice) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (invoice instanceof HibernateProxy) {
            return hasSameParameters(((Invoice) (((HibernateProxy) invoice).getHibernateLazyInitializer().getImplementation())));
        }

        if (!ConstrainableUtilities.hasSameParameters(customer, invoice.getCustomer())) {
            return false;
        }

        if (!ConstrainableUtilities.hasSameParameters(deliveryAddress, invoice.getDeliveryAddress())) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(invoiceDate, invoice.getInvoiceDate())) {
            return false;
        }

        if (!NumberUtilities.equals(total, invoice.getTotal(), 2)) {
            return false;
        }

        if (validity != invoice.getValidity()) {
            return false;
        }

        return Objects.equals(referenceNumber, invoice.getReferenceNumber());
    }

    @Override
    public String toString() {
        return "InvoicePojo{referenceNumber=" + referenceNumber + '}';
    }

}
