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

import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.data.specific.communication.AreaCode;
import com.etlsolutions.examples.data.specific.communication.CountryCode;
import com.etlsolutions.examples.data.specific.communication.TelephoneEnitity;
import com.etlsolutions.examples.data.specific.communication.TelephoneNumber;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.TelephonePojo;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class TelephoneProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class TelephoneProcessorTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final Telephone telephone = new TelephoneEnitity(new CountryCode("85"), new AreaCode("92"), new TelephoneNumber("29348282"), TelephoneType.OFFICE);

    private final TelephoneProcessor instance = new TelephoneProcessor(facade);

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

        TelephonePojo expResult = instance.save(telephone);
        assertEquals(expResult, instance.retrieve(telephone));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {

        assertNull(instance.retrieve(telephone));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        TelephonePojo result = instance.doSave(telephone);
        assertEquals(0, result.getId());
        assertTrue(telephone.hasSameParameters(result));
    }
    
    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_again() {

        TelephonePojo expResult = instance.save(telephone);
        assertEquals(expResult, instance.doSave(telephone));
    }
}
