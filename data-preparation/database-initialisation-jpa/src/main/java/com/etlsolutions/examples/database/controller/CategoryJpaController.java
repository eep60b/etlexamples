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
import com.etlsolutions.examples.database.entity.Category;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.entity.ItemCommonDetail;
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
public class CategoryJpaController implements Serializable {

    public CategoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Category category) throws PreexistingEntityException, Exception {
        if (category.getItemCommonDetailSet() == null) {
            category.setItemCommonDetailSet(new HashSet<ItemCommonDetail>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<ItemCommonDetail> attachedItemCommonDetailSet = new HashSet<ItemCommonDetail>();
            for (ItemCommonDetail itemCommonDetailSetItemCommonDetailToAttach : category.getItemCommonDetailSet()) {
                itemCommonDetailSetItemCommonDetailToAttach = em.getReference(itemCommonDetailSetItemCommonDetailToAttach.getClass(), itemCommonDetailSetItemCommonDetailToAttach.getItemCommonDetailId());
                attachedItemCommonDetailSet.add(itemCommonDetailSetItemCommonDetailToAttach);
            }
            category.setItemCommonDetailSet(attachedItemCommonDetailSet);
            em.persist(category);
            for (ItemCommonDetail itemCommonDetailSetItemCommonDetail : category.getItemCommonDetailSet()) {
                itemCommonDetailSetItemCommonDetail.getCategorySet().add(category);
                itemCommonDetailSetItemCommonDetail = em.merge(itemCommonDetailSetItemCommonDetail);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategory(category.getCategoryId()) != null) {
                throw new PreexistingEntityException("Category " + category + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Category category) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Category persistentCategory = em.find(Category.class, category.getCategoryId());
            Set<ItemCommonDetail> itemCommonDetailSetOld = persistentCategory.getItemCommonDetailSet();
            Set<ItemCommonDetail> itemCommonDetailSetNew = category.getItemCommonDetailSet();
            Set<ItemCommonDetail> attachedItemCommonDetailSetNew = new HashSet<ItemCommonDetail>();
            for (ItemCommonDetail itemCommonDetailSetNewItemCommonDetailToAttach : itemCommonDetailSetNew) {
                itemCommonDetailSetNewItemCommonDetailToAttach = em.getReference(itemCommonDetailSetNewItemCommonDetailToAttach.getClass(), itemCommonDetailSetNewItemCommonDetailToAttach.getItemCommonDetailId());
                attachedItemCommonDetailSetNew.add(itemCommonDetailSetNewItemCommonDetailToAttach);
            }
            itemCommonDetailSetNew = attachedItemCommonDetailSetNew;
            category.setItemCommonDetailSet(itemCommonDetailSetNew);
            category = em.merge(category);
            for (ItemCommonDetail itemCommonDetailSetOldItemCommonDetail : itemCommonDetailSetOld) {
                if (!itemCommonDetailSetNew.contains(itemCommonDetailSetOldItemCommonDetail)) {
                    itemCommonDetailSetOldItemCommonDetail.getCategorySet().remove(category);
                    itemCommonDetailSetOldItemCommonDetail = em.merge(itemCommonDetailSetOldItemCommonDetail);
                }
            }
            for (ItemCommonDetail itemCommonDetailSetNewItemCommonDetail : itemCommonDetailSetNew) {
                if (!itemCommonDetailSetOld.contains(itemCommonDetailSetNewItemCommonDetail)) {
                    itemCommonDetailSetNewItemCommonDetail.getCategorySet().add(category);
                    itemCommonDetailSetNewItemCommonDetail = em.merge(itemCommonDetailSetNewItemCommonDetail);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = category.getCategoryId();
                if (findCategory(id) == null) {
                    throw new NonexistentEntityException("The category with id " + id + " no longer exists.");
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
            Category category;
            try {
                category = em.getReference(Category.class, id);
                category.getCategoryId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The category with id " + id + " no longer exists.", enfe);
            }
            Set<ItemCommonDetail> itemCommonDetailSet = category.getItemCommonDetailSet();
            for (ItemCommonDetail itemCommonDetailSetItemCommonDetail : itemCommonDetailSet) {
                itemCommonDetailSetItemCommonDetail.getCategorySet().remove(category);
                itemCommonDetailSetItemCommonDetail = em.merge(itemCommonDetailSetItemCommonDetail);
            }
            em.remove(category);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Category> findCategoryEntities() {
        return findCategoryEntities(true, -1, -1);
    }

    public List<Category> findCategoryEntities(int maxResults, int firstResult) {
        return findCategoryEntities(false, maxResults, firstResult);
    }

    private List<Category> findCategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Category.class));
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

    public Category findCategory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Category.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Category> rt = cq.from(Category.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
