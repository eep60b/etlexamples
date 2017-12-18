/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.Wxfcs3hourlyData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author zc
 */
public class Wxfcs3hourlyDataBuilderTest {
    
    public Wxfcs3hourlyDataBuilderTest() {
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
     * Test of build method, of class Wxfcs3hourlyDataBuilder.
     */
    @Test
    public void testBuild() throws Exception {
        System.out.println("build");
        String line = "";
        ApplicationParameters parameters = null;
        Wxfcs3hourlyDataBuilder instance = new Wxfcs3hourlyDataBuilder();
        Wxfcs3hourlyData expResult = null;
        Wxfcs3hourlyData result = instance.build(line, parameters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createData method, of class Wxfcs3hourlyDataBuilder.
     */
    @Test
    public void testCreateData() {
        System.out.println("createData");
        NamedNodeMap repAttributes = null;
        DateTime dateTime = null;
        Wxfcs3hourlyDataBuilder instance = new Wxfcs3hourlyDataBuilder();
        Wxfcs3hourlyData expResult = null;
        Wxfcs3hourlyData result = instance.createData(repAttributes, dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
