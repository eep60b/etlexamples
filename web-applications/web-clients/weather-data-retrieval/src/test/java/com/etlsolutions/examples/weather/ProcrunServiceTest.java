package com.etlsolutions.examples.weather;

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
@PrepareForTest({ProcrunService.class, MetThreadService.class})
public final class ProcrunServiceTest {

    private final MetThreadService service = PowerMockito.mock(MetThreadService.class);
    private final String[] args = {"abad", "bbia"};
    private final InOrder inOrder = Mockito.inOrder(service);
    
    private MetThreadService cachedService;

    @Before
    public void setUp() {

        cachedService = Whitebox.getInternalState(service, "MET_DAEMON", ProcrunService.class);
        Whitebox.setInternalState(ProcrunService.class, "MET_DAEMON", service);
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
     * Test of stop method.
     */
    @Test
    public void testStop() {

        ProcrunService.stop(args);
        inOrder.verify(service).stop();
    }

}
