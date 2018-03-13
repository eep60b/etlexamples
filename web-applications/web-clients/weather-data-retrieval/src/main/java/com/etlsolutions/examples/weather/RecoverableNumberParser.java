package com.etlsolutions.examples.weather;

import org.apache.log4j.Logger;

/**
 * The RecoverableNumberParser class is a superclass whose children provide a
 * parser to parse a string to a number. If the operation fails, Error will be
 * logged as warning information instead of an exception being thrown out.
 *
 * @author zc
 * @param <T> - The number type.
 */
public abstract class RecoverableNumberParser<T extends Number> {

    /**
     * parse the number.
     *
     * @param value - The number string to be parsed.
     * @return
     */
    protected abstract T parseNumber(String value);

    /**
     * Parse the string into a number. If the string cannot be parsed into a
     * number, use the default value string.
     *
     * @param value - The string to be parsed.
     * @param defaultValue - The string for the default value. This string must
     * be valid, otherwise a NumberFormatException will be thrown.
     * @param valueName - The parameter name.
     * @return the parsed value.
     * @throws NumberFormatException exception ONLY when both the given value
     * and the default value cannot be parsed.
     */
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
