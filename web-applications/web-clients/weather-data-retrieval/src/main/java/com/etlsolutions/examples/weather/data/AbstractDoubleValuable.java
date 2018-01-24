package com.etlsolutions.examples.weather.data;

import com.etlsolutions.examples.weather.RecoverableDoubleParser;
import static com.etlsolutions.examples.weather.data.Valuable.UNKNOW_VALUE;

/**
 * The AbstractDoubleValuable abstract class is a super class for a double value
 * of data.
 *
 * @author zc
 */
public abstract class AbstractDoubleValuable extends AbstractValuable<Double> {

    protected AbstractDoubleValuable(String value, String name) {
        super(RecoverableDoubleParser.getInstance().parseNumber(value, UNKNOW_VALUE, name));
    }
}
