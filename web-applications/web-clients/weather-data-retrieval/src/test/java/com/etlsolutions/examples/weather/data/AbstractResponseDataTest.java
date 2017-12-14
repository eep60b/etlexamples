package com.etlsolutions.examples.weather.data;

import java.text.DateFormat;
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
public final class AbstractResponseDataTest {
    
    public AbstractResponseDataTest() {
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
     * Test of getDateTime method, of class AbstractResponseData.
     */
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        AbstractResponseData instance = null;
        DateTime expResult = null;
        DateTime result = instance.getDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutputString method, of class AbstractResponseData.
     */
    @Test
    public void testGetOutputString() {
        System.out.println("getOutputString");
        DateFormat dateTimeFormat = null;
        String delimiter = "";
        AbstractResponseData instance = null;
        String expResult = "";
        String result = instance.getOutputString(dateTimeFormat, delimiter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class AbstractResponseData.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String delimiter = "";
        String additional = "";
        AbstractResponseData instance = null;
        String expResult = "";
        String result = instance.getTitle(delimiter, additional);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private final class AbstractResponseDataImpl<T> extends AbstractResponseData {

        public AbstractResponseDataImpl() {
            super(null);
        }

        @Override
        public Valuable[] getValuables() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
