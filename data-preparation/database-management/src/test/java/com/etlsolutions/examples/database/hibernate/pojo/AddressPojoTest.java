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

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.InvoiceValidity;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 * Tests of class AddressPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
public final class AddressPojoTest {

    private final int id = 857;
    private final int id1 = 851;
    private final String house = "87 ho";
    private final String house2 = "99 ho";
    private final String street = "address main3";
    private final String street3 = "address mainX";
    private final String additional = "additional3";
    private final String additional4 = "additionalY";
    private final String city = "city3";
    private final String city5 = "city555";
    private final String area = "area3";
    private final String area6 = "area666";
    private final String postcode = "postcode3";
    private final String postcode7 = "postcode777";
    private final String country = "CT3";
    private final String country8 = "ZH";

    private final PersonAddressLinkPojo personAddressLinkPojo1 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLinkPojo2 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLinkPojo3 = Mockito.mock(PersonAddressLinkPojo.class);
    private final PersonAddressLinkPojo personAddressLinkPojo4 = Mockito.mock(PersonAddressLinkPojo.class);
    private final Set<PersonAddressLinkPojo> personAddressLinks = new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3));
    private final Set<PersonAddressLinkPojo> personAddressLinks9 = new HashSet<>(Arrays.asList(personAddressLinkPojo4));
    private final Set<PersonAddressLinkPojo> personAddressLinks10 = null;

    private final PublisherPojo publisherPojo1 = Mockito.mock(PublisherPojo.class);
    private final PublisherPojo publisherPojo2 = Mockito.mock(PublisherPojo.class);
    private final PublisherPojo publisherPojo3 = Mockito.mock(PublisherPojo.class);
    private final PublisherPojo publisherPojo4 = Mockito.mock(PublisherPojo.class);
    private final Set<PublisherPojo> publishers = new HashSet<>(Arrays.asList(publisherPojo1, publisherPojo2, publisherPojo3));
    private final Set<PublisherPojo> publishers11 = new HashSet<>(Arrays.asList(publisherPojo2, publisherPojo4));
    private final Set<PublisherPojo> publishers12 = null;

    private final InvoicePojo invoicePojo1 = Mockito.mock(InvoicePojo.class);
    private final InvoicePojo invoicePojo2 = Mockito.mock(InvoicePojo.class);
    private final InvoicePojo invoicePojo3 = Mockito.mock(InvoicePojo.class);
    private final InvoicePojo invoicePojo4 = Mockito.mock(InvoicePojo.class);
    private final Set<InvoicePojo> invoices = new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3));
    private final Set<InvoicePojo> invoices13 = new HashSet<>(Arrays.asList(invoicePojo2, invoicePojo4));
    private final Set<InvoicePojo> invoices14 = null;

    private final Address address = Mockito.mock(Address.class);

    private final AddressPojo instance = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance00 = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance01 = new AddressPojo(id1, house, street, additional, city, area, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance02 = new AddressPojo(id, house2, street, additional, city, area, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance03 = new AddressPojo(id, house, street3, additional, city, area, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance04 = new AddressPojo(id, house, street, additional4, city, area, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance05 = new AddressPojo(id, house, street, additional, city5, area, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance06 = new AddressPojo(id, house, street, additional, city, area6, postcode, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance07 = new AddressPojo(id, house, street, additional, city, area, postcode7, country, personAddressLinks, publishers, invoices);
    private final AddressPojo instance08 = new AddressPojo(id, house, street, additional, city, area, postcode, country8, personAddressLinks, publishers, invoices);
    private final AddressPojo instance09 = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks9, publishers, invoices);
    private final AddressPojo instance10 = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks10, publishers, invoices);
    private final AddressPojo instance11 = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks, publishers11, invoices);
    private final AddressPojo instance12 = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks, publishers12, invoices);
    private final AddressPojo instance13 = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks, publishers, invoices13);
    private final AddressPojo instance14 = new AddressPojo(id, house, street, additional, city, area, postcode, country, personAddressLinks, publishers, invoices14);
    private final AddressPojo instance15 = new AddressPojo();
    private final AddressPojo instance16 = new AddressPojo(1232, "2256", "address main2", "CT2");
    private final AddressPojo instance17 = new AddressPojo(5734, "Bing stay", "address main4", "additional4", "city4", "area4", "postcode4", "CT4");
    private final AddressPojo instance18 = new HibernateProxyAddressPojo(new AddressPojo(857, "87 ho", "address main3", "additional3", "city3", "area3", "postcode3", "CT3"));

    private AddressPojo instance19;

    @Before
    public void setUp() {

        Mockito.when(address.getHouse()).thenReturn("87 ho");
        Mockito.when(address.getStreet()).thenReturn("address main3");
        Mockito.when(address.getAdditional()).thenReturn("additional3");
        Mockito.when(address.getArea()).thenReturn("area3");
        Mockito.when(address.getCity()).thenReturn("city3");
        Mockito.when(address.getPostcode()).thenReturn("postcode3");
        Mockito.when(address.getCountry()).thenReturn("CT3");
        instance19 = new AddressPojo(address);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(857, instance.getId());
        assertEquals(0, instance15.getId());
        assertEquals(1232, instance16.getId());
        assertEquals(5734, instance17.getId());
        assertEquals(0, instance18.getId());
        assertEquals(0, instance19.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {
        instance.setId(5);
        assertEquals(5, instance.getId());
    }

    /**
     * Test of getHouse method.
     */
    @Test
    public void testGetHouse() {

        assertEquals("87 ho", instance.getHouse());
        assertNull(instance15.getHouse());
        assertEquals("2256", instance16.getHouse());
        assertEquals("Bing stay", instance17.getHouse());
        assertEquals("87 ho", instance19.getHouse());
    }

    /**
     * Test of setHouse method.
     */
    @Test
    public void testSetHouse() {

        instance.setHouse("new K house");
        assertEquals("new K house", instance.getHouse());
    }

    /**
     * Test of getStreet method.
     */
    @Test
    public void testGetStreet() {

        assertEquals("address main3", instance.getStreet());
        assertNull(instance15.getStreet());
        assertEquals("address main2", instance16.getStreet());
        assertEquals("address main4", instance17.getStreet());
        assertNull(instance18.getStreet());
        assertEquals("address main3", instance19.getStreet());
    }

    /**
     * Test of setStreet method.
     */
    @Test
    public void testSetStreet() {
        instance.setStreet("setAddressMain");
        assertEquals("setAddressMain", instance.getStreet());
    }

    /**
     * Test of getAdditional method.
     */
    @Test
    public void testGetAdditional() {

        assertEquals("additional3", instance.getAdditional());
        assertEquals("additional4", instance17.getAdditional());
        assertEquals("additional3", instance19.getAdditional());

        assertNull(instance15.getAdditional());
        assertNull(instance16.getAdditional());
        assertNull(instance18.getAdditional());
    }

    /**
     * Test of setAdditional method.
     */
    @Test
    public void testSetAdditional() {
        instance.setAdditional("setAdditional");
        assertEquals("setAdditional", instance.getAdditional());
    }

    /**
     * Test of getCity method.
     */
    @Test
    public void testGetCity() {

        assertEquals("city3", instance.getCity());
        assertEquals("city4", instance17.getCity());
        assertEquals("city3", instance19.getCity());

        assertNull(instance15.getCity());
        assertNull(instance16.getCity());
        assertNull(instance18.getCity());
    }

    /**
     * Test of setCity method.
     */
    @Test
    public void testSetCity() {
        instance.setCity("setCity");
        assertEquals("setCity", instance.getCity());
    }

    /**
     * Test of getArea method.
     */
    @Test
    public void testGetArea() {
        assertEquals("area3", instance.getArea());
        assertEquals("area4", instance17.getArea());
        assertEquals("area3", instance19.getArea());

        assertNull(instance15.getArea());
        assertNull(instance16.getArea());
        assertNull(instance18.getArea());
    }

    /**
     * Test of setArea method.
     */
    @Test
    public void testSetArea() {
        instance.setArea("setArea");
        assertEquals("setArea", instance.getArea());
    }

    /**
     * Test of getPostcode method.
     */
    @Test
    public void testGetPostcode() {
        assertEquals("postcode3", instance.getPostcode());
        assertEquals("postcode4", instance17.getPostcode());
        assertEquals("postcode3", instance19.getPostcode());

        assertNull(instance15.getPostcode());
        assertNull(instance16.getPostcode());
        assertNull(instance18.getPostcode());
    }

    /**
     * Test of setPostcode method.
     */
    @Test
    public void testSetPostcode() {
        instance.setPostcode("setPostcode");
        assertEquals("setPostcode", instance.getPostcode());
    }

    /**
     * Test of getCountry method.
     */
    @Test
    public void testGetCountry() {

        assertEquals("CT3", instance.getCountry());
        assertEquals("CT2", instance16.getCountry());
        assertEquals("CT4", instance17.getCountry());
        assertEquals("CT3", instance19.getCountry());

        assertNull(instance15.getCountry());
        assertNull(instance18.getCountry());
    }

    /**
     * Test of setCountry method.
     */
    @Test
    public void testSetCountry() {
        instance.setCountry("setCountry");
        assertEquals("setCountry", instance.getCountry());
    }

    /**
     * Test of getPersonAddressLinks method.
     */
    @Test
    public void testGetPersonAddressLinks() {

        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3)), instance.getPersonAddressLinks());
        instance.getPersonAddressLinks().clear();
        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3)), instance.getPersonAddressLinks());
        personAddressLinks.clear();
        assertEquals(new HashSet<>(Arrays.asList(personAddressLinkPojo1, personAddressLinkPojo2, personAddressLinkPojo3)), instance.getPersonAddressLinks());

        assertNull(instance10.getPersonAddressLinks());
        assertTrue(instance15.getPersonAddressLinks().isEmpty());
        assertTrue(instance16.getPersonAddressLinks().isEmpty());
        assertTrue(instance17.getPersonAddressLinks().isEmpty());
        assertTrue(instance18.getPersonAddressLinks().isEmpty());
        assertTrue(instance19.getPersonAddressLinks().isEmpty());
    }

    /**
     * Test of setPersonAddressLinks method.
     */
    @Test
    public void testSetPersonAddressLinks() {

        Set<PersonAddressLinkPojo> personAddressLinkSet = new HashSet<>(Arrays.asList(new PersonAddressLinkPojo(7853), new PersonAddressLinkPojo(6911)));

        instance.setPersonAddressLinks(personAddressLinkSet);
        assertEquals(new HashSet<>(Arrays.asList(new PersonAddressLinkPojo(7853), new PersonAddressLinkPojo(6911))), instance.getPersonAddressLinks());
        personAddressLinkSet.clear();
        assertEquals(new HashSet<>(Arrays.asList(new PersonAddressLinkPojo(7853), new PersonAddressLinkPojo(6911))), instance.getPersonAddressLinks());

        instance.setPersonAddressLinks(null);
        assertNull(instance.getPersonAddressLinks());
    }

    /**
     * Test of getPublishers method.
     */
    @Test
    public void testGetPublishers() {

        assertEquals(new HashSet<>(Arrays.asList(publisherPojo1, publisherPojo2, publisherPojo3)), instance.getPublishers());
        instance.getPublishers().clear();
        assertEquals(new HashSet<>(Arrays.asList(publisherPojo1, publisherPojo2, publisherPojo3)), instance.getPublishers());
        publishers.clear();
        assertEquals(new HashSet<>(Arrays.asList(publisherPojo1, publisherPojo2, publisherPojo3)), instance.getPublishers());

        assertNull(instance12.getPublishers());
        assertTrue(instance15.getPublishers().isEmpty());
        assertTrue(instance16.getPublishers().isEmpty());
        assertTrue(instance17.getPublishers().isEmpty());
        assertTrue(instance18.getPublishers().isEmpty());
        assertTrue(instance19.getPublishers().isEmpty());
    }

    /**
     * Test of setPublishers method.
     */
    @Test
    public void testSetPublishers() {

        Set<PublisherPojo> publisherSet = new HashSet<>(Arrays.asList(new PublisherPojo(2235, "TKI"), new PublisherPojo(4812, "F Pres")));
        instance.setPublishers(publisherSet);
        assertEquals(new HashSet<>(Arrays.asList(new PublisherPojo(2235, "TKI"), new PublisherPojo(4812, "F Pres"))), instance.getPublishers());

        publisherSet.clear();
        assertEquals(new HashSet<>(Arrays.asList(new PublisherPojo(2235, "TKI"), new PublisherPojo(4812, "F Pres"))), instance.getPublishers());

        instance.setPublishers(null);
        assertNull(instance.getPublishers());
    }

    /**
     * Test of getInvoices method.
     */
    @Test
    public void testGetInvoices() {

        assertEquals(new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3)), instance.getInvoices());
        instance.getInvoices().clear();
        assertEquals(new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3)), instance.getInvoices());
        invoices.clear();
        assertEquals(new HashSet<>(Arrays.asList(invoicePojo1, invoicePojo2, invoicePojo3)), instance.getInvoices());

        assertNull(instance14.getInvoices());
        assertTrue(instance15.getInvoices().isEmpty());
        assertTrue(instance16.getInvoices().isEmpty());
        assertTrue(instance17.getInvoices().isEmpty());
        assertTrue(instance18.getInvoices().isEmpty());
        assertTrue(instance19.getInvoices().isEmpty());
    }

    /**
     * Test of setInvoices method.
     */
    @Test
    public void testSetInvoices() {

        Set<InvoicePojo> invoiceSet = new HashSet<>(Arrays.asList(new InvoicePojo(89512, new CustomerPojo(6947, new PersonAddressLinkPojo(23489128), "inqlzig", "panzicae"), new Date(9143197413814L), new BigDecimal(4838.23), InvoiceValidity.NO, "ref-daldfajl")));

        instance.setInvoices(invoiceSet);
        assertEquals(new HashSet<>(Arrays.asList(new InvoicePojo(89512, new CustomerPojo(6947, new PersonAddressLinkPojo(23489128), "inqlzig", "panzicae"), new Date(9143197413814L), new BigDecimal(4838.23), InvoiceValidity.NO, "ref-daldfajl"))), instance.getInvoices());
        invoiceSet.clear();
        assertEquals(new HashSet<>(Arrays.asList(new InvoicePojo(89512, new CustomerPojo(6947, new PersonAddressLinkPojo(23489128), "inqlzig", "panzicae"), new Date(9143197413814L), new BigDecimal(4838.23), InvoiceValidity.NO, "ref-daldfajl"))), instance.getInvoices());
        
        instance.setInvoices(null);
        assertNull(instance.getInvoices());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance.hasSameConstraint(instance13));
        assertTrue(instance.hasSameConstraint(instance18));
        assertTrue(instance.hasSameConstraint(instance19));
        assertTrue(instance18.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(address));

        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(instance04));
        assertFalse(instance.hasSameConstraint(instance05));
        assertFalse(instance.hasSameConstraint(instance06));
        assertFalse(instance.hasSameConstraint(instance07));
        assertFalse(instance.hasSameConstraint(instance08));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance.hasSameParameters(instance11));
        assertTrue(instance.hasSameParameters(instance13));
        assertTrue(instance.hasSameParameters(instance18));
        assertTrue(instance.hasSameParameters(instance19));
        assertTrue(instance18.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(address));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(instance08));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());
        assertEquals(instance11.hashCode(), instance.hashCode());
        assertEquals(instance13.hashCode(), instance.hashCode());
        assertEquals(instance18.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
        assertNotEquals(instance08.hashCode(), instance.hashCode());
        assertNotEquals(instance19.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance16.equals(instance16));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance09));
        assertTrue(instance.equals(instance11));
        assertTrue(instance.equals(instance13));
        assertTrue(instance.equals(instance18));
        assertTrue(instance18.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(instance08));
        assertFalse(instance.equals(instance19));
        assertFalse(instance.equals(null));
        assertFalse(instance.equals(address));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        assertEquals("AddressPojo{id=857, house=87 ho, street=address main3, additional=additional3, city=city3, area=area3, postcode=postcode3, country=CT3}", instance.toString());
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
    private final class HibernateProxyAddressPojo extends AddressPojo implements HibernateProxy {

        private static final long serialVersionUID = 778836374051284408L;

        private final AddressPojo pojo;

        public HibernateProxyAddressPojo(AddressPojo pojo) {

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
                public AddressPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
