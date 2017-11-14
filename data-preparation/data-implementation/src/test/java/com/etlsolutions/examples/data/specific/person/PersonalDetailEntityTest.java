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

import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.communication.EmailEntity;
import com.etlsolutions.examples.data.specific.communication.TelephoneEnitity;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class PersonalDetailEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PersonalDetailEntity.class, TelephoneEnitity.class, EmailEntity.class})
public final class PersonalDetailEntityTest {

    private final PersonalTitle personTitleColumn = new PersonalTitle("Me.");
    private final PersonalTitle personTitleColumn1 = new PersonalTitle("Rx.");
    private final GivenName givenNameColumn = new GivenName("Ton");
    private final GivenName givenNameColumn2 = new GivenName("knla");
    private final FamilyName familyNameColumn = new FamilyName("Snigh");
    private final FamilyName familyNameColumn3 = new FamilyName("Piioap");
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(new Date(new Date(0).getTime() + 365L * 24L * 3600L * 30L + 24L * 3600L * 190L));
    private final DateOfBirth dateOfBirthColumn4 = new DateOfBirth(new Date(new Date(0).getTime() + 365L * 24L * 3600L * 30L + 24L * 3600L * 100L));
    private final PersonalProfile personalProfileColumn = new PersonalProfile(new byte[]{1, 16, 92});
    private final PersonalProfile personalProfileColumn5 = new PersonalProfile(new byte[]{61, 39, 82});
    private final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);

    private final PersonalDetailEntity instance = new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    private final PersonalDetailEntity instance00 = new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    private final PersonalDetailEntity instance01 = new PersonalDetailEntity(personTitleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    private final PersonalDetailEntity instance02 = new PersonalDetailEntity(personTitleColumn, givenNameColumn2, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    private final PersonalDetailEntity instance03 = new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn3, dateOfBirthColumn, personalProfileColumn);
    private final PersonalDetailEntity instance04 = new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn4, personalProfileColumn);
    private final PersonalDetailEntity instance05 = new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn5);
    private PersonalDetailEntity instance06;

    @Before
    public void setUp() {

        Mockito.when(personalDetail.getDateOfBirth()).thenReturn(new Date(new Date(0).getTime() + 365L * 24L * 3600L * 30L + 24L * 3600L * 190L));
        Mockito.when(personalDetail.getFamilyName()).thenReturn("Snigh");
        Mockito.when(personalDetail.getGivenName()).thenReturn("Ton");
        Mockito.when(personalDetail.getProfile()).thenReturn(new byte[]{1, 16, 92});
        Mockito.when(personalDetail.getTitle()).thenReturn("Me.");

        instance06 = new PersonalDetailEntity(personalDetail);
    }

    /**
     * Test of getDateOfBirth method.
     */
    @Test
    public void testGetDateOfBirth() {

        assertEquals(new Date(new Date(0).getTime() + 365L * 24L * 3600L * 30L + 24L * 3600L * 190L), instance.getDateOfBirth());
    }

    /**
     * Test of getFamilyName method.
     */
    @Test
    public void testGetFamilyName() {

        assertEquals("Snigh", instance.getFamilyName());
        assertEquals("Snigh", instance06.getFamilyName());
    }

    /**
     * Test of getGivenName method.
     */
    @Test
    public void testGetGivenName() {

        assertEquals("Ton", instance.getGivenName());
        assertEquals("Ton", instance06.getGivenName());
    }

    /**
     * Test of getTitle method.
     */
    @Test
    public void testGetTitle() {

        assertEquals("Me.", instance.getTitle());
        assertEquals("Me.", instance06.getTitle());
    }

    /**
     * Test of getProfile method.
     */
    @Test
    public void testGetProfile() {

        assertArrayEquals(new byte[]{1, 16, 92}, instance.getProfile());
        assertArrayEquals(new byte[]{1, 16, 92}, instance06.getProfile());
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
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(personalDetail));

        assertFalse(instance.hasSameConstraint(instance05));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(personalDetail));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
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
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(personalDetail));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("PersonalDetailEntity{title=Me., given name=Ton, family name=Snigh}", instance.toString());
    }
}
