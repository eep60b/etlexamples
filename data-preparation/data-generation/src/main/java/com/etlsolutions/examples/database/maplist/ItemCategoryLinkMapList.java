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
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The ItemCategoryLinkMapList class contains maps which can populate the
 BOOK_CATEGORY_LINK table in database.
 *
 * @author Zhipeng Chang
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 2.0.0 - Name changed from BookCategoryLinkMapList.
 * @version 2.0.1 - Unused fields are removed.
 */
@DataClass
@NotThreadSafe
public final class ItemCategoryLinkMapList extends AbstractMapList {

    private final List<Integer> allItemCommonDetailIds;
    private final List<Integer> allCategoryIds;
    private final Set<ConstraintArray> constraintArrays;

    public ItemCategoryLinkMapList(ItemCommonDetailMapList itemCommonDetailMapList, CategoryMapList categoryMapList, IdGenerationDefinition definition) {
        super(definition);
        allItemCommonDetailIds = itemCommonDetailMapList.getIds();
        allCategoryIds = categoryMapList.getIds();
        constraintArrays = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer...ids) {
        
        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, allItemCommonDetailIds, allCategoryIds);

        Map<String, Object> map = new HashMap<>();
        map.put("itemCommonDetailId", objs[0]);
        map.put("categoryId", objs[1]);
        return map;
    }

}
