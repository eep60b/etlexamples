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
import com.etlsolutions.examples.data.specific.person.AdministratorEntity;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.PersonalPassword;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.PersonalUsername;
import com.etlsolutions.examples.data.api.Administrator;
import com.etlsolutions.examples.data.api.AdministratorRole;
import com.etlsolutions.examples.data.api.PersonalDetail;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class AdministratorEntity.
 *
 * @author Zhipeng Chang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AdministratorEntity.class, PersonalDetailEntity.class, Date.class, PersonalTitle.class, GivenName.class, FamilyName.class, DateOfBirth.class, PersonalProfile.class})
public final class AdministratorEntityTest {

    private final PersonalDetailEntity personalDetailEntity = PowerMockito.mock(PersonalDetailEntity.class);
    private final PersonalDetailEntity personalDetailEntity1 = PowerMockito.mock(PersonalDetailEntity.class);
    private final PersonalPassword passwordColumn = new PersonalPassword("adakkkan,");
    private final PersonalPassword passwordColumn2 = new PersonalPassword("11adakkkan,");
    private final PersonalUsername usernameColumn = new PersonalUsername("usususer");
    private final PersonalUsername usernameColumn3 = new PersonalUsername("kssksisl");
    private final Administrator administrator = Mockito.mock(Administrator.class);
    private final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);

    private final AdministratorEntity instance = new AdministratorEntity(personalDetailEntity, passwordColumn, usernameColumn, AdministratorRole.OPERATOR);
    private final AdministratorEntity instance00 = new AdministratorEntity(personalDetailEntity, passwordColumn, usernameColumn, AdministratorRole.OPERATOR);
    private final AdministratorEntity instance01 = new AdministratorEntity(personalDetailEntity1, passwordColumn, usernameColumn, AdministratorRole.OPERATOR);
    private final AdministratorEntity instance02 = new AdministratorEntity(personalDetailEntity, passwordColumn2, usernameColumn, AdministratorRole.OPERATOR);
    private final AdministratorEntity instance03 = new AdministratorEntity(personalDetailEntity, passwordColumn, usernameColumn3, AdministratorRole.OPERATOR);
    private final AdministratorEntity instance04 = new AdministratorEntity(personalDetailEntity, passwordColumn, usernameColumn, AdministratorRole.ADMIN);
    private AdministratorEntity instance05;
    private AdministratorEntity instance06;

    @Before
    public void setUp() throws Exception {

        Mockito.when(personalDetail.getTitle()).thenReturn("TiTi");
        Mockito.when(personalDetail.getGivenName()).thenReturn("giiv");
        Mockito.when(personalDetail.getFamilyName()).thenReturn("famfm");
        Date date = PowerMockito.mock(Date.class);
        Mockito.when(personalDetail.getDateOfBirth()).thenReturn(date);
        byte[] prof = new byte[]{29, 38, 62};
        Mockito.when(personalDetail.getProfile()).thenReturn(prof);

        PersonalTitle personTitleColumn = PowerMockito.mock(PersonalTitle.class);
        GivenName givenNameColumn = PowerMockito.mock(GivenName.class);
        FamilyName familyNameColumn = PowerMockito.mock(FamilyName.class);
        DateOfBirth dateOfBirthColumn = PowerMockito.mock(DateOfBirth.class);
        PersonalProfile personalProfileColumn = PowerMockito.mock(PersonalProfile.class);

        PowerMockito.whenNew(PersonalTitle.class).withArguments("TiTi").thenReturn(personTitleColumn);
        PowerMockito.whenNew(GivenName.class).withArguments("giiv").thenReturn(givenNameColumn);
        PowerMockito.whenNew(FamilyName.class).withArguments("famfm").thenReturn(familyNameColumn);
        PowerMockito.whenNew(DateOfBirth.class).withArguments(date).thenReturn(dateOfBirthColumn);
        PowerMockito.whenNew(PersonalProfile.class).withArguments(prof).thenReturn(personalProfileColumn);

        PowerMockito.whenNew(PersonalDetailEntity.class).withArguments(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn).thenReturn(personalDetailEntity);

        instance05 = new AdministratorEntity(personalDetail, passwordColumn, usernameColumn, AdministratorRole.OPERATOR);

        Mockito.when(administrator.getPassword()).thenReturn("adakkkan,");
        Mockito.when(administrator.getPersonalDetail()).thenReturn(personalDetailEntity);
        Mockito.when(administrator.getRole()).thenReturn(AdministratorRole.OPERATOR);
        Mockito.when(administrator.getUsername()).thenReturn("usususer");

        instance06 = new AdministratorEntity(administrator);
    }

    /**
     * Test of getPassword method.
     */
    @Test
    public void testGetPassword() {

        assertEquals("adakkkan,", instance.getPassword());
        assertEquals("11adakkkan,", instance02.getPassword());
        assertEquals("adakkkan,", instance05.getPassword());
        assertEquals("adakkkan,", instance06.getPassword());
    }

    /**
     * Test of getRole method.
     */
    @Test
    public void testGetRole() {

        assertEquals(AdministratorRole.OPERATOR, instance.getRole());
        assertEquals(AdministratorRole.ADMIN, instance04.getRole());
        assertEquals(AdministratorRole.OPERATOR, instance05.getRole());
        assertEquals(AdministratorRole.OPERATOR, instance06.getRole());
    }

    /**
     * Test of getUsername method.
     */
    @Test
    public void testGetUsername() {

        assertEquals("usususer", instance.getUsername());
        assertEquals("kssksisl", instance03.getUsername());
        assertEquals("usususer", instance05.getUsername());
        assertEquals("usususer", instance06.getUsername());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailEntity, instance.getPersonalDetail());
        assertEquals(personalDetailEntity1, instance01.getPersonalDetail());
        assertEquals(personalDetailEntity, instance05.getPersonalDetail());
        assertEquals(personalDetailEntity, instance06.getPersonalDetail());
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
        assertTrue(instance.equals(instance05));
        assertTrue(instance.equals(instance06));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(administrator));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("AdministratorEntity{username=usususer}", instance.toString());
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
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(administrator));

        assertFalse(instance.hasSameConstraint(instance03));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(administrator));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
    }

}
