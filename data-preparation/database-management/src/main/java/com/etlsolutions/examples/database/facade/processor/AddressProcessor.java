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
import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.AddressPojo;
import com.etlsolutions.examples.utility.annotation.StatelessClass;

/**
 * The AddressProcessor class contains methods which process operations
 * associated to the ADDRESS table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
@StatelessClass
public final class AddressProcessor extends AbstractIdentifiableEdentityProcessor<AddressPojo, Address> {

    /**
     * Construct an AddressProcessor object using the given BookshopFacade
     * object.
     *
     * @param facade - The given BookshopFacade object.
     */
    public AddressProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    protected AddressPojo doSave(Address address) {

        AddressPojo pojo = retrieve(address);

        return pojo == null ? new AddressPojo(address) : pojo;
    }

    @Override
    public AddressPojo retrieve(Address address) {
        return findConstraintableWithSameParameters(QueryNames.FIND_ADDRESS_BY_UNIQUE_CONSTRAINT, address, new StringKeyValuePair(KeyNames.ADDRESS_HOUSE, address.getHouse()),
                new StringKeyValuePair(KeyNames.ADDRESS_STREET, address.getStreet()), new StringKeyValuePair(KeyNames.ADDRESS_ADITIONAL, address.getAdditional()), 
                new StringKeyValuePair(KeyNames.ADDRESS_CITY, address.getCity()), new StringKeyValuePair(KeyNames.ADDRESS_AREA, address.getArea()), 
                new StringKeyValuePair(KeyNames.ADDRESS_POSTCODE, address.getPostcode()), new StringKeyValuePair(KeyNames.ADDRESS_COUNTRY, address.getCountry()));
    }
}
