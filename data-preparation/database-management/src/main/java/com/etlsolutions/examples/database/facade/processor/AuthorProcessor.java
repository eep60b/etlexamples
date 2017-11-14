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
import com.etlsolutions.examples.data.api.Author;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AuthorPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;

/**
 * The AuthorProcessor class contains methods which process the operations
 * associated to AUTHOR table in the database.
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AuthorProcessor extends AbstractIdentifiableEdentityProcessor<AuthorPojo, Author> {

    private final PersonalDetailProcessor personalDetailProcessor;

    /**
     * Construct an object with the given BookshopFacade object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public AuthorProcessor(BookshopFacade facade) {
        super(facade);
        personalDetailProcessor = new PersonalDetailProcessor(facade);
    }

    @Override
    public AuthorPojo retrieve(Author author) {

        PersonalDetailPojo personalDetailPojo = personalDetailProcessor.retrieve(author.getPersonalDetail());

        if (personalDetailPojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_AUTHOR_BOOK_BY_UNIQUE_CONSTRAINT, author, new StringKeyValuePair(KeyNames.AUTHOR_PERSONAL_DETAIL, personalDetailPojo));
    }

    @Override
    protected AuthorPojo doSave(Author author) {

        AuthorPojo pojo = retrieve(author);

        if (pojo == null) {

            PersonalDetailPojo personalDetailPojo = personalDetailProcessor.save(author.getPersonalDetail());
            pojo = new AuthorPojo(personalDetailPojo, author.getImage(), author.getBiography(), author.getWebpageUrl());
        }

        return pojo;
    }
}
