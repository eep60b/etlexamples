/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public class PersonalProfileIdentificationFactoryTest {
    
    public PersonalProfileIdentificationFactoryTest() {
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
     * Test of createIdentification method, of class PersonalProfileIdentificationFactory.
     */
    @Test
    public void testCreateIdentification() {
        System.out.println("createIdentification");
        byte[] bytes = null;
        PersonalProfileIdentificationFactory instance = new PersonalProfileIdentificationFactory();
        String expResult = "";
        String result = instance.createIdentification(bytes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
