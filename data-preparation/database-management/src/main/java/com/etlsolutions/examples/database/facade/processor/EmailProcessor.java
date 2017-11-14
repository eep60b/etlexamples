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
import com.etlsolutions.examples.data.api.Email;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.EmailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;

/**
 * The EmailProcessor class contains methods to process the operations
 * associated to EMAIL table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class EmailProcessor extends AbstractIdentifiableEdentityProcessor<EmailPojo, Email> {

    /**
     * Construct an EmailProcessor object using the given BookshopFacade object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public EmailProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    public EmailPojo retrieve(Email email) {
        return findConstraintableWithSameParameters(QueryNames.FIND_EMAIL_BY_UNIQUE_CONSTRAINT, email,
                new StringKeyValuePair(KeyNames.EMAIL_ADDRESS, email.getEmailAddress()));

    }

    @Override
    protected EmailPojo doSave(Email email) {
        EmailPojo pojo = retrieve(email);

        if (pojo == null) {
            PersonalDetailPojo personalDetailPojo = new PersonalDetailProcessor(facade).save(email.getPersonalDetail());
            return new EmailPojo(personalDetailPojo, email.getEmailAddress());
        }

        return pojo;
    }
}
