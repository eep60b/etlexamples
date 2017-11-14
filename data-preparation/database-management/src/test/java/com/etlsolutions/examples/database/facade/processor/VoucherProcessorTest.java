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
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.data.specific.payment.ExpireDate;
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
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.CustomerPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.VoucherPojo;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class VoucherProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class VoucherProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final PersonalTitle titleColumn = new PersonalTitle("Mr.");
    private final GivenName givenNameColumn = new GivenName("Zak");
    private final FamilyName familyNameColumn = new FamilyName("Kongs");
    private final Date dateOfBith = new Date(3210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);
    private final PersonalDetail personalDetail = new PersonalDetailEntity(titleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);
    private final AddressEntity customerAddressEntry = new AddressEntity(new AddressHouse("dk9"), new AddressStreet("1 Faska Adda"), new AddressAdditionalInformation("kll l"), new AddressArea("Akrea"), new AddressCity("ciy"), new AddressCountry("UN"), new AddressPostcode("pos x"));
    private final PersonAddressLink personalAddressLink = new PersonAddressLinkEntity(customerAddressEntry, personalDetail, AddressType.CONTACT);

    private final ImageBytes imageColumn = new ImageBytes(new byte[]{68, 121, 3});
    private final PersonalUsername usernameColumn = new PersonalUsername("usnameA");
    private final PersonalPassword passwordColumn = new PersonalPassword("padadnk");

    private final CustomerEntity customer = new CustomerEntity(personalAddressLink, imageColumn, passwordColumn, usernameColumn);    
    
    private final VoucherTotal voucherTotalColumn = new VoucherTotal(new BigDecimal(45.28));
    private final VoucherToken voucherTokenColumn = new VoucherToken("KKDI-DKDA-23AK-22KK");
    private final ExpireDate expireDateColumn = new ExpireDate(new Date(219379123491834L));
    
    private final Voucher voucher1 = new VoucherEntity(customer, voucherTotalColumn, voucherTokenColumn, expireDateColumn);
    
    private final VoucherProcessor instance = new VoucherProcessor(facade);
    
    @Before
    public void setUp() {
        databaseManager.clear();        
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

        VoucherPojo expResult = instance.save(voucher1);
        assertEquals(expResult, instance.retrieve(voucher1));
    }
    
    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(voucher1));
    }    

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {
        
        AddressPojo addressPojo = new AddressPojo("dk9", "1 Faska Adda", "kll l", "ciy", "Akrea", "pos x", "UN");
        PersonalDetailPojo personalDetailPojo = new PersonalDetailPojo("Mr.", "Zak", "Kongs", dateOfBith, profile);
        
        PersonAddressLinkPojo perAddressLinkPojo = new PersonAddressLinkPojo(addressPojo, personalDetailPojo, AddressType.CONTACT);
        CustomerPojo customerPojo = new CustomerPojo(perAddressLinkPojo, "usnameA", "padadnk", new byte[]{68, 121, 3});
        VoucherPojo expResult = new VoucherPojo(customerPojo, "KKDI-DKDA-23AK-22KK", new BigDecimal(45.28), new Date(219379123491834L));   
        
        VoucherPojo result = instance.doSave(voucher1);

        assertTrue(result.hasSameParameters(expResult));
    }
    
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {
        
        VoucherPojo expResult = instance.save(voucher1);
        assertEquals(expResult, instance.doSave(voucher1));
    }    
}
