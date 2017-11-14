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
package com.etlsolutions.examples.data.spi;

import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableBook;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The BookSpi interface defines an object which represents detailed information
 * about a book. The object will have methods to set its fields.
 *
 * @param <I> - The item common detail.
 * @param <P> - The concrete type of publisher objects.
 *
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public interface BookSpi<I extends ItemCommonDetail, P extends Publisher> extends IdentifiableBook, IdentifiableSpi {

    /**
     * Set the PDF content for this book.
     *
     * @param pdf - The PDF content in a byte array.
     */
    void setPdf(byte[] pdf);

    /**
     * Set the book edition.
     *
     * @param edition - The book edition number.
     */
    void setEdition(int edition);

    /**
     * Set the book format.
     * @param format - The BookFormat ojbect.
     */
    void setFormat(BookFormat format);

    /**
     * Set the ISBN number for this book.
     * @param isbn - The ISBN number in a string format.
     */
    void setIsbn(String isbn);

    /**
     * Set the language for this book.
     *
     * @param language - The language code.
     */
    void setLanguage(LanguageCode language);

    /**
     * Set the date when the book is published.
     * @param publishDate
     */
    void setPublishDate(Date publishDate);

    /**
     * Set the publisher of this book.
     * @param publisher - the Publisher object.
     */
    void setPublisher(P publisher);

    /**
     *
     * @param width
     */
    void setWidth(BigDecimal width);

    /**
     * Set the book length for this book.
     *
     * @param length - The specified length.
     */
    void setLength(BigDecimal length);

    /**
     *
     * @param thickness
     */
    void setThickness(BigDecimal thickness);

    /**
     * Set the unit of measurement for this book.
     *
     * @param uom - The UOM object.
     */
    void setUom(UOM uom);

    /**
     * Set the the common detail for this book.
     *
     * @param itemCommonDetail - The ItemCommonDetail object which contains the detail.
     */
    void setItemCommonDetail(I itemCommonDetail);
}
