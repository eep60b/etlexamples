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
package com.etlsolutions.examples.data.specific.item;

import com.etlsolutions.examples.data.specific.item.ReviewText;
import com.etlsolutions.examples.data.specific.item.ReviewRanking;
import com.etlsolutions.examples.data.specific.item.ReviewEntity;
import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.Review;
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.person.ReviewerEntity;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class ReviewEntity.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @author 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ReviewEntity.class, ItemCommonDetailEntity.class, ReviewerEntity.class})
public final class ReviewEntityTest {

    private final ItemCommonDetailEntity itemCommonDetailEntity = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ItemCommonDetailEntity itemCommonDetailEntity1 = PowerMockito.mock(ItemCommonDetailEntity.class);
    private final ReviewRanking reviewRanking = new ReviewRanking(23141);
    private final ReviewRanking reviewRanking2 = new ReviewRanking(91435);
    private final ReviewText reviewText = new ReviewText("afdai adll afdkala lafla");
    private final ReviewText reviewText3 = new ReviewText("la l alfa lqerlq req");
    private final ReviewerEntity reviewerEntity = PowerMockito.mock(ReviewerEntity.class);
    private final ReviewerEntity reviewerEntity4 = PowerMockito.mock(ReviewerEntity.class);
    private final ItemCommonDetail itemCommonDetail = Mockito.mock(ItemCommonDetail.class);
    private final Reviewer reviewer = Mockito.mock(Reviewer.class);
    private final Review review = Mockito.mock(Review.class);

    private final ReviewEntity instance = new ReviewEntity(itemCommonDetailEntity, reviewRanking, reviewText, reviewerEntity);
    private final ReviewEntity instance00 = new ReviewEntity(itemCommonDetailEntity, reviewRanking, reviewText, reviewerEntity);
    private final ReviewEntity instance01 = new ReviewEntity(itemCommonDetailEntity1, reviewRanking, reviewText, reviewerEntity);
    private final ReviewEntity instance02 = new ReviewEntity(itemCommonDetailEntity, reviewRanking2, reviewText, reviewerEntity);
    private final ReviewEntity instance03 = new ReviewEntity(itemCommonDetailEntity, reviewRanking, reviewText3, reviewerEntity);
    private final ReviewEntity instance04 = new ReviewEntity(itemCommonDetailEntity, reviewRanking, reviewText, reviewerEntity4);
    private ReviewEntity instance05;
    private ReviewEntity instance06;
    private ReviewEntity instance07;

    @Before
    public void setUp() throws Exception {

        Mockito.when(review.getItemCommonDetail()).thenReturn(itemCommonDetailEntity);
        Mockito.when(review.getReviewer()).thenReturn(reviewerEntity);
        Mockito.when(review.getReviewRanking()).thenReturn(23141);
        Mockito.when(review.getReviewText()).thenReturn("afdai adll afdkala lafla");

        PowerMockito.whenNew(ItemCommonDetailEntity.class).withArguments(itemCommonDetail).thenReturn(itemCommonDetailEntity);
        PowerMockito.whenNew(ReviewerEntity.class).withArguments(reviewer).thenReturn(reviewerEntity);

        Mockito.when(itemCommonDetailEntity.hasSameConstraint(itemCommonDetailEntity)).thenReturn(Boolean.TRUE);
        Mockito.when(itemCommonDetailEntity.hasSameConstraint(itemCommonDetail)).thenReturn(Boolean.TRUE);
        
        Mockito.when(itemCommonDetailEntity.getName()).thenReturn("itemk 12");
        Mockito.when(reviewer.getUsername()).thenReturn("revKTom");
        
        instance05 = new ReviewEntity(itemCommonDetail, reviewRanking, reviewText, reviewerEntity);
        instance06 = new ReviewEntity(itemCommonDetailEntity, reviewRanking, reviewText, reviewer);
        instance07 = new ReviewEntity(review);
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetailEntity, instance.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance05.getItemCommonDetail());
        assertEquals(itemCommonDetailEntity, instance07.getItemCommonDetail());
    }

    /**
     * Test of getReviewRanking method.
     */
    @Test
    public void testGetReviewRanking() {

        assertEquals(23141, instance.getReviewRanking());
        assertEquals(23141, instance07.getReviewRanking());
    }

    /**
     * Test of getReviewText method.
     */
    @Test
    public void testGetReviewText() {

        assertEquals("afdai adll afdkala lafla", instance.getReviewText());
        assertEquals("afdai adll afdkala lafla", instance07.getReviewText());
    }

    /**
     * Test of getReviewer method.
     */
    @Test
    public void testGetReviewer() {

        assertEquals(reviewerEntity, instance.getReviewer());
        assertEquals(reviewerEntity, instance06.getReviewer());
        assertEquals(reviewerEntity, instance07.getReviewer());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance06));
        assertTrue(instance.equals(instance07));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(review));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance02));
        assertTrue(instance.hasSameConstraint(instance03));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance06));
        assertTrue(instance.hasSameConstraint(instance07));
        assertTrue(instance.hasSameConstraint(review));

        assertFalse(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(null));

    }

    /**
     * Test of hasSameParameters method.
     */
    @Test
    public void testHasSameParameters() {

        assertTrue(instance.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(instance00));
        assertTrue(instance.hasSameParameters(instance05));
        assertTrue(instance.hasSameParameters(instance06));
        assertTrue(instance.hasSameParameters(instance07));
        assertTrue(instance.hasSameParameters(review));

        assertFalse(instance.hasSameParameters(instance01));
        assertFalse(instance.hasSameParameters(instance02));
        assertFalse(instance.hasSameParameters(instance03));
        assertFalse(instance.hasSameParameters(instance04));
        assertFalse(instance.hasSameParameters(null));
    }

    /**
     * Test of toString method, of class ReviewEntity.
     */
    @Test
    public void testToString() {

        assertEquals("ReviewEntity{item=itemk 12, reviewer=revKTom}", instance.toString());
    }
}
