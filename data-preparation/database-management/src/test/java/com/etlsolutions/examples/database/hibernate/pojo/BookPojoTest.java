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
import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class BookPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BookPojoTest {

    private final int id = 6652;
    private final int id1 = 8875;
    private final PublisherPojo publisher = new PublisherPojo(218, "Appns");
    private final PublisherPojo publisher2 = new PublisherPojo(852, "llnk");
    private final ItemCommonDetailPojo itemCommonDetail = new ItemCommonDetailPojo(206, "itemA", new BigDecimal(12.99), new BigDecimal(64.66), CurrencyCode.USD, AvailabilityType.YES, "139418981124");
    private final ItemCommonDetailPojo itemCommonDetail3 = new ItemCommonDetailPojo(10, "itemAKNK", new BigDecimal(12.99), new BigDecimal(64.66), CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, "71321718124");
    private final String isbn = "2039140238104";
    private final String isbn4 = "2937923149384";
    private final byte[] pdf = {44, 30, 91};
    private final byte[] pdf5 = {4, 98, 34};
    private final int edition = 7;
    private final int edition6 = 10;
    private final Date publishDate = new Date(389210398189L);
    private final Date publishDate7 = new Date(12932183913819L);
    private final BigDecimal width = new BigDecimal(92.63);
    private final BigDecimal width8 = new BigDecimal(66.66);
    private final BigDecimal length = new BigDecimal(21.76);
    private final BigDecimal length9 = new BigDecimal(54.32);
    private final BigDecimal thickness = new BigDecimal(44.33);
    private final BigDecimal thickness10 = new BigDecimal(91.1);
    private final UOM uom = UOM.CM;
    private final UOM uom11 = UOM.ELECTRONIC;
    private final BookFormat format = BookFormat.ELECTRONIC;
    private final BookFormat format12 = BookFormat.HARDCOVER;
    private final LanguageCode language = LanguageCode.CZ;
    private final LanguageCode language13 = LanguageCode.EN;
    private final Author author1 = Mockito.mock(AuthorPojo.class);
    private final Author author2 = Mockito.mock(AuthorPojo.class);
    private final Author author3 = Mockito.mock(AuthorPojo.class);
    private final Author author4 = Mockito.mock(AuthorPojo.class);
    private final Set<Author> authors = new HashSet<>(Arrays.asList(author1, author2, author3));
    private final Set<Author> authors14 = new HashSet<>(Arrays.asList(author1, author4));
    private final Set<Author> authors15 = null;    
    private final Book book = Mockito.mock(Book.class);

    private final BookPojo instance = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance00 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance01 = new BookPojo(id1, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance02 = new BookPojo(id, publisher2, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance03 = new BookPojo(id, publisher, itemCommonDetail3, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance04 = new BookPojo(id, publisher, itemCommonDetail, isbn4, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance05 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf5, edition, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance06 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition6, publishDate, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance07 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate7, width, length, thickness, uom, format, language, authors);
    private final BookPojo instance08 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width8, length, thickness, uom, format, language, authors);
    private final BookPojo instance09 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length9, thickness, uom, format, language, authors);
    private final BookPojo instance10 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness10, uom, format, language, authors);
    private final BookPojo instance11 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom11, format, language, authors);
    private final BookPojo instance12 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format12, language, authors);
    private final BookPojo instance13 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language13, authors);
    private final BookPojo instance14 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors14);
    private final BookPojo instance15 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors15);
    private final BookPojo instance16 = new BookPojo();
    private final BookPojo instance17 = new BookPojo(isbn, width, length, thickness, uom, format, language);
    private final BookPojo instance18 = new BookPojo(publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language);
    private final BookPojo instance19 = new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language);
    private final BookPojo instance20 = new HibernateProxyBookPojo(new BookPojo(id, publisher, itemCommonDetail, isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, authors));
    private final BookPojo instance21 = new BookPojo(id, new PublisherPojo(), new ItemCommonDetailPojo(), isbn, pdf, edition, publishDate, width, length, thickness, uom, format, language, new HashSet<>(Arrays.asList(new AuthorPojo())));
    
    @Before
    public void setUp() {

        Mockito.when(book.getEdition()).thenReturn(edition);
        Mockito.when(book.getFormat()).thenReturn(format);
        Mockito.when(book.getIsbn()).thenReturn(isbn);
        Mockito.when(book.getItemCommonDetail()).thenReturn(itemCommonDetail);
        Mockito.when(book.getLanguage()).thenReturn(language);
        Mockito.when(book.getLength()).thenReturn(length);
        Mockito.when(book.getPdf()).thenReturn(pdf);
        Mockito.when(book.getPublishDate()).thenReturn(publishDate);
        Mockito.when(book.getPublisher()).thenReturn(publisher);
        Mockito.when(book.getThickness()).thenReturn(thickness);
        Mockito.when(book.getUom()).thenReturn(uom);
        Mockito.when(book.getWidth()).thenReturn(width);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(6652, instance.getId());
        assertEquals(0, instance16.getId());
        assertEquals(0, instance17.getId());
        assertEquals(0, instance18.getId());
        assertEquals(6652, instance19.getId());
        assertEquals(0, instance20.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(333);
        assertEquals(333, instance.getId());
    }

    /**
     * Test of getPublisher method.
     */
    @Test
    public void testGetPublisher() {

        assertEquals(publisher, instance.getPublisher());
        assertNull(instance16.getPublisher());
        assertNull(instance17.getPublisher());
        assertEquals(publisher, instance18.getPublisher());
        assertEquals(publisher, instance19.getPublisher());
        assertNull(instance20.getPublisher());
    }

    /**
     * Test of setPublisher method.
     */
    @Test
    public void testSetPublisher() {

        PublisherPojo publisher1 = Mockito.mock(PublisherPojo.class);
        instance.setPublisher(publisher1);
        assertEquals(publisher1, instance.getPublisher());
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetail, instance.getItemCommonDetail());
        assertNull(instance16.getItemCommonDetail());
        assertNull(instance17.getItemCommonDetail());
        assertEquals(itemCommonDetail, instance.getItemCommonDetail());
        assertEquals(itemCommonDetail, instance.getItemCommonDetail());
        assertNull(instance20.getItemCommonDetail());
    }

    /**
     * Test of setItemCommonDetail method.
     */
    @Test
    public void testSetItemCommonDetail() {

        ItemCommonDetailPojo itemCommonDetail1 = Mockito.mock(ItemCommonDetailPojo.class);
        instance.setItemCommonDetail(itemCommonDetail1);
        assertEquals(itemCommonDetail1, instance.getItemCommonDetail());
    }

    /**
     * Test of getIsbn method.
     */
    @Test
    public void testGetIsbn() {

        assertEquals(isbn, instance.getIsbn());
        assertNull(instance16.getIsbn());
        assertEquals(isbn, instance17.getIsbn());
        assertEquals(isbn, instance18.getIsbn());
        assertEquals(isbn, instance19.getIsbn());
        assertNull(instance20.getIsbn());
    }

    /**
     * Test of setIsbn method.
     */
    @Test
    public void testSetIsbn() {

        String isbn1 = "1903481947981";
        instance.setIsbn(isbn1);
        assertEquals(isbn1, instance.getIsbn());
    }

    /**
     * Test of getPdf method.
     */
    @Test
    public void testGetPdf() {

        assertArrayEquals(pdf, instance.getPdf());
        assertNull(instance16.getPdf());
        assertNull(instance17.getPdf());
        assertArrayEquals(pdf, instance18.getPdf());
        assertArrayEquals(pdf, instance19.getPdf());
        assertNull(instance20.getPdf());
    }

    /**
     * Test of setPdf method.
     */
    @Test
    public void testSetPdf() {

        byte[] pdf1 = new byte[]{36, 99};
        instance.setPdf(pdf1);
        assertArrayEquals(pdf1, instance.getPdf());
    }

    /**
     * Test of getEdition method.
     */
    @Test
    public void testGetEdition() {

        assertEquals(7, instance.getEdition());
        assertEquals(0, instance16.getEdition());
        assertEquals(0, instance17.getEdition());
        assertEquals(7, instance18.getEdition());
        assertEquals(7, instance19.getEdition());
        assertEquals(0, instance20.getEdition());
    }

    /**
     * Test of setEdition method.
     */
    @Test
    public void testSetEdition() {

        instance.setEdition(3);
        assertEquals(3, instance.getEdition());
    }

    /**
     * Test of getPublishDate method.
     */
    @Test
    public void testGetPublishDate() {

        assertEquals(publishDate, instance.getPublishDate());
        assertNull(instance16.getPublishDate());
        assertNull(instance17.getPublishDate());
        assertEquals(publishDate, instance18.getPublishDate());
        assertEquals(publishDate, instance19.getPublishDate());
        assertNull(instance20.getPublishDate());
    }

    /**
     * Test of setPublishDate method.
     */
    @Test
    public void testSetPublishDate() {

        Date publishDate1 = new Date(129379179189914392L);
        instance.setPublishDate(publishDate1);
        assertEquals(publishDate1, instance.getPublishDate());
    }

    /**
     * Test of getWidth method.
     */
    @Test
    public void testGetWidth() {

        assertEquals(new BigDecimal(92.63), instance.getWidth());
        assertNull(instance16.getWidth());
        assertEquals(new BigDecimal(92.63), instance17.getWidth());
        assertEquals(new BigDecimal(92.63), instance18.getWidth());
        assertEquals(new BigDecimal(92.63), instance19.getWidth());
        assertNull(instance20.getWidth());
    }

    /**
     * Test of setWidth method.
     */
    @Test
    public void testSetWidth() {

        instance.setWidth(new BigDecimal(54.00));
        assertEquals(new BigDecimal(54.00), instance.getWidth());
    }

    /**
     * Test of getLength method.
     */
    @Test
    public void testGetLength() {

        assertEquals(new BigDecimal(21.76), instance.getLength());
        assertNull(instance16.getLength());
        assertEquals(new BigDecimal(21.76), instance17.getLength());
        assertEquals(new BigDecimal(21.76), instance18.getLength());
        assertEquals(new BigDecimal(21.76), instance19.getLength());
        assertNull(instance20.getLength());
    }

    /**
     * Test of setLength method.
     */
    @Test
    public void testSetLength() {

        instance.setLength(new BigDecimal(99.9));
        assertEquals(new BigDecimal(99.9), instance.getLength());
    }

    /**
     * Test of getThickness method.
     */
    @Test
    public void testGetThickness() {

        assertEquals(new BigDecimal(44.33), instance.getThickness());
        assertNull(instance16.getThickness());
        assertEquals(new BigDecimal(44.33), instance17.getThickness());
        assertEquals(new BigDecimal(44.33), instance18.getThickness());
        assertEquals(new BigDecimal(44.33), instance19.getThickness());
        assertNull(instance20.getThickness());
    }

    /**
     * Test of setThickness method.
     */
    @Test
    public void testSetThickness() {

        instance.setThickness(new BigDecimal(2.4));
        assertEquals(new BigDecimal(2.4), instance.getThickness());
    }

    /**
     * Test of getUom method.
     */
    @Test
    public void testGetUom() {

        assertEquals(UOM.CM, instance.getUom());
        assertNull(instance16.getUom());
        assertEquals(UOM.CM, instance17.getUom());
        assertEquals(UOM.CM, instance18.getUom());
        assertEquals(UOM.CM, instance19.getUom());
        assertNull(instance20.getUom());
    }

    /**
     * Test of setUom method.
     */
    @Test
    public void testSetUom() {

        instance.setUom(UOM.ELECTRONIC);
        assertEquals(UOM.ELECTRONIC, instance.getUom());
    }

    /**
     * Test of getFormat method.
     */
    @Test
    public void testGetFormat() {

        assertEquals(BookFormat.ELECTRONIC, instance.getFormat());
        assertNull(instance16.getFormat());
        assertEquals(BookFormat.ELECTRONIC, instance17.getFormat());
        assertEquals(BookFormat.ELECTRONIC, instance18.getFormat());
        assertEquals(BookFormat.ELECTRONIC, instance19.getFormat());
        assertNull(instance20.getFormat());
    }

    /**
     * Test of setFormat method.
     */
    @Test
    public void testSetFormat() {

        instance.setFormat(BookFormat.PAPERBACK);
        assertEquals(BookFormat.PAPERBACK, instance.getFormat());
    }

    /**
     * Test of getLanguage method.
     */
    @Test
    public void testGetLanguage() {

        assertEquals(LanguageCode.CZ, instance.getLanguage());
        assertNull(instance16.getLanguage());
        assertEquals(LanguageCode.CZ, instance17.getLanguage());
        assertEquals(LanguageCode.CZ, instance18.getLanguage());
        assertEquals(LanguageCode.CZ, instance19.getLanguage());
        assertNull(instance20.getLanguage());
    }

    /**
     * Test of setLanguage method.
     */
    @Test
    public void testSetLanguage() {

        instance.setLanguage(LanguageCode.FR);
        assertEquals(LanguageCode.FR, instance.getLanguage());
    }

    /**
     * Test of getAuthors method.
     */
    @Test
    public void testGetAuthors() {

        assertEquals(new HashSet<>(Arrays.asList(author1, author2, author3)), instance.getAuthors());
        instance.getAuthors().clear();
        assertEquals(new HashSet<>(Arrays.asList(author1, author2, author3)), instance.getAuthors());
        authors.clear();
        assertEquals(new HashSet<>(Arrays.asList(author1, author2, author3)), instance.getAuthors());

        assertNull(instance15.getAuthors());
        assertTrue(instance16.getAuthors().isEmpty());
        assertTrue(instance17.getAuthors().isEmpty());
        assertTrue(instance18.getAuthors().isEmpty());
        assertTrue(instance19.getAuthors().isEmpty());
        assertTrue(instance20.getAuthors().isEmpty());
    }

    /**
     * Test of setAuthors method.
     */
    @Test
    public void testSetAuthors() {

        Set<Author> authorsA = new HashSet<>(Arrays.asList(author2, author3, author4));
        instance.setAuthors(authorsA);
        assertEquals(new HashSet<>(Arrays.asList(author2, author3, author4)), instance.getAuthors());
        authorsA.clear();
        assertEquals(new HashSet<>(Arrays.asList(author2, author3, author4)), instance.getAuthors());
        instance.setAuthors(null);
        assertNull(instance15.getAuthors());        
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());
        assertEquals(instance07.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());
        assertEquals(instance10.hashCode(), instance.hashCode());
        assertEquals(instance14.hashCode(), instance.hashCode());
        assertEquals(instance20.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance11.hashCode(), instance.hashCode());
        assertNotEquals(instance12.hashCode(), instance.hashCode());
        assertNotEquals(instance13.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance14));        
        assertTrue(instance.equals(instance20));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(instance06));
        assertFalse(instance.equals(instance07));
        assertFalse(instance.equals(instance08));
        assertFalse(instance.equals(instance09));
        assertFalse(instance.equals(instance10));
        assertFalse(instance.equals(instance11));
        assertFalse(instance.equals(instance12));
        assertFalse(instance.equals(instance13));
        assertFalse(instance.equals(new Object()));
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
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance.hasSameConstraint(instance13));
        assertTrue(instance.hasSameConstraint(book));
        assertTrue(instance13.hasSameConstraint(instance));

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
        assertTrue(instance.hasSameParameters(instance14));
        assertTrue(instance.hasSameParameters(instance20));
        assertTrue(instance.hasSameParameters(book));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(instance06));
        assertFalse(instance.hasSameParameters(instance07));
        assertFalse(instance.hasSameParameters(instance08));
        assertFalse(instance.hasSameParameters(instance09));
        assertFalse(instance.hasSameParameters(instance10));
        assertFalse(instance.hasSameParameters(instance11));
        assertFalse(instance.hasSameParameters(instance12));
        assertFalse(instance.hasSameParameters(instance13));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance21));
    }

    private final class HibernateProxyBookPojo extends BookPojo implements HibernateProxy {

        private static final long serialVersionUID = 809338385995401485L;

        private final BookPojo pojo;

        public HibernateProxyBookPojo(BookPojo pojo) {
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
                public BookPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
