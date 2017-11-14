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
import com.etlsolutions.examples.data.specific.person.AdministratorEntity;
import com.etlsolutions.examples.data.api.AdministratorRole;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.AdministratorPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AdministratorProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AdministratorProcessorTest {

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

    private final PersonalUsername usernameColumn = new PersonalUsername("usnameA");
    private final PersonalPassword passwordColumn = new PersonalPassword("padadnk");

    private final AdministratorEntity administratorEntity = new AdministratorEntity(personalDetail, passwordColumn, usernameColumn, AdministratorRole.OPERATOR);

    private AdministratorProcessor instance;

    @Before
    public void setUp() {
        databaseManager.clear();
        instance = new AdministratorProcessor(facade);
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
        
        AdministratorPojo expResult =  instance.save(administratorEntity);                
        assertEquals(expResult, instance.retrieve(administratorEntity));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
        assertNull(instance.retrieve(administratorEntity));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {
        PersonalDetailPojo personalDetailPojo = new PersonalDetailPojo(1, "Mr.", "Zak", "Kongs", dateOfBith, profile);
        AdministratorPojo expResult = new AdministratorPojo(0, personalDetailPojo, AdministratorRole.OPERATOR, "usnameA", "padadnk");

        AdministratorPojo result = instance.doSave(administratorEntity);
        
        assertEquals(0, result.getId());
        assertTrue(result.hasSameParameters(expResult));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {
        AdministratorPojo expResult = instance.save(administratorEntity);
        assertEquals(expResult, instance.doSave(administratorEntity));
    }
    
    /**
     * Test of save method.
     */
    @Test
    public void testSave() {
        PersonalDetailPojo personalDetailPojo = new PersonalDetailPojo(1, "Mr.", "Zak", "Kongs", dateOfBith, profile);
        AdministratorPojo expResult = new AdministratorPojo(1, personalDetailPojo, AdministratorRole.OPERATOR, "usnameA", "padadnk");
        assertTrue(expResult.hasSameParameters(instance.save(administratorEntity)));
    }
}
