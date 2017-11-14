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
package com.etlsolutions.examples.ha.pojo;

import com.etlsolutions.examples.data.api.AdministratorRole;
import com.etlsolutions.examples.ha.control.DataRetriever;
import com.etlsolutions.examples.ha.control.QueryNames;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AdministratorPojo.
 *
 * @author Zhipeng Chang
 */
public class AdministratorPojoTest {

    private final AdministratorPojo instance = new AdministratorPojo();

    @Before
    public void setUp() {
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        
        assertEquals(0, instance.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {
        
        int id = 31243;        
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getPerson method.
     */
    @Test
    public void testGetPerson() {
        
        assertNull(instance.getPersonalDetail());
    }

    /**
     * Test of setPerson method.
     */
    @Test
    public void testSetPerson() {

        PersonalDetailPojo personalDetail = new PersonalDetailPojo();
        instance.setPersonalDetail(personalDetail);        
        assertEquals(personalDetail, instance.getPersonalDetail());
    }

    /**
     * Test of getRole method.
     */
    @Test
    public void testGetAdminstratorRole() {
        
        assertNull(instance.getRole());
    }

    /**
     * Test of setRole method.
     */
    @Test
    public void testSetAdminstratorRole() {

        instance.setRole(AdministratorRole.ADMIN);
        assertEquals(AdministratorRole.ADMIN, instance.getRole());
    }

    /**
     * Test of getUsername method.
     */
    @Test
    public void testGetAdminstratorUsername() {
        assertNull(instance.getUsername());
    }

    /**
     * Test of setUsername method.
     */
    @Test
    public void testSetAdminstratorUsername() {
        String adminstratorUsername = "setAdminstratorUsername";
        instance.setUsername(adminstratorUsername);        
        assertEquals(adminstratorUsername, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class AdministratorPojo.
     */
    @Test
    public void testGetAdminstratorPassword() {

        assertNull(instance.getPassword());
    }

    /**
     * Test of setPassword method.
     */
    @Test
    public void testSetAdminstratorPassword() {
        
        String adminstratorPassword = "setAdminstratorPassword";
        instance.setPassword(adminstratorPassword);
        assertEquals(adminstratorPassword, instance.getPassword());
    }
    
    @Test
    public void testQueries() {
        DataRetriever retriever = new DataRetriever();
        
        List<AdministratorPojo> list = retriever.<AdministratorPojo>findAll(QueryNames.findAdministrators);
        assertEquals(3, list.size());
        
        assertEquals("Gwynedd", list.get(0));
    }     
    
    
    @Test
    public void testQueriesNative() {
        DataRetriever retriever = new DataRetriever();
        
        List<AdministratorPojo> list = retriever.<AdministratorPojo>findAll(QueryNames.findAdministratorsNative);
        assertEquals(3, list.size());
        
        assertEquals("Gwynedd", list.get(0));
    }     
}
