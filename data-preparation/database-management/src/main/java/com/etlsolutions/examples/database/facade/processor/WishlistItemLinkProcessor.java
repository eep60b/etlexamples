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
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.data.constant.KeyNames;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.WishlistItemLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableWishlistItemLink;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.WishlistItemLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.WishlistPojo;
import java.util.Set;

/**
 * The WishlistItemLinkProcessor class process database-related operations such
 * as save, retrieve etc. for the WISHLIST_ITEM_LINK table.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class WishlistItemLinkProcessor extends AbstractProcessor<WishlistItemLink> {

    private final WishlistProcessor wishlistProcessor;
    private final ItemCommonDetailProcessor itemCommonDetailProcessor;

    /**
     * Construct an AuthorBookLinkProcessor object with the given BookshopFacade
     * object.
     *
     * @param facade
     */
    public WishlistItemLinkProcessor(BookshopFacade facade) {
        super(facade);
        wishlistProcessor = new WishlistProcessor(facade);
        itemCommonDetailProcessor = new ItemCommonDetailProcessor(facade);
    }

    /**
     * Save the parameters in the given AuthorBookLink object to an entry into
     * the author_book_link table in the database.
     *
     * @param link - The given AuthorBookLink object.
     * @return an identifiable object which represents the saved entry. This
     * method will NOT return null. If the parameters cannot be saved, an
     * exception will be thrown.
     * @throws NullPointerException if the given object is null or its wishlist
     * or itemCommonDetail property is null.
     * @throws IllegalStateException if an error occurs.
     */
    @Override
    public IdentifiableWishlistItemLink save(WishlistItemLink link) {

        IdentifiableWishlistItemLink linkPojo = retrieve(link);

        if (linkPojo == null) {

            WishlistPojo wishlist = wishlistProcessor.save(link.getWishlist());
            ItemCommonDetailPojo itemCommonDetail = itemCommonDetailProcessor.save(link.getItemCommonDetail());

            Set<ItemCommonDetail> itemCommonDetails = wishlist.getItemCommonDetails();
            itemCommonDetails.add(itemCommonDetail);
            wishlist.setItemCommonDetails(itemCommonDetails);
            
            Set<WishlistPojo> wishlistPojos = itemCommonDetail.getWishlists();
            wishlistPojos.add(wishlist);
            itemCommonDetail.setWishlists(wishlistPojos);
            
            facade.update(wishlist, itemCommonDetail);

            linkPojo = new WishlistItemLinkPojo(wishlist, itemCommonDetail);
        }

        return linkPojo;
    }

    /**
     * Retrieve an entry from the author_book_link table in the database used
     * the parameter in the given AuthorBookLink object.
     *
     * @param link - The given AuthorBookLink object.
     * @return an AuthorBookLinkPojo object or null if there is no such an
     * entry.
     *
     * @throws NullPointerException if the given object is null or its wishlist
     * or itemCommonDetail property is null.
     */
    @Override
    public IdentifiableWishlistItemLink retrieve(WishlistItemLink link) {

        WishlistPojo wishlistPojo = wishlistProcessor.retrieve(link.getWishlist());
        ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.retrieve(link.getItemCommonDetail());

        if (wishlistPojo == null || itemCommonDetailPojo == null) {
            return null;
        }

        if (facade.retrieveList(QueryNames.SELECT_FROM_WISHLIST_ITEM_LINK,
                new StringKeyValuePair(KeyNames.WISHLIST_ITEM_LINK_WISHLIST_ID, wishlistPojo.getId()),
                new StringKeyValuePair(KeyNames.WISHLIST_ITEM_LINK_COMMON_DETAIL_ID, itemCommonDetailPojo.getId())).isEmpty()) {
            return null;
        }

        return new WishlistItemLinkPojo(wishlistPojo, itemCommonDetailPojo);
    }
}
