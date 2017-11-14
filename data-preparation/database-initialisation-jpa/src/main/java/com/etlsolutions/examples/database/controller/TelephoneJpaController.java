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
import com.etlsolutions.examples.database.entity.PersonalDetail;
import com.etlsolutions.examples.database.entity.Telephone;
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
public class TelephoneJpaController implements Serializable {

    public TelephoneJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Telephone telephone) throws PreexistingEntityException, Exception {
        if (telephone.getPersonalDetailSet() == null) {
            telephone.setPersonalDetailSet(new HashSet<PersonalDetail>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<PersonalDetail> attachedPersonalDetailSet = new HashSet<PersonalDetail>();
            for (PersonalDetail personalDetailSetPersonalDetailToAttach : telephone.getPersonalDetailSet()) {
                personalDetailSetPersonalDetailToAttach = em.getReference(personalDetailSetPersonalDetailToAttach.getClass(), personalDetailSetPersonalDetailToAttach.getPersonalDetailId());
                attachedPersonalDetailSet.add(personalDetailSetPersonalDetailToAttach);
            }
            telephone.setPersonalDetailSet(attachedPersonalDetailSet);
            em.persist(telephone);
            for (PersonalDetail personalDetailSetPersonalDetail : telephone.getPersonalDetailSet()) {
                personalDetailSetPersonalDetail.getTelephoneSet().add(telephone);
                personalDetailSetPersonalDetail = em.merge(personalDetailSetPersonalDetail);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTelephone(telephone.getTelephoneId()) != null) {
                throw new PreexistingEntityException("Telephone " + telephone + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Telephone telephone) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telephone persistentTelephone = em.find(Telephone.class, telephone.getTelephoneId());
            Set<PersonalDetail> personalDetailSetOld = persistentTelephone.getPersonalDetailSet();
            Set<PersonalDetail> personalDetailSetNew = telephone.getPersonalDetailSet();
            Set<PersonalDetail> attachedPersonalDetailSetNew = new HashSet<PersonalDetail>();
            for (PersonalDetail personalDetailSetNewPersonalDetailToAttach : personalDetailSetNew) {
                personalDetailSetNewPersonalDetailToAttach = em.getReference(personalDetailSetNewPersonalDetailToAttach.getClass(), personalDetailSetNewPersonalDetailToAttach.getPersonalDetailId());
                attachedPersonalDetailSetNew.add(personalDetailSetNewPersonalDetailToAttach);
            }
            personalDetailSetNew = attachedPersonalDetailSetNew;
            telephone.setPersonalDetailSet(personalDetailSetNew);
            telephone = em.merge(telephone);
            for (PersonalDetail personalDetailSetOldPersonalDetail : personalDetailSetOld) {
                if (!personalDetailSetNew.contains(personalDetailSetOldPersonalDetail)) {
                    personalDetailSetOldPersonalDetail.getTelephoneSet().remove(telephone);
                    personalDetailSetOldPersonalDetail = em.merge(personalDetailSetOldPersonalDetail);
                }
            }
            for (PersonalDetail personalDetailSetNewPersonalDetail : personalDetailSetNew) {
                if (!personalDetailSetOld.contains(personalDetailSetNewPersonalDetail)) {
                    personalDetailSetNewPersonalDetail.getTelephoneSet().add(telephone);
                    personalDetailSetNewPersonalDetail = em.merge(personalDetailSetNewPersonalDetail);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = telephone.getTelephoneId();
                if (findTelephone(id) == null) {
                    throw new NonexistentEntityException("The telephone with id " + id + " no longer exists.");
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
            Telephone telephone;
            try {
                telephone = em.getReference(Telephone.class, id);
                telephone.getTelephoneId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telephone with id " + id + " no longer exists.", enfe);
            }
            Set<PersonalDetail> personalDetailSet = telephone.getPersonalDetailSet();
            for (PersonalDetail personalDetailSetPersonalDetail : personalDetailSet) {
                personalDetailSetPersonalDetail.getTelephoneSet().remove(telephone);
                personalDetailSetPersonalDetail = em.merge(personalDetailSetPersonalDetail);
            }
            em.remove(telephone);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Telephone> findTelephoneEntities() {
        return findTelephoneEntities(true, -1, -1);
    }

    public List<Telephone> findTelephoneEntities(int maxResults, int firstResult) {
        return findTelephoneEntities(false, maxResults, firstResult);
    }

    private List<Telephone> findTelephoneEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Telephone.class));
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

    public Telephone findTelephone(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telephone.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelephoneCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Telephone> rt = cq.from(Telephone.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
