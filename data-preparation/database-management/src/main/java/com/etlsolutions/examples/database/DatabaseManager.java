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
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAddress;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAdministrator;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAmexcardPayment;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAuthor;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAuthorBookLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableBook;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableCategory;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableCustomer;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableDebitcardPayment;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableEmail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableInvoice;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableItemCategoryLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableItemCommonDetail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableMastercardPayment;
import com.etlsolutions.examples.data.api.identifiable.IdentifiablePaymentDetail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiablePaypalPayment;
import com.etlsolutions.examples.data.api.identifiable.IdentifiablePersonAddressLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiablePersonTelephoneLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiablePersonalDetail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiablePublisher;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableReview;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableReviewer;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableShoppingCartItem;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableSoldItem;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableTelephone;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableVisacardPayment;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableVoucher;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableVoucherPayment;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableWishlist;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableWishlistItemLink;
import com.etlsolutions.examples.data.constant.QueryNames;
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
import com.etlsolutions.examples.utility.annotation.OperationClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.util.Objects;
import org.hibernate.SessionFactory;

/**
 * The DatabaseManager class defines an object which manages the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
@ThreadSafe
@OperationClass
public final class DatabaseManager {

    private final BookshopFacade facade;

    /**
     * The internal lock used in this class. This lock should not leaked outside
     * this class to prevent deadlock.
     */
    private final Object lock = new Object();

    private final InsertQueryUnit[] units = InsertQueryUnitFactory.getInsertUnits();

    /**
     * Construct a DatabaseManager object.
     *
     * @param factory - The SessionFactory object used by this manager.
     */
    public DatabaseManager(SessionFactory factory) {
        facade = new BookshopFacade(factory);
    }

    /**
     * Populate the database. No exception or error will be thrown from this
     * method. They will be logged and the program will exit.
     *
     */
    public void populate() {
        synchronized (lock) {
            doClear();
            for (InsertQueryUnit unit : units) {
                facade.executeUpdate(unit.getQuery(), unit.getMapList().getMaps());
            }
        }
    }

    /**
     * Clear the database.
     *
     * @return how many delete queries have been executed.
     */
    public int clear() {
        synchronized (lock) {
            return doClear();
        }
    }

    private int doClear() {
        int i = 0;
        for (String query : QueryNames.DELETE_QUERIES) {
            i += facade.executeUpdate(query);
        }
        return i;
    }

    /**
     * Retrieve an IdentifiableAddress object from database using the
     * information of given address object.
     *
     * @param address - The given address object.
     * @return - the IdentifiableAddress object which has found.
     */
    public IdentifiableAddress retrieve(Address address) {
        synchronized (lock) {
            return new AddressProcessor(facade).retrieve(address);
        }
    }

    /**
     * Retrieve an object from database using the information of given
     * administrator object.
     *
     * @param administrator - The given administrator object.
     * @return - the IdentifiableAdministrator object which has been inserted.
     */
    public IdentifiableAdministrator retrieve(Administrator administrator) {
        synchronized (lock) {
            return new AdministratorProcessor(facade).retrieve(administrator);
        }
    }

    /**
     * Retrieve an object from database using the information of given
     * AmexcardPayment object.
     *
     * @param amexcardPayment - The given amexcardPayment object.
     * @return - the IdentifiableAmexcardPayment object which has been inserted.
     */
    public IdentifiableAmexcardPayment retrieve(AmexcardPayment amexcardPayment) {
        synchronized (lock) {
            return new AmexcardPaymentProcessor(facade).retrieve(amexcardPayment);
        }
    }

    /**
     * Retrieve an object from database using the information of given
     * AuthorBookLink object.
     *
     * @param authorBookLink - The given AuthorBookLink object.
     * @return - the IdentifiableAuthorBookLink object which has been inserted.
     */
    public IdentifiableAuthorBookLink retrieve(AuthorBookLink authorBookLink) {
        synchronized (lock) {
            return new AuthorBookLinkProcessor(facade).retrieve(authorBookLink);
        }
    }

    /**
     * Retrieve an object from database using the information of given Author
     * object.
     *
     * @param author - The given Author object.
     * @return - the IdentifiableAuthor object which has been inserted.
     */
    public IdentifiableAuthor retrieve(Author author) {
        synchronized (lock) {
            return new AuthorProcessor(facade).retrieve(author);
        }
    }

    /**
     * Retrieve a Book object from database using the information of given book
     * object.
     *
     * @param book - The given book object.
     * @return - the IdentifiableBook object which has been found.
     */
    public IdentifiableBook retrieve(Book book) {
        synchronized (lock) {
            return new BookProcessor(facade).retrieve(book);
        }
    }

    /**
     * Retrieve a Category object from database using the information of given
     * category object.
     *
     * @param category - The given category object.
     * @return - the IdentifiableCategory object which has been found.
     */
    public IdentifiableCategory retrieve(Category category) {
        synchronized (lock) {
            return new CategoryProcessor(facade).retrieve(category);
        }
    }

    /**
     * Retrieve an IdentifiableCustomer object from database using the
     * information of given Customer object.
     *
     * @param customer - The given Customer object.
     * @return - the IdentifiableCustomer object which has been found.
     */
    public IdentifiableCustomer retrieve(Customer customer) {
        synchronized (lock) {
            return new CustomerProcessor(facade).retrieve(customer);
        }
    }

    /**
     * Retrieve an IdentifiableDebitcardPayment object from database using the
     * information of given DebitcardPayment object.
     *
     * @param debitcardPayment - The given DebitcardPayment object.
     * @return - the IdentifiableDebitcardPayment object which has been found.
     */
    public IdentifiableDebitcardPayment retrieve(DebitcardPayment debitcardPayment) {
        synchronized (lock) {
            return new DebitcardPaymentProcessor(facade).retrieve(debitcardPayment);
        }
    }

    /**
     * Retrieve an Email object from database using the information of given
     * email object.
     *
     * @param email - The given email object.
     * @return - the IdentifiableEmail object which has been found.
     */
    public IdentifiableEmail retrieve(Email email) {
        synchronized (lock) {
            return new EmailProcessor(facade).retrieve(email);
        }
    }

    /**
     * Retrieve an Invoice object from database using the information of given
     * Invoice object.
     *
     * @param invoice - The given invoice object.
     * @return - the IdentifiableInvoice object which has been found.
     */
    public IdentifiableInvoice retrieve(Invoice invoice) {
        synchronized (lock) {
            return new InvoiceProcessor(facade).retrieve(invoice);
        }
    }

    /**
     * Retrieve an ItemCategoryLink object from database using the information
     * of given ItemCategoryLink object.
     *
     * @param itemCategoryLink - The given invoice object.
     * @return - the IdentifiableInvoice object which has been found.
     */
    public IdentifiableItemCategoryLink retrieve(ItemCategoryLink itemCategoryLink) {
        synchronized (lock) {
            return new ItemCategoryLinkProcessor(facade).retrieve(itemCategoryLink);
        }
    }

    /**
     * Retrieve an ItemCommonDetail object from database using the information
     * of given itemCommonDetail object.
     *
     * @param itemCommonDetail - The given itemCommonDetail object.
     * @return - the IdentifiableItemCommonDetail object which has been found.
     */
    public IdentifiableItemCommonDetail retrieve(ItemCommonDetail itemCommonDetail) {
        synchronized (lock) {
            return new ItemCommonDetailProcessor(facade).retrieve(itemCommonDetail);
        }
    }

    /**
     * Retrieve an IdentifiableMastercardPayment object from database using the
     * information of given DebitcardPayment object.
     *
     * @param mastercardPayment - The given MastercardPayment object.
     * @return - the IdentifiableMastercardPayment object which has been found.
     */
    public IdentifiableMastercardPayment retrieve(MastercardPayment mastercardPayment) {
        synchronized (lock) {
            return new MastercardPaymentProcessor(facade).retrieve(mastercardPayment);
        }
    }

    /**
     * Retrieve an PaymentDetail object from database using the information of
     * given payment detail object.
     *
     * @param paymentDetail - The given PaymentDetail object.
     * @return - the IdentifiablePaymentDetail object which has been found.
     */
    public IdentifiablePaymentDetail retrieve(PaymentDetail paymentDetail) {
        synchronized (lock) {
            return new PaymentDetailProcessor(facade).retrieve(paymentDetail);
        }
    }

    /**
     * Retrieve a PaypalPayment object from database using the information of
     * given paypalPayment object.
     *
     * @param paypalPayment - The given PaypalPayment object.
     * @return - the IdentifiablePaypalPayment object which has been found.
     */
    public IdentifiablePaypalPayment retrieve(PaypalPayment paypalPayment) {
        synchronized (lock) {
            return new PaypalPaymentProcessor(facade).retrieve(paypalPayment);
        }
    }

    /**
     * Retrieve a PersonAddressLink object from database using the information
     * of given personAddressLink object.
     *
     * @param personAddressLink - The given PersonAddressLink object.
     * @return - the IdentifiablePersonAddressLink object which has been found.
     */
    public IdentifiablePersonAddressLink retrieve(PersonAddressLink personAddressLink) {
        synchronized (lock) {
            return new PersonAddressLinkProcessor(facade).retrieve(personAddressLink);
        }
    }

    /**
     * Retrieve a PersonTelephoneLink object from database using the information
     * of given personTelephoneLink object.
     *
     * @param personTelephoneLink - The given PersonTelephoneLink object.
     * @return - the IdentifiablePersonTelephoneLink object which has been
     * found.
     */
    public IdentifiablePersonTelephoneLink retrieve(PersonTelephoneLink personTelephoneLink) {
        synchronized (lock) {
            return new PersonTelephoneLinkProcessor(facade).retrieve(personTelephoneLink);
        }
    }

    /**
     * Retrieve a PersonalDetail object from database using the information of
     * given personalDetail object.
     *
     * @param personalDetail - The given PersonalDetail object.
     * @return - the IdentifiablePersonalDetail object which has been found.
     */
    public IdentifiablePersonalDetail retrieve(PersonalDetail personalDetail) {
        synchronized (lock) {
            return new PersonalDetailProcessor(facade).retrieve(personalDetail);
        }
    }

    /**
     * Retrieve an Publisher object from database using the information of given
     * publisher object.
     *
     * @param publisher - The given Publisher object.
     * @return - the IdentifiablePublisher object which has been found.
     */
    public IdentifiablePublisher retrieve(Publisher publisher) {
        synchronized (lock) {
            return new PublisherProcessor(facade).retrieve(publisher);
        }
    }

    /**
     * Retrieve an Review object from database using the information of given
     * review object.
     *
     * @param review - The given Review object.
     * @return - the IdentifiableReview object which has been found.
     */
    public IdentifiableReview retrieve(Review review) {
        synchronized (lock) {
            return new ReviewProcessor(facade).retrieve(review);
        }
    }

    /**
     * Retrieve an Reviewer object from database using the information of given
     * Reviewer object.
     *
     * @param reviewer - The given Reviewer object.
     * @return - the IdentifiableReviewer object which has been found.
     */
    public IdentifiableReviewer retrieve(Reviewer reviewer) {
        synchronized (lock) {
            return new ReviewerProcessor(facade).retrieve(reviewer);
        }
    }

    /**
     * Retrieve an ShoppingCartItem object from database using the information
     * of given ShoppingCartItem object.
     *
     * @param shoppingCartItem - The given ShoppingCartItem object.
     * @return - the IdentifiableShoppingCartItem object which has been found.
     */
    public IdentifiableShoppingCartItem retrieve(ShoppingCartItem shoppingCartItem) {
        synchronized (lock) {
            return new ShoppingCartItemProcessor(facade).retrieve(shoppingCartItem);
        }
    }

    /**
     * Retrieve an SoldItem object from database using the information of given
     * SoldItem object.
     *
     * @param soldItem - The given SoldItem object.
     * @return - the IdentifiableSoldItem object which has been found.
     */
    public IdentifiableSoldItem retrieve(SoldItem soldItem) {
        synchronized (lock) {
            return new SoldItemProcessor(facade).retrieve(soldItem);
        }
    }

    /**
     * Retrieve an IdentifiableTelephone object from database using the
     * information of given Telephone object.
     *
     * @param telephone - The given Telephone object.
     * @return - the IdentifiableTelephone object which has been found.
     */
    public IdentifiableTelephone retrieve(Telephone telephone) {
        synchronized (lock) {
            return new TelephoneProcessor(facade).retrieve(telephone);
        }
    }

    /**
     * Retrieve an IdentifiableVisacardPayment object from database using the
     * information of given VisacardPayment object.
     *
     * @param visacardPayment - The given VisacardPayment object.
     * @return - the IdentifiableVoisacardPayment object which has been found.
     */
    public IdentifiableVisacardPayment retrieve(VisacardPayment visacardPayment) {
        synchronized (lock) {
            return new VisacardPaymentProcessor(facade).retrieve(visacardPayment);
        }
    }

    /**
     * Retrieve an IdentifiableVoucherPayment object from database using the
     * information of given VoucherPayment object.
     *
     * @param voucherPayment - The given VoucherPayment object.
     * @return - the IdentifiableVoucherPayment object which has been found.
     */
    public IdentifiableVoucherPayment retrieve(VoucherPayment voucherPayment) {
        synchronized (lock) {
            return new VoucherPaymentProcessor(facade).retrieve(voucherPayment);
        }
    }

    /**
     * Retrieve an IdentifiableVoucher object from database using the
     * information of given Voucher object.
     *
     * @param voucher - The given Voucher object.
     * @return - the IdentifiableVoucher object which has been found.
     */
    public IdentifiableVoucher retrieve(Voucher voucher) {
        synchronized (lock) {
            return new VoucherProcessor(facade).retrieve(voucher);
        }
    }

    /**
     * Retrieve an IdentifiableWishlistItemLink object from database using the
     * information of given WishlistItemLink object.
     *
     * @param wishlistItemLink - The given WishlistItemLink object.
     * @return - the IdentifiableWishlistItemLink object which has been found.
     */
    public IdentifiableWishlistItemLink retrieve(WishlistItemLink wishlistItemLink) {
        synchronized (lock) {
            return new WishlistItemLinkProcessor(facade).retrieve(wishlistItemLink);
        }
    }

    /**
     * Retrieve an IdentifiableWishlist object from database using the
     * information of given Wishlist object.
     *
     * @param wishlist - The given wishlist object.
     * @return - the IdentifiableWishlist object which has been found.
     */
    public IdentifiableWishlist retrieve(Wishlist wishlist) {
        synchronized (lock) {
            return new WishlistProcessor(facade).retrieve(wishlist);
        }
    }

    /**
     * Save information of the given address object into database.
     *
     * @param address - The given address object.
     * @return the IdentifiableAddress object which represents the inserted
     * entry.
     */
    public IdentifiableAddress save(Address address) {
        synchronized (lock) {
            return new AddressProcessor(facade).save(address);
        }
    }

    /**
     * Save information of the given Administrator object into database.
     *
     * @param administrator - The given Administrator object.
     * @return the IdentifiableAdministrator object which represents the
     * inserted entry.
     */
    public IdentifiableAdministrator save(Administrator administrator) {
        synchronized (lock) {
            return new AdministratorProcessor(facade).save(administrator);
        }
    }

    /**
     * Save information of the given AmexcardPayment object into database.
     *
     * @param amexcardPayment
     * @return
     */
    public IdentifiableAmexcardPayment save(AmexcardPayment amexcardPayment) {
        synchronized (lock) {
            return new AmexcardPaymentProcessor(facade).save(amexcardPayment);
        }
    }

    /**
     * Save information of the given AuthorBookLink object into database.
     *
     * @param authorBookLink - The AuthorBookLink object.
     * @return
     */
    public IdentifiableAuthorBookLink save(AuthorBookLink authorBookLink) {
        synchronized (lock) {
            return new AuthorBookLinkProcessor(facade).save(authorBookLink);
        }
    }

    /**
     * Save information of the given Author object into database.
     *
     * @param author - The specified Author object.
     * @return
     */
    public IdentifiableAuthor save(Author author) {
        synchronized (lock) {
            return new AuthorProcessor(facade).save(author);
        }
    }

    /**
     *
     * @param book
     * @return
     */
    public IdentifiableBook save(Book book) {
        synchronized (lock) {
            return new BookProcessor(facade).save(book);
        }
    }

    /**
     *
     * @param category
     * @return
     */
    public IdentifiableCategory save(Category category) {
        synchronized (lock) {
            return new CategoryProcessor(facade).save(category);
        }
    }

    /**
     * Save the given Customer object in the database.
     *
     * @param customer - The given Customer object.
     * @return
     */
    public IdentifiableCustomer save(Customer customer) {
        synchronized (lock) {
            return new CustomerProcessor(facade).save(customer);
        }
    }

    /**
     * Save the given DebitcardPayment object in the database.
     *
     * @param debitcardPayment - The given DebitcardPayment object.
     * @return the IdentifiableDebitcardPayment object which represents the
     * saved object.
     */
    public IdentifiableDebitcardPayment save(DebitcardPayment debitcardPayment) {
        synchronized (lock) {
            return new DebitcardPaymentProcessor(facade).save(debitcardPayment);
        }
    }

    /**
     *
     * @param email
     * @return
     */
    public IdentifiableEmail save(Email email) {
        synchronized (lock) {
            return new EmailProcessor(facade).save(email);
        }
    }

    /**
     *
     * @param invoice
     * @return
     */
    public IdentifiableInvoice save(Invoice invoice) {
        synchronized (lock) {
            return new InvoiceProcessor(facade).save(invoice);
        }
    }

    /**
     *
     * @param itemCategoryLink
     * @return
     */
    public IdentifiableItemCategoryLink save(ItemCategoryLink itemCategoryLink) {
        synchronized (lock) {
            return new ItemCategoryLinkProcessor(facade).save(itemCategoryLink);
        }
    }

    /**
     *
     * @param itemCommonDetail
     * @return
     */
    public IdentifiableItemCommonDetail save(ItemCommonDetail itemCommonDetail) {
        synchronized (lock) {
            return new ItemCommonDetailProcessor(facade).save(itemCommonDetail);
        }
    }

    /**
     *
     * @param mastercardPayment
     * @return
     */
    public IdentifiableMastercardPayment save(MastercardPayment mastercardPayment) {
        synchronized (lock) {
            return new MastercardPaymentProcessor(facade).save(mastercardPayment);
        }
    }

    /**
     *
     * @param paymentDetail
     * @return
     */
    public IdentifiablePaymentDetail save(PaymentDetail paymentDetail) {
        synchronized (lock) {
            return new PaymentDetailProcessor(facade).save(paymentDetail);
        }
    }


    /**
     *
     * @param paypalPayment
     * @return
     */
    public IdentifiablePaypalPayment save(PaypalPayment paypalPayment) {
        synchronized (lock) {
            return new PaypalPaymentProcessor(facade).save(paypalPayment);
        }
    }    
    
    /**
     *
     * @param personAddressLink
     * @return
     */
    public IdentifiablePersonAddressLink save(PersonAddressLink personAddressLink) {
        synchronized (lock) {
            return new PersonAddressLinkProcessor(facade).save(personAddressLink);
        }
    }

    /**
     *
     * @param personTelephoneLink
     * @return
     */
    public IdentifiablePersonTelephoneLink save(PersonTelephoneLink personTelephoneLink) {
        synchronized (lock) {
            return new PersonTelephoneLinkProcessor(facade).save(personTelephoneLink);
        }
    }

    /**
     *
     * @param personalDetail
     * @return
     */
    public IdentifiablePersonalDetail save(PersonalDetail personalDetail) {
        synchronized (lock) {
            return new PersonalDetailProcessor(facade).save(personalDetail);
        }
    }

    /**
     *
     * @param review
     * @return
     */
    public IdentifiableReview save(Review review) {
        synchronized (lock) {
            return new ReviewProcessor(facade).save(review);
        }
    }

    /**
     *
     * @param shoppingCartItem
     * @return
     */
    public IdentifiableShoppingCartItem save(ShoppingCartItem shoppingCartItem) {
        synchronized (lock) {
            return new ShoppingCartItemProcessor(facade).save(shoppingCartItem);
        }
    }

    /**
     *
     * @param soldItem
     * @return
     */
    public IdentifiableSoldItem save(SoldItem soldItem) {
        synchronized (lock) {
            return new SoldItemProcessor(facade).save(soldItem);
        }
    }

    /**
     * Save the given Telephone object in the database.
     *
     * @param telephone - The given Telephone object.
     * @return an IdentifialbeTelephone to represent the saved object.
     */
    public IdentifiableTelephone save(Telephone telephone) {
        synchronized (lock) {
            return new TelephoneProcessor(facade).save(telephone);
        }
    }

    /**
     * Save the given VoucherPayment object in the database.
     *
     * @param voucherPayment - The given VoucherPayment object.
     * @return an IdentifialbeVoucherPayment to represent the saved object.
     */
    public IdentifiableVoucherPayment save(VoucherPayment voucherPayment) {
        synchronized (lock) {
            return new VoucherPaymentProcessor(facade).save(voucherPayment);
        }
    }

    /**
     *
     * @param voucher
     * @return
     */
    public IdentifiableVoucher save(Voucher voucher) {
        synchronized (lock) {
            return new VoucherProcessor(facade).save(voucher);
        }
    }

    /**
     *
     * @param wishlistItemLink
     * @return
     */
    public IdentifiableWishlistItemLink save(WishlistItemLink wishlistItemLink) {
        synchronized (lock) {
            return new WishlistItemLinkProcessor(facade).save(wishlistItemLink);
        }
    }

    /**
     *
     * @param wishlist
     * @return
     */
    public IdentifiableWishlist save(Wishlist wishlist) {
        synchronized (lock) {
            return new WishlistProcessor(facade).save(wishlist);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.facade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final DatabaseManager other = (DatabaseManager) obj;

        return Objects.equals(this.facade, other.facade);
    }

    @Override
    public String toString() {
        return "DatabaseManager{" + "facade=" + facade + '}';
    }
}
