package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * The SingleProcessor class generates a single set of data each time.
 *
 * @author zc
 */
public final class SingleProcessor {

    /**
     * Generate a single set of data for the given parameters.
     *
     * @param parameters - The specified parameters.
     * @throws Exception if an error occurs.
     */
    public void process(ApplicationParameters parameters) throws Exception {

        Calendar calendar = Calendar.getInstance();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        for (RequestConfig requestConfig : parameters.getRequestConfigs()) {

            RequestMethod requestMethod = requestConfig.getRequestMethod();
            ResponseDataBuilder dataBuilder = DataBuilderFactory.getInstance().createDataBuilder(requestMethod);
            RequestLocation location = requestConfig.getRequestLocation();
            int year = calendar.get(Calendar.YEAR);
            String fileName = requestMethod.getAbbreviation() + DATA_FILENAME_SEPARATOR + location.getName() + DATA_FILENAME_SEPARATOR + year + parameters.getDataFileExtension();
            File file = new File(parameters.getDataDirectoryPath() + File.separator + fileName);

            List<File> additionalFiles = new ArrayList<>();

            //Don't user functional operations here to compatible for Java 1.7
            for (String path : parameters.getAdditionalDataDirectoryPaths()) {
                if (!path.trim().isEmpty()) {
                    additionalFiles.add(new File(path + File.separator + fileName));
                }
            }

            List<ResponseData> oldList = DataFileReader.getInstance().readData(dataBuilder, file, parameters);

            URL url = new URL(requestConfig.getUrl());
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            String xmlContent = IOUtils.toString(url, WEBSITE_ENCODING);
            InputSource is = new InputSource(new StringReader(xmlContent));

            Document doc = db.parse(is);

            List<ResponseData> newList = dataBuilder.build(doc, oldList);

            String formattedLocationId = location.getId();

            while (formattedLocationId.length() < MAXIMUM_LOCATION_ID_LENGTH) {
                formattedLocationId = "0" + formattedLocationId;
            }

            DataFileWriter.getInstance().write(xmlContent.replaceAll("><", ">\n<"), newList, file, additionalFiles, parameters, DATA_FILENAME_SEPARATOR + year + DATA_FILENAME_SEPARATOR + formattedLocationId);
        }
    }
}
