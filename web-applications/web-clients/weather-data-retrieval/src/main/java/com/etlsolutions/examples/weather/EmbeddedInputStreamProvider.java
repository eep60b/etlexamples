package com.etlsolutions.examples.weather;

import java.io.InputStream;

/**
 * The EmbeddedInputStreamProvider class provide an InputStream object which can
 * be used to read data files.
 *
 * @author zc
 */
public final class EmbeddedInputStreamProvider {

    private static final EmbeddedInputStreamProvider INSTANCE = new EmbeddedInputStreamProvider();

    private EmbeddedInputStreamProvider() {
    }

    /**
     *
     * @return
     */
    public static EmbeddedInputStreamProvider getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param path
     * @return
     */
    public InputStream getInputStream(String path) {
        return EmbeddedInputStreamProvider.class.getResourceAsStream(path);
    }
}
