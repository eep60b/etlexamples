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
package com.etlsolutions.examples.ha.pojo;

import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.Email;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.data.api.Telephone;
import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    public PersonalDetailPojoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGivenName method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetGivenName() {
        System.out.println("getGivenName");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        String expResult = "";
        String result = instance.getGivenName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGivenName method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetGivenName() {
        System.out.println("setGivenName");
        String personGivenName = "";
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setGivenName(personGivenName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFamilyName method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetFamilyName() {
        System.out.println("getFamilyName");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        String expResult = "";
        String result = instance.getFamilyName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFamilyName method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetFamilyName() {
        System.out.println("setFamilyName");
        String personFamilyName = "";
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setFamilyName(personFamilyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfBirth method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        Date expResult = null;
        Date result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOfBirth method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetDateOfBirth() {
        System.out.println("setDateOfBirth");
        Date dateOfBirth = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setDateOfBirth(dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonAddressLinks method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetPersonAddressLinks() {
        System.out.println("getPersonAddressLinks");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        Set<PersonAddressLink> expResult = null;
        Set<PersonAddressLink> result = instance.getPersonAddressLinks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonAddressLinks method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetPersonAddressLinks() {
        System.out.println("setPersonAddressLinks");
        Set<PersonAddressLink> personAddressLinks = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setPersonAddressLinks(personAddressLinks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdministrators method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetAdministrators() {
        System.out.println("getAdministrators");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        Set expResult = null;
        Set result = instance.getAdministrators();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdministrators method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetAdministrators() {
        System.out.println("setAdministrators");
        Set administrators = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setAdministrators(administrators);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthors method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetAuthors() {
        System.out.println("getAuthors");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        Set<Author> expResult = null;
        Set<Author> result = instance.getAuthors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthors method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetAuthors() {
        System.out.println("setAuthors");
        Set<Author> authors = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setAuthors(authors);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelephones method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetTelephones() {
        System.out.println("getTelephones");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        Set<Telephone> expResult = null;
        Set<Telephone> result = instance.getTelephones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelephones method.
     */
    @Test
    public void testSetTelephones() {
        System.out.println("setTelephones");
        Set<Telephone> telephones = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setTelephones(telephones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReviewers method.
     */
    @Test
    public void testGetReviewers() {
        System.out.println("getReviewers");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        Set<Reviewer> expResult = null;
        Set<Reviewer> result = instance.getReviewers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReviewers method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetReviewers() {
        System.out.println("setReviewers");
        Set<Reviewer> reviewers = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setReviewers(reviewers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmails method.
     */
    @Test
    public void testGetEmails() {
        System.out.println("getEmails");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        Set<Email> expResult = null;
        Set<Email> result = instance.getEmails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmails method.
     */
    @Test
    public void testSetEmails() {
        System.out.println("setEmails");
        Set<Email> emails = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setEmails(emails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class PersonalDetailPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class PersonalDetailPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfile method, of class PersonalDetailPojo.
     */
    @Test
    public void testSetProfile() {
        System.out.println("setProfile");
        byte[] profile = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        instance.setProfile(profile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfile method, of class PersonalDetailPojo.
     */
    @Test
    public void testGetProfile() {
        System.out.println("getProfile");
        PersonalDetailPojo instance = new PersonalDetailPojo();
        byte[] expResult = null;
        byte[] result = instance.getProfile();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameConstraint method, of class PersonalDetailPojo.
     */
    @Test
    public void testHasSameConstraint() {
        System.out.println("hasSameConstraint");
        PersonalDetail personalDetail = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        boolean expResult = false;
        boolean result = instance.hasSameConstraint(personalDetail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameParameters method, of class PersonalDetailPojo.
     */
    @Test
    public void testHasSameParameters() {
        System.out.println("hasSameParameters");
        PersonalDetail personalDetail = null;
        PersonalDetailPojo instance = new PersonalDetailPojo();
        boolean expResult = false;
        boolean result = instance.hasSameParameters(personalDetail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
