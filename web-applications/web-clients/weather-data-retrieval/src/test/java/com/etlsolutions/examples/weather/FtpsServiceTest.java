package com.etlsolutions.examples.weather;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.File;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class FtpsService.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FtpsService.class, Logger.class,  ApplicationParameters.class, FileUtils.class})
public final class FtpsServiceTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final JSch jsch = Mockito.mock(JSch.class);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);
    private final Session session = Mockito.mock(Session.class);
    private final ChannelSftp sftpChannel = Mockito.mock(ChannelSftp.class);
    private final File dataDirecotry = Mockito.mock(File.class);
    private final File file1 = Mockito.mock(File.class);
    private final File file2 = Mockito.mock(File.class);
    private final File file3 = Mockito.mock(File.class);
    private final File subDirectory = Mockito.mock(File.class);
    private final File[] files = {file1, file2, file3, subDirectory};
    private final InputStream inputStream1 = Mockito.mock(InputStream.class);
    private final InputStream inputStream2 = Mockito.mock(InputStream.class);
    private final File localFile1 = Mockito.mock(File.class);
    private final File localFile2 = Mockito.mock(File.class);

    private final InOrder inOrder = Mockito.inOrder(logger, session, sftpChannel);

    private FtpsService instance;

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(FtpsService.class)).thenReturn(logger);

        PowerMockito.whenNew(JSch.class).withNoArguments().thenReturn(jsch);

        Mockito.when(parameters.getIntervalInMinutes()).thenReturn(3);
        Mockito.when(parameters.getFtpsServerName()).thenReturn("ftySeveName");
        Mockito.when(parameters.getFtpsServerUsername()).thenReturn("usuusler");
        Mockito.when(parameters.getFtpsServerPassword()).thenReturn("papappapa");
        Mockito.when(parameters.getFtpsRemoteSourceDirectory()).thenReturn("reppmoote");
        Mockito.when(parameters.getFtpsLocalTargetDirecotry()).thenReturn("lloooou local");
        Mockito.when(parameters.getDataDirectoryPath()).thenReturn("daidata tata");
        Mockito.when(parameters.getDataFileExtension()).thenReturn(".dat");

        Mockito.when(jsch.getSession("usuusler", "ftySeveName", 22)).thenReturn(session);
        Mockito.when(session.openChannel("sftp")).thenReturn(sftpChannel);

        PowerMockito.whenNew(File.class).withArguments("daidata tata").thenReturn(dataDirecotry);
        Mockito.when(dataDirecotry.listFiles()).thenReturn(files);

        Mockito.when(file1.getName()).thenReturn("ffalafd.dat");
        Mockito.when(file2.getName()).thenReturn("fkjallsd.txt");
        Mockito.when(file3.getName()).thenReturn("cuiafffuxc.dAt");

        Mockito.when(file1.isFile()).thenReturn(Boolean.TRUE);
        Mockito.when(file2.isFile()).thenReturn(Boolean.TRUE);
        Mockito.when(file3.isFile()).thenReturn(Boolean.TRUE);

        Mockito.when(sftpChannel.get("reppmoote/ffalafd.dat")).thenReturn(inputStream1);
        Mockito.when(sftpChannel.get("reppmoote/cuiafffuxc.dAt")).thenReturn(inputStream2);

        PowerMockito.whenNew(File.class).withArguments("lloooou local" + File.separator + "ffalafd.dat").thenReturn(localFile1);
        PowerMockito.whenNew(File.class).withArguments("lloooou local" + File.separator + "cuiafffuxc.dAt").thenReturn(localFile2);

        PowerMockito.mockStatic(FileUtils.class);

        instance = new FtpsService();
    }

    /**
     * Test of init method.
     *
     * @throws java.lang.Exception if an error occurs.
     */
   // @Test
    public void testInit() throws Exception {

        //An operation without initialization will cause an NullPointerException.
        instance.stop();
        Mockito.verify(logger).warn(Mockito.eq("Failed to stop the FTPS service"), Mockito.any(NullPointerException.class));

        //An operation with initialization will NOT cause an NullPointerException.        
        instance.init(parameters);
        instance.stop();
        Mockito.verify(logger, Mockito.never()).warn(Mockito.eq("Failed to stop the FTPS service"), Mockito.any(NullPointerException.class));

    }

    /**
     * Test of start method, of class FtpsService.
     *
     * @throws java.lang.Exception if an error occurs.
     */
    @Test
    public void testStart() throws Exception {

        instance.init(parameters);

        instance.start();

        Thread.sleep(30000);
        
        inOrder.verify(session).setConfig("StrictHostKeyChecking", "no");
        inOrder.verify(session).setPassword("papappapa");
        inOrder.verify(session).connect();
        inOrder.verify(sftpChannel).connect();
        inOrder.verify(sftpChannel).exit();
        inOrder.verify(session).disconnect();
        inOrder.verify(logger).info("Data files successfully copied from the linux server.");
        inOrder.verify(logger).info("Copied file location:            lloooou local");

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(inputStream1, localFile1);

        PowerMockito.verifyStatic();
        FileUtils.copyInputStreamToFile(inputStream2, localFile2);

        instance.stop();
    }

    /**
     * Test of stop method.
     *
     * @throws java.lang.Exception if an error occurs.
     */
 //   @Test(expected = NullPointerException.class)
    public void testStop() throws Exception {

        instance.init(parameters);
        instance.stop();

        instance.start();
    }

}
