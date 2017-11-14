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

import java.net.URL;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

/**
 *
 * Test of class SessionFactoryGenerator.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@PrepareForTest({SessionFactoryGenerator.class})
public final class SessionFactoryGeneratorTest {

    @Rule
    public final PowerMockRule rule = new PowerMockRule();

    private final StandardServiceRegistryBuilder standardRegistryBuilder = Mockito.mock(StandardServiceRegistryBuilder.class);
    private final StandardServiceRegistry standardServiceRegistry = Mockito.mock(StandardServiceRegistry.class);
    private final MetadataSources sources = Mockito.mock(MetadataSources.class);
    private final MetadataBuilder metadataBuilder = Mockito.mock(MetadataBuilder.class);
    private final Metadata metadata = Mockito.mock(Metadata.class);
    private final SessionFactoryBuilder sessionFactoryBuilder = Mockito.mock(SessionFactoryBuilder.class);
    private final SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);

    private final SessionFactoryGenerator instance = new SessionFactoryGenerator();

    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(StandardServiceRegistryBuilder.class).withNoArguments().thenReturn(standardRegistryBuilder);
        Mockito.when(standardRegistryBuilder.build()).thenReturn(standardServiceRegistry);
        PowerMockito.whenNew(MetadataSources.class).withArguments(standardServiceRegistry).thenReturn(sources);
        Mockito.when(sources.getMetadataBuilder()).thenReturn(metadataBuilder);
        Mockito.when(metadataBuilder.build()).thenReturn(metadata);
        Mockito.when(metadata.getSessionFactoryBuilder()).thenReturn(sessionFactoryBuilder);
        Mockito.when(sessionFactoryBuilder.build()).thenReturn(sessionFactory);
    }

    /**
     * Test of getSessionFactory method.
     */
    @Test
    public void testGetSessionFactory_String() {
        String path = "afbbd";
        assertEquals(sessionFactory, instance.getSessionFactory(path));

        Mockito.verify(standardRegistryBuilder).configure(path);
    }

    /**
     * Test of getSessionFactory method.
     */
    @Test
    public void testGetSessionFactory_URL() {

        URL url = PowerMockito.mock(URL.class);
        assertEquals(sessionFactory, instance.getSessionFactory(url));
        Mockito.verify(standardRegistryBuilder).configure(url);
    }

    /**
     * Test of getSessionFactory method.
     */
    @Test(expected = ExceptionInInitializerError.class)
    public void testGetSessionFactory_null() {

        URL url = null;
        assertEquals(sessionFactory, instance.getSessionFactory(url));

    }

}
