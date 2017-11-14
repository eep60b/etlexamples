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
import com.etlsolutions.examples.data.api.TelephoneType;
import com.etlsolutions.examples.utility.EnumUtilities;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The TelephoneMapList class contains maps which can populate the TELEPHONE
 * table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class TelephoneMapList extends AbstractMapList {

    private final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
    private final Set<ConstraintArray> constraintArrays;

    public TelephoneMapList(IdGenerationDefinition definition) {
        super(definition);
        constraintArrays = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        String countryCode;
        String areaCode;
        String telephoneNumber;
        ConstraintArray constraintArray;
        while (true) {
            countryCode = randomStringGenerator.generateVariableLengthDigitalString(3);
            areaCode = "0" + randomStringGenerator.generateVariableLengthDigitalString(1);
            telephoneNumber = randomStringGenerator.generateFixedLengthDigitalString(7);
            constraintArray = new ConstraintArray(countryCode, areaCode, telephoneNumber);
            if (!constraintArrays.contains(constraintArray)) {
                constraintArrays.add(constraintArray);
                break;
            }
        }

        Map<String, Object> map = new HashMap<>(5);
        map.put(TELEPHONE_ID, ids[0]);
        map.put(TELEPHONE_COUNTRY_CODE, countryCode);
        map.put(TELEPHONE_AREA_CODE, areaCode);
        map.put(TELEPHONE_TYPE, randomStringGenerator.generateStringFromArray(EnumUtilities.names(TelephoneType.class)));
        map.put(TELEPHONE_NUMBER, telephoneNumber);

        return map;
    }

}
