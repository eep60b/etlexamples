package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableIntParser;
import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;

/**
 * The UvIndex class represents a UV index.
 *
 * @author zc
 */
public final class UvIndex extends AbstractValuable<Integer> {

    public static final String SHORT_PARAMETER_NAME = "U";

    private UvIndex(String value) {
        super(RecoverableIntParser.getInstance().parseNumber(value, UNKNOW_VALUE, "UV Index"));
    }

    /**
     * Get an instance of the UvIndex class.
     *
     * @param value - The UV index value.
     * @return the UV index value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static UvIndex getInstance(String value) {

        return new UvIndex(value);
    }

    @Override
    public String toString() {
        return "UV Index: " + value;
    }

    @Override
    public String getShortName() {
        return "UvIdx";
    }
}
