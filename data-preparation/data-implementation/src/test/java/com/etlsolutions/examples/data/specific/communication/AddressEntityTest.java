/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.data.specific.communication;

import com.etlsolutions.examples.data.api.Address;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class AddressEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AddressEntityTest {

    private final AddressHouse house = new AddressHouse("114");
    private final AddressHouse house1 = new AddressHouse("panhouse");
    private final AddressStreet street = new AddressStreet("main address1");
    private final AddressStreet street2 = new AddressStreet("main address2");
    private final AddressAdditionalInformation additional = new AddressAdditionalInformation("additi1");
    private final AddressAdditionalInformation additional3 = new AddressAdditionalInformation("additi2");
    private final AddressArea areaColumn = new AddressArea("gwynedd");
    private final AddressArea areaColumn4 = new AddressArea("great manchester");
    private final AddressCity cityColumn = new AddressCity("bangor");
    private final AddressCity cityColumn5 = new AddressCity("manchester");
    private final AddressCountry countryColumn = new AddressCountry("UK");
    private final AddressCountry countryColumn6 = new AddressCountry("UN");
    private final AddressPostcode postcodeColumn = new AddressPostcode("LL57 4LN");
    private final AddressPostcode postcodeColumn7 = new AddressPostcode("M9 6EY");
    private final Address address = Mockito.mock(Address.class);
    
    private final AddressEntity instance  = new AddressEntity(house, street, additional, areaColumn, cityColumn, countryColumn, postcodeColumn);
    private final AddressEntity instance00 = new AddressEntity(house, street, additional, areaColumn, cityColumn, countryColumn, postcodeColumn);
    private final AddressEntity instance01 = new AddressEntity(house1, street, additional, areaColumn, cityColumn, countryColumn, postcodeColumn);
    private final AddressEntity instance02 = new AddressEntity(house, street2, additional, areaColumn, cityColumn, countryColumn, postcodeColumn);
    private final AddressEntity instance03 = new AddressEntity(house, street, additional3, areaColumn, cityColumn, countryColumn, postcodeColumn);
    private final AddressEntity instance04 = new AddressEntity(house, street, additional, areaColumn4, cityColumn, countryColumn, postcodeColumn);
    private final AddressEntity instance05 = new AddressEntity(house, street, additional, areaColumn, cityColumn5, countryColumn, postcodeColumn);
    private final AddressEntity instance06 = new AddressEntity(house, street, additional, areaColumn, cityColumn, countryColumn6, postcodeColumn);
    private final AddressEntity instance07 = new AddressEntity(house, street, additional, areaColumn, cityColumn, countryColumn, postcodeColumn7);
    private final AddressEntity instance08 = new AddressEntity(instance);

    private AddressEntity instance09;
    
    @Before
    public void setUp() {

        Mockito.when(address.getHouse()).thenReturn("114");
        Mockito.when(address.getStreet()).thenReturn("main address1");
        Mockito.when(address.getAdditional()).thenReturn("additi1");
        Mockito.when(address.getArea()).thenReturn("gwynedd");
        Mockito.when(address.getCity()).thenReturn("bangor");
        Mockito.when(address.getCountry()).thenReturn("UK");
        Mockito.when(address.getPostcode()).thenReturn("LL57 4LN");

        instance09 = new AddressEntity(address);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_1() {
        new AddressEntity(null, street, additional, areaColumn, cityColumn, countryColumn, postcodeColumn);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_2() {
        new AddressEntity(house, null, additional, areaColumn, cityColumn, countryColumn, postcodeColumn);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_3() {
        new AddressEntity(house, street, null, areaColumn, cityColumn, countryColumn, postcodeColumn);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_4() {
        new AddressEntity(house, street, additional, null, cityColumn, countryColumn, postcodeColumn);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_5() {
        new AddressEntity(house, street, additional, areaColumn, null, countryColumn, postcodeColumn);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_6() {
        new AddressEntity(house, street, additional, areaColumn, cityColumn, null, postcodeColumn);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_7() {
        new AddressEntity(house, street, additional, areaColumn, cityColumn, countryColumn, null);
    }

    /**
     * Test of getHouse method.
     */
    @Test
    public void testGetHouse() {

        assertEquals("114", instance.getHouse());
        assertEquals("panhouse", instance01.getHouse());
        assertEquals("114", instance08.getHouse());
        assertEquals("114", instance09.getHouse());
    }

    /**
     * Test of getStreet method.
     */
    @Test
    public void testGetStreet() {
        assertEquals("main address1", instance.getStreet());
        assertEquals("main address2", instance02.getStreet());
        assertEquals("main address1", instance08.getStreet());
        assertEquals("main address1", instance09.getStreet());
    }

    /**
     * Test of getAdditional method.
     */
    @Test
    public void testGetAdditional() {

        assertEquals("additi1", instance.getAdditional());
        assertEquals("additi2", instance03.getAdditional());
        assertEquals("additi1", instance08.getAdditional());
        assertEquals("additi1", instance09.getAdditional());
    }

    /**
     * Test of getArea method.
     */
    @Test
    public void testGetArea() {

        assertEquals("gwynedd", instance.getArea());
        assertEquals("great manchester", instance04.getArea());
        assertEquals("gwynedd", instance08.getArea());
        assertEquals("gwynedd", instance09.getArea());
    }

    /**
     * Test of getCity method.
     */
    @Test
    public void testGetCity() {

        assertEquals("bangor", instance.getCity());
        assertEquals("manchester", instance05.getCity());
        assertEquals("bangor", instance08.getCity());
        assertEquals("bangor", instance09.getCity());
    }

    /**
     * Test of getCountry method.
     */
    @Test
    public void testGetCountry() {
        assertEquals("UK", instance.getCountry());
        assertEquals("UN", instance06.getCountry());
        assertEquals("UK", instance08.getCountry());
        assertEquals("UK", instance09.getCountry());
    }

    /**
     * Test of getPostcode method.
     */
    @Test
    public void testGetPostcode() {

        assertEquals("LL57 4LN", instance.getPostcode());
        assertEquals("M9 6EY", instance07.getPostcode());
        assertEquals("LL57 4LN", instance08.getPostcode());
        assertEquals("LL57 4LN", instance09.getPostcode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance08));
        assertTrue(instance.equals(instance09));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(address));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("AddressEntity{address=114, main address1, additi1, gwynedd, bangor, LL57 4LN, UK}", instance.toString());

    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {
        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(address));
        
        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(instance04));
        assertFalse(instance.hasSameConstraint(instance05));
        assertFalse(instance.hasSameConstraint(instance06));
        assertFalse(instance.hasSameConstraint(instance07));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance08));
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance.hasSameParameters(address));        

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(null));
    }
}
