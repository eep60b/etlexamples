package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.ResponseData;
import com.etlsolutions.examples.weather.data.Wxfcs3hourlyData;
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author zc
 */
public interface DataBuilder {

    /**
     * Build a Wxfcs3hourlyData object from the given string which is usually a line
 in a text file.
     *
     * @param inputLine - The string.
     * @return the Wxfcs3hourlyData object. This object will be valid in anycase.
 Otherwise an exception will be thrown.
     */
    @SuppressWarnings(value = "ResultOfMethodCallIgnored")
    ResponseData build(String inputLine);

    List<ResponseData> build(Document document, List<ResponseData> savedData, RequestMethod requestMethod);
    
}
