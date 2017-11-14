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
import com.etlsolutions.examples.database.entity.ItemCommonDetail;
import com.etlsolutions.examples.database.entity.Publisher;
import com.etlsolutions.examples.database.entity.Author;
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
public class BookJpaController implements Serializable {

    public BookJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Book book) throws PreexistingEntityException, Exception {
        if (book.getAuthorSet() == null) {
            book.setAuthorSet(new HashSet<Author>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemCommonDetail itemCommonDetailId = book.getItemCommonDetailId();
            if (itemCommonDetailId != null) {
                itemCommonDetailId = em.getReference(itemCommonDetailId.getClass(), itemCommonDetailId.getItemCommonDetailId());
                book.setItemCommonDetailId(itemCommonDetailId);
            }
            Publisher publisherId = book.getPublisherId();
            if (publisherId != null) {
                publisherId = em.getReference(publisherId.getClass(), publisherId.getPublisherId());
                book.setPublisherId(publisherId);
            }
            Set<Author> attachedAuthorSet = new HashSet<Author>();
            for (Author authorSetAuthorToAttach : book.getAuthorSet()) {
                authorSetAuthorToAttach = em.getReference(authorSetAuthorToAttach.getClass(), authorSetAuthorToAttach.getAuthorId());
                attachedAuthorSet.add(authorSetAuthorToAttach);
            }
            book.setAuthorSet(attachedAuthorSet);
            em.persist(book);
            if (itemCommonDetailId != null) {
                Book oldBookOfItemCommonDetailId = itemCommonDetailId.getBook();
                if (oldBookOfItemCommonDetailId != null) {
                    oldBookOfItemCommonDetailId.setItemCommonDetailId(null);
                    oldBookOfItemCommonDetailId = em.merge(oldBookOfItemCommonDetailId);
                }
                itemCommonDetailId.setBook(book);
                itemCommonDetailId = em.merge(itemCommonDetailId);
            }
            if (publisherId != null) {
                publisherId.getBookSet().add(book);
                publisherId = em.merge(publisherId);
            }
            for (Author authorSetAuthor : book.getAuthorSet()) {
                authorSetAuthor.getBookSet().add(book);
                authorSetAuthor = em.merge(authorSetAuthor);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBook(book.getBookId()) != null) {
                throw new PreexistingEntityException("Book " + book + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Book book) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Book persistentBook = em.find(Book.class, book.getBookId());
            ItemCommonDetail itemCommonDetailIdOld = persistentBook.getItemCommonDetailId();
            ItemCommonDetail itemCommonDetailIdNew = book.getItemCommonDetailId();
            Publisher publisherIdOld = persistentBook.getPublisherId();
            Publisher publisherIdNew = book.getPublisherId();
            Set<Author> authorSetOld = persistentBook.getAuthorSet();
            Set<Author> authorSetNew = book.getAuthorSet();
            if (itemCommonDetailIdNew != null) {
                itemCommonDetailIdNew = em.getReference(itemCommonDetailIdNew.getClass(), itemCommonDetailIdNew.getItemCommonDetailId());
                book.setItemCommonDetailId(itemCommonDetailIdNew);
            }
            if (publisherIdNew != null) {
                publisherIdNew = em.getReference(publisherIdNew.getClass(), publisherIdNew.getPublisherId());
                book.setPublisherId(publisherIdNew);
            }
            Set<Author> attachedAuthorSetNew = new HashSet<Author>();
            for (Author authorSetNewAuthorToAttach : authorSetNew) {
                authorSetNewAuthorToAttach = em.getReference(authorSetNewAuthorToAttach.getClass(), authorSetNewAuthorToAttach.getAuthorId());
                attachedAuthorSetNew.add(authorSetNewAuthorToAttach);
            }
            authorSetNew = attachedAuthorSetNew;
            book.setAuthorSet(authorSetNew);
            book = em.merge(book);
            if (itemCommonDetailIdOld != null && !itemCommonDetailIdOld.equals(itemCommonDetailIdNew)) {
                itemCommonDetailIdOld.setBook(null);
                itemCommonDetailIdOld = em.merge(itemCommonDetailIdOld);
            }
            if (itemCommonDetailIdNew != null && !itemCommonDetailIdNew.equals(itemCommonDetailIdOld)) {
                Book oldBookOfItemCommonDetailId = itemCommonDetailIdNew.getBook();
                if (oldBookOfItemCommonDetailId != null) {
                    oldBookOfItemCommonDetailId.setItemCommonDetailId(null);
                    oldBookOfItemCommonDetailId = em.merge(oldBookOfItemCommonDetailId);
                }
                itemCommonDetailIdNew.setBook(book);
                itemCommonDetailIdNew = em.merge(itemCommonDetailIdNew);
            }
            if (publisherIdOld != null && !publisherIdOld.equals(publisherIdNew)) {
                publisherIdOld.getBookSet().remove(book);
                publisherIdOld = em.merge(publisherIdOld);
            }
            if (publisherIdNew != null && !publisherIdNew.equals(publisherIdOld)) {
                publisherIdNew.getBookSet().add(book);
                publisherIdNew = em.merge(publisherIdNew);
            }
            for (Author authorSetOldAuthor : authorSetOld) {
                if (!authorSetNew.contains(authorSetOldAuthor)) {
                    authorSetOldAuthor.getBookSet().remove(book);
                    authorSetOldAuthor = em.merge(authorSetOldAuthor);
                }
            }
            for (Author authorSetNewAuthor : authorSetNew) {
                if (!authorSetOld.contains(authorSetNewAuthor)) {
                    authorSetNewAuthor.getBookSet().add(book);
                    authorSetNewAuthor = em.merge(authorSetNewAuthor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = book.getBookId();
                if (findBook(id) == null) {
                    throw new NonexistentEntityException("The book with id " + id + " no longer exists.");
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
            Book book;
            try {
                book = em.getReference(Book.class, id);
                book.getBookId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The book with id " + id + " no longer exists.", enfe);
            }
            ItemCommonDetail itemCommonDetailId = book.getItemCommonDetailId();
            if (itemCommonDetailId != null) {
                itemCommonDetailId.setBook(null);
                itemCommonDetailId = em.merge(itemCommonDetailId);
            }
            Publisher publisherId = book.getPublisherId();
            if (publisherId != null) {
                publisherId.getBookSet().remove(book);
                publisherId = em.merge(publisherId);
            }
            Set<Author> authorSet = book.getAuthorSet();
            for (Author authorSetAuthor : authorSet) {
                authorSetAuthor.getBookSet().remove(book);
                authorSetAuthor = em.merge(authorSetAuthor);
            }
            em.remove(book);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Book> findBookEntities() {
        return findBookEntities(true, -1, -1);
    }

    public List<Book> findBookEntities(int maxResults, int firstResult) {
        return findBookEntities(false, maxResults, firstResult);
    }

    private List<Book> findBookEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Book.class));
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

    public Book findBook(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Book.class, id);
        } finally {
            em.close();
        }
    }

    public int getBookCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Book> rt = cq.from(Book.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
