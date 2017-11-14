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
// Generated 19-Nov-2015 11:29:31 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.data.spi.BookSpi;
import com.etlsolutions.examples.utility.CalendarUtilities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;

/**
 * The BookPojo class is generated automatically then modified manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.0.1 - Use generic types.
 * @version 1.0.2 - Add a non-set-constructor.
 * @version 1.1.0 - Add equals and hashCode methods.
 * @version 1.1.1 - Change the field name form "bookId" to "id".
 * @version 1.1.2 - Set the initial capacities for the set fields.
 */
public class BookPojo implements Serializable, BookSpi<ItemCommonDetailPojo, PublisherPojo> {

    private static final long serialVersionUID = 847192276211327303L;

    private int id;
    private PublisherPojo publisher;
    private ItemCommonDetailPojo itemCommonDetail;
    private String isbn;
    private byte[] pdf;
    private int edition;
    private Date publishDate;
    private BigDecimal width;
    private BigDecimal length;
    private BigDecimal thickness;
    private UOM uom;
    private BookFormat format;
    private LanguageCode language;
    private Set<Author> authors = new HashSet<>(3);

    /**
     * Construct an empty default object. All integer fields are zero. all the
     * collection fields will be empty. All other fields are null.
     */
    public BookPojo() {
    }

    /**
     * Construct an object with the compulsory fields initialised.
     *
     * @param isbn - The ISBN number.
     * @param width - The book width.
     * @param length - The book length.
     * @param thickness - The book thickness.
     * @param uom - The unit of measurement for width, length and thickness.
     * @param format - The physical format of the book.
     * @param language - The language used to write the book.
     */
    public BookPojo(String isbn, BigDecimal width, BigDecimal length, BigDecimal thickness, UOM uom, BookFormat format, LanguageCode language) {

        this.isbn = isbn;
        this.width = width;
        this.length = length;
        this.thickness = thickness;
        this.uom = uom;
        this.format = format;
        this.language = language;
    }

    /**
     *
     * @param id
     * @param isbn
     * @param width
     * @param length
     * @param thickness
     * @param uom
     * @param format
     * @param language
     */
    public BookPojo(int id, String isbn, BigDecimal width, BigDecimal length, BigDecimal thickness, UOM uom, BookFormat format, LanguageCode language) {
        this(isbn, width, length, thickness, uom, format, language);
        this.id = id;
    }

    /**
     * Construct an object with all parameters initialised apart from ID and the
     * author set.
     *
     * @param publisher - The publisher information.
     * @param itemCommonDetail
     * @param bookIsbn
     * @param pdf
     * @param edition
     * @param publishDate
     * @param bookWidth
     * @param bookLength
     * @param bookThickness
     * @param uom
     * @param format
     * @param language
     */
    public BookPojo(PublisherPojo publisher, ItemCommonDetailPojo itemCommonDetail, String bookIsbn, byte[] pdf, int edition,
            Date publishDate, BigDecimal bookWidth, BigDecimal bookLength, BigDecimal bookThickness, UOM uom,
            BookFormat format, LanguageCode language) {

        this(bookIsbn, bookWidth, bookLength, bookThickness, uom, format, language);

        this.publisher = publisher;
        this.itemCommonDetail = itemCommonDetail;
        this.pdf = pdf == null ? null : Arrays.copyOf(pdf, pdf.length);
        this.edition = edition;
        this.publishDate = publishDate == null ? null : new Date(publishDate.getTime());
    }

    /**
     *
     * @param id
     * @param publisher
     * @param itemCommonDetail
     * @param bookIsbn
     * @param bookPdfContent
     * @param bookEdition
     * @param publishDate
     * @param bookWidth
     * @param bookLength
     * @param bookThickness
     * @param uom
     * @param format
     * @param language
     */
    public BookPojo(int id, PublisherPojo publisher, ItemCommonDetailPojo itemCommonDetail, String bookIsbn, byte[] bookPdfContent, int bookEdition,
            Date publishDate, BigDecimal bookWidth, BigDecimal bookLength, BigDecimal bookThickness, UOM uom,
            BookFormat format, LanguageCode language) {

        this(publisher, itemCommonDetail, bookIsbn, bookPdfContent, bookEdition, publishDate, bookWidth, bookLength, bookThickness, uom, format, language);
        this.id = id;
    }

    /**
     * Construct an object with all fields initialised.
     *
     * @param id
     * @param publisher
     * @param itemCommonDetail
     * @param bookIsbn
     * @param bookPdfContent
     * @param bookEdition
     * @param publishDate
     * @param bookWidth
     * @param bookLength
     * @param bookThickness
     * @param demensionUnit
     * @param bookFormat
     * @param bookLanguage
     * @param authors
     */
    public BookPojo(int id, PublisherPojo publisher, ItemCommonDetailPojo itemCommonDetail, String bookIsbn, byte[] bookPdfContent, int bookEdition, Date publishDate, BigDecimal bookWidth, BigDecimal bookLength,
            BigDecimal bookThickness, UOM demensionUnit, BookFormat bookFormat, LanguageCode bookLanguage, Set<Author> authors) {

        this(id, publisher, itemCommonDetail, bookIsbn, bookPdfContent, bookEdition, publishDate, bookWidth, bookLength, bookThickness, demensionUnit, bookFormat, bookLanguage);

        this.authors = authors == null ? null : new HashSet<>(authors);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public PublisherPojo getPublisher() {
        return this.publisher;
    }

    @Override
    public void setPublisher(PublisherPojo publisher) {
        this.publisher = publisher;
    }

    @Override
    public ItemCommonDetailPojo getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public void setItemCommonDetail(ItemCommonDetailPojo itemCommonDetail) {
        this.itemCommonDetail = itemCommonDetail;
    }

    @Override
    public String getIsbn() {
        return this.isbn;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public byte[] getPdf() {
        return pdf == null ? null : Arrays.copyOf(pdf, pdf.length);
    }

    @Override
    public void setPdf(byte[] pdf) {
        this.pdf = pdf == null ? null : Arrays.copyOf(pdf, pdf.length);
    }

    @Override
    public int getEdition() {
        return this.edition;
    }

    @Override
    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public Date getPublishDate() {
        return publishDate == null ? null : new Date(publishDate.getTime());
    }

    @Override
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate == null ? null : new Date(publishDate.getTime());
    }

    @Override
    public BigDecimal getWidth() {
        return width;
    }

    @Override
    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    @Override
    public BigDecimal getLength() {
        return length;
    }

    @Override
    public void setLength(BigDecimal length) {
        this.length = length;
    }

    @Override
    public BigDecimal getThickness() {
        return thickness;
    }

    @Override
    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    @Override
    public UOM getUom() {
        return uom;
    }

    @Override
    public void setUom(UOM uom) {
        this.uom = uom;
    }

    @Override
    public BookFormat getFormat() {
        return this.format;
    }

    @Override
    public void setFormat(BookFormat format) {
        this.format = format;
    }

    @Override
    public LanguageCode getLanguage() {
        return this.language;
    }

    @Override
    public void setLanguage(LanguageCode language) {
        this.language = language;
    }

    public Set<Author> getAuthors() {
        return authors == null ? null : new HashSet<>(authors);
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors == null ? null : new HashSet<>(authors);
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 7;
        hash = 59 * hash + this.getId();
        hash = 59 * hash + Objects.hashCode(this.publisher);
        hash = 59 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 59 * hash + Objects.hashCode(this.isbn);
        hash = 59 * hash + this.edition;
        hash = 59 * hash + Objects.hashCode(this.uom);
        hash = 59 * hash + Objects.hashCode(this.format);
        hash = 59 * hash + Objects.hashCode(this.language);
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

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if (obj instanceof HibernateProxy) {
            return equals(((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation());
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final BookPojo other = (BookPojo) obj;
        if (this.getId() != other.getId()) {
            return false;
        }

        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }

        if (!Objects.equals(this.itemCommonDetail, other.itemCommonDetail)) {
            return false;
        }

        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }

        if (!Arrays.equals(this.pdf, other.pdf)) {
            return false;
        }

        if (this.edition != other.edition) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(this.publishDate, other.publishDate)) {
            return false;
        }

        if (!Objects.equals(this.width, other.width)) {
            return false;
        }

        if (!Objects.equals(this.length, other.length)) {
            return false;
        }

        if (!Objects.equals(this.thickness, other.thickness)) {
            return false;
        }

        if (this.uom != other.uom) {
            return false;
        }
        if (this.format != other.format) {
            return false;
        }

        return this.language == other.language;
    }

    @Override
    public boolean hasSameConstraint(Book book) {

        if (this == book) {
            return true;
        }

        if (book == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return book.hasSameConstraint(((Book) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (book instanceof HibernateProxy) {
            return hasSameConstraint(((Book) (((HibernateProxy) book).getHibernateLazyInitializer().getImplementation())));
        }

        return Objects.deepEquals(isbn, book.getIsbn());
    }

    @Override
    public boolean hasSameParameters(Book book) {

        if (this == book) {
            return true;
        }

        if (book == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return book.hasSameParameters(((Book) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (book instanceof HibernateProxy) {
            return hasSameParameters(((Book) (((HibernateProxy) book).getHibernateLazyInitializer().getImplementation())));
        }

        if (!ConstrainableUtilities.hasSameParameters(publisher, book.getPublisher())) {
            return false;
        }

        if (!ConstrainableUtilities.hasSameParameters(itemCommonDetail, book.getItemCommonDetail())) {
            return false;
        }

        if (!Arrays.equals(this.pdf, book.getPdf())) {
            return false;
        }

        if (this.edition != book.getEdition()) {
            return false;
        }

        if (!CalendarUtilities.areSameDates(this.publishDate, book.getPublishDate())) {
            return false;
        }

        if (!Objects.equals(this.width, book.getWidth())) {
            return false;
        }

        if (!Objects.equals(this.length, book.getLength())) {
            return false;
        }

        if (!Objects.equals(this.thickness, book.getThickness())) {
            return false;
        }

        if (this.uom != book.getUom()) {
            return false;
        }
        if (this.format != book.getFormat()) {
            return false;
        }

        if (this.language != book.getLanguage()) {
            return false;
        }

        return Objects.deepEquals(isbn, book.getIsbn());
    }

    @Override
    public String toString() {
        return "BookPojo{" + "id=" + id + ", isbn=" + isbn + '}';
    }
}
