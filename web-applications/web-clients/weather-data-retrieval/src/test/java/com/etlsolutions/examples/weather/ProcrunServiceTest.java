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
public final class ProcrunServiceTest {
    
    public ProcrunServiceTest() {
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
     * Test of start method, of class ProcrunService.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        String[] args = null;
        ProcrunService.start(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class ProcrunService.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        String[] args = null;
        ProcrunService.stop(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
