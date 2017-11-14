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
import com.etlsolutions.examples.data.specific.person.PersonalBiography;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.ImageBytes;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.AuthorEntity;
import com.etlsolutions.examples.data.specific.person.WebpageUrl;
import com.etlsolutions.examples.data.api.Author;
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
 * Test of class AuthorEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AuthorEntity.class, PersonalDetailEntity.class, PersonalTitle.class, GivenName.class, FamilyName.class, DateOfBirth.class, PersonalProfile.class, Date.class})
public class AuthorEntityTest {

    private final Author author = Mockito.mock(Author.class);

    public final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);
    public final PersonalDetailEntity personalDetailEntity = PowerMockito.mock(PersonalDetailEntity.class);
    public final PersonalDetailEntity personalDetailEntity1 = PowerMockito.mock(PersonalDetailEntity.class);
    public final PersonalBiography biographyColumn = new PersonalBiography(new byte[]{54, 22, 63});
    public final PersonalBiography biographyColumn2 = new PersonalBiography(new byte[]{5, 31, 13});
    public final WebpageUrl webPageUrlColumn = new WebpageUrl("local.tests.com");
    public final WebpageUrl webPageUrlColumn3 = new WebpageUrl("localx.testx.com");
    public final ImageBytes imageColumn = new ImageBytes(new byte[]{49, 33, 72});
    public final ImageBytes imageColumn4 = new ImageBytes(new byte[]{7, 91, 23});

    private final AuthorEntity instance = new AuthorEntity(personalDetailEntity, biographyColumn, webPageUrlColumn, imageColumn);
    private final AuthorEntity instance0 = new AuthorEntity(personalDetailEntity, biographyColumn, webPageUrlColumn, imageColumn);
    private final AuthorEntity instance1 = new AuthorEntity(personalDetailEntity1, biographyColumn, webPageUrlColumn, imageColumn);
    private final AuthorEntity instance2 = new AuthorEntity(personalDetailEntity, biographyColumn2, webPageUrlColumn, imageColumn);
    private final AuthorEntity instance3 = new AuthorEntity(personalDetailEntity, biographyColumn, webPageUrlColumn3, imageColumn);
    private final AuthorEntity instance4 = new AuthorEntity(personalDetailEntity, biographyColumn, webPageUrlColumn, imageColumn4);
    private final AuthorEntity instance5 = new AuthorEntity(instance);
    private AuthorEntity instance6;

    @Before
    public void setUp() throws Exception {

        Mockito.when(author.getPersonalDetail()).thenReturn(personalDetail);
        Mockito.when(author.getImage()).thenReturn(new byte[]{49, 33, 72});
        Mockito.when(author.getWebpageUrl()).thenReturn("local.tests.com");
        Mockito.when(author.getBiography()).thenReturn(new byte[]{54, 22, 63});

        PersonalTitle personTitleColumn = PowerMockito.mock(PersonalTitle.class);
        GivenName givenNameColumn = PowerMockito.mock(GivenName.class);
        FamilyName familyNameColumn = PowerMockito.mock(FamilyName.class);
        DateOfBirth dateOfBirthColumn = PowerMockito.mock(DateOfBirth.class);
        PersonalProfile personalProfileColumn = PowerMockito.mock(PersonalProfile.class);

        Date date = PowerMockito.mock(Date.class);
        byte[] prof = {22, 11, 77};

        Mockito.when(personalDetail.getTitle()).thenReturn("tilltl");
        Mockito.when(personalDetail.getGivenName()).thenReturn("TONNy");
        Mockito.when(personalDetail.getFamilyName()).thenReturn("Famouse");
        Mockito.when(personalDetail.getDateOfBirth()).thenReturn(date);
        Mockito.when(personalDetail.getProfile()).thenReturn(prof);

        PowerMockito.whenNew(PersonalTitle.class).withArguments("tilltl").thenReturn(personTitleColumn);
        PowerMockito.whenNew(GivenName.class).withArguments("TONNy").thenReturn(givenNameColumn);
        PowerMockito.whenNew(FamilyName.class).withArguments("Famouse").thenReturn(familyNameColumn);
        PowerMockito.whenNew(DateOfBirth.class).withArguments(date).thenReturn(dateOfBirthColumn);
        PowerMockito.whenNew(PersonalProfile.class).withArguments(prof).thenReturn(personalProfileColumn);

        PowerMockito.whenNew(PersonalDetailEntity.class).withArguments(personTitleColumn, givenNameColumn, familyNameColumn, dateOfBirthColumn, personalProfileColumn).thenReturn(personalDetailEntity);

        instance6 = new AuthorEntity(author);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_author() {
        new AuthorEntity(null);
    }

    /**
     * Test of getBiography method.
     */
    @Test
    public void testGetBiography() {

        byte[] expResult = {54, 22, 63};
        assertArrayEquals(expResult, instance.getBiography());
        assertArrayEquals(expResult, instance5.getBiography());
        assertArrayEquals(expResult, instance6.getBiography());
    }

    /**
     * Test of getWebpageUrl method.
     */
    @Test
    public void testGetWebpageUrl() {

        String expResult = "local.tests.com";

        assertEquals(expResult, instance.getWebpageUrl());
        assertEquals(expResult, instance5.getWebpageUrl());
        assertEquals(expResult, instance6.getWebpageUrl());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        byte[] expResult = {49, 33, 72};

        assertArrayEquals(expResult, instance.getImage());
        assertArrayEquals(expResult, instance5.getImage());
        assertArrayEquals(expResult, instance6.getImage());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailEntity, instance.getPersonalDetail());
        assertEquals(personalDetailEntity, instance5.getPersonalDetail());
        assertEquals(personalDetailEntity, instance6.getPersonalDetail());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance0.hashCode(), instance.hashCode());
        assertEquals(instance2.hashCode(), instance.hashCode());
        assertEquals(instance4.hashCode(), instance.hashCode());
        assertEquals(instance5.hashCode(), instance.hashCode());
        assertEquals(instance6.hashCode(), instance.hashCode());

        assertNotEquals(instance1.hashCode(), instance.hashCode());
        assertNotEquals(instance3.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance0));
        assertTrue(instance.equals(instance5));
        assertTrue(instance.equals(instance6));

        assertFalse(instance.equals(instance1));
        assertFalse(instance.equals(instance2));
        assertFalse(instance.equals(instance3));
        assertFalse(instance.equals(instance4));
        assertFalse(instance.equals(author));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        Mockito.when(personalDetailEntity.hasSameConstraint(personalDetailEntity)).thenReturn(Boolean.TRUE);
        Mockito.when(personalDetailEntity.hasSameConstraint(personalDetail)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance0));
        assertTrue(instance.hasSameConstraint(instance2));
        assertTrue(instance.hasSameConstraint(instance3));
        assertTrue(instance.hasSameConstraint(instance4));
        assertTrue(instance.hasSameConstraint(instance5));
        assertTrue(instance.hasSameConstraint(instance6));
        assertTrue(instance.hasSameConstraint(author));

        assertFalse(instance.hasSameConstraint(instance1));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        Mockito.when(personalDetailEntity.hasSameParameters(personalDetailEntity)).thenReturn(Boolean.TRUE);
        Mockito.when(personalDetailEntity.hasSameParameters(personalDetail)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance0));
        assertTrue(instance.hasSameParameters(instance5));
        assertTrue(instance.hasSameParameters(instance6));
        assertTrue(instance.hasSameParameters(author));

        assertFalse(instance.hasSameParameters(instance1));
        assertFalse(instance.hasSameParameters(instance2));
        assertFalse(instance.hasSameParameters(instance3));
        assertFalse(instance.hasSameParameters(instance4));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("AuthorEntity{" + "personalDetail=" + personalDetailEntity + '}', instance.toString());
    }

}
