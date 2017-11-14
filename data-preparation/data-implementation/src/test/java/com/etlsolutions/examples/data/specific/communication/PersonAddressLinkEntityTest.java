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
import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import com.etlsolutions.examples.data.specific.person.FamilyName;
import com.etlsolutions.examples.data.specific.person.GivenName;
import com.etlsolutions.examples.data.specific.person.PersonalDetailEntity;
import com.etlsolutions.examples.data.specific.person.PersonalProfile;
import com.etlsolutions.examples.data.specific.person.PersonalTitle;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class PersonAddressLinkEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({PersonAddressLinkEntity.class, AddressEntity.class, PersonalDetailEntity.class, DateOfBirth.class})
public final class PersonAddressLinkEntityTest {

    private final AddressEntity addressEntity = PowerMockito.mock(AddressEntity.class);
    private final AddressEntity addressEntity1 = PowerMockito.mock(AddressEntity.class);
    private final PersonalDetailEntity personalDetailEntity = PowerMockito.mock(PersonalDetailEntity.class);
    private final PersonalDetailEntity personalDetailEntity2 = PowerMockito.mock(PersonalDetailEntity.class);
    private final PersonAddressLink personAddressLink = Mockito.mock(PersonAddressLink.class);
    private final Address address = Mockito.mock(Address.class);
    private final PersonalDetail personalDetail = Mockito.mock(PersonalDetail.class);

    private final PersonAddressLinkEntity instance = new PersonAddressLinkEntity(addressEntity, personalDetailEntity, AddressType.CONTACT);
    private final PersonAddressLinkEntity instance0 = new PersonAddressLinkEntity(addressEntity, personalDetailEntity, AddressType.CONTACT);
    private final PersonAddressLinkEntity instance1 = new PersonAddressLinkEntity(addressEntity1, personalDetailEntity, AddressType.CONTACT);
    private final PersonAddressLinkEntity instance2 = new PersonAddressLinkEntity(addressEntity, personalDetailEntity2, AddressType.CONTACT);
    private final PersonAddressLinkEntity instance3 = new PersonAddressLinkEntity(addressEntity, personalDetailEntity, AddressType.DELIVERY);
    private final PersonAddressLinkEntity instance4 = new PersonAddressLinkEntity(instance);
    private PersonAddressLinkEntity instance5;
    private PersonAddressLinkEntity instance6;
    private PersonAddressLinkEntity instance7;

    @Before
    public void setUp() throws Exception {
        
        Date date = PowerMockito.mock(Date.class);
        
        DateOfBirth dateOfBirthColumn = PowerMockito.mock(DateOfBirth.class);
        FamilyName familyNameColumn = new FamilyName("ffammmy");
        GivenName givenNameColumn = new GivenName("gTome");
        PersonalTitle personalTitle = new PersonalTitle("MRA");
        PersonalProfile personalProfile = new PersonalProfile(new byte[]{96, 86});
        
        Mockito.when(personalDetail.getDateOfBirth()).thenReturn(date);
        Mockito.when(personalDetail.getFamilyName()).thenReturn("ffammmy");
        Mockito.when(personalDetail.getGivenName()).thenReturn("gTome");
        Mockito.when(personalDetail.getProfile()).thenReturn(new byte[]{96, 86});
        Mockito.when(personalDetail.getTitle()).thenReturn("MRA");
        
        PowerMockito.whenNew(DateOfBirth.class).withArguments(date).thenReturn(dateOfBirthColumn);
        
        Mockito.when(personAddressLink.getPersonalDetail()).thenReturn(personalDetailEntity);
        Mockito.when(personAddressLink.getAddress()).thenReturn(addressEntity);
        Mockito.when(personAddressLink.getAddressType()).thenReturn(AddressType.CONTACT);
        
        PowerMockito.whenNew(AddressEntity.class).withArguments(address).thenReturn(addressEntity);
        PowerMockito.whenNew(PersonalDetailEntity.class).withArguments(personalDetail).thenReturn(personalDetailEntity);
        
        instance5 = new PersonAddressLinkEntity(personAddressLink);
        instance6 = new PersonAddressLinkEntity(address, personalDetailEntity, AddressType.CONTACT);
        instance7 = new PersonAddressLinkEntity(addressEntity, personalDetail, AddressType.CONTACT);
    }

    /**
     * Test of getAddress method.
     */
    @Test
    public void testGetAddress() {

        assertEquals(addressEntity, instance.getAddress());
        assertEquals(addressEntity, instance4.getAddress());
        assertEquals(addressEntity, instance5.getAddress());
        assertEquals(addressEntity, instance6.getAddress());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailEntity, instance.getPersonalDetail());
        assertEquals(personalDetailEntity, instance4.getPersonalDetail());
        assertEquals(personalDetailEntity, instance5.getPersonalDetail());
        assertEquals(personalDetailEntity, instance7.getPersonalDetail());
    }

    /**
     * Test of getAddressType method.
     */
    @Test
    public void testGetAddressType() {

        assertEquals(AddressType.CONTACT, instance.getAddressType());
        assertEquals(AddressType.CONTACT, instance4.getAddressType());
        assertEquals(AddressType.CONTACT, instance5.getAddressType());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance0.hashCode(), instance.hashCode());
        assertEquals(instance4.hashCode(), instance.hashCode());
        assertEquals(instance5.hashCode(), instance.hashCode());
        assertEquals(instance6.hashCode(), instance.hashCode());
        assertEquals(instance7.hashCode(), instance.hashCode());

        assertNotEquals(instance1.hashCode(), instance.hashCode());
        assertNotEquals(instance2.hashCode(), instance.hashCode());
        assertNotEquals(instance3.hashCode(), instance.hashCode());
    }

    /**
     * Test of hasSameConstraint method, of class PersonAddressLinkEntity.
     */
    @Test
    public void testHasSameConstraint() {

        Mockito.when(addressEntity.hasSameConstraint(address)).thenReturn(Boolean.TRUE);
        Mockito.when(addressEntity.hasSameConstraint(addressEntity)).thenReturn(Boolean.TRUE);
        Mockito.when(personalDetailEntity.hasSameConstraint(personalDetail)).thenReturn(Boolean.TRUE);
        Mockito.when(personalDetailEntity.hasSameConstraint(personalDetailEntity)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance0));
        assertTrue(instance.hasSameConstraint(instance4));
        assertTrue(instance.hasSameConstraint(instance5));
        assertTrue(instance.hasSameConstraint(instance6));
        assertTrue(instance.hasSameConstraint(instance7));
        assertTrue(instance.hasSameConstraint(personAddressLink));

        assertFalse(instance.hasSameConstraint(instance1));
        assertFalse(instance.hasSameConstraint(instance2));
        assertFalse(instance.hasSameConstraint(instance3));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method, of class PersonAddressLinkEntity.
     */
    @Test
    public void testHasSameParameters() {

        Mockito.when(addressEntity.hasSameParameters(address)).thenReturn(Boolean.TRUE);
        Mockito.when(addressEntity.hasSameParameters(addressEntity)).thenReturn(Boolean.TRUE);
        Mockito.when(personalDetailEntity.hasSameParameters(personalDetail)).thenReturn(Boolean.TRUE);
        Mockito.when(personalDetailEntity.hasSameParameters(personalDetailEntity)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance0));
        assertTrue(instance.hasSameParameters(instance4));
        assertTrue(instance.hasSameParameters(instance5));
        assertTrue(instance.hasSameParameters(instance6));
        assertTrue(instance.hasSameParameters(instance7));
        assertTrue(instance.hasSameParameters(personAddressLink));

        assertFalse(instance.hasSameParameters(instance1));
        assertFalse(instance.hasSameParameters(instance2));
        assertFalse(instance.hasSameParameters(instance3));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance0));
        assertTrue(instance.equals(instance4));
        assertTrue(instance.equals(instance5));
        assertTrue(instance.equals(instance6));
        assertTrue(instance.equals(instance7));

        assertFalse(instance.equals(instance1));
        assertFalse(instance.equals(instance2));
        assertFalse(instance.equals(instance3));
        assertFalse(instance.equals(personAddressLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals( "PersonAddressLinkEntity{address=addressEntity, person=personalDetailEntity, addressType=CONTACT}", instance.toString());
    }
}
