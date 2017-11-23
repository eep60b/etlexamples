package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequesConfig;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
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
public final class SingleProcessor {

    public void process(ApplicationParameters parameters) throws Exception {

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIMEZONE), Locale.ENGLISH);

        for (RequesConfig requestConfig : parameters.getRequestConfigs()) {

            RequestMethod requestMethod = requestConfig.getRequestMethod();
            DataBuilder dataBuilder = DataBuilderFactory.getInstance().createDataBuilder(requestMethod);
            RequestLocation location = requestConfig.getRequestLocation();
            int year = calendar.get(Calendar.YEAR);
            String fileName = requestMethod.getAbbreviation() + "-" + location.getName() + "-" + year + parameters.getDataFileExtension();
            File file = new File(parameters.getDataDirectoryPath() + File.separator + fileName);

            List<File> additionalFiles = new ArrayList<>();

            parameters.getAddtionalDataPaths().stream().forEach((path) -> {
                if (!path.trim().isEmpty()) {
                    additionalFiles.add(new File(path + File.separator + fileName));
                }
            });

            List<ResponseData> list = DataFileReader.getInstance().readData(dataBuilder, file);

            HttpClient client = new HttpClient();
            client.start();

            ContentResponse response = client.newRequest(requestConfig.getUrl()).send();

            client.stop();

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            InputSource is = new InputSource(new StringReader(response.getContentAsString()));

            Document doc = db.parse(is);

            List<ResponseData> newList = dataBuilder.build(doc, list, requestMethod);

            String formattedLocationId = location.getId();
            
            while (formattedLocationId.length() < MAXIMUM_LOCATION_ID_LENGTH) {
                formattedLocationId = "0" + formattedLocationId;
            }
            
            DataFileWriter.getInstance().write(newList, file, additionalFiles, parameters.getDataEncoding(), "-" + year + "-" + formattedLocationId);
        }
    }
}
