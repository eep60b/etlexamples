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

import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.Review;
import com.etlsolutions.examples.utility.SerialisationUtilities;
import java.math.BigDecimal;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class ReviewPojo.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ReviewPojoTest {

    private final int id = 4437;
    private final int id1 = 6625;
    private final ReviewerPojo reviewerPojo = new ReviewerPojo(id, "useruser", "ppsswwlld");
    private final ReviewerPojo reviewerPojo2 = Mockito.mock(ReviewerPojo.class);
    private final ItemCommonDetailPojo itemCommonDetailPojo = new ItemCommonDetailPojo(id, "itemNameAAA", new BigDecimal(23.30), new BigDecimal(55.77), CurrencyCode.USD, AvailabilityType.YES, "483914kqeiqeyrq");
    private final ItemCommonDetailPojo itemCommonDetailPojo3 = Mockito.mock(ItemCommonDetailPojo.class);
    private final int ranking = 38131;
    private final int ranking4 = 66384;
    private final String description = "good review";
    private final String description5 = "ver bakd review";
    private final Review review = Mockito.mock(Review.class);

    private final ReviewPojo instance = new ReviewPojo(id, reviewerPojo, itemCommonDetailPojo, ranking, description);
    private final ReviewPojo instance00 = new ReviewPojo(id, reviewerPojo, itemCommonDetailPojo, ranking, description);
    private final ReviewPojo instance01 = new ReviewPojo(id1, reviewerPojo, itemCommonDetailPojo, ranking, description);
    private final ReviewPojo instance02 = new ReviewPojo(id, reviewerPojo2, itemCommonDetailPojo, ranking, description);
    private final ReviewPojo instance03 = new ReviewPojo(id, reviewerPojo, itemCommonDetailPojo3, ranking, description);
    private final ReviewPojo instance04 = new ReviewPojo(id, reviewerPojo, itemCommonDetailPojo, ranking4, description);
    private final ReviewPojo instance05 = new ReviewPojo(id, reviewerPojo, itemCommonDetailPojo, ranking, description5);
    private final ReviewPojo instance06 = new ReviewPojo();
    private final ReviewPojo instance07 = new ReviewPojo(id);
    private final ReviewPojo instance08 = new ReviewPojo(reviewerPojo, itemCommonDetailPojo, ranking, description);
    private final ReviewPojo instance09 = new ReviewPojo(id, reviewerPojo, itemCommonDetailPojo, ranking, description);
    private final ReviewPojo instance10 = new HibernateProxyReviewPojo(new ReviewPojo(id, reviewerPojo, itemCommonDetailPojo, ranking, description));

    @Before
    public void setUp() {

        Mockito.when(review.getItemCommonDetail()).thenReturn(itemCommonDetailPojo);
        Mockito.when(review.getReviewRanking()).thenReturn(38131);
        Mockito.when(review.getReviewText()).thenReturn("good review");
        Mockito.when(review.getReviewer()).thenReturn(reviewerPojo);
    }

    /**
     * Test of getId method.
     */
    @Test
    public void testGetId() {

        assertEquals(4437, instance.getId());
        assertEquals(0, instance06.getId());
        assertEquals(4437, instance07.getId());
        assertEquals(0, instance08.getId());
        assertEquals(4437, instance09.getId());
        assertEquals(0, instance10.getId());
    }

    /**
     * Test of setId method.
     */
    @Test
    public void testSetId() {

        instance.setId(553);
        assertEquals(553, instance.getId());
    }

    /**
     * Test of getReviewer method.
     */
    @Test
    public void testGetReviewer() {

        assertEquals(reviewerPojo, instance.getReviewer());
        assertNull(instance06.getReviewer());
        assertNull(instance07.getReviewer());
        assertEquals(reviewerPojo, instance08.getReviewer());
        assertEquals(reviewerPojo, instance09.getReviewer());
        assertNull(instance10.getReviewer());
    }

    /**
     * Test of setReviewer method.
     */
    @Test
    public void testSetReviewer() {

        ReviewerPojo reviewer = Mockito.mock(ReviewerPojo.class);

        instance.setReviewer(reviewer);
        assertEquals(reviewer, instance.getReviewer());
    }

    /**
     * Test of getItemCommonDetail method.
     */
    @Test
    public void testGetItemCommonDetail() {

        assertEquals(itemCommonDetailPojo, instance.getItemCommonDetail());
        assertNull(instance06.getItemCommonDetail());
        assertNull(instance07.getItemCommonDetail());
        assertEquals(itemCommonDetailPojo, instance08.getItemCommonDetail());
        assertEquals(itemCommonDetailPojo, instance09.getItemCommonDetail());
        assertNull(instance10.getItemCommonDetail());
    }

    /**
     * Test of setItemCommonDetail method.
     */
    @Test
    public void testSetItemCommonDetail() {

        ItemCommonDetailPojo itemCommonDetail = Mockito.mock(ItemCommonDetailPojo.class);

        instance.setItemCommonDetail(itemCommonDetail);
        assertEquals(itemCommonDetail, instance.getItemCommonDetail());
    }

    /**
     * Test of getReviewRanking method.
     */
    @Test
    public void testGetReviewRanking() {

        assertEquals(38131, instance.getReviewRanking());
        assertEquals(0, instance06.getReviewRanking());
        assertEquals(0, instance07.getReviewRanking());
        assertEquals(38131, instance08.getReviewRanking());
        assertEquals(38131, instance09.getReviewRanking());
        assertEquals(0, instance10.getReviewRanking());
    }

    /**
     * Test of setReviewRanking method.
     */
    @Test
    public void testSetReviewRanking() {

        instance.setReviewRanking(926);
        assertEquals(926, instance.getReviewRanking());
    }

    /**
     * Test of getReviewText method.
     */
    @Test
    public void testGetReviewText() {

        assertEquals("good review", instance.getReviewText());
        assertNull(instance06.getReviewText());
        assertNull(instance07.getReviewText());
        assertEquals("good review", instance08.getReviewText());
        assertEquals("good review", instance09.getReviewText());
        assertNull(instance10.getReviewText());
    }

    /**
     * Test of setReviewText method.
     */
    @Test
    public void testSetReviewText() {

        instance.setReviewText("aaavx");
        assertEquals("aaavx", instance.getReviewText());
    }

    /**
     * Test of hasSameConstraint method.
     */
    @Test
    public void testHasSameConstraint() {

        assertTrue(instance.hasSameConstraint(instance));
        assertTrue(instance.hasSameConstraint(instance00));
        assertTrue(instance.hasSameConstraint(instance01));
        assertTrue(instance.hasSameConstraint(instance04));
        assertTrue(instance.hasSameConstraint(instance05));
        assertTrue(instance.hasSameConstraint(instance09));        
        assertTrue(instance.hasSameConstraint(review));
        assertTrue(instance.hasSameConstraint(instance10));
        assertTrue(instance10.hasSameConstraint(instance));

        assertFalse(instance.hasSameConstraint(instance02));
        assertFalse(instance.hasSameConstraint(instance03));
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
        assertTrue(instance.hasSameParameters(instance09));
        assertTrue(instance.hasSameParameters(instance10));
        assertTrue(instance10.hasSameParameters(instance));
        assertTrue(instance.hasSameParameters(review));        

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
        assertEquals(instance09.hashCode(), instance.hashCode());
        assertEquals(instance10.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
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
        assertTrue(instance.equals(instance09));
        assertTrue(instance.equals(instance10));
        assertTrue(instance10.equals(instance));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
        assertFalse(instance.equals(instance04));
        assertFalse(instance.equals(instance05));
        assertFalse(instance.equals(null));
        assertFalse(instance.equals(review));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("ReviewPojo{id=4437, reviewer=useruser, item barcode=483914kqeiqeyrq}" , instance.toString());
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
    private final class HibernateProxyReviewPojo extends ReviewPojo implements HibernateProxy {

        private static final long serialVersionUID = 805838057665242324L;
        private final ReviewPojo pojo;

        public HibernateProxyReviewPojo(ReviewPojo pojo) {

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
                public ReviewPojo getImplementation() {
                    return pojo;
                }
            };
        }
    }
}
