package com.etlsolutions.examples.weather;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import com.etlsolutions.examples.weather.data.RequestLocation;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.RequestConfig;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import static java.net.HttpURLConnection.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
     * @return true if data is retrieved correctly, otherwise return false.
     * @throws Exception if an error occurs.
     */
    @SuppressWarnings("SleepWhileInLoop")
    public boolean process(ApplicationParameters parameters) throws Exception {

        Logger logger = Logger.getLogger(SingleProcessor.class);

        Calendar calendar = Calendar.getInstance();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        for (RequestConfig requestConfig : parameters.getRequestConfigs()) {

            RequestMethod requestMethod = requestConfig.getRequestMethod();
            ResponseDataBuilder dataBuilder = DataBuilderFactory.getInstance().createDataBuilder(requestMethod);
            RequestLocation location = requestConfig.getRequestLocation();
            int year = calendar.get(Calendar.YEAR);
            String fileName = requestMethod.getAbbreviation() + DATA_FILENAME_SEPARATOR + location.getName() + DATA_FILENAME_SEPARATOR + year + parameters.getDataFileExtension();
            File file = new File(parameters.getDataDirectoryPath() + File.separator + fileName);
            
            //Copy the base file if it is newer than current data file.
            File baseFile = new File(parameters.getBaseDataDirectoryPath() + File.separator + fileName);           
            BaseFileCopier.getInstance().copy(baseFile, file);
            
            List<File> additionalFiles = new ArrayList<>();

            //Don't user functional operations here to compatible for Java 1.7
            for (String path : parameters.getAdditionalDataDirectoryPaths()) {
                if (!path.trim().isEmpty()) {
                    additionalFiles.add(new File(path + File.separator + fileName));
                }
            }

            List<ResponseData> oldList = DataFileReader.getInstance().readData(dataBuilder, file, parameters);

            URL url = new URL(requestConfig.getUrl());
            boolean doIt = true;
            int redirects = 0;

            while (doIt) {

                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                int stat = http.getResponseCode();

                //If it is redirected, find the redirect URL before return the result.
                doIt = stat == HTTP_MOVED_PERM || stat == HTTP_MOVED_TEMP || stat == HTTP_SEE_OTHER || stat == HTTP_USE_PROXY;
                if (doIt) {

                    URL base = http.getURL();
                    String loc = http.getHeaderField("Location");
                    URL target = loc == null ? null : new URL(base, loc);
                    http.disconnect();
                    // Redirection should be allowed only for HTTP and HTTPS and should be limited to 5 redirections at most.
                    if (target == null || !(target.getProtocol().equals("http") || target.getProtocol().equals("https")) || redirects >= 5) {
                        logger.warn("\nIllegal URL redirect: " + loc + "\nData not recorded.");
                        return false;
                    }

                    logger.info("\nUse redirect URL: " + loc);
                    url = target;
                }
            }

            String xmlContent = null;
            Document doc;
            try {

                xmlContent = IOUtils.toString(url, WEBSITE_ENCODING);
                InputSource is = new InputSource(new StringReader(xmlContent));
                doc = db.parse(is);

            } catch (SAXException | IOException ex) {

                logger.warn("\nFailed to parse the xml file: \n" + xmlContent, ex);
                return false;
            }

            List<ResponseData> newList = dataBuilder.build(doc, oldList);

            String formattedLocationId = location.getId();

            while (formattedLocationId.length() < MAXIMUM_LOCATION_ID_LENGTH) {
                formattedLocationId = "0" + formattedLocationId;
            }

            DataFileWriter.getInstance().write(xmlContent.replaceAll("><", ">\n<"), newList, file, additionalFiles, parameters, DATA_FILENAME_SEPARATOR + year + DATA_FILENAME_SEPARATOR + formattedLocationId);
        }
        return true;
    }
}
