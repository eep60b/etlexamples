package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class DataFileReader.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DataFileReader.class, ResponseData.class, ApplicationParameters.class})
public final class DataFileReaderTest {

    private final ResponseDataBuilder dataBuilder = Mockito.mock(ResponseDataBuilder.class);
    private final File file = Mockito.mock(File.class);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);
    private final ResponseData responseData1 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData3 = PowerMockito.mock(ResponseData.class);
    private final String line1 = "agaiidal";
    private final String line2 = "8af3oaeoa";
    private final String line3 = "oan3o2rkfu";
    private final FileReader fileReader = Mockito.mock(FileReader.class);
    private final BufferedReader br = Mockito.mock(BufferedReader.class);

    private final DataFileReader instance = DataFileReader.getInstance();

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(FileReader.class).withArguments(file).thenReturn(fileReader);
        PowerMockito.whenNew(BufferedReader.class).withArguments(fileReader).thenReturn(br);
        Mockito.when(br.readLine()).thenReturn("daiafadfalfa").thenReturn(line1).thenReturn(line2).thenReturn(line3).thenReturn(null);

        Mockito.when(dataBuilder.build(line1, parameters)).thenReturn(responseData1);
        Mockito.when(dataBuilder.build(line2, parameters)).thenReturn(null);
        Mockito.when(dataBuilder.build(line3, parameters)).thenReturn(responseData3);
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
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testReadData() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);
        assertEquals(Arrays.asList(responseData1, responseData3), instance.readData(dataBuilder, file, parameters));
        Mockito.verify(br).close();
    }

    /**
     * Test of readData method.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = ParseException.class)
    public void testReadData_ParseException() throws Exception {

        ParseException pex = Mockito.mock(ParseException.class);
        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);

        Mockito.when(dataBuilder.build(line1, parameters)).thenThrow(pex);

        instance.readData(dataBuilder, file, parameters);
        Mockito.verify(br).close();
    }

    /**
     * Test of readData method.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = NullPointerException.class)
    public void testReadData_NullPointerException() throws Exception {

        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);

        PowerMockito.whenNew(BufferedReader.class).withArguments(fileReader).thenReturn(null);

        instance.readData(dataBuilder, file, parameters);
    }

    /**
     * Test of readData method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testReadData_ReadLine_IOException() throws Exception {

        IOException ioe = Mockito.mock(IOException.class);
        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);

        Mockito.when(br.readLine()).thenThrow(ioe);

        try {
            instance.readData(dataBuilder, file, parameters);
        } catch (IOException ex) {
            assertSame(ioe, ex);
            Mockito.verify(br).close();
        }
    }

    /**
     * Test of readData method.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = IOException.class)
    public void testReadData_IOException() throws Exception {

        IOException ioe = Mockito.mock(IOException.class);
        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);

        PowerMockito.whenNew(BufferedReader.class).withArguments(fileReader).thenThrow(ioe);

        instance.readData(dataBuilder, file, parameters);
    }

    /**
     * Test of readData method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testReadData_NoFile() throws Exception {

        assertTrue(instance.readData(dataBuilder, file, parameters).isEmpty());
    }
}
