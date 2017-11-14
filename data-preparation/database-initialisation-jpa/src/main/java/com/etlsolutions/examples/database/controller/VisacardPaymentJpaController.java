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
import com.etlsolutions.examples.database.entity.PaymentDetail;
import com.etlsolutions.examples.database.entity.PersonAddressLink;
import com.etlsolutions.examples.database.entity.VisacardPayment;
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
public class VisacardPaymentJpaController implements Serializable {

    public VisacardPaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VisacardPayment visacardPayment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentDetail paymentDetail = visacardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail = em.getReference(paymentDetail.getClass(), paymentDetail.getPaymentDetailPK());
                visacardPayment.setPaymentDetail(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = visacardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId = em.getReference(personAddressLinkId.getClass(), personAddressLinkId.getLinkId());
                visacardPayment.setPersonAddressLinkId(personAddressLinkId);
            }
            em.persist(visacardPayment);
            if (paymentDetail != null) {
                paymentDetail.getVisacardPaymentSet().add(visacardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            if (personAddressLinkId != null) {
                personAddressLinkId.getVisacardPaymentSet().add(visacardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVisacardPayment(visacardPayment.getPaymentId()) != null) {
                throw new PreexistingEntityException("VisacardPayment " + visacardPayment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VisacardPayment visacardPayment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VisacardPayment persistentVisacardPayment = em.find(VisacardPayment.class, visacardPayment.getPaymentId());
            PaymentDetail paymentDetailOld = persistentVisacardPayment.getPaymentDetail();
            PaymentDetail paymentDetailNew = visacardPayment.getPaymentDetail();
            PersonAddressLink personAddressLinkIdOld = persistentVisacardPayment.getPersonAddressLinkId();
            PersonAddressLink personAddressLinkIdNew = visacardPayment.getPersonAddressLinkId();
            if (paymentDetailNew != null) {
                paymentDetailNew = em.getReference(paymentDetailNew.getClass(), paymentDetailNew.getPaymentDetailPK());
                visacardPayment.setPaymentDetail(paymentDetailNew);
            }
            if (personAddressLinkIdNew != null) {
                personAddressLinkIdNew = em.getReference(personAddressLinkIdNew.getClass(), personAddressLinkIdNew.getLinkId());
                visacardPayment.setPersonAddressLinkId(personAddressLinkIdNew);
            }
            visacardPayment = em.merge(visacardPayment);
            if (paymentDetailOld != null && !paymentDetailOld.equals(paymentDetailNew)) {
                paymentDetailOld.getVisacardPaymentSet().remove(visacardPayment);
                paymentDetailOld = em.merge(paymentDetailOld);
            }
            if (paymentDetailNew != null && !paymentDetailNew.equals(paymentDetailOld)) {
                paymentDetailNew.getVisacardPaymentSet().add(visacardPayment);
                paymentDetailNew = em.merge(paymentDetailNew);
            }
            if (personAddressLinkIdOld != null && !personAddressLinkIdOld.equals(personAddressLinkIdNew)) {
                personAddressLinkIdOld.getVisacardPaymentSet().remove(visacardPayment);
                personAddressLinkIdOld = em.merge(personAddressLinkIdOld);
            }
            if (personAddressLinkIdNew != null && !personAddressLinkIdNew.equals(personAddressLinkIdOld)) {
                personAddressLinkIdNew.getVisacardPaymentSet().add(visacardPayment);
                personAddressLinkIdNew = em.merge(personAddressLinkIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = visacardPayment.getPaymentId();
                if (findVisacardPayment(id) == null) {
                    throw new NonexistentEntityException("The visacardPayment with id " + id + " no longer exists.");
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
            VisacardPayment visacardPayment;
            try {
                visacardPayment = em.getReference(VisacardPayment.class, id);
                visacardPayment.getPaymentId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visacardPayment with id " + id + " no longer exists.", enfe);
            }
            PaymentDetail paymentDetail = visacardPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail.getVisacardPaymentSet().remove(visacardPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            PersonAddressLink personAddressLinkId = visacardPayment.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId.getVisacardPaymentSet().remove(visacardPayment);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            em.remove(visacardPayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VisacardPayment> findVisacardPaymentEntities() {
        return findVisacardPaymentEntities(true, -1, -1);
    }

    public List<VisacardPayment> findVisacardPaymentEntities(int maxResults, int firstResult) {
        return findVisacardPaymentEntities(false, maxResults, firstResult);
    }

    private List<VisacardPayment> findVisacardPaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VisacardPayment.class));
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

    public VisacardPayment findVisacardPayment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VisacardPayment.class, id);
        } finally {
            em.close();
        }
    }

    public int getVisacardPaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VisacardPayment> rt = cq.from(VisacardPayment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
