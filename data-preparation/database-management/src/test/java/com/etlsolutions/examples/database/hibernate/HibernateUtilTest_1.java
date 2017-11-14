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

import org.hibernate.SessionFactory;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class HibernateUtil.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({HibernateUtil.class, SessionFactoryGenerator.class})
public final class HibernateUtilTest_1 {

    private final SessionFactoryGenerator sessionFactoryGenerator = PowerMockito.mock(SessionFactoryGenerator.class);
    private final SessionFactory sessionFactory1 = Mockito.mock(SessionFactory.class);
    private final SessionFactory sessionFactory2 = Mockito.mock(SessionFactory.class);
    private final String path = "hibernate.cfg.xml";

    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(SessionFactoryGenerator.class).withNoArguments().thenReturn(sessionFactoryGenerator);
        Mockito.when(sessionFactory1.isClosed()).thenReturn(Boolean.TRUE);
        Mockito.when(sessionFactoryGenerator.getSessionFactory(path)).thenReturn(sessionFactory1).thenReturn(sessionFactory2);
    }


    /**
     * Test of getSessionFactory method.
     */
    @Test
    public void testGetSessionFactory_closed() {

        assertSame(sessionFactory1, HibernateUtil.getSessionFactory(path));
        assertSame(sessionFactory2, HibernateUtil.getSessionFactory(path));               //Repeat.     
    }
}
