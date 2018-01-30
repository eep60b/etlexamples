package com.etlsolutions.examples.weather.data;

/**
 * The RealTemperature class represents the temperature either forecasted or
 * observed.
 *
 * @author zc
 */
public final class RealTemperature extends AbstractDoubleValuable {

    public static final String SHORT_PARAMETER_NAME = "T";

    private RealTemperature(String value) {

        super(value, "Real Temperature");
    }

    /**
     * Get an instance of the RealTemperature class.
     *
     * @param value - The real temperature value.
     * @return the real temperature value. If the given value is invalid, an
     * unknown object is returned. No exception will be thrown.
     */
    public static RealTemperature getInstance(String value) {

        return new RealTemperature(value);
    }

    @Override
    public String toString() {
        return "Real temperature: " + value;
    }

    @Override
    public String getShortName() {
        return "Tempt";
    }
}
