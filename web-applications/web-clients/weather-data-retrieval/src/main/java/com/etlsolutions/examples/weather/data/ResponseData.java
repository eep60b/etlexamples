package com.etlsolutions.examples.weather.data;

import java.text.ParseException;

/**
 * The REsponseData class represents a single response data point.
 *
 * @author zc
 */
public interface ResponseData {

    /**
     * The date and time when the data is produced.
     *
     * @return the DataTime object.
     */
    DateTime getDateTime();

    /**
     * Get the title for this data.
     *
     * @param addtional - The additional string to be insert into the title.
     * @return the title string.
     */
    String getTitle(String addtional);

    /**
     * Get the output string for this data.
     *
     * @return the output string.
     * @throws ParseException 
     */
    String getOutputString();
}
