package com.etlsolutions.examples.weather;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class BaseFileCopier.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({BaseFileCopier.class, FileUtils.class, Logger.class})
public final class BaseFileCopierTest {

    private final File baseFile = Mockito.mock(File.class);
    private final File file = Mockito.mock(File.class);
    private final Logger logger = Mockito.mock(Logger.class);

    private final BaseFileCopier instance = BaseFileCopier.getInstance();

    @Before
    public void setUp() {
        
        PowerMockito.mockStatic(FileUtils.class);
        PowerMockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(BaseFileCopier.class)).thenReturn(logger);
        
        Mockito.when(baseFile.getAbsolutePath()).thenReturn("baseFfFF");
    }

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertSame(BaseFileCopier.getInstance(), instance);
    }    
    
    
    /**
     * Test of copy method.
     * @throws IOException if an IO error occurs.
     */
    @Test
    public void testCopy() throws IOException {

        Mockito.when(baseFile.isFile()).thenReturn(Boolean.TRUE);
        instance.copy(baseFile, file);
        
        PowerMockito.verifyStatic();
        FileUtils.copyFile(baseFile, file);
        
        Mockito.verify(logger).info("The base file: baseFfFF has been copied.");
    }
    

    /**
     * Test of copy method.
     * @throws IOException if an IO error occurs.
     */
    @Test
    public void testCopy_Newer() throws IOException {

        Mockito.when(baseFile.isFile()).thenReturn(Boolean.TRUE);
        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);
        
        Mockito.when(baseFile.lastModified()).thenReturn(128439257492345L);
        Mockito.when(file.lastModified()).thenReturn(128439257492344L);        
        
        instance.copy(baseFile, file);
        
        PowerMockito.verifyStatic();
        FileUtils.copyFile(baseFile, file);
        Mockito.verify(logger).info("The base file: baseFfFF has been copied.");        
    }    
    

    /**
     * Test of copy method.
     * @throws IOException if an IO error occurs.
     */
    @Test
    public void testCopy_NoBaseFile() throws IOException {

        instance.copy(baseFile, file);
        
        PowerMockito.verifyStatic(Mockito.never());
        FileUtils.copyFile(baseFile, file);
        
        Mockito.verify(logger).trace("The base file: baseFfFF is not a valid file and is not going to be used."); 
    }
    
    /**
     * Test of copy method.
     * @throws IOException if an IO error occurs.
     */
    @Test
    public void testCopy_Older() throws IOException {

        Mockito.when(baseFile.isFile()).thenReturn(Boolean.TRUE);
        Mockito.when(file.isFile()).thenReturn(Boolean.TRUE);
        
        Mockito.when(baseFile.lastModified()).thenReturn(128439257492345L);
        Mockito.when(file.lastModified()).thenReturn(128439257492346L);        
        
        instance.copy(baseFile, file);
        
        PowerMockito.verifyStatic(Mockito.never());
        FileUtils.copyFile(baseFile, file);
    
        
        Mockito.verify(logger).trace("The base file: baseFfFF has NOT been copied.");        
    } 
    
    

    /**
     * Test of copy method.
     * @throws IOException if an IO error occurs.
     */
    @Test
    public void testCopy_Exception() throws IOException {

        RuntimeException ex = Mockito.mock(RuntimeException.class);
        Mockito.when(baseFile.isFile()).thenThrow(ex);
        
        Mockito.when(baseFile.getAbsolutePath()).thenReturn("mybasfiel");
        Mockito.when(file.getAbsolutePath()).thenReturn("myfiell");
        
        instance.copy(baseFile, file);
        
        PowerMockito.verifyStatic(Mockito.never());
        FileUtils.copyFile(baseFile, file);
        
        Mockito.verify(logger).warn("\nFailed to copy the base file: mybasfiel to: myfiell\nThe base file is NOT used.", ex);
    }    

}
