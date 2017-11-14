/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.ha.pojo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zhipeng
 */
public class EmailPojoTest {
    
    public EmailPojoTest() {
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
     * Test of getId method, of class EmailPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        EmailPojo instance = new EmailPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class EmailPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        EmailPojo instance = new EmailPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonalDetail method, of class EmailPojo.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        EmailPojo instance = new EmailPojo();
        PersonalDetailPojo expResult = null;
        PersonalDetailPojo result = instance.getPersonalDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonalDetail method, of class EmailPojo.
     */
    @Test
    public void testSetPerson() {
        System.out.println("setPerson");
        PersonalDetailPojo person = null;
        EmailPojo instance = new EmailPojo();
        instance.setPersonalDetail(person);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailAddress method, of class EmailPojo.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        EmailPojo instance = new EmailPojo();
        String expResult = "";
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailAddress method, of class EmailPojo.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        String emailAddress = "";
        EmailPojo instance = new EmailPojo();
        instance.setEmailAddress(emailAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class EmailPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        EmailPojo instance = new EmailPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class EmailPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        EmailPojo instance = new EmailPojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
