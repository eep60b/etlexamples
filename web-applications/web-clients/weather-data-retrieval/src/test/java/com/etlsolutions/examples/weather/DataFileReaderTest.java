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

    private final DataFileReader instance = DataFileReader.getInstance();
    @Before
    public void setUp() {
    }


    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertSame(DataFileReader.getInstance(), instance);
    }

    /**
     * Test of readData method.
     */
    @Test
    public void testReadData() throws Exception {
        System.out.println("readData");
        ResponseDataBuilder dataBuilder = null;
        File file = null;
        ApplicationParameters parameters = null;
        
        List<ResponseData> expResult = null;
        List<ResponseData> result = instance.readData(dataBuilder, file, parameters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
