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
import com.etlsolutions.examples.database.entity.Author;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.entity.PersonalDetail;
import com.etlsolutions.examples.database.entity.Book;
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
public class AuthorJpaController implements Serializable {

    public AuthorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Author author) throws PreexistingEntityException, Exception {
        if (author.getBookSet() == null) {
            author.setBookSet(new HashSet<Book>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonalDetail personalDetailId = author.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId = em.getReference(personalDetailId.getClass(), personalDetailId.getPersonalDetailId());
                author.setPersonalDetailId(personalDetailId);
            }
            Set<Book> attachedBookSet = new HashSet<Book>();
            for (Book bookSetBookToAttach : author.getBookSet()) {
                bookSetBookToAttach = em.getReference(bookSetBookToAttach.getClass(), bookSetBookToAttach.getBookId());
                attachedBookSet.add(bookSetBookToAttach);
            }
            author.setBookSet(attachedBookSet);
            em.persist(author);
            if (personalDetailId != null) {
                Author oldAuthorOfPersonalDetailId = personalDetailId.getAuthor();
                if (oldAuthorOfPersonalDetailId != null) {
                    oldAuthorOfPersonalDetailId.setPersonalDetailId(null);
                    oldAuthorOfPersonalDetailId = em.merge(oldAuthorOfPersonalDetailId);
                }
                personalDetailId.setAuthor(author);
                personalDetailId = em.merge(personalDetailId);
            }
            for (Book bookSetBook : author.getBookSet()) {
                bookSetBook.getAuthorSet().add(author);
                bookSetBook = em.merge(bookSetBook);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAuthor(author.getAuthorId()) != null) {
                throw new PreexistingEntityException("Author " + author + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Author author) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Author persistentAuthor = em.find(Author.class, author.getAuthorId());
            PersonalDetail personalDetailIdOld = persistentAuthor.getPersonalDetailId();
            PersonalDetail personalDetailIdNew = author.getPersonalDetailId();
            Set<Book> bookSetOld = persistentAuthor.getBookSet();
            Set<Book> bookSetNew = author.getBookSet();
            if (personalDetailIdNew != null) {
                personalDetailIdNew = em.getReference(personalDetailIdNew.getClass(), personalDetailIdNew.getPersonalDetailId());
                author.setPersonalDetailId(personalDetailIdNew);
            }
            Set<Book> attachedBookSetNew = new HashSet<Book>();
            for (Book bookSetNewBookToAttach : bookSetNew) {
                bookSetNewBookToAttach = em.getReference(bookSetNewBookToAttach.getClass(), bookSetNewBookToAttach.getBookId());
                attachedBookSetNew.add(bookSetNewBookToAttach);
            }
            bookSetNew = attachedBookSetNew;
            author.setBookSet(bookSetNew);
            author = em.merge(author);
            if (personalDetailIdOld != null && !personalDetailIdOld.equals(personalDetailIdNew)) {
                personalDetailIdOld.setAuthor(null);
                personalDetailIdOld = em.merge(personalDetailIdOld);
            }
            if (personalDetailIdNew != null && !personalDetailIdNew.equals(personalDetailIdOld)) {
                Author oldAuthorOfPersonalDetailId = personalDetailIdNew.getAuthor();
                if (oldAuthorOfPersonalDetailId != null) {
                    oldAuthorOfPersonalDetailId.setPersonalDetailId(null);
                    oldAuthorOfPersonalDetailId = em.merge(oldAuthorOfPersonalDetailId);
                }
                personalDetailIdNew.setAuthor(author);
                personalDetailIdNew = em.merge(personalDetailIdNew);
            }
            for (Book bookSetOldBook : bookSetOld) {
                if (!bookSetNew.contains(bookSetOldBook)) {
                    bookSetOldBook.getAuthorSet().remove(author);
                    bookSetOldBook = em.merge(bookSetOldBook);
                }
            }
            for (Book bookSetNewBook : bookSetNew) {
                if (!bookSetOld.contains(bookSetNewBook)) {
                    bookSetNewBook.getAuthorSet().add(author);
                    bookSetNewBook = em.merge(bookSetNewBook);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = author.getAuthorId();
                if (findAuthor(id) == null) {
                    throw new NonexistentEntityException("The author with id " + id + " no longer exists.");
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
            Author author;
            try {
                author = em.getReference(Author.class, id);
                author.getAuthorId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The author with id " + id + " no longer exists.", enfe);
            }
            PersonalDetail personalDetailId = author.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId.setAuthor(null);
                personalDetailId = em.merge(personalDetailId);
            }
            Set<Book> bookSet = author.getBookSet();
            for (Book bookSetBook : bookSet) {
                bookSetBook.getAuthorSet().remove(author);
                bookSetBook = em.merge(bookSetBook);
            }
            em.remove(author);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Author> findAuthorEntities() {
        return findAuthorEntities(true, -1, -1);
    }

    public List<Author> findAuthorEntities(int maxResults, int firstResult) {
        return findAuthorEntities(false, maxResults, firstResult);
    }

    private List<Author> findAuthorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Author.class));
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

    public Author findAuthor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Author.class, id);
        } finally {
            em.close();
        }
    }

    public int getAuthorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Author> rt = cq.from(Author.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
