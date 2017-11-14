/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.ha.pojo;

import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PersonAddressLinkPojo.
 *
 * @author Zhipeng Chang
 */
public class PersonAddressLinkPojoTest {

    public PersonAddressLinkPojoTest() {
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
     * Test of getId method.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        AddressPojo expResult = null;
        AddressPojo result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        AddressPojo address = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {
        System.out.println("getPersonalDetail");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        PersonalDetailPojo expResult = null;
        PersonalDetailPojo result = instance.getPersonalDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonalDetail method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetPersonalDetail() {
        System.out.println("setPersonalDetail");
        PersonalDetailPojo personalAddress = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setPersonalDetail(personalAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressType method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetAddressType() {
        System.out.println("setAddressType");
        AddressType addresstype = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setAddressType(addresstype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressType method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testGetAddressType() {
        System.out.println("getAddressType");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        AddressType expResult = null;
        AddressType result = instance.getAddressType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMastercardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testGetMastercardPayments() {
        System.out.println("getMastercardPayments");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        Set<MastercardPaymentPojo> expResult = null;
        Set<MastercardPaymentPojo> result = instance.getMastercardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMastercardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetMastercardPayments() {
        System.out.println("setMastercardPayments");
        Set<MastercardPaymentPojo> mastercardPayments = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setMastercardPayments(mastercardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVisacardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testGetVisacardPayments() {
        System.out.println("getVisacardPayments");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        Set<VisacardPaymentPojo> expResult = null;
        Set<VisacardPaymentPojo> result = instance.getVisacardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVisacardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetVisacardPayments() {
        System.out.println("setVisacardPayments");
        Set<VisacardPaymentPojo> visacardPayments = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setVisacardPayments(visacardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebitcardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testGetDebitcardPayments() {
        System.out.println("getDebitcardPayments");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        Set<DebitcardPaymentPojo> expResult = null;
        Set<DebitcardPaymentPojo> result = instance.getDebitcardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebitcardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetDebitcardPayments() {
        System.out.println("setDebitcardPayments");
        Set<DebitcardPaymentPojo> debitcardPayments = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setDebitcardPayments(debitcardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmexcardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testGetAmexcardPayments() {
        System.out.println("getAmexcardPayments");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        Set<AmexcardPaymentPojo> expResult = null;
        Set<AmexcardPaymentPojo> result = instance.getAmexcardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmexcardPayments method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetAmexcardPayments() {
        System.out.println("setAmexcardPayments");
        Set<AmexcardPaymentPojo> amexcardPayments = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setAmexcardPayments(amexcardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomers method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testGetCustomers() {
        System.out.println("getCustomers");
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        Set<CustomerPojo> expResult = null;
        Set<CustomerPojo> result = instance.getCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomers method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testSetCustomers() {
        System.out.println("setCustomers");
        Set<CustomerPojo> customers = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        instance.setCustomers(customers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameConstraint method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testHasSameConstraint() {
        System.out.println("hasSameConstraint");
        PersonAddressLink constraintable = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        boolean expResult = false;
        boolean result = instance.hasSameConstraint(constraintable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameParameters method, of class PersonAddressLinkPojo.
     */
    @Test
    public void testHasSameParameters() {
        System.out.println("hasSameParameters");
        PersonAddressLink constraintable = null;
        PersonAddressLinkPojo instance = new PersonAddressLinkPojo();
        boolean expResult = false;
        boolean result = instance.hasSameParameters(constraintable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
