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
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.utility.annotation.StatelessClass;

/**
 * The PersonalDetailProcessor class contains methods which process the
 * operations associated with PERSONAL_DETAIL table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@StatelessClass
public final class PersonalDetailProcessor extends AbstractIdentifiableEdentityProcessor<PersonalDetailPojo, PersonalDetail> {

    /**
     * Construct an object with the given facade object.
     *
     * @param facade
     */
    public PersonalDetailProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    protected PersonalDetailPojo doSave(PersonalDetail personalDetail) {

        PersonalDetailPojo pojo = retrieve(personalDetail);
        return pojo == null ? new PersonalDetailPojo(personalDetail) : pojo;
    }

    @Override
    public PersonalDetailPojo retrieve(PersonalDetail personalDetail) {

        return findConstraintableWithSameParameters(QueryNames.FIND_PERSONAL_DETAIL_BY_UNIQUE_CONSTRAINT, personalDetail,
                new StringKeyValuePair(KeyNames.PERSONAL_DETAIL_PROFILE, personalDetail.getProfile()));
    }
}
