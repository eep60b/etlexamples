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
package com.etlsolutions.examples.data.constant;

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;

/**
 * The QueryNames class contains all the name string for queries.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class QueryNames {

    private QueryNames() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * The following string are used to delete data from database.
     */
    public static final String DELETE_FROM_VOUCHER = "DELETE_FROM_VOUCHER";
    public static final String DELETE_FROM_PAYPAL_PAYMENT = "DELETE_FROM_PAYPAL_PAYMENT";
    public static final String DELETE_FROM_MASTERCARD_PAYMENT = "DELETE_FROM_MASTERCARD_PAYMENT";
    public static final String DELETE_FROM_VISACARD_PAYMENT = "DELETE_FROM_VISACARD_PAYMENT";
    public static final String DELETE_FROM_AMEXCARD_PAYMENT = "DELETE_FROM_AMEXCARD_PAYMENT";
    public static final String DELETE_FROM_DEBITCARD_PAYMENT = "DELETE_FROM_DEBITCARD_PAYMENT";
    public static final String DELETE_FROM_PAYMENT_DETAIL = "DELETE_FROM_PAYMENT_DETAIL";
    public static final String DELETE_FROM_SHOPPING_CART_ITEM = "DELETE_FROM_SHOPPING_CART_ITEM";
    public static final String DELETE_FROM_WISHLIST = "DELETE_FROM_WISHLIST";
    public static final String DELETE_FROM_SOLD_ITEM = "DELETE_FROM_SOLD_ITEM";
    public static final String DELETE_FROM_AUTHOR = "DELETE_FROM_AUTHOR";
    public static final String DELETE_FROM_INVOICE = "DELETE_FROM_INVOICE";
    public static final String DELETE_FROM_CUSTOMER = "DELETE_FROM_CUSTOMER";
    public static final String DELETE_FROM_PERSON_ADDRESS_LINK = "DELETE_FROM_PERSON_ADDRESS_LINK";
    public static final String DELETE_FROM_REVIEW = "DELETE_FROM_REVIEW";
    public static final String DELETE_FROM_BOOK = "DELETE_FROM_BOOK";
    public static final String DELETE_FROM_ITEM_COMMMON_DETAIL = "DELETE_FROM_ITEM_COMMON_DETAIL";
    public static final String DELETE_FROM_REVIEWER = "DELETE_FROM_REVIEWER";
    public static final String DELETE_FROM_ADMINISTRATOR = "DELETE_FROM_ADMINISTRATOR";
    public static final String DELETE_FROM_EMAIL = "DELETE_FROM_EMAIL";
    public static final String DELETE_FROM_PERSONAL_DETAIL = "DELETE_FROM_PERSONAL_DETAIL";
    public static final String DELETE_FROM_TELEPHONE = "DELETE_FROM_TELEPHONE";
    public static final String DELETE_FROM_PUBLISHER = "DELETE_FROM_PUBLISHER";
    public static final String DELETE_FROM_CATEGORY = "DELETE_FROM_CATEGORY";
    public static final String DELETE_FROM_ADDRESS = "DELETE_FROM_ADDRESS";

    public static final String[] DELETE_QUERIES = {DELETE_FROM_VOUCHER, DELETE_FROM_PAYPAL_PAYMENT, DELETE_FROM_DEBITCARD_PAYMENT,
        DELETE_FROM_AMEXCARD_PAYMENT, DELETE_FROM_VISACARD_PAYMENT, DELETE_FROM_MASTERCARD_PAYMENT, DELETE_FROM_PAYMENT_DETAIL, DELETE_FROM_SHOPPING_CART_ITEM, DELETE_FROM_WISHLIST, DELETE_FROM_SOLD_ITEM,
        DELETE_FROM_AUTHOR, DELETE_FROM_INVOICE, DELETE_FROM_CUSTOMER, DELETE_FROM_PERSON_ADDRESS_LINK,
        DELETE_FROM_REVIEW, DELETE_FROM_BOOK, DELETE_FROM_ITEM_COMMMON_DETAIL, DELETE_FROM_REVIEWER, DELETE_FROM_ADMINISTRATOR, DELETE_FROM_EMAIL, DELETE_FROM_PERSONAL_DETAIL,
        DELETE_FROM_TELEPHONE, DELETE_FROM_PUBLISHER, DELETE_FROM_CATEGORY, DELETE_FROM_ADDRESS
    };

    /**
     * The following strings are used to retrieve an object according to its ID.
     */
    public static final String FIND_BY_ADDRESS_ID = "FIND_ADDRESS_BY_ID";

    /**
     * The following strings are used to retrieve an object according to its
     * parameters.
     */
    public static final String FIND_ADDRESS_BY_UNIQUE_CONSTRAINT = "FIND_ADDRESS_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_ADMINISTRATOR_BY_UNIQUE_CONSTRAINT = "FIND_ADMINISTRATOR_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_AMEXCARD_PAYMENT_BY_UNIQUE_CONSTRAINT = "FIND_AMEXCARD_PAYMENT_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_AUTHOR_BY_UNIQUE_CONSTRAINT = "FIND_AUTHOR_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_AUTHOR_BOOK_BY_UNIQUE_CONSTRAINT = "FIND_AUTHOR_BY_UNIQUE_CONSTRAINT";    
    
    public static final String FIND_BOOK_BY_UNIQUE_CONSTRAINT = "FIND_BOOK_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_CATEGORY_BY_UNIQUE_CONSTRAINT = "FIND_CATEGORY_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_CUSTOMER_BY_UNIQUE_CONSTRAINT = "FIND_CUSTOMER_BY_UNIQUE_CONSTRAINT";
    public static final String FIND_CUSTOMER_BY_USERNAME = "FIND_CUSTOMER_BY_USERNAME";
    public static final String FIND_CUSTOMER_BY_PASSWORD = "FIND_CUSTOMER_BY_PASSWORD";

    public static final String FIND_DEBITCARD_PAYMENT_BY_UNIQUE_CONSTRAINT = "FIND_DEBITCARD_PAYMENT_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_EMAIL_BY_UNIQUE_CONSTRAINT = "FIND_EMAIL_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_INVOICE_BY_UNIQUE_CONSTRAINT = "FIND_INVOICE_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_ITEM_COMMON_DETAIL_BY_UNIQUE_CONSTRAINT = "FIND_ITEM_COMMON_DETAIL_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_MASTERCARD_PAYMENT_BY_UNIQUE_CONSTRAINT = "FIND_MASTERCARD_PAYMENT_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_PAYMENT_DETAIL_BY_UNIQUE_CONSTRAINT = "FIND_PAYMENT_DETAIL_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_PAYPAL_PAYMENT_BY_UNIQUE_CONSTRAINT = "FIND_PAYPAL_PAYMENTL_BY_UNIQUE_CONSTRAINT";
    
    public static final String FIND_PERSON_ADDRESS_LINK_BY_UNIQUE_CONSTRAINT = "FIND_PERSON_ADDRESS_LINK_BY_UNIQUE_CONSTRAINT";
    
    public static final String FIND_PERSONAL_DETAIL_BY_UNIQUE_CONSTRAINT = "FIND_PERSONAL_DETAIL_BY_UNIQUE_CONSTRAINT";
    
    public static final String FIND_PUBLISHER_BY_UNIQUE_CONSTRAINT = "FIND_PUBLISHER_BY_UNIQUE_CONSTRAINT";    
    
    public static final String FIND_REVIEW_BY_UNIQUE_CONSTRAINT = "FIND_REVIEW_BY_UNIQUE_CONSTRAINT";   

    
    public static final String FIND_REVIEWER_BY_UNIQUE_CONSTRAINT = "FIND_REVIEWER_BY_UNIQUE_CONSTRAINT";   
       
    
    public static final String FIND_SHOPPING_CART_ITEM_BY_UNIQUE_CONSTRAINT = "FIND_SHOPPING_CART_ITEM_BY_UNIQUE_CONSTRAINT";    
    
    public static final String FIND_SOLD_ITEM_BY_UNIQUE_CONSTRAINT = "FIND_SOLD_ITEM_BY_UNIQUE_CONSTRAINT";  
    
 
    public static final String FIND_TELEPHONE_BY_UNIQUE_CONSTRAINT = "FIND_TELEPHONE_BY_UNIQUE_CONSTRAINT";      
    
    public static final String FIND_VISACARD_PAYMENT_BY_UNIQUE_CONSTRAINT = "FIND_VISACARD_PAYMENT_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_VOUCHER_BY_UNIQUE_CONSTRAINT = "FIND_VOUCHER_BY_UNIQUE_CONSTRAINT";

    public static final String FIND_VOUCHER_PAYMENT_BY_UNIQUE_CONSTRAINT = "FIND_VOUCHER_PAYMENT_BY_UNIQUE_CONSTRAINT";    
    
    public static final String FIND_WISHLIST_BY_UNIQUE_CONSTRAINT = "FIND_WISHLIST_BY_UNIQUE_CONSTRAINT";
    public static final String FIND_WISHLIST_BY_ID = "FIND_WISHLIST_BY_ID";
    
    /**
     * The following strings are used to retrieve all objects of one type from
     * the database.
     */
    public static final String FIND_ALL_ADDRESSES = "FIND_ALL_ADDRESSES";

    public static final String FIND_ALL_ADMINISTRATORS = "FIND_ALL_ADMINISTRATORS";

    public static final String FIND_ALL_AUTHORS = "FIND_ALL_AUTHORS";

    public static final String FIND_ALL_BOOKS = "FIND_ALL_BOOKS";

    public static final String FIND_ALL_CUSTOMERS = "FIND_ALL_CUSTOMERS";
    
    public static final String FIND_ALL_WISHLISTS = "FIND_ALL_WISHLISTS";      

    /**
     * The following strings are used to retrieve all IDs of one type from
     * the database.
     */
    public static final String FIND_ALL_ADDRESS_IDS = "FIND_ALL_ADDRESS_IDS";

    public static final String FIND_ALL_WISHLIST_IDS = "FIND_ALL_WISHLIST_IDS"; 
    
    public static final String FIND_ALL_PAYMENT_DETAIL_IDS = "FIND_ALL_PAYMENT_DETAIL_IDS";
    
    /**
     * The following string are used to insert an entry to the database.
     */
    public static final String INSERT_INTO_ADDRESS = "INSERT_INTO_ADDRESS";
    public static final String INSERT_INTO_CATEGORY = "INSERT_INTO_CATEGORY";
    public static final String INSERT_INTO_PUBLISHER = "INSERT_INTO_PUBLISHER";
    public static final String INSERT_INTO_TELEPNONE = "INSERT_INTO_TELEPNONE";
    public static final String INSERT_INTO_PERSONAL_DETAIL = "INSERT_INTO_PERSONAL_DETAIL";
    public static final String INSERT_INTO_EMAIL = "INSERT_INTO_EMAIL";
    public static final String INSERT_INTO_ADMINISTRATOR = "INSERT_INTO_ADMINISTRATOR";
    public static final String INSERT_INTO_REVIEWER = "INSERT_INTO_REVIEWER";
    public static final String INSERT_INTO_ITEM_COMMON_DETAIL = "INSERT_INTO_ITEM_COMMON_DETAIL";
    public static final String INSERT_INTO_BOOK = "INSERT_INTO_BOOK";
    public static final String INSERT_INTO_REVIEW = "INSERT_INTO_REVIEW";
    public static final String INSERT_INTO_ITEM_CATEGORY_LINK = "INSERT_INTO_ITEM_CATEGORY_LINK";
    public static final String INSERT_INTO_PERSON_TELEPHONE_LINK = "INSERT_INTO_PERSON_TELEPHONE_LINK";
    public static final String INSERT_INTO_PERSON_ADDRESS_LINK = "INSERT_INTO_PERSON_ADDRESS_LINK";
    public static final String INSERT_INTO_CUSTOMER = "INSERT_INTO_CUSTOMER";
    public static final String INSERT_INTO_INVOICE = "INSERT_INTO_INVOICE";
    public static final String INSERT_INTO_AUTHOR = "INSERT_INTO_AUTHOR";
    public static final String INSERT_INTO_AUTHOR_BOOK_LINK = "INSERT_INTO_AUTHOR_BOOK_LINK";
    public static final String INSERT_INTO_SOLD_ITEM = "INSERT_INTO_SOLD_ITEM";
    public static final String INSERT_INTO_WISHLIST = "INSERT_INTO_WISHLIST";
    public static final String INSERT_INTO_WISHLIST_ITEM_LINK = "INSERT_INTO_WISHLIST_ITEM_LINK";
    public static final String INSERT_INTO_SHOPPING_CART_ITEM = "INSERT_INTO_SHOPPING_CART_ITEM";
    public static final String INSERT_INTO_PAYMENT_DETAIL = "INSERT_INTO_PAYMENT_DETAIL";
    public static final String INSERT_INTO_VISACARD_PAYMENT = "INSERT_INTO_VISACARD_PAYMENT";
    public static final String INSERT_INTO_MASTERCARD_PAYMENT = "INSERT_INTO_MASTERCARD_PAYMENT";
    public static final String INSERT_INTO_AMEXCARD_PAYMENT = "INSERT_INTO_AMEXCARD_PAYMENT";
    public static final String INSERT_INTO_DEBITCARD_PAYMENT = "INSERT_INTO_DEBITCARD_PAYMENT";
    public static final String INSERT_INTO_PAYPAL_PAYMENT = "INSERT_INTO_PAYPAL_PAYMENT";
    public static final String INSERT_INTO_VOUCHER = "INSERT_INTO_VOUCHER";
    public static final String INSERT_INTO_VOUCHER_PAYMENT = "INSERT_INTO_VOUCHER_PAYMENT";

    public static final String SELECT_FROM_AUTHOR_BOOK_LINK = "SELECT_FROM_AUTHOR_BOOK_LINK";    
    public static final String SELECT_FEOM_ITEM_CATEGORY_LINK = "SELECT_FEOM_ITEM_CATEGORY_LINK";    
    public static final String SELECT_FROM_PERSON_TELEPHONE_LINK = "SELECT_FROM_PERSON_TELEPHONE_LINK";
    public static final String SELECT_FROM_WISHLIST_ITEM_LINK = "SELECT_FROM_WISHLIST_ITEM_LINK";
    public static final String SELECT_FROM_VOUCHER_PAYMENT = "SELECT_FROM_VOUCHER_PAYMENT";
}
