package com.etlsolutions.examples.weather;

import org.junit.Before;
import org.junit.Test;
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

    @Before
    public void setUp() {

        Whitebox.setInternalState(MetThreadService.class, "MET_DAEMON", service);
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
