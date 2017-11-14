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
public class ShoppingCartItemPojoTest {
    
    public ShoppingCartItemPojoTest() {
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
     * Test of getId method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemCommonDetail method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        ItemCommonDetailPojo expResult = null;
        ItemCommonDetailPojo result = instance.getItemCommonDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemCommonDetail method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        ItemCommonDetailPojo item = null;
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        instance.setItemCommonDetail(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        CustomerPojo expResult = null;
        CustomerPojo result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        CustomerPojo customer = null;
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        instance.setCustomer(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitNumber method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testGetUnitNumber() {
        System.out.println("getUnitNumber");
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        int expResult = 0;
        int result = instance.getUnitNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitNumber method, of class ShoppingCartItemPojo.
     */
    @Test
    public void testSetUnitNumber() {
        System.out.println("setUnitNumber");
        int unitNumber = 0;
        ShoppingCartItemPojo instance = new ShoppingCartItemPojo();
        instance.setUnitNumber(unitNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
