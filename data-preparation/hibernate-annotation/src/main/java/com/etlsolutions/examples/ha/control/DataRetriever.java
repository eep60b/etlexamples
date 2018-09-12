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
package com.etlsolutions.examples.ha.control;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Zhipeng Chang
 */
public class DataRetriever {

    
    public <T> List<T> findAll(String queryString) {
        Transaction transaction = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.getNamedQuery(queryString);
            List<T> list = (List<T>) query.list();
            transaction.commit();
            
            return list;
      
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
    
    //This code should work but not tested.
    public int getCounts(){

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.getNamedQuery("select count(DISTINCT city) from address");
            BigInteger result = (BigInteger) query.uniqueResult();
            transaction.commit();
            
            return result.intValue();
      
        } catch (RuntimeException e) {
            HibernateUtil.getSessionFactory().close();
            throw e;
        }
    }
}
