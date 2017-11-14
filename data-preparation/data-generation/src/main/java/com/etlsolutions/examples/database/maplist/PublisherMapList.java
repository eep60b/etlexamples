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

import com.etlsolutions.examples.data.RandomStringGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The PublisherMapList class contains maps which can populate the PUBLISHER
 * table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.0.1 - Add the addressIds field.
 */
public final class PublisherMapList extends AbstractMapList {

    private final RandomStringGenerator nameGenerator = new RandomStringGenerator();
    private final List<Integer> addressIds;
    private final Set<String> names;

    public PublisherMapList(AddressMapList addressMapList, IdGenerationDefinition definition) {
        super(definition);
        addressIds = addressMapList.getIds();
        names = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {
        
        Map<String, Object> map = new HashMap<>(3);
        map.put("id", ids[0]);
        map.put("addressId", keyGenerator.generateRandomKeyFromList(addressIds));
        map.put("name", nameGenerator.generateUniqueString(names, 50));
        return map;
    }

}
