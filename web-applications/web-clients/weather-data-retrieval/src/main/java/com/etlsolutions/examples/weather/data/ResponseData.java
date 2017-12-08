package com.etlsolutions.examples.weather.data;

import java.text.DateFormat;

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
     * @param delimiter - The delimiter to separate the fields.
     * @param addtional - The additional string to be insert into the title.
     * @return the title string.
     */
    String getTitle(String delimiter, String addtional);

    /**
     * Get the output string for this data.
     *
     * @param datetimeFormat - The date time format.
     * @param delimiter - The delimiter to separate the fields.
     * @return the output string. 
     */
    String getOutputString(DateFormat datetimeFormat, String delimiter);
    
    /**
     * Return all the Valuable fields in this object.
     * @return the Valuable array.
     */
    Valuable[] getValuables();
}
