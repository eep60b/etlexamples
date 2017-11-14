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
package com.etlsolutions.examples.data.api;

import com.etlsolutions.examples.data.general.Constrainable;

/**
 * The Review interface contains information of a review entry in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface Review extends Constrainable<Review> {

    /**
     * Get the details for the item to be reviewed.
     *
     * @return the ItemCommonDetail object.
     */
    ItemCommonDetail getItemCommonDetail();

    /**
     * Get the review ranking number.
     * 
     * @return the review ranking number.
     */
    int getReviewRanking();

    /**
     * Get the review text.
     * @return the review text string.
     */
    String getReviewText();

    /**
     * Get the reviewer who writes this review.
     *
     * @return the Reviewer object.
     */
    Reviewer getReviewer();
}
