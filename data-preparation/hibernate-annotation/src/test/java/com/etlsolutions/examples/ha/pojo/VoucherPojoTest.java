/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.ha.pojo;

import com.etlsolutions.examples.data.api.Voucher;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class VoucherPojo.
 *
 * @author Zhipeng Chang
 */
public class VoucherPojoTest {

    public VoucherPojoTest() {
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
        VoucherPojo instance = new VoucherPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class VoucherPojo.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        VoucherPojo instance = new VoucherPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class VoucherPojo.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        BigDecimal total = null;
        VoucherPojo instance = new VoucherPojo();
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class VoucherPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        VoucherPojo instance = new VoucherPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class VoucherPojo.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        VoucherPojo instance = new VoucherPojo();
        CustomerPojo expResult = null;
        CustomerPojo result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer method, of class VoucherPojo.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        CustomerPojo customer = null;
        VoucherPojo instance = new VoucherPojo();
        instance.setCustomer(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVoucherToken method, of class VoucherPojo.
     */
    @Test
    public void testGetVoucherToken() {
        System.out.println("getVoucherToken");
        VoucherPojo instance = new VoucherPojo();
        String expResult = "";
        String result = instance.getVoucherToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVoucherToken method, of class VoucherPojo.
     */
    @Test
    public void testSetVoucherToken() {
        System.out.println("setVoucherToken");
        String voucherToken = "";
        VoucherPojo instance = new VoucherPojo();
        instance.setVoucherToken(voucherToken);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpireDate method, of class VoucherPojo.
     */
    @Test
    public void testSetExpireDate() {
        System.out.println("setExpireDate");
        Date expireDate = null;
        VoucherPojo instance = new VoucherPojo();
        instance.setExpireDate(expireDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpireDate method, of class VoucherPojo.
     */
    @Test
    public void testGetExpireDate() {
        System.out.println("getExpireDate");
        VoucherPojo instance = new VoucherPojo();
        Date expResult = null;
        Date result = instance.getExpireDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentDetails method, of class VoucherPojo.
     */
    @Test
    public void testGetPaymentDetails() {
        System.out.println("getPaymentDetails");
        VoucherPojo instance = new VoucherPojo();
        Set<PaymentDetailPojo> expResult = null;
        Set<PaymentDetailPojo> result = instance.getPaymentDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentDetails method, of class VoucherPojo.
     */
    @Test
    public void testSetPaymentDetails() {
        System.out.println("setPaymentDetails");
        Set<PaymentDetailPojo> paymentDetails = null;
        VoucherPojo instance = new VoucherPojo();
        instance.setPaymentDetails(paymentDetails);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameConstraint method, of class VoucherPojo.
     */
    @Test
    public void testHasSameConstraint() {
        System.out.println("hasSameConstraint");
        Voucher voucher = null;
        VoucherPojo instance = new VoucherPojo();
        boolean expResult = false;
        boolean result = instance.hasSameConstraint(voucher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSameParameters method, of class VoucherPojo.
     */
    @Test
    public void testHasSameParameters() {
        System.out.println("hasSameParameters");
        Voucher voucher = null;
        VoucherPojo instance = new VoucherPojo();
        boolean expResult = false;
        boolean result = instance.hasSameParameters(voucher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class VoucherPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        VoucherPojo instance = new VoucherPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class VoucherPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        VoucherPojo instance = new VoucherPojo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
