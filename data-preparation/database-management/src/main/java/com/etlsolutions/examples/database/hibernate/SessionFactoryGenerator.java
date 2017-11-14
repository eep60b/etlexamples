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
package com.etlsolutions.examples.database.hibernate;

import com.etlsolutions.examples.base.log.SystemLogger;
import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.utility.annotation.StatelessClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.net.URL;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * The SessionFactoryGenerator class contains only one method to generate a
 * SessionFactory.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 2.0.0 - Change the implementation to work with Hibernate version
 * 5.0.6.
 */
@StatelessClass
@ThreadSafe
public final class SessionFactoryGenerator {

    /**
     * Get the generated SeesionFactory object. The method will generate a valid
     * SessionFactory using the hibernate configuration file.
     *
     * @param path - The path of Hibernate configuration file.
     * @return the generated SeesionFactory object.
     */
    public SessionFactory getSessionFactory(String path) {
        return getConcreteSessionFactory(path);
    }

    /**
     * Get the generated SeesionFactory object. The method will generate a valid
     * SessionFactory using the hibernate configuration file.
     *
     * @param url - The URL of Hibernate configuration file.
     * @return the generated SeesionFactory object.
     */
    public SessionFactory getSessionFactory(URL url) {
        return getConcreteSessionFactory(url);
    }   
    
    private <T> SessionFactory getConcreteSessionFactory(T t) {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) config file.
            StandardServiceRegistryBuilder standardRegistryBuilder = new StandardServiceRegistryBuilder();
            if (t instanceof String) {
                standardRegistryBuilder.configure((String) t);
            } else if(t instanceof URL) {
                standardRegistryBuilder.configure((URL) t);
            } else {
                throw new ExceptionInInitializerError("Invalid parameters.");
            }
            MetadataSources sources = new MetadataSources(standardRegistryBuilder.build());
            MetadataBuilder metadataBuilder = sources.getMetadataBuilder();
            Metadata metadata = metadataBuilder.build();
            SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
            return sessionFactoryBuilder.build();
        } catch (Throwable ex) {
            // Log the error information. 
            SystemLogger.fatal(SessionFactoryGenerator.class, MessageFactory.getMessage(ErrorType.SESSION_FACTORY_CREATION_FAILURE));
            throw new ExceptionInInitializerError(ex);
        }
    }
}
