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

import com.etlsolutions.examples.data.api.PersonTelephoneLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.PersonTelephoneLinkEntity;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.communication.AreaCode;
import com.etlsolutions.examples.data.specific.communication.CountryCode;
import com.etlsolutions.examples.data.specific.communication.TelephoneEnitity;
import com.etlsolutions.examples.data.specific.communication.TelephoneNumber;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.PersonTelephoneLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.TelephonePojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PersonTelephoneLinkProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonTelephoneLinkProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final PersonalTitle titleColumn1 = new PersonalTitle("Mr.");
    private final GivenName givenNameColumn = new GivenName("Zak");
    private final FamilyName familyNameColumn = new FamilyName("Kongs");
    private final Date dateOfBith = new Date(3210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);

    private final PersonalDetail personalDetail = new PersonalDetailEntity(titleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);

    private final CountryCode countryCodeColumn = new CountryCode("86");
    private final AreaCode areaCodeColumn = new AreaCode("10");
    private final TelephoneNumber telephoneNumberColumn = new TelephoneNumber("3574684");
    private final TelephoneEnitity telephone = new TelephoneEnitity(countryCodeColumn, areaCodeColumn, telephoneNumberColumn, TelephoneType.OFFICE);

    private final PersonTelephoneLink personTelephoneLink1 = new PersonTelephoneLinkEntity(personalDetail, telephone);
    
    private final PersonTelephoneLinkProcessor instance = new PersonTelephoneLinkProcessor(facade);

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

        PersonTelephoneLinkPojo expResult = instance.save(personTelephoneLink1);
        assertEquals(expResult, instance.retrieve(personTelephoneLink1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
        
        assertNull(instance.retrieve(personTelephoneLink1));

    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave() {
      
        PersonTelephoneLinkPojo expResult = new PersonTelephoneLinkPojo(new PersonalDetailPojo(1, "Mr.", "Zak", "Kongs", dateOfBith, profile), new TelephonePojo(1, "86", "10", TelephoneType.OFFICE, "3574684"));
        assertTrue(instance.save(personTelephoneLink1).hasSameParameters(expResult));
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave_again() {

        PersonTelephoneLinkPojo expResult = instance.save(personTelephoneLink1);
        assertEquals(expResult, instance.save(personTelephoneLink1));
    }
}
