package com.etlsolutions.examples.weather;

import java.io.PrintStream;
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
import org.powermock.reflect.Whitebox;

/**
 * Test of class MetServiceExceptionHandler.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MetServiceExceptionHandler.class, Date.class, System.class})
public final class MetServiceExceptionHandlerTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final PrintStream printStream = Mockito.mock(PrintStream.class);
    private final Exception exception = Mockito.mock(Exception.class);
    private final Date date = PowerMockito.mock(Date.class);
    private final InOrder inOrder = Mockito.inOrder(logger, printStream);

    private final MetServiceExceptionHandler instance = new MetServiceExceptionHandler(logger);

    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(date);
        Mockito.when(date.toString()).thenReturn("2018-02-13 09:38:55");

        Whitebox.setInternalState(instance, "printStream", printStream);

        Mockito.when(exception.getMessage()).thenReturn("errororor mmesage");
    }

    /**
     * Test of handleWarning methodr.
     */
    @Test
    public void testHandleWarning() {

        instance.handleWarning(exception);

        inOrder.verify(logger).warn("Process error occured at 2018-02-13 09:38:55.\nThis error is treated as recoverable error.\nThe application is not shutdown.");
        inOrder.verify(logger).warn(exception);
        inOrder.verify(printStream).println("Process error occured at 2018-02-13 09:38:55.\nThis error is treated as recoverable error.\nThe application is not shutdown.");
        inOrder.verify(printStream).println("errororor mmesage");
    }

    /**
     * Test of handleError method.
     */
    @Test
    public void testHandleError() {

        PowerMockito.mockStatic(System.class);

        instance.handleError(exception, "Process error occured");

        inOrder.verify(logger).error("Process error occured at 2018-02-13 09:38:55.", exception);
        inOrder.verify(printStream).println("Process error occured at 2018-02-13 09:38:55.");
        inOrder.verify(printStream).println("errororor mmesage");
        inOrder.verify(printStream).println("Force to terminate the metd service.");

        PowerMockito.mockStatic(System.class);
        System.exit(-1);
    }

}
