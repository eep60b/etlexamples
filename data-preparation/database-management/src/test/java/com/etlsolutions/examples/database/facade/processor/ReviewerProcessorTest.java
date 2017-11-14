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
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.ReviewerEntity;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ReviewerPojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ReviewerProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ReviewerProcessorTest {

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

    private final PersonalDetail personalDetail1 = new PersonalDetailEntity(titleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, profileColumn);

    private final Reviewer reviewer1 = new ReviewerEntity(personalDetail1, new PersonalUsername("usuuser"), new PersonalPassword("q0qlfdajl1q23l4j"), new ImageBytes(new byte[]{12, 54, 33}));
    private final Reviewer reviewer2 = new ReviewerEntity(personalDetail1, new PersonalUsername("usuuser"), new PersonalPassword("q0qlfdajl1q23l4j"), new ImageBytes(new byte[]{12, 54, 33}));
    private final Reviewer reviewer3 = new ReviewerEntity(personalDetail1, new PersonalUsername("usuuser"), new PersonalPassword("la;fdinakdaljala"), new ImageBytes(new byte[]{11, 54, 33}));
    
    private final ReviewerProcessor instance = new ReviewerProcessor(facade);

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
        ReviewerPojo expResult = instance.save(reviewer1);
        assertEquals(expResult, instance.retrieve(reviewer1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(reviewer1));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        ReviewerPojo expResult = new ReviewerPojo(new PersonalDetailPojo("Mr.", "Zak", "Kongs", new Date(3210129019L), new byte[]{1, 4}), new byte[]{12, 54, 33}, "usuuser", "q0qlfdajl1q23l4j");
        ReviewerPojo result = instance.doSave(reviewer1);
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(expResult));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_Existing() {

        ReviewerPojo expResult = instance.doSave(reviewer1);
        assertEquals(expResult, instance.doSave(reviewer1));
        assertEquals(expResult, instance.doSave(reviewer2));
    }
    
    /**
     * Test of doSave method.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoSave_Exception() {

        instance.save(reviewer1);
        instance.doSave(reviewer3);
    }
}
