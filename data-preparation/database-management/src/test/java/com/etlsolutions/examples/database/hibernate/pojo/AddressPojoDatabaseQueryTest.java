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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of class AddressPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
public final class AddressPojoDatabaseQueryTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final DatabaseManager databaseManager = new DatabaseManager(factory);
    private final AddressPojo address1 = new AddressPojo(1, "kn8s", "addressMain1", "additional", "city", "area", "postcode", "UN");
    private final AddressPojo address2 = new AddressPojo(1021, "9923", "addressMain2", "additional", "city", "area", "postcode", "UN");
    private final AddressPojo address3 = new AddressPojo(32, "392", "addressMain3", "additional", "city", "area", "postcode", "UN");
    private final AddressPojo[] addresses = {address1, address2, address3};
    private final List<Integer> generatedIds = new ArrayList<>(4);

    private Session session;
    private Transaction transaction;

    @Before
    public void setUp() {
        
        databaseManager.clear();
        try {
            session = factory.openSession();

            transaction = session.beginTransaction();

            for (AddressPojo address : addresses) {
                generatedIds.add((Integer) session.save(address));
            }
            session.flush();
            session.clear();
            transaction.commit();

            session = factory.openSession();
            transaction = session.beginTransaction();
        } catch (Throwable th) {

            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        }
    }

    @After
    public void tearDown() {
        session.flush();
        session.clear();
        transaction.commit();
        databaseManager.clear();
    }

    /**
     * Test of the query "FIND_ALL_ADDRESSES" and "DELETE_FROM_ADDRESS".
     */    
    @Test
    @SuppressWarnings("unchecked")
    public void testFindAllAddresses() {

        Query findQuery = session.getNamedQuery(QueryNames.FIND_ALL_ADDRESSES);
        @SuppressWarnings("unchecked")
        List<AddressPojo> list = findQuery.list();
        assertEquals(3, list.size());
        assertTrue(list.contains(address1));
        assertTrue(list.contains(address2));
        assertTrue(list.contains(address3));
        
        Query deleteQuery = session.getNamedQuery(QueryNames.DELETE_FROM_ADDRESS);
        assertEquals(3, deleteQuery.executeUpdate());        
        
        
        list = findQuery.list();
        assertTrue(list.isEmpty());       
    }

    /**
     * Test of the query "FIND_ALL_ADDRESS_IDS".
     */    
    @Test
    public void testFindAllAddressIds() {

        Query query = session.getNamedQuery(QueryNames.FIND_ALL_ADDRESS_IDS);

        @SuppressWarnings("unchecked")
        List<Integer> list = query.list();
        assertEquals(3, list.size());
        assertTrue(list.contains(generatedIds.get(0)));
        assertTrue(list.contains(generatedIds.get(1)));
        assertTrue(list.contains(generatedIds.get(2)));

    }
    
    /**
     * Test of the query "FIND_ADDRESS_BY_ID".
     */
    @Test
    public void testFindByAddressId() {

        Query query = session.getNamedQuery(QueryNames.FIND_BY_ADDRESS_ID);
        query.setInteger("id", generatedIds.get(2));
        @SuppressWarnings("unchecked")
        List<AddressPojo> result = query.list();

        assertEquals(1, result.size());
        assertTrue(address3.hasSameParameters(result.get(0)));
    }

    /**
     * Test of the query "INSERT_INTO_ADDRESS".
     */
    @Test
    public void testInsert() {

        Query insertQuery = session.getNamedQuery(QueryNames.INSERT_INTO_ADDRESS);
        insertQuery.setParameter("id", 251);
        insertQuery.setParameter("house", "190");
        insertQuery.setParameter("street", "Fimmy Street");
        insertQuery.setParameter("additional", "additionalY");
        insertQuery.setParameter("city", "cityQ");
        insertQuery.setParameter("area", "cityQa");
        insertQuery.setParameter("postcode", "LL57 2AA");
        insertQuery.setParameter("country", "AF");

        assertEquals(1, insertQuery.executeUpdate());
    }
}
