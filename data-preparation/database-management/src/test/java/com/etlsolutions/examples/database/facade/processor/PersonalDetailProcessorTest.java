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

import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PersonalDetailProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonalDetailProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final PersonalTitle titleColumn1 = new PersonalTitle("Mr.");
    private final PersonalTitle titleColumn2 = new PersonalTitle("Mrs.");
    private final GivenName givenNameColumn = new GivenName("Zak");
    private final FamilyName familyNameColumn = new FamilyName("Kongs");
    private final Date dateOfBith = new Date(3210129019L);
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(dateOfBith);
    private final byte[] profile = {1, 4};
    private final PersonalProfile profileColumn = new PersonalProfile(profile);

    private final PersonalDetail personalDetail1 = new PersonalDetailEntity(titleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);
    private final PersonalDetail personalDetail2 = new PersonalDetailEntity(titleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);
    private final PersonalDetail personalDetail3 = new PersonalDetailEntity(titleColumn2, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);
    private final PersonalDetailEntity personalDetailEntity = new PersonalDetailEntity(
            new PersonalTitle("Mr."), new GivenName("Goeke"), new FamilyName("Gones"),
            new DateOfBirth(new Date(23819471L)), new PersonalProfile(new byte[]{1, 33}));
    private PersonalDetailProcessor instance;

    @Before
    public void setUp() {
        databaseManager.clear();
        instance = new PersonalDetailProcessor(facade);
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

        PersonalDetailPojo expResult = new PersonalDetailPojo(1, "Mr.", "Zak", "Kongs", dateOfBith, profile);

        assertTrue(expResult.hasSameParameters(instance.save(personalDetail1)));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        PersonalDetailPojo expResult = new PersonalDetailPojo(0, "Mr.", "Zak", "Kongs", dateOfBith, profile);
        assertEquals(expResult, instance.doSave(personalDetail1));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_SaveAgain() {

        PersonalDetailPojo expResult = instance.save(personalDetail1);
        assertEquals(expResult, instance.doSave(personalDetail2));
    }

    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_Exception() {

        instance.save(personalDetail1);
        instance.doSave(personalDetail3);
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {

        instance.save(personalDetail1);
        assertTrue(instance.retrieve(personalDetail1).hasSameParameters(personalDetail1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(personalDetail1));
    }

}
