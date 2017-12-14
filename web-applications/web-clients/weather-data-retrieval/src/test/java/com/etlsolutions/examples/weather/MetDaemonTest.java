package com.etlsolutions.examples.weather;

import java.util.Arrays;
import java.util.Date;
import org.apache.commons.daemon.DaemonContext;
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
 * Test of class MetDaemon.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MetDaemon.class, ApplicationParametersFactory.class, ApplicationParameters.class, Logger.class, SingleProcessor.class})
public final class MetDaemonTest {

    private final DaemonContext daemonContext = Mockito.mock(DaemonContext.class);
    private final String[] args = {"abc"};
    private final ApplicationParametersFactory factory = PowerMockito.mock(ApplicationParametersFactory.class);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);
    private final Logger logger = Mockito.mock(Logger.class);
    private final Date date = Mockito.mock(Date.class);
    private final SingleProcessor singleProcessor = PowerMockito.mock(SingleProcessor.class);
    private final InOrder inOrder = Mockito.inOrder(logger, singleProcessor);

    private MetDaemon instance;

    @Before
    public void setUp() throws Exception {

        Mockito.when(daemonContext.getArguments()).thenReturn(args);

        PowerMockito.mockStatic(ApplicationParametersFactory.class);
        Mockito.when(ApplicationParametersFactory.getInstance()).thenReturn(factory);
        Mockito.when(factory.loadApplicationParameters(args)).thenReturn(parameters);
        Mockito.when(parameters.getDataDirectoryPath()).thenReturn("myDataDirectoryPathABC");
        Mockito.when(parameters.getAdditionalDataDirectoryPaths()).thenReturn(Arrays.asList("add1"));
        Mockito.when(parameters.getIntervalMiliSeconds()).thenReturn(7000L);

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(MetDaemon.class)).thenReturn(logger);

        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(date);
        Mockito.when(date.toString()).thenReturn("12/12/2017 12:00:32");

        Mockito.when(parameters.toString()).thenReturn("myparas.");

        PowerMockito.whenNew(SingleProcessor.class).withNoArguments().thenReturn(singleProcessor);

        instance = new MetDaemon();
    }

    /**
     * Test of init method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testInit() throws Exception {

        instance.init(daemonContext);

        inOrder.verify(logger).info("Start to load the configurations...");
        inOrder.verify(logger).info("12/12/2017 12:00:32");
        inOrder.verify(logger).info("\nConfigurations:");
        inOrder.verify(logger).info("myparas.\n");
    }

    /**
     * Test of start method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStart() throws Exception {

        instance.init(daemonContext);
        instance.start();
        Thread.sleep(5000);
        Thread.sleep(5000);
        inOrder.verify(logger).info("Start to load the configurations...");
        inOrder.verify(logger).info("12/12/2017 12:00:32");
        inOrder.verify(logger).info("\nConfigurations:");
        inOrder.verify(logger).info("myparas.\n");        
        inOrder.verify(logger).info("12/12/2017 12:00:32:  Start the metd service.");
        inOrder.verify(logger).info("12/12/2017 12:00:32:  The metd service has been successfully started.");
        Mockito.verify(singleProcessor, Mockito.times(2)).process(parameters);
        inOrder.verify(logger).info("\nNo.1");
        inOrder.verify(logger).info("Data location:            myDataDirectoryPathABC");
        inOrder.verify(logger).info("Data additional location: [add1]");
        inOrder.verify(logger).info("\nNo.2");        
    }

    /**
     * Test of stop method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStop() throws Exception {
        instance.init(daemonContext);
        instance.start();
        Thread.sleep(5000);
        instance.stop();
        Thread.sleep(5000);
        inOrder.verify(logger).info("12/12/2017 12:00:32:  Start the metd service.");
        Mockito.verify(singleProcessor, Mockito.times(1)).process(parameters);
        inOrder.verify(logger).info("\nNo.1");
        inOrder.verify(logger).info("Data location:            myDataDirectoryPathABC");
        inOrder.verify(logger).info("12/12/2017 12:00:32:  Stop the metd service.");
        inOrder.verify(logger).info("12/12/2017 12:00:32:  The metd service has been successfully stopped.");
        
    }

    /**
     * Test of destroy method.
     * @throws Exception if an error occurs.
     */
    @Test(expected = NullPointerException.class)
    public void testDestroy() throws Exception {

        instance.init(daemonContext);
        instance.destroy();
        instance.start();
    }

}
