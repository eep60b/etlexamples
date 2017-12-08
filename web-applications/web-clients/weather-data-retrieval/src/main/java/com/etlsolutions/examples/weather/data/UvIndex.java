package com.etlsolutions.examples.weather.data;

/**
 * The UvIndex class represents a UV index.
 *
 * @author zc
 */
public final class UvIndex extends AbstractValuable<Integer>  {

    public static final String SHORT_PARAMETER_NAME = "U";

    public UvIndex(String value) {
        super(Integer.parseInt(value));
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
