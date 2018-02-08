package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.EMBEDDED_LOCATIONS_FILE_PATH;
import java.io.IOException;
import java.io.InputStream;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test of class EmbeddedInputStreamProvider.
 *
 * @author zc
 */
public final class EmbeddedInputStreamProviderTest {

    private final EmbeddedInputStreamProvider instance = EmbeddedInputStreamProvider.getInstance();

    /**
     * Test of getInstance method.
     */
    @Test
    public void testGetInstance() {

        assertSame(EmbeddedInputStreamProvider.getInstance(), instance);
    }

    /**
     * Test of getInputStream method.
     *
     * @throws IOException if an IO error occurs.
     */
    @Test
    public void testGetInputStream() throws IOException {

        byte[] b = new byte[10];

        InputStream result = instance.getInputStream(EMBEDDED_LOCATIONS_FILE_PATH);
        
        assertEquals(916994, result.available());
        
        instance.getInputStream(EMBEDDED_LOCATIONS_FILE_PATH).read(b);
        
        assertArrayEquals(new byte[]{60,63,120,109,108,32,118,101,114,115}, b);        
    }
}
