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
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The SoldItemMapList class contains maps which can populate the
 BOOK_SOLD_PRICE table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 * 
 * @version 1.0.0 - Created.
 * @version 1.1.0 - Renamed to SoldItemMapList. 
 * @version 1.2.0 - Changed to use ItemCommonDetailMapList. 
 */
@NotThreadSafe
public final class SoldItemMapList extends AbstractMapList {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final List<Integer> itemCommonDetailIds;
    private final List<Integer> invoiceIds;
    private final Set<ConstraintArray> constraintArrays;

    /**
     * 
     * @param invoiceMapList
     * @param itemMapList
     * @param definition 
     */
    public SoldItemMapList(InvoiceMapList invoiceMapList, ItemCommonDetailMapList itemMapList, IdGenerationDefinition definition) {
        super(definition);
        itemCommonDetailIds = itemMapList.getIds();
        invoiceIds = invoiceMapList.getIds();
        constraintArrays = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, invoiceIds, itemCommonDetailIds);
        Map<String, Object> map = new HashMap<>();
        map.put(SOLD_ITEM_ID, ids[0]);
        map.put(SOLD_ITEM_INVOICE_ID, objs[0]);
        map.put(SOLD_ITEM_COMMON_DETAIL_ID, objs[1]);
        map.put(SOLD_ITEM_QUANTITY, randomNumberGenerator.generatePositiveNumber(200));
        map.put(SOLD_ITEM_UNIT_PRICE, randomNumberGenerator.generateNumber(0.01, 10000.00, 2));
        return map;
    }

}
