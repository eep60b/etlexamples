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
 * Test of class DataFileReader.
 *
 * @author zc
 */
public final class DataFileReaderTest {

    public DataFileReaderTest() {
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
     * Test of getInstance method, of class DataFileReader.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DataFileReader expResult = null;
        DataFileReader result = DataFileReader.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readData method, of class DataFileReader.
     */
    @Test
    public void testReadData() throws Exception {
        System.out.println("readData");
        ResponseDataBuilder dataBuilder = null;
        File file = null;
        ApplicationParameters parameters = null;
        DataFileReader instance = null;
        List<ResponseData> expResult = null;
        List<ResponseData> result = instance.readData(dataBuilder, file, parameters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
