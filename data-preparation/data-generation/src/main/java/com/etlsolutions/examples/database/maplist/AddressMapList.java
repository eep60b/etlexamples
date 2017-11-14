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
package com.etlsolutions.examples.database.maplist;

import com.etlsolutions.examples.data.AddressGenerator;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;
import com.etlsolutions.examples.data.api.Address;

/**
 * The AddressMapList class contains the maps which can populate the ADDRESS
 * table in database.
 *
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - Add the unique constraint.
 */
@DataClass
@NotThreadSafe
public final class AddressMapList extends AbstractMapList {

    private final AddressGenerator addressGenerator = new AddressGenerator();
    private final Set<Address> addresses;

    /**
     * Construct an object using the given IdGenerationDefinition object.
     *
     * @param definition
     */
    public AddressMapList(IdGenerationDefinition definition) {
        super(definition);
        addresses = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {
        Map<String, Object> map = new HashMap<>(7);
        Address address = addressGenerator.generateUniqueAddress(addresses);
        map.put(ADDRESS_ID, ids[0]);
        map.put(ADDRESS_HOUSE, address.getHouse());        
        map.put(ADDRESS_STREET, address.getStreet());
        map.put(ADDRESS_ADITIONAL, address.getAdditional());
        map.put(ADDRESS_CITY, address.getCity());
        map.put(ADDRESS_AREA, address.getArea());
        map.put(ADDRESS_POSTCODE, address.getPostcode());
        map.put(ADDRESS_COUNTRY, address.getCountry());
        return map;
    }
}
