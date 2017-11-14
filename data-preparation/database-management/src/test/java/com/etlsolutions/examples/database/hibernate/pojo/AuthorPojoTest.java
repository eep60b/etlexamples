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

import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.utility.SerialisationUtilities;
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
 * Test of class AuthorPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AuthorPojoTest {

    private final int id = 1453;
    private final int id1 = 453;
    private final PersonalDetailPojo personalDetailPojo = new PersonalDetailPojo("Mr.", "gg;vme", "ffda", new Date(83419319178391L), new byte[]{53, 65});
    private final PersonalDetailPojo personalDetailPojo2 = new PersonalDetailPojo("Mr.", "gkkkk", "lllafa", new Date(83419319178391L), new byte[]{53, 65, 77, 98});
    private final byte[] image = new byte[]{1, 61};
    private final byte[] image3 = new byte[]{22, 6};
    private final byte[] biography = new byte[]{7, 11};
    private final byte[] biography4 = new byte[]{27, 3};
    private final String webpageUrl = "authorUrl";
    private final String webpageUrl5 = "authorUrlKU";
    private final BookPojo book1 = Mockito.mock(BookPojo.class);
    private final BookPojo book2 = Mockito.mock(BookPojo.class);
    private final BookPojo book3 = Mockito.mock(BookPojo.class);
    private final BookPojo book4 = Mockito.mock(BookPojo.class);
    private final Set<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
    private final Set<Book> books6 = new HashSet<>(Arrays.asList(book2, book4));
    private final Set<Book> books7 = null;
    private final Author author = Mockito.mock(Author.class);

    private final AuthorPojo instance = new AuthorPojo(id, personalDetailPojo, image, biography, webpageUrl, books);
    private final AuthorPojo instance00 = new AuthorPojo(id, personalDetailPojo, image, biography, webpageUrl, books);
    private final AuthorPojo instance01 = new AuthorPojo(id1, personalDetailPojo, image, biography, webpageUrl, books);
    private final AuthorPojo instance02 = new AuthorPojo(id, personalDetailPojo2, image, biography, webpageUrl, books);
    private final AuthorPojo instance03 = new AuthorPojo(id, personalDetailPojo, image3, biography, webpageUrl, books);
    private final AuthorPojo instance04 = new AuthorPojo(id, personalDetailPojo, image, biography4, webpageUrl, books);
    private final AuthorPojo instance05 = new AuthorPojo(id, personalDetailPojo, image, biography, webpageUrl5, books);
    private final AuthorPojo instance06 = new AuthorPojo(id, personalDetailPojo, image, biography, webpageUrl, books6);
    private final AuthorPojo instance07 = new AuthorPojo(id, personalDetailPojo, image, biography, webpageUrl, books7);
    private final AuthorPojo instance08 = new AuthorPojo();
    private final AuthorPojo instance09 = new AuthorPojo(id, personalDetailPojo);
    private final AuthorPojo instance10 = new AuthorPojo(personalDetailPojo, image, biography, webpageUrl);
    private final AuthorPojo instance11 = new AuthorPojo(id, personalDetailPojo, image, biography, webpageUrl);
    private final AuthorPojo instance12 = new HibernateProxyAuthorPojo(new AuthorPojo(id, personalDetailPojo, image, biography, webpageUrl, books));

    @Before
    public void setUp() {
        Mockito.when(author.getBiography()).thenReturn(biography);
        Mockito.when(author.getImage()).thenReturn(image);
        Mockito.when(author.getPersonalDetail()).thenReturn(personalDetailPojo);
        Mockito.when(author.getWebpageUrl()).thenReturn(webpageUrl);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(1453, instance.getId());
        assertEquals(0, instance08.getId());
        assertEquals(1453, instance09.getId());
        assertEquals(0, instance10.getId());
        assertEquals(1453, instance11.getId());
        assertEquals(0, instance12.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(6973);
        assertEquals(6973, instance.getId());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(new PersonalDetailPojo("Mr.", "gg;vme", "ffda", new Date(83419319178391L), new byte[]{53, 65}), instance.getPersonalDetail());
        assertNull(instance08.getPersonalDetail());
        assertEquals(new PersonalDetailPojo("Mr.", "gg;vme", "ffda", new Date(83419319178391L), new byte[]{53, 65}), instance09.getPersonalDetail());
        assertEquals(new PersonalDetailPojo("Mr.", "gg;vme", "ffda", new Date(83419319178391L), new byte[]{53, 65}), instance10.getPersonalDetail());
        assertEquals(new PersonalDetailPojo("Mr.", "gg;vme", "ffda", new Date(83419319178391L), new byte[]{53, 65}), instance11.getPersonalDetail());
        assertNull(instance12.getPersonalDetail());
    }

    /**
     * Test of setPersonalDetail method.
     */
    @Test
    public void testSetPersonalDetail() {

        instance.setPersonalDetail(new PersonalDetailPojo("Mrkk.", "gg;vme", "ffda", new Date(83419319178391L), new byte[]{53, 65, 77, 98}));
        assertEquals(new PersonalDetailPojo("Mrkk.", "gg;vme", "ffda", new Date(83419319178391L), new byte[]{53, 65, 77, 98}), instance.getPersonalDetail());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        assertArrayEquals(new byte[]{1, 61}, instance.getImage());
        image[0] = 44;
        assertArrayEquals(new byte[]{1, 61}, instance.getImage());
        instance.getImage()[0] = 23;
        assertArrayEquals(new byte[]{1, 61}, instance.getImage());

        assertNull(instance08.getImage());
        assertNull(instance09.getImage());
        assertArrayEquals(new byte[]{1, 61}, instance10.getImage());
        assertArrayEquals(new byte[]{1, 61}, instance11.getImage());
        assertNull(instance12.getImage());
    }

    /**
     * Test of setImage method.
     */
    @Test
    public void testSetImage() {

        byte[] imageK = {2, 27, 31};
        instance.setImage(imageK);
        assertArrayEquals(new byte[]{2, 27, 31}, instance.getImage());

        imageK[0] = 32;
        assertArrayEquals(new byte[]{2, 27, 31}, instance.getImage());
    }

    /**
     * Test of getBiography method.
     */
    @Test
    public void testGetBiography() {

        assertArrayEquals(new byte[]{7, 11}, instance.getBiography());
        instance.getBiography()[0] = 28;
        assertArrayEquals(new byte[]{7, 11}, instance.getBiography());
        biography[0] = 73;
        assertArrayEquals(new byte[]{7, 11}, instance.getBiography());

        assertNull(instance08.getBiography());
        assertNull(instance09.getBiography());
        assertArrayEquals(new byte[]{7, 11}, instance10.getBiography());
        assertArrayEquals(new byte[]{7, 11}, instance11.getBiography());
    }

    /**
     * Test of setBiography method.
     */
    @Test
    public void testSetBiography() {

        byte[] biographyK = {71, 55};
        instance.setBiography(biographyK);
        assertArrayEquals(new byte[]{71, 55}, instance.getBiography());

        biographyK[0] = 22;
        assertArrayEquals(new byte[]{71, 55}, instance.getBiography());
    }

    /**
     * Test of getWebpageUrl method.
     */
    @Test
    public void testGetWebpageUrl() {

        assertEquals("authorUrl", instance.getWebpageUrl());
        assertNull(instance08.getWebpageUrl());
        assertNull(instance09.getWebpageUrl());
        assertEquals("authorUrl", instance10.getWebpageUrl());
        assertEquals("authorUrl", instance11.getWebpageUrl());
    }

    /**
     * Test of setWebpageUrl method.
     */
    @Test
    public void testSetWebpageUrl() {

        instance.setWebpageUrl("setauthorUrl");
        assertEquals("setauthorUrl", instance.getWebpageUrl());
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

        assertNull(instance07.getBooks());
        assertTrue(instance08.getBooks().isEmpty());
        assertTrue(instance09.getBooks().isEmpty());
        assertTrue(instance10.getBooks().isEmpty());
        assertTrue(instance11.getBooks().isEmpty());
        assertTrue(instance12.getBooks().isEmpty());
    }

    /**
     * Test of setBooks method.
     */
    @Test
    public void testSetBooks() {

        Set<Book> booksK = new HashSet<>(Arrays.asList(book2));
        instance.setBooks(new HashSet<>(booksK));
        assertEquals(new HashSet<>(Arrays.asList(book2)), instance.getBooks());
        booksK.add(book3);
        assertEquals(new HashSet<>(Arrays.asList(book2)), instance.getBooks());

        instance.setBooks(null);
        assertNull(instance.getBooks());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance12.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance12));
        assertTrue(instance12.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(author));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance.hasSameConstraint(author));
        assertTrue(instance12.hasSameConstraint(instance));

        assertFalse(instance.hasSameConstraint(instance02));
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
        assertTrue(instance.hasSameParameters(instance12));
        assertTrue(instance.hasSameParameters(author));
        assertTrue(instance12.hasSameParameters(instance));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("AuthorPojo{id=1453, personalDetail=PersonalDetailPojo{id=0, title=Mr., given name=gg;vme, family name=ffda}}", instance.toString());
        assertEquals("AuthorPojo{id=0, personalDetail=null}", instance08.toString());
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance08));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyAuthorPojo extends AuthorPojo implements HibernateProxy {

        private static final long serialVersionUID = 221794584125375431L;

        private final AuthorPojo pojo;

        public HibernateProxyAuthorPojo(AuthorPojo pojo) {

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
                public AuthorPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
