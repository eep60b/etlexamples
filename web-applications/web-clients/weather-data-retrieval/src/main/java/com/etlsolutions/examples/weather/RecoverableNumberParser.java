package com.etlsolutions.examples.weather;

import org.apache.log4j.Logger;

/**
 *
 * @author zc
 * @param <T>
 */
public abstract class RecoverableNumberParser<T extends Number> {

    /**
     * 
     * @param value
     * @return 
     */
    protected abstract T parseNumber(String value);

    
    public T parseNumber(String value, String defaultValue, String valueName) {

        try {
            return parseNumber(value);
        } catch (Throwable th) {

            String messsge = "Failed to convert the value to" + defaultValue.getClass().getSimpleName() + " :  " + valueName + "=" + value
                    + "\nThe default value has been used: " + defaultValue;
            Logger.getLogger(getClass()).warn(messsge, th);
            return parseNumber(defaultValue);
        }
    }

}
