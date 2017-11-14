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

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.utility.annotation.SingletonClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import org.hibernate.SessionFactory;

/**
 * The Hibernate Utility class provide a convenient method to get the Session Factory
 * object. Since the SessionFactory object is expensive to create. It is only created once when the application is launched.
 *
 * @author Zhipeng Chang
 * 
 * @version 1.0.0
 */
@SingletonClass
@ThreadSafe
public class HibernateUtil {

    private static final SessionFactory sessionFactory = new SessionFactoryGenerator().getSessionFactory(HibernateUtil.class.getResource("/hibernate/hibernate.cfg.xml"));

    private HibernateUtil() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * Get the generated singleton SessionFactory object.
     * @return the generated SessionFactory object.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
