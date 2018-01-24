package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableDoubleParser;
import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;
import org.apache.log4j.Logger;

/**
 * The PrecipitationProbability class represents a precipitation probability.
 *
 * @author zc
 */
public final class PrecipitationProbability extends AbstractDoubleValuable {
    
    public static final String SHORT_PARAMETER_NAME = "Pp";
    public static final double MINIMUM_VALUE = 0;
    public static final double MAXIMUM_VALUE = 100;
    
    private PrecipitationProbability(String value) {

        super(value, "Precipitation Probability");
    }
    /**
     * Get an instance of the PrecipitationProbability class.
     *
     * @param value - The precipitation probability value.
     * @return the precipitation probability value. If the given value is invalid, an unknown
     * object is returned. No exception will be thrown.
     */
    public static PrecipitationProbability getInstance(String value) {
            return new PrecipitationProbability(value);
    }
 
    @Override
    public String toString() {
        return "PrecipitationProbability: " + value;
    }

    @Override
    public String getShortName() {
        return "PpPrb";
    }
}
