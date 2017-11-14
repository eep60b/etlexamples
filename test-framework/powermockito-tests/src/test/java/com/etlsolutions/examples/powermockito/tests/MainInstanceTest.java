package com.etlsolutions.examples.powermockito.tests;

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of of class MainInstance.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MainInstance.class, ArrayReturnMethods.class})
public final class MainInstanceTest {

    private final ArrayReturnMethods arrayReturnMethods = PowerMockito.mock(ArrayReturnMethods.class);
    private final File file1 = Mockito.mock(File.class);
    private final File[] files = new File[]{file1};

    private final  MainInstance instance = new MainInstance();
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(ArrayReturnMethods.class).withNoArguments().thenReturn(arrayReturnMethods);
        Mockito.when(arrayReturnMethods.getFiles()).thenReturn(files);
    }

    /**
     * Test of arrayReturnOperation method.
     */
    @Test
    public void testArrayReturnOperation() {
          
        instance.arrayReturnOperation();
    }
}
