package com.etlsolutions.examples.weather;

import org.apache.commons.daemon.DaemonContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@PrepareForTest({MetDaemon.class, MetThreadService.class})
public final class MetDaemonTest {

    private final MetThreadService metThreadService = Mockito.mock(MetThreadService.class);
    private final DaemonContext daemonContext = Mockito.mock(DaemonContext.class);
    private final String[] args = {"abc"};

    private MetDaemon instance;

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(MetThreadService.class).withNoArguments().thenReturn(metThreadService);
        Mockito.when(daemonContext.getArguments()).thenReturn(args);
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

        Mockito.verify(metThreadService).init(args);
    }

    /**
     * Test of start method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStart() throws Exception {

        instance.start();       
        Mockito.verify(metThreadService).start();
       
    }

    /**
     * Test of stop method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testStop() throws Exception {

        instance.stop();        
        Mockito.verify(metThreadService).stop();
        
    }

    /**
     * Test of destroy method.
     */
    public void testDestroy() {

        instance.destroy();
        Mockito.verify(metThreadService).destroy();
    }

}
