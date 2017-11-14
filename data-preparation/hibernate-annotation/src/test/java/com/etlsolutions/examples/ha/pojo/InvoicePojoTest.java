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

import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.data.api.PaymentDetail;
import com.etlsolutions.examples.data.api.SoldItem;
import com.etlsolutions.examples.ha.control.DataRetriever;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class InvoicePojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class InvoicePojoTest {

    private final InvoicePojo instance = new InvoicePojo();

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

    @Test
    public void testGetInvoiceId() {
        assertEquals(0, instance.getId());
    }

    @Test
    public void testSetInvoiceId() {
        instance.setId(5);
        assertEquals(5, instance.getId());
    }

    @Test
    public void testGetCustomer() {
        assertNull(instance.getCustomer());
    }

    @Test
    public void testSetCustomer() {
        CustomerPojo customer = new CustomerPojo();
        instance.setCustomer(customer);
        assertEquals(customer, instance.getCustomer());
    }

    @Test
    public void testGetInvoiceDate() {
        assertNull(instance.getInvoiceDate());
    }

    @Test
    public void testSetInvoiceDate() {
        Date invoiceDate = new Date();
        instance.setInvoiceDate(invoiceDate);
        assertEquals(invoiceDate, instance.getInvoiceDate());
    }

    @Test
    public void testGetTotalAmount() {
        assertNull(instance.getTotal());
    }

    @Test
    public void testSetTotalAmount() {
        BigDecimal totalAmount = new BigDecimal(22.68);
        instance.setTotal(totalAmount);
        assertEquals(totalAmount, instance.getTotal());
    }

    @Test
    public void testGetValid() {
        assertNull(instance.getValidity());
    }

    @Test
    public void testSetValid() {
        InvoiceValidity valid = InvoiceValidity.YES;
        instance.setValidity(valid);
        assertEquals(valid, instance.getValidity());
    }

    @Test
    public void testGetBookSoldPrices() {
        assertTrue(instance.getSoldItems().isEmpty());
    }

    @Test
    public void testSetBookSoldPrices() {
        Set<SoldItem> bookSoldPrices = new HashSet<>();
        instance.setSoldItems(bookSoldPrices);
        assertEquals(bookSoldPrices, instance.getSoldItems());
    }

    @Test
    public void testGetPayments() {
        assertTrue(instance.getPaymentDetails().isEmpty());
    }

    @Test
    public void testSetPayments() {
        Set<PaymentDetail> payments = new HashSet<>();
        instance.setPaymentDetails(payments);
        assertEquals(payments, instance.getPaymentDetails());
    }

    @Test
    public void testGetViewInvoice() {
        assertNull(instance.getViewInvoice());
    }

    @Test
    public void testSetViewInvoice() {
        ViewInvoicePojo viewInvoice = new ViewInvoicePojo();
        instance.setViewInvoice(viewInvoice);
        assertEquals(viewInvoice, instance.getViewInvoice());
    }

    @Test
    public void testQueries() {
        DataRetriever retriever = new DataRetriever();

        List<InvoicePojo> list = retriever.<InvoicePojo>findAll("findInvoice");
        assertEquals(2, list.size());
        assertEquals(1, list.get(0).getViewInvoice().getId());
        assertNull(list.get(1).getViewInvoice());
    }

    /**
     * Test of getId method, of class InvoicePojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        InvoicePojo instance = new InvoicePojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class InvoicePojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        InvoicePojo instance = new InvoicePojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValidity method, of class InvoicePojo.
     */
    @Test
    public void testGetValidity() {
        System.out.println("getValidity");
        InvoicePojo instance = new InvoicePojo();
        String expResult = "";
        InvoiceValidity result = instance.getValidity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValidity method, of class InvoicePojo.
     */
    @Test
    public void testSetValidity() {
        System.out.println("setValidity");
        InvoiceValidity validity = InvoiceValidity.YES;
        InvoicePojo instance = new InvoicePojo();
        instance.setValidity(validity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSoldItems method, of class InvoicePojo.
     */
    @Test
    public void testGetItemSoldPrices() {
        System.out.println("getItemSoldPrices");
        InvoicePojo instance = new InvoicePojo();
        Set<SoldItem> expResult = null;
        Set<SoldItem> result = instance.getSoldItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSoldItems method, of class InvoicePojo.
     */
    @Test
    public void testSetItemSoldPrices() {
        System.out.println("setItemSoldPrices");
        Set<SoldItem> itemSoldPrices = null;
        InvoicePojo instance = new InvoicePojo();
        instance.setSoldItems(itemSoldPrices);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
