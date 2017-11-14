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
import com.etlsolutions.examples.database.entity.Address;
import com.etlsolutions.examples.database.entity.Book;
import com.etlsolutions.examples.database.entity.Publisher;
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
public class PublisherJpaController implements Serializable {

    public PublisherJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Publisher publisher) throws PreexistingEntityException, Exception {
        if (publisher.getBookSet() == null) {
            publisher.setBookSet(new HashSet<Book>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address addressId = publisher.getAddressId();
            if (addressId != null) {
                addressId = em.getReference(addressId.getClass(), addressId.getAddressId());
                publisher.setAddressId(addressId);
            }
            Set<Book> attachedBookSet = new HashSet<Book>();
            for (Book bookSetBookToAttach : publisher.getBookSet()) {
                bookSetBookToAttach = em.getReference(bookSetBookToAttach.getClass(), bookSetBookToAttach.getBookId());
                attachedBookSet.add(bookSetBookToAttach);
            }
            publisher.setBookSet(attachedBookSet);
            em.persist(publisher);
            if (addressId != null) {
                addressId.getPublisherSet().add(publisher);
                addressId = em.merge(addressId);
            }
            for (Book bookSetBook : publisher.getBookSet()) {
                Publisher oldPublisherIdOfBookSetBook = bookSetBook.getPublisherId();
                bookSetBook.setPublisherId(publisher);
                bookSetBook = em.merge(bookSetBook);
                if (oldPublisherIdOfBookSetBook != null) {
                    oldPublisherIdOfBookSetBook.getBookSet().remove(bookSetBook);
                    oldPublisherIdOfBookSetBook = em.merge(oldPublisherIdOfBookSetBook);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPublisher(publisher.getPublisherId()) != null) {
                throw new PreexistingEntityException("Publisher " + publisher + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Publisher publisher) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Publisher persistentPublisher = em.find(Publisher.class, publisher.getPublisherId());
            Address addressIdOld = persistentPublisher.getAddressId();
            Address addressIdNew = publisher.getAddressId();
            Set<Book> bookSetOld = persistentPublisher.getBookSet();
            Set<Book> bookSetNew = publisher.getBookSet();
            if (addressIdNew != null) {
                addressIdNew = em.getReference(addressIdNew.getClass(), addressIdNew.getAddressId());
                publisher.setAddressId(addressIdNew);
            }
            Set<Book> attachedBookSetNew = new HashSet<Book>();
            for (Book bookSetNewBookToAttach : bookSetNew) {
                bookSetNewBookToAttach = em.getReference(bookSetNewBookToAttach.getClass(), bookSetNewBookToAttach.getBookId());
                attachedBookSetNew.add(bookSetNewBookToAttach);
            }
            bookSetNew = attachedBookSetNew;
            publisher.setBookSet(bookSetNew);
            publisher = em.merge(publisher);
            if (addressIdOld != null && !addressIdOld.equals(addressIdNew)) {
                addressIdOld.getPublisherSet().remove(publisher);
                addressIdOld = em.merge(addressIdOld);
            }
            if (addressIdNew != null && !addressIdNew.equals(addressIdOld)) {
                addressIdNew.getPublisherSet().add(publisher);
                addressIdNew = em.merge(addressIdNew);
            }
            for (Book bookSetOldBook : bookSetOld) {
                if (!bookSetNew.contains(bookSetOldBook)) {
                    bookSetOldBook.setPublisherId(null);
                    bookSetOldBook = em.merge(bookSetOldBook);
                }
            }
            for (Book bookSetNewBook : bookSetNew) {
                if (!bookSetOld.contains(bookSetNewBook)) {
                    Publisher oldPublisherIdOfBookSetNewBook = bookSetNewBook.getPublisherId();
                    bookSetNewBook.setPublisherId(publisher);
                    bookSetNewBook = em.merge(bookSetNewBook);
                    if (oldPublisherIdOfBookSetNewBook != null && !oldPublisherIdOfBookSetNewBook.equals(publisher)) {
                        oldPublisherIdOfBookSetNewBook.getBookSet().remove(bookSetNewBook);
                        oldPublisherIdOfBookSetNewBook = em.merge(oldPublisherIdOfBookSetNewBook);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = publisher.getPublisherId();
                if (findPublisher(id) == null) {
                    throw new NonexistentEntityException("The publisher with id " + id + " no longer exists.");
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
            Publisher publisher;
            try {
                publisher = em.getReference(Publisher.class, id);
                publisher.getPublisherId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The publisher with id " + id + " no longer exists.", enfe);
            }
            Address addressId = publisher.getAddressId();
            if (addressId != null) {
                addressId.getPublisherSet().remove(publisher);
                addressId = em.merge(addressId);
            }
            Set<Book> bookSet = publisher.getBookSet();
            for (Book bookSetBook : bookSet) {
                bookSetBook.setPublisherId(null);
                bookSetBook = em.merge(bookSetBook);
            }
            em.remove(publisher);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Publisher> findPublisherEntities() {
        return findPublisherEntities(true, -1, -1);
    }

    public List<Publisher> findPublisherEntities(int maxResults, int firstResult) {
        return findPublisherEntities(false, maxResults, firstResult);
    }

    private List<Publisher> findPublisherEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Publisher.class));
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

    public Publisher findPublisher(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Publisher.class, id);
        } finally {
            em.close();
        }
    }

    public int getPublisherCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Publisher> rt = cq.from(Publisher.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
