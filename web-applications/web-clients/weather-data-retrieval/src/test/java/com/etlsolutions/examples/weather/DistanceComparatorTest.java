package com.etlsolutions.examples.weather;

import com.etlsolutions.examples.weather.data.RequestLocation;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zc
 */
public final class DistanceComparatorTest {

    private final DistanceComparator instance = new DistanceComparator(30.0, 40.0);

    /**
     * Test of compare method.
     */
    @Test
    public void testCompare() {

        assertTrue(instance.compare(new RequestLocation("19872", "iiajfd", 30.1, 40.1, 12.0), new RequestLocation("2541", "ibango", 30.11, 40.11, 89.0)) < 0);
        assertTrue(instance.compare(new RequestLocation("19872", "iiajfd", 30.12, 40.12, 10.0), new RequestLocation("2541", "ibango", 30.11, 40.11, 598.0)) > 0);
        assertTrue(instance.compare(new RequestLocation("19872", "iiajfd", 30.1, 40.1, 12.0), new RequestLocation("2541", "ibango", 29.9, 39.9, 69.0)) == 0);
    }
}
