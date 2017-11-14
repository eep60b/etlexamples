package com.etlsolutions.examples.weather;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author zc
 */
public class DocumentGenerator {

    public Document createDocument() throws ParserConfigurationException, SAXException, IOException, InterruptedException, TimeoutException, ExecutionException, Exception {

        HttpClient client = new HttpClient();
        client.start();
        ContentResponse response = client.newRequest("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/xml/350232?res=3hourly&key=8412a27d-b855-4b0c-8b2d-b8b8f5285ae8").send();
        client.stop();
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(response.getContentAsString()));
        Document doc = db.parse(is);
        doc.getChildNodes().item(0);
        return doc;

    }
}
