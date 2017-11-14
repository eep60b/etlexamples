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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The WishlistMapList class contains maps which can populate the WISHLIST_BOOK
 * table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - Add unique constraint for customer id and name.
 */
public final class WishlistMapList extends AbstractMapList {

    private final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();

    private final List<Integer> allCustomerIds;
    private final List<ConstraintArray> constraintArrays;    

    public WishlistMapList(CustomerMapList customerMapList, IdGenerationDefinition definition) {
        super(definition);
        allCustomerIds = customerMapList.getIds();
        constraintArrays = new ArrayList<>(definition.getSize());  
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {
 
        String name = randomStringGenerator.generateString(40);
        int customerId;
        while (true) {
            customerId = keyGenerator.generateRandomKeyFromList(allCustomerIds);
            ConstraintArray constraintArray = new ConstraintArray(customerId, name);
            
            if (!constraintArrays.contains(constraintArray)) {
                constraintArrays.add(constraintArray);
                break;
            }
        }

        Map<String, Object> map = new HashMap<>(3);
        map.put(WISHLIST_ID, ids[0]);
        map.put(WISHLIST_NAME, name);
        map.put(WISHLIST_CUSTOMER_ID, customerId);
        return map;
    }

}
