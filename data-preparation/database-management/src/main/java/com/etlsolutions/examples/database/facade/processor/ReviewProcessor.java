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
import com.etlsolutions.examples.data.api.Review;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.ItemCommonDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ReviewPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ReviewerPojo;

/**
 * The ReviewProcessor class contains methods which process operations
 * associated to the REVIEW table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class ReviewProcessor extends AbstractIdentifiableEdentityProcessor<ReviewPojo, Review> {

    private final ItemCommonDetailProcessor itemCommonDetailProcessor;
    private final ReviewerProcessor reviewerProcessor;
    /**
     * Construct an object with the given facade object.
     *
     * @param facade - The given facade object.
     */
    public ReviewProcessor(BookshopFacade facade) {
        super(facade);
        itemCommonDetailProcessor = new ItemCommonDetailProcessor(facade);
        reviewerProcessor = new ReviewerProcessor(facade);
    }

    @Override
    public ReviewPojo retrieve(Review review) {

        ItemCommonDetailPojo itemCommonDetailPojo = itemCommonDetailProcessor.retrieve(review.getItemCommonDetail());
        ReviewerPojo reviewerPojo = reviewerProcessor.retrieve(review.getReviewer());
        
        if(itemCommonDetailPojo == null || reviewerPojo == null) {
            return null;
        }
        
        return findConstraintableWithSameParameters(QueryNames.FIND_REVIEW_BY_UNIQUE_CONSTRAINT, review,
                new StringKeyValuePair(KeyNames.REVIEW_ITEM_COMMON_DETAIL, itemCommonDetailPojo),
                new StringKeyValuePair(KeyNames.REVIEW_REVIWER, reviewerPojo));
    }

    @Override
    protected ReviewPojo doSave(Review review) {

        ReviewPojo pojo = retrieve(review);
        return pojo == null ? new ReviewPojo(reviewerProcessor.save(review.getReviewer()), itemCommonDetailProcessor.save(review.getItemCommonDetail()), 
                review.getReviewRanking(), review.getReviewText()) : pojo;
    }
}
