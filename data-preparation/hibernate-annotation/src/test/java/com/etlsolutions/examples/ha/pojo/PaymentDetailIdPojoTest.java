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

import com.etlsolutions.examples.data.api.PaymentType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of getPaymentId method, of class PaymentDetailIdPojo.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public class PaymentDetailIdPojoTest {

    public PaymentDetailIdPojoTest() {
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
     * Test of getPaymentId method, of class PaymentDetailIdPojo.
     */
    @Test
    public void testGetPaymentId() {
        System.out.println("getPaymentId");
        PaymentDetailIdPojo instance = new PaymentDetailIdPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentId method, of class PaymentDetailIdPojo.
     */
    @Test
    public void testSetPaymentId() {
        System.out.println("setPaymentId");
        int paymentId = 0;
        PaymentDetailIdPojo instance = new PaymentDetailIdPojo();
        instance.setId(paymentId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentType method, of class PaymentDetailIdPojo.
     */
    @Test
    public void testGetPaymentType() {
        System.out.println("getPaymentType");
        PaymentDetailIdPojo instance = new PaymentDetailIdPojo();
        String expResult = "";
        assertEquals(expResult, instance.getPaymentType());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentType method, of class PaymentDetailIdPojo.
     */
    @Test
    public void testSetPaymentType() {
        System.out.println("setPaymentType");
        String paymentType = "";
        PaymentDetailIdPojo instance = new PaymentDetailIdPojo();
        instance.setPaymentType(PaymentType.AMEX_CARD);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class PaymentDetailIdPojo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = null;
        PaymentDetailIdPojo instance = new PaymentDetailIdPojo();
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class PaymentDetailIdPojo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        PaymentDetailIdPojo instance = new PaymentDetailIdPojo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
