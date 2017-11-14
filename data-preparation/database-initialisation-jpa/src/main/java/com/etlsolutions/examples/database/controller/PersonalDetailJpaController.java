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
import com.etlsolutions.examples.database.entity.Administrator;
import com.etlsolutions.examples.database.entity.Author;
import com.etlsolutions.examples.database.entity.Telephone;
import java.util.HashSet;
import java.util.Set;
import com.etlsolutions.examples.database.entity.Email;
import com.etlsolutions.examples.database.entity.PersonAddressLink;
import com.etlsolutions.examples.database.entity.PersonalDetail;
import com.etlsolutions.examples.database.entity.Reviewer;
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
public class PersonalDetailJpaController implements Serializable {

    public PersonalDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PersonalDetail personalDetail) throws PreexistingEntityException, Exception {
        if (personalDetail.getTelephoneSet() == null) {
            personalDetail.setTelephoneSet(new HashSet<Telephone>());
        }
        if (personalDetail.getEmailSet() == null) {
            personalDetail.setEmailSet(new HashSet<Email>());
        }
        if (personalDetail.getPersonAddressLinkSet() == null) {
            personalDetail.setPersonAddressLinkSet(new HashSet<PersonAddressLink>());
        }
        if (personalDetail.getReviewerSet() == null) {
            personalDetail.setReviewerSet(new HashSet<Reviewer>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrator administrator = personalDetail.getAdministrator();
            if (administrator != null) {
                administrator = em.getReference(administrator.getClass(), administrator.getAdministratorId());
                personalDetail.setAdministrator(administrator);
            }
            Author author = personalDetail.getAuthor();
            if (author != null) {
                author = em.getReference(author.getClass(), author.getAuthorId());
                personalDetail.setAuthor(author);
            }
            Set<Telephone> attachedTelephoneSet = new HashSet<Telephone>();
            for (Telephone telephoneSetTelephoneToAttach : personalDetail.getTelephoneSet()) {
                telephoneSetTelephoneToAttach = em.getReference(telephoneSetTelephoneToAttach.getClass(), telephoneSetTelephoneToAttach.getTelephoneId());
                attachedTelephoneSet.add(telephoneSetTelephoneToAttach);
            }
            personalDetail.setTelephoneSet(attachedTelephoneSet);
            Set<Email> attachedEmailSet = new HashSet<Email>();
            for (Email emailSetEmailToAttach : personalDetail.getEmailSet()) {
                emailSetEmailToAttach = em.getReference(emailSetEmailToAttach.getClass(), emailSetEmailToAttach.getEmailId());
                attachedEmailSet.add(emailSetEmailToAttach);
            }
            personalDetail.setEmailSet(attachedEmailSet);
            Set<PersonAddressLink> attachedPersonAddressLinkSet = new HashSet<PersonAddressLink>();
            for (PersonAddressLink personAddressLinkSetPersonAddressLinkToAttach : personalDetail.getPersonAddressLinkSet()) {
                personAddressLinkSetPersonAddressLinkToAttach = em.getReference(personAddressLinkSetPersonAddressLinkToAttach.getClass(), personAddressLinkSetPersonAddressLinkToAttach.getLinkId());
                attachedPersonAddressLinkSet.add(personAddressLinkSetPersonAddressLinkToAttach);
            }
            personalDetail.setPersonAddressLinkSet(attachedPersonAddressLinkSet);
            Set<Reviewer> attachedReviewerSet = new HashSet<Reviewer>();
            for (Reviewer reviewerSetReviewerToAttach : personalDetail.getReviewerSet()) {
                reviewerSetReviewerToAttach = em.getReference(reviewerSetReviewerToAttach.getClass(), reviewerSetReviewerToAttach.getReviewerId());
                attachedReviewerSet.add(reviewerSetReviewerToAttach);
            }
            personalDetail.setReviewerSet(attachedReviewerSet);
            em.persist(personalDetail);
            if (administrator != null) {
                PersonalDetail oldPersonalDetailIdOfAdministrator = administrator.getPersonalDetailId();
                if (oldPersonalDetailIdOfAdministrator != null) {
                    oldPersonalDetailIdOfAdministrator.setAdministrator(null);
                    oldPersonalDetailIdOfAdministrator = em.merge(oldPersonalDetailIdOfAdministrator);
                }
                administrator.setPersonalDetailId(personalDetail);
                administrator = em.merge(administrator);
            }
            if (author != null) {
                PersonalDetail oldPersonalDetailIdOfAuthor = author.getPersonalDetailId();
                if (oldPersonalDetailIdOfAuthor != null) {
                    oldPersonalDetailIdOfAuthor.setAuthor(null);
                    oldPersonalDetailIdOfAuthor = em.merge(oldPersonalDetailIdOfAuthor);
                }
                author.setPersonalDetailId(personalDetail);
                author = em.merge(author);
            }
            for (Telephone telephoneSetTelephone : personalDetail.getTelephoneSet()) {
                telephoneSetTelephone.getPersonalDetailSet().add(personalDetail);
                telephoneSetTelephone = em.merge(telephoneSetTelephone);
            }
            for (Email emailSetEmail : personalDetail.getEmailSet()) {
                PersonalDetail oldPersonalDetailIdOfEmailSetEmail = emailSetEmail.getPersonalDetailId();
                emailSetEmail.setPersonalDetailId(personalDetail);
                emailSetEmail = em.merge(emailSetEmail);
                if (oldPersonalDetailIdOfEmailSetEmail != null) {
                    oldPersonalDetailIdOfEmailSetEmail.getEmailSet().remove(emailSetEmail);
                    oldPersonalDetailIdOfEmailSetEmail = em.merge(oldPersonalDetailIdOfEmailSetEmail);
                }
            }
            for (PersonAddressLink personAddressLinkSetPersonAddressLink : personalDetail.getPersonAddressLinkSet()) {
                PersonalDetail oldPersonalDetailIdOfPersonAddressLinkSetPersonAddressLink = personAddressLinkSetPersonAddressLink.getPersonalDetailId();
                personAddressLinkSetPersonAddressLink.setPersonalDetailId(personalDetail);
                personAddressLinkSetPersonAddressLink = em.merge(personAddressLinkSetPersonAddressLink);
                if (oldPersonalDetailIdOfPersonAddressLinkSetPersonAddressLink != null) {
                    oldPersonalDetailIdOfPersonAddressLinkSetPersonAddressLink.getPersonAddressLinkSet().remove(personAddressLinkSetPersonAddressLink);
                    oldPersonalDetailIdOfPersonAddressLinkSetPersonAddressLink = em.merge(oldPersonalDetailIdOfPersonAddressLinkSetPersonAddressLink);
                }
            }
            for (Reviewer reviewerSetReviewer : personalDetail.getReviewerSet()) {
                PersonalDetail oldPersonalDetailIdOfReviewerSetReviewer = reviewerSetReviewer.getPersonalDetailId();
                reviewerSetReviewer.setPersonalDetailId(personalDetail);
                reviewerSetReviewer = em.merge(reviewerSetReviewer);
                if (oldPersonalDetailIdOfReviewerSetReviewer != null) {
                    oldPersonalDetailIdOfReviewerSetReviewer.getReviewerSet().remove(reviewerSetReviewer);
                    oldPersonalDetailIdOfReviewerSetReviewer = em.merge(oldPersonalDetailIdOfReviewerSetReviewer);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersonalDetail(personalDetail.getPersonalDetailId()) != null) {
                throw new PreexistingEntityException("PersonalDetail " + personalDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PersonalDetail personalDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonalDetail persistentPersonalDetail = em.find(PersonalDetail.class, personalDetail.getPersonalDetailId());
            Administrator administratorOld = persistentPersonalDetail.getAdministrator();
            Administrator administratorNew = personalDetail.getAdministrator();
            Author authorOld = persistentPersonalDetail.getAuthor();
            Author authorNew = personalDetail.getAuthor();
            Set<Telephone> telephoneSetOld = persistentPersonalDetail.getTelephoneSet();
            Set<Telephone> telephoneSetNew = personalDetail.getTelephoneSet();
            Set<Email> emailSetOld = persistentPersonalDetail.getEmailSet();
            Set<Email> emailSetNew = personalDetail.getEmailSet();
            Set<PersonAddressLink> personAddressLinkSetOld = persistentPersonalDetail.getPersonAddressLinkSet();
            Set<PersonAddressLink> personAddressLinkSetNew = personalDetail.getPersonAddressLinkSet();
            Set<Reviewer> reviewerSetOld = persistentPersonalDetail.getReviewerSet();
            Set<Reviewer> reviewerSetNew = personalDetail.getReviewerSet();
            if (administratorNew != null) {
                administratorNew = em.getReference(administratorNew.getClass(), administratorNew.getAdministratorId());
                personalDetail.setAdministrator(administratorNew);
            }
            if (authorNew != null) {
                authorNew = em.getReference(authorNew.getClass(), authorNew.getAuthorId());
                personalDetail.setAuthor(authorNew);
            }
            Set<Telephone> attachedTelephoneSetNew = new HashSet<Telephone>();
            for (Telephone telephoneSetNewTelephoneToAttach : telephoneSetNew) {
                telephoneSetNewTelephoneToAttach = em.getReference(telephoneSetNewTelephoneToAttach.getClass(), telephoneSetNewTelephoneToAttach.getTelephoneId());
                attachedTelephoneSetNew.add(telephoneSetNewTelephoneToAttach);
            }
            telephoneSetNew = attachedTelephoneSetNew;
            personalDetail.setTelephoneSet(telephoneSetNew);
            Set<Email> attachedEmailSetNew = new HashSet<Email>();
            for (Email emailSetNewEmailToAttach : emailSetNew) {
                emailSetNewEmailToAttach = em.getReference(emailSetNewEmailToAttach.getClass(), emailSetNewEmailToAttach.getEmailId());
                attachedEmailSetNew.add(emailSetNewEmailToAttach);
            }
            emailSetNew = attachedEmailSetNew;
            personalDetail.setEmailSet(emailSetNew);
            Set<PersonAddressLink> attachedPersonAddressLinkSetNew = new HashSet<PersonAddressLink>();
            for (PersonAddressLink personAddressLinkSetNewPersonAddressLinkToAttach : personAddressLinkSetNew) {
                personAddressLinkSetNewPersonAddressLinkToAttach = em.getReference(personAddressLinkSetNewPersonAddressLinkToAttach.getClass(), personAddressLinkSetNewPersonAddressLinkToAttach.getLinkId());
                attachedPersonAddressLinkSetNew.add(personAddressLinkSetNewPersonAddressLinkToAttach);
            }
            personAddressLinkSetNew = attachedPersonAddressLinkSetNew;
            personalDetail.setPersonAddressLinkSet(personAddressLinkSetNew);
            Set<Reviewer> attachedReviewerSetNew = new HashSet<Reviewer>();
            for (Reviewer reviewerSetNewReviewerToAttach : reviewerSetNew) {
                reviewerSetNewReviewerToAttach = em.getReference(reviewerSetNewReviewerToAttach.getClass(), reviewerSetNewReviewerToAttach.getReviewerId());
                attachedReviewerSetNew.add(reviewerSetNewReviewerToAttach);
            }
            reviewerSetNew = attachedReviewerSetNew;
            personalDetail.setReviewerSet(reviewerSetNew);
            personalDetail = em.merge(personalDetail);
            if (administratorOld != null && !administratorOld.equals(administratorNew)) {
                administratorOld.setPersonalDetailId(null);
                administratorOld = em.merge(administratorOld);
            }
            if (administratorNew != null && !administratorNew.equals(administratorOld)) {
                PersonalDetail oldPersonalDetailIdOfAdministrator = administratorNew.getPersonalDetailId();
                if (oldPersonalDetailIdOfAdministrator != null) {
                    oldPersonalDetailIdOfAdministrator.setAdministrator(null);
                    oldPersonalDetailIdOfAdministrator = em.merge(oldPersonalDetailIdOfAdministrator);
                }
                administratorNew.setPersonalDetailId(personalDetail);
                administratorNew = em.merge(administratorNew);
            }
            if (authorOld != null && !authorOld.equals(authorNew)) {
                authorOld.setPersonalDetailId(null);
                authorOld = em.merge(authorOld);
            }
            if (authorNew != null && !authorNew.equals(authorOld)) {
                PersonalDetail oldPersonalDetailIdOfAuthor = authorNew.getPersonalDetailId();
                if (oldPersonalDetailIdOfAuthor != null) {
                    oldPersonalDetailIdOfAuthor.setAuthor(null);
                    oldPersonalDetailIdOfAuthor = em.merge(oldPersonalDetailIdOfAuthor);
                }
                authorNew.setPersonalDetailId(personalDetail);
                authorNew = em.merge(authorNew);
            }
            for (Telephone telephoneSetOldTelephone : telephoneSetOld) {
                if (!telephoneSetNew.contains(telephoneSetOldTelephone)) {
                    telephoneSetOldTelephone.getPersonalDetailSet().remove(personalDetail);
                    telephoneSetOldTelephone = em.merge(telephoneSetOldTelephone);
                }
            }
            for (Telephone telephoneSetNewTelephone : telephoneSetNew) {
                if (!telephoneSetOld.contains(telephoneSetNewTelephone)) {
                    telephoneSetNewTelephone.getPersonalDetailSet().add(personalDetail);
                    telephoneSetNewTelephone = em.merge(telephoneSetNewTelephone);
                }
            }
            for (Email emailSetOldEmail : emailSetOld) {
                if (!emailSetNew.contains(emailSetOldEmail)) {
                    emailSetOldEmail.setPersonalDetailId(null);
                    emailSetOldEmail = em.merge(emailSetOldEmail);
                }
            }
            for (Email emailSetNewEmail : emailSetNew) {
                if (!emailSetOld.contains(emailSetNewEmail)) {
                    PersonalDetail oldPersonalDetailIdOfEmailSetNewEmail = emailSetNewEmail.getPersonalDetailId();
                    emailSetNewEmail.setPersonalDetailId(personalDetail);
                    emailSetNewEmail = em.merge(emailSetNewEmail);
                    if (oldPersonalDetailIdOfEmailSetNewEmail != null && !oldPersonalDetailIdOfEmailSetNewEmail.equals(personalDetail)) {
                        oldPersonalDetailIdOfEmailSetNewEmail.getEmailSet().remove(emailSetNewEmail);
                        oldPersonalDetailIdOfEmailSetNewEmail = em.merge(oldPersonalDetailIdOfEmailSetNewEmail);
                    }
                }
            }
            for (PersonAddressLink personAddressLinkSetOldPersonAddressLink : personAddressLinkSetOld) {
                if (!personAddressLinkSetNew.contains(personAddressLinkSetOldPersonAddressLink)) {
                    personAddressLinkSetOldPersonAddressLink.setPersonalDetailId(null);
                    personAddressLinkSetOldPersonAddressLink = em.merge(personAddressLinkSetOldPersonAddressLink);
                }
            }
            for (PersonAddressLink personAddressLinkSetNewPersonAddressLink : personAddressLinkSetNew) {
                if (!personAddressLinkSetOld.contains(personAddressLinkSetNewPersonAddressLink)) {
                    PersonalDetail oldPersonalDetailIdOfPersonAddressLinkSetNewPersonAddressLink = personAddressLinkSetNewPersonAddressLink.getPersonalDetailId();
                    personAddressLinkSetNewPersonAddressLink.setPersonalDetailId(personalDetail);
                    personAddressLinkSetNewPersonAddressLink = em.merge(personAddressLinkSetNewPersonAddressLink);
                    if (oldPersonalDetailIdOfPersonAddressLinkSetNewPersonAddressLink != null && !oldPersonalDetailIdOfPersonAddressLinkSetNewPersonAddressLink.equals(personalDetail)) {
                        oldPersonalDetailIdOfPersonAddressLinkSetNewPersonAddressLink.getPersonAddressLinkSet().remove(personAddressLinkSetNewPersonAddressLink);
                        oldPersonalDetailIdOfPersonAddressLinkSetNewPersonAddressLink = em.merge(oldPersonalDetailIdOfPersonAddressLinkSetNewPersonAddressLink);
                    }
                }
            }
            for (Reviewer reviewerSetOldReviewer : reviewerSetOld) {
                if (!reviewerSetNew.contains(reviewerSetOldReviewer)) {
                    reviewerSetOldReviewer.setPersonalDetailId(null);
                    reviewerSetOldReviewer = em.merge(reviewerSetOldReviewer);
                }
            }
            for (Reviewer reviewerSetNewReviewer : reviewerSetNew) {
                if (!reviewerSetOld.contains(reviewerSetNewReviewer)) {
                    PersonalDetail oldPersonalDetailIdOfReviewerSetNewReviewer = reviewerSetNewReviewer.getPersonalDetailId();
                    reviewerSetNewReviewer.setPersonalDetailId(personalDetail);
                    reviewerSetNewReviewer = em.merge(reviewerSetNewReviewer);
                    if (oldPersonalDetailIdOfReviewerSetNewReviewer != null && !oldPersonalDetailIdOfReviewerSetNewReviewer.equals(personalDetail)) {
                        oldPersonalDetailIdOfReviewerSetNewReviewer.getReviewerSet().remove(reviewerSetNewReviewer);
                        oldPersonalDetailIdOfReviewerSetNewReviewer = em.merge(oldPersonalDetailIdOfReviewerSetNewReviewer);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = personalDetail.getPersonalDetailId();
                if (findPersonalDetail(id) == null) {
                    throw new NonexistentEntityException("The personalDetail with id " + id + " no longer exists.");
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
            PersonalDetail personalDetail;
            try {
                personalDetail = em.getReference(PersonalDetail.class, id);
                personalDetail.getPersonalDetailId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personalDetail with id " + id + " no longer exists.", enfe);
            }
            Administrator administrator = personalDetail.getAdministrator();
            if (administrator != null) {
                administrator.setPersonalDetailId(null);
                administrator = em.merge(administrator);
            }
            Author author = personalDetail.getAuthor();
            if (author != null) {
                author.setPersonalDetailId(null);
                author = em.merge(author);
            }
            Set<Telephone> telephoneSet = personalDetail.getTelephoneSet();
            for (Telephone telephoneSetTelephone : telephoneSet) {
                telephoneSetTelephone.getPersonalDetailSet().remove(personalDetail);
                telephoneSetTelephone = em.merge(telephoneSetTelephone);
            }
            Set<Email> emailSet = personalDetail.getEmailSet();
            for (Email emailSetEmail : emailSet) {
                emailSetEmail.setPersonalDetailId(null);
                emailSetEmail = em.merge(emailSetEmail);
            }
            Set<PersonAddressLink> personAddressLinkSet = personalDetail.getPersonAddressLinkSet();
            for (PersonAddressLink personAddressLinkSetPersonAddressLink : personAddressLinkSet) {
                personAddressLinkSetPersonAddressLink.setPersonalDetailId(null);
                personAddressLinkSetPersonAddressLink = em.merge(personAddressLinkSetPersonAddressLink);
            }
            Set<Reviewer> reviewerSet = personalDetail.getReviewerSet();
            for (Reviewer reviewerSetReviewer : reviewerSet) {
                reviewerSetReviewer.setPersonalDetailId(null);
                reviewerSetReviewer = em.merge(reviewerSetReviewer);
            }
            em.remove(personalDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PersonalDetail> findPersonalDetailEntities() {
        return findPersonalDetailEntities(true, -1, -1);
    }

    public List<PersonalDetail> findPersonalDetailEntities(int maxResults, int firstResult) {
        return findPersonalDetailEntities(false, maxResults, firstResult);
    }

    private List<PersonalDetail> findPersonalDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PersonalDetail.class));
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

    public PersonalDetail findPersonalDetail(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PersonalDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonalDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PersonalDetail> rt = cq.from(PersonalDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
