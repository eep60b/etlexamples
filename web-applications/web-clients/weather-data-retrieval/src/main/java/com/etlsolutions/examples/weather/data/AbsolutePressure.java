package com.etlsolutions.examples.weather.data;

/**
 * The AbsolutePressure class represents the air pressure.
 *
 * @author zc
 */
public final class AbsolutePressure extends AbstractValuable<Double> {

    public static final String SHORT_PARAMETER_NAME = "P";
    
    public AbsolutePressure(String value) {

        super(Double.parseDouble(value));
    }


    @Override
    public String toString() {
        return "Pressure: " + value;
    }

    @Override
    public String getShortName() {
        return "Press";
    }
}
