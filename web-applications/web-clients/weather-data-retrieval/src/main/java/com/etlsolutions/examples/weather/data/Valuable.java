package com.etlsolutions.examples.weather.data;

/**
 * The Valuable interface defines an object which has a value.
 * @author zc
 */
public interface Valuable {
    
    /**
     * Get the value of this project.
     * @return the value.
     */
    Object getValue();
    
    /**
     * Get the short name of this value.
     * @return the short name.
     */
    String getShortName();
}
