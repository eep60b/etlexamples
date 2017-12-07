package com.etlsolutions.examples.weather.data;

/**
 * The UvIndex class represents a UV index.
 *
 * @author zc
 */
public final class UvIndex implements Valuable {

    public static final String SHORT_PARAMETER_NAME = "U";

    private final int value;

    public UvIndex(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UV index: " + value;
    }

    @Override
    public String getShortName() {
        return "UvIdx";
    }
}
