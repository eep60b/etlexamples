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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The PersonTelephoneLinkMapList class contains maps which can populate the
 * PERSON_TELEPHONE_LIMK table in database. This class has NO own IDs.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Created.
 */
public class PersonTelephoneLinkMapList extends AbstractMapList {

    private final List<Integer> personDetailIds;
    private final List<Integer> telephoneIds;
    private final Set<ConstraintArray> constraintArrays;

    public PersonTelephoneLinkMapList(PersonalDetailMapList personMapList, TelephoneMapList telephoneMapList, IdGenerationDefinition definition) {
        super(definition);
        personDetailIds = personMapList.getIds();
        telephoneIds = telephoneMapList.getIds();
        constraintArrays = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer...ids) {
        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, personDetailIds, telephoneIds);
        Map<String, Object> map = new HashMap<>();
        map.put("personalDetailId", objs[0]);
        map.put("telephoneId", objs[1]);
        return map;
    }

}
