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
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class InsertQueryUnitFactory.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({InsertQueryUnitFactory.class, SequenceIdGenerationDefinition.class, AddressMapList.class, CategoryMapList.class, PublisherMapList.class,
    TelephoneMapList.class, PersonalDetailMapList.class, EmailMapList.class, AdministratorMapList.class, ReviewerMapList.class,
    ItemCommonDetailMapList.class, BookMapList.class, ReviewMapList.class, ItemCategoryLinkMapList.class, PersonTelephoneLinkMapList.class,
    PersonAddressLinkMapList.class, CustomerMapList.class, InvoiceMapList.class, AuthorMapList.class, AuthorBookLinkMapList.class,
    SoldItemMapList.class, WishlistMapList.class, WishlistItemLinkMapList.class, ShoppingCartItemMapList.class, PaymentDetailMapList.class,
    VisacardPaymentMapList.class, MastercardPaymentMapList.class, AmexcardPaymentMapList.class, DebitcardPaymentMapList.class, PaypalPaymentMapList.class,
    VoucherMapList.class, VoucherPaymentMapList.class})
public final class InsertQueryUnitFactoryTest {

    @Before
    public void setUp() {
    }

    /**
     * Test of getInsertUnits method.
     * @throws Exception if an error occurs.
     */
    @Test
    public void testGetInsertUnits() throws Exception {

        SequenceIdGenerationDefinition sequenceIdGenerationDefinition10 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition20 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition30 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition50 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition100 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition230 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition250 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition300 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition500 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition1000 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition2000 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition4000 = PowerMockito.mock(SequenceIdGenerationDefinition.class);
        SequenceIdGenerationDefinition sequenceIdGenerationDefinition10000 = PowerMockito.mock(SequenceIdGenerationDefinition.class);

        AddressMapList addressMapList = PowerMockito.mock(AddressMapList.class);
        CategoryMapList categoryMapList = PowerMockito.mock(CategoryMapList.class);
        PublisherMapList publisherMapList = PowerMockito.mock(PublisherMapList.class);
        TelephoneMapList telephoneMapList = PowerMockito.mock(TelephoneMapList.class);
        PersonalDetailMapList personalDetailMapList = PowerMockito.mock(PersonalDetailMapList.class);
        EmailMapList emailMapList = PowerMockito.mock(EmailMapList.class);
        AdministratorMapList administratorMapList = PowerMockito.mock(AdministratorMapList.class);
        ReviewerMapList reviewerMapList = PowerMockito.mock(ReviewerMapList.class);
        ItemCommonDetailMapList itemCommonDetailMapList = PowerMockito.mock(ItemCommonDetailMapList.class);
        BookMapList bookMapList = PowerMockito.mock(BookMapList.class);
        ReviewMapList reviewMapList = PowerMockito.mock(ReviewMapList.class);
        ItemCategoryLinkMapList itemCategoryLinkMapList = PowerMockito.mock(ItemCategoryLinkMapList.class);
        PersonTelephoneLinkMapList personTelephoneLinkMapList = PowerMockito.mock(PersonTelephoneLinkMapList.class);
        PersonAddressLinkMapList personAddressLinkMapList = PowerMockito.mock(PersonAddressLinkMapList.class);
        CustomerMapList customerMapList = PowerMockito.mock(CustomerMapList.class);
        InvoiceMapList invoiceMapList = PowerMockito.mock(InvoiceMapList.class);
        AuthorMapList authorMapList = PowerMockito.mock(AuthorMapList.class);
        AuthorBookLinkMapList authorBookLinkMapList = PowerMockito.mock(AuthorBookLinkMapList.class);
        SoldItemMapList soldItemMapList = PowerMockito.mock(SoldItemMapList.class);
        WishlistMapList wishlistMapList = PowerMockito.mock(WishlistMapList.class);
        WishlistItemLinkMapList wishlistItemLinkMapList = PowerMockito.mock(WishlistItemLinkMapList.class);
        ShoppingCartItemMapList shoppingCartItemMapList = PowerMockito.mock(ShoppingCartItemMapList.class);
        PaymentDetailMapList paymentDetailMapList = PowerMockito.mock(PaymentDetailMapList.class);
        VisacardPaymentMapList visacardPaymentMapList = PowerMockito.mock(VisacardPaymentMapList.class);
        MastercardPaymentMapList mastercardPaymentMapList = PowerMockito.mock(MastercardPaymentMapList.class);
        AmexcardPaymentMapList amexcardPaymentMapList = PowerMockito.mock(AmexcardPaymentMapList.class);
        DebitcardPaymentMapList debitcardPaymentMapList = PowerMockito.mock(DebitcardPaymentMapList.class);
        PaypalPaymentMapList paypalPaymentMapList = PowerMockito.mock(PaypalPaymentMapList.class);
        VoucherMapList voucherMapList = PowerMockito.mock(VoucherMapList.class);
        VoucherPaymentMapList voucherPaymentMapList = PowerMockito.mock(VoucherPaymentMapList.class);

        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(10, 1, 1).thenReturn(sequenceIdGenerationDefinition10);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(20, 1, 1).thenReturn(sequenceIdGenerationDefinition20);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(30, 1, 1).thenReturn(sequenceIdGenerationDefinition30);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(50, 1, 1).thenReturn(sequenceIdGenerationDefinition50);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(100, 1, 1).thenReturn(sequenceIdGenerationDefinition100);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(230, 1, 1).thenReturn(sequenceIdGenerationDefinition230);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(250, 1, 1).thenReturn(sequenceIdGenerationDefinition250);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(300, 1, 1).thenReturn(sequenceIdGenerationDefinition300);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(500, 1, 1).thenReturn(sequenceIdGenerationDefinition500);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(1000, 1, 1).thenReturn(sequenceIdGenerationDefinition1000);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(2000, 1, 1).thenReturn(sequenceIdGenerationDefinition2000);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(4000, 1, 1).thenReturn(sequenceIdGenerationDefinition4000);
        PowerMockito.whenNew(SequenceIdGenerationDefinition.class).withArguments(10000, 1, 1).thenReturn(sequenceIdGenerationDefinition10000);

        PowerMockito.whenNew(AddressMapList.class).withArguments(sequenceIdGenerationDefinition10000).thenReturn(addressMapList);
        PowerMockito.whenNew(CategoryMapList.class).withArguments(sequenceIdGenerationDefinition500).thenReturn(categoryMapList);
        PowerMockito.whenNew(PublisherMapList.class).withArguments(addressMapList, sequenceIdGenerationDefinition100).thenReturn(publisherMapList);
        PowerMockito.whenNew(TelephoneMapList.class).withArguments(sequenceIdGenerationDefinition300).thenReturn(telephoneMapList);
        PowerMockito.whenNew(PersonalDetailMapList.class).withArguments(sequenceIdGenerationDefinition10000).thenReturn(personalDetailMapList);
        PowerMockito.whenNew(EmailMapList.class).withArguments(personalDetailMapList, sequenceIdGenerationDefinition250).thenReturn(emailMapList);
        PowerMockito.whenNew(AdministratorMapList.class).withArguments(personalDetailMapList, sequenceIdGenerationDefinition20).thenReturn(administratorMapList);
        PowerMockito.whenNew(ReviewerMapList.class).withArguments(personalDetailMapList, sequenceIdGenerationDefinition100).thenReturn(reviewerMapList);
        PowerMockito.whenNew(ItemCommonDetailMapList.class).withArguments(sequenceIdGenerationDefinition10000).thenReturn(itemCommonDetailMapList);
        PowerMockito.whenNew(BookMapList.class).withArguments(itemCommonDetailMapList, publisherMapList, sequenceIdGenerationDefinition100).thenReturn(bookMapList);
        PowerMockito.whenNew(ReviewMapList.class).withArguments(itemCommonDetailMapList, reviewerMapList, sequenceIdGenerationDefinition500).thenReturn(reviewMapList);
        PowerMockito.whenNew(ItemCategoryLinkMapList.class).withArguments(itemCommonDetailMapList, categoryMapList, sequenceIdGenerationDefinition100).thenReturn(itemCategoryLinkMapList);
        PowerMockito.whenNew(PersonTelephoneLinkMapList.class).withArguments(personalDetailMapList, telephoneMapList, sequenceIdGenerationDefinition500).thenReturn(personTelephoneLinkMapList);
        PowerMockito.whenNew(PersonAddressLinkMapList.class).withArguments(personalDetailMapList, addressMapList, sequenceIdGenerationDefinition4000).thenReturn(personAddressLinkMapList);
        PowerMockito.whenNew(CustomerMapList.class).withArguments(personAddressLinkMapList, sequenceIdGenerationDefinition500).thenReturn(customerMapList);
        PowerMockito.whenNew(InvoiceMapList.class).withArguments(customerMapList, addressMapList, sequenceIdGenerationDefinition2000).thenReturn(invoiceMapList);
        PowerMockito.whenNew(AuthorMapList.class).withArguments(personalDetailMapList, sequenceIdGenerationDefinition300).thenReturn(authorMapList);
        PowerMockito.whenNew(AuthorBookLinkMapList.class).withArguments(authorMapList, bookMapList, sequenceIdGenerationDefinition50).thenReturn(authorBookLinkMapList);
        PowerMockito.whenNew(SoldItemMapList.class).withArguments(invoiceMapList, itemCommonDetailMapList, sequenceIdGenerationDefinition100).thenReturn(soldItemMapList);
        PowerMockito.whenNew(WishlistMapList.class).withArguments(customerMapList, sequenceIdGenerationDefinition230).thenReturn(wishlistMapList);
        PowerMockito.whenNew(WishlistItemLinkMapList.class).withArguments(wishlistMapList, itemCommonDetailMapList, sequenceIdGenerationDefinition100).thenReturn(wishlistItemLinkMapList);
        PowerMockito.whenNew(ShoppingCartItemMapList.class).withArguments(customerMapList, itemCommonDetailMapList, sequenceIdGenerationDefinition50).thenReturn(shoppingCartItemMapList);
        PowerMockito.whenNew(PaymentDetailMapList.class).withArguments(invoiceMapList, sequenceIdGenerationDefinition1000).thenReturn(paymentDetailMapList);
        PowerMockito.whenNew(VisacardPaymentMapList.class).withArguments(paymentDetailMapList, personAddressLinkMapList, sequenceIdGenerationDefinition10).thenReturn(visacardPaymentMapList);
        PowerMockito.whenNew(MastercardPaymentMapList.class).withArguments(paymentDetailMapList, personAddressLinkMapList, sequenceIdGenerationDefinition10).thenReturn(mastercardPaymentMapList);
        PowerMockito.whenNew(AmexcardPaymentMapList.class).withArguments(paymentDetailMapList, personAddressLinkMapList, sequenceIdGenerationDefinition10).thenReturn(amexcardPaymentMapList);
        PowerMockito.whenNew(DebitcardPaymentMapList.class).withArguments(paymentDetailMapList, personAddressLinkMapList, sequenceIdGenerationDefinition10).thenReturn(debitcardPaymentMapList);
        PowerMockito.whenNew(PaypalPaymentMapList.class).withArguments(paymentDetailMapList, sequenceIdGenerationDefinition30).thenReturn(paypalPaymentMapList);
        PowerMockito.whenNew(VoucherMapList.class).withArguments(customerMapList, sequenceIdGenerationDefinition100).thenReturn(voucherMapList);
        PowerMockito.whenNew(VoucherPaymentMapList.class).withArguments(paymentDetailMapList, voucherMapList, sequenceIdGenerationDefinition10).thenReturn(voucherPaymentMapList);

        InsertQueryUnit[] expResult = new InsertQueryUnit[]{
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

        assertArrayEquals(expResult, InsertQueryUnitFactory.getInsertUnits());
    }

}
