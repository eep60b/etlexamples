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
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.data.spi.PaymentDetailSpi;
import com.etlsolutions.examples.utility.NumberUtilities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;

/**
 * The PaymentDetailPojo class is generated automatically then modified manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.0.1 - Change the field name from "id" to "idObject".
 * @version 1.0.2 - Use generic types.
 * @version 1.0.3 - Add a non-set constructor.
 * @version 1.1.0 - Add implementation of PaymentDetailSpi.
 */
public class PaymentDetailPojo implements Serializable, PaymentDetailSpi<InvoicePojo> {

    private static final long serialVersionUID = 568233952557586263L;

    private PaymentDetailIdPojo idObject;
    private InvoicePojo invoice;
    private BigDecimal subtotal;
    private CurrencyCode currencyCode;
    
    private Set<DebitcardPaymentPojo> debitcardPayments = new HashSet<>(0);
    private Set<VisacardPaymentPojo> visacardPayments = new HashSet<>(0);
    private Set<MastercardPaymentPojo> mastercardPayments = new HashSet<>(0);
    private Set<PaypalPaymentPojo> paypalPayments = new HashSet<>(0);
    private Set<VoucherPojo> vouchers = new HashSet<>(0);
    private Set<AmexcardPaymentPojo> amexcardPayments = new HashSet<>(0);

    /**
     * Construct a default object with no field is initialised.
     */
    public PaymentDetailPojo() {
    }

    /**
     * Construct an object with all fields are initialised except sets.
     * @param idObject
     * @param invoice
     * @param subtotal
     * @param currencyCode 
     */
    public PaymentDetailPojo(PaymentDetailIdPojo idObject, InvoicePojo invoice, BigDecimal subtotal, CurrencyCode currencyCode) {
        this.idObject = idObject;
        this.invoice = invoice;
        this.subtotal = subtotal;
        this.currencyCode = currencyCode;
    }

    /**
     * Construct an object with all the fields for the table columns except ID.
     * @param paymentType
     * @param invoice
     * @param subtotal
     * @param currencyCode 
     */
    public PaymentDetailPojo(PaymentType paymentType, InvoicePojo invoice, BigDecimal subtotal, CurrencyCode currencyCode) {
        this.idObject = new PaymentDetailIdPojo(paymentType);
        this.invoice = invoice;
        this.subtotal = subtotal;
        this.currencyCode = currencyCode;
    }    
    
    
    /**
     * Construct an object with all fields are initialised.
     * @param idObject
     * @param invoice
     * @param subtotal
     * @param currencyCode
     * @param debitcardPayments
     * @param visacardPayments
     * @param mastercardPayments
     * @param paypalPayments
     * @param vouchers
     * @param amexcardPayments 
     */
    public PaymentDetailPojo(PaymentDetailIdPojo idObject, InvoicePojo invoice, BigDecimal subtotal, CurrencyCode currencyCode, Set<DebitcardPaymentPojo> debitcardPayments,
            Set<VisacardPaymentPojo> visacardPayments, Set<MastercardPaymentPojo> mastercardPayments, Set<PaypalPaymentPojo> paypalPayments,
            Set<VoucherPojo> vouchers, Set<AmexcardPaymentPojo> amexcardPayments) {
        this.idObject = idObject;
        this.invoice = invoice;
        this.subtotal = subtotal;
        this.currencyCode = currencyCode;
        this.debitcardPayments = debitcardPayments == null ? null : new HashSet<>(debitcardPayments);
        this.visacardPayments = visacardPayments == null ? null : new HashSet<>(visacardPayments);
        this.mastercardPayments = mastercardPayments == null? null : new HashSet<>(mastercardPayments);
        this.paypalPayments = paypalPayments == null ? null : new HashSet<>(paypalPayments);
        this.vouchers = vouchers == null ? null : new HashSet<>(vouchers);
        this.amexcardPayments = amexcardPayments == null ? null : new HashSet<>(amexcardPayments);
    }

    public PaymentDetailIdPojo getIdObject() {
        return this.idObject;
    }

    public void setIdObject(PaymentDetailIdPojo idObject) {
        this.idObject = idObject;
    }

    @Override
    public InvoicePojo getInvoice() {
        return this.invoice;
    }

    @Override
    public void setInvoice(InvoicePojo invoice) {
        this.invoice = invoice;
    }

    @Override
    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    @Override
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    @Override
    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Set<DebitcardPaymentPojo> getDebitcardPayments() {
        return debitcardPayments == null ? null : new HashSet<>(debitcardPayments);
    }

    public void setDebitcardPayments(Set<DebitcardPaymentPojo> debitcardPayments) {
        this.debitcardPayments = debitcardPayments == null ? null : new HashSet<>(debitcardPayments);
    }

    public Set<VisacardPaymentPojo> getVisacardPayments() {
        return visacardPayments == null ? null : new HashSet<>(visacardPayments);
    }

    public void setVisacardPayments(Set<VisacardPaymentPojo> visacardPayments) {
        this.visacardPayments = visacardPayments == null ? null : new HashSet<>(visacardPayments);
    }

    public Set<MastercardPaymentPojo> getMastercardPayments() {
        return mastercardPayments == null ? null : new HashSet<>(mastercardPayments);
    }

    public void setMastercardPayments(Set<MastercardPaymentPojo> mastercardPayments) {
        this.mastercardPayments = mastercardPayments == null? null : new HashSet<>(mastercardPayments);
    }

    public Set<PaypalPaymentPojo> getPaypalPayments() {
        return paypalPayments == null ? null : new HashSet<>(paypalPayments);
    }
    
    /**
     * @param paypalPayments
     * @throws NullPointerException if the given set is null.
     */
    public void setPaypalPayments(Set<PaypalPaymentPojo> paypalPayments) {
        this.paypalPayments = paypalPayments == null ? null : new HashSet<>(paypalPayments);
    }

    public Set<VoucherPojo> getVouchers() {
        return vouchers == null ? null : new HashSet<>(vouchers);
    }

    public void setVouchers(Set<VoucherPojo> vouchers) {
        this.vouchers = vouchers == null ? null : new HashSet<>(vouchers);
    }

    public Set<AmexcardPaymentPojo> getAmexcardPayments() {
        return amexcardPayments == null ? null : new HashSet<>(amexcardPayments);
    }

    public void setAmexcardPayments(Set<AmexcardPaymentPojo> amexcardPayments) {
        this.amexcardPayments = amexcardPayments == null ? null : new HashSet<>(amexcardPayments);
    }

    @Override
    public boolean hasSameConstraint(PaymentDetail paymentDetail) {
        
        if(this == paymentDetail) {
            return true;
        }
        
        if(paymentDetail == null) {
            return false;
        }
                
        if(this instanceof HibernateProxy) {
            return paymentDetail.hasSameConstraint((PaymentDetail)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation());
        }

        if(paymentDetail instanceof HibernateProxy) {
            return hasSameConstraint(((PaymentDetail)(((HibernateProxy)paymentDetail).getHibernateLazyInitializer().getImplementation())));
        }          
        
        if(!ConstrainableUtilities.hasSameConstraint(invoice, paymentDetail.getInvoice())) {
            return false;
        }
        
        return getPaymentType() == paymentDetail.getPaymentType();
    }

    @Override
    public boolean hasSameParameters(PaymentDetail paymentDetail) {
        
        if(this == paymentDetail) {
            return true;
        }
        
        if(paymentDetail == null) {
            return false;
        }
          
        if(this instanceof HibernateProxy) {
            return paymentDetail.hasSameParameters((PaymentDetail)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation());
        }

        if(paymentDetail instanceof HibernateProxy) {
            return hasSameParameters(((PaymentDetail)(((HibernateProxy)paymentDetail).getHibernateLazyInitializer().getImplementation())));
        }          
        
        if(!ConstrainableUtilities.hasSameParameters(invoice, paymentDetail.getInvoice())) {
            return false;
        }
        
        if(currencyCode != paymentDetail.getCurrencyCode()) {
            return false;
        }
        
        if(!NumberUtilities.equals(subtotal, paymentDetail.getSubtotal(), 2)) {
            return false;
        }
        
        return getPaymentType() == paymentDetail.getPaymentType();
    }
    
    @Override
    public PaymentType getPaymentType() {
        return idObject == null ? null : idObject.getPaymentType();
    }

    @Override
    public void setPaymentType(PaymentType paymentType) {
        
        if(idObject == null) {
            idObject = new PaymentDetailIdPojo(paymentType);
        }
      
        idObject.setPaymentType(paymentType);
    }

    @Override
    public int getId() {
        return idObject == null ? 0 : idObject.getId();
    }

    @Override
    public void setId(int id) {
        
        if(idObject == null) {
            throw new IllegalStateException("The payment ID cannot be setup until the payment type has been setup.");
        }
        
        idObject.setId(id);
    }

    @Override
    public int hashCode() {
        
        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }        
        
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idObject);
        hash = 59 * hash + Objects.hashCode(this.invoice);
        hash = 59 * hash + Objects.hashCode(this.subtotal);
        hash = 59 * hash + Objects.hashCode(this.currencyCode);
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
        
        final PaymentDetailPojo other = (PaymentDetailPojo) obj;
        if (!Objects.equals(this.idObject, other.idObject)) {
            return false;
        }
        
        if (!Objects.equals(this.invoice, other.invoice)) {
            return false;
        }
        
        if (!NumberUtilities.equals(this.subtotal, other.subtotal, 2)) {
            return false;
        }
        
        return this.currencyCode == other.currencyCode;
    }

    @Override
    public String toString() {
        return "PaymentDetailPojo{id=" + (idObject == null ? 0 : idObject.getId()) + ", invoice number=" + (invoice == null ? null : invoice.getReferenceNumber()) + '}';
    }
}
