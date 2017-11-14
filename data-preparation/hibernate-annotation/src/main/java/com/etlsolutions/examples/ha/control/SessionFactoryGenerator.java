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

import com.etlsolutions.examples.base.log.SystemLogger;
import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.utility.annotation.StatelessClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.net.URL;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * The SessionFactoryGenerator class contains only one method to generate a SessionFactory.
 * 
 * @author Zhipeng Chang
 * 
 * @version 1.0.0
 */
@StatelessClass
@ThreadSafe
public final class SessionFactoryGenerator {
    
    /**
     * Get the generated SeesionFactory object. The method will generate a valid SessionFactory using the hibernate configuration file.
     * @param path
     * @return the generated SeesionFactory object.
     */
    public SessionFactory getSessionFactory(String path) {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) config file.
            Configuration configuration = new Configuration();
            configuration.configure(path);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        } catch (Throwable ex) {
            // Log the exception. 
            SystemLogger.fatal(SessionFactoryGenerator.class, MessageFactory.getMessage(ErrorType.SESSION_FACTORY_CREATION_FAILURE), ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    
    /**
     * Get the generated SeesionFactory object. The method will generate a valid SessionFactory using the hibernate configuration file.
     * @param url
     * @return the generated SeesionFactory object.
     */
    public SessionFactory getSessionFactory(URL url) {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) config file.
            Configuration configuration = new Configuration();
            configuration.configure(url);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        } catch (Throwable ex) {
            // Log the exception. 
            SystemLogger.fatal(SessionFactoryGenerator.class, MessageFactory.getMessage(ErrorType.SESSION_FACTORY_CREATION_FAILURE), ex);
            throw new ExceptionInInitializerError(ex);
        }
    }    
    
}
