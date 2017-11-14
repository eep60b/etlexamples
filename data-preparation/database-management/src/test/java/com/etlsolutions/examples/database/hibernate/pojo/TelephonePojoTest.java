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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class TelephonePojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class TelephonePojoTest {

    private final int id = 235;
    private final int id1 = 75435;
    private final String countryCode = "86";
    private final String countryCode2 = "43";
    private final String areaCode = "10";
    private final String areaCode3 = "12";
    private final TelephoneType telephoneType = TelephoneType.MOBILE;
    private final TelephoneType telephoneType4 = TelephoneType.HOME;
    private final String telephoneNumber = "208869";
    private final String telephoneNumber5 = "317189";

    private final PersonalDetailPojo personalDetailPojo1 = Mockito.mock(PersonalDetailPojo.class);
    private final PersonalDetailPojo personalDetailPojo2 = Mockito.mock(PersonalDetailPojo.class);
    private final PersonalDetailPojo personalDetailPojo3 = Mockito.mock(PersonalDetailPojo.class);
    private final PersonalDetailPojo personalDetailPojo4 = Mockito.mock(PersonalDetailPojo.class);
    private final Set<PersonalDetailPojo> personalDetails = new HashSet<>(Arrays.asList(personalDetailPojo1, personalDetailPojo2, personalDetailPojo3));
    private final Set<PersonalDetailPojo> personalDetails6 = new HashSet<>(Arrays.asList(personalDetailPojo2, personalDetailPojo4));
    private final Set<PersonalDetailPojo> personalDetails7 = null;

    private final Telephone telephone = Mockito.mock(Telephone.class);

    private final TelephonePojo instance = new TelephonePojo(id, countryCode, areaCode, telephoneType, telephoneNumber, personalDetails);
    private final TelephonePojo instance00 = new TelephonePojo(id, countryCode, areaCode, telephoneType, telephoneNumber, personalDetails);
    private final TelephonePojo instance01 = new TelephonePojo(id1, countryCode, areaCode, telephoneType, telephoneNumber, personalDetails);
    private final TelephonePojo instance02 = new TelephonePojo(id, countryCode2, areaCode, telephoneType, telephoneNumber, personalDetails);
    private final TelephonePojo instance03 = new TelephonePojo(id, countryCode, areaCode3, telephoneType, telephoneNumber, personalDetails);
    private final TelephonePojo instance04 = new TelephonePojo(id, countryCode, areaCode, telephoneType4, telephoneNumber, personalDetails);
    private final TelephonePojo instance05 = new TelephonePojo(id, countryCode, areaCode, telephoneType, telephoneNumber5, personalDetails);
    private final TelephonePojo instance06 = new TelephonePojo(id, countryCode, areaCode, telephoneType, telephoneNumber, personalDetails6);
    private final TelephonePojo instance07 = new TelephonePojo(id, countryCode, areaCode, telephoneType, telephoneNumber, personalDetails7);
    private final TelephonePojo instance08 = new TelephonePojo();
    private final TelephonePojo instance09 = new TelephonePojo(countryCode, areaCode, telephoneType, telephoneNumber);
    private final TelephonePojo instance10 = new TelephonePojo(id, countryCode, areaCode, telephoneType, telephoneNumber);
    private final TelephonePojo instance11 = new HibernateProxyTelephonePojo(instance);
    private TelephonePojo instance12;

    @Before
    public void setUp() {

        Mockito.when(telephone.getCountryCode()).thenReturn("86");
        Mockito.when(telephone.getTelephoneNumber()).thenReturn("208869");
        Mockito.when(telephone.getTelephoneType()).thenReturn(TelephoneType.MOBILE);
        Mockito.when(telephone.getAreaCode()).thenReturn("10");
        instance12 = new TelephonePojo(telephone);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(235, instance.getId());
        assertEquals(0, instance08.getId());
        assertEquals(0, instance09.getId());
        assertEquals(235, instance10.getId());
        assertEquals(0, instance11.getId());
        assertEquals(0, instance12.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(948);
        assertEquals(948, instance.getId());
    }

    /**
     * Test of getCountryCode method.
     */
    @Test
    public void testGetCountryCode() {

        assertEquals("86", instance.getCountryCode());
        assertNull(instance08.getCountryCode());
        assertEquals("86", instance09.getCountryCode());
        assertEquals("86", instance10.getCountryCode());
        assertNull(instance11.getCountryCode());
        assertEquals("86", instance12.getCountryCode());
    }

    /**
     * Test of setCountryCode method.
     */
    @Test
    public void testSetCountryCode() {

        instance.setCountryCode("44");
        assertEquals("44", instance.getCountryCode());
    }

    /**
     * Test of getAreaCode method.
     */
    @Test
    public void testGetAreaCode() {

        assertEquals("10", instance.getAreaCode());
        assertNull(instance08.getAreaCode());
        assertEquals("10", instance09.getAreaCode());
        assertEquals("10", instance10.getAreaCode());
        assertNull(instance11.getAreaCode());
        assertEquals("10", instance12.getAreaCode());
    }

    /**
     * Test of setAreaCode method.
     */
    @Test
    public void testSetAreaCode() {

        instance.setAreaCode("48");
        assertEquals("48", instance.getAreaCode());
    }

    /**
     * Test of getTelephoneType method.
     */
    @Test
    public void testGetTelephoneType() {
        assertEquals(TelephoneType.MOBILE, instance.getTelephoneType());
        assertNull(instance08.getTelephoneType());
        assertEquals(TelephoneType.MOBILE, instance09.getTelephoneType());
        assertEquals(TelephoneType.MOBILE, instance10.getTelephoneType());
        assertNull(instance11.getTelephoneType());
        assertEquals(TelephoneType.MOBILE, instance12.getTelephoneType());
    }

    /**
     * Test of setTelephoneType method.
     */
    @Test
    public void testSetTelephoneType() {

        instance.setTelephoneType(TelephoneType.HOME);
        assertEquals(TelephoneType.HOME, instance.getTelephoneType());
    }

    /**
     * Test of getTelephoneNumber method.
     */
    @Test
    public void testGetTelephoneNumber() {

        assertEquals("208869", instance.getTelephoneNumber());
        assertNull(instance08.getTelephoneNumber());
        assertEquals("208869", instance09.getTelephoneNumber());
        assertEquals("208869", instance10.getTelephoneNumber());
        assertNull(instance11.getTelephoneNumber());
        assertEquals("208869", instance12.getTelephoneNumber());
    }

    /**
     * Test of setTelephoneNumber method.
     */
    @Test
    public void testSetTelephoneNumber() {

        instance.setTelephoneNumber("teaaearaaer");
        assertEquals("teaaearaaer", instance.getTelephoneNumber());
    }

    /**
     * Test of getPersonalDetails method.
     */
    @Test
    public void testGetPersonalDetails() {

        assertEquals(new HashSet<>(Arrays.asList(personalDetailPojo1, personalDetailPojo2, personalDetailPojo3)), instance.getPersonalDetails());
        instance.getPersonalDetails().add(personalDetailPojo4);
        assertEquals(new HashSet<>(Arrays.asList(personalDetailPojo1, personalDetailPojo2, personalDetailPojo3)), instance.getPersonalDetails());
        personalDetails.add(personalDetailPojo4);
        assertEquals(new HashSet<>(Arrays.asList(personalDetailPojo1, personalDetailPojo2, personalDetailPojo3)), instance.getPersonalDetails());

        assertNull(instance07.getPersonalDetails());
        assertTrue(instance08.getPersonalDetails().isEmpty());
        assertTrue(instance09.getPersonalDetails().isEmpty());
        assertTrue(instance10.getPersonalDetails().isEmpty());
        assertTrue(instance11.getPersonalDetails().isEmpty());
        assertTrue(instance12.getPersonalDetails().isEmpty());
    }

    /**
     * Test of setPersonalDetails method.
     */
    @Test
    public void testSetPersonalDetails() {

        Set<PersonalDetailPojo> personalDetailsK = new HashSet<>(Arrays.asList(personalDetailPojo3, personalDetailPojo4));
        instance.setPersonalDetails(personalDetailsK);
        assertEquals(new HashSet<>(Arrays.asList(personalDetailPojo3, personalDetailPojo4)), instance.getPersonalDetails());
        personalDetailsK.clear();
        assertEquals(new HashSet<>(Arrays.asList(personalDetailPojo3, personalDetailPojo4)), instance.getPersonalDetails());

        instance.setPersonalDetails(null);
        assertNull(instance.getPersonalDetails());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance11.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance.hasSameConstraint(telephone));

        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(instance04));
        assertFalse(instance.hasSameConstraint(instance05));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {
        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance11.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance11));
        assertTrue(instance.hasSameParameters(telephone));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance11.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance06));
        assertTrue(instance.equals(instance11));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(telephone));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("TelephonePojo{country code=86, area code=10, type=MOBILE, telephone number=208869}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyTelephonePojo extends TelephonePojo implements HibernateProxy {

        private static final long serialVersionUID = 306689179941244081L;

        private final TelephonePojo pojo;

        public HibernateProxyTelephonePojo(TelephonePojo pojo) {

            this.pojo = pojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {

                @Override
                public TelephonePojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
