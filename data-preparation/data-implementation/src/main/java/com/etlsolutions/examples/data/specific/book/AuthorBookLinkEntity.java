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

import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.AuthorBookLink;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.specific.person.AuthorEntity;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import java.util.Objects;

/**
 * The AuthorBookLinkEntity class represent an entry for the AUTHOR_BOOK_LINK
 * table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AuthorBookLinkEntity implements AuthorBookLink {

    private final AuthorEntity author;
    private final BookEntity book;

    /**
     * Construct an object using information in the given AuthorBookLink object.
     *
     * @param link - The given AuthorBookLink object.
     *
     * @throws NullPointerException if the given link object is null or one of
     * its parameters is null.
     */
    public AuthorBookLinkEntity(AuthorBookLink link) {
        this(link.getAuthor(), link.getBook());
    }

    /**
     * Construct an object using the given Author and Book objects.
     * @param author - The specified Author object.
     * @param book - The specified Book object.
     *
     * @throws NullPointerException if either parameter is null.
     */
    public AuthorBookLinkEntity(Author author, Book book) {
        this.author = author instanceof AuthorEntity ? (AuthorEntity) author : new AuthorEntity(author);
        this.book = book instanceof BookEntity ? (BookEntity) book : new BookEntity(book);
    }

    @Override
    public AuthorEntity getAuthor() {
        return author;
    }

    @Override
    public BookEntity getBook() {
        return book;
    }

    @Override
    public boolean hasSameConstraint(AuthorBookLink authorBookLink) {

        if (this == authorBookLink) {
            return true;
        }
        
        if(authorBookLink == null) {
            return false;
        }
        
        return ConstrainableUtilities.hasSameConstraint(author, authorBookLink.getAuthor()) && ConstrainableUtilities.hasSameConstraint(book, authorBookLink.getBook());
    }

    @Override
    public boolean hasSameParameters(AuthorBookLink authorBookLink) {
        
        
        if (this == authorBookLink) {
            return true;
        }
        
        if(authorBookLink == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameParameters(author, authorBookLink.getAuthor()) && ConstrainableUtilities.hasSameParameters(book, authorBookLink.getBook());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.author);
        hash = 23 * hash + Objects.hashCode(this.book);
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

        final AuthorBookLinkEntity other = (AuthorBookLinkEntity) obj;

        if (!Objects.equals(this.author, other.author)) {
            return false;
        }

        return Objects.equals(this.book, other.book);
    }

    @Override
    public String toString() {
        return "AuthorBookLinkEntity{author=" + author + ", book=" + book + '}';
    }
}
