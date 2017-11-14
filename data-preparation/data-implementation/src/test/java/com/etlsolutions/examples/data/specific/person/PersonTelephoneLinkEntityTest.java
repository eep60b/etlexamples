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
package com.etlsolutions.examples.data.specific.person;

import com.etlsolutions.examples.data.api.PersonTelephoneLink;
import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.data.specific.communication.AreaCode;
import com.etlsolutions.examples.data.specific.communication.CountryCode;
import com.etlsolutions.examples.data.specific.communication.TelephoneEnitity;
import com.etlsolutions.examples.data.specific.communication.TelephoneNumber;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class PersonTelephoneLinkEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonTelephoneLinkEntityTest {

    private final PersonalTitle title = new PersonalTitle("Me.");
    private final GivenName givenName = new GivenName("Ton");
    private final GivenName givenName1 = new GivenName("Kimen");
    private final FamilyName familyName = new FamilyName("Snigh");
    private final DateOfBirth dateOfBirth = new DateOfBirth(new Date(new Date(0).getTime() + 365L * 24L * 3600L));
    private final PersonalProfile profile = new PersonalProfile(new byte[]{1, 16, 92});
    private final PersonalProfile profile1 = new PersonalProfile(new byte[]{10, 52, 96});

    private final PersonalDetailEntity personalDetailEntity = new PersonalDetailEntity(title, givenName, familyName, dateOfBirth, profile);
    private final PersonalDetailEntity personalDetailEntity1 = new PersonalDetailEntity(title, givenName1, familyName, dateOfBirth, profile1);

    private final CountryCode countryCodeColumn = new CountryCode("86");
    private final AreaCode areaCodeColumn = new AreaCode("10");
    private final TelephoneNumber telephoneNumberColumn = new TelephoneNumber("3574684");
    private final TelephoneNumber telephoneNumberColumn2 = new TelephoneNumber("4938322");
    private final TelephoneEnitity telephoneEnitity = new TelephoneEnitity(countryCodeColumn, areaCodeColumn, telephoneNumberColumn, TelephoneType.OFFICE);
    private final TelephoneEnitity telephoneEnitity2 = new TelephoneEnitity(countryCodeColumn, areaCodeColumn, telephoneNumberColumn2, TelephoneType.OFFICE);

    private final PersonTelephoneLink personTelephoneLink = Mockito.mock(PersonTelephoneLink.class);

    private final PersonTelephoneLinkEntity instance = new PersonTelephoneLinkEntity(personalDetailEntity, telephoneEnitity);
    private final PersonTelephoneLinkEntity instance00 = new PersonTelephoneLinkEntity(personalDetailEntity, telephoneEnitity);
    private final PersonTelephoneLinkEntity instance01 = new PersonTelephoneLinkEntity(personalDetailEntity1, telephoneEnitity);
    private final PersonTelephoneLinkEntity instance02 = new PersonTelephoneLinkEntity(personalDetailEntity, telephoneEnitity2);
    private PersonTelephoneLinkEntity instance03;

    @Before
    public void setUp() {

        Mockito.when(personTelephoneLink.getPersonalDetail()).thenReturn(personalDetailEntity);
        Mockito.when(personTelephoneLink.getTelephone()).thenReturn(telephoneEnitity);

        instance03 = new PersonTelephoneLinkEntity(personTelephoneLink);
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailEntity, instance.getPersonalDetail());
        assertEquals(personalDetailEntity, instance03.getPersonalDetail());
    }

    /**
     * Test of getTelephone method.
     */
    @Test
    public void testGetTelephone() {

        assertEquals(telephoneEnitity, instance.getTelephone());
        assertEquals(telephoneEnitity, instance03.getTelephone());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(personTelephoneLink));

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
        assertTrue(instance.hasSameParameters(instance03));
        assertTrue(instance.hasSameParameters(personTelephoneLink));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());

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
        assertTrue(instance.equals(instance03));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(personTelephoneLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("PersonTelephoneLinkEntity{personalDetailEntity=", instance.toString());
    }

}
