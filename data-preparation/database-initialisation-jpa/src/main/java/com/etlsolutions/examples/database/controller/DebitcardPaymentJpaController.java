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
import com.etlsolutions.examples.database.entity.DebitcardPayment;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.entity.PaymentDetail;
import com.etlsolutions.examples.database.entity.PersonAddressLink;
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
public class DebitcardPaymentJpaController implements Serializable {

    public DebitcardPaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DebitcardPayment debitcardPayment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentDetail paymentDetail = debitcardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail = em.getReference(paymentDetail.getClass(), paymentDetail.getPaymentDetailPK());
                debitcardPayment.setPaymentDetail(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = debitcardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId = em.getReference(personAddressLinkId.getClass(), personAddressLinkId.getLinkId());
                debitcardPayment.setPersonAddressLinkId(personAddressLinkId);
            }
            em.persist(debitcardPayment);
            if (paymentDetail != null) {
                paymentDetail.getDebitcardPaymentSet().add(debitcardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            if (personAddressLinkId != null) {
                personAddressLinkId.getDebitcardPaymentSet().add(debitcardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDebitcardPayment(debitcardPayment.getPaymentId()) != null) {
                throw new PreexistingEntityException("DebitcardPayment " + debitcardPayment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DebitcardPayment debitcardPayment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DebitcardPayment persistentDebitcardPayment = em.find(DebitcardPayment.class, debitcardPayment.getPaymentId());
            PaymentDetail paymentDetailOld = persistentDebitcardPayment.getPaymentDetail();
            PaymentDetail paymentDetailNew = debitcardPayment.getPaymentDetail();
            PersonAddressLink personAddressLinkIdOld = persistentDebitcardPayment.getPersonAddressLinkId();
            PersonAddressLink personAddressLinkIdNew = debitcardPayment.getPersonAddressLinkId();
            if (paymentDetailNew != null) {
                paymentDetailNew = em.getReference(paymentDetailNew.getClass(), paymentDetailNew.getPaymentDetailPK());
                debitcardPayment.setPaymentDetail(paymentDetailNew);
            }
            if (personAddressLinkIdNew != null) {
                personAddressLinkIdNew = em.getReference(personAddressLinkIdNew.getClass(), personAddressLinkIdNew.getLinkId());
                debitcardPayment.setPersonAddressLinkId(personAddressLinkIdNew);
            }
            debitcardPayment = em.merge(debitcardPayment);
            if (paymentDetailOld != null && !paymentDetailOld.equals(paymentDetailNew)) {
                paymentDetailOld.getDebitcardPaymentSet().remove(debitcardPayment);
                paymentDetailOld = em.merge(paymentDetailOld);
            }
            if (paymentDetailNew != null && !paymentDetailNew.equals(paymentDetailOld)) {
                paymentDetailNew.getDebitcardPaymentSet().add(debitcardPayment);
                paymentDetailNew = em.merge(paymentDetailNew);
            }
            if (personAddressLinkIdOld != null && !personAddressLinkIdOld.equals(personAddressLinkIdNew)) {
                personAddressLinkIdOld.getDebitcardPaymentSet().remove(debitcardPayment);
                personAddressLinkIdOld = em.merge(personAddressLinkIdOld);
            }
            if (personAddressLinkIdNew != null && !personAddressLinkIdNew.equals(personAddressLinkIdOld)) {
                personAddressLinkIdNew.getDebitcardPaymentSet().add(debitcardPayment);
                personAddressLinkIdNew = em.merge(personAddressLinkIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = debitcardPayment.getPaymentId();
                if (findDebitcardPayment(id) == null) {
                    throw new NonexistentEntityException("The debitcardPayment with id " + id + " no longer exists.");
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
            DebitcardPayment debitcardPayment;
            try {
                debitcardPayment = em.getReference(DebitcardPayment.class, id);
                debitcardPayment.getPaymentId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The debitcardPayment with id " + id + " no longer exists.", enfe);
            }
            PaymentDetail paymentDetail = debitcardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail.getDebitcardPaymentSet().remove(debitcardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = debitcardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId.getDebitcardPaymentSet().remove(debitcardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.remove(debitcardPayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DebitcardPayment> findDebitcardPaymentEntities() {
        return findDebitcardPaymentEntities(true, -1, -1);
    }

    public List<DebitcardPayment> findDebitcardPaymentEntities(int maxResults, int firstResult) {
        return findDebitcardPaymentEntities(false, maxResults, firstResult);
    }

    private List<DebitcardPayment> findDebitcardPaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DebitcardPayment.class));
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

    public DebitcardPayment findDebitcardPayment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DebitcardPayment.class, id);
        } finally {
            em.close();
        }
    }

    public int getDebitcardPaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DebitcardPayment> rt = cq.from(DebitcardPayment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
