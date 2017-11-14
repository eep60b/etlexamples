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
import com.etlsolutions.examples.database.entity.Address;
import com.etlsolutions.examples.database.entity.Customer;
import com.etlsolutions.examples.database.entity.Invoice;
import com.etlsolutions.examples.database.entity.SoldItem;
import java.util.HashSet;
import java.util.Set;
import com.etlsolutions.examples.database.entity.PaymentDetail;
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
public class InvoiceJpaController implements Serializable {

    public InvoiceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Invoice invoice) throws PreexistingEntityException, Exception {
        if (invoice.getSoldItemSet() == null) {
            invoice.setSoldItemSet(new HashSet<SoldItem>());
        }
        if (invoice.getPaymentDetailSet() == null) {
            invoice.setPaymentDetailSet(new HashSet<PaymentDetail>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address deliveryAddressId = invoice.getDeliveryAddressId();
            if (deliveryAddressId != null) {
                deliveryAddressId = em.getReference(deliveryAddressId.getClass(), deliveryAddressId.getAddressId());
                invoice.setDeliveryAddressId(deliveryAddressId);
            }
            Customer customerId = invoice.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCustomerId());
                invoice.setCustomerId(customerId);
            }
            Set<SoldItem> attachedSoldItemSet = new HashSet<SoldItem>();
            for (SoldItem soldItemSetSoldItemToAttach : invoice.getSoldItemSet()) {
                soldItemSetSoldItemToAttach = em.getReference(soldItemSetSoldItemToAttach.getClass(), soldItemSetSoldItemToAttach.getSoldItemId());
                attachedSoldItemSet.add(soldItemSetSoldItemToAttach);
            }
            invoice.setSoldItemSet(attachedSoldItemSet);
            Set<PaymentDetail> attachedPaymentDetailSet = new HashSet<PaymentDetail>();
            for (PaymentDetail paymentDetailSetPaymentDetailToAttach : invoice.getPaymentDetailSet()) {
                paymentDetailSetPaymentDetailToAttach = em.getReference(paymentDetailSetPaymentDetailToAttach.getClass(), paymentDetailSetPaymentDetailToAttach.getPaymentDetailPK());
                attachedPaymentDetailSet.add(paymentDetailSetPaymentDetailToAttach);
            }
            invoice.setPaymentDetailSet(attachedPaymentDetailSet);
            em.persist(invoice);
            if (deliveryAddressId != null) {
                deliveryAddressId.getInvoiceSet().add(invoice);
                deliveryAddressId = em.merge(deliveryAddressId);
            }
            if (customerId != null) {
                customerId.getInvoiceSet().add(invoice);
                customerId = em.merge(customerId);
            }
            for (SoldItem soldItemSetSoldItem : invoice.getSoldItemSet()) {
                Invoice oldInvoiceIdOfSoldItemSetSoldItem = soldItemSetSoldItem.getInvoiceId();
                soldItemSetSoldItem.setInvoiceId(invoice);
                soldItemSetSoldItem = em.merge(soldItemSetSoldItem);
                if (oldInvoiceIdOfSoldItemSetSoldItem != null) {
                    oldInvoiceIdOfSoldItemSetSoldItem.getSoldItemSet().remove(soldItemSetSoldItem);
                    oldInvoiceIdOfSoldItemSetSoldItem = em.merge(oldInvoiceIdOfSoldItemSetSoldItem);
                }
            }
            for (PaymentDetail paymentDetailSetPaymentDetail : invoice.getPaymentDetailSet()) {
                Invoice oldInvoiceIdOfPaymentDetailSetPaymentDetail = paymentDetailSetPaymentDetail.getInvoiceId();
                paymentDetailSetPaymentDetail.setInvoiceId(invoice);
                paymentDetailSetPaymentDetail = em.merge(paymentDetailSetPaymentDetail);
                if (oldInvoiceIdOfPaymentDetailSetPaymentDetail != null) {
                    oldInvoiceIdOfPaymentDetailSetPaymentDetail.getPaymentDetailSet().remove(paymentDetailSetPaymentDetail);
                    oldInvoiceIdOfPaymentDetailSetPaymentDetail = em.merge(oldInvoiceIdOfPaymentDetailSetPaymentDetail);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInvoice(invoice.getInvoiceId()) != null) {
                throw new PreexistingEntityException("Invoice " + invoice + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Invoice invoice) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Invoice persistentInvoice = em.find(Invoice.class, invoice.getInvoiceId());
            Address deliveryAddressIdOld = persistentInvoice.getDeliveryAddressId();
            Address deliveryAddressIdNew = invoice.getDeliveryAddressId();
            Customer customerIdOld = persistentInvoice.getCustomerId();
            Customer customerIdNew = invoice.getCustomerId();
            Set<SoldItem> soldItemSetOld = persistentInvoice.getSoldItemSet();
            Set<SoldItem> soldItemSetNew = invoice.getSoldItemSet();
            Set<PaymentDetail> paymentDetailSetOld = persistentInvoice.getPaymentDetailSet();
            Set<PaymentDetail> paymentDetailSetNew = invoice.getPaymentDetailSet();
            if (deliveryAddressIdNew != null) {
                deliveryAddressIdNew = em.getReference(deliveryAddressIdNew.getClass(), deliveryAddressIdNew.getAddressId());
                invoice.setDeliveryAddressId(deliveryAddressIdNew);
            }
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCustomerId());
                invoice.setCustomerId(customerIdNew);
            }
            Set<SoldItem> attachedSoldItemSetNew = new HashSet<SoldItem>();
            for (SoldItem soldItemSetNewSoldItemToAttach : soldItemSetNew) {
                soldItemSetNewSoldItemToAttach = em.getReference(soldItemSetNewSoldItemToAttach.getClass(), soldItemSetNewSoldItemToAttach.getSoldItemId());
                attachedSoldItemSetNew.add(soldItemSetNewSoldItemToAttach);
            }
            soldItemSetNew = attachedSoldItemSetNew;
            invoice.setSoldItemSet(soldItemSetNew);
            Set<PaymentDetail> attachedPaymentDetailSetNew = new HashSet<PaymentDetail>();
            for (PaymentDetail paymentDetailSetNewPaymentDetailToAttach : paymentDetailSetNew) {
                paymentDetailSetNewPaymentDetailToAttach = em.getReference(paymentDetailSetNewPaymentDetailToAttach.getClass(), paymentDetailSetNewPaymentDetailToAttach.getPaymentDetailPK());
                attachedPaymentDetailSetNew.add(paymentDetailSetNewPaymentDetailToAttach);
            }
            paymentDetailSetNew = attachedPaymentDetailSetNew;
            invoice.setPaymentDetailSet(paymentDetailSetNew);
            invoice = em.merge(invoice);
            if (deliveryAddressIdOld != null && !deliveryAddressIdOld.equals(deliveryAddressIdNew)) {
                deliveryAddressIdOld.getInvoiceSet().remove(invoice);
                deliveryAddressIdOld = em.merge(deliveryAddressIdOld);
            }
            if (deliveryAddressIdNew != null && !deliveryAddressIdNew.equals(deliveryAddressIdOld)) {
                deliveryAddressIdNew.getInvoiceSet().add(invoice);
                deliveryAddressIdNew = em.merge(deliveryAddressIdNew);
            }
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getInvoiceSet().remove(invoice);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getInvoiceSet().add(invoice);
                customerIdNew = em.merge(customerIdNew);
            }
            for (SoldItem soldItemSetOldSoldItem : soldItemSetOld) {
                if (!soldItemSetNew.contains(soldItemSetOldSoldItem)) {
                    soldItemSetOldSoldItem.setInvoiceId(null);
                    soldItemSetOldSoldItem = em.merge(soldItemSetOldSoldItem);
                }
            }
            for (SoldItem soldItemSetNewSoldItem : soldItemSetNew) {
                if (!soldItemSetOld.contains(soldItemSetNewSoldItem)) {
                    Invoice oldInvoiceIdOfSoldItemSetNewSoldItem = soldItemSetNewSoldItem.getInvoiceId();
                    soldItemSetNewSoldItem.setInvoiceId(invoice);
                    soldItemSetNewSoldItem = em.merge(soldItemSetNewSoldItem);
                    if (oldInvoiceIdOfSoldItemSetNewSoldItem != null && !oldInvoiceIdOfSoldItemSetNewSoldItem.equals(invoice)) {
                        oldInvoiceIdOfSoldItemSetNewSoldItem.getSoldItemSet().remove(soldItemSetNewSoldItem);
                        oldInvoiceIdOfSoldItemSetNewSoldItem = em.merge(oldInvoiceIdOfSoldItemSetNewSoldItem);
                    }
                }
            }
            for (PaymentDetail paymentDetailSetOldPaymentDetail : paymentDetailSetOld) {
                if (!paymentDetailSetNew.contains(paymentDetailSetOldPaymentDetail)) {
                    paymentDetailSetOldPaymentDetail.setInvoiceId(null);
                    paymentDetailSetOldPaymentDetail = em.merge(paymentDetailSetOldPaymentDetail);
                }
            }
            for (PaymentDetail paymentDetailSetNewPaymentDetail : paymentDetailSetNew) {
                if (!paymentDetailSetOld.contains(paymentDetailSetNewPaymentDetail)) {
                    Invoice oldInvoiceIdOfPaymentDetailSetNewPaymentDetail = paymentDetailSetNewPaymentDetail.getInvoiceId();
                    paymentDetailSetNewPaymentDetail.setInvoiceId(invoice);
                    paymentDetailSetNewPaymentDetail = em.merge(paymentDetailSetNewPaymentDetail);
                    if (oldInvoiceIdOfPaymentDetailSetNewPaymentDetail != null && !oldInvoiceIdOfPaymentDetailSetNewPaymentDetail.equals(invoice)) {
                        oldInvoiceIdOfPaymentDetailSetNewPaymentDetail.getPaymentDetailSet().remove(paymentDetailSetNewPaymentDetail);
                        oldInvoiceIdOfPaymentDetailSetNewPaymentDetail = em.merge(oldInvoiceIdOfPaymentDetailSetNewPaymentDetail);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = invoice.getInvoiceId();
                if (findInvoice(id) == null) {
                    throw new NonexistentEntityException("The invoice with id " + id + " no longer exists.");
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
            Invoice invoice;
            try {
                invoice = em.getReference(Invoice.class, id);
                invoice.getInvoiceId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The invoice with id " + id + " no longer exists.", enfe);
            }
            Address deliveryAddressId = invoice.getDeliveryAddressId();
            if (deliveryAddressId != null) {
                deliveryAddressId.getInvoiceSet().remove(invoice);
                deliveryAddressId = em.merge(deliveryAddressId);
            }
            Customer customerId = invoice.getCustomerId();
            if (customerId != null) {
                customerId.getInvoiceSet().remove(invoice);
                customerId = em.merge(customerId);
            }
            Set<SoldItem> soldItemSet = invoice.getSoldItemSet();
            for (SoldItem soldItemSetSoldItem : soldItemSet) {
                soldItemSetSoldItem.setInvoiceId(null);
                soldItemSetSoldItem = em.merge(soldItemSetSoldItem);
            }
            Set<PaymentDetail> paymentDetailSet = invoice.getPaymentDetailSet();
            for (PaymentDetail paymentDetailSetPaymentDetail : paymentDetailSet) {
                paymentDetailSetPaymentDetail.setInvoiceId(null);
                paymentDetailSetPaymentDetail = em.merge(paymentDetailSetPaymentDetail);
            }
            em.remove(invoice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Invoice> findInvoiceEntities() {
        return findInvoiceEntities(true, -1, -1);
    }

    public List<Invoice> findInvoiceEntities(int maxResults, int firstResult) {
        return findInvoiceEntities(false, maxResults, firstResult);
    }

    private List<Invoice> findInvoiceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Invoice.class));
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

    public Invoice findInvoice(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Invoice.class, id);
        } finally {
            em.close();
        }
    }

    public int getInvoiceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Invoice> rt = cq.from(Invoice.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
