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
package com.etlsolutions.examples.data.specific.book;

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.item.ItemAvailabilityNumber;
import com.etlsolutions.examples.data.specific.item.ItemBarcode;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.item.ItemDescription;
import com.etlsolutions.examples.data.specific.item.ItemImage;
import com.etlsolutions.examples.data.specific.item.ItemRanking;
import com.etlsolutions.examples.data.specific.item.ListPrice;
import com.etlsolutions.examples.data.specific.item.SalePrice;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class BookEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BookEntityTest {

    private final AddressEntity addressEntity = new AddressEntity(new AddressHouse("227"), new AddressStreet("stank"), new AddressAdditionalInformation("addadd"), new AddressArea("Greate Mank"), new AddressCity("Cidy"), new AddressCountry("UK"), new AddressPostcode("LLL786 2nl"));
    private final ItemCommonDetailEntity itemCommonDetailEntity = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(32),
            new ItemDescription("ff dsknk"), new ItemImage(new byte[]{35, 63, 22}), new NameWrapper("ite name"),
            new ItemRanking(23921), new ListPrice(new BigDecimal(42.47)), new SalePrice(new BigDecimal(23.11)), new ItemBarcode("fadaalfdkank"));
    private final ItemCommonDetailEntity itemCommonDetailEntity1 = new ItemCommonDetailEntity(CurrencyCode.USD, AvailabilityType.OUT_OF_STOCK, new ItemAvailabilityNumber(32),
            new ItemDescription("ff dsknk"), new ItemImage(new byte[]{35, 63, 22}), new NameWrapper("ite name"),
            new ItemRanking(23921), new ListPrice(), new SalePrice(22.37), new ItemBarcode("fadaalfdkankafad"));
    private final PublisherEntity publisherEntity = new PublisherEntity(addressEntity, new NameWrapper("kaak publ ish"));
    private final PublisherEntity publisherEntity2 = new PublisherEntity(addressEntity, new NameWrapper("bubll ish"));

    private final BookPdfContent pdfContent = new BookPdfContent(new byte[]{22, 11, 78});
    private final BookPdfContent pdfContent3 = new BookPdfContent(new byte[]{28, 53, 12});
    private final int edition = 2;
    private final int edition4 = 4;
    private final BookFormat bookFormat = BookFormat.PAPERBACK;
    private final BookFormat bookFormat5 = BookFormat.ELECTRONIC;
    private final String isbn = "1382373383778";
    private final String isbn6 = "2382376723778";
    private final LanguageCode languageCode = LanguageCode.EN;
    private final LanguageCode languageCode7 = LanguageCode.CZ;
    private final PublishDate publishDate = new PublishDate(new Date(2130095302349L));
    private final PublishDate publishDate8 = new PublishDate(new Date(21311195302349L));
    private final BookWidth bookWidth = new BookWidth(new BigDecimal(33.77));
    private final BookWidth bookWidthColumn9 = new BookWidth(new BigDecimal(46.77));
    private final BookLength bookLength = new BookLength(new BigDecimal(33.36));
    private final BookLength bookLength10 = new BookLength(new BigDecimal(41.65));
    private final BookThickness bookThickness = new BookThickness(new BigDecimal(3.34));
    private final BookThickness bookThickness11 = new BookThickness(new BigDecimal(5.68));
    private final UOM uom = UOM.IN;
    private final UOM uom12 = UOM.CM;
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);
    private final Publisher publisher = Mockito.mock(Publisher.class);
    private final BookIsbn bookIsbn = new BookIsbn("1382373383778");
    private final BookEdition bookEdition = new BookEdition(2);

    private final Book book = Mockito.mock(Book.class);

    private final BookEntity instance = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance00 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance01 = new BookEntity(itemCommonDetailEntity1, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance02 = new BookEntity(itemCommonDetailEntity, publisherEntity2, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance03 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent3, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance04 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition4, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance05 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat5, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance06 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn6, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance07 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode7, publishDate, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance08 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate8, bookWidth, bookLength, bookThickness, uom);
    private final BookEntity instance09 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidthColumn9, bookLength, bookThickness, uom);
    private final BookEntity instance10 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength10, bookThickness, uom);
    private final BookEntity instance11 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness11, uom);
    private final BookEntity instance12 = new BookEntity(itemCommonDetailEntity, publisherEntity, pdfContent, edition, bookFormat, isbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom12);
    private BookEntity instance13;
    private BookEntity instance14;

    @Before
    public void setUp() {

        Mockito.when(book.getItemCommonDetail()).thenReturn(itemCommonDetailEntity);
        Mockito.when(book.getPublisher()).thenReturn(publisherEntity);
        Mockito.when(book.getPdf()).thenReturn(new byte[]{22, 11, 78});
        Mockito.when(book.getEdition()).thenReturn(2);
        Mockito.when(book.getFormat()).thenReturn(BookFormat.PAPERBACK);
        Mockito.when(book.getIsbn()).thenReturn("1382373383778");
        Mockito.when(book.getLanguage()).thenReturn(LanguageCode.EN);
        Mockito.when(book.getLength()).thenReturn(new BigDecimal(33.36));
        Mockito.when(book.getPublishDate()).thenReturn(new Date(2130095302349L));
        Mockito.when(book.getThickness()).thenReturn(new BigDecimal(3.34));
        Mockito.when(book.getUom()).thenReturn(UOM.IN);
        Mockito.when(book.getWidth()).thenReturn(new BigDecimal(33.77));

        Mockito.when(itemCommonDetail.getAvailability()).thenReturn(AvailabilityType.OUT_OF_STOCK);
        Mockito.when(itemCommonDetail.getAvailabilityNumber()).thenReturn(32);
        Mockito.when(itemCommonDetail.getBarcode()).thenReturn("fadaalfdkank");
        Mockito.when(itemCommonDetail.getCurrencyCode()).thenReturn(CurrencyCode.USD);
        Mockito.when(itemCommonDetail.getDescription()).thenReturn("ff dsknk");
        Mockito.when(itemCommonDetail.getImage()).thenReturn(new byte[]{35, 63, 22});
        Mockito.when(itemCommonDetail.getListPrice()).thenReturn(new BigDecimal(42.47));
        Mockito.when(itemCommonDetail.getName()).thenReturn("ite name");
        Mockito.when(itemCommonDetail.getRanking()).thenReturn(23921);
        Mockito.when(itemCommonDetail.getSalePrice()).thenReturn(new BigDecimal(23.11));

        Mockito.when(publisher.getAddress()).thenReturn(addressEntity);
        Mockito.when(publisher.getName()).thenReturn("kaak publ ish");

        instance13 = new BookEntity(itemCommonDetail, publisher, pdfContent, bookEdition, bookFormat, bookIsbn, languageCode, publishDate, bookWidth, bookLength, bookThickness, uom);
        instance14 = new BookEntity(book);
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetailEntity, instance.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity1, instance01.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance13.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance14.getItemCommonDetail());
    }

    /**
     * Test of getPublisher method.
     */
    @Test
    public void testGetPublisher() {

        assertEquals(publisherEntity, instance.getPublisher());
        assertEquals(publisherEntity2, instance02.getPublisher());
        assertEquals(publisherEntity, instance13.getPublisher());
        assertEquals(publisherEntity, instance14.getPublisher());
    }

    /**
     * Test of getPdf method.
     */
    @Test
    public void testGetPdf() {
        assertArrayEquals(new byte[]{22, 11, 78}, instance.getPdf());
        assertArrayEquals(new byte[]{28, 53, 12}, instance03.getPdf());
        assertArrayEquals(new byte[]{22, 11, 78}, instance13.getPdf());
        assertArrayEquals(new byte[]{22, 11, 78}, instance14.getPdf());
    }

    /**
     * Test of getEdition method.
     */
    @Test
    public void testGetEdition() {

        assertEquals(2, instance.getEdition());
        assertEquals(4, instance04.getEdition());
        assertEquals(2, instance13.getEdition());
        assertEquals(2, instance14.getEdition());
    }

    /**
     * Test of getFormat method.
     */
    @Test
    public void testGetFormat() {

        assertEquals(BookFormat.PAPERBACK, instance.getFormat());
        assertEquals(BookFormat.ELECTRONIC, instance05.getFormat());
        assertEquals(BookFormat.PAPERBACK, instance13.getFormat());
        assertEquals(BookFormat.PAPERBACK, instance14.getFormat());
    }

    /**
     * Test of getIsbn method.
     */
    @Test
    public void testGetIsbn() {

        assertEquals("1382373383778", instance.getIsbn());
        assertEquals("2382376723778", instance06.getIsbn());
        assertEquals("1382373383778", instance13.getIsbn());
        assertEquals("1382373383778", instance14.getIsbn());
    }

    /**
     * Test of getLanguage method.
     */
    @Test
    public void testGetLanguage() {

        assertEquals(LanguageCode.EN, instance.getLanguage());
        assertEquals(LanguageCode.CZ, instance07.getLanguage());
        assertEquals(LanguageCode.EN, instance13.getLanguage());
        assertEquals(LanguageCode.EN, instance14.getLanguage());
    }

    /**
     * Test of getPublishDate method, of class BookEntity.
     */
    @Test
    public void testGetPublishDate() {

        assertEquals(new Date(2130095302349L), instance.getPublishDate());
        assertEquals(new Date(21311195302349L), instance08.getPublishDate());
        assertEquals(new Date(2130095302349L), instance13.getPublishDate());
        assertEquals(new Date(2130095302349L), instance14.getPublishDate());
    }

    /**
     * Test of getWidth method.
     */
    @Test
    public void testGetWidth() {

        assertEquals(new BigDecimal(33.77).setScale(1, BigDecimal.ROUND_HALF_UP), instance.getWidth());
        assertEquals(new BigDecimal(46.77).setScale(1, BigDecimal.ROUND_HALF_UP), instance09.getWidth());
        assertEquals(new BigDecimal(33.77).setScale(1, BigDecimal.ROUND_HALF_UP), instance13.getWidth());
        assertEquals(new BigDecimal(33.77).setScale(1, BigDecimal.ROUND_HALF_UP), instance14.getWidth());
    }

    /**
     * Test of getLength method, of class BookEntity.
     */
    @Test
    public void testGetLength() {

        assertEquals(new BigDecimal(33.36).setScale(1, BigDecimal.ROUND_HALF_UP), instance.getLength());
        assertEquals(new BigDecimal(41.65).setScale(1, BigDecimal.ROUND_HALF_UP), instance10.getLength());
        assertEquals(new BigDecimal(33.36).setScale(1, BigDecimal.ROUND_HALF_UP), instance13.getLength());
        assertEquals(new BigDecimal(33.36).setScale(1, BigDecimal.ROUND_HALF_UP), instance14.getLength());
    }

    /**
     * Test of getThickness method.
     */
    @Test
    public void testGetThickness() {

        assertEquals(new BigDecimal(3.34).setScale(1, BigDecimal.ROUND_HALF_UP), instance.getThickness());
        assertEquals(new BigDecimal(5.68).setScale(1, BigDecimal.ROUND_HALF_UP), instance11.getThickness());
        assertEquals(new BigDecimal(3.34).setScale(1, BigDecimal.ROUND_HALF_UP), instance13.getThickness());
        assertEquals(new BigDecimal(3.34).setScale(1, BigDecimal.ROUND_HALF_UP), instance14.getThickness());
    }

    /**
     * Test of getUom method.
     */
    @Test
    public void testGetUom() {

        assertEquals(UOM.IN, instance.getUom());
        assertEquals(UOM.CM, instance12.getUom());
        assertEquals(UOM.IN, instance13.getUom());
        assertEquals(UOM.IN, instance14.getUom());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance08.hashCode(), instance.hashCode());
        assertEquals(instance09.hashCode(), instance.hashCode());
        assertEquals(instance10.hashCode(), instance.hashCode());
        assertEquals(instance11.hashCode(), instance.hashCode());
        assertEquals(instance13.hashCode(), instance.hashCode());
        assertEquals(instance14.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
        assertNotEquals(instance06.hashCode(), instance.hashCode());
        assertNotEquals(instance07.hashCode(), instance.hashCode());
        assertNotEquals(instance12.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance13));
        assertTrue(instance.equals(instance14));

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
        assertFalse(instance.equals(null));
        assertFalse(instance.equals(book));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("BookEntity{book name=ite name, publisher=kaak publ ish}", instance.toString());
    }

    /**
     * Test of hasSameConstraint method, of class BookEntity.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(instance08));
        assertTrue(instance.hasSameConstraint(instance09));
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance.hasSameConstraint(instance11));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance.hasSameConstraint(instance13));
        assertTrue(instance.hasSameConstraint(instance14));
        assertTrue(instance.hasSameConstraint(book));

        assertFalse(instance.hasSameConstraint(instance06));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance13));
        assertTrue(instance.hasSameParameters(instance14));
        assertTrue(instance.hasSameParameters(book));

        assertFalse(instance.hasSameParameters(instance01));
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
    }
}
