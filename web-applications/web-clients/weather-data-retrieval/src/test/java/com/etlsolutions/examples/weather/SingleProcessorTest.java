package com.etlsolutions.examples.weather;

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
public final class SingleProcessorTest {
    
    public SingleProcessorTest() {
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
     * Test of process method, of class SingleProcessor.
     */
    @Test
    public void testProcess() throws Exception {
        System.out.println("process");
        ApplicationParameters parameters = null;
        SingleProcessor instance = new SingleProcessor();
        instance.process(parameters);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
