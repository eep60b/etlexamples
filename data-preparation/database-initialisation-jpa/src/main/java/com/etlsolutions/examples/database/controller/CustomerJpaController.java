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
import com.etlsolutions.examples.database.entity.Customer;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.entity.PersonAddressLink;
import com.etlsolutions.examples.database.entity.Voucher;
import java.util.HashSet;
import java.util.Set;
import com.etlsolutions.examples.database.entity.Wishlist;
import com.etlsolutions.examples.database.entity.ShoppingCartItem;
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
public class CustomerJpaController implements Serializable {

    public CustomerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Customer customer) throws PreexistingEntityException, Exception {
        if (customer.getVoucherSet() == null) {
            customer.setVoucherSet(new HashSet<Voucher>());
        }
        if (customer.getWishlistSet() == null) {
            customer.setWishlistSet(new HashSet<Wishlist>());
        }
        if (customer.getShoppingCartItemSet() == null) {
            customer.setShoppingCartItemSet(new HashSet<ShoppingCartItem>());
        }
        if (customer.getInvoiceSet() == null) {
            customer.setInvoiceSet(new HashSet<Invoice>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonAddressLink personAddressLinkId = customer.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId = em.getReference(personAddressLinkId.getClass(), personAddressLinkId.getLinkId());
                customer.setPersonAddressLinkId(personAddressLinkId);
            }
            Set<Voucher> attachedVoucherSet = new HashSet<Voucher>();
            for (Voucher voucherSetVoucherToAttach : customer.getVoucherSet()) {
                voucherSetVoucherToAttach = em.getReference(voucherSetVoucherToAttach.getClass(), voucherSetVoucherToAttach.getVoucherId());
                attachedVoucherSet.add(voucherSetVoucherToAttach);
            }
            customer.setVoucherSet(attachedVoucherSet);
            Set<Wishlist> attachedWishlistSet = new HashSet<Wishlist>();
            for (Wishlist wishlistSetWishlistToAttach : customer.getWishlistSet()) {
                wishlistSetWishlistToAttach = em.getReference(wishlistSetWishlistToAttach.getClass(), wishlistSetWishlistToAttach.getWishlistId());
                attachedWishlistSet.add(wishlistSetWishlistToAttach);
            }
            customer.setWishlistSet(attachedWishlistSet);
            Set<ShoppingCartItem> attachedShoppingCartItemSet = new HashSet<ShoppingCartItem>();
            for (ShoppingCartItem shoppingCartItemSetShoppingCartItemToAttach : customer.getShoppingCartItemSet()) {
                shoppingCartItemSetShoppingCartItemToAttach = em.getReference(shoppingCartItemSetShoppingCartItemToAttach.getClass(), shoppingCartItemSetShoppingCartItemToAttach.getShoppingCartItemId());
                attachedShoppingCartItemSet.add(shoppingCartItemSetShoppingCartItemToAttach);
            }
            customer.setShoppingCartItemSet(attachedShoppingCartItemSet);
            Set<Invoice> attachedInvoiceSet = new HashSet<Invoice>();
            for (Invoice invoiceSetInvoiceToAttach : customer.getInvoiceSet()) {
                invoiceSetInvoiceToAttach = em.getReference(invoiceSetInvoiceToAttach.getClass(), invoiceSetInvoiceToAttach.getInvoiceId());
                attachedInvoiceSet.add(invoiceSetInvoiceToAttach);
            }
            customer.setInvoiceSet(attachedInvoiceSet);
            em.persist(customer);
            if (personAddressLinkId != null) {
                Customer oldCustomerOfPersonAddressLinkId = personAddressLinkId.getCustomer();
                if (oldCustomerOfPersonAddressLinkId != null) {
                    oldCustomerOfPersonAddressLinkId.setPersonAddressLinkId(null);
                    oldCustomerOfPersonAddressLinkId = em.merge(oldCustomerOfPersonAddressLinkId);
                }
                personAddressLinkId.setCustomer(customer);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            for (Voucher voucherSetVoucher : customer.getVoucherSet()) {
                Customer oldCustomerIdOfVoucherSetVoucher = voucherSetVoucher.getCustomerId();
                voucherSetVoucher.setCustomerId(customer);
                voucherSetVoucher = em.merge(voucherSetVoucher);
                if (oldCustomerIdOfVoucherSetVoucher != null) {
                    oldCustomerIdOfVoucherSetVoucher.getVoucherSet().remove(voucherSetVoucher);
                    oldCustomerIdOfVoucherSetVoucher = em.merge(oldCustomerIdOfVoucherSetVoucher);
                }
            }
            for (Wishlist wishlistSetWishlist : customer.getWishlistSet()) {
                Customer oldCustomerIdOfWishlistSetWishlist = wishlistSetWishlist.getCustomerId();
                wishlistSetWishlist.setCustomerId(customer);
                wishlistSetWishlist = em.merge(wishlistSetWishlist);
                if (oldCustomerIdOfWishlistSetWishlist != null) {
                    oldCustomerIdOfWishlistSetWishlist.getWishlistSet().remove(wishlistSetWishlist);
                    oldCustomerIdOfWishlistSetWishlist = em.merge(oldCustomerIdOfWishlistSetWishlist);
                }
            }
            for (ShoppingCartItem shoppingCartItemSetShoppingCartItem : customer.getShoppingCartItemSet()) {
                Customer oldCustomerIdOfShoppingCartItemSetShoppingCartItem = shoppingCartItemSetShoppingCartItem.getCustomerId();
                shoppingCartItemSetShoppingCartItem.setCustomerId(customer);
                shoppingCartItemSetShoppingCartItem = em.merge(shoppingCartItemSetShoppingCartItem);
                if (oldCustomerIdOfShoppingCartItemSetShoppingCartItem != null) {
                    oldCustomerIdOfShoppingCartItemSetShoppingCartItem.getShoppingCartItemSet().remove(shoppingCartItemSetShoppingCartItem);
                    oldCustomerIdOfShoppingCartItemSetShoppingCartItem = em.merge(oldCustomerIdOfShoppingCartItemSetShoppingCartItem);
                }
            }
            for (Invoice invoiceSetInvoice : customer.getInvoiceSet()) {
                Customer oldCustomerIdOfInvoiceSetInvoice = invoiceSetInvoice.getCustomerId();
                invoiceSetInvoice.setCustomerId(customer);
                invoiceSetInvoice = em.merge(invoiceSetInvoice);
                if (oldCustomerIdOfInvoiceSetInvoice != null) {
                    oldCustomerIdOfInvoiceSetInvoice.getInvoiceSet().remove(invoiceSetInvoice);
                    oldCustomerIdOfInvoiceSetInvoice = em.merge(oldCustomerIdOfInvoiceSetInvoice);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCustomer(customer.getCustomerId()) != null) {
                throw new PreexistingEntityException("Customer " + customer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Customer customer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer persistentCustomer = em.find(Customer.class, customer.getCustomerId());
            PersonAddressLink personAddressLinkIdOld = persistentCustomer.getPersonAddressLinkId();
            PersonAddressLink personAddressLinkIdNew = customer.getPersonAddressLinkId();
            Set<Voucher> voucherSetOld = persistentCustomer.getVoucherSet();
            Set<Voucher> voucherSetNew = customer.getVoucherSet();
            Set<Wishlist> wishlistSetOld = persistentCustomer.getWishlistSet();
            Set<Wishlist> wishlistSetNew = customer.getWishlistSet();
            Set<ShoppingCartItem> shoppingCartItemSetOld = persistentCustomer.getShoppingCartItemSet();
            Set<ShoppingCartItem> shoppingCartItemSetNew = customer.getShoppingCartItemSet();
            Set<Invoice> invoiceSetOld = persistentCustomer.getInvoiceSet();
            Set<Invoice> invoiceSetNew = customer.getInvoiceSet();
            if (personAddressLinkIdNew != null) {
                personAddressLinkIdNew = em.getReference(personAddressLinkIdNew.getClass(), personAddressLinkIdNew.getLinkId());
                customer.setPersonAddressLinkId(personAddressLinkIdNew);
            }
            Set<Voucher> attachedVoucherSetNew = new HashSet<Voucher>();
            for (Voucher voucherSetNewVoucherToAttach : voucherSetNew) {
                voucherSetNewVoucherToAttach = em.getReference(voucherSetNewVoucherToAttach.getClass(), voucherSetNewVoucherToAttach.getVoucherId());
                attachedVoucherSetNew.add(voucherSetNewVoucherToAttach);
            }
            voucherSetNew = attachedVoucherSetNew;
            customer.setVoucherSet(voucherSetNew);
            Set<Wishlist> attachedWishlistSetNew = new HashSet<Wishlist>();
            for (Wishlist wishlistSetNewWishlistToAttach : wishlistSetNew) {
                wishlistSetNewWishlistToAttach = em.getReference(wishlistSetNewWishlistToAttach.getClass(), wishlistSetNewWishlistToAttach.getWishlistId());
                attachedWishlistSetNew.add(wishlistSetNewWishlistToAttach);
            }
            wishlistSetNew = attachedWishlistSetNew;
            customer.setWishlistSet(wishlistSetNew);
            Set<ShoppingCartItem> attachedShoppingCartItemSetNew = new HashSet<ShoppingCartItem>();
            for (ShoppingCartItem shoppingCartItemSetNewShoppingCartItemToAttach : shoppingCartItemSetNew) {
                shoppingCartItemSetNewShoppingCartItemToAttach = em.getReference(shoppingCartItemSetNewShoppingCartItemToAttach.getClass(), shoppingCartItemSetNewShoppingCartItemToAttach.getShoppingCartItemId());
                attachedShoppingCartItemSetNew.add(shoppingCartItemSetNewShoppingCartItemToAttach);
            }
            shoppingCartItemSetNew = attachedShoppingCartItemSetNew;
            customer.setShoppingCartItemSet(shoppingCartItemSetNew);
            Set<Invoice> attachedInvoiceSetNew = new HashSet<Invoice>();
            for (Invoice invoiceSetNewInvoiceToAttach : invoiceSetNew) {
                invoiceSetNewInvoiceToAttach = em.getReference(invoiceSetNewInvoiceToAttach.getClass(), invoiceSetNewInvoiceToAttach.getInvoiceId());
                attachedInvoiceSetNew.add(invoiceSetNewInvoiceToAttach);
            }
            invoiceSetNew = attachedInvoiceSetNew;
            customer.setInvoiceSet(invoiceSetNew);
            customer = em.merge(customer);
            if (personAddressLinkIdOld != null && !personAddressLinkIdOld.equals(personAddressLinkIdNew)) {
                personAddressLinkIdOld.setCustomer(null);
                personAddressLinkIdOld = em.merge(personAddressLinkIdOld);
            }
            if (personAddressLinkIdNew != null && !personAddressLinkIdNew.equals(personAddressLinkIdOld)) {
                Customer oldCustomerOfPersonAddressLinkId = personAddressLinkIdNew.getCustomer();
                if (oldCustomerOfPersonAddressLinkId != null) {
                    oldCustomerOfPersonAddressLinkId.setPersonAddressLinkId(null);
                    oldCustomerOfPersonAddressLinkId = em.merge(oldCustomerOfPersonAddressLinkId);
                }
                personAddressLinkIdNew.setCustomer(customer);
                personAddressLinkIdNew = em.merge(personAddressLinkIdNew);
            }
            for (Voucher voucherSetOldVoucher : voucherSetOld) {
                if (!voucherSetNew.contains(voucherSetOldVoucher)) {
                    voucherSetOldVoucher.setCustomerId(null);
                    voucherSetOldVoucher = em.merge(voucherSetOldVoucher);
                }
            }
            for (Voucher voucherSetNewVoucher : voucherSetNew) {
                if (!voucherSetOld.contains(voucherSetNewVoucher)) {
                    Customer oldCustomerIdOfVoucherSetNewVoucher = voucherSetNewVoucher.getCustomerId();
                    voucherSetNewVoucher.setCustomerId(customer);
                    voucherSetNewVoucher = em.merge(voucherSetNewVoucher);
                    if (oldCustomerIdOfVoucherSetNewVoucher != null && !oldCustomerIdOfVoucherSetNewVoucher.equals(customer)) {
                        oldCustomerIdOfVoucherSetNewVoucher.getVoucherSet().remove(voucherSetNewVoucher);
                        oldCustomerIdOfVoucherSetNewVoucher = em.merge(oldCustomerIdOfVoucherSetNewVoucher);
                    }
                }
            }
            for (Wishlist wishlistSetOldWishlist : wishlistSetOld) {
                if (!wishlistSetNew.contains(wishlistSetOldWishlist)) {
                    wishlistSetOldWishlist.setCustomerId(null);
                    wishlistSetOldWishlist = em.merge(wishlistSetOldWishlist);
                }
            }
            for (Wishlist wishlistSetNewWishlist : wishlistSetNew) {
                if (!wishlistSetOld.contains(wishlistSetNewWishlist)) {
                    Customer oldCustomerIdOfWishlistSetNewWishlist = wishlistSetNewWishlist.getCustomerId();
                    wishlistSetNewWishlist.setCustomerId(customer);
                    wishlistSetNewWishlist = em.merge(wishlistSetNewWishlist);
                    if (oldCustomerIdOfWishlistSetNewWishlist != null && !oldCustomerIdOfWishlistSetNewWishlist.equals(customer)) {
                        oldCustomerIdOfWishlistSetNewWishlist.getWishlistSet().remove(wishlistSetNewWishlist);
                        oldCustomerIdOfWishlistSetNewWishlist = em.merge(oldCustomerIdOfWishlistSetNewWishlist);
                    }
                }
            }
            for (ShoppingCartItem shoppingCartItemSetOldShoppingCartItem : shoppingCartItemSetOld) {
                if (!shoppingCartItemSetNew.contains(shoppingCartItemSetOldShoppingCartItem)) {
                    shoppingCartItemSetOldShoppingCartItem.setCustomerId(null);
                    shoppingCartItemSetOldShoppingCartItem = em.merge(shoppingCartItemSetOldShoppingCartItem);
                }
            }
            for (ShoppingCartItem shoppingCartItemSetNewShoppingCartItem : shoppingCartItemSetNew) {
                if (!shoppingCartItemSetOld.contains(shoppingCartItemSetNewShoppingCartItem)) {
                    Customer oldCustomerIdOfShoppingCartItemSetNewShoppingCartItem = shoppingCartItemSetNewShoppingCartItem.getCustomerId();
                    shoppingCartItemSetNewShoppingCartItem.setCustomerId(customer);
                    shoppingCartItemSetNewShoppingCartItem = em.merge(shoppingCartItemSetNewShoppingCartItem);
                    if (oldCustomerIdOfShoppingCartItemSetNewShoppingCartItem != null && !oldCustomerIdOfShoppingCartItemSetNewShoppingCartItem.equals(customer)) {
                        oldCustomerIdOfShoppingCartItemSetNewShoppingCartItem.getShoppingCartItemSet().remove(shoppingCartItemSetNewShoppingCartItem);
                        oldCustomerIdOfShoppingCartItemSetNewShoppingCartItem = em.merge(oldCustomerIdOfShoppingCartItemSetNewShoppingCartItem);
                    }
                }
            }
            for (Invoice invoiceSetOldInvoice : invoiceSetOld) {
                if (!invoiceSetNew.contains(invoiceSetOldInvoice)) {
                    invoiceSetOldInvoice.setCustomerId(null);
                    invoiceSetOldInvoice = em.merge(invoiceSetOldInvoice);
                }
            }
            for (Invoice invoiceSetNewInvoice : invoiceSetNew) {
                if (!invoiceSetOld.contains(invoiceSetNewInvoice)) {
                    Customer oldCustomerIdOfInvoiceSetNewInvoice = invoiceSetNewInvoice.getCustomerId();
                    invoiceSetNewInvoice.setCustomerId(customer);
                    invoiceSetNewInvoice = em.merge(invoiceSetNewInvoice);
                    if (oldCustomerIdOfInvoiceSetNewInvoice != null && !oldCustomerIdOfInvoiceSetNewInvoice.equals(customer)) {
                        oldCustomerIdOfInvoiceSetNewInvoice.getInvoiceSet().remove(invoiceSetNewInvoice);
                        oldCustomerIdOfInvoiceSetNewInvoice = em.merge(oldCustomerIdOfInvoiceSetNewInvoice);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = customer.getCustomerId();
                if (findCustomer(id) == null) {
                    throw new NonexistentEntityException("The customer with id " + id + " no longer exists.");
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
            Customer customer;
            try {
                customer = em.getReference(Customer.class, id);
                customer.getCustomerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + id + " no longer exists.", enfe);
            }
            PersonAddressLink personAddressLinkId = customer.getPersonAddressLinkId();
            if (personAddressLinkId != null) {
                personAddressLinkId.setCustomer(null);
                personAddressLinkId = em.merge(personAddressLinkId);
            }
            Set<Voucher> voucherSet = customer.getVoucherSet();
            for (Voucher voucherSetVoucher : voucherSet) {
                voucherSetVoucher.setCustomerId(null);
                voucherSetVoucher = em.merge(voucherSetVoucher);
            }
            Set<Wishlist> wishlistSet = customer.getWishlistSet();
            for (Wishlist wishlistSetWishlist : wishlistSet) {
                wishlistSetWishlist.setCustomerId(null);
                wishlistSetWishlist = em.merge(wishlistSetWishlist);
            }
            Set<ShoppingCartItem> shoppingCartItemSet = customer.getShoppingCartItemSet();
            for (ShoppingCartItem shoppingCartItemSetShoppingCartItem : shoppingCartItemSet) {
                shoppingCartItemSetShoppingCartItem.setCustomerId(null);
                shoppingCartItemSetShoppingCartItem = em.merge(shoppingCartItemSetShoppingCartItem);
            }
            Set<Invoice> invoiceSet = customer.getInvoiceSet();
            for (Invoice invoiceSetInvoice : invoiceSet) {
                invoiceSetInvoice.setCustomerId(null);
                invoiceSetInvoice = em.merge(invoiceSetInvoice);
            }
            em.remove(customer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Customer> findCustomerEntities() {
        return findCustomerEntities(true, -1, -1);
    }

    public List<Customer> findCustomerEntities(int maxResults, int firstResult) {
        return findCustomerEntities(false, maxResults, firstResult);
    }

    private List<Customer> findCustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer.class));
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

    public Customer findCustomer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer> rt = cq.from(Customer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
