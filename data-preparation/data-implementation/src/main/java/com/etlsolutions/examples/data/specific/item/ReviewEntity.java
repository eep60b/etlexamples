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

import com.etlsolutions.examples.data.api.ItemCommonDetail;
import com.etlsolutions.examples.data.api.Review;
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.specific.item.ItemCommonDetailEntity;
import com.etlsolutions.examples.data.specific.person.ReviewerEntity;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The ReviewEntity class represents the review for an item. It is a simple
 * implementation of the Review interface.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @author 1.0.0
 */
@ImmutableClass
@DataClass
public final class ReviewEntity implements Review {

    private final ItemCommonDetailEntity itemCommonDetail;
    private final int reviewRanking;
    private final String reviewText;
    private final ReviewerEntity reviewer;

    /**
     * Construct an object using the given Review object.
     *
     * @param review The given Review object.
     * @throws NullPointerException if the given Review object or its contents
     * (reviewer, item or review text) is null.
     */
    public ReviewEntity(Review review) {
        this(review.getItemCommonDetail(), review.getReviewRanking(), review.getReviewText(), review.getReviewer());
    }

    /**
     * Construct an object using the given parameters.
     *
     * @param itemCommonDetail
     * @param reviewRanking
     * @param reviewText
     * @param reviewer
     */
    public ReviewEntity(ItemCommonDetail itemCommonDetail, ReviewRanking reviewRanking, ReviewText reviewText, Reviewer reviewer) {

        this(itemCommonDetail, reviewRanking.getValue(), reviewText.getValue(), reviewer);
    }

    public ReviewEntity(ItemCommonDetail itemCommonDetail, int reviewRanking, String reviewText, Reviewer reviewer) {
        
        this.itemCommonDetail = itemCommonDetail instanceof ItemCommonDetailEntity ? (ItemCommonDetailEntity) itemCommonDetail : new ItemCommonDetailEntity(itemCommonDetail);
        this.reviewRanking = reviewRanking;
        this.reviewText = reviewText;
        this.reviewer = reviewer instanceof ReviewerEntity ? (ReviewerEntity) reviewer : new ReviewerEntity(reviewer);
    }

    @Override
    public ItemCommonDetail getItemCommonDetail() {
        return itemCommonDetail;
    }

    @Override
    public int getReviewRanking() {
        return reviewRanking;
    }

    @Override
    public String getReviewText() {
        return reviewText;
    }

    @Override
    public ReviewerEntity getReviewer() {
        return reviewer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.itemCommonDetail);
        hash = 43 * hash + Objects.hashCode(this.reviewRanking);
        hash = 43 * hash + Objects.hashCode(this.reviewText);
        hash = 43 * hash + Objects.hashCode(this.reviewer);
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

        final ReviewEntity other = (ReviewEntity) obj;

        return this.reviewRanking == other.reviewRanking && Objects.equals(this.reviewText, other.reviewText) && Objects.equals(this.itemCommonDetail, other.itemCommonDetail) && Objects.equals(this.reviewer, other.reviewer);
    }

    @Override
    public boolean hasSameConstraint(Review review) {

        if (this == review) {
            return true;
        }

        if (review == null) {
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(itemCommonDetail, review.getItemCommonDetail()) && ConstrainableUtilities.hasSameConstraint(reviewer, review.getReviewer());
    }

    @Override
    public boolean hasSameParameters(Review review) {

        if (this == review) {
            return true;
        }

        if (review == null) {
            return false;
        }

        return getReviewRanking() == review.getReviewRanking() && Objects.equals(getReviewText(), review.getReviewText()) && ConstrainableUtilities.hasSameParameters(itemCommonDetail, review.getItemCommonDetail()) && ConstrainableUtilities.hasSameParameters(reviewer,review.getReviewer());
    }

    @Override
    public String toString() {
        return "ReviewEntity{item=" + itemCommonDetail.getName() + ", reviewer=" + reviewer.getUsername() + '}';
    }
}
