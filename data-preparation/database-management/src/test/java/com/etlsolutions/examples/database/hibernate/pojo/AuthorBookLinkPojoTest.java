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

import com.etlsolutions.examples.data.api.AuthorBookLink;
import com.etlsolutions.examples.data.api.BookFormat;
import com.etlsolutions.examples.data.api.LanguageCode;
import com.etlsolutions.examples.data.api.UOM;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class AuthorBookLinkPojo.
 *
 * @author Zhipeng Chang
 */
public class AuthorBookLinkPojoTest {

    private final AuthorPojo authorPojo = new AuthorPojo(147, new PersonalDetailPojo(384, "Mss.", "GGivvenNmm", "FFmmailinnnamme", new Date(13099134914912498L), new byte[]{8, 11, 67}), new byte[]{2}, new byte[]{7, 8, 9}, "webpage1");
    private final AuthorPojo authorPojo1 = Mockito.mock(AuthorPojo.class);
    private final BookPojo bookPojo = new BookPojo(1111, "113994338838211", new BigDecimal(22.65), new BigDecimal(22.15), new BigDecimal(26.65), UOM.IN, BookFormat.PAPERBACK, LanguageCode.EN);
    private final BookPojo bookPojo2 = Mockito.mock(BookPojo.class);
    private final AuthorBookLink authorBookLink = Mockito.mock(AuthorBookLink.class);

    private final AuthorBookLinkPojo instance = new AuthorBookLinkPojo(authorPojo, bookPojo);
    private final AuthorBookLinkPojo instance00 = new AuthorBookLinkPojo(authorPojo, bookPojo);
    private final AuthorBookLinkPojo instance01 = new AuthorBookLinkPojo(authorPojo1, bookPojo);
    private final AuthorBookLinkPojo instance03 = new AuthorBookLinkPojo();
    private final AuthorBookLinkPojo instance04 = new AuthorBookLinkPojo(null, null);
    private final AuthorBookLinkPojo instance05 = new HibernateProxyAuthorBookLinkPojo(new AuthorBookLinkPojo(authorPojo, bookPojo));

    @Before
    public void setUp() {

        Mockito.when(authorBookLink.getAuthor()).thenReturn(authorPojo);
        Mockito.when(authorBookLink.getBook()).thenReturn(bookPojo);
    }

    /**
     * Test of getAuthorId method.
     */
    @Test
    public void testGetAuthorId() {

        assertEquals(147, instance.getAuthorId());
        assertEquals(0, instance03.getAuthorId());
        assertEquals(0, instance04.getAuthorId());
        assertEquals(147, instance05.getAuthorId());
    }

    /**
     * Test of getBookId method.
     */
    @Test
    public void testGetBookId() {

        assertEquals(1111, instance.getBookId());
        assertEquals(0, instance03.getBookId());
        assertEquals(0, instance04.getBookId());
        assertEquals(1111, instance05.getBookId());
    }

    /**
     * Test of getAuthor method.
     */
    @Test
    public void testGetAuthor() {

        assertEquals(authorPojo, instance.getAuthor());
        assertNull(instance03.getAuthor());
        assertNull(instance04.getAuthor());
        assertEquals(authorPojo, instance05.getAuthor());
    }

    /**
     * Test of getBook method.
     */
    @Test
    public void testGetBook() {

        assertEquals(bookPojo, instance.getBook());
        assertNull(instance03.getBook());
        assertNull(instance04.getBook());
        assertEquals(bookPojo, instance05.getBook());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance05.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(authorBookLink));

        assertFalse(instance.hasSameConstraint(instance01));
        assertFalse(instance.hasSameConstraint(instance03));
        assertFalse(instance.hasSameConstraint(instance04));
        assertFalse(instance.hasSameConstraint(null));
    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance05.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(authorBookLink));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));

    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance05.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());

    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance05));
        assertTrue(instance05.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(authorBookLink));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance));
    }

    /**
     * This class provides the HibernateProxy instances for tests.
     */
    private final class HibernateProxyAuthorBookLinkPojo extends AuthorBookLinkPojo implements HibernateProxy {

        private static final long serialVersionUID = 8;
        private final AuthorBookLinkPojo pojo;

        public HibernateProxyAuthorBookLinkPojo(AuthorBookLinkPojo pojo) {

            super(authorPojo, bookPojo);
            this.pojo = pojo;
        }

        @Override
        public Object writeReplace() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public LazyInitializer getHibernateLazyInitializer() {

            return new AbstractMockLazyInitializer() {

                @Override
                public AuthorBookLinkPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
