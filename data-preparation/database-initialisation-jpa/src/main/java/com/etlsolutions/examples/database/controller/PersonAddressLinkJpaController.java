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
import com.etlsolutions.examples.database.entity.PersonalDetail;
import com.etlsolutions.examples.database.entity.Customer;
import com.etlsolutions.examples.database.entity.MastercardPayment;
import java.util.HashSet;
import java.util.Set;
import com.etlsolutions.examples.database.entity.VisacardPayment;
import com.etlsolutions.examples.database.entity.AmexcardPayment;
import com.etlsolutions.examples.database.entity.DebitcardPayment;
import com.etlsolutions.examples.database.entity.PersonAddressLink;
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
public class PersonAddressLinkJpaController implements Serializable {

    public PersonAddressLinkJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PersonAddressLink personAddressLink) throws PreexistingEntityException, Exception {
        if (personAddressLink.getMastercardPaymentSet() == null) {
            personAddressLink.setMastercardPaymentSet(new HashSet<MastercardPayment>());
        }
        if (personAddressLink.getVisacardPaymentSet() == null) {
            personAddressLink.setVisacardPaymentSet(new HashSet<VisacardPayment>());
        }
        if (personAddressLink.getAmexcardPaymentSet() == null) {
            personAddressLink.setAmexcardPaymentSet(new HashSet<AmexcardPayment>());
        }
        if (personAddressLink.getDebitcardPaymentSet() == null) {
            personAddressLink.setDebitcardPaymentSet(new HashSet<DebitcardPayment>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address addressId = personAddressLink.getAddressId();
            if (addressId != null) {
                addressId = em.getReference(addressId.getClass(), addressId.getAddressId());
                personAddressLink.setAddressId(addressId);
            }
            PersonalDetail personalDetailId = personAddressLink.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId = em.getReference(personalDetailId.getClass(), personalDetailId.getPersonalDetailId());
                personAddressLink.setPersonalDetailId(personalDetailId);
            }
            Customer customer = personAddressLink.getCustomer();
            if (customer != null) {
                customer = em.getReference(customer.getClass(), customer.getCustomerId());
                personAddressLink.setCustomer(customer);
            }
            Set<MastercardPayment> attachedMastercardPaymentSet = new HashSet<MastercardPayment>();
            for (MastercardPayment mastercardPaymentSetMastercardPaymentToAttach : personAddressLink.getMastercardPaymentSet()) {
                mastercardPaymentSetMastercardPaymentToAttach = em.getReference(mastercardPaymentSetMastercardPaymentToAttach.getClass(), mastercardPaymentSetMastercardPaymentToAttach.getPaymentId());
                attachedMastercardPaymentSet.add(mastercardPaymentSetMastercardPaymentToAttach);
            }
            personAddressLink.setMastercardPaymentSet(attachedMastercardPaymentSet);
            Set<VisacardPayment> attachedVisacardPaymentSet = new HashSet<VisacardPayment>();
            for (VisacardPayment visacardPaymentSetVisacardPaymentToAttach : personAddressLink.getVisacardPaymentSet()) {
                visacardPaymentSetVisacardPaymentToAttach = em.getReference(visacardPaymentSetVisacardPaymentToAttach.getClass(), visacardPaymentSetVisacardPaymentToAttach.getPaymentId());
                attachedVisacardPaymentSet.add(visacardPaymentSetVisacardPaymentToAttach);
            }
            personAddressLink.setVisacardPaymentSet(attachedVisacardPaymentSet);
            Set<AmexcardPayment> attachedAmexcardPaymentSet = new HashSet<AmexcardPayment>();
            for (AmexcardPayment amexcardPaymentSetAmexcardPaymentToAttach : personAddressLink.getAmexcardPaymentSet()) {
                amexcardPaymentSetAmexcardPaymentToAttach = em.getReference(amexcardPaymentSetAmexcardPaymentToAttach.getClass(), amexcardPaymentSetAmexcardPaymentToAttach.getPaymentId());
                attachedAmexcardPaymentSet.add(amexcardPaymentSetAmexcardPaymentToAttach);
            }
            personAddressLink.setAmexcardPaymentSet(attachedAmexcardPaymentSet);
            Set<DebitcardPayment> attachedDebitcardPaymentSet = new HashSet<DebitcardPayment>();
            for (DebitcardPayment debitcardPaymentSetDebitcardPaymentToAttach : personAddressLink.getDebitcardPaymentSet()) {
                debitcardPaymentSetDebitcardPaymentToAttach = em.getReference(debitcardPaymentSetDebitcardPaymentToAttach.getClass(), debitcardPaymentSetDebitcardPaymentToAttach.getPaymentId());
                attachedDebitcardPaymentSet.add(debitcardPaymentSetDebitcardPaymentToAttach);
            }
            personAddressLink.setDebitcardPaymentSet(attachedDebitcardPaymentSet);
            em.persist(personAddressLink);
            if (addressId != null) {
                addressId.getPersonAddressLinkSet().add(personAddressLink);
                addressId = em.merge(addressId);
            }
            if (personalDetailId != null) {
                personalDetailId.getPersonAddressLinkSet().add(personAddressLink);
                personalDetailId = em.merge(personalDetailId);
            }
            if (customer != null) {
                PersonAddressLink oldPersonAddressLinkIdOfCustomer = customer.getPersonAddressLinkId();
                if (oldPersonAddressLinkIdOfCustomer != null) {
                    oldPersonAddressLinkIdOfCustomer.setCustomer(null);
                    oldPersonAddressLinkIdOfCustomer = em.merge(oldPersonAddressLinkIdOfCustomer);
                }
                customer.setPersonAddressLinkId(personAddressLink);
                customer = em.merge(customer);
            }
            for (MastercardPayment mastercardPaymentSetMastercardPayment : personAddressLink.getMastercardPaymentSet()) {
                PersonAddressLink oldPersonAddressLinkIdOfMastercardPaymentSetMastercardPayment = mastercardPaymentSetMastercardPayment.getPersonAddressLinkId();
                mastercardPaymentSetMastercardPayment.setPersonAddressLinkId(personAddressLink);
                mastercardPaymentSetMastercardPayment = em.merge(mastercardPaymentSetMastercardPayment);
                if (oldPersonAddressLinkIdOfMastercardPaymentSetMastercardPayment != null) {
                    oldPersonAddressLinkIdOfMastercardPaymentSetMastercardPayment.getMastercardPaymentSet().remove(mastercardPaymentSetMastercardPayment);
                    oldPersonAddressLinkIdOfMastercardPaymentSetMastercardPayment = em.merge(oldPersonAddressLinkIdOfMastercardPaymentSetMastercardPayment);
                }
            }
            for (VisacardPayment visacardPaymentSetVisacardPayment : personAddressLink.getVisacardPaymentSet()) {
                PersonAddressLink oldPersonAddressLinkIdOfVisacardPaymentSetVisacardPayment = visacardPaymentSetVisacardPayment.getPersonAddressLinkId();
                visacardPaymentSetVisacardPayment.setPersonAddressLinkId(personAddressLink);
                visacardPaymentSetVisacardPayment = em.merge(visacardPaymentSetVisacardPayment);
                if (oldPersonAddressLinkIdOfVisacardPaymentSetVisacardPayment != null) {
                    oldPersonAddressLinkIdOfVisacardPaymentSetVisacardPayment.getVisacardPaymentSet().remove(visacardPaymentSetVisacardPayment);
                    oldPersonAddressLinkIdOfVisacardPaymentSetVisacardPayment = em.merge(oldPersonAddressLinkIdOfVisacardPaymentSetVisacardPayment);
                }
            }
            for (AmexcardPayment amexcardPaymentSetAmexcardPayment : personAddressLink.getAmexcardPaymentSet()) {
                PersonAddressLink oldPersonAddressLinkIdOfAmexcardPaymentSetAmexcardPayment = amexcardPaymentSetAmexcardPayment.getPersonAddressLinkId();
                amexcardPaymentSetAmexcardPayment.setPersonAddressLinkId(personAddressLink);
                amexcardPaymentSetAmexcardPayment = em.merge(amexcardPaymentSetAmexcardPayment);
                if (oldPersonAddressLinkIdOfAmexcardPaymentSetAmexcardPayment != null) {
                    oldPersonAddressLinkIdOfAmexcardPaymentSetAmexcardPayment.getAmexcardPaymentSet().remove(amexcardPaymentSetAmexcardPayment);
                    oldPersonAddressLinkIdOfAmexcardPaymentSetAmexcardPayment = em.merge(oldPersonAddressLinkIdOfAmexcardPaymentSetAmexcardPayment);
                }
            }
            for (DebitcardPayment debitcardPaymentSetDebitcardPayment : personAddressLink.getDebitcardPaymentSet()) {
                PersonAddressLink oldPersonAddressLinkIdOfDebitcardPaymentSetDebitcardPayment = debitcardPaymentSetDebitcardPayment.getPersonAddressLinkId();
                debitcardPaymentSetDebitcardPayment.setPersonAddressLinkId(personAddressLink);
                debitcardPaymentSetDebitcardPayment = em.merge(debitcardPaymentSetDebitcardPayment);
                if (oldPersonAddressLinkIdOfDebitcardPaymentSetDebitcardPayment != null) {
                    oldPersonAddressLinkIdOfDebitcardPaymentSetDebitcardPayment.getDebitcardPaymentSet().remove(debitcardPaymentSetDebitcardPayment);
                    oldPersonAddressLinkIdOfDebitcardPaymentSetDebitcardPayment = em.merge(oldPersonAddressLinkIdOfDebitcardPaymentSetDebitcardPayment);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersonAddressLink(personAddressLink.getLinkId()) != null) {
                throw new PreexistingEntityException("PersonAddressLink " + personAddressLink + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PersonAddressLink personAddressLink) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonAddressLink persistentPersonAddressLink = em.find(PersonAddressLink.class, personAddressLink.getLinkId());
            Address addressIdOld = persistentPersonAddressLink.getAddressId();
            Address addressIdNew = personAddressLink.getAddressId();
            PersonalDetail personalDetailIdOld = persistentPersonAddressLink.getPersonalDetailId();
            PersonalDetail personalDetailIdNew = personAddressLink.getPersonalDetailId();
            Customer customerOld = persistentPersonAddressLink.getCustomer();
            Customer customerNew = personAddressLink.getCustomer();
            Set<MastercardPayment> mastercardPaymentSetOld = persistentPersonAddressLink.getMastercardPaymentSet();
            Set<MastercardPayment> mastercardPaymentSetNew = personAddressLink.getMastercardPaymentSet();
            Set<VisacardPayment> visacardPaymentSetOld = persistentPersonAddressLink.getVisacardPaymentSet();
            Set<VisacardPayment> visacardPaymentSetNew = personAddressLink.getVisacardPaymentSet();
            Set<AmexcardPayment> amexcardPaymentSetOld = persistentPersonAddressLink.getAmexcardPaymentSet();
            Set<AmexcardPayment> amexcardPaymentSetNew = personAddressLink.getAmexcardPaymentSet();
            Set<DebitcardPayment> debitcardPaymentSetOld = persistentPersonAddressLink.getDebitcardPaymentSet();
            Set<DebitcardPayment> debitcardPaymentSetNew = personAddressLink.getDebitcardPaymentSet();
            if (addressIdNew != null) {
                addressIdNew = em.getReference(addressIdNew.getClass(), addressIdNew.getAddressId());
                personAddressLink.setAddressId(addressIdNew);
            }
            if (personalDetailIdNew != null) {
                personalDetailIdNew = em.getReference(personalDetailIdNew.getClass(), personalDetailIdNew.getPersonalDetailId());
                personAddressLink.setPersonalDetailId(personalDetailIdNew);
            }
            if (customerNew != null) {
                customerNew = em.getReference(customerNew.getClass(), customerNew.getCustomerId());
                personAddressLink.setCustomer(customerNew);
            }
            Set<MastercardPayment> attachedMastercardPaymentSetNew = new HashSet<MastercardPayment>();
            for (MastercardPayment mastercardPaymentSetNewMastercardPaymentToAttach : mastercardPaymentSetNew) {
                mastercardPaymentSetNewMastercardPaymentToAttach = em.getReference(mastercardPaymentSetNewMastercardPaymentToAttach.getClass(), mastercardPaymentSetNewMastercardPaymentToAttach.getPaymentId());
                attachedMastercardPaymentSetNew.add(mastercardPaymentSetNewMastercardPaymentToAttach);
            }
            mastercardPaymentSetNew = attachedMastercardPaymentSetNew;
            personAddressLink.setMastercardPaymentSet(mastercardPaymentSetNew);
            Set<VisacardPayment> attachedVisacardPaymentSetNew = new HashSet<VisacardPayment>();
            for (VisacardPayment visacardPaymentSetNewVisacardPaymentToAttach : visacardPaymentSetNew) {
                visacardPaymentSetNewVisacardPaymentToAttach = em.getReference(visacardPaymentSetNewVisacardPaymentToAttach.getClass(), visacardPaymentSetNewVisacardPaymentToAttach.getPaymentId());
                attachedVisacardPaymentSetNew.add(visacardPaymentSetNewVisacardPaymentToAttach);
            }
            visacardPaymentSetNew = attachedVisacardPaymentSetNew;
            personAddressLink.setVisacardPaymentSet(visacardPaymentSetNew);
            Set<AmexcardPayment> attachedAmexcardPaymentSetNew = new HashSet<AmexcardPayment>();
            for (AmexcardPayment amexcardPaymentSetNewAmexcardPaymentToAttach : amexcardPaymentSetNew) {
                amexcardPaymentSetNewAmexcardPaymentToAttach = em.getReference(amexcardPaymentSetNewAmexcardPaymentToAttach.getClass(), amexcardPaymentSetNewAmexcardPaymentToAttach.getPaymentId());
                attachedAmexcardPaymentSetNew.add(amexcardPaymentSetNewAmexcardPaymentToAttach);
            }
            amexcardPaymentSetNew = attachedAmexcardPaymentSetNew;
            personAddressLink.setAmexcardPaymentSet(amexcardPaymentSetNew);
            Set<DebitcardPayment> attachedDebitcardPaymentSetNew = new HashSet<DebitcardPayment>();
            for (DebitcardPayment debitcardPaymentSetNewDebitcardPaymentToAttach : debitcardPaymentSetNew) {
                debitcardPaymentSetNewDebitcardPaymentToAttach = em.getReference(debitcardPaymentSetNewDebitcardPaymentToAttach.getClass(), debitcardPaymentSetNewDebitcardPaymentToAttach.getPaymentId());
                attachedDebitcardPaymentSetNew.add(debitcardPaymentSetNewDebitcardPaymentToAttach);
            }
            debitcardPaymentSetNew = attachedDebitcardPaymentSetNew;
            personAddressLink.setDebitcardPaymentSet(debitcardPaymentSetNew);
            personAddressLink = em.merge(personAddressLink);
            if (addressIdOld != null && !addressIdOld.equals(addressIdNew)) {
                addressIdOld.getPersonAddressLinkSet().remove(personAddressLink);
                addressIdOld = em.merge(addressIdOld);
            }
            if (addressIdNew != null && !addressIdNew.equals(addressIdOld)) {
                addressIdNew.getPersonAddressLinkSet().add(personAddressLink);
                addressIdNew = em.merge(addressIdNew);
            }
            if (personalDetailIdOld != null && !personalDetailIdOld.equals(personalDetailIdNew)) {
                personalDetailIdOld.getPersonAddressLinkSet().remove(personAddressLink);
                personalDetailIdOld = em.merge(personalDetailIdOld);
            }
            if (personalDetailIdNew != null && !personalDetailIdNew.equals(personalDetailIdOld)) {
                personalDetailIdNew.getPersonAddressLinkSet().add(personAddressLink);
                personalDetailIdNew = em.merge(personalDetailIdNew);
            }
            if (customerOld != null && !customerOld.equals(customerNew)) {
                customerOld.setPersonAddressLinkId(null);
                customerOld = em.merge(customerOld);
            }
            if (customerNew != null && !customerNew.equals(customerOld)) {
                PersonAddressLink oldPersonAddressLinkIdOfCustomer = customerNew.getPersonAddressLinkId();
                if (oldPersonAddressLinkIdOfCustomer != null) {
                    oldPersonAddressLinkIdOfCustomer.setCustomer(null);
                    oldPersonAddressLinkIdOfCustomer = em.merge(oldPersonAddressLinkIdOfCustomer);
                }
                customerNew.setPersonAddressLinkId(personAddressLink);
                customerNew = em.merge(customerNew);
            }
            for (MastercardPayment mastercardPaymentSetOldMastercardPayment : mastercardPaymentSetOld) {
                if (!mastercardPaymentSetNew.contains(mastercardPaymentSetOldMastercardPayment)) {
                    mastercardPaymentSetOldMastercardPayment.setPersonAddressLinkId(null);
                    mastercardPaymentSetOldMastercardPayment = em.merge(mastercardPaymentSetOldMastercardPayment);
                }
            }
            for (MastercardPayment mastercardPaymentSetNewMastercardPayment : mastercardPaymentSetNew) {
                if (!mastercardPaymentSetOld.contains(mastercardPaymentSetNewMastercardPayment)) {
                    PersonAddressLink oldPersonAddressLinkIdOfMastercardPaymentSetNewMastercardPayment = mastercardPaymentSetNewMastercardPayment.getPersonAddressLinkId();
                    mastercardPaymentSetNewMastercardPayment.setPersonAddressLinkId(personAddressLink);
                    mastercardPaymentSetNewMastercardPayment = em.merge(mastercardPaymentSetNewMastercardPayment);
                    if (oldPersonAddressLinkIdOfMastercardPaymentSetNewMastercardPayment != null && !oldPersonAddressLinkIdOfMastercardPaymentSetNewMastercardPayment.equals(personAddressLink)) {
                        oldPersonAddressLinkIdOfMastercardPaymentSetNewMastercardPayment.getMastercardPaymentSet().remove(mastercardPaymentSetNewMastercardPayment);
                        oldPersonAddressLinkIdOfMastercardPaymentSetNewMastercardPayment = em.merge(oldPersonAddressLinkIdOfMastercardPaymentSetNewMastercardPayment);
                    }
                }
            }
            for (VisacardPayment visacardPaymentSetOldVisacardPayment : visacardPaymentSetOld) {
                if (!visacardPaymentSetNew.contains(visacardPaymentSetOldVisacardPayment)) {
                    visacardPaymentSetOldVisacardPayment.setPersonAddressLinkId(null);
                    visacardPaymentSetOldVisacardPayment = em.merge(visacardPaymentSetOldVisacardPayment);
                }
            }
            for (VisacardPayment visacardPaymentSetNewVisacardPayment : visacardPaymentSetNew) {
                if (!visacardPaymentSetOld.contains(visacardPaymentSetNewVisacardPayment)) {
                    PersonAddressLink oldPersonAddressLinkIdOfVisacardPaymentSetNewVisacardPayment = visacardPaymentSetNewVisacardPayment.getPersonAddressLinkId();
                    visacardPaymentSetNewVisacardPayment.setPersonAddressLinkId(personAddressLink);
                    visacardPaymentSetNewVisacardPayment = em.merge(visacardPaymentSetNewVisacardPayment);
                    if (oldPersonAddressLinkIdOfVisacardPaymentSetNewVisacardPayment != null && !oldPersonAddressLinkIdOfVisacardPaymentSetNewVisacardPayment.equals(personAddressLink)) {
                        oldPersonAddressLinkIdOfVisacardPaymentSetNewVisacardPayment.getVisacardPaymentSet().remove(visacardPaymentSetNewVisacardPayment);
                        oldPersonAddressLinkIdOfVisacardPaymentSetNewVisacardPayment = em.merge(oldPersonAddressLinkIdOfVisacardPaymentSetNewVisacardPayment);
                    }
                }
            }
            for (AmexcardPayment amexcardPaymentSetOldAmexcardPayment : amexcardPaymentSetOld) {
                if (!amexcardPaymentSetNew.contains(amexcardPaymentSetOldAmexcardPayment)) {
                    amexcardPaymentSetOldAmexcardPayment.setPersonAddressLinkId(null);
                    amexcardPaymentSetOldAmexcardPayment = em.merge(amexcardPaymentSetOldAmexcardPayment);
                }
            }
            for (AmexcardPayment amexcardPaymentSetNewAmexcardPayment : amexcardPaymentSetNew) {
                if (!amexcardPaymentSetOld.contains(amexcardPaymentSetNewAmexcardPayment)) {
                    PersonAddressLink oldPersonAddressLinkIdOfAmexcardPaymentSetNewAmexcardPayment = amexcardPaymentSetNewAmexcardPayment.getPersonAddressLinkId();
                    amexcardPaymentSetNewAmexcardPayment.setPersonAddressLinkId(personAddressLink);
                    amexcardPaymentSetNewAmexcardPayment = em.merge(amexcardPaymentSetNewAmexcardPayment);
                    if (oldPersonAddressLinkIdOfAmexcardPaymentSetNewAmexcardPayment != null && !oldPersonAddressLinkIdOfAmexcardPaymentSetNewAmexcardPayment.equals(personAddressLink)) {
                        oldPersonAddressLinkIdOfAmexcardPaymentSetNewAmexcardPayment.getAmexcardPaymentSet().remove(amexcardPaymentSetNewAmexcardPayment);
                        oldPersonAddressLinkIdOfAmexcardPaymentSetNewAmexcardPayment = em.merge(oldPersonAddressLinkIdOfAmexcardPaymentSetNewAmexcardPayment);
                    }
                }
            }
            for (DebitcardPayment debitcardPaymentSetOldDebitcardPayment : debitcardPaymentSetOld) {
                if (!debitcardPaymentSetNew.contains(debitcardPaymentSetOldDebitcardPayment)) {
                    debitcardPaymentSetOldDebitcardPayment.setPersonAddressLinkId(null);
                    debitcardPaymentSetOldDebitcardPayment = em.merge(debitcardPaymentSetOldDebitcardPayment);
                }
            }
            for (DebitcardPayment debitcardPaymentSetNewDebitcardPayment : debitcardPaymentSetNew) {
                if (!debitcardPaymentSetOld.contains(debitcardPaymentSetNewDebitcardPayment)) {
                    PersonAddressLink oldPersonAddressLinkIdOfDebitcardPaymentSetNewDebitcardPayment = debitcardPaymentSetNewDebitcardPayment.getPersonAddressLinkId();
                    debitcardPaymentSetNewDebitcardPayment.setPersonAddressLinkId(personAddressLink);
                    debitcardPaymentSetNewDebitcardPayment = em.merge(debitcardPaymentSetNewDebitcardPayment);
                    if (oldPersonAddressLinkIdOfDebitcardPaymentSetNewDebitcardPayment != null && !oldPersonAddressLinkIdOfDebitcardPaymentSetNewDebitcardPayment.equals(personAddressLink)) {
                        oldPersonAddressLinkIdOfDebitcardPaymentSetNewDebitcardPayment.getDebitcardPaymentSet().remove(debitcardPaymentSetNewDebitcardPayment);
                        oldPersonAddressLinkIdOfDebitcardPaymentSetNewDebitcardPayment = em.merge(oldPersonAddressLinkIdOfDebitcardPaymentSetNewDebitcardPayment);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = personAddressLink.getLinkId();
                if (findPersonAddressLink(id) == null) {
                    throw new NonexistentEntityException("The personAddressLink with id " + id + " no longer exists.");
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
            PersonAddressLink personAddressLink;
            try {
                personAddressLink = em.getReference(PersonAddressLink.class, id);
                personAddressLink.getLinkId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personAddressLink with id " + id + " no longer exists.", enfe);
            }
            Address addressId = personAddressLink.getAddressId();
            if (addressId != null) {
                addressId.getPersonAddressLinkSet().remove(personAddressLink);
                addressId = em.merge(addressId);
            }
            PersonalDetail personalDetailId = personAddressLink.getPersonalDetailId();
            if (personalDetailId != null) {
                personalDetailId.getPersonAddressLinkSet().remove(personAddressLink);
                personalDetailId = em.merge(personalDetailId);
            }
            Customer customer = personAddressLink.getCustomer();
            if (customer != null) {
                customer.setPersonAddressLinkId(null);
                customer = em.merge(customer);
            }
            Set<MastercardPayment> mastercardPaymentSet = personAddressLink.getMastercardPaymentSet();
            for (MastercardPayment mastercardPaymentSetMastercardPayment : mastercardPaymentSet) {
                mastercardPaymentSetMastercardPayment.setPersonAddressLinkId(null);
                mastercardPaymentSetMastercardPayment = em.merge(mastercardPaymentSetMastercardPayment);
            }
            Set<VisacardPayment> visacardPaymentSet = personAddressLink.getVisacardPaymentSet();
            for (VisacardPayment visacardPaymentSetVisacardPayment : visacardPaymentSet) {
                visacardPaymentSetVisacardPayment.setPersonAddressLinkId(null);
                visacardPaymentSetVisacardPayment = em.merge(visacardPaymentSetVisacardPayment);
            }
            Set<AmexcardPayment> amexcardPaymentSet = personAddressLink.getAmexcardPaymentSet();
            for (AmexcardPayment amexcardPaymentSetAmexcardPayment : amexcardPaymentSet) {
                amexcardPaymentSetAmexcardPayment.setPersonAddressLinkId(null);
                amexcardPaymentSetAmexcardPayment = em.merge(amexcardPaymentSetAmexcardPayment);
            }
            Set<DebitcardPayment> debitcardPaymentSet = personAddressLink.getDebitcardPaymentSet();
            for (DebitcardPayment debitcardPaymentSetDebitcardPayment : debitcardPaymentSet) {
                debitcardPaymentSetDebitcardPayment.setPersonAddressLinkId(null);
                debitcardPaymentSetDebitcardPayment = em.merge(debitcardPaymentSetDebitcardPayment);
            }
            em.remove(personAddressLink);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PersonAddressLink> findPersonAddressLinkEntities() {
        return findPersonAddressLinkEntities(true, -1, -1);
    }

    public List<PersonAddressLink> findPersonAddressLinkEntities(int maxResults, int firstResult) {
        return findPersonAddressLinkEntities(false, maxResults, firstResult);
    }

    private List<PersonAddressLink> findPersonAddressLinkEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PersonAddressLink.class));
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

    public PersonAddressLink findPersonAddressLink(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PersonAddressLink.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonAddressLinkCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PersonAddressLink> rt = cq.from(PersonAddressLink.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
