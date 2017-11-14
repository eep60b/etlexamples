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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class AuthorBookLinkEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AuthorBookLinkEntity.class, AuthorEntity.class, BookEntity.class})
public final class AuthorBookLinkEntityTest {

    private final Author author = Mockito.mock(Author.class);
    private final AuthorEntity authorEntity = PowerMockito.mock(AuthorEntity.class);
    private final AuthorEntity authorEntity1 = PowerMockito.mock(AuthorEntity.class);
    private final Book book = PowerMockito.mock(Book.class);
    private final BookEntity bookEntity = PowerMockito.mock(BookEntity.class);
    private final BookEntity bookEntity2 = PowerMockito.mock(BookEntity.class);

    private final AuthorBookLink link = Mockito.mock(AuthorBookLink.class);

    private final AuthorBookLinkEntity instance = new AuthorBookLinkEntity(authorEntity, bookEntity);
    private final AuthorBookLinkEntity instance00 = new AuthorBookLinkEntity(authorEntity, bookEntity);
    private final AuthorBookLinkEntity instance01 = new AuthorBookLinkEntity(authorEntity1, bookEntity);
    private final AuthorBookLinkEntity instance02 = new AuthorBookLinkEntity(authorEntity, bookEntity2);
    private AuthorBookLinkEntity instance03;
    private AuthorBookLinkEntity instance04;

    @Before
    public void setUp() throws Exception {

        Mockito.when(link.getAuthor()).thenReturn(authorEntity);
        Mockito.when(link.getBook()).thenReturn(bookEntity);

        PowerMockito.whenNew(AuthorEntity.class).withArguments(author).thenReturn(authorEntity);
        PowerMockito.whenNew(BookEntity.class).withArguments(book).thenReturn(bookEntity);

        instance03 = new AuthorBookLinkEntity(author, book);
        instance04 = new AuthorBookLinkEntity(link);
    }

    /**
     * Test of getAuthor method.
     */
    @Test
    public void testGetAuthor() {

        assertEquals(authorEntity, instance.getAuthor());
        assertEquals(authorEntity, instance03.getAuthor());
        assertEquals(authorEntity, instance04.getAuthor());
    }

    /**
     * Test of getBook method.
     */
    @Test
    public void testGetBook() {

        assertEquals(bookEntity, instance.getBook());
        assertEquals(bookEntity, instance03.getBook());
        assertEquals(bookEntity, instance04.getBook());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
                assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(link));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance03));
        assertTrue(instance.hasSameParameters(instance04));
        assertTrue(instance.hasSameParameters(link));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance04.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance03));
        assertTrue(instance.equals(instance04));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }
}
