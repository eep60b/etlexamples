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

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.Invoice;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.api.VoucherPayment;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.data.specific.purchase.InvoiceDate;
import com.etlsolutions.examples.data.specific.purchase.InvoiceEntity;
import com.etlsolutions.examples.data.specific.purchase.InvoiceReferenceNumber;
import com.etlsolutions.examples.data.specific.purchase.InvoiceSubtotal;
import com.etlsolutions.examples.data.specific.payment.ExpireDate;
import com.etlsolutions.examples.data.specific.payment.PaymentDetailEntity;
import com.etlsolutions.examples.data.specific.payment.PaymentSubtotal;
import com.etlsolutions.examples.data.specific.payment.VoucherPaymentEntity;
import com.etlsolutions.examples.data.specific.person.CustomerEntity;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.data.specific.payment.VoucherEntity;
import com.etlsolutions.examples.data.specific.payment.VoucherToken;
import com.etlsolutions.examples.data.specific.payment.VoucherTotal;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.InvoicePojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailIdPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class VoucherPaymentProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class VoucherPaymentProcessorTest {


    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final AddressHouse addressHouse1 = new AddressHouse("dk9");
    private final AddressStreet addressMainColumn1 = new AddressStreet("83knl2 llps kxy");
    private final AddressAdditionalInformation addressAdditionalColumn1 = new AddressAdditionalInformation("aff f");
    private final AddressArea addressAreaColumn1 = new AddressArea("manfter");
    private final AddressCity addressCityColumn1 = new AddressCity("Poafu");
    private final AddressCountry addressCountryColumn1 = new AddressCountry("UNl");
    private final AddressPostcode addressPostcodeColumn1 = new AddressPostcode("K1UV2");
    private final Address address1 = new AddressEntity(addressHouse1, addressMainColumn1, addressAdditionalColumn1, addressAreaColumn1, addressCityColumn1, addressCountryColumn1, addressPostcodeColumn1);

    private final PersonalTitle titleColumn1 = new PersonalTitle("Mr.");
    private final GivenName givenNameColumn = new GivenName("Zakc");
    private final FamilyName familyNameColumn = new FamilyName("Kongsl");
    private final Date dateOfBith = new Date(5210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4, 8};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);

    private final PersonalDetail personalDetail = new PersonalDetailEntity(titleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);

    private final PersonAddressLink personAddressLink = new PersonAddressLinkEntity(address1, personalDetail, AddressType.CONTACT);

    private final ImageBytes customerImageBytesColumn = new ImageBytes(new byte[]{1, 22, 56});
    private final PersonalPassword customerPasswordColumn = new PersonalPassword("stanangkksl");
    private final PersonalUsername customerUsernameColumn = new PersonalUsername("usnakk");
    private final Customer customer = new CustomerEntity(personAddressLink, customerImageBytesColumn, customerPasswordColumn, customerUsernameColumn);

    private final AddressHouse addressHouse2 = new AddressHouse("008s");    
    private final AddressStreet addressMainColumn2 = new AddressStreet("83nkck kxy");
    private final AddressAdditionalInformation addressAdditionalColumn2 = new AddressAdditionalInformation("vnaig");
    private final AddressArea addressAreaColumn2 = new AddressArea("fordxo");
    private final AddressCity addressCityColumn2 = new AddressCity("nkant");
    private final AddressCountry addressCountryColumn2 = new AddressCountry("IRNL");
    private final AddressPostcode addressPostcodeColumn2 = new AddressPostcode("YGGR");
    private final Address address2 = new AddressEntity(addressHouse2, addressMainColumn2, addressAdditionalColumn2, addressAreaColumn2, addressCityColumn2, addressCountryColumn2, addressPostcodeColumn2);

    private final Invoice invoice = new InvoiceEntity(customer, address2, new InvoiceDate(new Date(239248239L)), new InvoiceSubtotal(new BigDecimal(98.41)), new InvoiceReferenceNumber("einl12030aa"), InvoiceValidity.YES);
    
    private final PaymentDetail paymentDetail = new PaymentDetailEntity(invoice, new PaymentSubtotal(new BigDecimal(74.28)), CurrencyCode.USD, PaymentType.VOUCHER);
      
    private final VoucherTotal voucherTotalColumn = new VoucherTotal(new BigDecimal(45.28));
    private final VoucherToken voucherTokenColumn = new VoucherToken("KKDI-DKDA-23AK-22KK");
    private final VoucherToken voucherTokenColumn3 = new VoucherToken("KKDI-DKDA-23AK-22hh");
    private final ExpireDate expireDateColumn = new ExpireDate(new Date(219379123491834L));
    
    private final Voucher voucher = new VoucherEntity(customer, voucherTotalColumn, voucherTokenColumn, expireDateColumn);    
    private final Voucher voucher3 = new VoucherEntity(customer, voucherTotalColumn, voucherTokenColumn3, expireDateColumn); 
    
    private final VoucherPayment voucherPayment1 = new VoucherPaymentEntity(paymentDetail, voucher);
    private final VoucherPayment voucherPayment2 = new VoucherPaymentEntity(paymentDetail, voucher);
    private final VoucherPayment voucherPayment3 = new VoucherPaymentEntity(paymentDetail, voucher3);
    
    private final VoucherPaymentProcessor instance = new VoucherPaymentProcessor(facade);
    
    @Before
    public void setUp() {
        databaseManager.clear();
    }

    @After
    public void tearDown() {
        databaseManager.clear();
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave() {

        VoucherPaymentPojo expResult = new VoucherPaymentPojo(new PaymentDetailPojo(new PaymentDetailIdPojo(1, PaymentType.VOUCHER), 
                new InvoicePojo(new CustomerPojo(new PersonAddressLinkPojo( new AddressPojo("dk9", "83knl2 llps kxy", "aff f", "Poafu", "manfter", "K1UV2", "UNl"), new PersonalDetailPojo("Mr.", "Zakc", "Kongsl", new Date(5210129019L), new byte[]{1, 4, 8}), AddressType.CONTACT), "usnakk", "stanangkksl", new byte[]{1, 22, 56}), new AddressPojo("008s", "83nkck kxy", "vnaig", "nkant", "fordxo", "YGGR", "IRNL"), new Date(239248239L), new BigDecimal(98.41), InvoiceValidity.YES, "einl12030aa"), new BigDecimal(74.28), CurrencyCode.USD), 
                new VoucherPojo(new CustomerPojo(new PersonAddressLinkPojo( new AddressPojo("dk9", "83knl2 llps kxy", "aff f", "Poafu", "manfter", "K1UV2", "UNl"), new PersonalDetailPojo("Mr.", "Zakc", "Kongsl", new Date(5210129019L), new byte[]{1, 4, 8}), AddressType.CONTACT), "usnakk", "stanangkksl", new byte[]{1, 22, 56}), "KKDI-DKDA-23AK-22KK", new BigDecimal(45.28), new Date(219379123491834L)));
        assertTrue(instance.save(voucherPayment1).hasSameParameters(expResult));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_again() {

        VoucherPaymentPojo expResult = instance.save(voucherPayment1);
        assertEquals(expResult, instance.save(voucherPayment2));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(voucherPayment1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {

        VoucherPaymentPojo expResult = instance.save(voucherPayment1);
        assertEquals(expResult, instance.retrieve(voucherPayment2));
    }
}
