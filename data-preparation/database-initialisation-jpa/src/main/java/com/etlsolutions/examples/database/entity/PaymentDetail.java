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
package com.etlsolutions.examples.database.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "payment_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentDetail.findAll", query = "SELECT p FROM PaymentDetail p"),
    @NamedQuery(name = "PaymentDetail.findByPaymentDetailId", query = "SELECT p FROM PaymentDetail p WHERE p.paymentDetailPK.paymentDetailId = :paymentDetailId"),
    @NamedQuery(name = "PaymentDetail.findByPaymentType", query = "SELECT p FROM PaymentDetail p WHERE p.paymentDetailPK.paymentType = :paymentType"),
    @NamedQuery(name = "PaymentDetail.findBySubtotal", query = "SELECT p FROM PaymentDetail p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "PaymentDetail.findByCurrencyCode", query = "SELECT p FROM PaymentDetail p WHERE p.currencyCode = :currencyCode")})
public class PaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentDetailPK paymentDetailPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @Column(name = "currency_code")
    private String currencyCode;
    @JoinTable(name = "voucher_payment", joinColumns = {
        @JoinColumn(name = "payment_detail_id", referencedColumnName = "payment_detail_id"),
        @JoinColumn(name = "payment_type", referencedColumnName = "payment_type")}, inverseJoinColumns = {
        @JoinColumn(name = "voucher_id", referencedColumnName = "voucher_id")})
    @ManyToMany
    private Set<Voucher> voucherSet;
    @OneToMany(mappedBy = "paymentDetail")
    private Set<MastercardPayment> mastercardPaymentSet;
    @OneToMany(mappedBy = "paymentDetail")
    private Set<VisacardPayment> visacardPaymentSet;
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    @ManyToOne
    private Invoice invoiceId;
    @OneToMany(mappedBy = "paymentDetail")
    private Set<AmexcardPayment> amexcardPaymentSet;
    @OneToMany(mappedBy = "paymentDetail")
    private Set<PaypalPayment> paypalPaymentSet;
    @OneToMany(mappedBy = "paymentDetail")
    private Set<DebitcardPayment> debitcardPaymentSet;

    public PaymentDetail() {
    }

    public PaymentDetail(PaymentDetailPK paymentDetailPK) {
        this.paymentDetailPK = paymentDetailPK;
    }

    public PaymentDetail(PaymentDetailPK paymentDetailPK, BigDecimal subtotal, String currencyCode) {
        this.paymentDetailPK = paymentDetailPK;
        this.subtotal = subtotal;
        this.currencyCode = currencyCode;
    }

    public PaymentDetail(int paymentDetailId, String paymentType) {
        this.paymentDetailPK = new PaymentDetailPK(paymentDetailId, paymentType);
    }

    public PaymentDetailPK getPaymentDetailPK() {
        return paymentDetailPK;
    }

    public void setPaymentDetailPK(PaymentDetailPK paymentDetailPK) {
        this.paymentDetailPK = paymentDetailPK;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @XmlTransient
    public Set<Voucher> getVoucherSet() {
        return voucherSet;
    }

    public void setVoucherSet(Set<Voucher> voucherSet) {
        this.voucherSet = voucherSet;
    }

    @XmlTransient
    public Set<MastercardPayment> getMastercardPaymentSet() {
        return mastercardPaymentSet;
    }

    public void setMastercardPaymentSet(Set<MastercardPayment> mastercardPaymentSet) {
        this.mastercardPaymentSet = mastercardPaymentSet;
    }

    @XmlTransient
    public Set<VisacardPayment> getVisacardPaymentSet() {
        return visacardPaymentSet;
    }

    public void setVisacardPaymentSet(Set<VisacardPayment> visacardPaymentSet) {
        this.visacardPaymentSet = visacardPaymentSet;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    @XmlTransient
    public Set<AmexcardPayment> getAmexcardPaymentSet() {
        return amexcardPaymentSet;
    }

    public void setAmexcardPaymentSet(Set<AmexcardPayment> amexcardPaymentSet) {
        this.amexcardPaymentSet = amexcardPaymentSet;
    }

    @XmlTransient
    public Set<PaypalPayment> getPaypalPaymentSet() {
        return paypalPaymentSet;
    }

    public void setPaypalPaymentSet(Set<PaypalPayment> paypalPaymentSet) {
        this.paypalPaymentSet = paypalPaymentSet;
    }

    @XmlTransient
    public Set<DebitcardPayment> getDebitcardPaymentSet() {
        return debitcardPaymentSet;
    }

    public void setDebitcardPaymentSet(Set<DebitcardPayment> debitcardPaymentSet) {
        this.debitcardPaymentSet = debitcardPaymentSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentDetailPK != null ? paymentDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDetail)) {
            return false;
        }
        PaymentDetail other = (PaymentDetail) object;
        if ((this.paymentDetailPK == null && other.paymentDetailPK != null) || (this.paymentDetailPK != null && !this.paymentDetailPK.equals(other.paymentDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.entity.PaymentDetail[ paymentDetailPK=" + paymentDetailPK + " ]";
    }
    
}
