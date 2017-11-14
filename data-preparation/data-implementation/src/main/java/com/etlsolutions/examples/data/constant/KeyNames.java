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
 * The KeyNames class contains all the key strings for database parameters in
 * Hibernate and JPA modules
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class KeyNames {

    private KeyNames() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    public static final String ADDRESS_ID = "id";
    public static final String ADDRESS_HOUSE = "house";    
    public static final String ADDRESS_STREET = "street";
    public static final String ADDRESS_ADITIONAL = "additional";
    public static final String ADDRESS_CITY = "city";
    public static final String ADDRESS_AREA = "area";
    public static final String ADDRESS_POSTCODE = "postcode";
    public static final String ADDRESS_COUNTRY = "country";

    public static final String ADMINISTRATOR_ID = "id";
    public static final String ADMINISTRATOR_PERSONAL_DETAIL = "personalDetail";
    public static final String ADMINISTRATOR_PERSONAL_DETAIL_ID = "personalDetailId";
    public static final String ADMINISTRATOR_ROLE = "administratorRole";
    public static final String ADMINISTRATOR_USERNAME = "username";
    public static final String ADMINISTRATOR_PASSWORD = "password";

    public static final String AMEXCARD_PAYMENT_ID = "id";
    public static final String AMEXCARD_PAYMENT_PERSON_ADDRESS_LINK = "personAddressLink";
    public static final String AMEXCARD_PAYMENT_PERSON_ADDRESS_LINK_ID = "personAddressLink";
    public static final String AMEXCARD_PAYMENT_PAYMENT_DETAIL = "paymentDetail";
    public static final String AMEXCARD_PAYMENT_PAYMENT_DETAIL_ID = "paymentDetailId";
    public static final String AMEXCARD_PAYMENT_PAYMENT_TYPE = "paymentType";
    public static final String AMEXCARD_PAYMENT_CARD_NUMBER = "cardNumber";
    public static final String AMEXCARD_PAYMENT_SECURITY_CODE = "securityCode";
    public static final String AMEXCARD_PAYMENT_EXPIRE_DATE = "expireDate";

    public static final String AUTHOR_ID = "id";
    public static final String AUTHOR_PERSONAL_DETAIL = "personalDetail";
    public static final String AUTHOR_PERSONAL_DETAIL_ID = "personalDetailId";
    public static final String AUTHOR_IMAGE = "image";
    public static final String AUTHOR_BIOGRAPHY = "biography";
    public static final String AUTHOR_WEBPAGE_URL = "webpageUrl";

    public static final String AUTHOR_BOOK_LINK_BOOK = "book";
    public static final String AUTHOR_BOOK_LINK_BOOK_ID = "bookId";
    public static final String AUTHOR_BOOK_LINK_AUTHOR = "author";
    public static final String AUTHOR_BOOK_LINK_AUTHOR_ID = "authorId";

    public static final String BOOK_ID = "id";
    public static final String BOOK_ITEM_COMMON_DETAIL = "itemCommonDetail";
    public static final String BOOK_ITEM_COMMON_DETAIL_ID = "itemCommonDetailId";
    public static final String BOOK_PUBLISHER = "publisher";
    public static final String BOOK_PUBLISHER_ID = "publisherId";
    public static final String BOOK_ISBN = "isbn";
    public static final String BOOK_PDF_CONTENT = "pdf";
    public static final String BOOK_EDITION = "edition";
    public static final String BOOK_PUBLISH_DATE = "publishedDate";
    public static final String BOOK_WIDTH = "width";
    public static final String BOOK_LENGTH = "length";
    public static final String BOOK_THICKNESS = "thickness";
    public static final String BOOK_UOM = "uom";
    public static final String BOOK_FORMAT = "format";
    public static final String BOOK_LANGUAGE = "language";

    public static final String CARD_PAYMENT_ID = "id";
    public static final String CARD_PAYMENT_PAYMENT_DETAIL = "paymentDetail";
    public static final String CARD_PAYMENT_PAYMENT_DETAIL_ID = "paymentDetailId";
    public static final String CARD_PAYMENT_PERSON_ADDRESS_LINK = "personAddressLink";
    public static final String CARD_PAYMENT_PERSON_ADDRESS_LINK_ID = "personAddressLinkId";
    public static final String CARD_PAYMENT_TYPE = "paymentType";
    public static final String CARD_PAYMENT_EXPIRE_DATE = "expireDate";

    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name";

    public static final String CUSTOMER_ID = "id";
    public static final String CUSTOMER_PERSON_ADDRESS_LINK = "personAddressLink";
    public static final String CUSTOMER_PERSON_ADDRESS_LINK_ID = "personAddressLinkId";
    public static final String CUSTOMER_USERNAME = "username";
    public static final String CUSTOMER_PASSWORD = "password";
    public static final String CUSTOMER_IMAGE = "image";

    public static final String DEBITCARD_PAYMENT_ID = "id";
    public static final String DEBITCARD_PAYMENT_PERSON_ADDRESS_LINK_ID = "personAddressLinkId";
    public static final String DEBITCARD_PAYMENT_PERSON_ADDRESS_LINK = "personAddressLink";
    public static final String DEBITCARD_PAYMENT_PAYMENT_DETAIL_ID = "paymentDetailId";
    public static final String DEBITCARD_PAYMENT_PAYMENT_DETAIL = "paymentDetail";
    public static final String DEBITCARD_PAYMENT_PAYMENT_TYPE = "paymentType";
    public static final String DEBITCARD_PAYMENT_CARD_NUMBER = "cardNumber";
    public static final String DEBITCARD_PAYMENT_SECURITY_CODE = "securityCode";
    public static final String DEBITCARD_PAYMENT_ISSUE_NUMBER = "issueNumber";
    public static final String DEBITCARD_PAYMENT_START_DATE = "startDate";
    public static final String DEBITCARD_PAYMENT_EXPIRE_DATE = "expireDate";

    public static final String EMAIL_ID = "id";
    public static final String EMAIL_PERSONAL_DETAIL = "personalDetail";
    public static final String EMAIL_PERSONAL_DETAIL_ID = "personalDetailId";
    public static final String EMAIL_ADDRESS = "emailAddress";

    public static final String INVOICE_ID = "id";
    public static final String INVOICE_DELIVERY_ADDRESS = "deliveryAddress";
    public static final String INVOICE_DELIVERY_ADDRESS_ID = "deliveryAddressId";
    public static final String INVOICE_CUSTOMER = "customer";
    public static final String INVOICE_CUSTOMER_ID = "customerId";
    public static final String INVOICE_DATE = "invoiceDate";
    public static final String INVOICE_TOTAL = "total";
    public static final String INVOICE_VALIDITY = "validity";
    public static final String INVOICE_REFERENCE_NUMBER = "referenceNumber";

    public static final String ITEM_CATEGORY_LINK_CATEGORY = "category";
    public static final String ITEM_CATEGORY_LINK_CATEGORY_ID = "categoryId";
    public static final String ITEM_CATEGORY_LINK_ITEM_COMMON_DETAIL = "itemCommonDetail";
    public static final String ITEM_CATEGORY_LINK_ITEM_COMMON_DETAIL_ID = "itemCommonDetailId";

    public static final String ITEM_COMMON_DETAIL_ID = "id";
    public static final String ITEM_COMMON_DETAIL_NAME = "name";
    public static final String ITEM_COMMON_DETAIL_IMAGE = "image";
    public static final String ITEM_COMMON_DETAIL_LIST_PRICE = "listPrice";
    public static final String ITEM_COMMON_DETAIL_SALE_PRICE = "salePrice";
    public static final String ITEM_COMMON_DETAIL_CURRENCY_CODE = "currencyCode";
    public static final String ITEM_COMMON_DETAIL_RANKING = "ranking";
    public static final String ITEM_COMMON_DETAIL_DESCRIPTION = "description";
    public static final String ITEM_COMMON_DETAIL_AVAILABILITY = "availability";
    public static final String ITEM_COMMON_DETAIL_AVAILABILITY_NUMBER = "availabilityNumber";
    public static final String ITEM_COMMON_DETAIL_BARCODE = "barcode";

    public static final String MASTERCARD_PAYMENT_ID = "id";
    public static final String MASTERCARD_PAYMENT_PERSON_ADDRESS_LINK_ID = "personAddressLinkId";
    public static final String MASTERCARD_PAYMENT_PERSON_ADDRESS_LINK = "personAddressLink";
    public static final String MASTERCARD_PAYMENT_PAYMENT_DETAIL_ID = "paymentDetailId";
    public static final String MASTERCARD_PAYMENT_PAYMENT_DETAIL = "paymentDetail";
    public static final String MASTERCARD_PAYMENT_PAYMENT_TYPE = "paymentType";
    public static final String MASTERCARD_PAYMENT_CARD_NUMBER = "cardNumber";
    public static final String MASTERCARD_PAYMENT_SECURITY_CODE = "securityCode";
    public static final String MASTERCARD_PAYMENT_START_DATE = "startDate";
    public static final String MASTERCARD_PAYMENT_EXPIRE_DATE = "expireDate";

    public static final String PAYMENT_DETAIL_ID = "id";
    public static final String PAYMENT_TYPE = "paymentType";
    public static final String PAYMENT_INVOICE = "invoice";
    public static final String PAYMENT_INVOICE_ID = "invoiceId";
    public static final String PAYMENT_SUBTOTAL = "subtotal";
    public static final String PAYMENT_CURRENCY_CODE = "currencyCode";

    public static final String PAYPAL_PAYMENT_ID = "id";
    public static final String PAYPAL_PAYMENT_DETAIL = "paymentDetail";
    public static final String PAYPAL_PAYMENT_DETAIL_ID = "paymentDetailId";
    public static final String PAYPAL_PAYMENT_TYPE = "paymentType";
    public static final String PAYPAL_ACCOUNT_ID = "accountId";
    public static final String PAYPAL_IDENTITY_TOKEN = "identityToken";

    public static final String PERSON_ADDRESS_LINK_ID = "id";
    public static final String PERSON_ADDRESS_LINK_PERSONAL_DETAIL = "personalDetail";
    public static final String PERSON_ADDRESS_LINK_PERSONAL_DETAIL_ID = "personalDetailId";
    public static final String PERSON_ADDRESS_LINK_ADDRESS = "address";
    public static final String PERSON_ADDRESS_LINK_ADDRESS_ID = "addressId";
    public static final String PERSON_ADDRESS_LINK_ADDRESS_TYPE = "type";

    public static final String PERSONAL_DETAIL_ID = "id";
    public static final String PERSONAL_DETAIL_TITLE = "title";
    public static final String PERSONAL_DETAIL_GIVEN_NAME = "givenName";
    public static final String PERSONAL_DETAIL_FAMILY_NAME = "familyName";
    public static final String PERSONAL_DETAIL_DATE_OF_BIRTH = "dateOfBirth";
    public static final String PERSONAL_DETAIL_PROFILE = "profile";

    public static final String PERSONAL_TELEPHONE_LINK_PERSIONAL_DETAIL = "personalDetail";
    public static final String PERSONAL_TELEPHONE_LINK_PERSIONAL_DETAIL_ID = "personalDetailId";
    public static final String PERSONAL_TELEPHONE_LINK_TELEPHONE = "telephone";
    public static final String PERSONAL_TELEPHONE_LINK_TELEPHONE_ID = "telephoneId";

    public static final String PUBLISHER_ID = "id";
    public static final String PUBLISHER_NAME = "name";
    public static final String PUBLISHER_ADDRESS = "address";
    public static final String PUBLISHER_ADDRESS_ID = "addressId";

    public static final String REVIEW_ID = "id";
    public static final String REVIEW_REVIWER = "reviewer";
    public static final String REVIEW_REVIWER_ID = "reviewerId";
    public static final String REVIEW_ITEM_COMMON_DETAIL = "itemCommonDetail";
    public static final String REVIEW_ITEM_COMMON_DETAIL_ID = "itemCommonDetailId";
    public static final String REVIEW_RANKING = "ranking";
    public static final String REVIEW_TEXT = "text";

    public static final String REVIEWER_ID = "id";
    public static final String REVIEWER_PERSONAL_DETAIL = "personalDetal";
    public static final String REVIEWER_PERSONAL_DETAIL_ID = "personalDetalId";
    public static final String REVIEWER_IMAGE = "image";
    public static final String REVIEWER_USERNAME = "username";
    public static final String REVIEWER_PASSWORD = "password";

    public static final String SHOPPING_CART_ITEM_ID = "id";
    public static final String SHOPPING_CART_ITEM_CUSTOMER = "customer";
    public static final String SHOPPING_CART_ITEM_CUSTOMER_ID = "customerId";
    public static final String SHOPPING_CART_ITEM_COMMON_DETAIL = "itemCommonDetail";
    public static final String SHOPPING_CART_ITEM_COMMON_DETAIL_ID = "itemCommonDetailId";
    public static final String SHOPPING_CART_ITEM_UNIT_NUMBER = "unitNumber";

    public static final String SOLD_ITEM_ID = "id";
    public static final String SOLD_ITEM_COMMON_DETAIL = "itemCommonDetail";
    public static final String SOLD_ITEM_COMMON_DETAIL_ID = "itemCommonDetailId";
    public static final String SOLD_ITEM_INVOICE = "invoice";
    public static final String SOLD_ITEM_INVOICE_ID = "invoiceId";
    public static final String SOLD_ITEM_QUANTITY = "quantity";
    public static final String SOLD_ITEM_UNIT_PRICE = "unitPrice";

    public static final String TELEPHONE_ID = "id";
    public static final String TELEPHONE_COUNTRY_CODE = "countryCode";
    public static final String TELEPHONE_AREA_CODE = "areaCode";
    public static final String TELEPHONE_TYPE = "telephoneType";
    public static final String TELEPHONE_NUMBER = "telephoneNumber";

    public static final String VISACARD_PAYMENT_ID = "id";
    public static final String VISACARD_PAYMENT_PERSON_ADDRESS_LINK_ID = "personAddressLinkId";
    public static final String VISACARD_PAYMENT_PERSON_ADDRESS_LINK = "personAddressLink";
    public static final String VISACARD_PAYMENT_PAYMENT_DETAIL_ID = "paymentDetailId";
    public static final String VISACARD_PAYMENT_PAYMENT_DETAIL = "paymentDetail";
    public static final String VISACARD_PAYMENT_PAYMENT_TYPE = "paymentType";
    public static final String VISACARD_PAYMENT_CARD_NUMBER = "cardNumber";
    public static final String VISACARD_PAYMENT_SECURITY_CODE = "securityCode";
    public static final String VISACARD_PAYMENT_START_DATE = "startDate";
    public static final String VISACARD_PAYMENT_EXPIRE_DATE = "expireDate";

    public static final String VOUCHER_ID = "id";
    public static final String VOUCHER_CUSTOMER = "customer";
    public static final String VOUCHER_CUSTOMER_ID = "customerId";
    public static final String VOUCHER_TOKEN = "voucherToken";
    public static final String VOUCHER_TOTAL = "total";
    public static final String VOUCHER_EXPIRED_DATE = "expireDate";    

    public static final String VOUCHER_PAYMENT_VOUCHER_ID = "voucherId";
    public static final String VOUCHER_PAYMENT_PAYMENT_DETAIL_ID = "paymentDetailId";
    public static final String VOUCHER_PAYMENT_PAYMENT_DETAIL = "paymentDetail";
    public static final String VOUCHER_PAYMENT_PAYMENT_TYPE = "paymentType";

    public static final String WISHLIST_ID = "id";
    public static final String WISHLIST_NAME = "name";
    public static final String WISHLIST_CUSTOMER = "customer";
    public static final String WISHLIST_CUSTOMER_ID = "customerId";
    public static final String WISHLIST_ITEM_LINK_COMMON_DETAIL = "itemCommonDetail";
    public static final String WISHLIST_ITEM_LINK_COMMON_DETAIL_ID = "itemCommonDetailId";
    public static final String WISHLIST_ITEM_LINK_WISHLIST = "wishlist";
    public static final String WISHLIST_ITEM_LINK_WISHLIST_ID = "wishlistId";
}
