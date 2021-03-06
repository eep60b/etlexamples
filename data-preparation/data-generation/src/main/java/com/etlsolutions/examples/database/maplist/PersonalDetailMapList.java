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

import com.etlsolutions.examples.data.DateTimeGenerator;
import com.etlsolutions.examples.data.PersonalProfileIdentificationFactory;
import com.etlsolutions.examples.data.RandomNumberGenerator;
import com.etlsolutions.examples.data.RandomStringGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The PersonalDetailMapList class contains maps which can populate the PERSON
 * table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonalDetailMapList extends AbstractMapList {

    private final RandomStringGenerator stringGenerator = new RandomStringGenerator();
    private final DateTimeGenerator dateTimeGenerator = new DateTimeGenerator();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();    

    private final Set<byte[]> profiles;
    
    public PersonalDetailMapList(IdGenerationDefinition definition) {
        super(definition);
        profiles = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Map<String, Object> map = new HashMap<>(5);
        map.put(PERSONAL_DETAIL_ID, ids[0]);
        map.put(PERSONAL_DETAIL_TITLE, stringGenerator.generateString(10));
        map.put(PERSONAL_DETAIL_GIVEN_NAME, stringGenerator.generateFixedLengthString(40));
        map.put(PERSONAL_DETAIL_FAMILY_NAME, stringGenerator.generateFixedLengthString(20));
        map.put(PERSONAL_DETAIL_DATE_OF_BIRTH, dateTimeGenerator.generateRandomOldDate(10));
        byte[] profile = randomNumberGenerator.generateRandomUniqueBytes(profiles, 2000);
        map.put(PERSONAL_DETAIL_PROFILE, profile);      
        return map;
    }
}
