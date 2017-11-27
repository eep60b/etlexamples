package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The ResponseDataBuilder interface define an object which can build REsponseData
 objects.
 *
 * @author zc
 */
public abstract class ResponseDataBuilder {

    /**
     * Build a ResponseData object from the given string which is usually a line
     * in a text file.
     *
     * @param inputLine - The string.
     * @param parameters - The parameters.
     * @return the ResponseData object. This method should return a valid
     * object. Otherwise an exception should be thrown.
     * @throws ParseException if the date and time in the input line cannot be
     * parsed.
     */
    @SuppressWarnings(value = "ResultOfMethodCallIgnored")
    public abstract ResponseData build(String inputLine, ApplicationParameters parameters) throws ParseException;

    /**
     * Create a new ResponseData object.
     *
     * @param repAttributes - The node attributes which contains information of the data.
     * @param dateTime - The data and time of the data collected.
     * @return the new ResponseData object.
     */
    public abstract ResponseData createData(NamedNodeMap repAttributes, DateTime dateTime);

    /**
     * Build a oldList of ResponseData objects from the given XML document and
 attached it to the end of existing oldList.
     *
     * @param document - The XML document.
     * @param savedData - The existing oldList.
     * @param requestMethod - The method to request data.
     * @return the new oldList of ResponseData objects.
     */
    public final List<ResponseData> build(Document document, List<ResponseData> savedData, RequestMethod requestMethod) {

        List<ResponseData> oldList = new ArrayList<>(savedData);
        List<ResponseData> newList = new ArrayList<>();
        NodeList documentChildren = document.getChildNodes();

        for (int i = 0; i < documentChildren.getLength(); i++) {

            Node documentChild = documentChildren.item(i);
            if (documentChild.getNodeName().equals("SiteRep")) {

                NodeList siteRepChildren = documentChild.getChildNodes();

                for (int j = 0; j < siteRepChildren.getLength(); j++) {

                    Node siteRepChild = siteRepChildren.item(j);

                    if (siteRepChild.getNodeName().equals("DV")) {

                        NodeList dvChildren = siteRepChild.getChildNodes();

                        for (int k = 0; k < dvChildren.getLength(); k++) {

                            Node dvChild = dvChildren.item(k);
                            if (dvChild.getNodeName().equals("Location")) {

                                NodeList locationChildren = dvChild.getChildNodes();

                                for (int l = 0; l < locationChildren.getLength(); l++) {

                                    Node periodNode = locationChildren.item(l);
                                    NamedNodeMap periodAttributes = periodNode.getAttributes();
                                    String date = periodAttributes.getNamedItem("value").getTextContent();
                                    NodeList periodChildren = periodNode.getChildNodes();

                                    for (int m = 0; m < periodChildren.getLength(); m++) {

                                        Node repNode = periodChildren.item(m);
                                        String timeString = repNode.getTextContent();

                                        DateTime dateTime = new DateTime(date, timeString);

                                        for (int n = oldList.size() - 1; n >= 0; n--) {
                                            ResponseData data = oldList.get(n);
                                            if (data.getDateTime().equals(dateTime)) {
                                                oldList.remove(n);
                                            }
                                        }
                                        NamedNodeMap repAttributes = repNode.getAttributes();
                                        newList.add(createData(repAttributes, dateTime));

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        oldList.addAll(newList);
        return Collections.unmodifiableList(oldList);
    }
}
