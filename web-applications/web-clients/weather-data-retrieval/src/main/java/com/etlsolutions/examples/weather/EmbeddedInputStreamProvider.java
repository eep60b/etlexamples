package com.etlsolutions.examples.weather;

import java.io.InputStream;

/**
 *
 * @author zc
 */
public final class EmbeddedInputStreamProvider {

    private static final EmbeddedInputStreamProvider INSTANCE = new EmbeddedInputStreamProvider();

    private EmbeddedInputStreamProvider() {
    }

    public static EmbeddedInputStreamProvider getInstance() {
        return INSTANCE;
    }

    public InputStream getInputStream(String path) {
        return EmbeddedInputStreamProvider.class.getResourceAsStream(path);
    }
}
