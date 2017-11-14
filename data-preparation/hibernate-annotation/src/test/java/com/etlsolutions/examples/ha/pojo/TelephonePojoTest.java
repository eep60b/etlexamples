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

import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.ha.control.DataRetriever;
import com.etlsolutions.examples.ha.control.QueryNames;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class TelephonePojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class TelephonePojoTest {

    private final TelephonePojo instance = new TelephonePojo();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetTelephoneId() {
        assertEquals(0, instance.getId());
    }

    @Test
    public void testSetTelephoneId() {
        int telephoneId = 2545;
        instance.setId(telephoneId);
        assertEquals(telephoneId, instance.getId());
    }

    @Test
    public void testGetCountryCode() {
        assertNull(instance.getCountryCode());
    }

    @Test
    public void testSetCountryCode() {
        String countryCode = "45";
        instance.setCountryCode(countryCode);
        assertEquals(countryCode, instance.getCountryCode());
    }

    @Test
    public void testGetTelephoneType() {
        assertNull(instance.getTelephoneType());
    }

    @Test
    public void testSetTelephoneType() {
        instance.setTelephoneType(TelephoneType.MOBILE);
        assertEquals(TelephoneType.MOBILE, instance.getTelephoneType());
    }

    @Test
    public void testGetTelephoneNumber() {
        assertNull(instance.getTelephoneNumber());
    }

    @Test
    public void testSetTelephoneNumber() {
        String telephoneNumber = "97643832";
        instance.setTelephoneNumber(telephoneNumber);
        assertEquals(telephoneNumber, instance.getTelephoneNumber());
    }

    @Test
    public void testGetPersons() {
        assertTrue(instance.getPersonalDetails().isEmpty());
    }

    @Test
    public void testSetPersons() {
        Set<PersonalDetailPojo> persons = new HashSet<>();
        instance.setPersonalDetails(persons);
        assertEquals(persons, instance.getPersonalDetails());
    }

    @Test
    public void testQueries() {
        DataRetriever retriever = new DataRetriever();
        List<TelephonePojo> list = retriever.<TelephonePojo>findAll(QueryNames.findTelephones);
        assertEquals(4, list.size());
        assertEquals("644515", list.get(0).getTelephoneNumber());
    }

    /**
     * Test of getId method, of class TelephonePojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TelephonePojo instance = new TelephonePojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class TelephonePojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        TelephonePojo instance = new TelephonePojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAreaCode method, of class TelephonePojo.
     */
    @Test
    public void testGetAreaCode() {
        System.out.println("getAreaCode");
        TelephonePojo instance = new TelephonePojo();
        String expResult = "";
        String result = instance.getAreaCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAreaCode method, of class TelephonePojo.
     */
    @Test
    public void testSetAreaCode() {
        System.out.println("setAreaCode");
        String areaCode = "";
        TelephonePojo instance = new TelephonePojo();
        instance.setAreaCode(areaCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonalDetails method, of class TelephonePojo.
     */
    @Test
    public void testGetPersonalDetails() {
        System.out.println("getPersonalDetails");
        TelephonePojo instance = new TelephonePojo();
        Set<PersonalDetailPojo> expResult = null;
        Set<PersonalDetailPojo> result = instance.getPersonalDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonalDetails method, of class TelephonePojo.
     */
    @Test
    public void testSetPersonalDetails() {
        System.out.println("setPersonalDetails");
        Set<PersonalDetailPojo> personalDetails = null;
        TelephonePojo instance = new TelephonePojo();
        instance.setPersonalDetails(personalDetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameConstraint method, of class TelephonePojo.
     */
    @Test
    public void testHasSameConstraint() {
        System.out.println("hasSameConstraint");
        Telephone constraintable = null;
        TelephonePojo instance = new TelephonePojo();
        boolean expResult = false;
        boolean result = instance.hasSameConstraint(constraintable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameParameters method, of class TelephonePojo.
     */
    @Test
    public void testHasSameParameters() {
        System.out.println("hasSameParameters");
        Telephone constraintable = null;
        TelephonePojo instance = new TelephonePojo();
        boolean expResult = false;
        boolean result = instance.hasSameParameters(constraintable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class TelephonePojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TelephonePojo instance = new TelephonePojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TelephonePojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        TelephonePojo instance = new TelephonePojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
