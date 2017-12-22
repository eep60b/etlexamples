package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The UvIndex class represents a UV index.
 *
 * @author zc
 */
public final class UvIndex extends AbstractValuable<Integer>  {

    public static final String SHORT_PARAMETER_NAME = "U";

    private UvIndex(String value) {
        super(Integer.parseInt(value));
    }

    /**
     * Get an instance of the UvIndex class.
     *
     * @param value - The UV index value.
     * @return the UV index value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static UvIndex getInstance(String value) {
        try {
            return new UvIndex(value);
        } catch (Exception ex) {
            Logger.getLogger(UvIndex.class).warn("Unknown UV index value: " + value, ex);
            return new UvIndex(UNKNOW_VALUE);
        }
    }
     
    @Override
    public String toString() {
        return "UvIndex: " + value;
    }

    @Override
    public String getShortName() {
        return "UvIdx";
    }
}
