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
import com.etlsolutions.examples.database.entity.PaypalPayment;
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
public class PaypalPaymentJpaController implements Serializable {

    public PaypalPaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaypalPayment paypalPayment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentDetail paymentDetail = paypalPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail = em.getReference(paymentDetail.getClass(), paymentDetail.getPaymentDetailPK());
                paypalPayment.setPaymentDetail(paymentDetail);
            }
            em.persist(paypalPayment);
            if (paymentDetail != null) {
                paymentDetail.getPaypalPaymentSet().add(paypalPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaypalPayment(paypalPayment.getPaymentId()) != null) {
                throw new PreexistingEntityException("PaypalPayment " + paypalPayment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PaypalPayment paypalPayment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaypalPayment persistentPaypalPayment = em.find(PaypalPayment.class, paypalPayment.getPaymentId());
            PaymentDetail paymentDetailOld = persistentPaypalPayment.getPaymentDetail();
            PaymentDetail paymentDetailNew = paypalPayment.getPaymentDetail();
            if (paymentDetailNew != null) {
                paymentDetailNew = em.getReference(paymentDetailNew.getClass(), paymentDetailNew.getPaymentDetailPK());
                paypalPayment.setPaymentDetail(paymentDetailNew);
            }
            paypalPayment = em.merge(paypalPayment);
            if (paymentDetailOld != null && !paymentDetailOld.equals(paymentDetailNew)) {
                paymentDetailOld.getPaypalPaymentSet().remove(paypalPayment);
                paymentDetailOld = em.merge(paymentDetailOld);
            }
            if (paymentDetailNew != null && !paymentDetailNew.equals(paymentDetailOld)) {
                paymentDetailNew.getPaypalPaymentSet().add(paypalPayment);
                paymentDetailNew = em.merge(paymentDetailNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paypalPayment.getPaymentId();
                if (findPaypalPayment(id) == null) {
                    throw new NonexistentEntityException("The paypalPayment with id " + id + " no longer exists.");
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
            PaypalPayment paypalPayment;
            try {
                paypalPayment = em.getReference(PaypalPayment.class, id);
                paypalPayment.getPaymentId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paypalPayment with id " + id + " no longer exists.", enfe);
            }
            PaymentDetail paymentDetail = paypalPayment.getPaymentDetail();
            if (paymentDetail != null) {
                paymentDetail.getPaypalPaymentSet().remove(paypalPayment);
                paymentDetail = em.merge(paymentDetail);
            }
            em.remove(paypalPayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PaypalPayment> findPaypalPaymentEntities() {
        return findPaypalPaymentEntities(true, -1, -1);
    }

    public List<PaypalPayment> findPaypalPaymentEntities(int maxResults, int firstResult) {
        return findPaypalPaymentEntities(false, maxResults, firstResult);
    }

    private List<PaypalPayment> findPaypalPaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaypalPayment.class));
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

    public PaypalPayment findPaypalPayment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaypalPayment.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaypalPaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaypalPayment> rt = cq.from(PaypalPayment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
