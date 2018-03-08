package com.etlsolutions.examples.weather;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import java.io.File;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
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
@PrepareForTest({FtpsService.class, Logger.class,  ApplicationParameters.class, FtpsFileRetriever.class})
public final class FtpsServiceTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final FtpsFileRetriever retriever = PowerMockito.mock(FtpsFileRetriever.class);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);

    private final InOrder inOrder = Mockito.inOrder(logger, retriever);

    private FtpsService instance;

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(FtpsService.class)).thenReturn(logger);

        PowerMockito.whenNew(FtpsFileRetriever.class).withNoArguments().thenReturn(retriever);

        Mockito.when(parameters.getIntervalInMinutes()).thenReturn(3);
        Mockito.when(parameters.getFtpsServerName()).thenReturn("ftySeveName");
        Mockito.when(parameters.getFtpsLocalTargetDirecotry()).thenReturn("lloooou local");
        
        instance = new FtpsService();
    }

    /**
     * Test of init method.
     *
     * @throws java.lang.Exception if an error occurs.
     */
    @Test
    public void testInit() throws Exception {

        //An operation with initialization will NOT cause an NullPointerException.        
        instance.init(parameters);
        instance.stop();
        Mockito.verify(logger, Mockito.never()).warn(Mockito.eq("Failed to stop the FTPS service"), Mockito.any(NullPointerException.class));

    }

    /**
     * Test of init method.
     *
     * @throws java.lang.Exception if an error occurs.
     */
    @Test
    public void testInit_Not_Initialized() throws Exception {

        //An operation without initialization will cause an NullPointerException.
        instance.stop();
        Mockito.verify(logger).warn(Mockito.eq("Failed to stop the FTPS service"), Mockito.any(NullPointerException.class));
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

        Thread.sleep(1000);
        
        inOrder.verify(retriever).copyFiles(parameters);
        inOrder.verify(logger).info("Data files successfully copied from the linux server.");
        inOrder.verify(logger).info("Copied file location:            lloooou local");
        
        instance.stop();
    }

    /**
     * Test of stop method.
     *
     * @throws java.lang.Exception if an error occurs.
     */
    @Test(expected = NullPointerException.class)
    public void testStop() throws Exception {

        instance.init(parameters);
        instance.stop();

        instance.start();
    }

}
