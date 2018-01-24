package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import sun.tools.attach.BsdVirtualMachine;

/**
 * Test of class SingleProcessor.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SingleProcessor.class, ApplicationParameters.class, Calendar.class, DataBuilderFactory.class, BaseFileCopier.class, DataFileReader.class, DocumentBuilderFactory.class, 
    DataFileWriter.class, ResponseDataBuilder.class, IOUtils.class, RequestConfig.class, RequestLocation.class, URL.class, URLConnection.class})
public final class SingleProcessorTest {

    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);
    private final Calendar calendar = Mockito.mock(Calendar.class);
    private final BaseFileCopier baseFileCopier = PowerMockito.mock(BaseFileCopier.class);
    private final RequestConfig requestConfig1 = PowerMockito.mock(RequestConfig.class);
    private final RequestConfig requestConfig2 = PowerMockito.mock(RequestConfig.class);    
    private final List<RequestConfig> requestConfigs = Arrays.asList(requestConfig1, requestConfig2);
    private final DataBuilderFactory dataBuilderFactory = PowerMockito.mock(DataBuilderFactory.class);
    private final DataFileReader dataFileReader = PowerMockito.mock(DataFileReader.class);
    private final DocumentBuilderFactory documentBuilderFactory = PowerMockito.mock(DocumentBuilderFactory.class);
    private final DocumentBuilder db = Mockito.mock(DocumentBuilder.class);
    private final DataFileWriter dataFileWriter = PowerMockito.mock(DataFileWriter.class);
    private final ResponseDataBuilder dataBuilder1 = PowerMockito.mock(ResponseDataBuilder.class);
    private final ResponseDataBuilder dataBuilder2 = PowerMockito.mock(ResponseDataBuilder.class);
    private final RequestLocation location1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation location2 = PowerMockito.mock(RequestLocation.class);
    private final File file1 = Mockito.mock(File.class);
    private final File file2 = Mockito.mock(File.class);    
    private final File baseFile1 = Mockito.mock(File.class);
    private final File baseFile2 = Mockito.mock(File.class); 
    private final File additionalFile11 = Mockito.mock(File.class);
    private final File additionalFile12 = Mockito.mock(File.class);
    private final File additionalFile31 = Mockito.mock(File.class);    
    private final File additionalFile21 = Mockito.mock(File.class);
    private final File additionalFile22 = Mockito.mock(File.class);
    private final File additionalFile32 = Mockito.mock(File.class); 
    @SuppressWarnings("unchecked")
    private final ArrayList<File> additionalFiles1 = Mockito.mock(ArrayList.class);
    @SuppressWarnings("unchecked")
    private final ArrayList<File> additionalFiles2 = Mockito.mock(ArrayList.class);
    @SuppressWarnings("unchecked")
    private final List<ResponseData> oldList1 = Mockito.mock(List.class);
    @SuppressWarnings("unchecked")
    private final List<ResponseData> oldList2 = Mockito.mock(List.class);
    private final URL url = PowerMockito.mock(URL.class);                   //Only ONE URL object can be produced by PowerMockito. 
    private final URLConnection conn1 = Mockito.mock(URLConnection.class);
    private final URLConnection conn2 = Mockito.mock(URLConnection.class);
    private final StringReader stringReader1 = Mockito.mock(StringReader.class);
    private final StringReader stringReader2 = Mockito.mock(StringReader.class);
    private final InputSource inputSource1 = Mockito.mock(InputSource.class);
    private final InputSource inputSource2 = Mockito.mock(InputSource.class);
    private final Document doc1 = Mockito.mock(Document.class);
    private final Document doc2 = Mockito.mock(Document.class);    
    @SuppressWarnings("unchecked")
    private final List<ResponseData> newList1 = Mockito.mock(List.class);
    @SuppressWarnings("unchecked")
    private final List<ResponseData> newList2 = Mockito.mock(List.class);
    
    private final InOrder inOrder = Mockito.inOrder(baseFileCopier, additionalFiles1, additionalFiles2, conn1, conn2, dataFileWriter);
    
    private final SingleProcessor instance = new SingleProcessor();
    
    @Before
    public void setUp() throws Exception {
        
        PowerMockito.mockStatic(Calendar.class);
        Mockito.when(Calendar.getInstance()).thenReturn(calendar);
        
        PowerMockito.mockStatic(DataBuilderFactory.class);
        Mockito.when(DataBuilderFactory.getInstance()).thenReturn(dataBuilderFactory);

        PowerMockito.mockStatic(BaseFileCopier.class);
        Mockito.when(BaseFileCopier.getInstance()).thenReturn(baseFileCopier);        
        
        PowerMockito.mockStatic(DataFileReader.class);
        Mockito.when(DataFileReader.getInstance()).thenReturn(dataFileReader);
        
        PowerMockito.mockStatic(DocumentBuilderFactory.class);
        Mockito.when(DocumentBuilderFactory.newInstance()).thenReturn(documentBuilderFactory);
        Mockito.when(documentBuilderFactory.newDocumentBuilder()).thenReturn(db);
        
        PowerMockito.mockStatic(DataFileWriter.class);
        Mockito.when(DataFileWriter.getInstance()).thenReturn(dataFileWriter);
               
        Mockito.when(parameters.getRequestConfigs()).thenReturn(requestConfigs);
        Mockito.when(parameters.getDataFileExtension()).thenReturn(".ttt").thenReturn(".dac");
        Mockito.when(parameters.getDataDirectoryPath()).thenReturn("datadirectoPpa");
        List<String> addtionalPaths = Arrays.asList("additon1", "   ", "addaodt2");
        Mockito.when(parameters.getAdditionalDataDirectoryPaths()).thenReturn(addtionalPaths);
        Mockito.when(parameters.getBaseDataDirectoryPath()).thenReturn("basebase");
        
        Mockito.when(requestConfig1.getRequestMethod()).thenReturn(RequestMethod.FCS_3HOURLY);
        Mockito.when(requestConfig2.getRequestMethod()).thenReturn(RequestMethod.OBS_HOURLY); 
        
        Mockito.when(dataBuilderFactory.createDataBuilder(RequestMethod.FCS_3HOURLY)).thenReturn(dataBuilder1);
        Mockito.when(dataBuilderFactory.createDataBuilder(RequestMethod.OBS_HOURLY)).thenReturn(dataBuilder2);
        
        Mockito.when(calendar.get(Calendar.YEAR)).thenReturn(2017).thenReturn(2018);
        
        Mockito.when(requestConfig1.getRequestLocation()).thenReturn(location1);
        Mockito.when(requestConfig1.getUrl()).thenReturn("urla1");
        Mockito.when(requestConfig2.getRequestLocation()).thenReturn(location2);
        Mockito.when(requestConfig2.getUrl()).thenReturn("urlb2");
        
        Mockito.when(location1.getName()).thenReturn("bango");
        Mockito.when(location1.getId()).thenReturn("342");
        Mockito.when(location2.getName()).thenReturn("caernar");
        Mockito.when(location2.getId()).thenReturn("698127");
        
        PowerMockito.whenNew(File.class).withArguments("datadirectoPpa" + File.separator + "fcs3h-bango-2017.ttt").thenReturn(file1);
        PowerMockito.whenNew(File.class).withArguments("datadirectoPpa" + File.separator + "obs1h-caernar-2018.dac").thenReturn(file2);     

        PowerMockito.whenNew(File.class).withArguments("basebase" + File.separator + "fcs3h-bango-2017.ttt").thenReturn(baseFile1);
        PowerMockito.whenNew(File.class).withArguments("basebase" + File.separator + "obs1h-caernar-2018.dac").thenReturn(baseFile2);        
        
        PowerMockito.whenNew(File.class).withArguments("additon1" + File.separator + "fcs3h-bango-2017.ttt").thenReturn(additionalFile11);        
        PowerMockito.whenNew(File.class).withArguments("addaodt2" + File.separator + "fcs3h-bango-2017.ttt").thenReturn(additionalFile21);  
        PowerMockito.whenNew(File.class).withArguments("   " + File.separator + "fcs3h-bango-2017.ttt").thenReturn(additionalFile31);   
        
        PowerMockito.whenNew(File.class).withArguments("additon1" + File.separator + "obs1h-caernar-2018.dac").thenReturn(additionalFile12);        
        PowerMockito.whenNew(File.class).withArguments("addaodt2" + File.separator + "obs1h-caernar-2018.dac").thenReturn(additionalFile22);          
        PowerMockito.whenNew(File.class).withArguments("   " + File.separator + "obs1h-caernar-2018.dac").thenReturn(additionalFile32);          
        
        PowerMockito.whenNew(ArrayList.class).withNoArguments().thenReturn(additionalFiles1).thenReturn(additionalFiles2);
        
        Mockito.when(dataFileReader.readData(dataBuilder1, file1, parameters)).thenReturn(oldList1);
        Mockito.when(dataFileReader.readData(dataBuilder2, file2, parameters)).thenReturn(oldList2);
        
        PowerMockito.whenNew(URL.class).withArguments("urla1").thenReturn(url);
        PowerMockito.whenNew(URL.class).withArguments("urlb2").thenReturn(url);
        
        Mockito.when(url.openConnection()).thenReturn(conn1).thenReturn(conn2);
        
        PowerMockito.mockStatic(IOUtils.class);
        Mockito.when(IOUtils.toString(url, "UTF-8")).thenReturn("contentns1").thenReturn("contentns2");
        
        PowerMockito.whenNew(StringReader.class).withArguments("contentns1").thenReturn(stringReader1);
        PowerMockito.whenNew(StringReader.class).withArguments("contentns2").thenReturn(stringReader2);  
        
        PowerMockito.whenNew(InputSource.class).withArguments(stringReader1).thenReturn(inputSource1);
        PowerMockito.whenNew(InputSource.class).withArguments(stringReader2).thenReturn(inputSource2);     
        
        Mockito.when(db.parse(inputSource1)).thenReturn(doc1);
        Mockito.when(db.parse(inputSource2)).thenReturn(doc2);   
        
        Mockito.when(dataBuilder1.build(doc1, oldList1)).thenReturn(newList1);
        Mockito.when(dataBuilder2.build(doc2, oldList2)).thenReturn(newList2);        
    }

    /**
     * Test of process method.
     * @throws Exception if an error occurs
     */
    @Test
    public void testProcess() throws Exception {
        
        instance.process(parameters);
        
        inOrder.verify(baseFileCopier).copy(baseFile1, file1);
        inOrder.verify(additionalFiles1).add(additionalFile11);
        inOrder.verify(additionalFiles1).add(additionalFile21);        
        inOrder.verify(conn1).setDoOutput(Boolean.TRUE);
        inOrder.verify(dataFileWriter).write("contentns1", newList1, file1, additionalFiles1, parameters, "-2017-000342");
        
        inOrder.verify(baseFileCopier).copy(baseFile2, file2);        
        inOrder.verify(additionalFiles2).add(additionalFile12);
        inOrder.verify(additionalFiles2).add(additionalFile22);         
        inOrder.verify(conn2).setDoOutput(true);      
        inOrder.verify(dataFileWriter).write("contentns2", newList2, file2, additionalFiles2, parameters, "-2018-698127");
        
        Mockito.verify(additionalFiles1, Mockito.never()).add(additionalFile31);
        Mockito.verify(additionalFiles2, Mockito.never()).add(additionalFile32);
    }
}
