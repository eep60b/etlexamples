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
package com.etlsolutions.examples.data.api;

import com.etlsolutions.examples.data.general.Constrainable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The Book interface defines a object which represents detailed information
 * about a book.
 *
 * @author Zhipeng Chang
 *
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface Book extends SuperBook, Constrainable<Book> {

    /**
     * Get the PDF content of this book.
     *
     * @return the PDF content object.
     */
    byte[] getPdf();

    /**
     * Get the book edition.
     *
     * @return the book edition.
     */
    int getEdition();

    /**
     * Get the book format information.
     *
     * @return the book format type.
     */
    BookFormat getFormat();

    /**
     * Get the book ISBN number.
     *
     * @return the book ISBN number.
     */
    String getIsbn();

    /**
     * Get the language which this book is written in.
     *
     * @return the language code.
     */
    LanguageCode getLanguage();

    /**
     * Get the publish date of this book.
     *
     * @return the publish date.
     */
    Date getPublishDate();

    /**
     * Get the book publisher.
     *
     * @return the book publisher.
     */
    Publisher getPublisher();

    /**
     * Get the width of this book.
     *
     * @return the width.
     */
    BigDecimal getWidth();

    /**
     * Get the length of this book.
     *
     * @return the length.
     */
    BigDecimal getLength();

    /**
     * Get the thickness of this book.
     *
     * @return the thickness.
     */
    BigDecimal getThickness();

    /**
     * Get the unit name which is used to measure the width, length and
     * thickness.
     *
     * @return the unit of measurement.
     */
    UOM getUom();

    /**
     * Get the common detail of this book.
     *
     * @return the ItemCommonDetail object which contains the common detail.
     */
    ItemCommonDetail getItemCommonDetail();
}
