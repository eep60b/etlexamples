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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.data.api.Administrator;
import com.etlsolutions.examples.data.api.AdministratorRole;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class AdministratorPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @author 1.0.0
 */
public final class AdministratorPojoTest {

    private final int id = 1242;
    private final int id1 = 9439;
    private final PersonalDetailPojo personalDetail = new PersonalDetailPojo(3681, "Mr", "TTMM", "ETLFamily", new Date(479137412941934123L), new byte[]{73, 64, 55});
    private final PersonalDetailPojo personalDetail2 = new PersonalDetailPojo(3681, "Mkr", "TKx", "LLFamily", new Date(32743812941934123L), new byte[]{34, 33, 33});
    private final PersonalDetailPojo personalDetailx = new PersonalDetailPojo(3681, "Mr", "TTMM", "ETLFamily", new Date(479137412941934123L), new byte[]{73, 64, 55});
    private final AdministratorRole administratorRole = AdministratorRole.ADMIN;
    private final AdministratorRole administratorRole3 = AdministratorRole.OPERATOR;
    private final String username = "uandkaljla";
    private final String username4 = "lankrela";
    private final String password = "102438jqlej32";
    private final String password5 = "(&*H(jkfa))";
    private final Administrator administrator = Mockito.mock(Administrator.class);

    private final AdministratorPojo instance = new AdministratorPojo(id, personalDetail, administratorRole, username, password);
    private final AdministratorPojo instance00 = new AdministratorPojo(id, personalDetail, administratorRole, username, password);
    private final AdministratorPojo instance01 = new AdministratorPojo(id1, personalDetail, administratorRole, username, password);
    private final AdministratorPojo instance02 = new AdministratorPojo(id, personalDetail2, administratorRole, username, password);
    private final AdministratorPojo instance03 = new AdministratorPojo(id, personalDetail, administratorRole3, username, password);
    private final AdministratorPojo instance04 = new AdministratorPojo(id, personalDetail, administratorRole, username4, password);
    private final AdministratorPojo instance05 = new AdministratorPojo(id, personalDetail, administratorRole, username, password5);
    private final AdministratorPojo instance06 = new AdministratorPojo();
    private final AdministratorPojo instance07 = new AdministratorPojo(personalDetail, administratorRole, username, password);
    private final AdministratorPojo instance08 = new HibernateProxyAdministratorPojo(new AdministratorPojo(id, personalDetail, administratorRole, username, password));

    @Before
    public void setUp() {

        Mockito.when(administrator.getPassword()).thenReturn(password);
        Mockito.when(administrator.getPersonalDetail()).thenReturn(personalDetailx);
        Mockito.when(administrator.getRole()).thenReturn(administratorRole);
        Mockito.when(administrator.getUsername()).thenReturn(username);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        assertEquals(1242, instance.getId());
        assertEquals(0, instance06.getId());
        assertEquals(0, instance07.getId());
        assertEquals(0, instance08.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(886);
        assertEquals(886, instance.getId());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetail, instance.getPersonalDetail());
        assertNull(instance06.getPersonalDetail());
        assertEquals(personalDetail, instance07.getPersonalDetail());
        assertNull(instance08.getPersonalDetail());
    }

    /**
     * Test of setPersonalDetail method.
     */
    @Test
    public void testSetPersonalDetail() {

        PersonalDetailPojo personalDetail1 = Mockito.mock(PersonalDetailPojo.class);
        instance.setPersonalDetail(personalDetail1);
        assertEquals(personalDetail1, instance.getPersonalDetail());
    }

    /**
     * Test of getRole method.
     */
    @Test
    public void testGetRole() {

        assertEquals(AdministratorRole.ADMIN, instance.getRole());
        assertNull(instance06.getRole());
        assertEquals(AdministratorRole.ADMIN, instance07.getRole());
        assertNull(instance08.getRole());
    }

    /**
     * Test of setRole method.
     */
    @Test
    public void testSetRole() {

        instance.setRole(AdministratorRole.SYSTEM);
        assertEquals(AdministratorRole.SYSTEM, instance.getRole());
    }

    /**
     * Test of getUsername method.
     */
    @Test
    public void testGetUsername() {

        assertEquals(username, instance.getUsername());
        assertNull(instance06.getUsername());
        assertEquals(username, instance07.getUsername());
        assertNull(instance08.getUsername());
    }

    /**
     * Test of setUsername method.
     */
    @Test
    public void testSetUsername() {

        String username1 = "setUsername";
        instance.setUsername(username1);
        assertEquals("setUsername", instance.getUsername());
    }

    /**
     * Test of getPassword method.
     */
    @Test
    public void testGetPassword() {

        assertEquals(password, instance.getPassword());
        assertNull(instance06.getPassword());
        assertEquals(password, instance07.getPassword());
        assertNull(instance08.getPassword());
    }

    /**
     * Test of setPassword method.
     */
    @Test
    public void testSetPassword() {

        instance.setPassword("setPassword");
        assertEquals("setPassword", instance.getPassword());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance02.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance08));
        assertTrue(instance08.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(administrator));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance08.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(administrator));

        assertFalse(instance.hasSameConstraint(instance04));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance08.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(administrator));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));
    }

    @Test
    public void testToString() {

        assertEquals("AdministratorPojo{name=TTMM ETLFamily, username=uandkaljla}", instance.toString());
        assertEquals("AdministratorPojo{name=null, username=null}", instance06.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance));
    }

    private final class HibernateProxyAdministratorPojo extends AdministratorPojo implements HibernateProxy {

        private static final long serialVersionUID = 9;
        private final AdministratorPojo administratorPojo;

        public HibernateProxyAdministratorPojo(AdministratorPojo administratorPojo) {
            this.administratorPojo = administratorPojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {
                @Override
                public AdministratorPojo getImplementation() {
                    return administratorPojo;
                }
            };
        }
    }

}
