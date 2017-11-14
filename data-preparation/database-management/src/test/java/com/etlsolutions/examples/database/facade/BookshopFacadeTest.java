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
package com.etlsolutions.examples.database.facade;

import com.etlsolutions.examples.base.log.SystemLogger;
import com.etlsolutions.examples.data.KeyGenerator;
import com.etlsolutions.examples.data.general.TreeNode;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class BookshopFacade.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({BookshopFacade.class, KeyGenerator.class, SystemLogger.class})
public final class BookshopFacadeTest {

    private final KeyGenerator keyGenerator = PowerMockito.mock(KeyGenerator.class);
    private final SessionFactory factory = Mockito.mock(SessionFactory.class);
    private final String queryStringKey = "queryStringKey";
    private final Transaction transaction = Mockito.mock(Transaction.class);
    private final Session session = Mockito.mock(Session.class);
    private final Query query = Mockito.mock(Query.class);
    private final HibernateException hibernateException = Mockito.mock(HibernateException.class);
    private final RuntimeException runtimeException = Mockito.mock(RuntimeException.class);
    private final List<Integer> retrieveList = Arrays.asList(1183, 431, 41141);
    private final StringKeyValuePair[] keyValuePairs = {new StringKeyValuePair("iandaldada", "kankadafafa"), new StringKeyValuePair("9ada", "nakda;"), new StringKeyValuePair("nakkd", "fnflaidha")};
    private final TreeNode item1 = Mockito.mock(TreeNode.class);
    private final TreeNode item2 = Mockito.mock(TreeNode.class);
    private final TreeNode item3 = Mockito.mock(TreeNode.class);
    private final TreeNode item4 = Mockito.mock(TreeNode.class);
    private final TreeNode item5 = Mockito.mock(TreeNode.class);
    private final Object item6 = Mockito.mock(Object.class);
    private final Object[] items = {item1, item5, item6};
    private final List<Integer> saveList = Arrays.asList(1183, 431, 41141, 6665);
    @SuppressWarnings("unchecked")
    private final Class<Object> klass = Object.class;

    private List<Map<String, Object>> parameterList;
    private final InOrder inOrder = Mockito.inOrder(query, transaction, session);

    private BookshopFacade instance;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(KeyGenerator.class).withNoArguments().thenReturn(keyGenerator);
        PowerMockito.mockStatic(SystemLogger.class);

        Mockito.when(factory.openSession()).thenReturn(session);
        Mockito.when(session.beginTransaction()).thenReturn(transaction);
        Mockito.when(session.getNamedQuery(queryStringKey)).thenReturn(query);
        Mockito.when(query.executeUpdate()).thenReturn(23);
        PowerMockito.mockStatic(SystemLogger.class);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("iandaldada", "kankadafafa");
        map1.put("9ada", "nakda;");
        map1.put("nakkd", "fnflaidha");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("inl'#'a", "aanl;;;");
        map2.put("moonalll", "aiwwnnd");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("9abnadki", "inladaicn");

        parameterList = Arrays.asList(map1, map2, map3);

        Mockito.when(item1.getChildren()).thenReturn(Arrays.asList(item2, item3));
        Mockito.when(item3.getChildren()).thenReturn(Arrays.asList(item4));
        Mockito.when(item2.isLeaf()).thenReturn(Boolean.TRUE);
        Mockito.when(item3.isLeaf()).thenReturn(Boolean.FALSE);
        Mockito.when(item4.isLeaf()).thenReturn(Boolean.TRUE);
        Mockito.when(item5.isLeaf()).thenReturn(Boolean.TRUE);

        Mockito.when(session.save(item2)).thenReturn(1183);
        Mockito.when(session.save(item4)).thenReturn(431);
        Mockito.when(session.save(item5)).thenReturn(41141);
        Mockito.when(session.save(item6)).thenReturn(6665);

        instance = new BookshopFacade(factory);
    }

    /**
     * Test of executeUpdate(String queryStringKey) method.
     */
    @Test
    public void testExecuteUpdate_String() {
        assertEquals(23, instance.executeUpdate(queryStringKey));
        Mockito.verify(transaction).commit();

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "The query queryStringKey has been successfully processed.");
    }

    /**
     * Test of executeUpdate(String queryStringKey) method.
     */
    @Test(expected = HibernateException.class)
    public void testExecuteUpdate_String_HibernateException() {

        Mockito.doThrow(hibernateException).when(transaction).commit();
        try {
            instance.executeUpdate(queryStringKey);
        } catch (Exception ex) {
            Mockito.verify(transaction).rollback();
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of executeUpdate(String queryStringKey) method.
     */
    @Test(expected = RuntimeException.class)
    public void testExecuteUpdate_String_OtherException() {

        Mockito.when(session.beginTransaction()).thenThrow(runtimeException);

        try {
            instance.executeUpdate(queryStringKey);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");

            throw ex;
        }
    }

    /**
     * Test of executeUpdate(String queryStringKey) method.
     */
    @Test(expected = NullPointerException.class)
    public void testExecuteUpdate_String_NullFactory() {

        instance = new BookshopFacade(null);

        try {
            instance.executeUpdate(queryStringKey);
        } catch (Exception ex) {
            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of executeUpdate(String queryStringKey) method.
     */
    @Test(expected = NullPointerException.class)
    public void testExecuteUpdate_String_NullTransaction() {

        Mockito.when(session.beginTransaction()).thenReturn(null);
        try {
            instance.executeUpdate(queryStringKey);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of executeUpdate method.
     */
    @Test
    public void testExecuteUpdate_String_List() {

        Mockito.when(query.executeUpdate()).thenReturn(1183).thenReturn(431).thenReturn(41141);

        assertEquals(retrieveList, instance.executeUpdate(queryStringKey, parameterList));

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

        Mockito.verify(query).setParameter("iandaldada", "kankadafafa");
        Mockito.verify(query).setParameter("9ada", "nakda;");
        Mockito.verify(query).setParameter("nakkd", "fnflaidha");
        Mockito.verify(query).setParameter("inl'#'a", "aanl;;;");
        Mockito.verify(query).setParameter("moonalll", "aiwwnnd");
        Mockito.verify(query).setParameter("9abnadki", "inladaicn");
    }

    /**
     * Test of executeUpdate method.
     */
    @Test(expected = HibernateException.class)
    public void testExecuteUpdate_String_List_HibernateException() {

        Mockito.doThrow(hibernateException).when(transaction).commit();

        Mockito.when(query.executeUpdate()).thenReturn(1183).thenReturn(431).thenReturn(41141);

        try {
            instance.executeUpdate(queryStringKey, parameterList);

        } catch (Exception ex) {
            Mockito.verify(transaction).rollback();
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of executeUpdate method.
     */
    @Test(expected = RuntimeException.class)
    public void testExecuteUpdate_String_List_OtherException() {

        Mockito.when(session.beginTransaction()).thenThrow(runtimeException);

        try {
            instance.executeUpdate(queryStringKey, parameterList);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");

            throw ex;
        }
    }

    /**
     * Test of executeUpdate method.
     */
    @Test(expected = NullPointerException.class)
    public void testExecuteUpdate_String_List_NullFactory() {

        instance = new BookshopFacade(null);

        try {
            instance.executeUpdate(queryStringKey, parameterList);
        } catch (Exception ex) {
            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of executeUpdate method.
     */
    @Test(expected = NullPointerException.class)
    public void testExecuteUpdate_String_List_NullTransaction() {

        Mockito.when(session.beginTransaction()).thenReturn(null);
        try {
            instance.executeUpdate(queryStringKey, parameterList);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of retrieveList method.
     */
    @Test
    public void testRetrieveList() {

        Mockito.when(query.list()).thenReturn(retrieveList);

        assertEquals(retrieveList, instance.retrieveList(queryStringKey, keyValuePairs));

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

        inOrder.verify(query).setParameter("iandaldada", "kankadafafa");
        inOrder.verify(query).setParameter("9ada", "nakda;");
        inOrder.verify(query).setParameter("nakkd", "fnflaidha");
        inOrder.verify(transaction).commit();

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "The query queryStringKey has been successfully processed.");
    }

    /**
     * Test of retrieveList method.
     */
    @Test(expected = HibernateException.class)
    public void testRetrieveList_HibernateException() {

        Mockito.doThrow(hibernateException).when(transaction).commit();
        try {
            instance.retrieveList(queryStringKey, keyValuePairs);

        } catch (Exception ex) {
            Mockito.verify(transaction).rollback();
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of retrieveList method.
     */
    @Test(expected = RuntimeException.class)
    public void testRetrieveList_OtherException() {

        Mockito.when(session.beginTransaction()).thenThrow(runtimeException);

        try {
            instance.retrieveList(queryStringKey, keyValuePairs);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");

            throw ex;
        }
    }

    /**
     * Test of retrieveList method.
     */
    @Test(expected = NullPointerException.class)
    public void testRetrieveList_NullFactory() {

        instance = new BookshopFacade(null);

        try {
            instance.retrieveList(queryStringKey, keyValuePairs);
        } catch (Exception ex) {
            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of retrieveList method.
     */
    @Test(expected = NullPointerException.class)
    public void testRetrieveList_NullTransaction() {

        Mockito.when(session.beginTransaction()).thenReturn(null);
        try {
            instance.retrieveList(queryStringKey, keyValuePairs);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave() {

        assertEquals(saveList, instance.save(items));

        inOrder.verify(session).flush();
        inOrder.verify(session).clear();
        inOrder.verify(transaction).commit();

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "Start to save the objects.");

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "The objects have been succefully saved.");
    }

    /**
     * Test of save method.
     */
    @Test(expected = HibernateException.class)
    public void testSave_HibernateException() {

        Mockito.doThrow(hibernateException).when(transaction).commit();
        try {
            instance.save(items);

        } catch (Exception ex) {
            Mockito.verify(transaction).rollback();
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving the object.");

            throw ex;
        }
    }

    /**
     * Test of save method.
     */
    @Test(expected = RuntimeException.class)
    public void testSave_OtherException() {

        Mockito.when(session.beginTransaction()).thenThrow(runtimeException);

        try {
            instance.save(items);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving the object.");

            throw ex;
        }
    }

    /**
     * Test of save method.
     */
    @Test(expected = NullPointerException.class)
    public void testSave_NullFactory() {

        instance = new BookshopFacade(null);

        try {
            instance.save(items);
        } catch (Exception ex) {
            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving the object.");
            throw ex;
        }
    }

    /**
     * Test of save method.
     */
    @Test(expected = NullPointerException.class)
    public void testSave_NullTransaction() {

        Mockito.when(session.beginTransaction()).thenReturn(null);
        try {
            instance.save(items);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving the object.");
            throw ex;
        }
    }

    /**
     * Test of getNewId method.
     */
    @Test
    public void testGetNewId() {

        Mockito.when(keyGenerator.generateRandomKey()).thenReturn(232).thenReturn(82).thenReturn(641);

        Mockito.when(session.get(klass, 232)).thenReturn(new Object());
        Mockito.when(session.get(klass, 82)).thenReturn(new Object());
        Mockito.when(session.get(klass, 641)).thenReturn(null);

        assertEquals(641, instance.getNewId(klass));
    }

    /**
     * Test of getNewId method, of class BookshopFacade.
     */
    @Test(expected = HibernateException.class)
    public void testGetNewId_Exception() {

        Mockito.doThrow(hibernateException).when(factory).openSession();
        try {
            instance.getNewId(klass);

        } catch (Exception ex) {

            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error occured when finding the ID.");

            throw ex;
        }
    }

    /**
     * Test of getNewId method.
     */
    @Test(expected = NullPointerException.class)
    public void testGetNewId_NullFactory() {

        instance = new BookshopFacade(null);

        try {
            instance.getNewId(klass);
        } catch (Exception ex) {
            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error occured when finding the ID.");
            throw ex;
        }
    }

    /**
     * Test of saveOrUpdate method.
     */
    @Test
    public void testSaveOrUpdate() {

        instance.saveOrUpdate(items);

        inOrder.verify(session).saveOrUpdate(item2);
        inOrder.verify(session).saveOrUpdate(item4);
        inOrder.verify(session).saveOrUpdate(item5);
        inOrder.verify(session).saveOrUpdate(item6);
        inOrder.verify(session).flush();
        inOrder.verify(session).clear();
        inOrder.verify(transaction).commit();

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "Start to save or update the objects.");

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "The objects have been succefully saved or updated.");
    }

    /**
     * Test of saveOrUpdate method.
     */
    @Test(expected = HibernateException.class)
    public void testSaveOrUpdate_HibernateException() {

        Mockito.doThrow(hibernateException).when(transaction).commit();
        try {
            instance.saveOrUpdate(items);

        } catch (Exception ex) {
            Mockito.verify(transaction).rollback();
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving or updating the object.");

            throw ex;
        }
    }

    /**
     * Test of saveOrUpdate method.
     */
    @Test(expected = RuntimeException.class)
    public void testSaveOrUpdate_OtherException() {

        Mockito.when(session.beginTransaction()).thenThrow(runtimeException);

        try {
            instance.saveOrUpdate(items);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving or updating the object.");

            throw ex;
        }
    }

    /**
     * Test of saveOrUpdate method.
     */
    @Test(expected = NullPointerException.class)
    public void testSaveOrUpdate_NullFactory() {

        instance = new BookshopFacade(null);

        try {
            instance.saveOrUpdate(items);
        } catch (Exception ex) {
            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving or updating the object.");
            throw ex;
        }
    }

    /**
     * Test of saveOrUpdate method.
     */
    @Test(expected = NullPointerException.class)
    public void testSaveOrUpdate_NullTransaction() {

        Mockito.when(session.beginTransaction()).thenReturn(null);
        try {
            instance.saveOrUpdate(items);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when saving or updating the object.");

            throw ex;
        }
    }

    /**
     * Test of update method.
     */
    @Test
    public void testUpdate() {

        instance.update(items);

        inOrder.verify(session).update(item2);
        inOrder.verify(session).update(item4);
        inOrder.verify(session).update(item5);
        inOrder.verify(session).update(item6);
        inOrder.verify(session).flush();
        inOrder.verify(session).clear();
        inOrder.verify(transaction).commit();

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "Start to update the objects.");

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "The objects have been succefully updated.");

    }

    /**
     * Test of update method.
     */
    @Test(expected = HibernateException.class)
    public void testUpdate_HibernateException() {

        Mockito.doThrow(hibernateException).when(transaction).commit();
        try {
            instance.update(items);

        } catch (Exception ex) {
            Mockito.verify(transaction).rollback();
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when updating the object.");

            throw ex;
        }
    }

    /**
     * Test of update method.
     */
    @Test(expected = RuntimeException.class)
    public void testUpdate_OtherException() {

        Mockito.when(session.beginTransaction()).thenThrow(runtimeException);

        try {
            instance.update(items);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when updating the object.");

            throw ex;
        }
    }

    /**
     * Test of update method.
     */
    @Test(expected = NullPointerException.class)
    public void testUpdate_NullFactory() {

        instance = new BookshopFacade(null);

        try {
            instance.update(items);
        } catch (Exception ex) {

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when updating the object.");

            throw ex;
        }
    }

    /**
     * Test of update method.
     */
    @Test(expected = NullPointerException.class)
    public void testUpdate_NullTransaction() {

        Mockito.when(session.beginTransaction()).thenReturn(null);
        try {
            instance.update(items);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found when updating the object.");

            throw ex;
        }
    }

    /**
     * Test of executeUpdate method.
     */
    @Test
    public void testExecuteUpdate_String_StringKeyValuePairArr() {

        Mockito.when(query.executeUpdate()).thenReturn(397);

        assertTrue(instance.executeUpdate(queryStringKey, keyValuePairs) == 397);

        Mockito.verify(transaction).commit();

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

        PowerMockito.verifyStatic();
        SystemLogger.info(BookshopFacade.class, "The query queryStringKey has been successfully processed.");
    }

    /**
     * Test of executeUpdate method.
     */
    @Test(expected = HibernateException.class)
    public void testExecuteUpdate_String_StringKeyValuePairArr_HibernateException() {

        Mockito.doThrow(hibernateException).when(transaction).commit();

        try {
            instance.executeUpdate(queryStringKey, keyValuePairs);
        } catch (Exception ex) {
            Mockito.verify(transaction).rollback();
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.info(BookshopFacade.class, "Start to process the query queryStringKey.");

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of executeUpdate method.
     */
    @Test(expected = RuntimeException.class)
    public void testExecuteUpdate_String_StringKeyValuePairArr_OtherException() {

        Mockito.when(session.beginTransaction()).thenThrow(runtimeException);

        try {
            instance.executeUpdate(queryStringKey, keyValuePairs);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");

            throw ex;
        }
    }

    /**
     * Test of executeUpdate method.
     */
    @Test(expected = NullPointerException.class)
    public void testExecuteUpdate_String_StringKeyValuePairArr_NullFactory() {
   
        instance = new BookshopFacade(null);

        try {
            instance.executeUpdate(queryStringKey, keyValuePairs);
        } catch (Exception ex) {
            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of executeUpdate method, of class BookshopFacade.
     */
    @Test(expected = NullPointerException.class)
    public void testExecuteUpdate_String_StringKeyValuePairArr_NullTransaction() {


        Mockito.when(session.beginTransaction()).thenReturn(null);
        try {
            instance.executeUpdate(queryStringKey, keyValuePairs);
        } catch (Exception ex) {
            Mockito.verify(factory).close();

            PowerMockito.verifyStatic();
            SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: queryStringKey.");
            throw ex;
        }
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(new BookshopFacade(factory).hashCode(), instance.hashCode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_false() {
        SessionFactory newFactory = Mockito.mock(SessionFactory.class);
        assertNotEquals(new BookshopFacade(newFactory).hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {
        assertTrue(instance.equals(new BookshopFacade(factory)));
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_false() {
        SessionFactory newFactory = Mockito.mock(SessionFactory.class);
        assertFalse(instance.equals(new BookshopFacade(newFactory)));
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_false_null() {
        assertFalse(instance.equals(null));
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_false_other_object() {
        assertFalse(instance.equals(new Object()));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        int hashcode = instance.hashCode();
        assertEquals("BookshopFacade{hashcode=" + hashcode + '}', instance.toString());
    }
}
