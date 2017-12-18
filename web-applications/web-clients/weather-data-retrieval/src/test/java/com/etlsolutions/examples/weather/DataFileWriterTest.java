package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class DataFileWriter.
 *
 * @author zc
 */
public final class DataFileWriterTest {

    
    private final DataFileWriter instance = DataFileWriter.getInstance();
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertSame(DataFileWriter.getInstance(), instance);
    }

    /**
     * Test of write method.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        List<ResponseData> list = null;
        File file = null;
        List<File> additionalFiles = null;
        ApplicationParameters parameters = null;
        String titleAdditional = "";
        instance.write(list, file, additionalFiles, parameters, titleAdditional);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
