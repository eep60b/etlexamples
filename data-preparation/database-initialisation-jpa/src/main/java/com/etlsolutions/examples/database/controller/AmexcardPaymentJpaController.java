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
import com.etlsolutions.examples.database.entity.AmexcardPayment;
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
public class AmexcardPaymentJpaController implements Serializable {

    public AmexcardPaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AmexcardPayment amexcardPayment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentDetail paymentDetail = amexcardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail = em.getReference(paymentDetail.getClass(), paymentDetail.getPaymentDetailPK());
                amexcardPayment.setPaymentDetail(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = amexcardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId = em.getReference(personAddressLinkId.getClass(), personAddressLinkId.getLinkId());
                amexcardPayment.setPersonAddressLinkId(personAddressLinkId);
            }
            em.persist(amexcardPayment);
            if (paymentDetail != null) {
                paymentDetail.getAmexcardPaymentSet().add(amexcardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            if (personAddressLinkId != null) {
                personAddressLinkId.getAmexcardPaymentSet().add(amexcardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAmexcardPayment(amexcardPayment.getPaymentId()) != null) {
                throw new PreexistingEntityException("AmexcardPayment " + amexcardPayment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AmexcardPayment amexcardPayment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AmexcardPayment persistentAmexcardPayment = em.find(AmexcardPayment.class, amexcardPayment.getPaymentId());
            PaymentDetail paymentDetailOld = persistentAmexcardPayment.getPaymentDetail();
            PaymentDetail paymentDetailNew = amexcardPayment.getPaymentDetail();
            PersonAddressLink personAddressLinkIdOld = persistentAmexcardPayment.getPersonAddressLinkId();
            PersonAddressLink personAddressLinkIdNew = amexcardPayment.getPersonAddressLinkId();
            if (paymentDetailNew != null) {
                paymentDetailNew = em.getReference(paymentDetailNew.getClass(), paymentDetailNew.getPaymentDetailPK());
                amexcardPayment.setPaymentDetail(paymentDetailNew);
            }
            if (personAddressLinkIdNew != null) {
                personAddressLinkIdNew = em.getReference(personAddressLinkIdNew.getClass(), personAddressLinkIdNew.getLinkId());
                amexcardPayment.setPersonAddressLinkId(personAddressLinkIdNew);
            }
            amexcardPayment = em.merge(amexcardPayment);
            if (paymentDetailOld != null && !paymentDetailOld.equals(paymentDetailNew)) {
                paymentDetailOld.getAmexcardPaymentSet().remove(amexcardPayment);
                paymentDetailOld = em.merge(paymentDetailOld);
            }
            if (paymentDetailNew != null && !paymentDetailNew.equals(paymentDetailOld)) {
                paymentDetailNew.getAmexcardPaymentSet().add(amexcardPayment);
                paymentDetailNew = em.merge(paymentDetailNew);
            }
            if (personAddressLinkIdOld != null && !personAddressLinkIdOld.equals(personAddressLinkIdNew)) {
                personAddressLinkIdOld.getAmexcardPaymentSet().remove(amexcardPayment);
                personAddressLinkIdOld = em.merge(personAddressLinkIdOld);
            }
            if (personAddressLinkIdNew != null && !personAddressLinkIdNew.equals(personAddressLinkIdOld)) {
                personAddressLinkIdNew.getAmexcardPaymentSet().add(amexcardPayment);
                personAddressLinkIdNew = em.merge(personAddressLinkIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = amexcardPayment.getPaymentId();
                if (findAmexcardPayment(id) == null) {
                    throw new NonexistentEntityException("The amexcardPayment with id " + id + " no longer exists.");
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
            AmexcardPayment amexcardPayment;
            try {
                amexcardPayment = em.getReference(AmexcardPayment.class, id);
                amexcardPayment.getPaymentId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The amexcardPayment with id " + id + " no longer exists.", enfe);
            }
            PaymentDetail paymentDetail = amexcardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail.getAmexcardPaymentSet().remove(amexcardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = amexcardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId.getAmexcardPaymentSet().remove(amexcardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.remove(amexcardPayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AmexcardPayment> findAmexcardPaymentEntities() {
        return findAmexcardPaymentEntities(true, -1, -1);
    }

    public List<AmexcardPayment> findAmexcardPaymentEntities(int maxResults, int firstResult) {
        return findAmexcardPaymentEntities(false, maxResults, firstResult);
    }

    private List<AmexcardPayment> findAmexcardPaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AmexcardPayment.class));
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

    public AmexcardPayment findAmexcardPayment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AmexcardPayment.class, id);
        } finally {
            em.close();
        }
    }

    public int getAmexcardPaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AmexcardPayment> rt = cq.from(AmexcardPayment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
