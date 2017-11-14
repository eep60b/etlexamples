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
import com.etlsolutions.examples.database.entity.Review;
import com.etlsolutions.examples.database.entity.Reviewer;
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
public class ReviewerJpaController implements Serializable {

    public ReviewerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reviewer reviewer) throws PreexistingEntityException, Exception {
        if (reviewer.getReviewSet() == null) {
            reviewer.setReviewSet(new HashSet<Review>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonalDetail personalDetailId = reviewer.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId = em.getReference(personalDetailId.getClass(), personalDetailId.getPersonalDetailId());
                reviewer.setPersonalDetailId(personalDetailId);
            }
            Set<Review> attachedReviewSet = new HashSet<Review>();
            for (Review reviewSetReviewToAttach : reviewer.getReviewSet()) {
                reviewSetReviewToAttach = em.getReference(reviewSetReviewToAttach.getClass(), reviewSetReviewToAttach.getReviewId());
                attachedReviewSet.add(reviewSetReviewToAttach);
            }
            reviewer.setReviewSet(attachedReviewSet);
            em.persist(reviewer);
            if (personalDetailId != null) {
                personalDetailId.getReviewerSet().add(reviewer);
                personalDetailId = em.merge(personalDetailId);
            }
            for (Review reviewSetReview : reviewer.getReviewSet()) {
                Reviewer oldReviewerIdOfReviewSetReview = reviewSetReview.getReviewerId();
                reviewSetReview.setReviewerId(reviewer);
                reviewSetReview = em.merge(reviewSetReview);
                if (oldReviewerIdOfReviewSetReview != null) {
                    oldReviewerIdOfReviewSetReview.getReviewSet().remove(reviewSetReview);
                    oldReviewerIdOfReviewSetReview = em.merge(oldReviewerIdOfReviewSetReview);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReviewer(reviewer.getReviewerId()) != null) {
                throw new PreexistingEntityException("Reviewer " + reviewer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reviewer reviewer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reviewer persistentReviewer = em.find(Reviewer.class, reviewer.getReviewerId());
            PersonalDetail personalDetailIdOld = persistentReviewer.getPersonalDetailId();
            PersonalDetail personalDetailIdNew = reviewer.getPersonalDetailId();
            Set<Review> reviewSetOld = persistentReviewer.getReviewSet();
            Set<Review> reviewSetNew = reviewer.getReviewSet();
            if (personalDetailIdNew != null) {
                personalDetailIdNew = em.getReference(personalDetailIdNew.getClass(), personalDetailIdNew.getPersonalDetailId());
                reviewer.setPersonalDetailId(personalDetailIdNew);
            }
            Set<Review> attachedReviewSetNew = new HashSet<Review>();
            for (Review reviewSetNewReviewToAttach : reviewSetNew) {
                reviewSetNewReviewToAttach = em.getReference(reviewSetNewReviewToAttach.getClass(), reviewSetNewReviewToAttach.getReviewId());
                attachedReviewSetNew.add(reviewSetNewReviewToAttach);
            }
            reviewSetNew = attachedReviewSetNew;
            reviewer.setReviewSet(reviewSetNew);
            reviewer = em.merge(reviewer);
            if (personalDetailIdOld != null && !personalDetailIdOld.equals(personalDetailIdNew)) {
                personalDetailIdOld.getReviewerSet().remove(reviewer);
                personalDetailIdOld = em.merge(personalDetailIdOld);
            }
            if (personalDetailIdNew != null && !personalDetailIdNew.equals(personalDetailIdOld)) {
                personalDetailIdNew.getReviewerSet().add(reviewer);
                personalDetailIdNew = em.merge(personalDetailIdNew);
            }
            for (Review reviewSetOldReview : reviewSetOld) {
                if (!reviewSetNew.contains(reviewSetOldReview)) {
                    reviewSetOldReview.setReviewerId(null);
                    reviewSetOldReview = em.merge(reviewSetOldReview);
                }
            }
            for (Review reviewSetNewReview : reviewSetNew) {
                if (!reviewSetOld.contains(reviewSetNewReview)) {
                    Reviewer oldReviewerIdOfReviewSetNewReview = reviewSetNewReview.getReviewerId();
                    reviewSetNewReview.setReviewerId(reviewer);
                    reviewSetNewReview = em.merge(reviewSetNewReview);
                    if (oldReviewerIdOfReviewSetNewReview != null && !oldReviewerIdOfReviewSetNewReview.equals(reviewer)) {
                        oldReviewerIdOfReviewSetNewReview.getReviewSet().remove(reviewSetNewReview);
                        oldReviewerIdOfReviewSetNewReview = em.merge(oldReviewerIdOfReviewSetNewReview);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = reviewer.getReviewerId();
                if (findReviewer(id) == null) {
                    throw new NonexistentEntityException("The reviewer with id " + id + " no longer exists.");
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
            Reviewer reviewer;
            try {
                reviewer = em.getReference(Reviewer.class, id);
                reviewer.getReviewerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reviewer with id " + id + " no longer exists.", enfe);
            }
            PersonalDetail personalDetailId = reviewer.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId.getReviewerSet().remove(reviewer);
                personalDetailId = em.merge(personalDetailId);
            }
            Set<Review> reviewSet = reviewer.getReviewSet();
            for (Review reviewSetReview : reviewSet) {
                reviewSetReview.setReviewerId(null);
                reviewSetReview = em.merge(reviewSetReview);
            }
            em.remove(reviewer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reviewer> findReviewerEntities() {
        return findReviewerEntities(true, -1, -1);
    }

    public List<Reviewer> findReviewerEntities(int maxResults, int firstResult) {
        return findReviewerEntities(false, maxResults, firstResult);
    }

    private List<Reviewer> findReviewerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reviewer.class));
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

    public Reviewer findReviewer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reviewer.class, id);
        } finally {
            em.close();
        }
    }

    public int getReviewerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reviewer> rt = cq.from(Reviewer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
