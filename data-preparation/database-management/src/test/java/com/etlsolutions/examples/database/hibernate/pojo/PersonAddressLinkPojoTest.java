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

import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class PersonAddressLinkPojo.
 *
 * @author Zhipeng Chang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AddressPojo.class)
public final class PersonAddressLinkPojoTest {

    private final int id = 2101;
    private final int id1 = 913481;
    private final AddressPojo address = PowerMockito.mock(AddressPojo.class);
    private final AddressPojo address2 = PowerMockito.mock(AddressPojo.class);
    private final AddressPojo address4 = PowerMockito.mock(AddressPojo.class);
    private final PersonalDetailPojo personalDetail = Mockito.mock(PersonalDetailPojo.class);
    private final PersonalDetailPojo personalDetail3 = Mockito.mock(PersonalDetailPojo.class);
    private final PersonalDetailPojo personalDetail4 = Mockito.mock(PersonalDetailPojo.class);

    private final DebitcardPaymentPojo debitcardPaymentPojo1 = Mockito.mock(DebitcardPaymentPojo.class);
    private final DebitcardPaymentPojo debitcardPaymentPojo2 = Mockito.mock(DebitcardPaymentPojo.class);
    private final DebitcardPaymentPojo debitcardPaymentPojo3 = Mockito.mock(DebitcardPaymentPojo.class);
    private final DebitcardPaymentPojo debitcardPaymentPojo4 = Mockito.mock(DebitcardPaymentPojo.class);
    private final Set<DebitcardPaymentPojo> debitcardPayments = new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3));
    private final Set<DebitcardPaymentPojo> debitcardPayments5 = new HashSet<>(Arrays.asList(debitcardPaymentPojo2, debitcardPaymentPojo4));
    private final Set<DebitcardPaymentPojo> debitcardPayments6 = null;

    private final VisacardPaymentPojo visacardPaymentPojo1 = Mockito.mock(VisacardPaymentPojo.class);
    private final VisacardPaymentPojo visacardPaymentPojo2 = Mockito.mock(VisacardPaymentPojo.class);
    private final VisacardPaymentPojo visacardPaymentPojo3 = Mockito.mock(VisacardPaymentPojo.class);
    private final VisacardPaymentPojo visacardPaymentPojo4 = Mockito.mock(VisacardPaymentPojo.class);
    private final Set<VisacardPaymentPojo> visacardPayments = new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3));
    private final Set<VisacardPaymentPojo> visacardPayments7 = new HashSet<>(Arrays.asList(visacardPaymentPojo2, visacardPaymentPojo4));
    private final Set<VisacardPaymentPojo> visacardPayments8 = null;

    private final MastercardPaymentPojo mastercardPaymentPojo1 = Mockito.mock(MastercardPaymentPojo.class);
    private final MastercardPaymentPojo mastercardPaymentPojo2 = Mockito.mock(MastercardPaymentPojo.class);
    private final MastercardPaymentPojo mastercardPaymentPojo3 = Mockito.mock(MastercardPaymentPojo.class);
    private final MastercardPaymentPojo mastercardPaymentPojo4 = Mockito.mock(MastercardPaymentPojo.class);
    private final Set<MastercardPaymentPojo> mastercardPayments = new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3));
    private final Set<MastercardPaymentPojo> mastercardPayments9 = new HashSet<>(Arrays.asList(mastercardPaymentPojo2, mastercardPaymentPojo4));
    private final Set<MastercardPaymentPojo> mastercardPayments10 = null;

    private final AmexcardPaymentPojo amexcardPaymentPojo1 = Mockito.mock(AmexcardPaymentPojo.class);
    private final AmexcardPaymentPojo amexcardPaymentPojo2 = Mockito.mock(AmexcardPaymentPojo.class);
    private final AmexcardPaymentPojo amexcardPaymentPojo3 = Mockito.mock(AmexcardPaymentPojo.class);
    private final AmexcardPaymentPojo amexcardPaymentPojo4 = Mockito.mock(AmexcardPaymentPojo.class);
    private final Set<AmexcardPaymentPojo> amexcardPayments = new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3));
    private final Set<AmexcardPaymentPojo> amexcardPayments11 = new HashSet<>(Arrays.asList(amexcardPaymentPojo2, amexcardPaymentPojo4));
    private final Set<AmexcardPaymentPojo> amexcardPayments12 = null;

    private final CustomerPojo customerPojo1 = Mockito.mock(CustomerPojo.class);
    private final CustomerPojo customerPojo2 = Mockito.mock(CustomerPojo.class);
    private final CustomerPojo customerPojo3 = Mockito.mock(CustomerPojo.class);
    private final CustomerPojo customerPojo4 = Mockito.mock(CustomerPojo.class);
    private final Set<CustomerPojo> customers = new HashSet<>(Arrays.asList(customerPojo1, customerPojo2, customerPojo3));
    private final Set<CustomerPojo> customers13 = new HashSet<>(Arrays.asList(customerPojo2, customerPojo4));
    private final Set<CustomerPojo> customers14 = null;

    private final PersonAddressLink personAddressLink = Mockito.mock(PersonAddressLink.class);

    private final PersonAddressLinkPojo instance = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance00 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance01 = new PersonAddressLinkPojo(id1, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance02 = new PersonAddressLinkPojo(id, address2, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance03 = new PersonAddressLinkPojo(id, address, personalDetail3, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance04 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.DELIVERY, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance05 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments5, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance06 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments6, visacardPayments, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance07 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments7, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance08 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments8, mastercardPayments, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance09 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments9, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance10 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments10, amexcardPayments, customers);
    private final PersonAddressLinkPojo instance11 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments11, customers);
    private final PersonAddressLinkPojo instance12 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments12, customers);
    private final PersonAddressLinkPojo instance13 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers13);
    private final PersonAddressLinkPojo instance14 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers14);
    private final PersonAddressLinkPojo instance15 = new PersonAddressLinkPojo();
    private final PersonAddressLinkPojo instance16 = new PersonAddressLinkPojo(id);
    private final PersonAddressLinkPojo instance17 = new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT);
    private final PersonAddressLinkPojo instance18 = new HibernateProxyPersonAddressLinkPojo(new PersonAddressLinkPojo(id, address, personalDetail, AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers));
    private final PersonAddressLinkPojo instance19 = new PersonAddressLinkPojo(id, new AddressPojo(), new PersonalDetailPojo(), AddressType.CONTACT, debitcardPayments, visacardPayments, mastercardPayments, amexcardPayments, customers);

    @Before
    public void setUp() {
        Mockito.when(personAddressLink.getAddress()).thenReturn(address);
        Mockito.when(personAddressLink.getAddressType()).thenReturn(AddressType.CONTACT);
        Mockito.when(personAddressLink.getPersonalDetail()).thenReturn(personalDetail);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(2101, instance.getId());
        assertEquals(0, instance15.getId());
        assertEquals(2101, instance16.getId());
        assertEquals(2101, instance17.getId());
        assertEquals(0, instance18.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(2234);
        assertEquals(2234, instance.getId());
    }

    /**
     * Test of getAddress method.
     */
    @Test
    public void testGetAddress() {

        assertEquals(address, instance.getAddress());
        assertNull(instance15.getAddress());
        assertNull(instance16.getAddress());
        assertEquals(address, instance17.getAddress());
        assertNull(instance18.getAddress());
    }

    /**
     * Test of setAddress method.
     */
    @Test
    public void testSetAddress() {

        instance.setAddress(address4);
        assertEquals(address4, instance.getAddress());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetail, instance.getPersonalDetail());
        assertNull(instance15.getPersonalDetail());
        assertNull(instance16.getPersonalDetail());
        assertEquals(personalDetail, instance17.getPersonalDetail());
        assertNull(instance18.getPersonalDetail());
    }

    /**
     * Test of setPersonalDetail method.
     */
    @Test
    public void testSetPersonalDetail() {

        instance.setPersonalDetail(personalDetail4);
        assertEquals(personalDetail4, instance.getPersonalDetail());
    }

    /**
     * Test of getAddressType method.
     */
    @Test
    public void testGetAddressType() {

        assertEquals(AddressType.CONTACT, instance.getAddressType());
        assertNull(instance15.getAddressType());
        assertNull(instance16.getAddressType());
        assertEquals(AddressType.CONTACT, instance17.getAddressType());
        assertNull(instance18.getAddressType());
    }

    /**
     * Test of setAddressType method.
     */
    @Test
    public void testSetAddressType() {

        instance.setAddressType(AddressType.DELIVERY);
        assertEquals(AddressType.DELIVERY, instance.getAddressType());
    }

    /**
     * Test of getDebitcardPayments method.
     */
    @Test
    public void testGetDebitcardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());
        instance.getDebitcardPayments().clear();
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());
        debitcardPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo1, debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());

        assertNull(instance06.getDebitcardPayments());
        assertTrue(instance15.getDebitcardPayments().isEmpty());
        assertTrue(instance16.getDebitcardPayments().isEmpty());
        assertTrue(instance17.getDebitcardPayments().isEmpty());
        assertTrue(instance18.getDebitcardPayments().isEmpty());
    }

    /**
     * Test of setDebitcardPayments method.
     */
    @Test
    public void testSetDebitcardPayments() {

        Set<DebitcardPaymentPojo> debitcardPaymentPojosG = new HashSet<>(Arrays.asList(debitcardPaymentPojo2, debitcardPaymentPojo3));

        instance.setDebitcardPayments(debitcardPaymentPojosG);
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());
        debitcardPaymentPojosG.clear();
        assertEquals(new HashSet<>(Arrays.asList(debitcardPaymentPojo2, debitcardPaymentPojo3)), instance.getDebitcardPayments());

        instance.setDebitcardPayments(null);
        assertNull(instance.getDebitcardPayments());
    }

    /**
     * Test of getVisacardPayments method.
     */
    @Test
    public void testGetVisacardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());
        instance.getVisacardPayments().clear();
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());
        visacardPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo2, visacardPaymentPojo3)), instance.getVisacardPayments());

        assertNull(instance08.getVisacardPayments());
        assertTrue(instance15.getVisacardPayments().isEmpty());
        assertTrue(instance16.getVisacardPayments().isEmpty());
        assertTrue(instance17.getVisacardPayments().isEmpty());
        assertTrue(instance18.getVisacardPayments().isEmpty());
    }

    /**
     * Test of setVisacardPayments method.
     */
    @Test
    public void testSetVisacardPayments() {

        Set<VisacardPaymentPojo> visacardPaymentsN = new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo3));
        instance.setVisacardPayments(visacardPaymentsN);
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo3)), instance.getVisacardPayments());
        visacardPaymentsN.clear();
        assertEquals(new HashSet<>(Arrays.asList(visacardPaymentPojo1, visacardPaymentPojo3)), instance.getVisacardPayments());

        instance.setVisacardPayments(null);
        assertNull(instance.getVisacardPayments());
    }

    /**
     * Test of getMastercardPayments method.
     */
    @Test
    public void testGetMastercardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());
        instance.getMastercardPayments().clear();
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());
        mastercardPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo1, mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());

        assertNull(instance10.getMastercardPayments());
        assertTrue(instance15.getMastercardPayments().isEmpty());
        assertTrue(instance16.getMastercardPayments().isEmpty());
        assertTrue(instance17.getMastercardPayments().isEmpty());
        assertTrue(instance18.getMastercardPayments().isEmpty());
    }

    /**
     * Test of setMastercardPayments method.
     */
    @Test
    public void testSetMastercardPayments() {

        Set<MastercardPaymentPojo> mastercardPaymentsB = new HashSet<>(Arrays.asList(mastercardPaymentPojo2, mastercardPaymentPojo3));

        instance.setMastercardPayments(mastercardPaymentsB);
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());
        mastercardPaymentsB.clear();
        assertEquals(new HashSet<>(Arrays.asList(mastercardPaymentPojo2, mastercardPaymentPojo3)), instance.getMastercardPayments());

        instance.setMastercardPayments(null);
        assertNull(instance.getMastercardPayments());
    }

    /**
     * Test of getAmexcardPayments method.
     */
    @Test
    public void testGetAmexcardPayments() {

        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3)), instance.getAmexcardPayments());
        instance.getAmexcardPayments().clear();
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3)), instance.getAmexcardPayments());
        amexcardPayments.clear();
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2, amexcardPaymentPojo3)), instance.getAmexcardPayments());

        assertNull(instance12.getAmexcardPayments());
        assertTrue(instance15.getAmexcardPayments().isEmpty());
        assertTrue(instance16.getAmexcardPayments().isEmpty());
        assertTrue(instance17.getAmexcardPayments().isEmpty());
        assertTrue(instance18.getAmexcardPayments().isEmpty());
    }

    /**
     * Test of setAmexcardPayments method.
     */
    @Test
    public void testSetAmexcardPayments() {
        Set<AmexcardPaymentPojo> amexcardPaymentsC = new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2));

        instance.setAmexcardPayments(amexcardPaymentsC);
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2)), instance.getAmexcardPayments());
        amexcardPaymentsC.clear();
        assertEquals(new HashSet<>(Arrays.asList(amexcardPaymentPojo1, amexcardPaymentPojo2)), instance.getAmexcardPayments());

        instance.setAmexcardPayments(null);
        assertNull(instance.getAmexcardPayments());
    }

    /**
     * Test of getCustomers method.
     */
    @Test
    public void testGetCustomers() {

        assertEquals(new HashSet<>(Arrays.asList(customerPojo1, customerPojo2, customerPojo3)), instance.getCustomers());
        instance.getCustomers().clear();
        assertEquals(new HashSet<>(Arrays.asList(customerPojo1, customerPojo2, customerPojo3)), instance.getCustomers());
        customers.clear();
        assertEquals(new HashSet<>(Arrays.asList(customerPojo1, customerPojo2, customerPojo3)), instance.getCustomers());

        assertNull(instance14.getCustomers());
        assertTrue(instance15.getCustomers().isEmpty());
        assertTrue(instance16.getCustomers().isEmpty());
        assertTrue(instance17.getCustomers().isEmpty());
        assertTrue(instance18.getCustomers().isEmpty());
    }

    /**
     * Test of setCustomers method.
     */
    @Test
    public void testSetCustomers() {

        Set<CustomerPojo> customersS = new HashSet<>(Arrays.asList(customerPojo2, customerPojo3));
        instance.setCustomers(customersS);
        assertEquals(new HashSet<>(Arrays.asList(customerPojo2, customerPojo3)), instance.getCustomers());
        customersS.clear();
        assertEquals(new HashSet<>(Arrays.asList(customerPojo2, customerPojo3)), instance.getCustomers());

        instance.setCustomers(null);
        assertNull(instance.getCustomers());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());
        assertEquals(instance11.hashCode(), instance.hashCode());
        assertEquals(instance13.hashCode(), instance.hashCode());
        assertEquals(instance18.hashCode(), instance.hashCode());

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
        assertTrue(instance.equals(instance07));
        assertTrue(instance.equals(instance09));
        assertTrue(instance.equals(instance11));
        assertTrue(instance.equals(instance13));
        assertTrue(instance.equals(instance18));
        assertTrue(instance18.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(personAddressLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        Mockito.when(personalDetail.hasSameConstraint(personalDetail)).thenReturn(Boolean.TRUE);
        Mockito.when(address.hasSameConstraint(address)).thenReturn(Boolean.TRUE);

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance.hasSameConstraint(instance13));
        assertTrue(instance.hasSameConstraint(instance18));
        assertTrue(instance18.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(personAddressLink));

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
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(instance07));
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance.hasSameParameters(instance11));
        assertTrue(instance.hasSameParameters(instance13));
        assertTrue(instance.hasSameParameters(instance18));
        assertTrue(instance18.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(personAddressLink));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

    @Test
    public void testToString() {
        assertEquals("PersonAddressLinkPojo{address=" + address + ", personalDetail=" + personalDetail + ", addressType=CONTACT}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance19));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyPersonAddressLinkPojo extends PersonAddressLinkPojo implements HibernateProxy {

        private static final long serialVersionUID = 47692891737311045L;

        private final PersonAddressLinkPojo pojo;

        public HibernateProxyPersonAddressLinkPojo(PersonAddressLinkPojo pojo) {

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
                public PersonAddressLinkPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
