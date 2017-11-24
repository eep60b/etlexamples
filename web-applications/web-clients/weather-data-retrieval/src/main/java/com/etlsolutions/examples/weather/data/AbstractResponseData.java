package com.etlsolutions.examples.weather.data;

import java.text.DateFormat;

/**
 * The AbstractResponseData class is a super class which implements the common
 * methods for the ResponseData objects.
 *
 * @author zc
 */
public abstract class AbstractResponseData implements ResponseData {

    private final DateTime dateTime;

    protected AbstractResponseData(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public final DateTime getDateTime() {
        return dateTime;
    }

    @Override
    public final String getOutputString(DateFormat dateTimeFormat, String delimiter) {

        String output = dateTimeFormat.format(dateTime.getDateTime());

        for (Valuable valuable : getValuables()) {
            output = output + delimiter + valuable.getValue();
        }

        return output;
    }

    @Override
    public final String getTitle(String delimiter, String additional) {

        String output = dateTime.getShortName();
        for (Valuable valuable : getValuables()) {
            output = output + additional + delimiter + valuable.getShortName();
        }

        return output + additional;
    }
}
