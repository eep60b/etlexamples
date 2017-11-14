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

import com.etlsolutions.examples.data.ConstraintArray;
import com.etlsolutions.examples.data.RandomStringGenerator;
import com.etlsolutions.examples.data.api.AddressType;
import com.etlsolutions.examples.utility.EnumUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The PersonAddressLinkMapList class contains maps which can populate the
 * PERSON_ADDRESS_LINK table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class PersonAddressLinkMapList extends AbstractMapList {

    private final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
    private final List<Integer> allPersonalDetailIds;
    private final List<Integer> allAddressIds;
    private final List<String> allAddressTypes;
    private final Set<ConstraintArray> constraintArrays;

    public PersonAddressLinkMapList(PersonalDetailMapList personalDetailMapList, AddressMapList addressMapList, IdGenerationDefinition definition) {
        super(definition);
        allPersonalDetailIds = personalDetailMapList.getIds();
        allAddressIds = addressMapList.getIds();
        int size = definition.getSize();
        constraintArrays = new HashSet<>(size);
        allAddressTypes = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            allAddressTypes.add(randomStringGenerator.generateStringFromArray(EnumUtilities.names(AddressType.class)));
        }
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, allPersonalDetailIds, allAddressIds, allAddressTypes);
        Map<String, Object> map = new HashMap<>();
        map.put("id", ids[0]);
        map.put("personalDetailId", objs[0]);
        map.put("addressId", objs[1]);
        map.put("type", objs[2]);
        return map;
    }

}
