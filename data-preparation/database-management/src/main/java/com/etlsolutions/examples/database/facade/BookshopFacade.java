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
import com.etlsolutions.examples.utility.annotation.OperationClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * The BookshopFacade class is designed following the facade pattern. It is used
 * to execute database queries.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - Add throw IllegalStateException for errors.
 */
@ThreadSafe
@OperationClass
public final class BookshopFacade {

    private final KeyGenerator keyGenerator = new KeyGenerator();
    private final SessionFactory factory;
    private final Object lock = new Object();

    /**
     * Construct a BookshopFacade object.
     *
     * @param factory - The SessionFactory object used to generate session. It
     * is must have a valid connection and must be open. The factory will not be
     * closed after this operation.
     */
    public BookshopFacade(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Execute a single query without any parameters. If an error occurs, the
     * database will be rolled back.
     *
     * @param queryStringKey - The question string key.
     * @return the number of entities updated or deleted.
     */
    public int executeUpdate(String queryStringKey) {
        synchronized (lock) {
            SystemLogger.info(BookshopFacade.class, "Start to process the query " + queryStringKey + ".");
            Transaction transaction = null;

            try {
                Session session = factory.openSession();
                transaction = session.beginTransaction();
                Query query = session.getNamedQuery(queryStringKey);
                int i = query.executeUpdate();
                transaction.commit();
                SystemLogger.info(BookshopFacade.class, "The query " + queryStringKey + " has been successfully processed.");
                return i;

            } catch (Throwable ex) {

                SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: " + queryStringKey + ".");

                if (transaction != null) {
                    try {
                        transaction.rollback();
                    } catch (Throwable th2) {

                        if (factory != null) {
                            factory.close();
                        }
                        throw th2;
                    }
                }

                if (factory != null) {
                    factory.close();
                }
                throw ex;
            }
        }
    }

    /**
     * Execute a single query with parameters. Each parameter set is provided by
     * a map of key/value pairs. The map is provided in a list. The execution
     * will continue until all the parameters in the list is used. If an error
     * occurs, the database will be rolled back.
     *
     * @param queryStringKey - The question string key.
     * @param parameterList - The parameter map list.
     * @return a list of the number of entities updated or deleted. each number
     * is corresponding to a parameter map.
     */
    public List<Integer> executeUpdate(String queryStringKey, List<Map<String, Object>> parameterList) {
        synchronized (lock) {
            SystemLogger.info(BookshopFacade.class, "Start to process the query " + queryStringKey + ".");
            Transaction transaction = null;

            try {
                List<Integer> list = new ArrayList<>();
                Session session = factory.openSession();
                transaction = session.beginTransaction();
                Query insertQuery = session.getNamedQuery(queryStringKey);

                parameterList.stream().map((parameterMap) -> {
                    Set<String> parameterNames = parameterMap.keySet();
                    parameterNames.stream().forEach((parameterName) -> {
                        insertQuery.setParameter(parameterName, parameterMap.get(parameterName));
                    });
                    return parameterMap;
                }).forEach((item) -> {
                    int i = insertQuery.executeUpdate();
                    list.add(i);
                });

                transaction.commit();

                SystemLogger.info(BookshopFacade.class, "The query " + queryStringKey + " has been successfully processed.");
                return list;

            } catch (Throwable th) {

                SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: " + queryStringKey + ".");

                if (transaction != null) {
                    try {
                        transaction.rollback();
                    } catch (Throwable th2) {

                        if (factory != null) {
                            factory.close();
                        }
                        throw th2;
                    }
                }

                if (factory != null) {
                    factory.close();
                }
                throw th;
            }
        }
    }

    /**
     * Execute a single query with parameters. Each parameter set is provided by
     * a map of key/value pairs. The map is provided in a list. The execution
     * will continue until all the parameters in the list is used. If an error
     * occurs, the database will be rolled back.
     *
     * @param queryStringKey - The question string key.
     * @param parameterList - The parameter map list.
     * @return a list of the number of entities updated or deleted. each number
     * is corresponding to a parameter map.
     */
    /**
     * Execute a single query with parameters.Each parameter set is provided by
     * a few key/value pairs. The execution will continue until all the
     * parameters in the list is used. If an error occurs, the database will be
     * rolled back.
     *
     * @param queryStringKey - The question string key.
     * @param keyValuePairs - The parameter key/value pairs
     * @return a list of the number of entities updated or deleted. each number
     * is corresponding to a parameter map.
     */
    public Integer executeUpdate(String queryStringKey, StringKeyValuePair... keyValuePairs) {
        synchronized (lock) {
            SystemLogger.info(BookshopFacade.class, "Start to process the query " + queryStringKey + ".");
            Transaction transaction = null;

            try {
                Session session = factory.openSession();
                transaction = session.beginTransaction();
                Query insertQuery = session.getNamedQuery(queryStringKey);

                for (StringKeyValuePair keyValuePair : keyValuePairs) {
                    insertQuery.setParameter(keyValuePair.getKey(), keyValuePair.getValue());
                }

                int i = insertQuery.executeUpdate();

                transaction.commit();

                SystemLogger.info(BookshopFacade.class, "The query " + queryStringKey + " has been successfully processed.");
                return i;

            } catch (Throwable th) {

                SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: " + queryStringKey + ".");

                if (transaction != null) {
                    try {
                        transaction.rollback();
                    } catch (Throwable th2) {

                        if (factory != null) {
                            factory.close();
                        }
                        throw th2;
                    }
                }

                if (factory != null) {
                    factory.close();
                }
                throw th;
            }
        }
    }

    /**
     * Retrieve a list of objects from the database using the specified query
     * and parameters.
     *
     * @param <T> - The object type.
     * @param queryStringKey - The query string.
     * @param keyValuePairs - The key-value pairs which contain the values for
     * columns.
     * @return the object list.
     */
    public <T> List<T> retrieveList(String queryStringKey, StringKeyValuePair... keyValuePairs) {
        synchronized (lock) {
            SystemLogger.info(BookshopFacade.class, "Start to process the query " + queryStringKey + ".");
            Transaction transaction = null;

            try {
                Session session = factory.openSession();
                transaction = session.beginTransaction();
                Query query = session.getNamedQuery(queryStringKey);

                for (StringKeyValuePair keyValuePair : keyValuePairs) {
                    query.setParameter(keyValuePair.getKey(), keyValuePair.getValue());
                }

                @SuppressWarnings("unchecked")
                List<T> list = query.list();

                transaction.commit();

                SystemLogger.info(BookshopFacade.class, "The query " + queryStringKey + " has been successfully processed.");
                return list;

            } catch (Throwable th) {

                SystemLogger.fatal(BookshopFacade.class, "Error found during the excution of query: " + queryStringKey + ".");

                if (transaction != null) {
                    try {
                        transaction.rollback();
                    } catch (Throwable th2) {

                        if (factory != null) {
                            factory.close();
                        }
                        throw th2;
                    }
                }

                if (factory != null) {
                    factory.close();
                }
                throw th;
            }
        }
    }

    /**
     * Save the given items into the database.
     *
     * @param items - The given items.
     * @return the list of generated IDs.
     */
    public List<Object> save(Object... items) {
        synchronized (lock) {
            SystemLogger.info(BookshopFacade.class, "Start to save the objects.");
            Transaction transaction = null;
            try {
                List<Object> list = new ArrayList<>(items.length);
                Session session = factory.openSession();
                transaction = session.beginTransaction();

                for (Object item : items) {

                    list.addAll(saveItem(item, session));
                }
                session.flush();
                session.clear();

                transaction.commit();
                SystemLogger.info(BookshopFacade.class, "The objects have been succefully saved.");
                return list;
            } catch (Throwable ex) {

                SystemLogger.fatal(BookshopFacade.class, "Error found when saving the object.");

                if (transaction != null) {
                    try {
                        transaction.rollback();
                    } catch (Throwable th2) {

                        if (factory != null) {
                            factory.close();
                        }
                        throw th2;
                    }
                }

                if (factory != null) {
                    factory.close();
                }
                throw ex;
            }
        }
    }

    private List<Object> saveItem(Object item, Session session) {

        if (item instanceof TreeNode) {
            return saveItem((TreeNode) item, session);
        }

        return Arrays.asList(session.save(item));
    }

    private List<Object> saveItem(TreeNode item, Session session) {

        if (item.isLeaf()) {
            return Arrays.asList(session.save(item));
        }

        List<Object> list = new ArrayList<>();

        item.getChildren().stream().forEach((child) -> {
            list.addAll(saveItem(child, session));
        });

        return list;
    }

    /**
     * Save or update the given items into database.
     *
     * @param items - The given items.
     */
    public void saveOrUpdate(Object... items) {
        synchronized (lock) {
            SystemLogger.info(BookshopFacade.class, "Start to save or update the objects.");
            Transaction transaction = null;
            try {

                Session session = factory.openSession();
                transaction = session.beginTransaction();

                for (Object item : items) {

                    saveOrUpdateItem(item, session);
                }
                session.flush();
                session.clear();

                transaction.commit();
                SystemLogger.info(BookshopFacade.class, "The objects have been succefully saved or updated.");

            } catch (Throwable ex) {

                SystemLogger.fatal(BookshopFacade.class, "Error found when saving or updating the object.");

                if (transaction != null) {
                    try {
                        transaction.rollback();
                    } catch (Throwable th2) {

                        if (factory != null) {
                            factory.close();
                        }
                        throw th2;
                    }
                }

                if (factory != null) {
                    factory.close();
                }
                throw ex;
            }
        }
    }

    private void saveOrUpdateItem(Object item, Session session) {

        if (item instanceof TreeNode) {
            saveOrUpdateItem((TreeNode) item, session);
            return;
        }

        session.saveOrUpdate(item);
    }

    private void saveOrUpdateItem(TreeNode item, Session session) {

        if (item.isLeaf()) {
            session.saveOrUpdate(item);
            return;
        }

        item.getChildren().stream().forEach((child) -> {
            saveOrUpdateItem(child, session);
        });
    }

    /**
     * Update the given items into database.
     *
     * @param items - The given items.
     */
    public void update(Object... items) {
        synchronized (lock) {
            SystemLogger.info(BookshopFacade.class, "Start to update the objects.");
            Transaction transaction = null;
            try {

                Session session = factory.openSession();
                transaction = session.beginTransaction();

                for (Object item : items) {

                    updateItem(item, session);
                }
                session.flush();
                session.clear();

                transaction.commit();
                SystemLogger.info(BookshopFacade.class, "The objects have been succefully updated.");

            } catch (Throwable ex) {

                SystemLogger.fatal(BookshopFacade.class, "Error found when updating the object.");

                if (transaction != null) {
                    try {
                        transaction.rollback();
                    } catch (Throwable th2) {

                        if (factory != null) {
                            factory.close();
                        }
                        throw th2;
                    }
                }

                if (factory != null) {
                    factory.close();
                }
                throw ex;
            }
        }
    }

    private void updateItem(Object item, Session session) {

        if (item instanceof TreeNode) {
            updateItem((TreeNode) item, session);
            return;
        }

        session.update(item);
    }

    private void updateItem(TreeNode item, Session session) {

        if (item.isLeaf()) {
            session.update(item);
            return;
        }

        item.getChildren().stream().forEach((child) -> {
            updateItem(child, session);
        });
    }

    /**
     * Get the new ID for the specified POJO type. When a POJO type is given,
     * Hibernate will look for an unused ID number in the corresponding table
     * and return it.
     *
     * @param <T> - The POJO type.
     * @param klass - The POJO class.
     * @return - The new ID.
     */
    public <T> int getNewId(Class<T> klass) {
        synchronized (lock) {
            try (Session session = factory.openSession()) {

                while (true) {
                    int i = keyGenerator.generateRandomKey();
                    if (session.get(klass, i) == null) {
                        return i;
                    }
                }
            } catch (Throwable ex) {

                SystemLogger.fatal(BookshopFacade.class, "Error occured when finding the ID.");

                if (factory != null) {
                    factory.close();
                }

                throw ex;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.factory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final BookshopFacade other = (BookshopFacade) obj;
        return Objects.equals(this.factory, other.factory);
    }

    @Override
    public String toString() {
        return "BookshopFacade{hashcode=" + hashCode() + '}';
    }
}
