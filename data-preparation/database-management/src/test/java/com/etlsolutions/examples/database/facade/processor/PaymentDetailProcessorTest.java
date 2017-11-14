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
import com.etlsolutions.examples.data.specific.payment.PaymentDetailEntity;
import com.etlsolutions.examples.data.specific.payment.PaymentSubtotal;
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
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PaymentDetailProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PaymentDetailProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final AddressStreet addressMainColumn1 = new AddressStreet("83knl2 llps kxy");
    private final AddressAdditionalInformation addressAdditionalColumn1 = new AddressAdditionalInformation("aff f");
    private final AddressArea addressAreaColumn1 = new AddressArea("manfter");
    private final AddressCity addressCityColumn1 = new AddressCity("Poafu");
    private final AddressCountry addressCountryColumn1 = new AddressCountry("UNl");
    private final AddressPostcode addressPostcodeColumn1 = new AddressPostcode("K1UV2");
    private final Address address1 = new AddressEntity(new AddressHouse("dk9"), addressMainColumn1, addressAdditionalColumn1, addressAreaColumn1, addressCityColumn1, addressCountryColumn1, addressPostcodeColumn1);

    private final PersonalTitle titleColumn1 = new PersonalTitle("Mr.");
    private final GivenName givenNameColumn = new GivenName("Zakc");
    private final FamilyName familyNameColumn = new FamilyName("Kongsl");
    private final Date dateOfBith = new Date(5210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4, 8};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);

    private final PersonalDetail personalDetail = new PersonalDetailEntity(titleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);

    private final PersonAddressLink personAddressLink = new PersonAddressLinkEntity(address1, personalDetail, AddressType.CONTACT);

    private final ImageBytes customerImaBytesColumn = new ImageBytes(new byte[]{1, 22, 56});
    private final PersonalPassword customerPasswordColumn = new PersonalPassword("stanangkksl");
    private final PersonalUsername customerUsernameColumn = new PersonalUsername("usnakk");
    private final Customer customer = new CustomerEntity(personAddressLink, customerImaBytesColumn, customerPasswordColumn, customerUsernameColumn);

    private final AddressStreet addressMainColumn2 = new AddressStreet("83nkck kxy");
    private final AddressAdditionalInformation addressAdditionalColumn2 = new AddressAdditionalInformation("vnaig");
    private final AddressArea addressAreaColumn2 = new AddressArea("fordxo");
    private final AddressCity addressCityColumn2 = new AddressCity("nkant");
    private final AddressCountry addressCountryColumn2 = new AddressCountry("IRNL");
    private final AddressPostcode addressPostcodeColumn2 = new AddressPostcode("YGGR");
    private final Address address2 = new AddressEntity(new AddressHouse("008s"), addressMainColumn2, addressAdditionalColumn2, addressAreaColumn2, addressCityColumn2, addressCountryColumn2, addressPostcodeColumn2);

    private final Invoice invoice1 = new InvoiceEntity(customer, address2, new InvoiceDate(new Date(239248239L)), new InvoiceSubtotal(new BigDecimal(98.41)), new InvoiceReferenceNumber("einl12030aa"), InvoiceValidity.YES);
    private final Invoice invoice2 = new InvoiceEntity(customer, address2, new InvoiceDate(new Date(239248239L)), new InvoiceSubtotal(new BigDecimal(98.41)), new InvoiceReferenceNumber("kadna319913"), InvoiceValidity.NO);

    
    private final PaymentDetail paymentDetail1 = new PaymentDetailEntity(invoice1, new PaymentSubtotal(new BigDecimal(74.28)), CurrencyCode.USD, PaymentType.MASTER_CARD);
    private final PaymentDetail paymentDetail2 = new PaymentDetailEntity(invoice2, new PaymentSubtotal(new BigDecimal(74.28)), CurrencyCode.BRP, PaymentType.PAYPAL);
    
    private final PaymentDetailProcessor instance = new PaymentDetailProcessor(facade);

    @Before
    public void setUp() {
        databaseManager.clear();
    }

    @After
    public void tearDown() {
        databaseManager.clear();
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testSave() {

        PaymentDetailPojo result = instance.save(paymentDetail1);
        assertTrue(paymentDetail1.hasSameParameters(result));
        assertTrue(result.getId() > 0);
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testSave_again() {

        PaymentDetailPojo expResult = instance.save(paymentDetail1);
        assertEquals(expResult, instance.save(paymentDetail1));
    }


    /**
     * Test of doSave method.
     */
    @Test
    public void testSave_two() {

        PaymentDetailPojo expResult1 = instance.save(paymentDetail1);
        PaymentDetailPojo expResult2 = instance.save(paymentDetail2);
        
        assertEquals(expResult1, instance.save(paymentDetail1));        
        assertEquals(expResult2, instance.save(paymentDetail2));
    }    
    
    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {

        PaymentDetailPojo expResult = instance.save(paymentDetail1);
        assertEquals(expResult, instance.retrieve(paymentDetail1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieveNull() {

        assertNull(instance.retrieve(paymentDetail1));
    }
}
