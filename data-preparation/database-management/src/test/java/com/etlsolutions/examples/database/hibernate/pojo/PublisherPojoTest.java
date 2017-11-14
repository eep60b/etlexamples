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

import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.Publisher;
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
 * Test of class PublisherPojo.
 *
 * @author Zhieng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PublisherPojoTest {

    private final int id = 5403;
    private final int id1 = 2212;
    private final AddressPojo address = Mockito.mock(AddressPojo.class);
    private final AddressPojo address2 = new AddressPojo();
    private final String name = "apessL";
    private final String name3 = "apessJ";

    private final BookPojo book1 = Mockito.mock(BookPojo.class);
    private final BookPojo book2 = Mockito.mock(BookPojo.class);
    private final BookPojo book3 = Mockito.mock(BookPojo.class);
    private final BookPojo book4 = Mockito.mock(BookPojo.class);
    private final Set<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
    private final Set<Book> books4 = new HashSet<>(Arrays.asList(book3, book4));
    private final Set<Book> books5 = null;

    private final Publisher publisher = Mockito.mock(Publisher.class);

    private final PublisherPojo instance = new PublisherPojo(id, address, name, books);
    private final PublisherPojo instance00 = new PublisherPojo(id, address, name, books);
    private final PublisherPojo instance01 = new PublisherPojo(id1, address, name, books);
    private final PublisherPojo instance02 = new PublisherPojo(id, address2, name, books);
    private final PublisherPojo instance03 = new PublisherPojo(id, address, name3, books);
    private final PublisherPojo instance04 = new PublisherPojo(id, address, name, books4);
    private final PublisherPojo instance05 = new PublisherPojo(id, address, name, books5);

    private final PublisherPojo instance06 = new PublisherPojo();
    private final PublisherPojo instance07 = new PublisherPojo(id, name);
    private final PublisherPojo instance08 = new PublisherPojo(address, name);
    private final PublisherPojo instance09 = new PublisherPojo(id, address, name);
    private final PublisherPojo instance10 = new HibernateProxyPublisherPojo(new PublisherPojo(id, address, name, books));
    private final PublisherPojo instance11 = new PublisherPojo(id, new AddressPojo(8, "ppan", "adnkk", "UKN"), name, books);

    @Before
    public void setUp() {

        Mockito.when(publisher.getName()).thenReturn(name);
        Mockito.when(publisher.getAddress()).thenReturn(address);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(5403, instance.getId());
        assertEquals(0, instance06.getId());
        assertEquals(5403, instance07.getId());
        assertEquals(0, instance08.getId());
        assertEquals(5403, instance09.getId());
        assertEquals(0, instance10.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(884);
        assertEquals(884, instance.getId());
    }

    /**
     * Test of getAddress method.
     */
    @Test
    public void testGetAddress() {

        assertEquals(address, instance.getAddress());
        assertNull(instance06.getAddress());
        assertNull(instance07.getAddress());
        assertEquals(address, instance08.getAddress());
        assertEquals(address, instance03.getAddress());
        assertNull(instance10.getAddress());
    }

    /**
     * Test of setAddress method.
     */
    @Test
    public void testSetAddress() {

        AddressPojo addressK = Mockito.mock(AddressPojo.class);
        instance.setAddress(addressK);
        assertEquals(addressK, instance.getAddress());
    }

    /**
     * Test of getName method.
     */
    @Test
    public void testGetName() {

        assertEquals("apessL", instance.getName());
        assertNull(instance06.getName());
        assertEquals("apessL", instance07.getName());
        assertEquals("apessL", instance08.getName());
        assertEquals("apessL", instance09.getName());
        assertNull(instance10.getName());
    }

    /**
     * Test of setName method.
     */
    @Test
    public void testSetName() {

        instance.setName("newNm");
        assertEquals("newNm", instance.getName());
    }

    /**
     * Test of getBooks method.
     */
    @Test
    public void testGetBooks() {

        assertEquals(new HashSet<>(Arrays.asList(book1, book2, book3)), instance.getBooks());
        instance.getBooks().clear();
        assertEquals(new HashSet<>(Arrays.asList(book1, book2, book3)), instance.getBooks());
        books.clear();
        assertEquals(new HashSet<>(Arrays.asList(book1, book2, book3)), instance.getBooks());

        assertNull(instance05.getBooks());
        assertTrue(instance06.getBooks().isEmpty());
        assertTrue(instance07.getBooks().isEmpty());
        assertTrue(instance08.getBooks().isEmpty());
        assertTrue(instance09.getBooks().isEmpty());
        assertTrue(instance10.getBooks().isEmpty());
    }

    /**
     * Test of setBooks method.
     */
    @Test
    public void testSetBooks() {
        Set<Book> booksA = new HashSet<>(Arrays.asList(book1, book2));

        instance.setBooks(booksA);
        assertEquals(new HashSet<>(Arrays.asList(book1, book2)), instance.getBooks());

        booksA.clear();
        assertEquals(new HashSet<>(Arrays.asList(book1, book2)), instance.getBooks());

        instance.setBooks(null);
        assertNull(instance.getBooks());
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
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance10.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(publisher));

        assertFalse(instance.hasSameConstraint(null));
        assertFalse(instance.hasSameConstraint(instance03));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance01));
        assertTrue(instance.hasSameParameters(instance04));
        assertTrue(instance.hasSameParameters(instance10));
        assertTrue(instance10.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(publisher));

        assertFalse(instance.hasSameParameters(null));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance10.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance04));
        assertTrue(instance.equals(instance10));
        assertTrue(instance10.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        Mockito.when(address.toString()).thenReturn("address1");

        assertEquals("PublisherPojo{id=5403, address=address1, name=apessL}", instance.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance11));
    }

    private final class HibernateProxyPublisherPojo extends PublisherPojo implements HibernateProxy {

        private static final long serialVersionUID = 830259958296423456L;

        private final PublisherPojo pojo;

        public HibernateProxyPublisherPojo(PublisherPojo pojo) {

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
                public PublisherPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
