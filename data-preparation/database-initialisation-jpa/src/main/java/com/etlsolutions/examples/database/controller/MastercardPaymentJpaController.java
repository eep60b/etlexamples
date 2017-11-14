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
import com.etlsolutions.examples.database.entity.MastercardPayment;
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
public class MastercardPaymentJpaController implements Serializable {

    public MastercardPaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MastercardPayment mastercardPayment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentDetail paymentDetail = mastercardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail = em.getReference(paymentDetail.getClass(), paymentDetail.getPaymentDetailPK());
                mastercardPayment.setPaymentDetail(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = mastercardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId = em.getReference(personAddressLinkId.getClass(), personAddressLinkId.getLinkId());
                mastercardPayment.setPersonAddressLinkId(personAddressLinkId);
            }
            em.persist(mastercardPayment);
            if (paymentDetail != null) {
                paymentDetail.getMastercardPaymentSet().add(mastercardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            if (personAddressLinkId != null) {
                personAddressLinkId.getMastercardPaymentSet().add(mastercardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMastercardPayment(mastercardPayment.getPaymentId()) != null) {
                throw new PreexistingEntityException("MastercardPayment " + mastercardPayment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MastercardPayment mastercardPayment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MastercardPayment persistentMastercardPayment = em.find(MastercardPayment.class, mastercardPayment.getPaymentId());
            PaymentDetail paymentDetailOld = persistentMastercardPayment.getPaymentDetail();
            PaymentDetail paymentDetailNew = mastercardPayment.getPaymentDetail();
            PersonAddressLink personAddressLinkIdOld = persistentMastercardPayment.getPersonAddressLinkId();
            PersonAddressLink personAddressLinkIdNew = mastercardPayment.getPersonAddressLinkId();
            if (paymentDetailNew != null) {
                paymentDetailNew = em.getReference(paymentDetailNew.getClass(), paymentDetailNew.getPaymentDetailPK());
                mastercardPayment.setPaymentDetail(paymentDetailNew);
            }
            if (personAddressLinkIdNew != null) {
                personAddressLinkIdNew = em.getReference(personAddressLinkIdNew.getClass(), personAddressLinkIdNew.getLinkId());
                mastercardPayment.setPersonAddressLinkId(personAddressLinkIdNew);
            }
            mastercardPayment = em.merge(mastercardPayment);
            if (paymentDetailOld != null && !paymentDetailOld.equals(paymentDetailNew)) {
                paymentDetailOld.getMastercardPaymentSet().remove(mastercardPayment);
                paymentDetailOld = em.merge(paymentDetailOld);
            }
            if (paymentDetailNew != null && !paymentDetailNew.equals(paymentDetailOld)) {
                paymentDetailNew.getMastercardPaymentSet().add(mastercardPayment);
                paymentDetailNew = em.merge(paymentDetailNew);
            }
            if (personAddressLinkIdOld != null && !personAddressLinkIdOld.equals(personAddressLinkIdNew)) {
                personAddressLinkIdOld.getMastercardPaymentSet().remove(mastercardPayment);
                personAddressLinkIdOld = em.merge(personAddressLinkIdOld);
            }
            if (personAddressLinkIdNew != null && !personAddressLinkIdNew.equals(personAddressLinkIdOld)) {
                personAddressLinkIdNew.getMastercardPaymentSet().add(mastercardPayment);
                personAddressLinkIdNew = em.merge(personAddressLinkIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mastercardPayment.getPaymentId();
                if (findMastercardPayment(id) == null) {
                    throw new NonexistentEntityException("The mastercardPayment with id " + id + " no longer exists.");
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
            MastercardPayment mastercardPayment;
            try {
                mastercardPayment = em.getReference(MastercardPayment.class, id);
                mastercardPayment.getPaymentId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mastercardPayment with id " + id + " no longer exists.", enfe);
            }
            PaymentDetail paymentDetail = mastercardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail.getMastercardPaymentSet().remove(mastercardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = mastercardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId.getMastercardPaymentSet().remove(mastercardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.remove(mastercardPayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MastercardPayment> findMastercardPaymentEntities() {
        return findMastercardPaymentEntities(true, -1, -1);
    }

    public List<MastercardPayment> findMastercardPaymentEntities(int maxResults, int firstResult) {
        return findMastercardPaymentEntities(false, maxResults, firstResult);
    }

    private List<MastercardPayment> findMastercardPaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MastercardPayment.class));
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

    public MastercardPayment findMastercardPayment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MastercardPayment.class, id);
        } finally {
            em.close();
        }
    }

    public int getMastercardPaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MastercardPayment> rt = cq.from(MastercardPayment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
