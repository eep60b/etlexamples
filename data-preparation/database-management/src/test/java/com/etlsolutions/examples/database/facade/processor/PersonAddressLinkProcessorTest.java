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
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zhipeng Chang
 */
public final class PersonAddressLinkProcessorTest {

    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
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

    private final PersonalDetail personalDetail1 = new PersonalDetailEntity(titleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);    
    
    private final PersonAddressLink personAddressLink1 = new PersonAddressLinkEntity(address1, personalDetail1, AddressType.CONTACT);
    private final PersonAddressLink personAddressLink2 = new PersonAddressLinkEntity(address1, personalDetail1, AddressType.CONTACT);    
    
    private PersonAddressLinkProcessor instance;

    @Before
    public void setUp() {
        databaseManager.clear();
        instance = new PersonAddressLinkProcessor(facade);
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

        PersonAddressLinkPojo expResult = new PersonAddressLinkPojo(new AddressPojo(address1), new PersonalDetailPojo(personalDetail1), AddressType.CONTACT);
        assertTrue(instance.save(personAddressLink1).hasSameParameters(expResult));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        PersonAddressLinkPojo expResult = new PersonAddressLinkPojo(new AddressPojo(address1), new PersonalDetailPojo(personalDetail1), AddressType.CONTACT);
        PersonAddressLinkPojo result = instance.doSave(personAddressLink1);
        assertTrue(result.hasSameParameters(expResult));
        assertEquals(0, result.getId());
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {

        PersonAddressLinkPojo expResult = instance.save(personAddressLink1);
        assertEquals(expResult, instance.doSave(personAddressLink2));
    }
        
    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {
        
        PersonAddressLinkPojo expResult = instance.save(personAddressLink1);
        assertEquals(expResult, instance.retrieve(personAddressLink1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(personAddressLink1));
    }

}
