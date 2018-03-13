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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
     * @throws ParserConfigurationException if the DocumentBuilder cannot be generated.
     * @throws ParseException if the XML content cannot be parsed.
     * @throws IOException if an IO error occurs.
     */
    @SuppressWarnings({"SleepWhileInLoop", "null"})
    public boolean process(ApplicationParameters parameters) throws ParserConfigurationException, ParseException, IOException {

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
            String baseDataDirectoryPath = parameters.getBaseDataDirectoryPath();
            if (new File(baseDataDirectoryPath).isDirectory()) {
                File baseFile = new File(baseDataDirectoryPath + File.separator + fileName);
                BaseFileCopier.getInstance().copy(baseFile, file);
            }
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

            HttpURLConnection http = null;
            while (doIt) {

                http = (HttpURLConnection) url.openConnection();
                int stat = http.getResponseCode();

                List<Integer> stats = Arrays.asList(HTTP_MOVED_PERM, HTTP_MOVED_TEMP, HTTP_SEE_OTHER, HTTP_USE_PROXY);

                //If it is redirected, find the redirect URL before return the result.
                doIt = stats.contains(stat);
                if (doIt) {

                    URL base = http.getURL();
                    String loc = http.getHeaderField("Location");
                    URL target = loc == null ? null : new URL(base, loc);
                    http.disconnect();

                    // Redirection should be allowed only for HTTP and HTTPS and should be limited to 5 redirections at most.                   
                    if (target == null) {
                        logger.warn("\nIllegal URL redirect: " + loc + "\nData not recorded.");
                        return false;
                    }

                    if (redirects > stats.size()) {
                        logger.warn("\nIllegal URL redirect: " + loc + "\nData not recorded.");
                        logger.warn("\nToo many redirects.");
                        return false;
                    }

                    String protocol = target.getProtocol();
                    if (!(protocol.equals("http") || protocol.equals("https"))) {
                        logger.warn("\nIllegal URL redirect: " + loc + "\nData not recorded.");
                        logger.warn("Uknown protocol: " + protocol);
                        return false;
                    }

                    logger.info("\nUse redirect URL: " + loc);
                    url = target;
                    redirects++;
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
                logger.warn(http.getResponseMessage());                
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
