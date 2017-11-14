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
package com.etlsolutions.examples.database.controller;

import com.etlsolutions.examples.database.controller.exceptions.NonexistentEntityException;
import com.etlsolutions.examples.database.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.entity.Invoice;
import com.etlsolutions.examples.database.entity.Voucher;
import java.util.HashSet;
import java.util.Set;
import com.etlsolutions.examples.database.entity.MastercardPayment;
import com.etlsolutions.examples.database.entity.VisacardPayment;
import com.etlsolutions.examples.database.entity.AmexcardPayment;
import com.etlsolutions.examples.database.entity.PaypalPayment;
import com.etlsolutions.examples.database.entity.DebitcardPayment;
import com.etlsolutions.examples.database.entity.PaymentDetail;
import com.etlsolutions.examples.database.entity.PaymentDetailPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class PaymentDetailJpaController implements Serializable {

    public PaymentDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaymentDetail paymentDetail) throws PreexistingEntityException, Exception {
        if (paymentDetail.getPaymentDetailPK() == null) {
            paymentDetail.setPaymentDetailPK(new PaymentDetailPK());
        }
        if (paymentDetail.getVoucherSet() == null) {
            paymentDetail.setVoucherSet(new HashSet<Voucher>());
        }
        if (paymentDetail.getMastercardPaymentSet() == null) {
            paymentDetail.setMastercardPaymentSet(new HashSet<MastercardPayment>());
        }
        if (paymentDetail.getVisacardPaymentSet() == null) {
            paymentDetail.setVisacardPaymentSet(new HashSet<VisacardPayment>());
        }
        if (paymentDetail.getAmexcardPaymentSet() == null) {
            paymentDetail.setAmexcardPaymentSet(new HashSet<AmexcardPayment>());
        }
        if (paymentDetail.getPaypalPaymentSet() == null) {
            paymentDetail.setPaypalPaymentSet(new HashSet<PaypalPayment>());
        }
        if (paymentDetail.getDebitcardPaymentSet() == null) {
            paymentDetail.setDebitcardPaymentSet(new HashSet<DebitcardPayment>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Invoice invoiceId = paymentDetail.getInvoiceId();
            if (invoiceId != null) {
                invoiceId = em.getReference(invoiceId.getClass(), invoiceId.getInvoiceId());
                paymentDetail.setInvoiceId(invoiceId);
            }
            Set<Voucher> attachedVoucherSet = new HashSet<Voucher>();
            for (Voucher voucherSetVoucherToAttach : paymentDetail.getVoucherSet()) {
                voucherSetVoucherToAttach = em.getReference(voucherSetVoucherToAttach.getClass(), voucherSetVoucherToAttach.getVoucherId());
                attachedVoucherSet.add(voucherSetVoucherToAttach);
            }
            paymentDetail.setVoucherSet(attachedVoucherSet);
            Set<MastercardPayment> attachedMastercardPaymentSet = new HashSet<MastercardPayment>();
            for (MastercardPayment mastercardPaymentSetMastercardPaymentToAttach : paymentDetail.getMastercardPaymentSet()) {
                mastercardPaymentSetMastercardPaymentToAttach = em.getReference(mastercardPaymentSetMastercardPaymentToAttach.getClass(), mastercardPaymentSetMastercardPaymentToAttach.getPaymentId());
                attachedMastercardPaymentSet.add(mastercardPaymentSetMastercardPaymentToAttach);
            }
            paymentDetail.setMastercardPaymentSet(attachedMastercardPaymentSet);
            Set<VisacardPayment> attachedVisacardPaymentSet = new HashSet<VisacardPayment>();
            for (VisacardPayment visacardPaymentSetVisacardPaymentToAttach : paymentDetail.getVisacardPaymentSet()) {
                visacardPaymentSetVisacardPaymentToAttach = em.getReference(visacardPaymentSetVisacardPaymentToAttach.getClass(), visacardPaymentSetVisacardPaymentToAttach.getPaymentId());
                attachedVisacardPaymentSet.add(visacardPaymentSetVisacardPaymentToAttach);
            }
            paymentDetail.setVisacardPaymentSet(attachedVisacardPaymentSet);
            Set<AmexcardPayment> attachedAmexcardPaymentSet = new HashSet<AmexcardPayment>();
            for (AmexcardPayment amexcardPaymentSetAmexcardPaymentToAttach : paymentDetail.getAmexcardPaymentSet()) {
                amexcardPaymentSetAmexcardPaymentToAttach = em.getReference(amexcardPaymentSetAmexcardPaymentToAttach.getClass(), amexcardPaymentSetAmexcardPaymentToAttach.getPaymentId());
                attachedAmexcardPaymentSet.add(amexcardPaymentSetAmexcardPaymentToAttach);
            }
            paymentDetail.setAmexcardPaymentSet(attachedAmexcardPaymentSet);
            Set<PaypalPayment> attachedPaypalPaymentSet = new HashSet<PaypalPayment>();
            for (PaypalPayment paypalPaymentSetPaypalPaymentToAttach : paymentDetail.getPaypalPaymentSet()) {
                paypalPaymentSetPaypalPaymentToAttach = em.getReference(paypalPaymentSetPaypalPaymentToAttach.getClass(), paypalPaymentSetPaypalPaymentToAttach.getPaymentId());
                attachedPaypalPaymentSet.add(paypalPaymentSetPaypalPaymentToAttach);
            }
            paymentDetail.setPaypalPaymentSet(attachedPaypalPaymentSet);
            Set<DebitcardPayment> attachedDebitcardPaymentSet = new HashSet<DebitcardPayment>();
            for (DebitcardPayment debitcardPaymentSetDebitcardPaymentToAttach : paymentDetail.getDebitcardPaymentSet()) {
                debitcardPaymentSetDebitcardPaymentToAttach = em.getReference(debitcardPaymentSetDebitcardPaymentToAttach.getClass(), debitcardPaymentSetDebitcardPaymentToAttach.getPaymentId());
                attachedDebitcardPaymentSet.add(debitcardPaymentSetDebitcardPaymentToAttach);
            }
            paymentDetail.setDebitcardPaymentSet(attachedDebitcardPaymentSet);
            em.persist(paymentDetail);
            if (invoiceId != null) {
                invoiceId.getPaymentDetailSet().add(paymentDetail);
                invoiceId = em.merge(invoiceId);
            }
            for (Voucher voucherSetVoucher : paymentDetail.getVoucherSet()) {
                voucherSetVoucher.getPaymentDetailSet().add(paymentDetail);
                voucherSetVoucher = em.merge(voucherSetVoucher);
            }
            for (MastercardPayment mastercardPaymentSetMastercardPayment : paymentDetail.getMastercardPaymentSet()) {
                PaymentDetail oldPaymentDetailOfMastercardPaymentSetMastercardPayment = mastercardPaymentSetMastercardPayment.getPaymentDetail();
                mastercardPaymentSetMastercardPayment.setPaymentDetail(paymentDetail);
                mastercardPaymentSetMastercardPayment = em.merge(mastercardPaymentSetMastercardPayment);
                if (oldPaymentDetailOfMastercardPaymentSetMastercardPayment != null) {
                    oldPaymentDetailOfMastercardPaymentSetMastercardPayment.getMastercardPaymentSet().remove(mastercardPaymentSetMastercardPayment);
                    oldPaymentDetailOfMastercardPaymentSetMastercardPayment = em.merge(oldPaymentDetailOfMastercardPaymentSetMastercardPayment);
                }
            }
            for (VisacardPayment visacardPaymentSetVisacardPayment : paymentDetail.getVisacardPaymentSet()) {
                PaymentDetail oldPaymentDetailOfVisacardPaymentSetVisacardPayment = visacardPaymentSetVisacardPayment.getPaymentDetail();
                visacardPaymentSetVisacardPayment.setPaymentDetail(paymentDetail);
                visacardPaymentSetVisacardPayment = em.merge(visacardPaymentSetVisacardPayment);
                if (oldPaymentDetailOfVisacardPaymentSetVisacardPayment != null) {
                    oldPaymentDetailOfVisacardPaymentSetVisacardPayment.getVisacardPaymentSet().remove(visacardPaymentSetVisacardPayment);
                    oldPaymentDetailOfVisacardPaymentSetVisacardPayment = em.merge(oldPaymentDetailOfVisacardPaymentSetVisacardPayment);
                }
            }
            for (AmexcardPayment amexcardPaymentSetAmexcardPayment : paymentDetail.getAmexcardPaymentSet()) {
                PaymentDetail oldPaymentDetailOfAmexcardPaymentSetAmexcardPayment = amexcardPaymentSetAmexcardPayment.getPaymentDetail();
                amexcardPaymentSetAmexcardPayment.setPaymentDetail(paymentDetail);
                amexcardPaymentSetAmexcardPayment = em.merge(amexcardPaymentSetAmexcardPayment);
                if (oldPaymentDetailOfAmexcardPaymentSetAmexcardPayment != null) {
                    oldPaymentDetailOfAmexcardPaymentSetAmexcardPayment.getAmexcardPaymentSet().remove(amexcardPaymentSetAmexcardPayment);
                    oldPaymentDetailOfAmexcardPaymentSetAmexcardPayment = em.merge(oldPaymentDetailOfAmexcardPaymentSetAmexcardPayment);
                }
            }
            for (PaypalPayment paypalPaymentSetPaypalPayment : paymentDetail.getPaypalPaymentSet()) {
                PaymentDetail oldPaymentDetailOfPaypalPaymentSetPaypalPayment = paypalPaymentSetPaypalPayment.getPaymentDetail();
                paypalPaymentSetPaypalPayment.setPaymentDetail(paymentDetail);
                paypalPaymentSetPaypalPayment = em.merge(paypalPaymentSetPaypalPayment);
                if (oldPaymentDetailOfPaypalPaymentSetPaypalPayment != null) {
                    oldPaymentDetailOfPaypalPaymentSetPaypalPayment.getPaypalPaymentSet().remove(paypalPaymentSetPaypalPayment);
                    oldPaymentDetailOfPaypalPaymentSetPaypalPayment = em.merge(oldPaymentDetailOfPaypalPaymentSetPaypalPayment);
                }
            }
            for (DebitcardPayment debitcardPaymentSetDebitcardPayment : paymentDetail.getDebitcardPaymentSet()) {
                PaymentDetail oldPaymentDetailOfDebitcardPaymentSetDebitcardPayment = debitcardPaymentSetDebitcardPayment.getPaymentDetail();
                debitcardPaymentSetDebitcardPayment.setPaymentDetail(paymentDetail);
                debitcardPaymentSetDebitcardPayment = em.merge(debitcardPaymentSetDebitcardPayment);
                if (oldPaymentDetailOfDebitcardPaymentSetDebitcardPayment != null) {
                    oldPaymentDetailOfDebitcardPaymentSetDebitcardPayment.getDebitcardPaymentSet().remove(debitcardPaymentSetDebitcardPayment);
                    oldPaymentDetailOfDebitcardPaymentSetDebitcardPayment = em.merge(oldPaymentDetailOfDebitcardPaymentSetDebitcardPayment);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaymentDetail(paymentDetail.getPaymentDetailPK()) != null) {
                throw new PreexistingEntityException("PaymentDetail " + paymentDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PaymentDetail paymentDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentDetail persistentPaymentDetail = em.find(PaymentDetail.class, paymentDetail.getPaymentDetailPK());
            Invoice invoiceIdOld = persistentPaymentDetail.getInvoiceId();
            Invoice invoiceIdNew = paymentDetail.getInvoiceId();
            Set<Voucher> voucherSetOld = persistentPaymentDetail.getVoucherSet();
            Set<Voucher> voucherSetNew = paymentDetail.getVoucherSet();
            Set<MastercardPayment> mastercardPaymentSetOld = persistentPaymentDetail.getMastercardPaymentSet();
            Set<MastercardPayment> mastercardPaymentSetNew = paymentDetail.getMastercardPaymentSet();
            Set<VisacardPayment> visacardPaymentSetOld = persistentPaymentDetail.getVisacardPaymentSet();
            Set<VisacardPayment> visacardPaymentSetNew = paymentDetail.getVisacardPaymentSet();
            Set<AmexcardPayment> amexcardPaymentSetOld = persistentPaymentDetail.getAmexcardPaymentSet();
            Set<AmexcardPayment> amexcardPaymentSetNew = paymentDetail.getAmexcardPaymentSet();
            Set<PaypalPayment> paypalPaymentSetOld = persistentPaymentDetail.getPaypalPaymentSet();
            Set<PaypalPayment> paypalPaymentSetNew = paymentDetail.getPaypalPaymentSet();
            Set<DebitcardPayment> debitcardPaymentSetOld = persistentPaymentDetail.getDebitcardPaymentSet();
            Set<DebitcardPayment> debitcardPaymentSetNew = paymentDetail.getDebitcardPaymentSet();
            if (invoiceIdNew != null) {
                invoiceIdNew = em.getReference(invoiceIdNew.getClass(), invoiceIdNew.getInvoiceId());
                paymentDetail.setInvoiceId(invoiceIdNew);
            }
            Set<Voucher> attachedVoucherSetNew = new HashSet<Voucher>();
            for (Voucher voucherSetNewVoucherToAttach : voucherSetNew) {
                voucherSetNewVoucherToAttach = em.getReference(voucherSetNewVoucherToAttach.getClass(), voucherSetNewVoucherToAttach.getVoucherId());
                attachedVoucherSetNew.add(voucherSetNewVoucherToAttach);
            }
            voucherSetNew = attachedVoucherSetNew;
            paymentDetail.setVoucherSet(voucherSetNew);
            Set<MastercardPayment> attachedMastercardPaymentSetNew = new HashSet<MastercardPayment>();
            for (MastercardPayment mastercardPaymentSetNewMastercardPaymentToAttach : mastercardPaymentSetNew) {
                mastercardPaymentSetNewMastercardPaymentToAttach = em.getReference(mastercardPaymentSetNewMastercardPaymentToAttach.getClass(), mastercardPaymentSetNewMastercardPaymentToAttach.getPaymentId());
                attachedMastercardPaymentSetNew.add(mastercardPaymentSetNewMastercardPaymentToAttach);
            }
            mastercardPaymentSetNew = attachedMastercardPaymentSetNew;
            paymentDetail.setMastercardPaymentSet(mastercardPaymentSetNew);
            Set<VisacardPayment> attachedVisacardPaymentSetNew = new HashSet<VisacardPayment>();
            for (VisacardPayment visacardPaymentSetNewVisacardPaymentToAttach : visacardPaymentSetNew) {
                visacardPaymentSetNewVisacardPaymentToAttach = em.getReference(visacardPaymentSetNewVisacardPaymentToAttach.getClass(), visacardPaymentSetNewVisacardPaymentToAttach.getPaymentId());
                attachedVisacardPaymentSetNew.add(visacardPaymentSetNewVisacardPaymentToAttach);
            }
            visacardPaymentSetNew = attachedVisacardPaymentSetNew;
            paymentDetail.setVisacardPaymentSet(visacardPaymentSetNew);
            Set<AmexcardPayment> attachedAmexcardPaymentSetNew = new HashSet<AmexcardPayment>();
            for (AmexcardPayment amexcardPaymentSetNewAmexcardPaymentToAttach : amexcardPaymentSetNew) {
                amexcardPaymentSetNewAmexcardPaymentToAttach = em.getReference(amexcardPaymentSetNewAmexcardPaymentToAttach.getClass(), amexcardPaymentSetNewAmexcardPaymentToAttach.getPaymentId());
                attachedAmexcardPaymentSetNew.add(amexcardPaymentSetNewAmexcardPaymentToAttach);
            }
            amexcardPaymentSetNew = attachedAmexcardPaymentSetNew;
            paymentDetail.setAmexcardPaymentSet(amexcardPaymentSetNew);
            Set<PaypalPayment> attachedPaypalPaymentSetNew = new HashSet<PaypalPayment>();
            for (PaypalPayment paypalPaymentSetNewPaypalPaymentToAttach : paypalPaymentSetNew) {
                paypalPaymentSetNewPaypalPaymentToAttach = em.getReference(paypalPaymentSetNewPaypalPaymentToAttach.getClass(), paypalPaymentSetNewPaypalPaymentToAttach.getPaymentId());
                attachedPaypalPaymentSetNew.add(paypalPaymentSetNewPaypalPaymentToAttach);
            }
            paypalPaymentSetNew = attachedPaypalPaymentSetNew;
            paymentDetail.setPaypalPaymentSet(paypalPaymentSetNew);
            Set<DebitcardPayment> attachedDebitcardPaymentSetNew = new HashSet<DebitcardPayment>();
            for (DebitcardPayment debitcardPaymentSetNewDebitcardPaymentToAttach : debitcardPaymentSetNew) {
                debitcardPaymentSetNewDebitcardPaymentToAttach = em.getReference(debitcardPaymentSetNewDebitcardPaymentToAttach.getClass(), debitcardPaymentSetNewDebitcardPaymentToAttach.getPaymentId());
                attachedDebitcardPaymentSetNew.add(debitcardPaymentSetNewDebitcardPaymentToAttach);
            }
            debitcardPaymentSetNew = attachedDebitcardPaymentSetNew;
            paymentDetail.setDebitcardPaymentSet(debitcardPaymentSetNew);
            paymentDetail = em.merge(paymentDetail);
            if (invoiceIdOld != null && !invoiceIdOld.equals(invoiceIdNew)) {
                invoiceIdOld.getPaymentDetailSet().remove(paymentDetail);
                invoiceIdOld = em.merge(invoiceIdOld);
            }
            if (invoiceIdNew != null && !invoiceIdNew.equals(invoiceIdOld)) {
                invoiceIdNew.getPaymentDetailSet().add(paymentDetail);
                invoiceIdNew = em.merge(invoiceIdNew);
            }
            for (Voucher voucherSetOldVoucher : voucherSetOld) {
                if (!voucherSetNew.contains(voucherSetOldVoucher)) {
                    voucherSetOldVoucher.getPaymentDetailSet().remove(paymentDetail);
                    voucherSetOldVoucher = em.merge(voucherSetOldVoucher);
                }
            }
            for (Voucher voucherSetNewVoucher : voucherSetNew) {
                if (!voucherSetOld.contains(voucherSetNewVoucher)) {
                    voucherSetNewVoucher.getPaymentDetailSet().add(paymentDetail);
                    voucherSetNewVoucher = em.merge(voucherSetNewVoucher);
                }
            }
            for (MastercardPayment mastercardPaymentSetOldMastercardPayment : mastercardPaymentSetOld) {
                if (!mastercardPaymentSetNew.contains(mastercardPaymentSetOldMastercardPayment)) {
                    mastercardPaymentSetOldMastercardPayment.setPaymentDetail(null);
                    mastercardPaymentSetOldMastercardPayment = em.merge(mastercardPaymentSetOldMastercardPayment);
                }
            }
            for (MastercardPayment mastercardPaymentSetNewMastercardPayment : mastercardPaymentSetNew) {
                if (!mastercardPaymentSetOld.contains(mastercardPaymentSetNewMastercardPayment)) {
                    PaymentDetail oldPaymentDetailOfMastercardPaymentSetNewMastercardPayment = mastercardPaymentSetNewMastercardPayment.getPaymentDetail();
                    mastercardPaymentSetNewMastercardPayment.setPaymentDetail(paymentDetail);
                    mastercardPaymentSetNewMastercardPayment = em.merge(mastercardPaymentSetNewMastercardPayment);
                    if (oldPaymentDetailOfMastercardPaymentSetNewMastercardPayment != null && !oldPaymentDetailOfMastercardPaymentSetNewMastercardPayment.equals(paymentDetail)) {
                        oldPaymentDetailOfMastercardPaymentSetNewMastercardPayment.getMastercardPaymentSet().remove(mastercardPaymentSetNewMastercardPayment);
                        oldPaymentDetailOfMastercardPaymentSetNewMastercardPayment = em.merge(oldPaymentDetailOfMastercardPaymentSetNewMastercardPayment);
                    }
                }
            }
            for (VisacardPayment visacardPaymentSetOldVisacardPayment : visacardPaymentSetOld) {
                if (!visacardPaymentSetNew.contains(visacardPaymentSetOldVisacardPayment)) {
                    visacardPaymentSetOldVisacardPayment.setPaymentDetail(null);
                    visacardPaymentSetOldVisacardPayment = em.merge(visacardPaymentSetOldVisacardPayment);
                }
            }
            for (VisacardPayment visacardPaymentSetNewVisacardPayment : visacardPaymentSetNew) {
                if (!visacardPaymentSetOld.contains(visacardPaymentSetNewVisacardPayment)) {
                    PaymentDetail oldPaymentDetailOfVisacardPaymentSetNewVisacardPayment = visacardPaymentSetNewVisacardPayment.getPaymentDetail();
                    visacardPaymentSetNewVisacardPayment.setPaymentDetail(paymentDetail);
                    visacardPaymentSetNewVisacardPayment = em.merge(visacardPaymentSetNewVisacardPayment);
                    if (oldPaymentDetailOfVisacardPaymentSetNewVisacardPayment != null && !oldPaymentDetailOfVisacardPaymentSetNewVisacardPayment.equals(paymentDetail)) {
                        oldPaymentDetailOfVisacardPaymentSetNewVisacardPayment.getVisacardPaymentSet().remove(visacardPaymentSetNewVisacardPayment);
                        oldPaymentDetailOfVisacardPaymentSetNewVisacardPayment = em.merge(oldPaymentDetailOfVisacardPaymentSetNewVisacardPayment);
                    }
                }
            }
            for (AmexcardPayment amexcardPaymentSetOldAmexcardPayment : amexcardPaymentSetOld) {
                if (!amexcardPaymentSetNew.contains(amexcardPaymentSetOldAmexcardPayment)) {
                    amexcardPaymentSetOldAmexcardPayment.setPaymentDetail(null);
                    amexcardPaymentSetOldAmexcardPayment = em.merge(amexcardPaymentSetOldAmexcardPayment);
                }
            }
            for (AmexcardPayment amexcardPaymentSetNewAmexcardPayment : amexcardPaymentSetNew) {
                if (!amexcardPaymentSetOld.contains(amexcardPaymentSetNewAmexcardPayment)) {
                    PaymentDetail oldPaymentDetailOfAmexcardPaymentSetNewAmexcardPayment = amexcardPaymentSetNewAmexcardPayment.getPaymentDetail();
                    amexcardPaymentSetNewAmexcardPayment.setPaymentDetail(paymentDetail);
                    amexcardPaymentSetNewAmexcardPayment = em.merge(amexcardPaymentSetNewAmexcardPayment);
                    if (oldPaymentDetailOfAmexcardPaymentSetNewAmexcardPayment != null && !oldPaymentDetailOfAmexcardPaymentSetNewAmexcardPayment.equals(paymentDetail)) {
                        oldPaymentDetailOfAmexcardPaymentSetNewAmexcardPayment.getAmexcardPaymentSet().remove(amexcardPaymentSetNewAmexcardPayment);
                        oldPaymentDetailOfAmexcardPaymentSetNewAmexcardPayment = em.merge(oldPaymentDetailOfAmexcardPaymentSetNewAmexcardPayment);
                    }
                }
            }
            for (PaypalPayment paypalPaymentSetOldPaypalPayment : paypalPaymentSetOld) {
                if (!paypalPaymentSetNew.contains(paypalPaymentSetOldPaypalPayment)) {
                    paypalPaymentSetOldPaypalPayment.setPaymentDetail(null);
                    paypalPaymentSetOldPaypalPayment = em.merge(paypalPaymentSetOldPaypalPayment);
                }
            }
            for (PaypalPayment paypalPaymentSetNewPaypalPayment : paypalPaymentSetNew) {
                if (!paypalPaymentSetOld.contains(paypalPaymentSetNewPaypalPayment)) {
                    PaymentDetail oldPaymentDetailOfPaypalPaymentSetNewPaypalPayment = paypalPaymentSetNewPaypalPayment.getPaymentDetail();
                    paypalPaymentSetNewPaypalPayment.setPaymentDetail(paymentDetail);
                    paypalPaymentSetNewPaypalPayment = em.merge(paypalPaymentSetNewPaypalPayment);
                    if (oldPaymentDetailOfPaypalPaymentSetNewPaypalPayment != null && !oldPaymentDetailOfPaypalPaymentSetNewPaypalPayment.equals(paymentDetail)) {
                        oldPaymentDetailOfPaypalPaymentSetNewPaypalPayment.getPaypalPaymentSet().remove(paypalPaymentSetNewPaypalPayment);
                        oldPaymentDetailOfPaypalPaymentSetNewPaypalPayment = em.merge(oldPaymentDetailOfPaypalPaymentSetNewPaypalPayment);
                    }
                }
            }
            for (DebitcardPayment debitcardPaymentSetOldDebitcardPayment : debitcardPaymentSetOld) {
                if (!debitcardPaymentSetNew.contains(debitcardPaymentSetOldDebitcardPayment)) {
                    debitcardPaymentSetOldDebitcardPayment.setPaymentDetail(null);
                    debitcardPaymentSetOldDebitcardPayment = em.merge(debitcardPaymentSetOldDebitcardPayment);
                }
            }
            for (DebitcardPayment debitcardPaymentSetNewDebitcardPayment : debitcardPaymentSetNew) {
                if (!debitcardPaymentSetOld.contains(debitcardPaymentSetNewDebitcardPayment)) {
                    PaymentDetail oldPaymentDetailOfDebitcardPaymentSetNewDebitcardPayment = debitcardPaymentSetNewDebitcardPayment.getPaymentDetail();
                    debitcardPaymentSetNewDebitcardPayment.setPaymentDetail(paymentDetail);
                    debitcardPaymentSetNewDebitcardPayment = em.merge(debitcardPaymentSetNewDebitcardPayment);
                    if (oldPaymentDetailOfDebitcardPaymentSetNewDebitcardPayment != null && !oldPaymentDetailOfDebitcardPaymentSetNewDebitcardPayment.equals(paymentDetail)) {
                        oldPaymentDetailOfDebitcardPaymentSetNewDebitcardPayment.getDebitcardPaymentSet().remove(debitcardPaymentSetNewDebitcardPayment);
                        oldPaymentDetailOfDebitcardPaymentSetNewDebitcardPayment = em.merge(oldPaymentDetailOfDebitcardPaymentSetNewDebitcardPayment);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PaymentDetailPK id = paymentDetail.getPaymentDetailPK();
                if (findPaymentDetail(id) == null) {
                    throw new NonexistentEntityException("The paymentDetail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PaymentDetailPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentDetail paymentDetail;
            try {
                paymentDetail = em.getReference(PaymentDetail.class, id);
                paymentDetail.getPaymentDetailPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paymentDetail with id " + id + " no longer exists.", enfe);
            }
            Invoice invoiceId = paymentDetail.getInvoiceId();
            if (invoiceId != null) {
                invoiceId.getPaymentDetailSet().remove(paymentDetail);
                invoiceId = em.merge(invoiceId);
            }
            Set<Voucher> voucherSet = paymentDetail.getVoucherSet();
            for (Voucher voucherSetVoucher : voucherSet) {
                voucherSetVoucher.getPaymentDetailSet().remove(paymentDetail);
                voucherSetVoucher = em.merge(voucherSetVoucher);
            }
            Set<MastercardPayment> mastercardPaymentSet = paymentDetail.getMastercardPaymentSet();
            for (MastercardPayment mastercardPaymentSetMastercardPayment : mastercardPaymentSet) {
                mastercardPaymentSetMastercardPayment.setPaymentDetail(null);
                mastercardPaymentSetMastercardPayment = em.merge(mastercardPaymentSetMastercardPayment);
            }
            Set<VisacardPayment> visacardPaymentSet = paymentDetail.getVisacardPaymentSet();
            for (VisacardPayment visacardPaymentSetVisacardPayment : visacardPaymentSet) {
                visacardPaymentSetVisacardPayment.setPaymentDetail(null);
                visacardPaymentSetVisacardPayment = em.merge(visacardPaymentSetVisacardPayment);
            }
            Set<AmexcardPayment> amexcardPaymentSet = paymentDetail.getAmexcardPaymentSet();
            for (AmexcardPayment amexcardPaymentSetAmexcardPayment : amexcardPaymentSet) {
                amexcardPaymentSetAmexcardPayment.setPaymentDetail(null);
                amexcardPaymentSetAmexcardPayment = em.merge(amexcardPaymentSetAmexcardPayment);
            }
            Set<PaypalPayment> paypalPaymentSet = paymentDetail.getPaypalPaymentSet();
            for (PaypalPayment paypalPaymentSetPaypalPayment : paypalPaymentSet) {
                paypalPaymentSetPaypalPayment.setPaymentDetail(null);
                paypalPaymentSetPaypalPayment = em.merge(paypalPaymentSetPaypalPayment);
            }
            Set<DebitcardPayment> debitcardPaymentSet = paymentDetail.getDebitcardPaymentSet();
            for (DebitcardPayment debitcardPaymentSetDebitcardPayment : debitcardPaymentSet) {
                debitcardPaymentSetDebitcardPayment.setPaymentDetail(null);
                debitcardPaymentSetDebitcardPayment = em.merge(debitcardPaymentSetDebitcardPayment);
            }
            em.remove(paymentDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PaymentDetail> findPaymentDetailEntities() {
        return findPaymentDetailEntities(true, -1, -1);
    }

    public List<PaymentDetail> findPaymentDetailEntities(int maxResults, int firstResult) {
        return findPaymentDetailEntities(false, maxResults, firstResult);
    }

    private List<PaymentDetail> findPaymentDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaymentDetail.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PaymentDetail findPaymentDetail(PaymentDetailPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaymentDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaymentDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaymentDetail> rt = cq.from(PaymentDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
