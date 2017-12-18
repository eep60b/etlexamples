package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.RequestMethod;
import com.etlsolutions.examples.weather.data.ResponseData;
import java.text.ParseException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;

/**
 * Test of class ResponseDataBuilder.
 *
 * @author zc
 */
public final class ResponseDataBuilderTest {

    public void setUp() {
    }

    /**
     * Test of build method.
     */
    @Test
    public void testBuild_3args() {
        System.out.println("build");
        Document document = null;
        List<ResponseData> savedData = null;
        RequestMethod requestMethod = null;
        ResponseDataBuilder instance = new ResponseDataBuilderImpl();
        List<ResponseData> expResult = null;
        List<ResponseData> result = instance.build(document, savedData, requestMethod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private final class ResponseDataBuilderImpl extends ResponseDataBuilder {

        @Override
        public ResponseData build(String inputLine, ApplicationParameters parameters) throws ParseException {
            return null;
        }

        @Override
        public ResponseData createData(NamedNodeMap repAttributes, DateTime dateTime) {
            return null;
        }
    }

}
