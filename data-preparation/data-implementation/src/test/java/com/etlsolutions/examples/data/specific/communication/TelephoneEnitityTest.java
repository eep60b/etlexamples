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

import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.data.api.TelephoneType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class TelephoneEnitity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class TelephoneEnitityTest {

    private final CountryCode countryCode = new CountryCode("86");
    private final CountryCode countryCode1 = new CountryCode("98");
    private final AreaCode areaCode = new AreaCode("10");
    private final AreaCode areaCode2 = new AreaCode("47");
    private final TelephoneNumber telephoneNumber = new TelephoneNumber("3574684");
    private final TelephoneNumber telephoneNumber3 = new TelephoneNumber("8263721");
    private final TelephoneType telephoneType = TelephoneType.OFFICE;
    private final TelephoneType telephoneType4 = TelephoneType.HOME;

    private final Telephone telephone = Mockito.mock(Telephone.class);

    private final TelephoneEnitity instance = new TelephoneEnitity(countryCode, areaCode, telephoneNumber, telephoneType);
    private final TelephoneEnitity instance00 = new TelephoneEnitity(countryCode, areaCode, telephoneNumber, telephoneType);
    private final TelephoneEnitity instance01 = new TelephoneEnitity(countryCode1, areaCode, telephoneNumber, telephoneType);
    private final TelephoneEnitity instance02 = new TelephoneEnitity(countryCode, areaCode2, telephoneNumber, telephoneType);
    private final TelephoneEnitity instance03 = new TelephoneEnitity(countryCode, areaCode, telephoneNumber3, telephoneType);
    private final TelephoneEnitity instance04 = new TelephoneEnitity(countryCode, areaCode, telephoneNumber, telephoneType4);
    private TelephoneEnitity instance05;

    @Before
    public void setUp() {

        Mockito.when(telephone.getCountryCode()).thenReturn("86");
        Mockito.when(telephone.getAreaCode()).thenReturn("10");
        Mockito.when(telephone.getTelephoneNumber()).thenReturn("3574684");
        Mockito.when(telephone.getTelephoneType()).thenReturn(TelephoneType.OFFICE);

        instance05 = new TelephoneEnitity(telephone);
    }

    /**
     * Test of getCountryCode method.
     */
    @Test
    public void testGetCountryCode() {

        assertEquals("86", instance.getCountryCode());
        assertEquals("86", instance05.getCountryCode());
    }

    /**
     * Test of getAreaCode method.
     */
    @Test
    public void testGetAreaCode() {

        assertEquals("10", instance.getAreaCode());
        assertEquals("10", instance05.getAreaCode());
    }

    /**
     * Test of getTelephoneNumber method.
     */
    @Test
    public void testGetTelephoneNumber() {

        assertEquals("3574684", instance.getTelephoneNumber());
        assertEquals("3574684", instance05.getTelephoneNumber());
    }

    /**
     * Test of getTelephoneType method.
     */
    @Test
    public void testGetTelephoneType() {

        assertEquals(TelephoneType.OFFICE, instance.getTelephoneType());
        assertEquals(TelephoneType.OFFICE, instance05.getTelephoneType());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance05));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(telephone));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("TelephoneEnitity{country code=86, area code=10, telephone number=3574684, type=OFFICE}", instance.toString());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(telephone));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(instance04));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(telephone));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }
}
