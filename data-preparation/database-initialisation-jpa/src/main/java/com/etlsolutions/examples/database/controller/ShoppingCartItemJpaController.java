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
import com.etlsolutions.examples.database.entity.ShoppingCartItem;
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
public class ShoppingCartItemJpaController implements Serializable {

    public ShoppingCartItemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ShoppingCartItem shoppingCartItem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customerId = shoppingCartItem.getCustomerId();
            if (customerId != null) {
                customerId = em.getReference(customerId.getClass(), customerId.getCustomerId());
                shoppingCartItem.setCustomerId(customerId);
            }
            ItemCommonDetail itemCommonDetailId = shoppingCartItem.getItemCommonDetailId();
            if (itemCommonDetailId != null) {
                itemCommonDetailId = em.getReference(itemCommonDetailId.getClass(), itemCommonDetailId.getItemCommonDetailId());
                shoppingCartItem.setItemCommonDetailId(itemCommonDetailId);
            }
            em.persist(shoppingCartItem);
            if (customerId != null) {
                customerId.getShoppingCartItemSet().add(shoppingCartItem);
                customerId = em.merge(customerId);
            }
            if (itemCommonDetailId != null) {
                itemCommonDetailId.getShoppingCartItemSet().add(shoppingCartItem);
                itemCommonDetailId = em.merge(itemCommonDetailId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findShoppingCartItem(shoppingCartItem.getShoppingCartItemId()) != null) {
                throw new PreexistingEntityException("ShoppingCartItem " + shoppingCartItem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ShoppingCartItem shoppingCartItem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ShoppingCartItem persistentShoppingCartItem = em.find(ShoppingCartItem.class, shoppingCartItem.getShoppingCartItemId());
            Customer customerIdOld = persistentShoppingCartItem.getCustomerId();
            Customer customerIdNew = shoppingCartItem.getCustomerId();
            ItemCommonDetail itemCommonDetailIdOld = persistentShoppingCartItem.getItemCommonDetailId();
            ItemCommonDetail itemCommonDetailIdNew = shoppingCartItem.getItemCommonDetailId();
            if (customerIdNew != null) {
                customerIdNew = em.getReference(customerIdNew.getClass(), customerIdNew.getCustomerId());
                shoppingCartItem.setCustomerId(customerIdNew);
            }
            if (itemCommonDetailIdNew != null) {
                itemCommonDetailIdNew = em.getReference(itemCommonDetailIdNew.getClass(), itemCommonDetailIdNew.getItemCommonDetailId());
                shoppingCartItem.setItemCommonDetailId(itemCommonDetailIdNew);
            }
            shoppingCartItem = em.merge(shoppingCartItem);
            if (customerIdOld != null && !customerIdOld.equals(customerIdNew)) {
                customerIdOld.getShoppingCartItemSet().remove(shoppingCartItem);
                customerIdOld = em.merge(customerIdOld);
            }
            if (customerIdNew != null && !customerIdNew.equals(customerIdOld)) {
                customerIdNew.getShoppingCartItemSet().add(shoppingCartItem);
                customerIdNew = em.merge(customerIdNew);
            }
            if (itemCommonDetailIdOld != null && !itemCommonDetailIdOld.equals(itemCommonDetailIdNew)) {
                itemCommonDetailIdOld.getShoppingCartItemSet().remove(shoppingCartItem);
                itemCommonDetailIdOld = em.merge(itemCommonDetailIdOld);
            }
            if (itemCommonDetailIdNew != null && !itemCommonDetailIdNew.equals(itemCommonDetailIdOld)) {
                itemCommonDetailIdNew.getShoppingCartItemSet().add(shoppingCartItem);
                itemCommonDetailIdNew = em.merge(itemCommonDetailIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = shoppingCartItem.getShoppingCartItemId();
                if (findShoppingCartItem(id) == null) {
                    throw new NonexistentEntityException("The shoppingCartItem with id " + id + " no longer exists.");
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
            ShoppingCartItem shoppingCartItem;
            try {
                shoppingCartItem = em.getReference(ShoppingCartItem.class, id);
                shoppingCartItem.getShoppingCartItemId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The shoppingCartItem with id " + id + " no longer exists.", enfe);
            }
            Customer customerId = shoppingCartItem.getCustomerId();
            if (customerId != null) {
                customerId.getShoppingCartItemSet().remove(shoppingCartItem);
                customerId = em.merge(customerId);
            }
            ItemCommonDetail itemCommonDetailId = shoppingCartItem.getItemCommonDetailId();
            if (itemCommonDetailId != null) {
                itemCommonDetailId.getShoppingCartItemSet().remove(shoppingCartItem);
                itemCommonDetailId = em.merge(itemCommonDetailId);
            }
            em.remove(shoppingCartItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ShoppingCartItem> findShoppingCartItemEntities() {
        return findShoppingCartItemEntities(true, -1, -1);
    }

    public List<ShoppingCartItem> findShoppingCartItemEntities(int maxResults, int firstResult) {
        return findShoppingCartItemEntities(false, maxResults, firstResult);
    }

    private List<ShoppingCartItem> findShoppingCartItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ShoppingCartItem.class));
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

    public ShoppingCartItem findShoppingCartItem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ShoppingCartItem.class, id);
        } finally {
            em.close();
        }
    }

    public int getShoppingCartItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ShoppingCartItem> rt = cq.from(ShoppingCartItem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
