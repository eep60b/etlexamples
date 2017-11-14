/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.ha.pojo;

import java.util.Date;
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
public class DebitcardPaymentPojoTest {
    
    public DebitcardPaymentPojoTest() {
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
     * Test of getId method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentDetail method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetPayment() {
        System.out.println("getPayment");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        PaymentDetailPojo expResult = null;
        PaymentDetailPojo result = instance.getPaymentDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentDetail method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetPayment() {
        System.out.println("setPayment");
        PaymentDetailPojo payment = null;
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setPaymentDetail(payment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonAddressLink method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetPersonAddressLink() {
        System.out.println("getPersonAddressLink");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        PersonAddressLinkPojo expResult = null;
        PersonAddressLinkPojo result = instance.getPersonAddressLink();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonAddressLink method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetPersonAddressLink() {
        System.out.println("setPersonAddressLink");
        PersonAddressLinkPojo personAddressLink = null;
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setPersonAddressLink(personAddressLink);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardNumber method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetCardNumber() {
        System.out.println("getCardNumber");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        String expResult = "";
        String result = instance.getCardNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCardNumber method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetCardNumber() {
        System.out.println("setCardNumber");
        String cardNumber = "";
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setCardNumber(cardNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecurityCode method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetSecurityCode() {
        System.out.println("getSecurityCode");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        String expResult = "";
        String result = instance.getSecurityCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecurityCode method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetSecurityCode() {
        System.out.println("setSecurityCode");
        String securityCode = "";
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setSecurityCode(securityCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIssueNumber method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetIssueNumber() {
        System.out.println("getIssueNumber");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        Integer expResult = null;
        Integer result = instance.getIssueNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIssueNumber method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetIssueNumber() {
        System.out.println("setIssueNumber");
        Integer issueNumber = null;
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setIssueNumber(issueNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpireDate method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testGetExpireDate() {
        System.out.println("getExpireDate");
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        Date expResult = null;
        Date result = instance.getExpireDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpireDate method, of class DebitcardPaymentPojo.
     */
    @Test
    public void testSetExpireDate() {
        System.out.println("setExpireDate");
        Date expireDate = null;
        DebitcardPaymentPojo instance = new DebitcardPaymentPojo();
        instance.setExpireDate(expireDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
