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
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.data.constant.KeyNames;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.BookPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PublisherPojo;

/**
 * The BookProcessor class contains methods which process the operations
 * associated to BOOK table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BookProcessor extends AbstractIdentifiableEdentityProcessor<BookPojo, Book> {

    /**
     * Construct a BookProcessor object with the given BookshopFacade object.
     *
     * @param facade
     */
    public BookProcessor(BookshopFacade facade) {

        super(facade);
    }

    @Override
    public BookPojo retrieve(Book book) {

        return findConstraintableWithSameParameters(QueryNames.FIND_BOOK_BY_UNIQUE_CONSTRAINT, book, new StringKeyValuePair(KeyNames.BOOK_ISBN, book.getIsbn()));
    }

    @Override
    protected BookPojo doSave(Book book) {

        BookPojo pojo = retrieve(book);

        if (pojo == null) {

            PublisherPojo publisherPojo = new PublisherProcessor(facade).save(book.getPublisher());
            ItemCommonDetailPojo itemCommonDetailPojo = new ItemCommonDetailProcessor(facade).save(book.getItemCommonDetail());

            pojo = new BookPojo(publisherPojo, itemCommonDetailPojo, book.getIsbn(), book.getPdf(), book.getEdition(), book.getPublishDate(), book.getWidth(), book.getLength(), book.getThickness(), book.getUom(), book.getFormat(), book.getLanguage());
        }

        return pojo;
    }
}
