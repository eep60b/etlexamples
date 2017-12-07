package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AbstractValuable.
 *
 * @author zc
 */
public final class AbstractValuableTest {

    private final AbstractValuable<String> instance1 = new AbstractValuableImpl("myvaluejkin");
    private final AbstractValuable<String> instance2 = new AbstractValuableImpl("myvaluejkin");
    private final AbstractValuable<String> instance3 = new AbstractValuableImpl("myvaluejkfain");

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
        assertEquals("myvaluejkin", instance1.getValue());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance2.hashCode(), instance1.hashCode());
        assertNotEquals(instance3.hashCode(), instance1.hashCode());
    }


    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance1.equals(instance2));

        assertFalse(instance1.equals(instance3));
        assertFalse(instance1.equals(new Object()));
        assertFalse(instance1.equals(null));
    }

    private final class AbstractValuableImpl extends AbstractValuable<String> {

        public AbstractValuableImpl(String value) {
            super(value);
        }

        @Override
        public String getShortName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
