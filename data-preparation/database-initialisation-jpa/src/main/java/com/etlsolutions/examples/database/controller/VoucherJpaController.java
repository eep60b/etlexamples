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
import com.etlsolutions.examples.database.entity.Customer;
import com.etlsolutions.examples.database.entity.PaymentDetail;
import com.etlsolutions.examples.database.entity.Voucher;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class VoucherJpaController implements Serializable {

    public VoucherJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Voucher voucher) throws PreexistingEntityException, Exception {
        if (voucher.getPaymentDetailSet() == null) {
            voucher.setPaymentDetailSet(new HashSet<PaymentDetail>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customerId = voucher.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCustomerId());
                voucher.setCustomerId(customerId);
            }
            Set<PaymentDetail> attachedPaymentDetailSet = new HashSet<PaymentDetail>();
            for (PaymentDetail paymentDetailSetPaymentDetailToAttach : voucher.getPaymentDetailSet()) {
                paymentDetailSetPaymentDetailToAttach = em.getReference(paymentDetailSetPaymentDetailToAttach.getClass(), paymentDetailSetPaymentDetailToAttach.getPaymentDetailPK());
                attachedPaymentDetailSet.add(paymentDetailSetPaymentDetailToAttach);
            }
            voucher.setPaymentDetailSet(attachedPaymentDetailSet);
            em.persist(voucher);
            if (customerId != null) {
                customerId.getVoucherSet().add(voucher);
                customerId = em.merge(customerId);
            }
            for (PaymentDetail paymentDetailSetPaymentDetail : voucher.getPaymentDetailSet()) {
                paymentDetailSetPaymentDetail.getVoucherSet().add(voucher);
                paymentDetailSetPaymentDetail = em.merge(paymentDetailSetPaymentDetail);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVoucher(voucher.getVoucherId()) != null) {
                throw new PreexistingEntityException("Voucher " + voucher + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Voucher voucher) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voucher persistentVoucher = em.find(Voucher.class, voucher.getVoucherId());
            Customer customerIdOld = persistentVoucher.getCustomerId();
            Customer customerIdNew = voucher.getCustomerId();
            Set<PaymentDetail> paymentDetailSetOld = persistentVoucher.getPaymentDetailSet();
            Set<PaymentDetail> paymentDetailSetNew = voucher.getPaymentDetailSet();
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCustomerId());
                voucher.setCustomerId(customerIdNew);
            }
            Set<PaymentDetail> attachedPaymentDetailSetNew = new HashSet<PaymentDetail>();
            for (PaymentDetail paymentDetailSetNewPaymentDetailToAttach : paymentDetailSetNew) {
                paymentDetailSetNewPaymentDetailToAttach = em.getReference(paymentDetailSetNewPaymentDetailToAttach.getClass(), paymentDetailSetNewPaymentDetailToAttach.getPaymentDetailPK());
                attachedPaymentDetailSetNew.add(paymentDetailSetNewPaymentDetailToAttach);
            }
            paymentDetailSetNew = attachedPaymentDetailSetNew;
            voucher.setPaymentDetailSet(paymentDetailSetNew);
            voucher = em.merge(voucher);
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getVoucherSet().remove(voucher);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getVoucherSet().add(voucher);
                customerIdNew = em.merge(customerIdNew);
            }
            for (PaymentDetail paymentDetailSetOldPaymentDetail : paymentDetailSetOld) {
                if (!paymentDetailSetNew.contains(paymentDetailSetOldPaymentDetail)) {
                    paymentDetailSetOldPaymentDetail.getVoucherSet().remove(voucher);
                    paymentDetailSetOldPaymentDetail = em.merge(paymentDetailSetOldPaymentDetail);
                }
            }
            for (PaymentDetail paymentDetailSetNewPaymentDetail : paymentDetailSetNew) {
                if (!paymentDetailSetOld.contains(paymentDetailSetNewPaymentDetail)) {
                    paymentDetailSetNewPaymentDetail.getVoucherSet().add(voucher);
                    paymentDetailSetNewPaymentDetail = em.merge(paymentDetailSetNewPaymentDetail);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = voucher.getVoucherId();
                if (findVoucher(id) == null) {
                    throw new NonexistentEntityException("The voucher with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voucher voucher;
            try {
                voucher = em.getReference(Voucher.class, id);
                voucher.getVoucherId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The voucher with id " + id + " no longer exists.", enfe);
            }
            Customer customerId = voucher.getCustomerId();
            if (customerId != null) {
                customerId.getVoucherSet().remove(voucher);
                customerId = em.merge(customerId);
            }
            Set<PaymentDetail> paymentDetailSet = voucher.getPaymentDetailSet();
            for (PaymentDetail paymentDetailSetPaymentDetail : paymentDetailSet) {
                paymentDetailSetPaymentDetail.getVoucherSet().remove(voucher);
                paymentDetailSetPaymentDetail = em.merge(paymentDetailSetPaymentDetail);
            }
            em.remove(voucher);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Voucher> findVoucherEntities() {
        return findVoucherEntities(true, -1, -1);
    }

    public List<Voucher> findVoucherEntities(int maxResults, int firstResult) {
        return findVoucherEntities(false, maxResults, firstResult);
    }

    private List<Voucher> findVoucherEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Voucher.class));
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

    public Voucher findVoucher(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Voucher.class, id);
        } finally {
            em.close();
        }
    }

    public int getVoucherCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Voucher> rt = cq.from(Voucher.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
