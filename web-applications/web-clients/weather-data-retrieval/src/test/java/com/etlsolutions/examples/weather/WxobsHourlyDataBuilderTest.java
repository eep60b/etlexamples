package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.WxobsHourlyData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author zc
 */
public final class WxobsHourlyDataBuilderTest {

    
    @Before
    public void setUp() {
    }


    /**
     * Test of build method, of class WxobsHourlyDataBuilder.
     */
    @Test
    public void testBuild() throws Exception {
        System.out.println("build");
        String inputLine = "";
        ApplicationParameters parameters = null;
        WxobsHourlyDataBuilder instance = new WxobsHourlyDataBuilder();
        WxobsHourlyData expResult = null;
        WxobsHourlyData result = instance.build(inputLine, parameters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createData method, of class WxobsHourlyDataBuilder.
     */
    @Test
    public void testCreateData() {
        System.out.println("createData");
        NamedNodeMap repAttributes = null;
        DateTime dateTime = null;
        WxobsHourlyDataBuilder instance = new WxobsHourlyDataBuilder();
        WxobsHourlyData expResult = null;
        WxobsHourlyData result = instance.createData(repAttributes, dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
