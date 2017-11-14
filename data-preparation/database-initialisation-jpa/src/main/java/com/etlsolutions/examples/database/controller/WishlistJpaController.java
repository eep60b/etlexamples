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
import com.etlsolutions.examples.database.entity.ItemCommonDetail;
import com.etlsolutions.examples.database.entity.Wishlist;
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
public class WishlistJpaController implements Serializable {

    public WishlistJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Wishlist wishlist) throws PreexistingEntityException, Exception {
        if (wishlist.getItemCommonDetailSet() == null) {
            wishlist.setItemCommonDetailSet(new HashSet<ItemCommonDetail>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customerId = wishlist.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCustomerId());
                wishlist.setCustomerId(customerId);
            }
            Set<ItemCommonDetail> attachedItemCommonDetailSet = new HashSet<ItemCommonDetail>();
            for (ItemCommonDetail itemCommonDetailSetItemCommonDetailToAttach : wishlist.getItemCommonDetailSet()) {
                itemCommonDetailSetItemCommonDetailToAttach = em.getReference(itemCommonDetailSetItemCommonDetailToAttach.getClass(), itemCommonDetailSetItemCommonDetailToAttach.getItemCommonDetailId());
                attachedItemCommonDetailSet.add(itemCommonDetailSetItemCommonDetailToAttach);
            }
            wishlist.setItemCommonDetailSet(attachedItemCommonDetailSet);
            em.persist(wishlist);
            if (customerId != null) {
                customerId.getWishlistSet().add(wishlist);
                customerId = em.merge(customerId);
            }
            for (ItemCommonDetail itemCommonDetailSetItemCommonDetail : wishlist.getItemCommonDetailSet()) {
                itemCommonDetailSetItemCommonDetail.getWishlistSet().add(wishlist);
                itemCommonDetailSetItemCommonDetail = em.merge(itemCommonDetailSetItemCommonDetail);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findWishlist(wishlist.getWishlistId()) != null) {
                throw new PreexistingEntityException("Wishlist " + wishlist + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Wishlist wishlist) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Wishlist persistentWishlist = em.find(Wishlist.class, wishlist.getWishlistId());
            Customer customerIdOld = persistentWishlist.getCustomerId();
            Customer customerIdNew = wishlist.getCustomerId();
            Set<ItemCommonDetail> itemCommonDetailSetOld = persistentWishlist.getItemCommonDetailSet();
            Set<ItemCommonDetail> itemCommonDetailSetNew = wishlist.getItemCommonDetailSet();
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCustomerId());
                wishlist.setCustomerId(customerIdNew);
            }
            Set<ItemCommonDetail> attachedItemCommonDetailSetNew = new HashSet<ItemCommonDetail>();
            for (ItemCommonDetail itemCommonDetailSetNewItemCommonDetailToAttach : itemCommonDetailSetNew) {
                itemCommonDetailSetNewItemCommonDetailToAttach = em.getReference(itemCommonDetailSetNewItemCommonDetailToAttach.getClass(), itemCommonDetailSetNewItemCommonDetailToAttach.getItemCommonDetailId());
                attachedItemCommonDetailSetNew.add(itemCommonDetailSetNewItemCommonDetailToAttach);
            }
            itemCommonDetailSetNew = attachedItemCommonDetailSetNew;
            wishlist.setItemCommonDetailSet(itemCommonDetailSetNew);
            wishlist = em.merge(wishlist);
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getWishlistSet().remove(wishlist);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getWishlistSet().add(wishlist);
                customerIdNew = em.merge(customerIdNew);
            }
            for (ItemCommonDetail itemCommonDetailSetOldItemCommonDetail : itemCommonDetailSetOld) {
                if (!itemCommonDetailSetNew.contains(itemCommonDetailSetOldItemCommonDetail)) {
                    itemCommonDetailSetOldItemCommonDetail.getWishlistSet().remove(wishlist);
                    itemCommonDetailSetOldItemCommonDetail = em.merge(itemCommonDetailSetOldItemCommonDetail);
                }
            }
            for (ItemCommonDetail itemCommonDetailSetNewItemCommonDetail : itemCommonDetailSetNew) {
                if (!itemCommonDetailSetOld.contains(itemCommonDetailSetNewItemCommonDetail)) {
                    itemCommonDetailSetNewItemCommonDetail.getWishlistSet().add(wishlist);
                    itemCommonDetailSetNewItemCommonDetail = em.merge(itemCommonDetailSetNewItemCommonDetail);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = wishlist.getWishlistId();
                if (findWishlist(id) == null) {
                    throw new NonexistentEntityException("The wishlist with id " + id + " no longer exists.");
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
            Wishlist wishlist;
            try {
                wishlist = em.getReference(Wishlist.class, id);
                wishlist.getWishlistId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wishlist with id " + id + " no longer exists.", enfe);
            }
            Customer customerId = wishlist.getCustomerId();
            if (customerId != null) {
                customerId.getWishlistSet().remove(wishlist);
                customerId = em.merge(customerId);
            }
            Set<ItemCommonDetail> itemCommonDetailSet = wishlist.getItemCommonDetailSet();
            for (ItemCommonDetail itemCommonDetailSetItemCommonDetail : itemCommonDetailSet) {
                itemCommonDetailSetItemCommonDetail.getWishlistSet().remove(wishlist);
                itemCommonDetailSetItemCommonDetail = em.merge(itemCommonDetailSetItemCommonDetail);
            }
            em.remove(wishlist);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Wishlist> findWishlistEntities() {
        return findWishlistEntities(true, -1, -1);
    }

    public List<Wishlist> findWishlistEntities(int maxResults, int firstResult) {
        return findWishlistEntities(false, maxResults, firstResult);
    }

    private List<Wishlist> findWishlistEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Wishlist.class));
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

    public Wishlist findWishlist(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Wishlist.class, id);
        } finally {
            em.close();
        }
    }

    public int getWishlistCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Wishlist> rt = cq.from(Wishlist.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
