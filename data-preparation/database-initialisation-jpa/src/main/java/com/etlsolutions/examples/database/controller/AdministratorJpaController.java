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
import com.etlsolutions.examples.database.entity.Administrator;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.entity.PersonalDetail;
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
public class AdministratorJpaController implements Serializable {

    public AdministratorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrator administrator) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonalDetail personalDetailId = administrator.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId = em.getReference(personalDetailId.getClass(), personalDetailId.getPersonalDetailId());
                administrator.setPersonalDetailId(personalDetailId);
            }
            em.persist(administrator);
            if (personalDetailId != null) {
                Administrator oldAdministratorOfPersonalDetailId = personalDetailId.getAdministrator();
                if (oldAdministratorOfPersonalDetailId != null) {
                    oldAdministratorOfPersonalDetailId.setPersonalDetailId(null);
                    oldAdministratorOfPersonalDetailId = em.merge(oldAdministratorOfPersonalDetailId);
                }
                personalDetailId.setAdministrator(administrator);
                personalDetailId = em.merge(personalDetailId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdministrator(administrator.getAdministratorId()) != null) {
                throw new PreexistingEntityException("Administrator " + administrator + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administrator administrator) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrator persistentAdministrator = em.find(Administrator.class, administrator.getAdministratorId());
            PersonalDetail personalDetailIdOld = persistentAdministrator.getPersonalDetailId();
            PersonalDetail personalDetailIdNew = administrator.getPersonalDetailId();
            if (personalDetailIdNew != null) {
                personalDetailIdNew = em.getReference(personalDetailIdNew.getClass(), personalDetailIdNew.getPersonalDetailId());
                administrator.setPersonalDetailId(personalDetailIdNew);
            }
            administrator = em.merge(administrator);
            if (personalDetailIdOld != null && !personalDetailIdOld.equals(personalDetailIdNew)) {
                personalDetailIdOld.setAdministrator(null);
                personalDetailIdOld = em.merge(personalDetailIdOld);
            }
            if (personalDetailIdNew != null && !personalDetailIdNew.equals(personalDetailIdOld)) {
                Administrator oldAdministratorOfPersonalDetailId = personalDetailIdNew.getAdministrator();
                if (oldAdministratorOfPersonalDetailId != null) {
                    oldAdministratorOfPersonalDetailId.setPersonalDetailId(null);
                    oldAdministratorOfPersonalDetailId = em.merge(oldAdministratorOfPersonalDetailId);
                }
                personalDetailIdNew.setAdministrator(administrator);
                personalDetailIdNew = em.merge(personalDetailIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = administrator.getAdministratorId();
                if (findAdministrator(id) == null) {
                    throw new NonexistentEntityException("The administrator with id " + id + " no longer exists.");
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
            Administrator administrator;
            try {
                administrator = em.getReference(Administrator.class, id);
                administrator.getAdministratorId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrator with id " + id + " no longer exists.", enfe);
            }
            PersonalDetail personalDetailId = administrator.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId.setAdministrator(null);
                personalDetailId = em.merge(personalDetailId);
            }
            em.remove(administrator);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administrator> findAdministratorEntities() {
        return findAdministratorEntities(true, -1, -1);
    }

    public List<Administrator> findAdministratorEntities(int maxResults, int firstResult) {
        return findAdministratorEntities(false, maxResults, firstResult);
    }

    private List<Administrator> findAdministratorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrator.class));
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

    public Administrator findAdministrator(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrator.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministratorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrator> rt = cq.from(Administrator.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
