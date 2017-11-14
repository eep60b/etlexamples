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
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.data.api.PaypalPayment;
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
import com.etlsolutions.examples.data.specific.payment.PaypalAccountId;
import com.etlsolutions.examples.data.specific.payment.PaypalIdentifyToken;
import com.etlsolutions.examples.data.specific.payment.PaypalPaymentEntity;
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
import com.etlsolutions.examples.database.hibernate.pojo.InvoicePojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailIdPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaymentDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PaypalPaymentPojo;
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
 * Test of class PaypalPaymentProcessor.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class PaypalPaymentProcessorTest {
    
    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private PaypalPayment paypalPayment1;
    private PaypalPayment paypalPayment2;
    private PaypalPayment paypalPayment3;
    
    private PaypalPaymentProcessor instance; 
    
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
        PaymentDetailEntity cardPaymentDetailEntity = new PaymentDetailEntity(invoiceEntity, new PaymentSubtotal(23.86), CurrencyCode.USD, PaymentType.PAYPAL);

        PaypalAccountId paypalAccountIdColumn = new PaypalAccountId("iandkkdla");
        PaypalIdentifyToken paypalIdentifyTokenColumn = new PaypalIdentifyToken("iandiadkk3432342");
        PaypalIdentifyToken paypalIdentifyTokenColumn3 = new PaypalIdentifyToken("ialdknkkaldkdkk3432342");
               
        paypalPayment1 = new PaypalPaymentEntity(cardPaymentDetailEntity, paypalAccountIdColumn, paypalIdentifyTokenColumn);
        paypalPayment2 = new PaypalPaymentEntity(cardPaymentDetailEntity, paypalAccountIdColumn, paypalIdentifyTokenColumn);
        paypalPayment3 = new PaypalPaymentEntity(cardPaymentDetailEntity, paypalAccountIdColumn, paypalIdentifyTokenColumn3);
        
        databaseManager.clear();
        instance = new PaypalPaymentProcessor(facade);
        
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

        PaypalPaymentPojo expResult = instance.save(paypalPayment1);
        assertEquals(expResult, instance.retrieve(paypalPayment2));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
        assertNull(instance.retrieve(paypalPayment1));
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
        PaymentDetailPojo paymentDetail = new PaymentDetailPojo(new PaymentDetailIdPojo(PaymentType.PAYPAL), invoice, new BigDecimal(23.86), CurrencyCode.USD);
        
        PaypalPaymentPojo expResult = new PaypalPaymentPojo(paymentDetail, "iandkkdla", "iandiadkk3432342");
        
        PaypalPaymentPojo result = instance.doSave(paypalPayment1);
        
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(paypalPayment1));
        assertTrue(result.hasSameParameters(expResult));
    }
    
    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_Exception() {
        
        instance.save(paypalPayment1);
        instance.doSave(paypalPayment3);
    }   
}
