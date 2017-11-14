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
import com.etlsolutions.examples.database.entity.ItemCommonDetail;
import com.etlsolutions.examples.database.entity.SoldItem;
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
public class SoldItemJpaController implements Serializable {

    public SoldItemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SoldItem soldItem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Invoice invoiceId = soldItem.getInvoiceId();
            if (invoiceId != null) {
                invoiceId = em.getReference(invoiceId.getClass(), invoiceId.getInvoiceId());
                soldItem.setInvoiceId(invoiceId);
            }
            ItemCommonDetail itemCommonDetailId = soldItem.getItemCommonDetailId();
            if (itemCommonDetailId != null) {
                itemCommonDetailId = em.getReference(itemCommonDetailId.getClass(), itemCommonDetailId.getItemCommonDetailId());
                soldItem.setItemCommonDetailId(itemCommonDetailId);
            }
            em.persist(soldItem);
            if (invoiceId != null) {
                invoiceId.getSoldItemSet().add(soldItem);
                invoiceId = em.merge(invoiceId);
            }
            if (itemCommonDetailId != null) {
                itemCommonDetailId.getSoldItemSet().add(soldItem);
                itemCommonDetailId = em.merge(itemCommonDetailId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSoldItem(soldItem.getSoldItemId()) != null) {
                throw new PreexistingEntityException("SoldItem " + soldItem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SoldItem soldItem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SoldItem persistentSoldItem = em.find(SoldItem.class, soldItem.getSoldItemId());
            Invoice invoiceIdOld = persistentSoldItem.getInvoiceId();
            Invoice invoiceIdNew = soldItem.getInvoiceId();
            ItemCommonDetail itemCommonDetailIdOld = persistentSoldItem.getItemCommonDetailId();
            ItemCommonDetail itemCommonDetailIdNew = soldItem.getItemCommonDetailId();
            if (invoiceIdNew != null) {
                invoiceIdNew = em.getReference(invoiceIdNew.getClass(), invoiceIdNew.getInvoiceId());
                soldItem.setInvoiceId(invoiceIdNew);
            }
            if (itemCommonDetailIdNew != null) {
                itemCommonDetailIdNew = em.getReference(itemCommonDetailIdNew.getClass(), itemCommonDetailIdNew.getItemCommonDetailId());
                soldItem.setItemCommonDetailId(itemCommonDetailIdNew);
            }
            soldItem = em.merge(soldItem);
            if (invoiceIdOld != null && !invoiceIdOld.equals(invoiceIdNew)) {
                invoiceIdOld.getSoldItemSet().remove(soldItem);
                invoiceIdOld = em.merge(invoiceIdOld);
            }
            if (invoiceIdNew != null && !invoiceIdNew.equals(invoiceIdOld)) {
                invoiceIdNew.getSoldItemSet().add(soldItem);
                invoiceIdNew = em.merge(invoiceIdNew);
            }
            if (itemCommonDetailIdOld != null && !itemCommonDetailIdOld.equals(itemCommonDetailIdNew)) {
                itemCommonDetailIdOld.getSoldItemSet().remove(soldItem);
                itemCommonDetailIdOld = em.merge(itemCommonDetailIdOld);
            }
            if (itemCommonDetailIdNew != null && !itemCommonDetailIdNew.equals(itemCommonDetailIdOld)) {
                itemCommonDetailIdNew.getSoldItemSet().add(soldItem);
                itemCommonDetailIdNew = em.merge(itemCommonDetailIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = soldItem.getSoldItemId();
                if (findSoldItem(id) == null) {
                    throw new NonexistentEntityException("The soldItem with id " + id + " no longer exists.");
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
            SoldItem soldItem;
            try {
                soldItem = em.getReference(SoldItem.class, id);
                soldItem.getSoldItemId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The soldItem with id " + id + " no longer exists.", enfe);
            }
            Invoice invoiceId = soldItem.getInvoiceId();
            if (invoiceId != null) {
                invoiceId.getSoldItemSet().remove(soldItem);
                invoiceId = em.merge(invoiceId);
            }
            ItemCommonDetail itemCommonDetailId = soldItem.getItemCommonDetailId();
            if (itemCommonDetailId != null) {
                itemCommonDetailId.getSoldItemSet().remove(soldItem);
                itemCommonDetailId = em.merge(itemCommonDetailId);
            }
            em.remove(soldItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SoldItem> findSoldItemEntities() {
        return findSoldItemEntities(true, -1, -1);
    }

    public List<SoldItem> findSoldItemEntities(int maxResults, int firstResult) {
        return findSoldItemEntities(false, maxResults, firstResult);
    }

    private List<SoldItem> findSoldItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SoldItem.class));
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

    public SoldItem findSoldItem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SoldItem.class, id);
        } finally {
            em.close();
        }
    }

    public int getSoldItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SoldItem> rt = cq.from(SoldItem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
