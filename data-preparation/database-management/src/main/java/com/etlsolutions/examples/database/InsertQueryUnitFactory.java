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
package com.etlsolutions.examples.database;

import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.database.maplist.AddressMapList;
import com.etlsolutions.examples.database.maplist.AdministratorMapList;
import com.etlsolutions.examples.database.maplist.AmexcardPaymentMapList;
import com.etlsolutions.examples.database.maplist.AuthorBookLinkMapList;
import com.etlsolutions.examples.database.maplist.AuthorMapList;
import com.etlsolutions.examples.database.maplist.BookMapList;
import com.etlsolutions.examples.database.maplist.CategoryMapList;
import com.etlsolutions.examples.database.maplist.CustomerMapList;
import com.etlsolutions.examples.database.maplist.DebitcardPaymentMapList;
import com.etlsolutions.examples.database.maplist.EmailMapList;
import com.etlsolutions.examples.database.maplist.InvoiceMapList;
import com.etlsolutions.examples.database.maplist.ItemCategoryLinkMapList;
import com.etlsolutions.examples.database.maplist.ItemCommonDetailMapList;
import com.etlsolutions.examples.database.maplist.MastercardPaymentMapList;
import com.etlsolutions.examples.database.maplist.PaymentDetailMapList;
import com.etlsolutions.examples.database.maplist.PaypalPaymentMapList;
import com.etlsolutions.examples.database.maplist.PersonAddressLinkMapList;
import com.etlsolutions.examples.database.maplist.PersonTelephoneLinkMapList;
import com.etlsolutions.examples.database.maplist.PersonalDetailMapList;
import com.etlsolutions.examples.database.maplist.PublisherMapList;
import com.etlsolutions.examples.database.maplist.ReviewMapList;
import com.etlsolutions.examples.database.maplist.ReviewerMapList;
import com.etlsolutions.examples.database.maplist.SequenceIdGenerationDefinition;
import com.etlsolutions.examples.database.maplist.ShoppingCartItemMapList;
import com.etlsolutions.examples.database.maplist.SoldItemMapList;
import com.etlsolutions.examples.database.maplist.TelephoneMapList;
import com.etlsolutions.examples.database.maplist.VisacardPaymentMapList;
import com.etlsolutions.examples.database.maplist.VoucherMapList;
import com.etlsolutions.examples.database.maplist.VoucherPaymentMapList;
import com.etlsolutions.examples.database.maplist.WishlistItemLinkMapList;
import com.etlsolutions.examples.database.maplist.WishlistMapList;
import com.etlsolutions.examples.message.ErrorType;
import static com.etlsolutions.examples.message.MessageFactory.getMessage;
import com.etlsolutions.examples.utility.annotation.UtilityClass;

/**
 * The InsertQueryUnitFactory class is a utility class to create the
 * InsertQueryUnits.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@UtilityClass
public final class InsertQueryUnitFactory {

    private InsertQueryUnitFactory() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * Get the InsertUnit array.
     * @return the InsertUnit array.
     */
    public static final InsertQueryUnit[] getInsertUnits() {
        AddressMapList addressMapList = new AddressMapList(new SequenceIdGenerationDefinition(10000, 1, 1));
        CategoryMapList categoryMapList = new CategoryMapList(new SequenceIdGenerationDefinition(500, 1, 1));
        PublisherMapList publisherMapList = new PublisherMapList(addressMapList, new SequenceIdGenerationDefinition(100, 1, 1));
        TelephoneMapList telephoneMapList = new TelephoneMapList(new SequenceIdGenerationDefinition(300, 1, 1));
        PersonalDetailMapList personalDetailMapList = new PersonalDetailMapList(new SequenceIdGenerationDefinition(10000, 1, 1));
        EmailMapList emailMapList = new EmailMapList(personalDetailMapList, new SequenceIdGenerationDefinition(250, 1, 1));
        AdministratorMapList administratorMapList = new AdministratorMapList(personalDetailMapList, new SequenceIdGenerationDefinition(20, 1, 1));
        ReviewerMapList reviewerMapList = new ReviewerMapList(personalDetailMapList, new SequenceIdGenerationDefinition(100, 1, 1));
        ItemCommonDetailMapList itemCommonDetailMapList = new ItemCommonDetailMapList(new SequenceIdGenerationDefinition(10000, 1, 1));
        BookMapList bookMapList = new BookMapList(itemCommonDetailMapList, publisherMapList, new SequenceIdGenerationDefinition(100, 1, 1));
        ReviewMapList reviewMapList = new ReviewMapList(itemCommonDetailMapList, reviewerMapList, new SequenceIdGenerationDefinition(500, 1, 1));
        ItemCategoryLinkMapList itemCategoryLinkMapList = new ItemCategoryLinkMapList(itemCommonDetailMapList, categoryMapList, new SequenceIdGenerationDefinition(100, 1, 1));
        PersonTelephoneLinkMapList personTelephoneLinkMapList = new PersonTelephoneLinkMapList(personalDetailMapList, telephoneMapList, new SequenceIdGenerationDefinition(500, 1, 1));
        PersonAddressLinkMapList personAddressLinkMapList = new PersonAddressLinkMapList(personalDetailMapList, addressMapList, new SequenceIdGenerationDefinition(4000, 1, 1));
        CustomerMapList customerMapList = new CustomerMapList(personAddressLinkMapList, new SequenceIdGenerationDefinition(500, 1, 1));
        InvoiceMapList invoiceMapList = new InvoiceMapList(customerMapList, addressMapList, new SequenceIdGenerationDefinition(2000, 1, 1));
        AuthorMapList authorMapList = new AuthorMapList(personalDetailMapList, new SequenceIdGenerationDefinition(300, 1, 1));
        AuthorBookLinkMapList authorBookLinkMapList = new AuthorBookLinkMapList(authorMapList, bookMapList, new SequenceIdGenerationDefinition(50, 1, 1));
        SoldItemMapList soldItemMapList = new SoldItemMapList(invoiceMapList, itemCommonDetailMapList, new SequenceIdGenerationDefinition(100, 1, 1));
        WishlistMapList wishlistMapList = new WishlistMapList(customerMapList, new SequenceIdGenerationDefinition(230, 1, 1));
        WishlistItemLinkMapList wishlistItemLinkMapList = new WishlistItemLinkMapList(wishlistMapList, itemCommonDetailMapList, new SequenceIdGenerationDefinition(100, 1, 1));
        ShoppingCartItemMapList shoppingCartItemMapList = new ShoppingCartItemMapList(customerMapList, itemCommonDetailMapList, new SequenceIdGenerationDefinition(50, 1, 1));
        PaymentDetailMapList paymentDetailMapList = new PaymentDetailMapList(invoiceMapList, new SequenceIdGenerationDefinition(1000, 1, 1));
        VisacardPaymentMapList visacardPaymentMapList = new VisacardPaymentMapList(paymentDetailMapList, personAddressLinkMapList, new SequenceIdGenerationDefinition(10, 1, 1));
        MastercardPaymentMapList mastercardPaymentMapList = new MastercardPaymentMapList(paymentDetailMapList, personAddressLinkMapList, new SequenceIdGenerationDefinition(10, 1, 1));
        AmexcardPaymentMapList amexcardPaymentMapList = new AmexcardPaymentMapList(paymentDetailMapList, personAddressLinkMapList, new SequenceIdGenerationDefinition(10, 1, 1));
        DebitcardPaymentMapList debitcardPaymentMapList = new DebitcardPaymentMapList(paymentDetailMapList, personAddressLinkMapList, new SequenceIdGenerationDefinition(10, 1, 1));
        PaypalPaymentMapList paypalPaymentMapList = new PaypalPaymentMapList(paymentDetailMapList, new SequenceIdGenerationDefinition(30, 1, 1));
        VoucherMapList voucherMapList = new VoucherMapList(customerMapList, new SequenceIdGenerationDefinition(100, 1, 1));
        VoucherPaymentMapList voucherPaymentMapList = new VoucherPaymentMapList(paymentDetailMapList, voucherMapList, new SequenceIdGenerationDefinition(10, 1, 1));

        return new InsertQueryUnit[]{
            new InsertQueryUnit(QueryNames.INSERT_INTO_ADDRESS, addressMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_CATEGORY, categoryMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_PUBLISHER, publisherMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_TELEPNONE, telephoneMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_PERSONAL_DETAIL, personalDetailMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_EMAIL, emailMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_ADMINISTRATOR, administratorMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_REVIEWER, reviewerMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_ITEM_COMMON_DETAIL, itemCommonDetailMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_BOOK, bookMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_REVIEW, reviewMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_ITEM_CATEGORY_LINK, itemCategoryLinkMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_PERSON_TELEPHONE_LINK, personTelephoneLinkMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_PERSON_ADDRESS_LINK, personAddressLinkMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_CUSTOMER, customerMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_INVOICE, invoiceMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_AUTHOR, authorMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_AUTHOR_BOOK_LINK, authorBookLinkMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_SOLD_ITEM, soldItemMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_WISHLIST, wishlistMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_WISHLIST_ITEM_LINK, wishlistItemLinkMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_SHOPPING_CART_ITEM, shoppingCartItemMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_PAYMENT_DETAIL, paymentDetailMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_VISACARD_PAYMENT, visacardPaymentMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_MASTERCARD_PAYMENT, mastercardPaymentMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_AMEXCARD_PAYMENT, amexcardPaymentMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_DEBITCARD_PAYMENT, debitcardPaymentMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_PAYPAL_PAYMENT, paypalPaymentMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_VOUCHER, voucherMapList),
            new InsertQueryUnit(QueryNames.INSERT_INTO_VOUCHER_PAYMENT, voucherPaymentMapList)
        };
    }
}
