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
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.ReviewerEntity;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Reviewer;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 * Test of class ReviewerEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ReviewerEntityTest {

    private final PersonalTitle personTitleColumn = new PersonalTitle("Me.");
    private final PersonalTitle personTitleColumn1 = new PersonalTitle("Re.");
    private final GivenName givenNameColumn = new GivenName("Ton");
    private final FamilyName familyNameColumn = new FamilyName("Snigh");
    private final DateOfBirth dateOfBirthColumn = new DateOfBirth(new Date(new Date(0).getTime() + 365L * 24L * 3600L * 30L + 24L * 3600L * 190L));
    private final PersonalProfile personalProfileColumn = new PersonalProfile(new byte[]{1, 16, 92});
    private final PersonalDetailEntity personalDetailEntity = new PersonalDetailEntity(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    private final PersonalDetailEntity personalDetailEntity1 = new PersonalDetailEntity(personTitleColumn1, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn);
    private final PersonalUsername usernameColumn = new PersonalUsername("uuualusername");
    private final PersonalUsername usernameColumn2 = new PersonalUsername("uuua9nnadkame");
    private final PersonalPassword passwordColumn = new PersonalPassword("oanfkdkl3lladjal2");
    private final PersonalPassword passwordColumn3 = new PersonalPassword("789134h131234i");
    private final ImageBytes imageColumn = new ImageBytes(new byte[]{99, 77, 22});
    private final ImageBytes imageColumn4 = new ImageBytes(new byte[]{60, 30, 34});
    private final ImageBytes imageColumn5 = null;
    private final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);
    private final Reviewer reviewer = Mockito.mock(Reviewer.class);

    private final ReviewerEntity instance = new ReviewerEntity(personalDetailEntity, usernameColumn, passwordColumn, imageColumn);
    private final ReviewerEntity instance00 = new ReviewerEntity(personalDetailEntity, usernameColumn, passwordColumn, imageColumn);
    private final ReviewerEntity instance01 = new ReviewerEntity(personalDetailEntity1, usernameColumn, passwordColumn, imageColumn);
    private final ReviewerEntity instance02 = new ReviewerEntity(personalDetailEntity, usernameColumn2, passwordColumn, imageColumn);
    private final ReviewerEntity instance03 = new ReviewerEntity(personalDetailEntity, usernameColumn, passwordColumn3, imageColumn);
    private final ReviewerEntity instance04 = new ReviewerEntity(personalDetailEntity, usernameColumn, passwordColumn, imageColumn4);
    private final ReviewerEntity instance05 = new ReviewerEntity(personalDetailEntity, usernameColumn, passwordColumn, imageColumn5);
    private ReviewerEntity instance06;
    private ReviewerEntity instance07;

    @Before
    public void setUp() {

        Mockito.when(reviewer.getPersonalDetail()).thenReturn(personalDetail);

        Mockito.when(personalDetail.getDateOfBirth()).thenReturn(new Date(new Date(0).getTime() + 365L * 24L * 3600L * 30L + 24L * 3600L * 190L));
        Mockito.when(personalDetail.getFamilyName()).thenReturn("Snigh");
        Mockito.when(personalDetail.getGivenName()).thenReturn("Ton");
        Mockito.when(personalDetail.getProfile()).thenReturn(new byte[]{1, 16, 92});
        Mockito.when(personalDetail.getTitle()).thenReturn("Me.");
        
        Mockito.when(reviewer.getImage()).thenReturn(new byte[]{99, 77, 22});
        Mockito.when(reviewer.getPassword()).thenReturn("oanfkdkl3lladjal2");
        Mockito.when(reviewer.getUsername()).thenReturn("uuualusername");

        instance06 = new ReviewerEntity(personalDetail, usernameColumn, passwordColumn, imageColumn);
        instance07 = new ReviewerEntity(reviewer);
    }

    /**
     * Test of getPassword method.
     */
    @Test
    public void testGetPassword() {

        assertEquals("oanfkdkl3lladjal2", instance.getPassword());
        assertEquals("oanfkdkl3lladjal2", instance06.getPassword());
        assertEquals("oanfkdkl3lladjal2", instance07.getPassword());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        assertArrayEquals(new byte[]{99, 77, 22}, instance.getImage());
        assertNull(instance05.getImage());        
        assertArrayEquals(new byte[]{99, 77, 22}, instance06.getImage());
        assertArrayEquals(new byte[]{99, 77, 22}, instance07.getImage());
    }

    /**
     * Test of getUsername method.
     */
    @Test
    public void testGetUsername() {

        assertEquals("uuualusername", instance.getUsername());
        assertEquals("uuualusername", instance06.getUsername());
        assertEquals("uuualusername", instance07.getUsername());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailEntity, instance.getPersonalDetail());
        assertEquals(personalDetailEntity, instance06.getPersonalDetail());
        assertEquals(personalDetailEntity, instance07.getPersonalDetail());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(reviewer));

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
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(instance07));
        assertTrue(instance.hasSameParameters(reviewer));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());

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

        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance06));
        assertTrue(instance.equals(instance07));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(reviewer));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("ReviewerEntity{name=Ton Snigh, username=uuualusername}", instance.toString());
    }
}
