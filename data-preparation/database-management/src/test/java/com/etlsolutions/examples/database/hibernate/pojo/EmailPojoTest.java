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

import com.etlsolutions.examples.data.api.Email;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class EmailPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class EmailPojoTest {

    private final int id = 2278;
    private final int id1 = 9439;
    private final PersonalDetailPojo personalDetailPojo = new PersonalDetailPojo(2217, "MR", "Klock", "Sondous", new Date(121212341421L), new byte[]{33, 54, 76});
    private final PersonalDetailPojo personalDetailPojo2 = new PersonalDetailPojo(2217, "MRS", "Jeam", "Sondous", new Date(1299212341421L), new byte[]{3, 49, 17});
    private final String emailAddress = "aks@hmail.com";
    private final String emailAddress3 = "akk.deff@kktmai.com";

    private final Email email = Mockito.mock(Email.class);

    private final EmailPojo instance = new EmailPojo(id, personalDetailPojo, emailAddress);
    private final EmailPojo instance00 = new EmailPojo(id, personalDetailPojo, emailAddress);
    private final EmailPojo instance01 = new EmailPojo(id1, personalDetailPojo, emailAddress);
    private final EmailPojo instance02 = new EmailPojo(id, personalDetailPojo2, emailAddress);
    private final EmailPojo instance03 = new EmailPojo(id, personalDetailPojo, emailAddress3);

    private final EmailPojo instance04 = new EmailPojo();
    private final EmailPojo instance05 = new EmailPojo(personalDetailPojo, "askk@kmail.com");
    private final EmailPojo instance06 = new EmailPojo(753, "knak@fnnak.com");
    private final EmailPojo hibernateProxyIinstance = new HibernateProxyEmailPojo(instance);

    @Before
    public void setUp() {
        Mockito.when(email.getEmailAddress()).thenReturn("aks@hmail.com");
        Mockito.when(email.getPersonalDetail()).thenReturn(personalDetailPojo);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(2278, instance.getId());
        assertEquals(0, instance04.getId());
        assertEquals(0, instance05.getId());
        assertEquals(753, instance06.getId());
        assertEquals(0, hibernateProxyIinstance.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(853);
        assertEquals(853, instance.getId());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailPojo, instance.getPersonalDetail());
        assertEquals(personalDetailPojo, instance05.getPersonalDetail());

        assertNull(instance04.getPersonalDetail());
        assertNull(instance06.getPersonalDetail());
        assertNull(hibernateProxyIinstance.getPersonalDetail());
    }

    /**
     * Test of setPersonalDetail method.
     */
    @Test
    public void testSetPersonalDetail() {

        PersonalDetailPojo personalDetail = new PersonalDetailPojo(2217, "MR", "Klock", "Sondous", new Date(121212341421L), new byte[]{33, 54, 76});

        instance.setPersonalDetail(personalDetail);

        assertEquals(personalDetail, instance.getPersonalDetail());
    }

    /**
     * Test of getEmailAddress method.
     */
    @Test
    public void testGetEmailAddress() {

        assertEquals("aks@hmail.com", instance.getEmailAddress());
        assertEquals("askk@kmail.com", instance05.getEmailAddress());
        assertEquals("knak@fnnak.com", instance06.getEmailAddress());

        assertNull(instance04.getEmailAddress());
        assertNull(hibernateProxyIinstance.getEmailAddress());
    }

    /**
     * Test of setEmailAddress method.
     */
    @Test
    public void testSetEmailAddress() {

        instance.setEmailAddress("mmp@vnauk.irg");
        assertEquals("mmp@vnauk.irg", instance.getEmailAddress());
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
        assertTrue(instance.hasSameConstraint(hibernateProxyIinstance));
        assertTrue(instance.hasSameConstraint(email));
        assertTrue(hibernateProxyIinstance.hasSameConstraint(instance));

        assertFalse(instance.hasSameConstraint(instance03));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(email));
        assertTrue(instance.hasSameParameters(hibernateProxyIinstance));
        assertTrue(hibernateProxyIinstance.hasSameParameters(instance));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(hibernateProxyIinstance.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(hibernateProxyIinstance));
        assertTrue(hibernateProxyIinstance.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(email));
        assertFalse(instance.equals(null));
    }
     
    /**
     * Test of serialisation.
     */    
    @Test
    public void testSerialisation() {
        
        assertTrue(SerialisationUtilities.isSerializable(instance));
    }   
    
    private final static class HibernateProxyEmailPojo extends EmailPojo implements HibernateProxy {
        
        private static final long serialVersionUID = 889111987350156962L;
        
        private final EmailPojo pojo;

        public HibernateProxyEmailPojo(EmailPojo pojo) {
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
                public EmailPojo getImplementation() {
                    return pojo;
                }
            };
        }

    }
}
