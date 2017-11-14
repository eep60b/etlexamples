/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.ha.pojo;

import java.math.BigDecimal;
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
public class SoldItemPojoTest {
    
    public SoldItemPojoTest() {
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
     * Test of getId method, of class SoldItemPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        SoldItemPojo instance = new SoldItemPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class SoldItemPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        SoldItemPojo instance = new SoldItemPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class SoldItemPojo.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        SoldItemPojo instance = new SoldItemPojo();
        ItemCommonDetailPojo expResult = null;
        ItemCommonDetailPojo result = instance.getItemCommonDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class SoldItemPojo.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        ItemCommonDetailPojo item = null;
        SoldItemPojo instance = new SoldItemPojo();
        instance.setItemCommonDetail(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoice method, of class SoldItemPojo.
     */
    @Test
    public void testGetInvoice() {
        System.out.println("getInvoice");
        SoldItemPojo instance = new SoldItemPojo();
        InvoicePojo expResult = null;
        InvoicePojo result = instance.getInvoice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInvoice method, of class SoldItemPojo.
     */
    @Test
    public void testSetInvoice() {
        System.out.println("setInvoice");
        InvoicePojo invoice = null;
        SoldItemPojo instance = new SoldItemPojo();
        instance.setInvoice(invoice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class SoldItemPojo.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        SoldItemPojo instance = new SoldItemPojo();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class SoldItemPojo.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        SoldItemPojo instance = new SoldItemPojo();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class SoldItemPojo.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        SoldItemPojo instance = new SoldItemPojo();
        BigDecimal expResult = null;
        BigDecimal result = instance.getUnitPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitPrice method, of class SoldItemPojo.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        BigDecimal unitPrice = null;
        SoldItemPojo instance = new SoldItemPojo();
        instance.setUnitPrice(unitPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
