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

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.Administrator;
import com.etlsolutions.examples.data.api.AmexcardPayment;
import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.AuthorBookLink;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.DebitcardPayment;
import com.etlsolutions.examples.data.api.Email;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.ItemCategoryLink;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.MastercardPayment;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PaypalPayment;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonTelephoneLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.data.api.Review;
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.data.api.ShoppingCartItem;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.data.api.VisacardPayment;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.api.VoucherPayment;
import com.etlsolutions.examples.data.api.Wishlist;
import com.etlsolutions.examples.data.api.WishlistItemLink;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.container.MapList;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.facade.processor.AddressProcessor;
import com.etlsolutions.examples.database.facade.processor.AdministratorProcessor;
import com.etlsolutions.examples.database.facade.processor.AmexcardPaymentProcessor;
import com.etlsolutions.examples.database.facade.processor.AuthorBookLinkProcessor;
import com.etlsolutions.examples.database.facade.processor.AuthorProcessor;
import com.etlsolutions.examples.database.facade.processor.BookProcessor;
import com.etlsolutions.examples.database.facade.processor.CategoryProcessor;
import com.etlsolutions.examples.database.facade.processor.CustomerProcessor;
import com.etlsolutions.examples.database.facade.processor.DebitcardPaymentProcessor;
import com.etlsolutions.examples.database.facade.processor.EmailProcessor;
import com.etlsolutions.examples.database.facade.processor.InvoiceProcessor;
import com.etlsolutions.examples.database.facade.processor.ItemCategoryLinkProcessor;
import com.etlsolutions.examples.database.facade.processor.ItemCommonDetailProcessor;
import com.etlsolutions.examples.database.facade.processor.MastercardPaymentProcessor;
import com.etlsolutions.examples.database.facade.processor.PaymentDetailProcessor;
import com.etlsolutions.examples.database.facade.processor.PaypalPaymentProcessor;
import com.etlsolutions.examples.database.facade.processor.PersonAddressLinkProcessor;
import com.etlsolutions.examples.database.facade.processor.PersonTelephoneLinkProcessor;
import com.etlsolutions.examples.database.facade.processor.PersonalDetailProcessor;
import com.etlsolutions.examples.database.facade.processor.PublisherProcessor;
import com.etlsolutions.examples.database.facade.processor.ReviewProcessor;
import com.etlsolutions.examples.database.facade.processor.ReviewerProcessor;
import com.etlsolutions.examples.database.facade.processor.ShoppingCartItemProcessor;
import com.etlsolutions.examples.database.facade.processor.SoldItemProcessor;
import com.etlsolutions.examples.database.facade.processor.TelephoneProcessor;
import com.etlsolutions.examples.database.facade.processor.VisacardPaymentProcessor;
import com.etlsolutions.examples.database.facade.processor.VoucherPaymentProcessor;
import com.etlsolutions.examples.database.facade.processor.VoucherProcessor;
import com.etlsolutions.examples.database.facade.processor.WishlistItemLinkProcessor;
import com.etlsolutions.examples.database.facade.processor.WishlistProcessor;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.AdministratorPojo;
import com.etlsolutions.examples.database.hibernate.pojo.AmexcardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.AuthorBookLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.AuthorPojo;
import com.etlsolutions.examples.database.hibernate.pojo.BookPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CategoryPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.DebitcardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.EmailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.InvoicePojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCategoryLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.MastercardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaypalPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonTelephoneLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PublisherPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ReviewPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ReviewerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ShoppingCartItemPojo;
import com.etlsolutions.examples.database.hibernate.pojo.SoldItemPojo;
import com.etlsolutions.examples.database.hibernate.pojo.TelephonePojo;
import com.etlsolutions.examples.database.hibernate.pojo.VisacardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPojo;
import com.etlsolutions.examples.database.hibernate.pojo.WishlistItemLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.WishlistPojo;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class DatabaseManager.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DatabaseManager.class, BookshopFacade.class, InsertQueryUnit.class, InsertQueryUnitFactory.class,
    AddressProcessor.class, AdministratorProcessor.class, AmexcardPaymentProcessor.class, AuthorBookLinkProcessor.class,
    AuthorProcessor.class, BookProcessor.class, CategoryProcessor.class, CustomerProcessor.class,
    DebitcardPaymentProcessor.class, EmailProcessor.class, InvoiceProcessor.class, ItemCategoryLinkProcessor.class,
    ItemCommonDetailProcessor.class, MastercardPaymentProcessor.class, PaymentDetailProcessor.class, PaypalPaymentProcessor.class,
    PersonAddressLinkProcessor.class, PersonTelephoneLinkProcessor.class, PersonalDetailProcessor.class,
    PublisherProcessor.class, ReviewProcessor.class, ReviewerProcessor.class, ShoppingCartItemProcessor.class,
    SoldItemProcessor.class, TelephoneProcessor.class, VisacardPaymentProcessor.class, VoucherPaymentProcessor.class,
    VoucherProcessor.class, WishlistItemLinkProcessor.class, WishlistProcessor.class})
public final class DatabaseManagerTest {

    private final BookshopFacade facade = PowerMockito.mock(BookshopFacade.class);
    private final BookshopFacade facade1 = PowerMockito.mock(BookshopFacade.class);
    private final MapList mapList1 = Mockito.mock(MapList.class);
    private final MapList mapList2 = Mockito.mock(MapList.class);
    @SuppressWarnings("unchecked")
    private final List<Map<String, Object>> list1 = Mockito.mock(List.class);
    @SuppressWarnings("unchecked")
    private final List<Map<String, Object>> list2 = Mockito.mock(List.class);
    private final InsertQueryUnit queryUnit1 = PowerMockito.mock(InsertQueryUnit.class);
    private final InsertQueryUnit queryUnit2 = PowerMockito.mock(InsertQueryUnit.class);
    private final InsertQueryUnit[] units = {queryUnit1, queryUnit2};
    private final SessionFactory factory = Mockito.mock(SessionFactory.class);
    private final SessionFactory factory1 = Mockito.mock(SessionFactory.class);

    private final AddressProcessor addressProcessor = PowerMockito.mock(AddressProcessor.class);
    private final Address address = Mockito.mock(Address.class);
    private final AddressPojo addressPojo = Mockito.mock(AddressPojo.class);
    private final AdministratorProcessor administratorProcessor = PowerMockito.mock(AdministratorProcessor.class);
    private final Administrator administrator = Mockito.mock(Administrator.class);
    private final AdministratorPojo administratorPojo = Mockito.mock(AdministratorPojo.class);
    private final AmexcardPaymentProcessor amexcardPaymentProcessor = PowerMockito.mock(AmexcardPaymentProcessor.class);
    private final AmexcardPayment amexcardPayment = Mockito.mock(AmexcardPayment.class);
    private final AmexcardPaymentPojo amexcardPaymentPojo = Mockito.mock(AmexcardPaymentPojo.class);
    private final AuthorBookLinkProcessor authorBookLinkProcessor = PowerMockito.mock(AuthorBookLinkProcessor.class);
    private final AuthorBookLink authorBookLink = Mockito.mock(AuthorBookLink.class);
    private final AuthorBookLinkPojo authorBookLinkPojo = Mockito.mock(AuthorBookLinkPojo.class);
    private final AuthorProcessor authorProcessor = PowerMockito.mock(AuthorProcessor.class);
    private final Author author = Mockito.mock(Author.class);
    private final AuthorPojo authorPojo = Mockito.mock(AuthorPojo.class);
    private final BookProcessor bookProcessor = PowerMockito.mock(BookProcessor.class);
    private final Book book = Mockito.mock(Book.class);
    private final BookPojo bookPojo = Mockito.mock(BookPojo.class);
    private final CategoryProcessor categoryProcessor = PowerMockito.mock(CategoryProcessor.class);
    private final Category category = Mockito.mock(Category.class);
    private final CategoryPojo categoryPojo = Mockito.mock(CategoryPojo.class);
    private final CustomerProcessor customerProcessor = PowerMockito.mock(CustomerProcessor.class);
    private final Customer customer = Mockito.mock(Customer.class);
    private final CustomerPojo customerPojo = Mockito.mock(CustomerPojo.class);
    private final DebitcardPaymentProcessor debitcardPaymentProcessor = PowerMockito.mock(DebitcardPaymentProcessor.class);
    private final DebitcardPayment debitcardPayment = Mockito.mock(DebitcardPayment.class);
    private final DebitcardPaymentPojo debitcardPaymentPojo = Mockito.mock(DebitcardPaymentPojo.class);
    private final EmailProcessor emailProcessor = PowerMockito.mock(EmailProcessor.class);
    private final Email email = Mockito.mock(Email.class);
    private final EmailPojo emailPojo = Mockito.mock(EmailPojo.class);
    private final InvoiceProcessor invoiceProcessor = PowerMockito.mock(InvoiceProcessor.class);
    private final Invoice invoice = Mockito.mock(Invoice.class);
    private final InvoicePojo invoicePojo = Mockito.mock(InvoicePojo.class);
    private final ItemCategoryLinkProcessor itemCategoryLinkProcessor = PowerMockito.mock(ItemCategoryLinkProcessor.class);
    private final ItemCategoryLink itemCategoryLink = Mockito.mock(ItemCategoryLink.class);
    private final ItemCategoryLinkPojo itemCategoryLinkPojo = Mockito.mock(ItemCategoryLinkPojo.class);
    private final ItemCommonDetailProcessor itemCommonDetailProcessor = PowerMockito.mock(ItemCommonDetailProcessor.class);
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);
    private final ItemCommonDetailPojo itemCommonDetailPojo = Mockito.mock(ItemCommonDetailPojo.class);
    private final MastercardPaymentProcessor mastercardPaymentProcessor = PowerMockito.mock(MastercardPaymentProcessor.class);
    private final MastercardPayment mastercardPayment = Mockito.mock(MastercardPayment.class);
    private final MastercardPaymentPojo mastercardPaymentPojo = Mockito.mock(MastercardPaymentPojo.class);
    private final PaymentDetailProcessor paymentDetailProcessor = PowerMockito.mock(PaymentDetailProcessor.class);
    private final PaymentDetail paymentDetail = Mockito.mock(PaymentDetail.class);
    private final PaymentDetailPojo paymentDetailPojo = Mockito.mock(PaymentDetailPojo.class);
    private final PaypalPaymentProcessor paypalPaymentProcessor = PowerMockito.mock(PaypalPaymentProcessor.class);
    private final PaypalPayment paypalPayment = Mockito.mock(PaypalPayment.class);
    private final PaypalPaymentPojo paypalPaymentPojo = Mockito.mock(PaypalPaymentPojo.class);
    private final PersonAddressLinkProcessor personAddressLinkProcessor = PowerMockito.mock(PersonAddressLinkProcessor.class);
    private final PersonAddressLink personAddressLink = Mockito.mock(PersonAddressLink.class);
    private final PersonAddressLinkPojo personAddressLinkPojo = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonTelephoneLinkProcessor personTelephoneLinkProcessor = PowerMockito.mock(PersonTelephoneLinkProcessor.class);
    private final PersonTelephoneLink personTelephoneLink = Mockito.mock(PersonTelephoneLink.class);
    private final PersonTelephoneLinkPojo personTelephoneLinkPojo = Mockito.mock(PersonTelephoneLinkPojo.class);
    private final PersonalDetailProcessor personalDetailProcessor = PowerMockito.mock(PersonalDetailProcessor.class);
    private final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);
    private final PersonalDetailPojo personalDetailPojo = Mockito.mock(PersonalDetailPojo.class);
    private final PublisherProcessor publisherProcessor = PowerMockito.mock(PublisherProcessor.class);
    private final Publisher publisher = Mockito.mock(Publisher.class);
    private final PublisherPojo publisherPojo = Mockito.mock(PublisherPojo.class);
    private final ReviewProcessor reviewProcessor = PowerMockito.mock(ReviewProcessor.class);
    private final Review review = Mockito.mock(Review.class);
    private final ReviewPojo reviewPojo = Mockito.mock(ReviewPojo.class);
    private final ReviewerProcessor reviewerProcessor = PowerMockito.mock(ReviewerProcessor.class);
    private final Reviewer reviewer = Mockito.mock(Reviewer.class);
    private final ReviewerPojo reviewerPojo = Mockito.mock(ReviewerPojo.class);
    private final ShoppingCartItemProcessor shoppingCartItemProcessor = PowerMockito.mock(ShoppingCartItemProcessor.class);
    private final ShoppingCartItem shoppingCartItem = Mockito.mock(ShoppingCartItem.class);
    private final ShoppingCartItemPojo shoppingCartItemPojo = Mockito.mock(ShoppingCartItemPojo.class);
    private final SoldItemProcessor soldItemProcessor = PowerMockito.mock(SoldItemProcessor.class);
    private final SoldItem soldItem = Mockito.mock(SoldItem.class);
    private final SoldItemPojo soldItemPojo = Mockito.mock(SoldItemPojo.class);
    private final TelephoneProcessor telephoneProcessor = PowerMockito.mock(TelephoneProcessor.class);
    private final Telephone telephone = Mockito.mock(Telephone.class);
    private final TelephonePojo telephonePojo = Mockito.mock(TelephonePojo.class);
    private final VisacardPaymentProcessor visacardPaymentProcessor = PowerMockito.mock(VisacardPaymentProcessor.class);
    private final VisacardPayment visacardPayment = Mockito.mock(VisacardPayment.class);
    private final VisacardPaymentPojo visacardPaymentPojo = Mockito.mock(VisacardPaymentPojo.class);
    private final VoucherProcessor voucherProcessor = PowerMockito.mock(VoucherProcessor.class);
    private final Voucher voucher = Mockito.mock(Voucher.class);
    private final VoucherPojo voucherPojo = Mockito.mock(VoucherPojo.class);
    private final VoucherPaymentProcessor voucherPaymentProcessor = PowerMockito.mock(VoucherPaymentProcessor.class);
    private final VoucherPayment voucherPayment = Mockito.mock(VoucherPayment.class);
    private final VoucherPaymentPojo voucherPaymentPojo = Mockito.mock(VoucherPaymentPojo.class);
    private final WishlistItemLinkProcessor wishlistItemLinkProcessor = PowerMockito.mock(WishlistItemLinkProcessor.class);
    private final WishlistItemLink wishlistItemLink = Mockito.mock(WishlistItemLink.class);
    private final WishlistItemLinkPojo wishlistItemLinkPojo = Mockito.mock(WishlistItemLinkPojo.class);
    private final WishlistProcessor wishlistProcessor = PowerMockito.mock(WishlistProcessor.class);
    private final Wishlist wishlist = Mockito.mock(Wishlist.class);
    private final WishlistPojo wishlistPojo = Mockito.mock(WishlistPojo.class);

    private final InOrder inOrder = Mockito.inOrder(facade);

    private DatabaseManager instance;
    private DatabaseManager instance0;
    private DatabaseManager instance1;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(BookshopFacade.class).withArguments(factory).thenReturn(facade);
        PowerMockito.whenNew(BookshopFacade.class).withArguments(factory1).thenReturn(facade1);
        PowerMockito.mockStatic(InsertQueryUnitFactory.class);
        Mockito.when(InsertQueryUnitFactory.getInsertUnits()).thenReturn(units);

        Mockito.when(queryUnit1.getQuery()).thenReturn("query1");
        Mockito.when(queryUnit1.getMapList()).thenReturn(mapList1);
        Mockito.when(mapList1.getMaps()).thenReturn(list1);

        Mockito.when(queryUnit2.getQuery()).thenReturn("query2");
        Mockito.when(queryUnit2.getMapList()).thenReturn(mapList2);
        Mockito.when(mapList2.getMaps()).thenReturn(list2);

        PowerMockito.whenNew(AddressProcessor.class).withArguments(facade).thenReturn(addressProcessor);
        PowerMockito.whenNew(AdministratorProcessor.class).withArguments(facade).thenReturn(administratorProcessor);
        PowerMockito.whenNew(AmexcardPaymentProcessor.class).withArguments(facade).thenReturn(amexcardPaymentProcessor);
        PowerMockito.whenNew(AuthorBookLinkProcessor.class).withArguments(facade).thenReturn(authorBookLinkProcessor);
        PowerMockito.whenNew(AuthorProcessor.class).withArguments(facade).thenReturn(authorProcessor);
        PowerMockito.whenNew(BookProcessor.class).withArguments(facade).thenReturn(bookProcessor);
        PowerMockito.whenNew(CategoryProcessor.class).withArguments(facade).thenReturn(categoryProcessor);
        PowerMockito.whenNew(CustomerProcessor.class).withArguments(facade).thenReturn(customerProcessor);
        PowerMockito.whenNew(DebitcardPaymentProcessor.class).withArguments(facade).thenReturn(debitcardPaymentProcessor);
        PowerMockito.whenNew(EmailProcessor.class).withArguments(facade).thenReturn(emailProcessor);
        PowerMockito.whenNew(InvoiceProcessor.class).withArguments(facade).thenReturn(invoiceProcessor);
        PowerMockito.whenNew(ItemCategoryLinkProcessor.class).withArguments(facade).thenReturn(itemCategoryLinkProcessor);
        PowerMockito.whenNew(ItemCommonDetailProcessor.class).withArguments(facade).thenReturn(itemCommonDetailProcessor);
        PowerMockito.whenNew(MastercardPaymentProcessor.class).withArguments(facade).thenReturn(mastercardPaymentProcessor);
        PowerMockito.whenNew(PaymentDetailProcessor.class).withArguments(facade).thenReturn(paymentDetailProcessor);
        PowerMockito.whenNew(PaypalPaymentProcessor.class).withArguments(facade).thenReturn(paypalPaymentProcessor);
        PowerMockito.whenNew(PersonAddressLinkProcessor.class).withArguments(facade).thenReturn(personAddressLinkProcessor);
        PowerMockito.whenNew(PersonTelephoneLinkProcessor.class).withArguments(facade).thenReturn(personTelephoneLinkProcessor);
        PowerMockito.whenNew(PersonalDetailProcessor.class).withArguments(facade).thenReturn(personalDetailProcessor);
        PowerMockito.whenNew(PublisherProcessor.class).withArguments(facade).thenReturn(publisherProcessor);
        PowerMockito.whenNew(ReviewProcessor.class).withArguments(facade).thenReturn(reviewProcessor);
        PowerMockito.whenNew(ReviewerProcessor.class).withArguments(facade).thenReturn(reviewerProcessor);
        PowerMockito.whenNew(ShoppingCartItemProcessor.class).withArguments(facade).thenReturn(shoppingCartItemProcessor);
        PowerMockito.whenNew(SoldItemProcessor.class).withArguments(facade).thenReturn(soldItemProcessor);
        PowerMockito.whenNew(TelephoneProcessor.class).withArguments(facade).thenReturn(telephoneProcessor);
        PowerMockito.whenNew(VisacardPaymentProcessor.class).withArguments(facade).thenReturn(visacardPaymentProcessor);
        PowerMockito.whenNew(VoucherPaymentProcessor.class).withArguments(facade).thenReturn(voucherPaymentProcessor);
        PowerMockito.whenNew(VoucherProcessor.class).withArguments(facade).thenReturn(voucherProcessor);
        PowerMockito.whenNew(WishlistItemLinkProcessor.class).withArguments(facade).thenReturn(wishlistItemLinkProcessor);
        PowerMockito.whenNew(WishlistProcessor.class).withArguments(facade).thenReturn(wishlistProcessor);

        instance = new DatabaseManager(factory);
        instance0 = new DatabaseManager(factory);
        instance1 = new DatabaseManager(factory1);
    }

    /**
     * Test of populate method.
     */
    @Test
    public void testPopulate() {
        instance.populate();

        for (String query : QueryNames.DELETE_QUERIES) {
            inOrder.verify(facade).executeUpdate(query);
        }

        inOrder.verify(facade).executeUpdate("query1", list1);
        inOrder.verify(facade).executeUpdate("query2", list2);
    }

    @Test
    public void testClear() {
        instance.clear();
        for (String query : QueryNames.DELETE_QUERIES) {
            inOrder.verify(facade).executeUpdate(query);
        }
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Address() {

        Mockito.when(addressProcessor.retrieve(address)).thenReturn(addressPojo);
        assertEquals(addressPojo, instance.retrieve(address));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Administrator() {
        Mockito.when(administratorProcessor.retrieve(administrator)).thenReturn(administratorPojo);
        assertEquals(administratorPojo, instance.retrieve(administrator));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_AmexcardPayment() {

        Mockito.when(amexcardPaymentProcessor.retrieve(amexcardPayment)).thenReturn(amexcardPaymentPojo);
        assertEquals(amexcardPaymentPojo, instance.retrieve(amexcardPayment));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_AuthorBookLink() {

        Mockito.when(authorBookLinkProcessor.retrieve(authorBookLink)).thenReturn(authorBookLinkPojo);
        assertEquals(authorBookLinkPojo, instance.retrieve(authorBookLink));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Author() {

        Mockito.when(authorProcessor.retrieve(author)).thenReturn(authorPojo);
        assertEquals(authorPojo, instance.retrieve(author));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Book() {

        Mockito.when(bookProcessor.retrieve(book)).thenReturn(bookPojo);
        assertEquals(bookPojo, instance.retrieve(book));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Category() {

        Mockito.when(categoryProcessor.retrieve(category)).thenReturn(categoryPojo);
        assertEquals(categoryPojo, instance.retrieve(category));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Customer() {

        Mockito.when(customerProcessor.retrieve(customer)).thenReturn(customerPojo);
        assertEquals(customerPojo, instance.retrieve(customer));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_DebitcardPayment() {

        Mockito.when(debitcardPaymentProcessor.retrieve(debitcardPayment)).thenReturn(debitcardPaymentPojo);
        assertEquals(debitcardPaymentPojo, instance.retrieve(debitcardPayment));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Email() {

        Mockito.when(emailProcessor.retrieve(email)).thenReturn(emailPojo);
        assertEquals(emailPojo, instance.retrieve(email));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Invoice() {

        Mockito.when(invoiceProcessor.retrieve(invoice)).thenReturn(invoicePojo);
        assertEquals(invoicePojo, instance.retrieve(invoice));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_ItemCategoryLink() {

        Mockito.when(itemCategoryLinkProcessor.retrieve(itemCategoryLink)).thenReturn(itemCategoryLinkPojo);
        assertEquals(itemCategoryLinkPojo, instance.retrieve(itemCategoryLink));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_ItemCommonDetail() {

        Mockito.when(itemCommonDetailProcessor.retrieve(itemCommonDetail)).thenReturn(itemCommonDetailPojo);
        assertEquals(itemCommonDetailPojo, instance.retrieve(itemCommonDetail));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_MastercardPayment() {

        Mockito.when(mastercardPaymentProcessor.retrieve(mastercardPayment)).thenReturn(mastercardPaymentPojo);
        assertEquals(mastercardPaymentPojo, instance.retrieve(mastercardPayment));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_PaymentDetail() {

        Mockito.when(paymentDetailProcessor.retrieve(paymentDetail)).thenReturn(paymentDetailPojo);
        assertEquals(paymentDetailPojo, instance.retrieve(paymentDetail));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_PaypalPayment() {

        Mockito.when(paypalPaymentProcessor.retrieve(paypalPayment)).thenReturn(paypalPaymentPojo);
        assertEquals(paypalPaymentPojo, instance.retrieve(paypalPayment));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_PersonAddressLink() {

        Mockito.when(personAddressLinkProcessor.retrieve(personAddressLink)).thenReturn(personAddressLinkPojo);
        assertEquals(personAddressLinkPojo, instance.retrieve(personAddressLink));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_PersonTelephoneLink() {

        Mockito.when(personTelephoneLinkProcessor.retrieve(personTelephoneLink)).thenReturn(personTelephoneLinkPojo);
        assertEquals(personTelephoneLinkPojo, instance.retrieve(personTelephoneLink));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_PersonalDetail() {

        Mockito.when(personalDetailProcessor.retrieve(personalDetail)).thenReturn(personalDetailPojo);
        assertEquals(personalDetailPojo, instance.retrieve(personalDetail));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Publisher() {

        Mockito.when(publisherProcessor.retrieve(publisher)).thenReturn(publisherPojo);
        assertEquals(publisherPojo, instance.retrieve(publisher));

    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Review() {

        Mockito.when(reviewProcessor.retrieve(review)).thenReturn(reviewPojo);
        assertEquals(reviewPojo, instance.retrieve(review));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Reviewer() {

        Mockito.when(reviewerProcessor.retrieve(reviewer)).thenReturn(reviewerPojo);
        assertEquals(reviewerPojo, instance.retrieve(reviewer));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_ShoppingCartItem() {

        Mockito.when(shoppingCartItemProcessor.retrieve(shoppingCartItem)).thenReturn(shoppingCartItemPojo);
        assertEquals(shoppingCartItemPojo, instance.retrieve(shoppingCartItem));
    }

    /**
     * Test of retrieve method, of class DatabaseManager.
     */
    @Test
    public void testRetrieve_SoldItem() {

        Mockito.when(soldItemProcessor.retrieve(soldItem)).thenReturn(soldItemPojo);
        assertEquals(soldItemPojo, instance.retrieve(soldItem));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Telephone() {

        Mockito.when(telephoneProcessor.retrieve(telephone)).thenReturn(telephonePojo);
        assertEquals(telephonePojo, instance.retrieve(telephone));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_VisacardPayment() {

        Mockito.when(visacardPaymentProcessor.retrieve(visacardPayment)).thenReturn(visacardPaymentPojo);
        assertEquals(visacardPaymentPojo, instance.retrieve(visacardPayment));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Voucher() {

        Mockito.when(voucherProcessor.retrieve(voucher)).thenReturn(voucherPojo);
        assertEquals(voucherPojo, instance.retrieve(voucher));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_VoucherPayment() {

        Mockito.when(voucherPaymentProcessor.retrieve(voucherPayment)).thenReturn(voucherPaymentPojo);
        assertEquals(voucherPaymentPojo, instance.retrieve(voucherPayment));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_WishlistItemLink() {

        Mockito.when(wishlistItemLinkProcessor.retrieve(wishlistItemLink)).thenReturn(wishlistItemLinkPojo);
        assertEquals(wishlistItemLinkPojo, instance.retrieve(wishlistItemLink));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_Wishlist() {

        Mockito.when(wishlistProcessor.retrieve(wishlist)).thenReturn(wishlistPojo);
        assertEquals(wishlistPojo, instance.retrieve(wishlist));
    }

    /**
     * Test of save(Address address) method.
     *
     * @throws Exception
     */
    @Test
    public void testSave_Address() throws Exception {

        Mockito.when(addressProcessor.save(address)).thenReturn(addressPojo);
        assertEquals(addressPojo, instance.save(address));
    }

    /**
     * Test of save method.
     *
     * @throws Exception
     */
    @Test
    public void testSave_Administrator() throws Exception {

        Mockito.when(administratorProcessor.save(administrator)).thenReturn(administratorPojo);
        assertEquals(administratorPojo, instance.save(administrator));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_AmexcardPayment() {

        Mockito.when(amexcardPaymentProcessor.save(amexcardPayment)).thenReturn(amexcardPaymentPojo);
        assertEquals(amexcardPaymentPojo, instance.save(amexcardPayment));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_AuthorBookLink() {

        Mockito.when(authorBookLinkProcessor.save(authorBookLink)).thenReturn(authorBookLinkPojo);
        assertEquals(authorBookLinkPojo, instance.save(authorBookLink));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Author() {

        Mockito.when(authorProcessor.save(author)).thenReturn(authorPojo);
        assertEquals(authorPojo, instance.save(author));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Book() {

        Mockito.when(bookProcessor.save(book)).thenReturn(bookPojo);
        assertEquals(bookPojo, instance.save(book));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Category() {

        Mockito.when(categoryProcessor.save(category)).thenReturn(categoryPojo);
        assertEquals(categoryPojo, instance.save(category));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Customer() {

        Mockito.when(customerProcessor.save(customer)).thenReturn(customerPojo);
        assertEquals(customerPojo, instance.save(customer));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_DebitcardPayment() {

        Mockito.when(debitcardPaymentProcessor.save(debitcardPayment)).thenReturn(debitcardPaymentPojo);
        assertEquals(debitcardPaymentPojo, instance.save(debitcardPayment));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Email() {

        Mockito.when(emailProcessor.save(email)).thenReturn(emailPojo);
        assertEquals(emailPojo, instance.save(email));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Invoice() {

        Mockito.when(invoiceProcessor.save(invoice)).thenReturn(invoicePojo);
        assertEquals(invoicePojo, instance.save(invoice));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_ItemCategoryLink() {

        Mockito.when(itemCategoryLinkProcessor.save(itemCategoryLink)).thenReturn(itemCategoryLinkPojo);
        assertEquals(itemCategoryLinkPojo, instance.save(itemCategoryLink));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_ItemCommonDetail() {

        Mockito.when(itemCommonDetailProcessor.save(itemCommonDetail)).thenReturn(itemCommonDetailPojo);
        assertEquals(itemCommonDetailPojo, instance.save(itemCommonDetail));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_MastercardPayment() {

        Mockito.when(mastercardPaymentProcessor.save(mastercardPayment)).thenReturn(mastercardPaymentPojo);
        assertEquals(mastercardPaymentPojo, instance.save(mastercardPayment));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_PaymentDetail() {

        Mockito.when(paymentDetailProcessor.save(paymentDetail)).thenReturn(paymentDetailPojo);
        assertEquals(paymentDetailPojo, instance.save(paymentDetail));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_PaypalPayment() {

        Mockito.when(paypalPaymentProcessor.save(paypalPayment)).thenReturn(paypalPaymentPojo);
        assertEquals(paypalPaymentPojo, instance.save(paypalPayment));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_PersonAddressLink() {

        Mockito.when(personAddressLinkProcessor.save(personAddressLink)).thenReturn(personAddressLinkPojo);
        assertEquals(personAddressLinkPojo, instance.save(personAddressLink));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_PersonTelephoneLink() {

        Mockito.when(personTelephoneLinkProcessor.save(personTelephoneLink)).thenReturn(personTelephoneLinkPojo);
        assertEquals(personTelephoneLinkPojo, instance.save(personTelephoneLink));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_PersonalDetail() {

        Mockito.when(personalDetailProcessor.save(personalDetail)).thenReturn(personalDetailPojo);
        assertEquals(personalDetailPojo, instance.save(personalDetail));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Review() {

        Mockito.when(reviewProcessor.save(review)).thenReturn(reviewPojo);
        assertEquals(reviewPojo, instance.save(review));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_ShoppingCartItem() {

        Mockito.when(shoppingCartItemProcessor.save(shoppingCartItem)).thenReturn(shoppingCartItemPojo);
        assertEquals(shoppingCartItemPojo, instance.save(shoppingCartItem));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_SoldItem() {

        Mockito.when(soldItemProcessor.save(soldItem)).thenReturn(soldItemPojo);
        assertEquals(soldItemPojo, instance.save(soldItem));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Telephone() {

        Mockito.when(telephoneProcessor.save(telephone)).thenReturn(telephonePojo);
        assertEquals(telephonePojo, instance.save(telephone));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Voucher() {

        Mockito.when(voucherProcessor.save(voucher)).thenReturn(voucherPojo);
        assertEquals(voucherPojo, instance.save(voucher));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_VoucherPayment() {

        Mockito.when(voucherPaymentProcessor.save(voucherPayment)).thenReturn(voucherPaymentPojo);
        assertEquals(voucherPaymentPojo, instance.save(voucherPayment));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_WishlistItemLink() {

        Mockito.when(wishlistItemLinkProcessor.save(wishlistItemLink)).thenReturn(wishlistItemLinkPojo);
        assertEquals(wishlistItemLinkPojo, instance.save(wishlistItemLink));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_Wishlist() {

        Mockito.when(wishlistProcessor.save(wishlist)).thenReturn(wishlistPojo);
        assertEquals(wishlistPojo, instance.save(wishlist));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance0.hashCode(), instance.hashCode());
        assertNotEquals(instance1.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance0));

        assertFalse(instance.equals(instance1));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("DatabaseManager{" + "facade=" + facade + '}', instance.toString());
    }
}
