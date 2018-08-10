package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class FtpsFileRetriever.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FtpsFileRetriever.class,  ApplicationParameters.class, Logger.class, FileUtils.class, RequestConfig.class, RequestLocation.class, RequestMethod.class, Calendar.class})
public final class FtpsFileRetrieverTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final JSch jsch = Mockito.mock(JSch.class);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);
    private final RequestConfig requestConfig1 = PowerMockito.mock(RequestConfig.class);
    private final RequestConfig requestConfig2 = PowerMockito.mock(RequestConfig.class);
    private final List<RequestConfig> requestConfigs = Arrays.asList(requestConfig1, requestConfig2);
    private final RequestLocation requestLocation1 = PowerMockito.mock(RequestLocation.class);
    private final RequestLocation requestLocation2 = PowerMockito.mock(RequestLocation.class);    
    private final RequestMethod requestMethod1 = PowerMockito.mock(RequestMethod.class);
    private final RequestMethod requestMethod2 = PowerMockito.mock(RequestMethod.class);  
    private final Calendar calendar = Mockito.mock(Calendar.class);
    private final Session session = Mockito.mock(Session.class);
    private final ChannelSftp sftpChannel = Mockito.mock(ChannelSftp.class);

    private final InputStream inputStream1 = Mockito.mock(InputStream.class);
    private final InputStream inputStream2 = Mockito.mock(InputStream.class);
    private final InputStream inputStream4 = Mockito.mock(InputStream.class);
    private final File localFile1 = Mockito.mock(File.class);
    private final File localFile2 = Mockito.mock(File.class);
    private final File localFile3 = Mockito.mock(File.class);
    private final File localFile4 = Mockito.mock(File.class);
    
    private final InOrder inOrder = Mockito.inOrder(logger, session, sftpChannel);

    private FtpsFileRetriever instance;

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(FtpsFileRetriever.class)).thenReturn(logger);

        PowerMockito.whenNew(JSch.class).withNoArguments().thenReturn(jsch);

        Mockito.when(parameters.getIntervalInMinutes()).thenReturn(3);
        Mockito.when(parameters.getFtpsServerName()).thenReturn("ftySeveName");
        Mockito.when(parameters.getFtpsUsername()).thenReturn("usuusler");
        Mockito.when(parameters.getFtpsPassword()).thenReturn("papappapa");
        Mockito.when(parameters.getFtpsRemoteSourceDirectory()).thenReturn("reppmoote");
        Mockito.when(parameters.getFtpsLocalTargetDirecotries()).thenReturn(Arrays.asList("lloooou local", "ssss"));
        Mockito.when(parameters.getDataDirectoryPath()).thenReturn("daidata tata");
        Mockito.when(parameters.getDataFileExtension()).thenReturn(".dat");
        Mockito.when(parameters.getRequestConfigs()).thenReturn(requestConfigs);

        Mockito.when(jsch.getSession("usuusler", "ftySeveName", 22)).thenReturn(session);
        Mockito.when(session.openChannel("sftp")).thenReturn(sftpChannel);
        Mockito.when(sftpChannel.get("reppmoote/fcs3h-ffalafd-2020.dat")).thenReturn(inputStream1);
        Mockito.when(sftpChannel.get("reppmoote/obs1h-cuiafffuxc-2020.dat")).thenReturn(inputStream2);
        
        PowerMockito.mockStatic(Calendar.class);
        Mockito.when(Calendar.getInstance()).thenReturn(calendar);
        Mockito.when(calendar.get(Calendar.YEAR)).thenReturn(2020);
        Mockito.when(requestConfig1.getRequestLocation()).thenReturn(requestLocation1);
        Mockito.when(requestConfig1.getRequestMethod()).thenReturn(requestMethod1);
        Mockito.when(requestConfig2.getRequestLocation()).thenReturn(requestLocation2);
        Mockito.when(requestConfig2.getRequestMethod()).thenReturn(requestMethod2);
        Mockito.when(requestMethod1.getAbbreviation()).thenReturn("fcs3h");
        Mockito.when(requestMethod2.getAbbreviation()).thenReturn("obs1h");        
        Mockito.when(requestLocation1.getName()).thenReturn("ffalafd");
        Mockito.when(requestLocation2.getName()).thenReturn("cuiafffuxc");
        PowerMockito.whenNew(File.class).withArguments("lloooou local" + File.separator + "fcs3h-ffalafd-2020.dat.txt").thenReturn(localFile1);
        PowerMockito.whenNew(File.class).withArguments("lloooou local" + File.separator + "obs1h-cuiafffuxc-2020.dat.txt").thenReturn(localFile2);
        PowerMockito.whenNew(File.class).withArguments("ssss" + File.separator + "fcs3h-ffalafd-2020.dat.txt").thenReturn(localFile3);
        PowerMockito.whenNew(File.class).withArguments("ssss" + File.separator + "obs1h-cuiafffuxc-2020.dat.txt").thenReturn(localFile4);
        
        PowerMockito.mockStatic(FileUtils.class);

        instance = new FtpsFileRetriever();
    }

    /**
     * Test of copyFiles method.
     *
     * @throws java.lang.Exception if an error occurs.
     */
    @Test
    public void testCopyFiles() throws Exception {

        instance.copyFiles(parameters);

        inOrder.verify(session).setConfig("StrictHostKeyChecking", "no");
        inOrder.verify(session).setPassword("papappapa");
        inOrder.verify(session).connect();
        inOrder.verify(sftpChannel).connect();
        inOrder.verify(sftpChannel).exit();
        inOrder.verify(session).disconnect();

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(inputStream1, localFile1);

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(inputStream1, localFile3);

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(inputStream2, localFile2);    
        
        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(inputStream2, localFile4);        
    }

    /**
     * Test of copyFiles method.
     *
     * @throws java.lang.Exception if an error occurs.
     */
    @Test
    public void testCopyFiles_Exception() throws Exception {

        SftpException ex = Mockito.mock(SftpException.class);
        Mockito.when(sftpChannel.get("reppmoote/ffalafd.dat")).thenThrow(ex);
        try {
            instance.copyFiles(parameters);
        } catch (SftpException sftex) {
            assertSame(ex, sftex);
            Mockito.verify(sftpChannel).exit();
            Mockito.verify(session).disconnect();
        }
    }
}
