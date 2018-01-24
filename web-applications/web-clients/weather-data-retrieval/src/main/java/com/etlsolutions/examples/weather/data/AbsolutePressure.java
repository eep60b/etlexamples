package com.etlsolutions.examples.weather.data;

/**
 * The AbsolutePressure class represents the air pressure.
 *
 * @author zc
 */
public final class AbsolutePressure extends AbstractDoubleValuable {

    public static final String SHORT_PARAMETER_NAME = "P";

    private AbsolutePressure(String value) {

        super(value, "Absolute pressure");
    }

    /**
     * Get an instance of the AbsolutePressure class.
     *
     * @param value - The absolute pressure value.
     * @return the absolute pressure value. If the given value is invalid, an
     * unknown object is returned. No exception will be thrown.
     */
    public static AbsolutePressure getInstance(String value) {

        return new AbsolutePressure(value);
    }

    @Override
    public String toString() {
        return "Absolute Pressure: " + value;
    }

    @Override
    public String getShortName() {
        return "Press";
    }
}
