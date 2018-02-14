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
@PrepareForTest({ProcrunService.class, MetThreadService.class, Logger.class, System.class})
public final class ProcrunServiceTest {

    private final MetThreadService service = PowerMockito.mock(MetThreadService.class);
    private final Logger logger = Mockito.mock(Logger.class);
    private final NullPointerException ex = Mockito.mock(NullPointerException.class);
    private final String[] args = {"abad", "bbia"};
    private final InOrder inOrder = Mockito.inOrder(service);

    private MetThreadService cachedService;

    @Before
    public void setUp() {

        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(ProcrunService.class)).thenReturn(logger);

        cachedService = Whitebox.getInternalState(service, "MET_DAEMON", ProcrunService.class);
        Whitebox.setInternalState(ProcrunService.class, "MET_DAEMON", service);

        PowerMockito.mockStatic(System.class);
    }

    @After
    public void tearDown() throws Exception {
        Whitebox.setInternalState(ProcrunService.class, "MET_DAEMON", cachedService);
    }

    /**
     * Test of start method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStart() throws Exception {

        ProcrunService.start(args);

        inOrder.verify(service).init(args);
        inOrder.verify(service).start();
    }

    /**
     * Test of start method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStart_exception() throws Exception {

        PowerMockito.doThrow(ex).when(service).init(args);

        ProcrunService.start(args);

        Mockito.verify(service, Mockito.never()).start();
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
        inOrder.verify(service).stop();
        inOrder.verify(service).destroy();
    }

    /**
     * Test of stop method.
     */
    @Test
    public void testStop_exception() {

        PowerMockito.doThrow(ex).when(service).stop();

        ProcrunService.stop(args);

        Mockito.verify(service, Mockito.never()).destroy();
        Mockito.verify(logger).error("Failed to stop ProcrunService.", ex);

        PowerMockito.verifyStatic();
        System.exit(-1);  
    }
}
