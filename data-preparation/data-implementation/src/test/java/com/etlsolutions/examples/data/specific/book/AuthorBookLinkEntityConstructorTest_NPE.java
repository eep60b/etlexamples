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

import com.etlsolutions.examples.data.specific.book.AuthorBookLinkEntity;
import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.data.api.Book;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/**
 * Test of class AuthorBookLinkEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AuthorBookLinkEntityConstructorTest_NPE {

    private final Author author = Mockito.mock(Author.class);
    private final Book book = PowerMockito.mock(Book.class);

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_link() {
        new AuthorBookLinkEntity(null);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_author() {
        new AuthorBookLinkEntity(null, book);
    }

    /**
     * Test of constructor.
     */
    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void testConstructor_null_book() {
        new AuthorBookLinkEntity(author, null);
    }
}
