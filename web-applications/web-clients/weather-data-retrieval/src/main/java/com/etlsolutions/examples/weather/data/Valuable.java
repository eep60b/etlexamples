package com.etlsolutions.examples.weather.data;

/**
 * The Valuable interface defines an object which has a value.
 *
 * @param <T> - The value type.
 * @author zc
 */
public interface Valuable<T> {

    String UNKNOW_VALUE = "-100";

    /**
     * Get the value of this project.
     *
     * @return the value.
     */
    T getValue();

    /**
     * Get the short name of this value.
     *
     * @return the short name.
     */
    String getShortName();
}
