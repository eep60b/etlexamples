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

import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.DebitcardPayment;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentType;
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
import com.etlsolutions.examples.data.specific.payment.DebitcardPaymentEntity;
import com.etlsolutions.examples.data.specific.payment.ExpireDate;
import com.etlsolutions.examples.data.specific.payment.IssueNumber;
import com.etlsolutions.examples.data.specific.payment.PaymentCardNumber;
import com.etlsolutions.examples.data.specific.payment.PaymentDetailEntity;
import com.etlsolutions.examples.data.specific.payment.PaymentSubtotal;
import com.etlsolutions.examples.data.specific.payment.SecurityCode;
import com.etlsolutions.examples.data.specific.payment.StartDate;
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
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.DebitcardPaymentPojo;
import com.etlsolutions.examples.database.hibernate.pojo.InvoicePojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailIdPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class DebitcardPaymentProcessor.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class DebitcardPaymentProcessorTest {

    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private DebitcardPayment debitcardPayment1;
    private DebitcardPayment debitcardPayment2;
    private DebitcardPayment debitcardPayment3;
    
    private DebitcardPaymentProcessor instance; 
    
    @Before
    public void setUp() {
        
                AddressEntity customerAddressEntry = new AddressEntity(new AddressHouse("3321"), new AddressStreet("1 Faska Adda"), new AddressAdditionalInformation("kll l"), new AddressArea("Akrea"), new AddressCity("ciy"), new AddressCountry("UN"), new AddressPostcode("pos x"));
        PersonalDetailEntity customerDetailEntity = new PersonalDetailEntity(
                new PersonalTitle("Mr."), new GivenName("Goeke"), new FamilyName("Gones"),
                new DateOfBirth(new Date(23819471L)), new PersonalProfile(new byte[]{45, 32, 19, 72, 11}));
        PersonAddressLinkEntity customerPersonAddressLinkEntity = new PersonAddressLinkEntity(customerAddressEntry, customerDetailEntity, AddressType.DELIVERY);
        CustomerEntity customerEntity = new CustomerEntity(
                customerPersonAddressLinkEntity, new ImageBytes(new byte[]{59, 73, 48}),
                new PersonalPassword("passkwor"), new PersonalUsername("userkname"));

        AddressEntity dileveryAddressEntry = new AddressEntity(new AddressHouse("ku21"), new AddressStreet("1 Tafa Adda"), new AddressAdditionalInformation("emty"), new AddressArea("Area"), new AddressCity("ciy"), new AddressCountry("UN"), new AddressPostcode("pos x"));
        InvoiceEntity invoiceEntity = new InvoiceEntity(customerEntity, dileveryAddressEntry,
                new InvoiceDate(new Date(111523294320243L)), new InvoiceSubtotal(56.78), new InvoiceReferenceNumber("ref-5663924"), InvoiceValidity.YES);
        PaymentDetailEntity cardPaymentDetailEntity = new PaymentDetailEntity(invoiceEntity, new PaymentSubtotal(23.86), CurrencyCode.USD, PaymentType.AMEX_CARD);

        AddressEntity cardAddressEntry = new AddressEntity(new AddressHouse("fx1"), new AddressStreet("1 FFAA Da"), new AddressAdditionalInformation("emty"), new AddressArea("Area"), new AddressCity("ciy"), new AddressCountry("UN"), new AddressPostcode("pos x"));
        PersonalDetailEntity cardPersonalDetailEntity = new PersonalDetailEntity(new PersonalTitle("Mr"), new GivenName("Jhen"), new FamilyName("Joneps"), new DateOfBirth(new Date(1027189239134L)), new PersonalProfile(new byte[]{23, 11, 21, 123}));
        PersonAddressLinkEntity cardPersonAddressLinkEntity = new PersonAddressLinkEntity(cardAddressEntry, cardPersonalDetailEntity, AddressType.CONTACT);
        
        IssueNumber issueNumberColumn = new IssueNumber(2);
        StartDate startDateColumn = new StartDate(new Date(1212342423L));

        PaymentCardNumber paymentCardNumberColumn = new PaymentCardNumber("198232081901431");
        ExpireDate expireDateColumn = new ExpireDate(new Date(23489798713L));
        SecurityCode securityCodeColumn = new SecurityCode("967");
        SecurityCode securityCodeColumn3 = new SecurityCode("864");
        
        debitcardPayment1 = new DebitcardPaymentEntity(cardPaymentDetailEntity, cardPersonAddressLinkEntity, issueNumberColumn, startDateColumn, paymentCardNumberColumn, expireDateColumn, securityCodeColumn);
        debitcardPayment2 = new DebitcardPaymentEntity(cardPaymentDetailEntity, cardPersonAddressLinkEntity, issueNumberColumn, startDateColumn, paymentCardNumberColumn, expireDateColumn, securityCodeColumn);
        debitcardPayment3 = new DebitcardPaymentEntity(cardPaymentDetailEntity, cardPersonAddressLinkEntity, issueNumberColumn, startDateColumn, paymentCardNumberColumn, expireDateColumn, securityCodeColumn3);
        
        databaseManager.clear();
        instance = new DebitcardPaymentProcessor(facade);
        
    }

    @After
    public void tearDown() {
        databaseManager.clear();            
    }


    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {

        DebitcardPaymentPojo expResult = instance.save(debitcardPayment1);
        assertEquals(expResult, instance.retrieve(debitcardPayment2));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
        assertNull(instance.retrieve(debitcardPayment1));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {
        
        AddressPojo customerAddress = new AddressPojo("3321", "1 Faska Adda", "kll l", "ciy", "Akrea", "pos x", "UN");
        PersonalDetailPojo customerDetail = new PersonalDetailPojo("Mr.", "Goeke", "Gones", new Date(23819471L), new byte[]{45, 32, 19, 72, 11});
        PersonAddressLinkPojo customerPersonAddressLink = new PersonAddressLinkPojo(customerAddress, customerDetail, AddressType.DELIVERY);
        CustomerPojo customer = new CustomerPojo(customerPersonAddressLink,"userkname", "passkwor", new byte[]{59, 73, 48});

        AddressPojo dileveryAddress = new AddressPojo("ku21", "1 Tafa Adda", "emty", "ciy", "Area", "pos x", "UN");
        InvoicePojo invoice = new InvoicePojo(customer, dileveryAddress, new Date(111523294320243L), new BigDecimal(56.78), InvoiceValidity.YES, "ref-5663924");
        PaymentDetailPojo cardPaymentDetail = new PaymentDetailPojo(new PaymentDetailIdPojo(PaymentType.AMEX_CARD), invoice, new BigDecimal(23.86), CurrencyCode.USD);

        AddressPojo cardAddress = new AddressPojo("fx1", "1 FFAA Da", "emty", "ciy", "Area", "pos x", "UN");
        PersonalDetailPojo cardPersonalDetail = new PersonalDetailPojo("Mr", "Jhen", "Joneps", new Date(1027189239134L), new byte[]{23, 11, 21, 123});
        PersonAddressLinkPojo cardPersonAddressLink = new PersonAddressLinkPojo(cardAddress, cardPersonalDetail, AddressType.CONTACT);
        
        DebitcardPaymentPojo expResult = new DebitcardPaymentPojo(cardPersonAddressLink, cardPaymentDetail, "198232081901431", "967", 2, new Date(1212342423L), new Date(23489798713L));
        
        DebitcardPaymentPojo result = instance.doSave(debitcardPayment1);
        
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(debitcardPayment1));
        assertTrue(result.hasSameParameters(expResult));
    }
   
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_Existing() {
        
        DebitcardPaymentPojo expResult = instance.save(debitcardPayment1);
        assertEquals(expResult, instance.doSave(debitcardPayment2));
    }    
    
    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_Exception() {
        
        instance.save(debitcardPayment1);
        instance.doSave(debitcardPayment3);
    }    
}
