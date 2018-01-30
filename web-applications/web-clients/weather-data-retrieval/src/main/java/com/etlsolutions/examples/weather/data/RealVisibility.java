package com.etlsolutions.examples.weather.data;

/**
 * The RealVisibility class represents a data point of real visibility.
 *
 * @author zc
 */
public final class RealVisibility extends AbstractDoubleValuable {

    public static final String SHORT_PARAMETER_NAME = "V";

    private RealVisibility(String value) {

        super(value, "Real Visibility");
    }

    /**
     * Get an instance of the RealVisibility class.
     *
     * @param value - The real visibility value.
     * @return the real visibility value. If the given value is invalid, an
     * unknown object is returned. No exception will be thrown.
     */
    public static RealVisibility getInstance(String value) {

        return new RealVisibility(value);
    }

    @Override
    public String getShortName() {
        return "Vsblt";
    }

    @Override
    public String toString() {
        return "Real visibility: " + value;
    }
}
