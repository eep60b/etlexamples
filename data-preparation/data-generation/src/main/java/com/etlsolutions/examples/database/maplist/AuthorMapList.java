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

import com.etlsolutions.examples.data.RandomNumberGenerator;
import com.etlsolutions.examples.data.RandomStringGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The AuthorMapList class contains maps which can populate the AUTHOR table in
 * database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class AuthorMapList extends AbstractMapList {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
    private final List<Integer> allPersonalDetailIds;
    private final Set<Integer> personalDetailIds;    
    
    public AuthorMapList(PersonalDetailMapList personalDetailMapList, IdGenerationDefinition definition) {
        super(definition);
        allPersonalDetailIds = personalDetailMapList.getIds();
        personalDetailIds = new HashSet<>(definition.getSize()); 
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {
        
        Map<String, Object> map = new HashMap<>();
        map.put("id", ids[0]);
        map.put("personalDetailId", keyGenerator.generateUniqueObjectFromList(personalDetailIds, allPersonalDetailIds));
        map.put("image", randomNumberGenerator.generteRandomBytes(2000));
        map.put("biography", randomNumberGenerator.generteRandomBytes(2000));
        map.put("webpageUrl", randomStringGenerator.generateFixedLengthDigitalString(100));

        return map;
    }

}
