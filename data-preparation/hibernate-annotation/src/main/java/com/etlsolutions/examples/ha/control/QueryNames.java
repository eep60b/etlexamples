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
package com.etlsolutions.examples.ha.control;

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;

/**
 * The QueryNames class is a utility class which contains all the query names
 * used inside this module.
 *
 *
 * @author Zhipeng Chang
 */
public final class QueryNames {

    private QueryNames() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    public static final String findAddresses = "findAddresses";
    public static final String findAdministrators = "findAdministrators";
    public static final String findAuthors = "findAAuthors";
    public static final String findAmexcardPayments = "findAmexcardPayments";
    public static final String findBooks = "findBooks";    
    public static final String findCategories = "findCategories";
    public static final String findCustomers = "findCustomers";
    public static final String findDebitcardPayments = "findDebitcardPayments";
    public static final String findEmails = "findEmails";
    public static final String findInvoices = "findInvoices";
    public static final String findItemDetails = "findItems";
    public static final String findSoldItemSolds = "findItemSoldPrices";
    public static final String findMastercardPayments = "findMastercardPayments";
    public static final String findPaymentIds = "findPaymentIds";
    public static final String findPaymentDetails = "findPayments";
    public static final String findPaypalPayments = "findPaypalPayments";
    public static final String findPersonAddressLinks = "findPersonAddressLinks";
    public static final String findPersons = "findPersons";
    public static final String findPublishers = "findPublishers";
    public static final String findReviews = "findReviews";
    public static final String findReviewers = "findReviewers";
    public static final String findShoppingCart = "findShoppingCarts";
    public static final String findTelephones = "findTelephones";
    public static final String findViewInvoices = "findViewInvoices";
    public static final String findVisacardPayments = "findVisacardPayments";
    public static final String findVoucherPayments = "findVoucherPayments";
    public static final String findVouchers = "findVouchers";
    public static final String findWishlists = "findWishlists";
    
    public static final String findAddressesNative = "findAddressesNative";
    public static final String findAdministratorsNative = "findAdministratorsNative";
    public static final String findAuthorsNative = "findAuthorsNative";
    public static final String findAmexcardPaymentsNative = "findAmexcardPaymentsNative";
    public static final String findBooksNative = "findBooksNative";    
    public static final String findCategoriesNative = "findCategoriesNative";
    public static final String findCustomersNative = "findCustomersNative";
    public static final String findDebitcardPaymentsNative = "findDebitcardPaymentsNative";
    public static final String findEmailsNative = "findEmailsNative";
    public static final String findInvoicesNative = "findInvoicesNative";
    public static final String findItemsNative = "findItemsNative";
    public static final String findSoldItemsNative = "findItemSoldPricesNative";
    public static final String findMastercardPaymentsNative = "findMastercardPaymentsNative";
    public static final String findPaymentIdsNative = "findPaymentIdsNative";
    public static final String findPaymentsNative = "findPaymentsNative";
    public static final String findPaypalPaymentsNative = "findPaypalPaymentsNative";
    public static final String findPersonAddressLinksNative = "findPersonAddressLinksNative";
    public static final String findPersonsNative = "findPersonNatives";
    public static final String findPublishersNative = "findPublishersNative";
    public static final String findReviewsNative = "findReviewsNative";
    public static final String findReviewersNative = "findReviewersNative";
    public static final String findShoppingCartsNative = "findShoppingCartsNative";
    public static final String findTelephonesNative = "findTelephonesNative";
    public static final String findViewInvoicesNative = "findViewInvoicesNative";
    public static final String findVisacardPaymentsNative = "findVisacardPaymentsNative";
    public static final String findVoucherPaymentsNative = "findVoucherPaymentsNative";
    public static final String findVouchersNative = "findVouchersNative";
    public static final String findWishlistsNative = "findWishlistsNative";    
    
}
