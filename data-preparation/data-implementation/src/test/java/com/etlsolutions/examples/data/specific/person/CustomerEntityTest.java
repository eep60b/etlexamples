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
package com.etlsolutions.examples.data.specific.person;

import com.etlsolutions.examples.data.api.Customer;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.data.specific.communication.PersonAddressLinkEntity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class CustomerEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({CustomerEntity.class, PersonAddressLinkEntity.class})
public final class CustomerEntityTest {

    private final PersonAddressLinkEntity personAddressLinkEntity = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLinkEntity personAddressLinkEntity1 = PowerMockito.mock(PersonAddressLinkEntity.class);
    private final PersonAddressLink personAddressLink = Mockito.mock(PersonAddressLink.class);
    private final ImageBytes customerImaBytes = new ImageBytes(new byte[]{2, 2, 66, 9});
    private final ImageBytes customerImaBytes2 = new ImageBytes(new byte[]{83, 52, 31, 8});
    private final PersonalPassword password = new PersonalPassword("ld*(*&aloqoeqor");
    private final PersonalPassword password3 = new PersonalPassword("*Y*(*GKI890yj");
    private final PersonalUsername username = new PersonalUsername("alalkallq");
    private final PersonalUsername username4 = new PersonalUsername("lkajfGaiec");
    private final Customer customer = Mockito.mock(Customer.class);

    private final CustomerEntity instance = new CustomerEntity(personAddressLinkEntity, customerImaBytes, password, username);
    private final CustomerEntity instance00 = new CustomerEntity(personAddressLinkEntity, customerImaBytes, password, username);
    private final CustomerEntity instance01 = new CustomerEntity(personAddressLinkEntity1, customerImaBytes, password, username);
    private final CustomerEntity instance02 = new CustomerEntity(personAddressLinkEntity, customerImaBytes2, password, username);
    private final CustomerEntity instance03 = new CustomerEntity(personAddressLinkEntity, customerImaBytes, password3, username);
    private final CustomerEntity instance04 = new CustomerEntity(personAddressLinkEntity, customerImaBytes, password, username4);
    private CustomerEntity instance05;
    private CustomerEntity instance06;
    
    @Before
    public void setUp() throws Exception {

        PowerMockito.whenNew(PersonAddressLinkEntity.class).withArguments(personAddressLink).thenReturn(personAddressLinkEntity);
        
        Mockito.when(customer.getImage()).thenReturn(new byte[]{2, 2, 66, 9});
        Mockito.when(customer.getPassword()).thenReturn("ld*(*&aloqoeqor");
        Mockito.when(customer.getPersonAddressLink()).thenReturn(personAddressLinkEntity);
        Mockito.when(customer.getUsername()).thenReturn("*Y*(*GKI890yj");
        
        instance05 = new CustomerEntity(personAddressLink, customerImaBytes, password, username);
        instance06 = new CustomerEntity(customer);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_PersonAddressLink() {
        new CustomerEntity(null, customerImaBytes, password, username);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_CustomerImaBytes() {
        new CustomerEntity(personAddressLinkEntity, null, password, username);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_Password() {
        new CustomerEntity(personAddressLinkEntity, customerImaBytes, null, username);
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_Username() {
        new CustomerEntity(personAddressLinkEntity, customerImaBytes, password, null);
    }

    /**
     * Test of getPersonAddressLink method.
     */
    @Test
    public void testGetPersonAddressLink() {

        assertEquals(personAddressLinkEntity, instance.getPersonAddressLink());
        assertEquals(personAddressLinkEntity, instance06.getPersonAddressLink());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        assertArrayEquals(new byte[]{2, 2, 66, 9}, instance.getImage());
        assertArrayEquals(new byte[]{2, 2, 66, 9}, instance06.getImage());
    }

    /**
     * Test of getPassword method.
     */
    @Test
    public void testGetPassword() {

        assertEquals("ld*(*&aloqoeqor", instance.getPassword());
        assertEquals("ld*(*&aloqoeqor", instance06.getPassword());
    }

    /**
     * Test of getUsername method,.
     */
    @Test
    public void testGetUsername() {

        assertEquals("alalkallq", instance.getUsername());
        assertEquals("alalkallq", instance06.getUsername());
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
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance06));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance06));
        assertFalse(instance.hasSameConstraint(customer));

        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(customer));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

}
