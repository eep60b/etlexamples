package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.DEFAULT_TIMEZONE;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequestSource;
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

        for (RequestSource requestSource : parameters.getRequestSources()) {

            RequestMethod requestMethod = requestSource.getRequesttMethod();
            DataBuilder dataBuilder = DataBuilderFactory.getInstance().createDataBuilder(requestMethod);
            
            String fileName = requestMethod.getAbbreviation() + "-" + requestSource.getRequestLocation().getName() + "-" + calendar.get(Calendar.YEAR) + parameters.getDataFileExtension();
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

            ContentResponse response = client.newRequest(requestSource.getUrl()).send();

            client.stop();

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            InputSource is = new InputSource(new StringReader(response.getContentAsString()));

            Document doc = db.parse(is);

            List<ResponseData> newList = dataBuilder.build(doc, list, requestMethod);

            DataFileWriter.getInstance().write(newList, file, additionalFiles, parameters.getDataEncoding());
        }
    }
}
