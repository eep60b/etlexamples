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
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AddressProcessor.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AddressProcessorTest {

    private final SessionFactory factory = HibernateUtil.getSessionFactory("hibernate-test.cfg.xml");
    private final BookshopFacade facade = new BookshopFacade(factory);
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final AddressStreet addressMainColumn = new AddressStreet("832 llps kxy");
    private final AddressAdditionalInformation addressAdditionalColumn = new AddressAdditionalInformation("f f");
    private final AddressArea addressAreaColumn = new AddressArea("mancester");
    private final AddressCity addressCityColumn = new AddressCity("Potou");
    private final AddressCountry addressCountryColumn = new AddressCountry("UN");
    private final AddressPostcode addressPostcodeColumn = new AddressPostcode("K1432");
    private final Address address1 = new AddressEntity(new AddressHouse("3321"), addressMainColumn, addressAdditionalColumn, addressAreaColumn, addressCityColumn, addressCountryColumn, addressPostcodeColumn);
    private final Address address2 = new AddressEntity(new AddressHouse("3321"), addressMainColumn, addressAdditionalColumn, addressAreaColumn, addressCityColumn, addressCountryColumn, addressPostcodeColumn);
 
    private final AddressProcessor instance = new AddressProcessor(facade);

    @Before
    public void setUp() {
        databaseManager.clear();
    }

    @After
    public void tearDown() {
        databaseManager.clear();
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testSave() {
        
        AddressPojo expResult = new AddressPojo(1, "3321", "832 llps kxy", "f f", "Potou", "mancester", "K1432", "UN");
        assertTrue(instance.save(address1).hasSameParameters(expResult));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave() {

        AddressPojo expResult = new AddressPojo(0, "3321", "832 llps kxy", "f f", "Potou", "mancester", "K1432", "UN");
        assertEquals(expResult, instance.doSave(address1));
    }

    /**
     * Test of doSave method.
     */
    @Test
    public void testDoSave_SaveAgain() {
        
        AddressPojo expResult = instance.save(address1);
        
        assertEquals(expResult, instance.doSave(address2));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve() {
        
        instance.save(address1);
        assertTrue(instance.retrieve(address1).hasSameParameters(address1));
    }

    /**
     * Test of retrieve method.
     */
    @Test
    public void testRetrieve_null() {
       
        assertNull(instance.retrieve(address1));
    }
}
