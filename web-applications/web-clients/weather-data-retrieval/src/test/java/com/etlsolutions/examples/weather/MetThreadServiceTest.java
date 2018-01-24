package com.etlsolutions.examples.weather;

import java.util.Arrays;
import java.util.Date;
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
 * Test of class MetThreadService.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MetThreadService.class, ApplicationParametersFactory.class, ApplicationParameters.class, Logger.class, SingleProcessor.class, Date.class})
public final class MetThreadServiceTest {

    private final String[] args = {"abc"};
    private final ApplicationParametersFactory factory = PowerMockito.mock(ApplicationParametersFactory.class);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);
    private final Logger logger = Mockito.mock(Logger.class);
    private final Date date = PowerMockito.mock(Date.class);
    private final SingleProcessor singleProcessor = PowerMockito.mock(SingleProcessor.class);
    private final InOrder inOrder = Mockito.inOrder(logger, singleProcessor);

    private MetThreadService instance;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(ApplicationParametersFactory.class);
        Mockito.when(ApplicationParametersFactory.getInstance()).thenReturn(factory);
        Mockito.when(factory.loadApplicationParameters(args)).thenReturn(parameters);
        Mockito.when(parameters.getDataDirectoryPath()).thenReturn("myDataDirectoryPathABC");
        Mockito.when(parameters.getAdditionalDataDirectoryPaths()).thenReturn(Arrays.asList("add1"));
        Mockito.when(parameters.getIntervalInMinutes()).thenReturn(1);

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(MetThreadService.class)).thenReturn(logger);

        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(date);
        Mockito.when(date.toString()).thenReturn("12/12/2017 12:00:32");

        Mockito.when(parameters.toString()).thenReturn("myparas.");

        PowerMockito.whenNew(SingleProcessor.class).withNoArguments().thenReturn(singleProcessor);

        instance = new MetThreadService();
    }

    /**
     * Test of init method.
     * @throws Exception if an error occurs.
     */
    @Test
    public void testInit() throws Exception {

        instance.init(args);
        inOrder.verify(logger).info("\n\nStart to load the configurations...");
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

        Mockito.when(singleProcessor.process(parameters)).thenReturn(Boolean.TRUE);
        
        instance.init(args);
        instance.start();
        Thread.sleep(60000);
        Thread.sleep(20000);
        inOrder.verify(logger).info("\n\nStart to load the configurations...");
        inOrder.verify(logger).info("12/12/2017 12:00:32");
        inOrder.verify(logger).info("\nConfigurations:");
        inOrder.verify(logger).info("myparas.\n");
        inOrder.verify(logger).info("12/12/2017 12:00:32:  Start the metd service.");
        Mockito.verify(singleProcessor, Mockito.times(2)).process(parameters);        
        inOrder.verify(logger).info("12/12/2017 12:00:32:  The metd service has been successfully started.");
        Mockito.verify(logger).info("\nNo.1");
  //      inOrder.verify(logger).info("\nData successfully recorded at 12/12/2017 12:00:32");
        Mockito.verify(logger, Mockito.times(2)).info("Data location:            myDataDirectoryPathABC");
        Mockito.verify(logger, Mockito.times(2)).info("Data additional location: [add1]");
        Mockito.verify(logger).info("\nNo.2");
    }

    /**
     * Test of stop method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStop() throws Exception {
        instance.init(args);
        instance.start();
        Thread.sleep(6000);
        instance.stop();
        Thread.sleep(60000);
        inOrder.verify(logger).info("12/12/2017 12:00:32:  Start the metd service.");
        Mockito.verify(singleProcessor, Mockito.times(1)).process(parameters);
        inOrder.verify(logger).info("\nNo.1");
        inOrder.verify(logger).info("\n\n12/12/2017 12:00:32:  Stop the metd service.");      
        inOrder.verify(logger).info("12/12/2017 12:00:32:  The metd service has been successfully stopped.");
        
        inOrder.verify(logger, Mockito.never()).info("\nNo.2");
    }

    /**
     * Test of destroy method.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = NullPointerException.class)
    public void testDestroy() throws Exception {

        instance.init(args);
        instance.destroy();
        instance.start();
    }
}