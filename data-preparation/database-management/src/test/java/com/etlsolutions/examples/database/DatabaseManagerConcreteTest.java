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
package com.etlsolutions.examples.database;

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAddress;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of class DatabaseManager.
 *
 * @author Zhipeng Chang
 */
public final class DatabaseManagerConcreteTest {

    private SessionFactory factory;

    private DatabaseManager instance;

    @Before
    public void setUp() {
        factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
        instance = new DatabaseManager(factory);
        instance.clear();
    }

    @After
    public void tearDown() {
        instance.clear();
    }

    /**
     * Test of save method.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testInsertAddress() throws SQLException {
        Address address1 = new AddressEntity(new AddressHouse("3321"), new AddressStreet("addressMaincloumn"), new AddressAdditionalInformation("addressAdditionalcloumn"),
                new AddressArea("hil"), new AddressCity("kity"), new AddressCountry("YN"), new AddressPostcode("alf"));

        IdentifiableAddress result = instance.save(address1);

        assertTrue(result.hasSameParameters(address1));
    }

    /**
     * Test of save method.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testInsertAddress_Multiple() throws SQLException {
        Address address1 = new AddressEntity(new AddressHouse("621"), new AddressStreet("addressMaincloumn1"), new AddressAdditionalInformation("addressAdditionalcloumn"),
                new AddressArea("hil"), new AddressCity("kity"), new AddressCountry("YN1"), new AddressPostcode("alf"));
        Address address2 = new AddressEntity(new AddressHouse("3 h"), new AddressStreet("addressMaincloumn2"), new AddressAdditionalInformation("addressAdditionalcloumn"),
                new AddressArea("hil"), new AddressCity("kity"), new AddressCountry("YN1"), new AddressPostcode("alf"));
        Address address3 = new AddressEntity(new AddressHouse("3321"), new AddressStreet("addressMaincloumn1"), new AddressAdditionalInformation("addressAdditionalcloumn"),
                new AddressArea("hil"), new AddressCity("kity"), new AddressCountry("YN2"), new AddressPostcode("alf"));

        Address address4 = new AddressEntity(new AddressHouse("3321"), new AddressStreet("addressMaincloumn2"), new AddressAdditionalInformation("addressAdditionalcloumn"),
                new AddressArea("hil"), new AddressCity("kity"), new AddressCountry("YN2"), new AddressPostcode("alf"));

        IdentifiableAddress result1 = instance.save(address1);
        IdentifiableAddress result2 = instance.save(address2);
        IdentifiableAddress result3 = instance.save(address3);
        IdentifiableAddress result4 = instance.save(address4);

        assertTrue(result1.hasSameParameters(address1));
        assertTrue(result2.hasSameParameters(address2));
        assertTrue(result3.hasSameParameters(address3));
        assertTrue(result4.hasSameParameters(address4));
    }

    /**
     * Test of save Address method.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testInsertAddress_SameObject() throws SQLException {
        Address address1 = new AddressEntity(new AddressHouse("3321"), new AddressStreet("addressMaincloumn5"), new AddressAdditionalInformation("addressAdditionalcloumn"),
                new AddressArea("hil"), new AddressCity("kity"), new AddressCountry("YN5"), new AddressPostcode("alf"));

        Address address2 = new AddressEntity(new AddressHouse("3321"), new AddressStreet("addressMaincloumn5"), new AddressAdditionalInformation("addressAdditionalcloumn"),
                new AddressArea("hil"), new AddressCity("kity"), new AddressCountry("YN5"), new AddressPostcode("alf"));

        IdentifiableAddress result1 = instance.save(address1);
        IdentifiableAddress result2 = instance.save(address2);

        assertTrue(result1.equals(result2));
    }
}
