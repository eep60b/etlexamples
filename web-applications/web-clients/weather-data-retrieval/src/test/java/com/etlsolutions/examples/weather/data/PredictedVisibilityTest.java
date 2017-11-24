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

        assertTrue(0.0 == PredictedVisibility.VERY_POOR.getValue());
    }

    @Test
    public void testGetMaxValue() {

        assertTrue(1000.0 == PredictedVisibility.VERY_POOR.getMaxValue());
    }

    @Test
    public void testGetPredictedVisibility() {
        
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
}
