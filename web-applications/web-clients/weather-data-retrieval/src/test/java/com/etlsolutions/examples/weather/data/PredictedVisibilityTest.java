package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public final class PredictedVisibilityTest {

    @Test
    public void testValues() {

        PredictedVisibility[] expResult = {PredictedVisibility.UNKOWN, PredictedVisibility.VERY_POOR, PredictedVisibility.POOR, PredictedVisibility.MODEARATE, PredictedVisibility.GOOD, PredictedVisibility.VERY_GOOD, PredictedVisibility.EXCELLENT};
        assertArrayEquals(expResult, PredictedVisibility.values());
    }

    @Test
    public void testGetCode() {

        assertEquals("VP", PredictedVisibility.VERY_POOR.getCode());
    }

    @Test
    public void testGetMinValue() {

        assertTrue(PredictedVisibility.VERY_POOR.getValue() == 0.0);
    }

    @Test
    public void testGetMaxValue() {

        assertTrue(1000.0 == PredictedVisibility.VERY_POOR.getMaxValue());
    }

    @Test
    public void testGetPredictedVisibility_double() {
        
        assertEquals(PredictedVisibility.UNKOWN, PredictedVisibility.getPredictedVisibility(-1000));
        assertEquals(PredictedVisibility.VERY_POOR, PredictedVisibility.getPredictedVisibility(0));
        assertEquals(PredictedVisibility.POOR, PredictedVisibility.getPredictedVisibility(1000));
        assertEquals(PredictedVisibility.MODEARATE, PredictedVisibility.getPredictedVisibility(4000));
        assertEquals(PredictedVisibility.GOOD, PredictedVisibility.getPredictedVisibility(10000));
        assertEquals(PredictedVisibility.VERY_GOOD, PredictedVisibility.getPredictedVisibility(20000));
        assertEquals(PredictedVisibility.EXCELLENT, PredictedVisibility.getPredictedVisibility(40000));
    }

    @Test
    public void testgetPredictedVisibility() {

        assertEquals(PredictedVisibility.VERY_POOR, PredictedVisibility.getPredictedVisibility("VP"));
    }

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertEquals(0, PredictedVisibility.VERY_POOR.getValue(), 0);
    }


    /**
     * Test of getPredictedVisibility method.
     */
    @Test
    public void testGetPredictedVisibility_String() {

        assertEquals(PredictedVisibility.POOR, PredictedVisibility.getPredictedVisibility("PO"));
        assertEquals(PredictedVisibility.UNKOWN, PredictedVisibility.getPredictedVisibility("POX"));
    }

    /**
     * Test of getShortName method.
     */
    @Test
    public void testGetShortName() {

        assertEquals("PrVis", PredictedVisibility.VERY_GOOD.getShortName());
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("Predicted visibility: MODEARATE(4000.0-10000.0)", PredictedVisibility.MODEARATE.toString());
    }
}
