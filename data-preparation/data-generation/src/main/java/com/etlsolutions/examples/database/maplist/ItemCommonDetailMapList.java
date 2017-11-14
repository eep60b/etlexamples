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
import com.etlsolutions.examples.data.api.CurrencyCode;
import com.etlsolutions.examples.data.api.AvailabilityType;
import com.etlsolutions.examples.utility.EnumUtilities;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The ItemCommonDetailMapList class contains the maps which can populate the ITEM table in
 database.
 *
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Created.
 *
 */
public final class ItemCommonDetailMapList extends AbstractMapList {
    
    private final RandomStringGenerator stringGenerator = new RandomStringGenerator();
    private final RandomNumberGenerator valueGenerator = new RandomNumberGenerator();
    private final Set<String> barcodes;
    
    public ItemCommonDetailMapList(IdGenerationDefinition definition) {
        super(definition);
        barcodes = new HashSet<>(definition.getSize());        
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer...ids) {

        Map<String, Object> map = new HashMap<>();
        map.put("id", ids[0]);
        map.put("name", stringGenerator.generateString(100));
        map.put("image", valueGenerator.generteRandomBytes(2000));
        map.put("listPrice", valueGenerator.generateNumber(0.01, 100, 2));
        map.put("salePrice", valueGenerator.generateNumber(0.01, 100, 2));
        map.put("currencyCode", stringGenerator.generateStringFromArray(EnumUtilities.names(CurrencyCode.class)));
        map.put("ranking", valueGenerator.generatePositiveNumber(1000));
        map.put("description", stringGenerator.generateString(100));
        map.put("availability", stringGenerator.generateStringFromArray(EnumUtilities.names(AvailabilityType.class)));
        map.put("availabilityNumber", valueGenerator.generatePositiveNumber(50));
        map.put ("barcode", stringGenerator.generateFixedLengthUniqueDigitalString(barcodes, 25));
        return map;
    }

}
