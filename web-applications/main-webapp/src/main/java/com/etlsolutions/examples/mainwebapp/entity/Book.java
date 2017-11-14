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
package com.etlsolutions.examples.mainwebapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zhipeng
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByBookIsbn", query = "SELECT b FROM Book b WHERE b.bookIsbn = :bookIsbn"),
    @NamedQuery(name = "Book.findByBookEdition", query = "SELECT b FROM Book b WHERE b.bookEdition = :bookEdition"),
    @NamedQuery(name = "Book.findByPublishDate", query = "SELECT b FROM Book b WHERE b.publishDate = :publishDate"),
    @NamedQuery(name = "Book.findByBookWidth", query = "SELECT b FROM Book b WHERE b.bookWidth = :bookWidth"),
    @NamedQuery(name = "Book.findByBookLength", query = "SELECT b FROM Book b WHERE b.bookLength = :bookLength"),
    @NamedQuery(name = "Book.findByBookThickness", query = "SELECT b FROM Book b WHERE b.bookThickness = :bookThickness"),
    @NamedQuery(name = "Book.findByDimensionUnit", query = "SELECT b FROM Book b WHERE b.dimensionUnit = :dimensionUnit"),
    @NamedQuery(name = "Book.findByBookFormat", query = "SELECT b FROM Book b WHERE b.bookFormat = :bookFormat"),
    @NamedQuery(name = "Book.findByBookLanguage", query = "SELECT b FROM Book b WHERE b.bookLanguage = :bookLanguage")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Basic(optional = false)
    @Column(name = "book_isbn")
    private String bookIsbn;
    @Lob
    @Column(name = "book_pdf_content")
    private byte[] bookPdfContent;
    @Basic(optional = false)
    @Column(name = "book_edition")
    private int bookEdition;
    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "book_width")
    private BigDecimal bookWidth;
    @Column(name = "book_length")
    private BigDecimal bookLength;
    @Column(name = "book_thickness")
    private BigDecimal bookThickness;
    @Basic(optional = false)
    @Column(name = "dimension_unit")
    private String dimensionUnit;
    @Basic(optional = false)
    @Column(name = "book_format")
    private String bookFormat;
    @Basic(optional = false)
    @Column(name = "book_language")
    private String bookLanguage;
    @ManyToMany(mappedBy = "bookCollection")
    private Collection<Author> authorCollection;
    @JoinColumn(name = "item_common_detail_id", referencedColumnName = "item_common_detail_id")
    @OneToOne
    private ItemCommonDetail itemCommonDetailId;
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    @ManyToOne
    private Publisher publisherId;

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId, String bookIsbn, int bookEdition, String dimensionUnit, String bookFormat, String bookLanguage) {
        this.bookId = bookId;
        this.bookIsbn = bookIsbn;
        this.bookEdition = bookEdition;
        this.dimensionUnit = dimensionUnit;
        this.bookFormat = bookFormat;
        this.bookLanguage = bookLanguage;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public byte[] getBookPdfContent() {
        return bookPdfContent;
    }

    public void setBookPdfContent(byte[] bookPdfContent) {
        this.bookPdfContent = bookPdfContent;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BigDecimal getBookWidth() {
        return bookWidth;
    }

    public void setBookWidth(BigDecimal bookWidth) {
        this.bookWidth = bookWidth;
    }

    public BigDecimal getBookLength() {
        return bookLength;
    }

    public void setBookLength(BigDecimal bookLength) {
        this.bookLength = bookLength;
    }

    public BigDecimal getBookThickness() {
        return bookThickness;
    }

    public void setBookThickness(BigDecimal bookThickness) {
        this.bookThickness = bookThickness;
    }

    public String getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(String dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public String getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(String bookFormat) {
        this.bookFormat = bookFormat;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    @XmlTransient
    public Collection<Author> getAuthorCollection() {
        return authorCollection;
    }

    public void setAuthorCollection(Collection<Author> authorCollection) {
        this.authorCollection = authorCollection;
    }

    public ItemCommonDetail getItemCommonDetailId() {
        return itemCommonDetailId;
    }

    public void setItemCommonDetailId(ItemCommonDetail itemCommonDetailId) {
        this.itemCommonDetailId = itemCommonDetailId;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.Book[ bookId=" + bookId + " ]";
    }
    
}
