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

import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.person.AuthorEntity;
import com.etlsolutions.examples.data.specific.person.PersonalBiography;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.WebpageUrl;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.AuthorPojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AuthorProcessor.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class AuthorProcessorTest {

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
    
    private final PersonalBiography biographyColumn = new PersonalBiography(new byte[]{44, 66});
    private final WebpageUrl webpageUrlColumn = new WebpageUrl("http://www.my.page");
    private final ImageBytes imageColumn = new ImageBytes(new byte[]{33, 32});

    private final Author author = new AuthorEntity(personalDetail, biographyColumn, webpageUrlColumn, imageColumn);

    private AuthorProcessor instance;

    @Before
    public void setUp() {
        databaseManager.clear();
        instance = new AuthorProcessor(facade);
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

        AuthorPojo expResult = instance.save(author);
        assertEquals(expResult, instance.retrieve(author));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(author));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        AuthorPojo result = instance.doSave(author);
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(author));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {

        AuthorPojo expResult = instance.save(author);
        assertEquals(expResult, instance.doSave(author));
    }
}
