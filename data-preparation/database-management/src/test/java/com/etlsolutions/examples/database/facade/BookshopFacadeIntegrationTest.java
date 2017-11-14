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

import com.etlsolutions.examples.data.general.IntegrationTestMarker;
import com.etlsolutions.examples.database.DatabaseManager;
import com.etlsolutions.examples.database.hibernate.SessionFactoryGenerator;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

/**
 * Simple integration tests of class BookshopFacade.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@Category(IntegrationTestMarker.class)
public final class BookshopFacadeIntegrationTest {

    private final SessionFactory factory = new SessionFactoryGenerator().getSessionFactory("hibernate-test.cfg.xml");
    private final DatabaseManager databaseManager = new DatabaseManager(factory);

    private final BookshopFacade instance = new BookshopFacade(factory);

    @Before
    public void setUp() {
        databaseManager.clear();
    }

    @After
    public void tearDown() {
        databaseManager.clear();
    }

    /**
     * Test of save method.
     */
    @Test
    public void testSave() {

        Date dateOfBith = new Date(8319810129019L);
        byte[] profile = {1, 4, 6};
        PersonalDetailPojo item = new PersonalDetailPojo(1, "Mrs.", "Zag", "Konsk", dateOfBith, profile);

        List<Object> result = instance.save(item);

        assertEquals(1, (int) result.get(0));
    }
}
