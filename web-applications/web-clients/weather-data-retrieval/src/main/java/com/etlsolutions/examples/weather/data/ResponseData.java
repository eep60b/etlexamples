package com.etlsolutions.examples.weather.data;

import java.text.DateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The REsponseData class represents a single response data point.
 *
 * @author zc
 */
public final class ResponseData {

    private final DateTime dateTime;
    private final List<Valuable> valuables;

    /**
     * Construct an object.
     * @param dateTime - The date and time when this data is collected.
     * @param valuables - The values of this data.
     */
    public ResponseData(DateTime dateTime, List<Valuable> valuables) {
        this.dateTime = dateTime;
        this.valuables = Collections.unmodifiableList(valuables);
    }

    /**
     * The date and time when the data is produced.
     *
     * @return the DataTime object.
     */
    public final DateTime getDateTime() {
        return dateTime;
    }

    /**
     * Get the output string for this data.
     *
     * @param datetimeFormat - The date time format.
     * @param delimiter - The delimiter to separate the fields.
     * @return the output string. 
     */
    public final String getOutputString(DateFormat datetimeFormat, String delimiter) {

        String output = datetimeFormat.format(dateTime.getDateTime());

        for (Valuable valuable : getValuables()) {
            output = output + delimiter + valuable.getValue();
        }

        return output;
    }
    
    /**
     * Get the title for this data.
     *
     * @param delimiter - The delimiter to separate the fields.
     * @param additional - The additional string to be insert into the title.
     * @return the title string.
     */
    public final String getTitle(String delimiter, String additional) {

        String output = dateTime.getShortName();
        for (Valuable valuable : getValuables()) {
            output = output + additional + delimiter + valuable.getShortName();
        }

        return output + additional;
    }

    /**
     * Return all the Valuable fields in this object.
     * @return the Valuable array.
     */
    public List<Valuable> getValuables() {
        return valuables;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.dateTime);
        hash = 23 * hash + Objects.hashCode(this.valuables);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResponseData other = (ResponseData) obj;
        
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        return Objects.equals(this.valuables, other.valuables);
    }
}
