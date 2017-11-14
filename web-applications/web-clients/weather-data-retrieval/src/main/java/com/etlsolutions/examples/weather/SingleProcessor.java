package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.DEFAULT_TIMEZONE;
import com.etlsolutions.examples.weather.data.ForecastData;
import java.io.File;
import java.io.StringReader;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author zc
 */
public class SingleProcessor {

    public void process(ApplicationParameters parameters) throws Exception {
        
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIMEZONE), Locale.ENGLISH);
        int year = calendar.get(Calendar.YEAR);
        File file = new File(parameters.getDataDirectoryPath() + File.separator + year);        
        
        List<ForecastData> list = DataFileReader.readData(file);
        
        HttpClient client = new HttpClient();
        client.start();
        
        ContentResponse response = client.newRequest(parameters.getUrl()).send();
        
        client.stop();
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        
        InputSource is = new InputSource(new StringReader(response.getContentAsString()));
        
        Document doc = db.parse(is);
        
        List<ForecastData> newList = ForecastDataBuilder.build(doc, list, parameters.getForecastMethod());
        
        DataFileWriter.write(newList, file);
        
        doc.getChildNodes().item(0);
        
    }
}