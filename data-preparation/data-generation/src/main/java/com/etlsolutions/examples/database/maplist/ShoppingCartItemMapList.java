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
import com.etlsolutions.examples.data.RandomNumberGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The ShoppingCartItemMapList class contains maps which can populate the
 SHOPPING_CART table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - Add the allItemCommonDetailIds, allCustomerIds and constraintArrays fields.
 */
public final class ShoppingCartItemMapList extends AbstractMapList {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final List<Integer> allCustomerIds;
    private final List<Integer> allItemCommonDetailIds;    
    private final Set<ConstraintArray> constraintArrays;
    
    public ShoppingCartItemMapList(CustomerMapList customerMapList, ItemCommonDetailMapList itemCommonDetailMapList, IdGenerationDefinition definition) {
        super(definition);
        allCustomerIds = customerMapList.getIds();
        allItemCommonDetailIds = itemCommonDetailMapList.getIds();
        constraintArrays = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, allCustomerIds, allItemCommonDetailIds);
        Map<String, Object> map = new HashMap<>(4);
        map.put("id", ids[0]);
        map.put("customerId", objs[0]);
        map.put("itemCommonDetailId", objs[1]);
        map.put("unitNumber", randomNumberGenerator.generatePositiveNumber(50));
        return map;
    }

}
