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

import com.etlsolutions.examples.data.api.Email;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.communication.EmailAddress;
import com.etlsolutions.examples.data.specific.communication.EmailEntity;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.EmailPojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class EmailProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class EmailProcessorTest {

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
    private final EmailAddress emailAddressColumn = new EmailAddress("abc.hhj@khoon.com");
    
    private final Email email = new EmailEntity(emailAddressColumn, personalDetail);
    
    private final EmailProcessor instance = new EmailProcessor(facade);

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

        EmailPojo expResult = instance.save(email);
        assertEquals(expResult, instance.retrieve(email));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
        
        assertNull(instance.retrieve(email));
    }
    
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        EmailPojo result = instance.doSave(email);
        assertTrue(email.hasSameParameters(result));
        assertEquals(0, result.getId());
    }
    
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {

        EmailPojo expResult = instance.save(email);
        assertEquals(expResult, instance.doSave(email));
    }
}
