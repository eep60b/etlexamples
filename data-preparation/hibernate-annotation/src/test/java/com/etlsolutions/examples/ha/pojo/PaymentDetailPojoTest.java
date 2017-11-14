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

import com.etlsolutions.examples.data.api.AmexcardPayment;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.DebitcardPayment;
import com.etlsolutions.examples.data.api.MastercardPayment;
import com.etlsolutions.examples.data.api.PaymentType;
import com.etlsolutions.examples.data.api.PaypalPayment;
import com.etlsolutions.examples.data.api.VisacardPayment;
import com.etlsolutions.examples.data.api.Voucher;
import com.etlsolutions.examples.data.api.VoucherPayment;
import java.math.BigDecimal;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PaymentDetailPojo.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public class PaymentDetailPojoTest {

    public PaymentDetailPojoTest() {
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
     * Test of getIdObject method.
     */
    @Test
    public void testGetIdObject() {
        System.out.println("getIdObject");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        PaymentDetailIdPojo expResult = null;
        PaymentDetailIdPojo result = instance.getIdObject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdObject method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetIdObject() {
        System.out.println("setIdObject");
        PaymentDetailIdPojo idObject = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setIdObject(idObject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoice method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetInvoice() {
        System.out.println("getInvoice");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        InvoicePojo expResult = null;
        InvoicePojo result = instance.getInvoice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInvoice method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetInvoice() {
        System.out.println("setInvoice");
        InvoicePojo invoice = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setInvoice(invoice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtotal method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getSubtotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubtotal method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        BigDecimal amount = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setSubtotal(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrencyCode method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetCurrencyCode() {
        System.out.println("getCurrencyCode");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        String expResult = "";
        assertEquals(expResult, instance.getCurrencyCode());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrencyCode method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetCurrencyCode() {
        System.out.println("setCurrencyCode");
        String currencyCode = "";
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setCurrencyCode(CurrencyCode.RMB);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMastercardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetMastercardPayments() {
        System.out.println("getMastercardPayments");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        Set<MastercardPayment> expResult = null;
        Set<MastercardPayment> result = instance.getMastercardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMastercardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetMastercardPayments() {
        System.out.println("setMastercardPayments");
        Set<MastercardPayment> mastercardPayments = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setMastercardPayments(mastercardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebitcardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetDebitcardPayments() {
        System.out.println("getDebitcardPayments");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        Set<DebitcardPayment> expResult = null;
        Set<DebitcardPayment> result = instance.getDebitcardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebitcardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetDebitcardPayments() {
        System.out.println("setDebitcardPayments");
        Set<DebitcardPayment> debitcardPayments = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setDebitcardPayments(debitcardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVisacardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetVisacardPayments() {
        System.out.println("getVisacardPayments");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        Set<VisacardPayment> expResult = null;
        Set<VisacardPayment> result = instance.getVisacardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVisacardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetVisacardPayments() {
        System.out.println("setVisacardPayments");
        Set<VisacardPayment> visacardPayments = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setVisacardPayments(visacardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaypalPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetPaypalPayments() {
        System.out.println("getPaypalPayments");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        Set<PaypalPayment> expResult = null;
        Set<PaypalPayment> result = instance.getPaypalPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaypalPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetPaypalPayments() {
        System.out.println("setPaypalPayments");
        Set<PaypalPayment> paypalPayments = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setPaypalPayments(paypalPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVoucherPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetVoucherPayments() {
        System.out.println("getVoucherPayments");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        Set<VoucherPayment> expResult = null;
        Set<Voucher> result = instance.getVouchers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVoucherPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetVoucherPayments() {
        System.out.println("setVoucherPayments");
        Set<Voucher> vouchers = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setVouchers(vouchers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmexcardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetAmexcardPayments() {
        System.out.println("getAmexcardPayments");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        Set<AmexcardPayment> expResult = null;
        Set<AmexcardPayment> result = instance.getAmexcardPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmexcardPayments method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetAmexcardPayments() {
        System.out.println("setAmexcardPayments");
        Set<AmexcardPayment> amexcardPayments = null;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setAmexcardPayments(amexcardPayments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentType method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetPaymentType() {
        System.out.println("getPaymentType");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        String expResult = "";
        assertEquals(expResult, instance.getPaymentType());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentType method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetPaymentType() {
        System.out.println("setPaymentType");
        String paymentType = "";
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setPaymentType(PaymentType.PAYPAL);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class PaymentDetailPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PaymentDetailPojo instance = new PaymentDetailPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class PaymentDetailPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        PaymentDetailPojo instance = new PaymentDetailPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
