package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class DataFileWriter.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DataFileWriter.class, ResponseData.class, ApplicationParameters.class, FileUtils.class, SimpleDateFormat.class})
public final class DataFileWriterTest {

    private final ResponseData responseData1 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData2 = PowerMockito.mock(ResponseData.class);
    private final ResponseData responseData3 = PowerMockito.mock(ResponseData.class);
    private final List<ResponseData> list = Arrays.asList(responseData1, responseData2, responseData3);
    private final File file = Mockito.mock(File.class);
    private final File additionalFile1 = Mockito.mock(File.class);
    private final File additionalfile2 = Mockito.mock(File.class);
    private final List<File> additionalFiles = Arrays.asList(additionalFile1, additionalfile2);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);
    private final DateFormat dateFormat = Mockito.mock(DateFormat.class);
    private final String titleAdditional = "aldaii-120012";
    private final String delimiter = ",";
    private final String dataEncoding = "Unicode-18";
    private final File dataLogFile = Mockito.mock(File.class);
    private final Date currentTime = Mockito.mock(Date.class);

    private final DataFileWriter instance = DataFileWriter.getInstance();

    @Before
    public void setUp() throws Exception {

        Mockito.when(parameters.getDelimiter()).thenReturn(delimiter);
        Mockito.when(parameters.getDataEncoding()).thenReturn(dataEncoding);
        Mockito.when(parameters.getDataDirectoryPath()).thenReturn("Datapath");

        Mockito.when(responseData1.getTitle(delimiter, titleAdditional)).thenReturn("DTime,afad-afa");
        Mockito.when(parameters.getDatetimeFormat()).thenReturn(dateFormat);
        Mockito.when(responseData1.getOutputString(dateFormat, delimiter)).thenReturn("12,32,1");
        Mockito.when(responseData2.getOutputString(dateFormat, delimiter)).thenReturn("87,32,a1");
        Mockito.when(responseData3.getOutputString(dateFormat, delimiter)).thenReturn("1256,2,f");

        PowerMockito.mockStatic(FileUtils.class);

        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(currentTime);

        PowerMockito.whenNew(File.class).withArguments("Datapath" + File.separator + "log" + File.separator + "datalog" + File.separator + "1970-01-01.log").thenReturn(dataLogFile);
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
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testWrite() throws Exception {

        instance.write("</DV></SiteRep>", list, file, additionalFiles, parameters, titleAdditional);

        PowerMockito.verifyStatic();
        FileUtils.writeStringToFile(file, "DTime,afad-afa\n12,32,1\n87,32,a1\n1256,2,f", dataEncoding, false);

        PowerMockito.verifyStatic();
        FileUtils.writeStringToFile(additionalFile1, "DTime,afad-afa\n12,32,1\n87,32,a1\n1256,2,f", dataEncoding, false);

        PowerMockito.verifyStatic();
        FileUtils.writeStringToFile(additionalfile2, "DTime,afad-afa\n12,32,1\n87,32,a1\n1256,2,f", dataEncoding, false);

        PowerMockito.verifyStatic();
        FileUtils.writeStringToFile(dataLogFile, "\n\nData recorded at 01:00:00\n</DV></SiteRep>", dataEncoding, true);
    }

    /**
     * Test of write method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testWrite_withException() throws Exception {

        PowerMockito.mockStatic(FileUtils.class);
        PowerMockito.doThrow(new IOException()).when(FileUtils.class);
        FileUtils.writeStringToFile(additionalFile1, "DTime,afad-afa\n12,32,1\n87,32,a1\n1256,2,f", dataEncoding, false);
        
        instance.write("</DV></SiteRep>", list, file, additionalFiles, parameters, titleAdditional);

        PowerMockito.verifyStatic();
        FileUtils.writeStringToFile(file, "DTime,afad-afa\n12,32,1\n87,32,a1\n1256,2,f", dataEncoding, false);

        PowerMockito.verifyStatic();
        FileUtils.writeStringToFile(additionalfile2, "DTime,afad-afa\n12,32,1\n87,32,a1\n1256,2,f", dataEncoding, false);

        PowerMockito.verifyStatic();
        FileUtils.writeStringToFile(dataLogFile, "\n\nData recorded at 01:00:00\n</DV></SiteRep>", dataEncoding, true);
    }

}
