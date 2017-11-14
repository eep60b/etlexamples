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
import com.etlsolutions.examples.data.api.Reviewer;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.ReviewerPojo;

/**
 * The ReviewerProcessor class contains methods which process operations
 * associated to the REVIEWER table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ReviewerProcessor extends AbstractIdentifiableEdentityProcessor<ReviewerPojo, Reviewer> {

    /**
     * Construct an object with the given facade object.
     *
     * @param facade - The given object.
     */
    public ReviewerProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    public ReviewerPojo retrieve(Reviewer reviewer) {
        return findConstraintableWithSameParameters(QueryNames.FIND_REVIEWER_BY_UNIQUE_CONSTRAINT, reviewer, new StringKeyValuePair(KeyNames.REVIEWER_USERNAME, reviewer.getUsername()));
    }

    @Override
    protected ReviewerPojo doSave(Reviewer reviewer) {
        ReviewerPojo pojo = retrieve(reviewer);

        if (pojo == null) {

            PersonalDetailPojo personalDetailPojo = new PersonalDetailProcessor(facade).save(reviewer.getPersonalDetail());

            return new ReviewerPojo(personalDetailPojo, reviewer.getImage(), reviewer.getUsername(), reviewer.getPassword());
        }

        return pojo;
    }
}
