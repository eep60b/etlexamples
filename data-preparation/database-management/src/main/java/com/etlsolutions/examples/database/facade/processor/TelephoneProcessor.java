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
import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.TelephonePojo;

/**
 * The TelephoneProcessor class contains methods which process operations
 * associated to the TELEPHONE table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class TelephoneProcessor extends AbstractIdentifiableEdentityProcessor<TelephonePojo, Telephone> {

    /**
     * Construct an TelephoneProcessor object using the given BookshopFacade object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public TelephoneProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    public TelephonePojo retrieve(Telephone telephone) {
        return findConstraintableWithSameParameters(QueryNames.FIND_TELEPHONE_BY_UNIQUE_CONSTRAINT, telephone,
                new StringKeyValuePair(KeyNames.TELEPHONE_COUNTRY_CODE, telephone.getCountryCode()),
                new StringKeyValuePair(KeyNames.TELEPHONE_AREA_CODE, telephone.getAreaCode()),
                new StringKeyValuePair(KeyNames.TELEPHONE_NUMBER, telephone.getTelephoneNumber()),
                new StringKeyValuePair(KeyNames.TELEPHONE_TYPE, telephone.getTelephoneType()));
    }

    @Override
    protected TelephonePojo doSave(Telephone telephone) {

        TelephonePojo pojo = retrieve(telephone);
        return pojo == null ? new TelephonePojo(telephone) : pojo;
    }
}
