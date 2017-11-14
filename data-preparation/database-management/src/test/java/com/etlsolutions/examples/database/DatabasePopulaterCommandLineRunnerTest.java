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

import com.etlsolutions.examples.database.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class DatabasePopulaterCommandLineRunner.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DatabasePopulaterCommandLineRunner.class, DatabaseManager.class, HibernateUtil.class})
public final class DatabasePopulaterCommandLineRunnerTest {

    /**
     * Test of the main method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMain() throws Exception {

        SessionFactory factory = Mockito.mock(SessionFactory.class);
        String path = "hibernate.cfg.xml";
        PowerMockito.mockStatic(HibernateUtil.class);
        Mockito.when(HibernateUtil.getSessionFactory(path)).thenReturn(factory);
        DatabaseManager populater = PowerMockito.mock(DatabaseManager.class);
        PowerMockito.whenNew(DatabaseManager.class).withArguments(factory).thenReturn(populater);
        DatabasePopulaterCommandLineRunner.main();
        Mockito.verify(populater).populate();
    }
    

    /**
     * Test of the main method.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testMain_withArgument() throws Exception {

        SessionFactory factory = Mockito.mock(SessionFactory.class);
        String path = "anotherhibernate.cfg.xml";
        PowerMockito.mockStatic(HibernateUtil.class);
        Mockito.when(HibernateUtil.getSessionFactory(path)).thenReturn(factory);
        DatabaseManager populater = PowerMockito.mock(DatabaseManager.class);
        PowerMockito.whenNew(DatabaseManager.class).withArguments(factory).thenReturn(populater);
        DatabasePopulaterCommandLineRunner.main(path);
        Mockito.verify(populater).populate();
    }    
}
