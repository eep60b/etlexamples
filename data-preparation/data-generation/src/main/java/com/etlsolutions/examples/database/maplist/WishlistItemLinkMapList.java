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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The WishlistItemLinkMapList class contains maps which can populate the
 SHOPPING_CART_LINK table in database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Created.
 * @version 1.1.0 - Use ItemCommonDetailMapList.
 */
public final class WishlistItemLinkMapList extends AbstractMapList {

    private final List<Integer> wishlistIdList;
    private final List<Integer> itemCommonDetailIdList;
    private final Set<ConstraintArray> constraintArrays;

    public WishlistItemLinkMapList(WishlistMapList wishlistMapList, ItemCommonDetailMapList itemCommonDetailMapList, IdGenerationDefinition definition) {
        super(definition);
        wishlistIdList = new ArrayList<>(wishlistMapList.getIds());
        itemCommonDetailIdList = new ArrayList<>(itemCommonDetailMapList.getIds());
        constraintArrays = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, wishlistIdList, itemCommonDetailIdList);
        Map<String, Object> map = new HashMap<>(2);
        map.put("wishlistId", objs[0]);
        map.put("itemCommonDetailId", objs[1]);
        return map;
    }
}
