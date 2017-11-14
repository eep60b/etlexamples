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
package com.etlsolutions.examples.data.specific.communication;

import com.etlsolutions.examples.data.api.Email;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class EmailEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({EmailEntity.class, PersonalDetailEntity.class})
public final class EmailEntityTest {

    private final EmailAddress emailAddress = new EmailAddress("abc@google.kom");
    private final EmailAddress emailAddress1 = new EmailAddress("bbc@google.kom");

    private final PersonalDetailEntity personalDetailEntity = PowerMockito.mock(PersonalDetailEntity.class);
    private final PersonalDetailEntity personalDetailEntity2 = PowerMockito.mock(PersonalDetailEntity.class);
    private final PersonalDetail personalDetail3 = Mockito.mock(PersonalDetail.class);

    private final Email email = Mockito.mock(Email.class);

    private final EmailEntity instance = new EmailEntity(emailAddress, personalDetailEntity);
    private final EmailEntity instance00 = new EmailEntity(emailAddress, personalDetailEntity);
    private final EmailEntity instance01 = new EmailEntity(emailAddress1, personalDetailEntity);
    private final EmailEntity instance02 = new EmailEntity(emailAddress, personalDetailEntity2);
    private EmailEntity instance03;
    private EmailEntity instance04;

    @Before
    public void setUp() throws Exception {

        Mockito.when(email.getEmailAddress()).thenReturn("abc@google.kom");
        Mockito.when(email.getPersonalDetail()).thenReturn(personalDetailEntity);

        PowerMockito.whenNew(PersonalDetailEntity.class).withArguments(personalDetail3).thenReturn(personalDetailEntity);

        instance03 = new EmailEntity(emailAddress, personalDetail3);
        instance04 = new EmailEntity(email);
    }

    /**
     * Test of getEmailAddress method.
     */
    @Test
    public void testGetEmailAddress() {

        assertEquals("abc@google.kom", instance.getEmailAddress());
        assertEquals("abc@google.kom", instance03.getEmailAddress());
        assertEquals("abc@google.kom", instance04.getEmailAddress());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailEntity, instance.getPersonalDetail());
        assertEquals(personalDetailEntity, instance03.getPersonalDetail());
        assertEquals(personalDetailEntity, instance04.getPersonalDetail());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("EmailEnitity{Email address=abc@google.kom}", instance.toString());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(email));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(email));

        assertFalse(instance.hasSameParameters(null));
        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
    }
}
