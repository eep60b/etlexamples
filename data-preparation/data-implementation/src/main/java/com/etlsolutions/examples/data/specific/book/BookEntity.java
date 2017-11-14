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

import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.utility.CalendarUtilities;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.utility.NumberUtilities;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * The BookEntity class contains the information of a book.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class BookEntity implements Book {

    private final ItemCommonDetailEntity itemCommonDetail;
    private final PublisherEntity publisher;
    private final BookPdfContent pdfContent;
    private final int bookEdition;
    private final BookFormat format;
    private final String bookIsbn;
    private final LanguageCode language;
    private final PublishDate publishDate;
    private final BookWidth bookWidth;
    private final BookLength bookLength;
    private final BookThickness bookThickness;
    private final UOM uom;

    /**
     * Construct an object using the given parameters.
     *
     * @param itemCommonDetail - The item detail.
     * @param publisher - The publisher.
     * @param pdfContent - The content of PDF file of the book.
     * @param bookEdition - The book edition.
     * @param bookFormat - The book format.
     * @param bookIsbn - The book ISBN number.
     * @param language - The book language.
     * @param publishDate - The published date of the book.
     * @param bookWidth - The book width.
     * @param bookLength - The book length.
     * @param bookThickness - The book thickness.
     * @param uom - The unit of measurement of width, length, thickness of the book.
     */
    public BookEntity(ItemCommonDetail itemCommonDetail, Publisher publisher, BookPdfContent pdfContent, int bookEdition,
            BookFormat bookFormat, String bookIsbn, LanguageCode language, PublishDate publishDate,
            BookWidth bookWidth, BookLength bookLength, BookThickness bookThickness, UOM uom) {
        this.itemCommonDetail = itemCommonDetail instanceof ItemCommonDetailEntity ? (ItemCommonDetailEntity) itemCommonDetail : new ItemCommonDetailEntity(itemCommonDetail);
        this.publisher = publisher instanceof PublisherEntity ? (PublisherEntity) publisher : new PublisherEntity(publisher);
        this.pdfContent = pdfContent;
        this.bookEdition = bookEdition;
        this.format = bookFormat;
        this.bookIsbn = bookIsbn;
        this.language = language;
        this.publishDate = publishDate;
        this.bookWidth = bookWidth;
        this.bookLength = bookLength;
        this.bookThickness = bookThickness;
        this.uom = uom;
    }

    /**
     * Construct an object using the given parameters.
     *
     * @param itemCommonDetail - The item detail.
     * @param publisher - The publisher.
     * @param pdfContent - The content of PDF file of the book.
     * @param bookEdition - The book edition.
     * @param bookFormat - The book format.
     * @param bookIsbn - The book ISBN number.
     * @param language - The book language.
     * @param publishDate - The published date of the book.
     * @param bookWidth - The book width.
     * @param bookLength - The book length.
     * @param bookThickness - The book thickness.
     * @param uom - The unit of measurement of width, length, thickness of the book.
     */
    public BookEntity(ItemCommonDetail itemCommonDetail, Publisher publisher, BookPdfContent pdfContent, BookEdition bookEdition,
            BookFormat bookFormat, BookIsbn bookIsbn, LanguageCode language, PublishDate publishDate,
            BookWidth bookWidth, BookLength bookLength, BookThickness bookThickness, UOM uom) {
        
        this(itemCommonDetail, publisher, pdfContent, bookEdition.getValue(), bookFormat,
        bookIsbn.getValue(), language, publishDate, bookWidth, bookLength, bookThickness, uom);
    }
    
    /**
     * Construct an object using the given Book object.
     *
     * @param book - The specified Book object.
     */
    public BookEntity(Book book) {
        this(book.getItemCommonDetail(), book.getPublisher(), new BookPdfContent(book.getPdf()), book.getEdition(),
                book.getFormat(), book.getIsbn(), book.getLanguage(),
                new PublishDate(book.getPublishDate()), new BookWidth(book.getWidth()), new BookLength(book.getLength()),
                new BookThickness(book.getThickness()), book.getUom());
    }

    @Override
    public byte[] getPdf() {
        return pdfContent.getValue();
    }

    @Override
    public int getEdition() {
        return bookEdition;
    }

    @Override
    public BookFormat getFormat() {
        return format;
    }

    @Override
    public String getIsbn() {
        return bookIsbn;
    }

    @Override
    public LanguageCode getLanguage() {
        return language;
    }

    @Override
    public Date getPublishDate() {
        return publishDate.getValue();
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public BigDecimal getWidth() {
        return bookWidth.getValue();
    }

    @Override
    public BigDecimal getLength() {
        return bookLength.getValue();
    }

    @Override
    public BigDecimal getThickness() {
        return bookThickness.getValue();
    }

    @Override
    public UOM getUom() {
        return uom;
    }

    @Override
    public ItemCommonDetail getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 59 * hash + Objects.hashCode(this.publisher);
        hash = 59 * hash + this.bookEdition;
        hash = 59 * hash + Objects.hashCode(this.format);
        hash = 59 * hash + Objects.hashCode(this.bookIsbn);
        hash = 59 * hash + Objects.hashCode(this.language);
        hash = 59 * hash + Objects.hashCode(this.uom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final BookEntity other = (BookEntity) obj;

        if (this.bookEdition != other.bookEdition) {
            return false;
        }

        if (this.format != other.format) {
            return false;
        }

        if (this.language != other.language) {
            return false;
        }
        
        if (this.uom != other.uom) {
            return false;
        }
        
        if (!Objects.equals(this.bookIsbn, other.bookIsbn)) {
            return false;
        }

        if (!Objects.equals(this.publishDate, other.publishDate)) {
            return false;
        }

        if (!Objects.equals(this.bookWidth, other.bookWidth)) {
            return false;
        }

        if (!Objects.equals(this.bookLength, other.bookLength)) {
            return false;
        }

        if (!Objects.equals(this.bookThickness, other.bookThickness)) {
            return false;
        }

        if (!Objects.equals(this.pdfContent, other.pdfContent)) {
            return false;
        }
        
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        
        return Objects.equals(this.itemCommonDetail, other.itemCommonDetail);
    }

    @Override
    public String toString() {
        return "BookEntity{book name=" + getItemCommonDetail().getName() + ", publisher=" + getPublisher().getName() + '}';
    }

    @Override
    public boolean hasSameConstraint(Book book) {

        if (this == book) {
            return true;
        }

        if (book == null) {
            return false;
        }

        return Objects.equals(getIsbn(), book.getIsbn());
    }

    @Override
    public boolean hasSameParameters(Book book) {

        if (this == book) {
            return true;
        }

        if (book == null) {
            return false;
        }

        if (this.uom != book.getUom()) {
            return false;
        }

        if (this.format != book.getFormat()) {
            return false;
        }

        if (getEdition() != book.getEdition()) {
            return false;
        }

        if (this.language != book.getLanguage()) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(getPublishDate(), book.getPublishDate())) {
            return false;
        }

        if (!NumberUtilities.equals(getWidth(), book.getWidth())) {
            return false;
        }

        if (!NumberUtilities.equals(getLength(), book.getLength())) {
            return false;
        }

        if (!NumberUtilities.equals(getThickness(), book.getThickness())) {
            return false;
        }
        
        if (!Arrays.equals(getPdf(), book.getPdf())) {
            return false;
        }

        if (!Objects.equals(getIsbn(), book.getIsbn())) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(publisher, book.getPublisher()) && ConstrainableUtilities.hasSameParameters(itemCommonDetail, book.getItemCommonDetail());
    }
}
