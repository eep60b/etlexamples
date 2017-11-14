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
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class PersonalDetailPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class PersonalDetailPojoTest {

    private final int id = 7736;
    private final int id1 = 2223;
    private final String title = "Mrss.";
    private final String title2 = "Ken.";
    private final String givenName = "ggTom";
    private final String givenName3 = "kkeno";
    private final String familyName = "Ssmitth";
    private final String familyName4 = "Gones";
    private final Date dateOfBirth = new Date(831904719074194141L);
    private final Date dateOfBirth5 = new Date(981934719219121111L);
    private final byte[] profile = {36, 19, 36, 37};
    private final byte[] profile6 = {60, 9, 16, 27};

    private final AuthorPojo authorPojo1 = Mockito.mock(AuthorPojo.class);
    private final AuthorPojo authorPojo2 = Mockito.mock(AuthorPojo.class);
    private final AuthorPojo authorPojo3 = Mockito.mock(AuthorPojo.class);
    private final AuthorPojo authorPojo4 = Mockito.mock(AuthorPojo.class);
    private final Set<AuthorPojo> authors = new HashSet<>(Arrays.asList(authorPojo1, authorPojo2, authorPojo3));
    private final Set<AuthorPojo> authors7 = new HashSet<>(Arrays.asList(authorPojo4, authorPojo2));
    private final Set<AuthorPojo> authors8 = null;

    private final AdministratorPojo administratorPojo1 = Mockito.mock(AdministratorPojo.class);
    private final AdministratorPojo administratorPojo2 = Mockito.mock(AdministratorPojo.class);
    private final AdministratorPojo administratorPojo3 = Mockito.mock(AdministratorPojo.class);
    private final AdministratorPojo administratorPojo4 = Mockito.mock(AdministratorPojo.class);
    private final Set<AdministratorPojo> administrators = new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo2, administratorPojo3));
    private final Set<AdministratorPojo> administrators9 = new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo4));
    private final Set<AdministratorPojo> administrators10 = null;

    private final ReviewerPojo reviewerPojo1 = Mockito.mock(ReviewerPojo.class);
    private final ReviewerPojo reviewerPojo2 = Mockito.mock(ReviewerPojo.class);
    private final ReviewerPojo reviewerPojo3 = Mockito.mock(ReviewerPojo.class);
    private final ReviewerPojo reviewerPojo4 = Mockito.mock(ReviewerPojo.class);
    private final Set<ReviewerPojo> reviewers = new HashSet<>(Arrays.asList(reviewerPojo1, reviewerPojo2, reviewerPojo3));
    private final Set<ReviewerPojo> reviewers11 = new HashSet<>(Arrays.asList(reviewerPojo3, reviewerPojo4));
    private final Set<ReviewerPojo> reviewers12 = null;

    private final PersonAddressLinkPojo personAddressLinkPojo1 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLinkPojo2 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLinkPojo3 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLinkPojo4 = Mockito.mock(PersonAddressLinkPojo.class);
    private final Set<PersonAddressLinkPojo> personAddressLinks = new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3));
    private final Set<PersonAddressLinkPojo> personAddressLinks13 = new HashSet<>(Arrays.asList(personAddressLinkPojo4, personAddressLinkPojo1, personAddressLinkPojo3));
    private final Set<PersonAddressLinkPojo> personAddressLinks14 = null;

    private final Email email1 = Mockito.mock(Email.class);
    private final Email email2 = Mockito.mock(Email.class);
    private final Email email3 = Mockito.mock(Email.class);
    private final Email email4 = Mockito.mock(Email.class);
    private final Set<Email> emails = new HashSet<>(Arrays.asList(email1, email2, email3));
    private final Set<Email> emails15 = new HashSet<>(Arrays.asList(email1, email4));
    private final Set<Email> emails16 = null;

    private final Telephone telephone1 = Mockito.mock(Telephone.class);
    private final Telephone telephone2 = Mockito.mock(Telephone.class);
    private final Telephone telephone3 = Mockito.mock(Telephone.class);
    private final Telephone telephone4 = Mockito.mock(Telephone.class);
    private final Set<Telephone> telephones = new HashSet<>(Arrays.asList(telephone1, telephone2, telephone3));
    private final Set<Telephone> telephones17 = new HashSet<>(Arrays.asList(telephone2, telephone4));
    private final Set<Telephone> telephones18 = null;

    private final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);

    private final PersonalDetailPojo instance = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance00 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance01 = new PersonalDetailPojo(id1, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance02 = new PersonalDetailPojo(id, title2, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance03 = new PersonalDetailPojo(id, title, givenName3, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance04 = new PersonalDetailPojo(id, title, givenName, familyName4, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance05 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth5, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance06 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile6, authors, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance07 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors7, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance08 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors8, administrators, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance09 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators9, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance10 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators10, reviewers, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance11 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers11, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance12 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers12, personAddressLinks, emails, telephones);
    private final PersonalDetailPojo instance13 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks13, emails, telephones);
    private final PersonalDetailPojo instance14 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks14, emails, telephones);
    private final PersonalDetailPojo instance15 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails15, telephones);
    private final PersonalDetailPojo instance16 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails16, telephones);
    private final PersonalDetailPojo instance17 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones17);
    private final PersonalDetailPojo instance18 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones18);
    private final PersonalDetailPojo instance19 = new PersonalDetailPojo();
    private final PersonalDetailPojo instance20 = new PersonalDetailPojo(title, givenName, familyName, dateOfBirth, profile);
    private final PersonalDetailPojo instance21 = new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile);
    private final PersonalDetailPojo instance22 = new PersonalDetailPojo(title, givenName, familyName, dateOfBirth, profile, emails, telephones);
    private final PersonalDetailPojo instance23 = new HibernateProxyPersonalDetailPojo(new PersonalDetailPojo(id, title, givenName, familyName, dateOfBirth, profile, authors, administrators, reviewers, personAddressLinks, emails, telephones));
    private PersonalDetailPojo instance24;

    @Before
    public void setUp() {
        Mockito.when(personalDetail.getDateOfBirth()).thenReturn(new Date(831904719074194141L));
        Mockito.when(personalDetail.getFamilyName()).thenReturn("Ssmitth");
        Mockito.when(personalDetail.getGivenName()).thenReturn("ggTom");
        Mockito.when(personalDetail.getProfile()).thenReturn(new byte[]{36, 19, 36, 37});
        Mockito.when(personalDetail.getTitle()).thenReturn("Mrss.");
        instance24 = new PersonalDetailPojo(personalDetail);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(7736, instance.getId());
        assertEquals(0, instance19.getId());
        assertEquals(0, instance24.getId());
        assertEquals(0, instance20.getId());
        assertEquals(7736, instance21.getId());
        assertEquals(0, instance22.getId());
        assertEquals(0, instance23.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(22341);
        assertEquals(22341, instance.getId());
    }

    /**
     * Test of getTitle method.
     */
    @Test
    public void testGetTitle() {

        assertEquals("Mrss.", instance.getTitle());
        assertNull(instance19.getTitle());
        assertEquals("Mrss.", instance24.getTitle());
        assertEquals("Mrss.", instance20.getTitle());
        assertEquals("Mrss.", instance21.getTitle());
        assertEquals("Mrss.", instance22.getTitle());
        assertNull(instance23.getTitle());
    }

    /**
     * Test of setTitle method.
     */
    @Test
    public void testSetTitle() {

        instance.setTitle("Dress.");
        assertEquals("Dress.", instance.getTitle());
    }

    /**
     * Test of getGivenName method.
     */
    @Test
    public void testGetGivenName() {

        assertEquals("ggTom", instance.getGivenName());
        assertNull(instance19.getGivenName());
        assertEquals("ggTom", instance24.getGivenName());
        assertEquals("ggTom", instance20.getGivenName());
        assertEquals("ggTom", instance21.getGivenName());
        assertEquals("ggTom", instance22.getGivenName());
        assertNull(instance23.getGivenName());
    }

    /**
     * Test of setGivenName method.
     */
    @Test
    public void testSetGivenName() {

        instance.setGivenName("keFred");
        assertEquals("keFred", instance.getGivenName());
    }

    /**
     * Test of getFamilyName method.
     */
    @Test
    public void testGetFamilyName() {

        assertEquals("Ssmitth", instance.getFamilyName());
        assertNull(instance19.getFamilyName());
        assertEquals("Ssmitth", instance24.getFamilyName());
        assertEquals("Ssmitth", instance20.getFamilyName());
        assertEquals("Ssmitth", instance21.getFamilyName());
        assertEquals("Ssmitth", instance22.getFamilyName());
        assertNull(instance23.getFamilyName());
    }

    /**
     * Test of setFamilyName method.
     */
    @Test
    public void testSetFamilyName() {

        instance.setFamilyName("fafaf");
        assertEquals("fafaf", instance.getFamilyName());
    }

    /**
     * Test of getDateOfBirth method.
     */
    @Test
    public void testGetDateOfBirth() {

        assertEquals(new Date(831904719074194141L), instance.getDateOfBirth());
        assertNull(instance19.getDateOfBirth());
        assertEquals(new Date(831904719074194141L), instance24.getDateOfBirth());
        assertEquals(new Date(831904719074194141L), instance20.getDateOfBirth());
        assertEquals(new Date(831904719074194141L), instance21.getDateOfBirth());
        assertEquals(new Date(831904719074194141L), instance22.getDateOfBirth());
        assertNull(instance23.getDateOfBirth());
    }

    /**
     * Test of setDateOfBirth method.
     */
    @Test
    public void testSetDateOfBirth() {

        instance.setDateOfBirth(new Date(76134871434141L));
        assertEquals(new Date(76134871434141L), instance.getDateOfBirth());
    }

    /**
     * Test of getProfile method.
     */
    @Test
    public void testGetProfile() {

        assertArrayEquals(new byte[]{36, 19, 36, 37}, instance.getProfile());
        assertNull(instance19.getProfile());
        assertArrayEquals(new byte[]{36, 19, 36, 37}, instance24.getProfile());
        assertArrayEquals(new byte[]{36, 19, 36, 37}, instance20.getProfile());
        assertArrayEquals(new byte[]{36, 19, 36, 37}, instance21.getProfile());
        assertArrayEquals(new byte[]{36, 19, 36, 37}, instance22.getProfile());
        assertNull(instance23.getProfile());
    }

    /**
     * Test of setProfile method.
     */
    @Test
    public void testSetProfile() {

        instance.setProfile(new byte[]{63, 22, 61, 61});
        assertArrayEquals(new byte[]{63, 22, 61, 61}, instance.getProfile());
    }

    /**
     * Test of getAuthors method.
     */
    @Test
    public void testGetAuthors() {

        assertEquals(new HashSet<>(Arrays.asList(authorPojo1, authorPojo2, authorPojo3)), instance.getAuthors());
        Set<AuthorPojo> result = instance.getAuthors();
        result.clear();
        assertEquals(new HashSet<>(Arrays.asList(authorPojo1, authorPojo2, authorPojo3)), instance.getAuthors());
        authors.clear();
        assertEquals(new HashSet<>(Arrays.asList(authorPojo1, authorPojo2, authorPojo3)), instance.getAuthors());

        assertNull(instance08.getAuthors());
        assertTrue(instance19.getAuthors().isEmpty());
        assertTrue(instance24.getAuthors().isEmpty());
        assertTrue(instance20.getAuthors().isEmpty());
        assertTrue(instance21.getAuthors().isEmpty());
        assertTrue(instance22.getAuthors().isEmpty());
        assertTrue(instance23.getAuthors().isEmpty());
    }

    /**
     * Test of setAuthors method.
     */
    @Test
    public void testSetAuthors() {

        Set<AuthorPojo> authorsK = new HashSet<>(Arrays.asList(authorPojo1, authorPojo2, authorPojo4));
        instance.setAuthors(authorsK);
        assertEquals(new HashSet<>(Arrays.asList(authorPojo1, authorPojo2, authorPojo4)), instance.getAuthors());
        authorsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(authorPojo1, authorPojo2, authorPojo4)), instance.getAuthors());

        instance.setAuthors(null);
        assertNull(instance.getAuthors());
    }

    /**
     * Test of getAdministrators method.
     */
    @Test
    public void testGetAdministrators() {

        assertEquals(new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo2, administratorPojo3)), instance.getAdministrators());
        instance.getAdministrators().clear();
        assertEquals(new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo2, administratorPojo3)), instance.getAdministrators());
        administrators.clear();
        assertEquals(new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo2, administratorPojo3)), instance.getAdministrators());

        assertNull(instance10.getAdministrators());
        assertTrue(instance19.getAdministrators().isEmpty());
        assertTrue(instance24.getAdministrators().isEmpty());
        assertTrue(instance20.getAdministrators().isEmpty());
        assertTrue(instance21.getAdministrators().isEmpty());
        assertTrue(instance22.getAdministrators().isEmpty());
        assertTrue(instance23.getAdministrators().isEmpty());
    }

    /**
     * Test of setAdministrators method.
     */
    @Test
    public void testSetAdministrators() {

        Set<AdministratorPojo> administratorsK = new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo3));
        instance.setAdministrators(administratorsK);
        assertEquals(new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo3)), instance.getAdministrators());

        administratorsK.add(administratorPojo2);
        assertEquals(new HashSet<>(Arrays.asList(administratorPojo1, administratorPojo3)), instance.getAdministrators());

        instance.setAdministrators(null);
        assertNull(instance.getAdministrators());
    }

    /**
     * Test of getReviewers method.
     */
    @Test
    public void testGetReviewers() {

        assertEquals(new HashSet<>(Arrays.asList(reviewerPojo1, reviewerPojo2, reviewerPojo3)), instance.getReviewers());
        Set<ReviewerPojo> result = instance.getReviewers();
        result.clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewerPojo1, reviewerPojo2, reviewerPojo3)), instance.getReviewers());
        reviewers.clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewerPojo1, reviewerPojo2, reviewerPojo3)), instance.getReviewers());

        assertNull(instance12.getReviewers());
        assertTrue(instance19.getReviewers().isEmpty());
        assertTrue(instance24.getReviewers().isEmpty());
        assertTrue(instance20.getReviewers().isEmpty());
        assertTrue(instance21.getReviewers().isEmpty());
        assertTrue(instance22.getReviewers().isEmpty());
        assertTrue(instance23.getReviewers().isEmpty());
    }

    /**
     * Test of setReviewers method.
     */
    @Test
    public void testSetReviewers() {

        Set<ReviewerPojo> reviewersK = new HashSet<>(Arrays.asList(reviewerPojo1, reviewerPojo2));
        instance.setReviewers(reviewersK);
        assertEquals(new HashSet<>(Arrays.asList(reviewerPojo1, reviewerPojo2)), instance.getReviewers());
        reviewersK.clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewerPojo1, reviewerPojo2)), instance.getReviewers());

        instance.setReviewers(null);
        assertNull(instance.getReviewers());
    }

    /**
     * Test of getPersonAddressLinks method.
     */
    @Test
    public void testGetPersonAddressLinks() {

        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3)), instance.getPersonAddressLinks());
        Set<PersonAddressLinkPojo> result = instance.getPersonAddressLinks();
        result.clear();
        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3)), instance.getPersonAddressLinks());
        personAddressLinks.clear();
        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3)), instance.getPersonAddressLinks());

        assertNull(instance14.getPersonAddressLinks());
        assertTrue(instance19.getPersonAddressLinks().isEmpty());
        assertTrue(instance24.getPersonAddressLinks().isEmpty());
        assertTrue(instance20.getPersonAddressLinks().isEmpty());
        assertTrue(instance21.getPersonAddressLinks().isEmpty());
        assertTrue(instance22.getPersonAddressLinks().isEmpty());
        assertTrue(instance23.getPersonAddressLinks().isEmpty());
    }

    /**
     * Test of setPersonAddressLinks method.
     */
    @Test
    public void testSetPersonAddressLinks() {

        Set<PersonAddressLinkPojo> personAddressLinksK = new HashSet<>(Arrays.asList(personAddressLinkPojo4));
        instance.setPersonAddressLinks(personAddressLinksK);
        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo4)), instance.getPersonAddressLinks());
        personAddressLinksK.clear();
        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo4)), instance.getPersonAddressLinks());

        instance.setPersonAddressLinks(null);
        assertNull(instance.getPersonAddressLinks());
    }

    /**
     * Test of getEmails method.
     */
    @Test
    public void testGetEmails() {

        assertEquals(new HashSet<>(Arrays.asList(email1, email2, email3)), instance.getEmails());
        Set<Email> result = instance.getEmails();
        result.clear();
        assertEquals(new HashSet<>(Arrays.asList(email1, email2, email3)), instance.getEmails());
        emails.clear();
        assertEquals(new HashSet<>(Arrays.asList(email1, email2, email3)), instance.getEmails());

        assertNull(instance16.getEmails());
        assertTrue(instance19.getEmails().isEmpty());
        assertTrue(instance24.getEmails().isEmpty());
        assertTrue(instance20.getEmails().isEmpty());
        assertTrue(instance21.getEmails().isEmpty());
        assertEquals(new HashSet<>(Arrays.asList(email1, email2, email3)), instance22.getEmails());
        assertTrue(instance23.getEmails().isEmpty());
    }

    /**
     * Test of setEmails method.
     */
    @Test
    public void testSetEmails() {

        Set<Email> emailsK = new HashSet<>(Arrays.asList(email2, email3));
        instance.setEmails(emailsK);
        assertEquals(new HashSet<>(Arrays.asList(email2, email3)), instance.getEmails());
        emailsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(email2, email3)), instance.getEmails());

        instance.setEmails(null);
        assertNull(instance.getEmails());
    }

    /**
     * Test of getTelephones method.
     */
    @Test
    public void testGetTelephones() {

        assertEquals(new HashSet<>(Arrays.asList(telephone1, telephone2, telephone3)), instance.getTelephones());
        Set<Telephone> result = instance.getTelephones();
        result.clear();
        assertEquals(new HashSet<>(Arrays.asList(telephone1, telephone2, telephone3)), instance.getTelephones());
        telephones.clear();
        assertEquals(new HashSet<>(Arrays.asList(telephone1, telephone2, telephone3)), instance.getTelephones());

        assertNull(instance18.getTelephones());
        assertTrue(instance19.getTelephones().isEmpty());
        assertTrue(instance24.getTelephones().isEmpty());
        assertTrue(instance20.getTelephones().isEmpty());
        assertTrue(instance21.getTelephones().isEmpty());
        assertEquals(new HashSet<>(Arrays.asList(telephone1, telephone2, telephone3)), instance22.getTelephones());
        assertTrue(instance23.getTelephones().isEmpty());

    }

    /**
     * Test of setTelephones method.
     */
    @Test
    public void testSetTelephones() {

        Set<Telephone> telephonesK = new HashSet<>(Arrays.asList(telephone2, telephone3));
        instance.setTelephones(telephonesK);
        assertEquals(new HashSet<>(Arrays.asList(telephone2, telephone3)), instance.getTelephones());

        telephonesK.clear();
        assertEquals(new HashSet<>(Arrays.asList(telephone2, telephone3)), instance.getTelephones());

        instance.setTelephones(null);
        assertNull(instance.getTelephones());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());
        assertEquals(instance11.hashCode(), instance.hashCode());
        assertEquals(instance13.hashCode(), instance.hashCode());
        assertEquals(instance15.hashCode(), instance.hashCode());
        assertEquals(instance17.hashCode(), instance.hashCode());
        assertEquals(instance23.hashCode(), instance.hashCode());

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
        assertTrue(instance.equals(instance07));
        assertTrue(instance.equals(instance09));
        assertTrue(instance.equals(instance11));
        assertTrue(instance.equals(instance13));
        assertTrue(instance.equals(instance15));
        assertTrue(instance.equals(instance17));
        assertTrue(instance.equals(instance23));
        assertTrue(instance23.equals(instance));

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
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance.hasSameConstraint(instance13));
        assertTrue(instance.hasSameConstraint(instance15));
        assertTrue(instance.hasSameConstraint(instance17));
        assertTrue(instance.hasSameConstraint(instance23));
        assertTrue(instance23.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(personalDetail));

        assertFalse(instance.hasSameConstraint(instance06));
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
        assertTrue(instance.hasSameParameters(instance07));
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance.hasSameParameters(instance11));
        assertTrue(instance.hasSameParameters(instance13));
        assertTrue(instance.hasSameParameters(instance15));
        assertTrue(instance.hasSameParameters(instance17));
        assertTrue(instance.hasSameParameters(instance23));
        assertTrue(instance23.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(personalDetail));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(null));
    }

    @Test
    public void testToString() {
        assertEquals("PersonalDetailPojo{id=7736, title=Mrss., given name=ggTom, family name=Ssmitth}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance19));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyPersonalDetailPojo extends PersonalDetailPojo implements HibernateProxy {

        private static final long serialVersionUID = 507561526296375148L;

        private final PersonalDetailPojo pojo;

        public HibernateProxyPersonalDetailPojo(PersonalDetailPojo pojo) {

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
                public PersonalDetailPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
