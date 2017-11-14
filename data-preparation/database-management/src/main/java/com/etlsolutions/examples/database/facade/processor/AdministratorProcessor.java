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
import com.etlsolutions.examples.data.api.Administrator;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AdministratorPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;

/**
 * The AdministratorProcessor class contains methods which process the
 * operations associated with the ADMINISTRATOR table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AdministratorProcessor extends AbstractIdentifiableEdentityProcessor<AdministratorPojo, Administrator> {

    private final PersonalDetailProcessor personalDetailProcessor;

    /**
     * Construct an object using the given BookshopFacade object.
     *
     * @param facade - The given facade.
     */
    public AdministratorProcessor(BookshopFacade facade) {
        super(facade);
        personalDetailProcessor = new PersonalDetailProcessor(facade);
    }

    @Override
    public AdministratorPojo retrieve(Administrator administrator) {

        return findConstraintableWithSameParameters(QueryNames.FIND_ADMINISTRATOR_BY_UNIQUE_CONSTRAINT, administrator,
                new StringKeyValuePair(KeyNames.ADMINISTRATOR_USERNAME, administrator.getUsername()));
    }

    @Override
    protected AdministratorPojo doSave(Administrator administrator) {

        AdministratorPojo pojo = retrieve(administrator);

        if (pojo == null) {
            PersonalDetailPojo personalDetailPojo = personalDetailProcessor.save(administrator.getPersonalDetail());
            pojo =  new AdministratorPojo(personalDetailPojo, administrator.getRole(), administrator.getUsername(), administrator.getPassword());
            personalDetailPojo.getAdministrators().add(pojo);
            return pojo;
        }

        return pojo;
    }
}
