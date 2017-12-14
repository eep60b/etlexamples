/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.util.List;
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
public class DataFileWriterTest {
    
    public DataFileWriterTest() {
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
     * Test of getInstance method, of class DataFileWriter.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DataFileWriter expResult = null;
        DataFileWriter result = DataFileWriter.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class DataFileWriter.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        List<ResponseData> list = null;
        File file = null;
        List<File> additionalFiles = null;
        ApplicationParameters parameters = null;
        String titleAdditional = "";
        DataFileWriter instance = null;
        instance.write(list, file, additionalFiles, parameters, titleAdditional);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
