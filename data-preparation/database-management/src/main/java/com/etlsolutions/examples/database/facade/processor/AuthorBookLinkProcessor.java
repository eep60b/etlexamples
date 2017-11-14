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
import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.AuthorBookLink;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAuthorBookLink;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AuthorBookLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.AuthorPojo;
import com.etlsolutions.examples.database.hibernate.pojo.BookPojo;
import java.util.Set;

/**
 * The AuthorBookLinkProcessor class contains methods which process operations
 * associated to the AUTHOR_BOOK_LINK table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AuthorBookLinkProcessor extends AbstractProcessor<AuthorBookLink> {

    private final AuthorProcessor authorProcessor;
    private final BookProcessor bookProcessor;

    /**
     * Construct an AuthorBookLinkProcessor object with the given BookshopFacade
     * object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public AuthorBookLinkProcessor(BookshopFacade facade) {
        super(facade);
        authorProcessor = new AuthorProcessor(facade);
        bookProcessor = new BookProcessor(facade);
    }

    /**
     * Save the parameters in the given AuthorBookLink object to an entry into
     * the author_book_link table in the database.
     *
     * @param link - The given AuthorBookLink object.
     * @return an identifiable object which represents the saved entry. This
     * method will NOT return null. If the parameters cannot be saved, an
     * exception will be thrown.
     * @throws NullPointerException if the given object is null or its
     * authorPojo or bookPojo property is null.
     * @throws IllegalStateException if an error occurs.
     */
    @Override
    public IdentifiableAuthorBookLink save(AuthorBookLink link) {

        AuthorBookLinkPojo linkPojo = retrieve(link);

        if (linkPojo == null) {

            AuthorPojo author = authorProcessor.save(link.getAuthor());
            BookPojo book = bookProcessor.save(link.getBook());

            Set<Book> books = author.getBooks();
            books.add(book);            
            author.setBooks(books);
            
            Set<Author> authors = book.getAuthors();
            authors.add(author);
            book.setAuthors(authors);
            
            facade.update(author, book);
            
            linkPojo = new AuthorBookLinkPojo(author, book);
        }

        return linkPojo;
    }

    /**
     * Retrieve an entry from the author_book_link table in the database used
     * the parameter in the given AuthorBookLink object.
     *
     * @param link - The given AuthorBookLink object.
     * @return an AuthorBookLinkPojo object or null if there is no such an
     * entry.
     *
     * @throws NullPointerException if the given object is null or its
     * authorPojo or bookPojo property is null.
     */
    @Override
    public AuthorBookLinkPojo retrieve(AuthorBookLink link) {

        AuthorPojo authorPojo = authorProcessor.retrieve(link.getAuthor());
        BookPojo bookPojo = bookProcessor.retrieve(link.getBook());

        if (authorPojo == null || bookPojo == null) {
            return null;
        }

        if (facade.retrieveList(QueryNames.SELECT_FROM_AUTHOR_BOOK_LINK,
                new StringKeyValuePair(KeyNames.AUTHOR_BOOK_LINK_AUTHOR_ID, authorPojo.getId()),
                new StringKeyValuePair(KeyNames.AUTHOR_BOOK_LINK_BOOK_ID, bookPojo.getId())).isEmpty()) {
            return null;
        }

        return new AuthorBookLinkPojo(authorPojo, bookPojo);
    }
}
