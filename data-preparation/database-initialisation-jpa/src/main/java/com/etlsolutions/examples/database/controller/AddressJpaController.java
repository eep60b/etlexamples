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
import com.etlsolutions.examples.database.entity.Address;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.entity.PersonAddressLink;
import java.util.HashSet;
import java.util.Set;
import com.etlsolutions.examples.database.entity.Publisher;
import com.etlsolutions.examples.database.entity.Invoice;
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
public class AddressJpaController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public AddressJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Address address) throws PreexistingEntityException  {
        if (address.getPersonAddressLinkSet() == null) {
            address.setPersonAddressLinkSet(new HashSet<>());
        }
        if (address.getPublisherSet() == null) {
            address.setPublisherSet(new HashSet<>());
        }
        if (address.getInvoiceSet() == null) {
            address.setInvoiceSet(new HashSet<>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<PersonAddressLink> attachedPersonAddressLinkSet = new HashSet<>();
            for (PersonAddressLink personAddressLinkSetPersonAddressLinkToAttach : address.getPersonAddressLinkSet()) {
                personAddressLinkSetPersonAddressLinkToAttach = em.getReference(personAddressLinkSetPersonAddressLinkToAttach.getClass(), personAddressLinkSetPersonAddressLinkToAttach.getLinkId());
                attachedPersonAddressLinkSet.add(personAddressLinkSetPersonAddressLinkToAttach);
            }
            address.setPersonAddressLinkSet(attachedPersonAddressLinkSet);
            Set<Publisher> attachedPublisherSet = new HashSet<>();
            for (Publisher publisherSetPublisherToAttach : address.getPublisherSet()) {
                publisherSetPublisherToAttach = em.getReference(publisherSetPublisherToAttach.getClass(), publisherSetPublisherToAttach.getPublisherId());
                attachedPublisherSet.add(publisherSetPublisherToAttach);
            }
            address.setPublisherSet(attachedPublisherSet);
            Set<Invoice> attachedInvoiceSet = new HashSet<>();
            for (Invoice invoiceSetInvoiceToAttach : address.getInvoiceSet()) {
                invoiceSetInvoiceToAttach = em.getReference(invoiceSetInvoiceToAttach.getClass(), invoiceSetInvoiceToAttach.getInvoiceId());
                attachedInvoiceSet.add(invoiceSetInvoiceToAttach);
            }
            address.setInvoiceSet(attachedInvoiceSet);
            em.persist(address);
            for (PersonAddressLink personAddressLinkSetPersonAddressLink : address.getPersonAddressLinkSet()) {
                Address oldAddressIdOfPersonAddressLinkSetPersonAddressLink = personAddressLinkSetPersonAddressLink.getAddressId();
                personAddressLinkSetPersonAddressLink.setAddressId(address);
                personAddressLinkSetPersonAddressLink = em.merge(personAddressLinkSetPersonAddressLink);
                if (oldAddressIdOfPersonAddressLinkSetPersonAddressLink != null) {
                    oldAddressIdOfPersonAddressLinkSetPersonAddressLink.getPersonAddressLinkSet().remove(personAddressLinkSetPersonAddressLink);
                    oldAddressIdOfPersonAddressLinkSetPersonAddressLink = em.merge(oldAddressIdOfPersonAddressLinkSetPersonAddressLink);
                }
            }
            for (Publisher publisherSetPublisher : address.getPublisherSet()) {
                Address oldAddressIdOfPublisherSetPublisher = publisherSetPublisher.getAddressId();
                publisherSetPublisher.setAddressId(address);
                publisherSetPublisher = em.merge(publisherSetPublisher);
                if (oldAddressIdOfPublisherSetPublisher != null) {
                    oldAddressIdOfPublisherSetPublisher.getPublisherSet().remove(publisherSetPublisher);
                    oldAddressIdOfPublisherSetPublisher = em.merge(oldAddressIdOfPublisherSetPublisher);
                }
            }
            for (Invoice invoiceSetInvoice : address.getInvoiceSet()) {
                Address oldDeliveryAddressIdOfInvoiceSetInvoice = invoiceSetInvoice.getDeliveryAddressId();
                invoiceSetInvoice.setDeliveryAddressId(address);
                invoiceSetInvoice = em.merge(invoiceSetInvoice);
                if (oldDeliveryAddressIdOfInvoiceSetInvoice != null) {
                    oldDeliveryAddressIdOfInvoiceSetInvoice.getInvoiceSet().remove(invoiceSetInvoice);
                    oldDeliveryAddressIdOfInvoiceSetInvoice = em.merge(oldDeliveryAddressIdOfInvoiceSetInvoice);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAddress(address.getAddressId()) != null) {
                throw new PreexistingEntityException("Address " + address + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Address address) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address persistentAddress = em.find(Address.class, address.getAddressId());
            Set<PersonAddressLink> personAddressLinkSetOld = persistentAddress.getPersonAddressLinkSet();
            Set<PersonAddressLink> personAddressLinkSetNew = address.getPersonAddressLinkSet();
            Set<Publisher> publisherSetOld = persistentAddress.getPublisherSet();
            Set<Publisher> publisherSetNew = address.getPublisherSet();
            Set<Invoice> invoiceSetOld = persistentAddress.getInvoiceSet();
            Set<Invoice> invoiceSetNew = address.getInvoiceSet();
            Set<PersonAddressLink> attachedPersonAddressLinkSetNew = new HashSet<>();
            for (PersonAddressLink personAddressLinkSetNewPersonAddressLinkToAttach : personAddressLinkSetNew) {
                personAddressLinkSetNewPersonAddressLinkToAttach = em.getReference(personAddressLinkSetNewPersonAddressLinkToAttach.getClass(), personAddressLinkSetNewPersonAddressLinkToAttach.getLinkId());
                attachedPersonAddressLinkSetNew.add(personAddressLinkSetNewPersonAddressLinkToAttach);
            }
            personAddressLinkSetNew = attachedPersonAddressLinkSetNew;
            address.setPersonAddressLinkSet(personAddressLinkSetNew);
            Set<Publisher> attachedPublisherSetNew = new HashSet<Publisher>();
            for (Publisher publisherSetNewPublisherToAttach : publisherSetNew) {
                publisherSetNewPublisherToAttach = em.getReference(publisherSetNewPublisherToAttach.getClass(), publisherSetNewPublisherToAttach.getPublisherId());
                attachedPublisherSetNew.add(publisherSetNewPublisherToAttach);
            }
            publisherSetNew = attachedPublisherSetNew;
            address.setPublisherSet(publisherSetNew);
            Set<Invoice> attachedInvoiceSetNew = new HashSet<Invoice>();
            for (Invoice invoiceSetNewInvoiceToAttach : invoiceSetNew) {
                invoiceSetNewInvoiceToAttach = em.getReference(invoiceSetNewInvoiceToAttach.getClass(), invoiceSetNewInvoiceToAttach.getInvoiceId());
                attachedInvoiceSetNew.add(invoiceSetNewInvoiceToAttach);
            }
            invoiceSetNew = attachedInvoiceSetNew;
            address.setInvoiceSet(invoiceSetNew);
            address = em.merge(address);
            for (PersonAddressLink personAddressLinkSetOldPersonAddressLink : personAddressLinkSetOld) {
                if (!personAddressLinkSetNew.contains(personAddressLinkSetOldPersonAddressLink)) {
                    personAddressLinkSetOldPersonAddressLink.setAddressId(null);
                    personAddressLinkSetOldPersonAddressLink = em.merge(personAddressLinkSetOldPersonAddressLink);
                }
            }
            for (PersonAddressLink personAddressLinkSetNewPersonAddressLink : personAddressLinkSetNew) {
                if (!personAddressLinkSetOld.contains(personAddressLinkSetNewPersonAddressLink)) {
                    Address oldAddressIdOfPersonAddressLinkSetNewPersonAddressLink = personAddressLinkSetNewPersonAddressLink.getAddressId();
                    personAddressLinkSetNewPersonAddressLink.setAddressId(address);
                    personAddressLinkSetNewPersonAddressLink = em.merge(personAddressLinkSetNewPersonAddressLink);
                    if (oldAddressIdOfPersonAddressLinkSetNewPersonAddressLink != null && !oldAddressIdOfPersonAddressLinkSetNewPersonAddressLink.equals(address)) {
                        oldAddressIdOfPersonAddressLinkSetNewPersonAddressLink.getPersonAddressLinkSet().remove(personAddressLinkSetNewPersonAddressLink);
                        oldAddressIdOfPersonAddressLinkSetNewPersonAddressLink = em.merge(oldAddressIdOfPersonAddressLinkSetNewPersonAddressLink);
                    }
                }
            }
            for (Publisher publisherSetOldPublisher : publisherSetOld) {
                if (!publisherSetNew.contains(publisherSetOldPublisher)) {
                    publisherSetOldPublisher.setAddressId(null);
                    publisherSetOldPublisher = em.merge(publisherSetOldPublisher);
                }
            }
            for (Publisher publisherSetNewPublisher : publisherSetNew) {
                if (!publisherSetOld.contains(publisherSetNewPublisher)) {
                    Address oldAddressIdOfPublisherSetNewPublisher = publisherSetNewPublisher.getAddressId();
                    publisherSetNewPublisher.setAddressId(address);
                    publisherSetNewPublisher = em.merge(publisherSetNewPublisher);
                    if (oldAddressIdOfPublisherSetNewPublisher != null && !oldAddressIdOfPublisherSetNewPublisher.equals(address)) {
                        oldAddressIdOfPublisherSetNewPublisher.getPublisherSet().remove(publisherSetNewPublisher);
                        oldAddressIdOfPublisherSetNewPublisher = em.merge(oldAddressIdOfPublisherSetNewPublisher);
                    }
                }
            }
            for (Invoice invoiceSetOldInvoice : invoiceSetOld) {
                if (!invoiceSetNew.contains(invoiceSetOldInvoice)) {
                    invoiceSetOldInvoice.setDeliveryAddressId(null);
                    invoiceSetOldInvoice = em.merge(invoiceSetOldInvoice);
                }
            }
            for (Invoice invoiceSetNewInvoice : invoiceSetNew) {
                if (!invoiceSetOld.contains(invoiceSetNewInvoice)) {
                    Address oldDeliveryAddressIdOfInvoiceSetNewInvoice = invoiceSetNewInvoice.getDeliveryAddressId();
                    invoiceSetNewInvoice.setDeliveryAddressId(address);
                    invoiceSetNewInvoice = em.merge(invoiceSetNewInvoice);
                    if (oldDeliveryAddressIdOfInvoiceSetNewInvoice != null && !oldDeliveryAddressIdOfInvoiceSetNewInvoice.equals(address)) {
                        oldDeliveryAddressIdOfInvoiceSetNewInvoice.getInvoiceSet().remove(invoiceSetNewInvoice);
                        oldDeliveryAddressIdOfInvoiceSetNewInvoice = em.merge(oldDeliveryAddressIdOfInvoiceSetNewInvoice);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = address.getAddressId();
                if (findAddress(id) == null) {
                    throw new NonexistentEntityException("The address with id " + id + " no longer exists.");
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
            Address address;
            try {
                address = em.getReference(Address.class, id);
                address.getAddressId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The address with id " + id + " no longer exists.", enfe);
            }
            Set<PersonAddressLink> personAddressLinkSet = address.getPersonAddressLinkSet();
            for (PersonAddressLink personAddressLinkSetPersonAddressLink : personAddressLinkSet) {
                personAddressLinkSetPersonAddressLink.setAddressId(null);
                personAddressLinkSetPersonAddressLink = em.merge(personAddressLinkSetPersonAddressLink);
            }
            Set<Publisher> publisherSet = address.getPublisherSet();
            for (Publisher publisherSetPublisher : publisherSet) {
                publisherSetPublisher.setAddressId(null);
                publisherSetPublisher = em.merge(publisherSetPublisher);
            }
            Set<Invoice> invoiceSet = address.getInvoiceSet();
            for (Invoice invoiceSetInvoice : invoiceSet) {
                invoiceSetInvoice.setDeliveryAddressId(null);
                invoiceSetInvoice = em.merge(invoiceSetInvoice);
            }
            em.remove(address);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Address> findAddressEntities() {
        return findAddressEntities(true, -1, -1);
    }

    public List<Address> findAddressEntities(int maxResults, int firstResult) {
        return findAddressEntities(false, maxResults, firstResult);
    }

    private List<Address> findAddressEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Address.class));
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

    public Address findAddress(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Address.class, id);
        } finally {
            em.close();
        }
    }

    public int getAddressCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Address> rt = cq.from(Address.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
