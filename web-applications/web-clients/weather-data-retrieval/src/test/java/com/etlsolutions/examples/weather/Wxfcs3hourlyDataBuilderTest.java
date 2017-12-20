package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.DateTime;
import com.etlsolutions.examples.weather.data.Wxfcs3hourlyData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.NamedNodeMap;

/**
 * Test of class Wxfcs3hourlyDataBuilder.
 *
 * @author zc
 */
public final class Wxfcs3hourlyDataBuilderTest {

    private final Wxfcs3hourlyDataBuilder instance = new Wxfcs3hourlyDataBuilder();
    
    @Before
    public void setUp() {
    }

    /**
     * Test of build method.
     */
    @Test
    public void testBuild() throws Exception {
        System.out.println("build");
        String line = "";
        ApplicationParameters parameters = null;
        
        Wxfcs3hourlyData expResult = null;
        Wxfcs3hourlyData result = instance.build(line, parameters);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createData method, of class Wxfcs3hourlyDataBuilder.
     */
    @Test
    public void testCreateData() {
        System.out.println("createData");
        NamedNodeMap repAttributes = null;
        DateTime dateTime = null;
        Wxfcs3hourlyDataBuilder instance = new Wxfcs3hourlyDataBuilder();
        Wxfcs3hourlyData expResult = null;
        Wxfcs3hourlyData result = instance.createData(repAttributes, dateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
