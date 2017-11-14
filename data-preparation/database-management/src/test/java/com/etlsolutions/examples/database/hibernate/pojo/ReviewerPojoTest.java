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

import com.etlsolutions.examples.data.api.Review;
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class ReviewerPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ReviewerPojoTest {

    private final int id = 129090;
    private final int id1 = 872391;
    private final PersonalDetailPojo personalDetailPojo = Mockito.mock(PersonalDetailPojo.class);
    private final PersonalDetailPojo personalDetailPojo2 = Mockito.mock(PersonalDetailPojo.class);
    private final byte[] image = {92, 18, 27, 45, 33, 90};
    private final byte[] image3 = {77, 42, 78, 22};
    private final String username = "oafnkkal";
    private final String username4 = "lasn4lda";
    private final String password = "9q34oldq!£!£";
    private final String password5 = "lfdj$£AAa";

    private final ReviewPojo reviewPojo1 = Mockito.mock(ReviewPojo.class);
    private final ReviewPojo reviewPojo2 = Mockito.mock(ReviewPojo.class);
    private final ReviewPojo reviewPojo3 = Mockito.mock(ReviewPojo.class);
    private final ReviewPojo reviewPojo4 = Mockito.mock(ReviewPojo.class);
    private final Set<Review> reviewPojos = new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3));
    private final Set<Review> reviewPojos6 = new HashSet<>(Arrays.asList(reviewPojo4, reviewPojo3));
    private final Set<Review> reviewPojos7 = null;
    private final Reviewer reveiwer = Mockito.mock(Reviewer.class);

    private final ReviewerPojo instance = new ReviewerPojo(id, personalDetailPojo, image, username, password, reviewPojos);
    private final ReviewerPojo instance00 = new ReviewerPojo(id, personalDetailPojo, image, username, password, reviewPojos);
    private final ReviewerPojo instance01 = new ReviewerPojo(id1, personalDetailPojo, image, username, password, reviewPojos);
    private final ReviewerPojo instance02 = new ReviewerPojo(id, personalDetailPojo2, image, username, password, reviewPojos);
    private final ReviewerPojo instance03 = new ReviewerPojo(id, personalDetailPojo, image3, username, password, reviewPojos);
    private final ReviewerPojo instance04 = new ReviewerPojo(id, personalDetailPojo, image, username4, password, reviewPojos);
    private final ReviewerPojo instance05 = new ReviewerPojo(id, personalDetailPojo, image, username, password5, reviewPojos);
    private final ReviewerPojo instance06 = new ReviewerPojo(id, personalDetailPojo, image, username, password, reviewPojos6);
    private final ReviewerPojo instance07 = new ReviewerPojo(id, personalDetailPojo, image, username, password, reviewPojos7);
    private final ReviewerPojo instance08 = new ReviewerPojo();
    private final ReviewerPojo instance09 = new ReviewerPojo(id, username, password);
    private final ReviewerPojo instance10 = new ReviewerPojo(personalDetailPojo, image, username, password);
    private final ReviewerPojo instance11 = new ReviewerPojo(id, personalDetailPojo, image, username, password);
    private final ReviewerPojo instance12 = new HibernateProxyReviewerPojo(instance);
    private final ReviewerPojo instance13 = new ReviewerPojo(id, new PersonalDetailPojo(), image, username, password);

    @Before
    public void setUp() {

        Mockito.when(reveiwer.getImage()).thenReturn(image);
        Mockito.when(reveiwer.getPassword()).thenReturn(password);
        Mockito.when(reveiwer.getPersonalDetail()).thenReturn(personalDetailPojo);
        Mockito.when(reveiwer.getUsername()).thenReturn(username);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(129090, instance.getId());
        assertEquals(0, instance08.getId());
        assertEquals(129090, instance09.getId());
        assertEquals(0, instance10.getId());
        assertEquals(129090, instance11.getId());
        assertEquals(0, instance12.getId());

    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(8934019);
        assertEquals(8934019, instance.getId());
    }

    /**
     * Test of getPersonalDetail method.
     */
    @Test
    public void testGetPersonalDetail() {

        assertEquals(personalDetailPojo, instance.getPersonalDetail());
        assertNull(instance08.getPersonalDetail());
        assertNull(instance09.getPersonalDetail());
        assertEquals(personalDetailPojo, instance10.getPersonalDetail());
        assertEquals(personalDetailPojo, instance11.getPersonalDetail());
        assertNull(instance12.getPersonalDetail());
    }

    /**
     * Test of setPersonalDetail method.
     */
    @Test
    public void testSetPersonalDetail() {

        PersonalDetailPojo personalDetailPojo1 = Mockito.mock(PersonalDetailPojo.class);
        instance.setPersonalDetail(personalDetailPojo1);
        assertEquals(personalDetailPojo1, instance.getPersonalDetail());
    }

    /**
     * Test of getImage method.
     */
    @Test
    public void testGetImage() {

        assertArrayEquals(new byte[]{92, 18, 27, 45, 33, 90}, instance.getImage());
        instance.getImage()[0] = 1;
        assertArrayEquals(new byte[]{92, 18, 27, 45, 33, 90}, instance.getImage());
        image[1] = 3;
        assertArrayEquals(new byte[]{92, 18, 27, 45, 33, 90}, instance.getImage());

        assertNull(instance08.getImage());
        assertNull(instance09.getImage());
        assertArrayEquals(new byte[]{92, 18, 27, 45, 33, 90}, instance10.getImage());
        assertArrayEquals(new byte[]{92, 18, 27, 45, 33, 90}, instance11.getImage());
        assertNull(instance12.getImage());
    }

    /**
     * Test of setImage method.
     */
    @Test
    public void testSetImage() {

        byte[] imageF = {84, 35, 22};
        instance.setImage(imageF);
        assertArrayEquals(new byte[]{84, 35, 22}, instance.getImage());

        imageF[0] = 0;
        assertArrayEquals(new byte[]{84, 35, 22}, instance.getImage());
    }

    /**
     * Test of getUsername method.
     */
    @Test
    public void testGetUsername() {

        assertEquals(username, instance.getUsername());
        assertNull(instance08.getUsername());
        assertEquals(username, instance09.getUsername());
        assertEquals(username, instance10.getUsername());
        assertEquals(username, instance11.getUsername());
        assertNull(instance12.getUsername());
    }

    /**
     * Test of setUsername method.
     */
    @Test
    public void testSetUsername() {

        instance.setUsername("setUsername");
        assertEquals("setUsername", instance.getUsername());
    }

    /**
     * Test of getPassword method.
     */
    @Test
    public void testGetPassword() {

        assertEquals("9q34oldq!£!£", instance.getPassword());
        assertNull(instance08.getPassword());
        assertEquals("9q34oldq!£!£", instance09.getPassword());
        assertEquals("9q34oldq!£!£", instance10.getPassword());
        assertNull(instance12.getPassword());
    }

    /**
     * Test of setPassword method.
     */
    @Test
    public void testSetPassword() {

        instance.setPassword("lkdnakekelad2");
        assertEquals("lkdnakekelad2", instance.getPassword());
    }

    /**
     * Test of getReviews method.
     */
    @Test
    public void testGetReviews() {

        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3)), instance.getReviews());
        instance.getReviews().remove(reviewPojo1);
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3)), instance.getReviews());
        reviewPojos.clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo2, reviewPojo3)), instance.getReviews());

        assertNull(instance07.getReviews());
        assertTrue(instance08.getReviews().isEmpty());
        assertTrue(instance09.getReviews().isEmpty());
        assertEquals(reviewPojos, instance10.getReviews());
        assertTrue(instance09.getReviews().isEmpty());
    }

    /**
     * Test of setReviews method.
     */
    @Test
    public void testSetReviews() {

        Set<Review> reviews = new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo4));
        instance.setReviews(reviews);
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo4)), instance.getReviews());
        reviews.clear();
        assertEquals(new HashSet<>(Arrays.asList(reviewPojo1, reviewPojo4)), instance.getReviews());

        instance.setReviews(null);
        assertNull(instance.getReviews());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance12));
        assertTrue(instance12.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(reveiwer));

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
        assertTrue(instance.hasSameParameters(instance01));        
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(instance12));
        assertTrue(instance12.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(reveiwer));

        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(instance05));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());
        assertEquals(instance03.hashCode(), instance.hashCode());
        assertEquals(instance06.hashCode(), instance.hashCode());
        assertEquals(instance12.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance04.hashCode(), instance.hashCode());
        assertNotEquals(instance05.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));
        assertTrue(instance.equals(instance06));
        assertTrue(instance.equals(instance12));
        assertTrue(instance12.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(reveiwer));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of serialisation.
     */
    @Test
    public void testSerialisation() {

        assertTrue(SerialisationUtilities.isSerializable(instance13));
    }

    private final class HibernateProxyReviewerPojo extends ReviewerPojo implements HibernateProxy {

        private static final long serialVersionUID = 202910644784275747L;

        private final ReviewerPojo pojo;

        public HibernateProxyReviewerPojo(ReviewerPojo pojo) {

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
                public ReviewerPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
