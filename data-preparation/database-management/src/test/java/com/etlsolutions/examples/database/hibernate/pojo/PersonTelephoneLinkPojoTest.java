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

import com.etlsolutions.examples.data.api.PersonTelephoneLink;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class PersonTelephoneLinkPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonTelephoneLinkPojoTest {

    private final PersonalDetailPojo personalDetailPojo = Mockito.mock(PersonalDetailPojo.class);
    private final PersonalDetailPojo personalDetailPojo1 = Mockito.mock(PersonalDetailPojo.class);
    private final TelephonePojo telephonePojo = Mockito.mock(TelephonePojo.class);
    private final TelephonePojo telephonePojo2 = Mockito.mock(TelephonePojo.class);
    private final PersonTelephoneLink personTelephoneLink = Mockito.mock(PersonTelephoneLink.class);

    private final PersonTelephoneLinkPojo instance = new PersonTelephoneLinkPojo(personalDetailPojo, telephonePojo);
    private final PersonTelephoneLinkPojo instance00 = new PersonTelephoneLinkPojo(personalDetailPojo, telephonePojo);
    private final PersonTelephoneLinkPojo instance01 = new PersonTelephoneLinkPojo(personalDetailPojo1, telephonePojo);
    private final PersonTelephoneLinkPojo instance02 = new PersonTelephoneLinkPojo(personalDetailPojo, telephonePojo2);
    private final PersonTelephoneLinkPojo instance03 = new PersonTelephoneLinkPojo(null, null);
    private final PersonTelephoneLinkPojo instance04 = new PersonTelephoneLinkPojo();
    private final PersonTelephoneLinkPojo instance05 = new HibernateProxyPersonTelephoneLinkPojo(new PersonTelephoneLinkPojo(personalDetailPojo, telephonePojo));
    private final PersonTelephoneLinkPojo instance06 = new PersonTelephoneLinkPojo(new PersonalDetailPojo(), new TelephonePojo());

    @Before
    public void setUp() {
        Mockito.when(personTelephoneLink.getPersonalDetail()).thenReturn(personalDetailPojo);
        Mockito.when(personTelephoneLink.getTelephone()).thenReturn(telephonePojo);
    }

    /**
     * Test of getPersonalDetailId method.
     */
    @Test
    public void testGetPersonalDetailId() {

        Mockito.when(personalDetailPojo.getId()).thenReturn(23239);

        assertEquals(23239, instance.getPersonalDetailId());
        assertEquals(0, instance03.getPersonalDetailId());
        assertEquals(0, instance04.getPersonalDetailId());
        assertEquals(0, instance05.getPersonalDetailId());

    }

    /**
     * Test of getTelephoneId method.
     */
    @Test
    public void testGetTelephoneId() {

        Mockito.when(telephonePojo.getId()).thenReturn(4829);

        assertEquals(4829, instance.getTelephoneId());
        assertEquals(0, instance03.getTelephoneId());
        assertEquals(0, instance04.getTelephoneId());
        assertEquals(0, instance05.getTelephoneId());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailPojo, instance.getPersonalDetail());
        assertNull(instance03.getPersonalDetail());
        assertNull(instance04.getPersonalDetail());
        assertNull(instance05.getPersonalDetail());
    }

    /**
     * Test of getTelephone method.
     */
    @Test
    public void testGetTelephone() {

        assertEquals(telephonePojo, instance.getTelephone());
        assertNull(instance03.getTelephone());
        assertNull(instance04.getTelephone());
        assertNull(instance05.getTelephone());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(personTelephoneLink));
        assertTrue(instance05.hasSameConstraint(instance));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance05.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(personTelephoneLink));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance06));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyPersonTelephoneLinkPojo extends PersonTelephoneLinkPojo implements HibernateProxy {

        private static final long serialVersionUID = 489001530927481524L;
        private final PersonTelephoneLinkPojo pojo;

        public HibernateProxyPersonTelephoneLinkPojo(PersonTelephoneLinkPojo pojo) {

            this.pojo = pojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {

                @Override
                public PersonTelephoneLinkPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
