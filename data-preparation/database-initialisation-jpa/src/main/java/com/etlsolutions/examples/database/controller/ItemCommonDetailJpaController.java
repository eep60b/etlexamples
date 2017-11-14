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
import com.etlsolutions.examples.database.entity.Book;
import com.etlsolutions.examples.database.entity.Category;
import com.etlsolutions.examples.database.entity.ItemCommonDetail;
import java.util.HashSet;
import java.util.Set;
import com.etlsolutions.examples.database.entity.Wishlist;
import com.etlsolutions.examples.database.entity.SoldItem;
import com.etlsolutions.examples.database.entity.Review;
import com.etlsolutions.examples.database.entity.ShoppingCartItem;
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
public class ItemCommonDetailJpaController implements Serializable {

    public ItemCommonDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemCommonDetail itemCommonDetail) throws PreexistingEntityException, Exception {
        if (itemCommonDetail.getCategorySet() == null) {
            itemCommonDetail.setCategorySet(new HashSet<Category>());
        }
        if (itemCommonDetail.getWishlistSet() == null) {
            itemCommonDetail.setWishlistSet(new HashSet<Wishlist>());
        }
        if (itemCommonDetail.getSoldItemSet() == null) {
            itemCommonDetail.setSoldItemSet(new HashSet<SoldItem>());
        }
        if (itemCommonDetail.getReviewSet() == null) {
            itemCommonDetail.setReviewSet(new HashSet<Review>());
        }
        if (itemCommonDetail.getShoppingCartItemSet() == null) {
            itemCommonDetail.setShoppingCartItemSet(new HashSet<ShoppingCartItem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Book book = itemCommonDetail.getBook();
            if (book != null) {
                book = em.getReference(book.getClass(), book.getBookId());
                itemCommonDetail.setBook(book);
            }
            Set<Category> attachedCategorySet = new HashSet<Category>();
            for (Category categorySetCategoryToAttach : itemCommonDetail.getCategorySet()) {
                categorySetCategoryToAttach = em.getReference(categorySetCategoryToAttach.getClass(), categorySetCategoryToAttach.getCategoryId());
                attachedCategorySet.add(categorySetCategoryToAttach);
            }
            itemCommonDetail.setCategorySet(attachedCategorySet);
            Set<Wishlist> attachedWishlistSet = new HashSet<Wishlist>();
            for (Wishlist wishlistSetWishlistToAttach : itemCommonDetail.getWishlistSet()) {
                wishlistSetWishlistToAttach = em.getReference(wishlistSetWishlistToAttach.getClass(), wishlistSetWishlistToAttach.getWishlistId());
                attachedWishlistSet.add(wishlistSetWishlistToAttach);
            }
            itemCommonDetail.setWishlistSet(attachedWishlistSet);
            Set<SoldItem> attachedSoldItemSet = new HashSet<SoldItem>();
            for (SoldItem soldItemSetSoldItemToAttach : itemCommonDetail.getSoldItemSet()) {
                soldItemSetSoldItemToAttach = em.getReference(soldItemSetSoldItemToAttach.getClass(), soldItemSetSoldItemToAttach.getSoldItemId());
                attachedSoldItemSet.add(soldItemSetSoldItemToAttach);
            }
            itemCommonDetail.setSoldItemSet(attachedSoldItemSet);
            Set<Review> attachedReviewSet = new HashSet<Review>();
            for (Review reviewSetReviewToAttach : itemCommonDetail.getReviewSet()) {
                reviewSetReviewToAttach = em.getReference(reviewSetReviewToAttach.getClass(), reviewSetReviewToAttach.getReviewId());
                attachedReviewSet.add(reviewSetReviewToAttach);
            }
            itemCommonDetail.setReviewSet(attachedReviewSet);
            Set<ShoppingCartItem> attachedShoppingCartItemSet = new HashSet<ShoppingCartItem>();
            for (ShoppingCartItem shoppingCartItemSetShoppingCartItemToAttach : itemCommonDetail.getShoppingCartItemSet()) {
                shoppingCartItemSetShoppingCartItemToAttach = em.getReference(shoppingCartItemSetShoppingCartItemToAttach.getClass(), shoppingCartItemSetShoppingCartItemToAttach.getShoppingCartItemId());
                attachedShoppingCartItemSet.add(shoppingCartItemSetShoppingCartItemToAttach);
            }
            itemCommonDetail.setShoppingCartItemSet(attachedShoppingCartItemSet);
            em.persist(itemCommonDetail);
            if (book != null) {
                ItemCommonDetail oldItemCommonDetailIdOfBook = book.getItemCommonDetailId();
                if (oldItemCommonDetailIdOfBook != null) {
                    oldItemCommonDetailIdOfBook.setBook(null);
                    oldItemCommonDetailIdOfBook = em.merge(oldItemCommonDetailIdOfBook);
                }
                book.setItemCommonDetailId(itemCommonDetail);
                book = em.merge(book);
            }
            for (Category categorySetCategory : itemCommonDetail.getCategorySet()) {
                categorySetCategory.getItemCommonDetailSet().add(itemCommonDetail);
                categorySetCategory = em.merge(categorySetCategory);
            }
            for (Wishlist wishlistSetWishlist : itemCommonDetail.getWishlistSet()) {
                wishlistSetWishlist.getItemCommonDetailSet().add(itemCommonDetail);
                wishlistSetWishlist = em.merge(wishlistSetWishlist);
            }
            for (SoldItem soldItemSetSoldItem : itemCommonDetail.getSoldItemSet()) {
                ItemCommonDetail oldItemCommonDetailIdOfSoldItemSetSoldItem = soldItemSetSoldItem.getItemCommonDetailId();
                soldItemSetSoldItem.setItemCommonDetailId(itemCommonDetail);
                soldItemSetSoldItem = em.merge(soldItemSetSoldItem);
                if (oldItemCommonDetailIdOfSoldItemSetSoldItem != null) {
                    oldItemCommonDetailIdOfSoldItemSetSoldItem.getSoldItemSet().remove(soldItemSetSoldItem);
                    oldItemCommonDetailIdOfSoldItemSetSoldItem = em.merge(oldItemCommonDetailIdOfSoldItemSetSoldItem);
                }
            }
            for (Review reviewSetReview : itemCommonDetail.getReviewSet()) {
                ItemCommonDetail oldItemCommonDetailIdOfReviewSetReview = reviewSetReview.getItemCommonDetailId();
                reviewSetReview.setItemCommonDetailId(itemCommonDetail);
                reviewSetReview = em.merge(reviewSetReview);
                if (oldItemCommonDetailIdOfReviewSetReview != null) {
                    oldItemCommonDetailIdOfReviewSetReview.getReviewSet().remove(reviewSetReview);
                    oldItemCommonDetailIdOfReviewSetReview = em.merge(oldItemCommonDetailIdOfReviewSetReview);
                }
            }
            for (ShoppingCartItem shoppingCartItemSetShoppingCartItem : itemCommonDetail.getShoppingCartItemSet()) {
                ItemCommonDetail oldItemCommonDetailIdOfShoppingCartItemSetShoppingCartItem = shoppingCartItemSetShoppingCartItem.getItemCommonDetailId();
                shoppingCartItemSetShoppingCartItem.setItemCommonDetailId(itemCommonDetail);
                shoppingCartItemSetShoppingCartItem = em.merge(shoppingCartItemSetShoppingCartItem);
                if (oldItemCommonDetailIdOfShoppingCartItemSetShoppingCartItem != null) {
                    oldItemCommonDetailIdOfShoppingCartItemSetShoppingCartItem.getShoppingCartItemSet().remove(shoppingCartItemSetShoppingCartItem);
                    oldItemCommonDetailIdOfShoppingCartItemSetShoppingCartItem = em.merge(oldItemCommonDetailIdOfShoppingCartItemSetShoppingCartItem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemCommonDetail(itemCommonDetail.getItemCommonDetailId()) != null) {
                throw new PreexistingEntityException("ItemCommonDetail " + itemCommonDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemCommonDetail itemCommonDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemCommonDetail persistentItemCommonDetail = em.find(ItemCommonDetail.class, itemCommonDetail.getItemCommonDetailId());
            Book bookOld = persistentItemCommonDetail.getBook();
            Book bookNew = itemCommonDetail.getBook();
            Set<Category> categorySetOld = persistentItemCommonDetail.getCategorySet();
            Set<Category> categorySetNew = itemCommonDetail.getCategorySet();
            Set<Wishlist> wishlistSetOld = persistentItemCommonDetail.getWishlistSet();
            Set<Wishlist> wishlistSetNew = itemCommonDetail.getWishlistSet();
            Set<SoldItem> soldItemSetOld = persistentItemCommonDetail.getSoldItemSet();
            Set<SoldItem> soldItemSetNew = itemCommonDetail.getSoldItemSet();
            Set<Review> reviewSetOld = persistentItemCommonDetail.getReviewSet();
            Set<Review> reviewSetNew = itemCommonDetail.getReviewSet();
            Set<ShoppingCartItem> shoppingCartItemSetOld = persistentItemCommonDetail.getShoppingCartItemSet();
            Set<ShoppingCartItem> shoppingCartItemSetNew = itemCommonDetail.getShoppingCartItemSet();
            if (bookNew != null) {
                bookNew = em.getReference(bookNew.getClass(), bookNew.getBookId());
                itemCommonDetail.setBook(bookNew);
            }
            Set<Category> attachedCategorySetNew = new HashSet<Category>();
            for (Category categorySetNewCategoryToAttach : categorySetNew) {
                categorySetNewCategoryToAttach = em.getReference(categorySetNewCategoryToAttach.getClass(), categorySetNewCategoryToAttach.getCategoryId());
                attachedCategorySetNew.add(categorySetNewCategoryToAttach);
            }
            categorySetNew = attachedCategorySetNew;
            itemCommonDetail.setCategorySet(categorySetNew);
            Set<Wishlist> attachedWishlistSetNew = new HashSet<Wishlist>();
            for (Wishlist wishlistSetNewWishlistToAttach : wishlistSetNew) {
                wishlistSetNewWishlistToAttach = em.getReference(wishlistSetNewWishlistToAttach.getClass(), wishlistSetNewWishlistToAttach.getWishlistId());
                attachedWishlistSetNew.add(wishlistSetNewWishlistToAttach);
            }
            wishlistSetNew = attachedWishlistSetNew;
            itemCommonDetail.setWishlistSet(wishlistSetNew);
            Set<SoldItem> attachedSoldItemSetNew = new HashSet<SoldItem>();
            for (SoldItem soldItemSetNewSoldItemToAttach : soldItemSetNew) {
                soldItemSetNewSoldItemToAttach = em.getReference(soldItemSetNewSoldItemToAttach.getClass(), soldItemSetNewSoldItemToAttach.getSoldItemId());
                attachedSoldItemSetNew.add(soldItemSetNewSoldItemToAttach);
            }
            soldItemSetNew = attachedSoldItemSetNew;
            itemCommonDetail.setSoldItemSet(soldItemSetNew);
            Set<Review> attachedReviewSetNew = new HashSet<Review>();
            for (Review reviewSetNewReviewToAttach : reviewSetNew) {
                reviewSetNewReviewToAttach = em.getReference(reviewSetNewReviewToAttach.getClass(), reviewSetNewReviewToAttach.getReviewId());
                attachedReviewSetNew.add(reviewSetNewReviewToAttach);
            }
            reviewSetNew = attachedReviewSetNew;
            itemCommonDetail.setReviewSet(reviewSetNew);
            Set<ShoppingCartItem> attachedShoppingCartItemSetNew = new HashSet<ShoppingCartItem>();
            for (ShoppingCartItem shoppingCartItemSetNewShoppingCartItemToAttach : shoppingCartItemSetNew) {
                shoppingCartItemSetNewShoppingCartItemToAttach = em.getReference(shoppingCartItemSetNewShoppingCartItemToAttach.getClass(), shoppingCartItemSetNewShoppingCartItemToAttach.getShoppingCartItemId());
                attachedShoppingCartItemSetNew.add(shoppingCartItemSetNewShoppingCartItemToAttach);
            }
            shoppingCartItemSetNew = attachedShoppingCartItemSetNew;
            itemCommonDetail.setShoppingCartItemSet(shoppingCartItemSetNew);
            itemCommonDetail = em.merge(itemCommonDetail);
            if (bookOld != null && !bookOld.equals(bookNew)) {
                bookOld.setItemCommonDetailId(null);
                bookOld = em.merge(bookOld);
            }
            if (bookNew != null && !bookNew.equals(bookOld)) {
                ItemCommonDetail oldItemCommonDetailIdOfBook = bookNew.getItemCommonDetailId();
                if (oldItemCommonDetailIdOfBook != null) {
                    oldItemCommonDetailIdOfBook.setBook(null);
                    oldItemCommonDetailIdOfBook = em.merge(oldItemCommonDetailIdOfBook);
                }
                bookNew.setItemCommonDetailId(itemCommonDetail);
                bookNew = em.merge(bookNew);
            }
            for (Category categorySetOldCategory : categorySetOld) {
                if (!categorySetNew.contains(categorySetOldCategory)) {
                    categorySetOldCategory.getItemCommonDetailSet().remove(itemCommonDetail);
                    categorySetOldCategory = em.merge(categorySetOldCategory);
                }
            }
            for (Category categorySetNewCategory : categorySetNew) {
                if (!categorySetOld.contains(categorySetNewCategory)) {
                    categorySetNewCategory.getItemCommonDetailSet().add(itemCommonDetail);
                    categorySetNewCategory = em.merge(categorySetNewCategory);
                }
            }
            for (Wishlist wishlistSetOldWishlist : wishlistSetOld) {
                if (!wishlistSetNew.contains(wishlistSetOldWishlist)) {
                    wishlistSetOldWishlist.getItemCommonDetailSet().remove(itemCommonDetail);
                    wishlistSetOldWishlist = em.merge(wishlistSetOldWishlist);
                }
            }
            for (Wishlist wishlistSetNewWishlist : wishlistSetNew) {
                if (!wishlistSetOld.contains(wishlistSetNewWishlist)) {
                    wishlistSetNewWishlist.getItemCommonDetailSet().add(itemCommonDetail);
                    wishlistSetNewWishlist = em.merge(wishlistSetNewWishlist);
                }
            }
            for (SoldItem soldItemSetOldSoldItem : soldItemSetOld) {
                if (!soldItemSetNew.contains(soldItemSetOldSoldItem)) {
                    soldItemSetOldSoldItem.setItemCommonDetailId(null);
                    soldItemSetOldSoldItem = em.merge(soldItemSetOldSoldItem);
                }
            }
            for (SoldItem soldItemSetNewSoldItem : soldItemSetNew) {
                if (!soldItemSetOld.contains(soldItemSetNewSoldItem)) {
                    ItemCommonDetail oldItemCommonDetailIdOfSoldItemSetNewSoldItem = soldItemSetNewSoldItem.getItemCommonDetailId();
                    soldItemSetNewSoldItem.setItemCommonDetailId(itemCommonDetail);
                    soldItemSetNewSoldItem = em.merge(soldItemSetNewSoldItem);
                    if (oldItemCommonDetailIdOfSoldItemSetNewSoldItem != null && !oldItemCommonDetailIdOfSoldItemSetNewSoldItem.equals(itemCommonDetail)) {
                        oldItemCommonDetailIdOfSoldItemSetNewSoldItem.getSoldItemSet().remove(soldItemSetNewSoldItem);
                        oldItemCommonDetailIdOfSoldItemSetNewSoldItem = em.merge(oldItemCommonDetailIdOfSoldItemSetNewSoldItem);
                    }
                }
            }
            for (Review reviewSetOldReview : reviewSetOld) {
                if (!reviewSetNew.contains(reviewSetOldReview)) {
                    reviewSetOldReview.setItemCommonDetailId(null);
                    reviewSetOldReview = em.merge(reviewSetOldReview);
                }
            }
            for (Review reviewSetNewReview : reviewSetNew) {
                if (!reviewSetOld.contains(reviewSetNewReview)) {
                    ItemCommonDetail oldItemCommonDetailIdOfReviewSetNewReview = reviewSetNewReview.getItemCommonDetailId();
                    reviewSetNewReview.setItemCommonDetailId(itemCommonDetail);
                    reviewSetNewReview = em.merge(reviewSetNewReview);
                    if (oldItemCommonDetailIdOfReviewSetNewReview != null && !oldItemCommonDetailIdOfReviewSetNewReview.equals(itemCommonDetail)) {
                        oldItemCommonDetailIdOfReviewSetNewReview.getReviewSet().remove(reviewSetNewReview);
                        oldItemCommonDetailIdOfReviewSetNewReview = em.merge(oldItemCommonDetailIdOfReviewSetNewReview);
                    }
                }
            }
            for (ShoppingCartItem shoppingCartItemSetOldShoppingCartItem : shoppingCartItemSetOld) {
                if (!shoppingCartItemSetNew.contains(shoppingCartItemSetOldShoppingCartItem)) {
                    shoppingCartItemSetOldShoppingCartItem.setItemCommonDetailId(null);
                    shoppingCartItemSetOldShoppingCartItem = em.merge(shoppingCartItemSetOldShoppingCartItem);
                }
            }
            for (ShoppingCartItem shoppingCartItemSetNewShoppingCartItem : shoppingCartItemSetNew) {
                if (!shoppingCartItemSetOld.contains(shoppingCartItemSetNewShoppingCartItem)) {
                    ItemCommonDetail oldItemCommonDetailIdOfShoppingCartItemSetNewShoppingCartItem = shoppingCartItemSetNewShoppingCartItem.getItemCommonDetailId();
                    shoppingCartItemSetNewShoppingCartItem.setItemCommonDetailId(itemCommonDetail);
                    shoppingCartItemSetNewShoppingCartItem = em.merge(shoppingCartItemSetNewShoppingCartItem);
                    if (oldItemCommonDetailIdOfShoppingCartItemSetNewShoppingCartItem != null && !oldItemCommonDetailIdOfShoppingCartItemSetNewShoppingCartItem.equals(itemCommonDetail)) {
                        oldItemCommonDetailIdOfShoppingCartItemSetNewShoppingCartItem.getShoppingCartItemSet().remove(shoppingCartItemSetNewShoppingCartItem);
                        oldItemCommonDetailIdOfShoppingCartItemSetNewShoppingCartItem = em.merge(oldItemCommonDetailIdOfShoppingCartItemSetNewShoppingCartItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itemCommonDetail.getItemCommonDetailId();
                if (findItemCommonDetail(id) == null) {
                    throw new NonexistentEntityException("The itemCommonDetail with id " + id + " no longer exists.");
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
            ItemCommonDetail itemCommonDetail;
            try {
                itemCommonDetail = em.getReference(ItemCommonDetail.class, id);
                itemCommonDetail.getItemCommonDetailId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemCommonDetail with id " + id + " no longer exists.", enfe);
            }
            Book book = itemCommonDetail.getBook();
            if (book != null) {
                book.setItemCommonDetailId(null);
                book = em.merge(book);
            }
            Set<Category> categorySet = itemCommonDetail.getCategorySet();
            for (Category categorySetCategory : categorySet) {
                categorySetCategory.getItemCommonDetailSet().remove(itemCommonDetail);
                categorySetCategory = em.merge(categorySetCategory);
            }
            Set<Wishlist> wishlistSet = itemCommonDetail.getWishlistSet();
            for (Wishlist wishlistSetWishlist : wishlistSet) {
                wishlistSetWishlist.getItemCommonDetailSet().remove(itemCommonDetail);
                wishlistSetWishlist = em.merge(wishlistSetWishlist);
            }
            Set<SoldItem> soldItemSet = itemCommonDetail.getSoldItemSet();
            for (SoldItem soldItemSetSoldItem : soldItemSet) {
                soldItemSetSoldItem.setItemCommonDetailId(null);
                soldItemSetSoldItem = em.merge(soldItemSetSoldItem);
            }
            Set<Review> reviewSet = itemCommonDetail.getReviewSet();
            for (Review reviewSetReview : reviewSet) {
                reviewSetReview.setItemCommonDetailId(null);
                reviewSetReview = em.merge(reviewSetReview);
            }
            Set<ShoppingCartItem> shoppingCartItemSet = itemCommonDetail.getShoppingCartItemSet();
            for (ShoppingCartItem shoppingCartItemSetShoppingCartItem : shoppingCartItemSet) {
                shoppingCartItemSetShoppingCartItem.setItemCommonDetailId(null);
                shoppingCartItemSetShoppingCartItem = em.merge(shoppingCartItemSetShoppingCartItem);
            }
            em.remove(itemCommonDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemCommonDetail> findItemCommonDetailEntities() {
        return findItemCommonDetailEntities(true, -1, -1);
    }

    public List<ItemCommonDetail> findItemCommonDetailEntities(int maxResults, int firstResult) {
        return findItemCommonDetailEntities(false, maxResults, firstResult);
    }

    private List<ItemCommonDetail> findItemCommonDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemCommonDetail.class));
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

    public ItemCommonDetail findItemCommonDetail(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemCommonDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemCommonDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemCommonDetail> rt = cq.from(ItemCommonDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
