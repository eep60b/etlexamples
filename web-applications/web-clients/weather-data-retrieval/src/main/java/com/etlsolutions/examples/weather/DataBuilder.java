package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.text.ParseException;
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author zc
 */
public interface DataBuilder {

    /**
     * Build a ResponseData object from the given string which is usually a line
     * in a text file.
     *
     * @param inputLine - The string.
     * @return the ResponseData object. This method should return a valid
     * object. Otherwise an exception should be thrown.
     * @throws ParseException if the date and time in the input line cannot be parsed.
     */
    @SuppressWarnings(value = "ResultOfMethodCallIgnored")
    ResponseData build(String inputLine) throws ParseException;

    /**
     * Build a list of ResponseData objects from the given XML document and
     * attached it to the end of existing list.
     *
     * @param document - The XML document.
     * @param savedData - The existing list.
     * @param requestMethod - The method to request data.
     * @return the new list of ResponseData objects.
     */
    List<ResponseData> build(Document document, List<ResponseData> savedData, RequestMethod requestMethod);

}
