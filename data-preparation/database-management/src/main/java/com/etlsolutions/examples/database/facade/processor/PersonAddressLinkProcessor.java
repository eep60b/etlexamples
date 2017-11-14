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
import com.etlsolutions.examples.data.api.PersonAddressLink;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonAddressLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;

/**
 * The PersonAddressLinkProcessor class contains methods which process the
 * operations associated to the PERSON_ADDRESS_LINK table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonAddressLinkProcessor extends AbstractIdentifiableEdentityProcessor<PersonAddressLinkPojo, PersonAddressLink> {

    /**
     * Construct an object with the given facade object.
     *
     * @param facade
     */
    public PersonAddressLinkProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    protected PersonAddressLinkPojo doSave(PersonAddressLink personAddressLink) {

        PersonAddressLinkPojo pojo = retrieve(personAddressLink);

        if (pojo == null) {

            AddressPojo addressPojo = new AddressProcessor(facade).save(personAddressLink.getAddress());
            PersonalDetailPojo personalDetailPojo = new PersonalDetailProcessor(facade).save(personAddressLink.getPersonalDetail());
            pojo = new PersonAddressLinkPojo(addressPojo, personalDetailPojo, personAddressLink.getAddressType());
        }

        return pojo;
    }

    @Override
    public PersonAddressLinkPojo retrieve(PersonAddressLink personAddressLink) {

        PersonalDetailPojo personalDetailPojo = new PersonalDetailProcessor(facade).retrieve(personAddressLink.getPersonalDetail());
        AddressPojo addressPojo = new AddressProcessor(facade).retrieve(personAddressLink.getAddress());

        if (personalDetailPojo == null || addressPojo == null) {
            return null;
        }

        return findConstraintableWithSameParameters(QueryNames.FIND_PERSON_ADDRESS_LINK_BY_UNIQUE_CONSTRAINT, personAddressLink,
                new StringKeyValuePair(KeyNames.PERSON_ADDRESS_LINK_PERSONAL_DETAIL, personalDetailPojo),
                new StringKeyValuePair(KeyNames.PERSON_ADDRESS_LINK_ADDRESS, addressPojo),
                new StringKeyValuePair(KeyNames.PERSON_ADDRESS_LINK_ADDRESS_TYPE, personAddressLink.getAddressType()));
    }

}
