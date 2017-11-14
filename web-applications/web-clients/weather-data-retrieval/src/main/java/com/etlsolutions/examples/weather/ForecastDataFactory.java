package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.ForecastData;
import org.w3c.dom.Document;

/**
 *
 * @author zc
 */
public class ForecastDataFactory {
    
    
    public static final ForecastData createForecastData (Document document) {
        
        
        
        return new ForecastData(null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
