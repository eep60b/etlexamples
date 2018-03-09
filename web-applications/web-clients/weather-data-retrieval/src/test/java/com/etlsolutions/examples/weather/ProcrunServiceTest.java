package com.etlsolutions.examples.weather;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Test of class ProcrunService.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ProcrunService.class, MetThreadService.class, FtpsService.class, ApplicationParameters.class, Logger.class, System.class})
public final class ProcrunServiceTest {

    private final MetThreadService metThreadService = PowerMockito.mock(MetThreadService.class);
    private final FtpsService ftpsService = PowerMockito.mock(FtpsService.class);
    private final ApplicationParameters parameters = PowerMockito.mock(ApplicationParameters.class);    
    private final Logger logger = Mockito.mock(Logger.class);
    private final NullPointerException ex = Mockito.mock(NullPointerException.class);
    private final String[] args = {"abad", "bbia"};
    private final InOrder inOrder = Mockito.inOrder(metThreadService, ftpsService);

    private MetThreadService cachedMetThreadService;
    private FtpsService cachedFtpsService = PowerMockito.mock(FtpsService.class);

    @Before
    public void setUp() throws Exception {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(ProcrunService.class)).thenReturn(logger);

        cachedMetThreadService = Whitebox.getInternalState(metThreadService, "MET_DAEMON", ProcrunService.class);
        Whitebox.setInternalState(ProcrunService.class, "MET_DAEMON", metThreadService);

        cachedFtpsService = Whitebox.getInternalState(ftpsService, "FTPS_SERVICE", ProcrunService.class);
        Whitebox.setInternalState(ProcrunService.class, "FTPS_SERVICE", ftpsService);

        Mockito.when(metThreadService.init(args)).thenReturn(parameters);

        PowerMockito.mockStatic(System.class);
    }

    @After
    public void tearDown() throws Exception {
        Whitebox.setInternalState(ProcrunService.class, "MET_DAEMON", cachedMetThreadService);
        Whitebox.setInternalState(ProcrunService.class, "FTPS_SERVICE", cachedFtpsService);
    }

    /**
     * Test of start method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStart() throws Exception {

        Mockito.when(parameters.isUseFtpsService()).thenReturn(Boolean.TRUE);
        
        ProcrunService.start(args);

        inOrder.verify(metThreadService).start();
        inOrder.verify(ftpsService).init(parameters);
        inOrder.verify(ftpsService).start();
    }

    /**
     * Test of start method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStart_without_FTPS_service() throws Exception {

        Mockito.when(parameters.isUseFtpsService()).thenReturn(Boolean.FALSE);
        
        ProcrunService.start(args);

        Mockito.verify(metThreadService).start();
        Mockito.verify(ftpsService, Mockito.never()).init(parameters);
        Mockito.verify(ftpsService, Mockito.never()).start();
    }
    
    /**
     * Test of start method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStart_exception() throws Exception {

        PowerMockito.doThrow(ex).when(metThreadService).init(args);

        ProcrunService.start(args);

        Mockito.verify(metThreadService, Mockito.never()).start();
        Mockito.verify(logger).error("Failed to start ProcrunService.", ex);

        PowerMockito.verifyStatic();
        System.exit(-1);
    }

    /**
     * Test of stop method.
     */
    @Test
    public void testStop() {

        ProcrunService.stop(args);
        inOrder.verify(metThreadService).stop();
        inOrder.verify(metThreadService).destroy();
        inOrder.verify(ftpsService).stop();
    }

    /**
     * Test of stop method.
     */
    @Test
    public void testStop_exception() {

        PowerMockito.doThrow(ex).when(metThreadService).stop();

        ProcrunService.stop(args);

        Mockito.verify(metThreadService, Mockito.never()).destroy();
        Mockito.verify(logger).error("Failed to stop ProcrunService.", ex);

        PowerMockito.verifyStatic();
        System.exit(-1);
    }
}
