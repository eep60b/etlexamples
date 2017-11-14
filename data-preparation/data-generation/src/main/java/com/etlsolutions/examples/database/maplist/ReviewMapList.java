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
import com.etlsolutions.examples.data.RandomStringGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.etlsolutions.examples.data.constant.KeyNames.*;

/**
 * The ReviewMapList class contains maps which can populate the REVIEW table in
 * database.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0 - Created.
 * @version 2.0.0 - Added the reviewerMapList and constraintArrays fields.
 */
public class ReviewMapList extends AbstractMapList {

    private final RandomStringGenerator stringGenerator = new RandomStringGenerator();
    private final RandomNumberGenerator valueGenerator = new RandomNumberGenerator();

    private final List<Integer> allItemCommonDetailIds;
    private final List<Integer> allReviewerIds;
    private final Set<ConstraintArray> constraintArrays;
    
    public ReviewMapList(ItemCommonDetailMapList itemCommonDetailMapList, ReviewerMapList reviewerMapList, IdGenerationDefinition definition) {
        super(definition);
        allItemCommonDetailIds = itemCommonDetailMapList.getIds();
        allReviewerIds = reviewerMapList.getIds();
        constraintArrays = new HashSet<>(definition.getSize());
        initMaps();
    }

    @Override
    protected Map<String, Object> createMap(Integer... ids) {

        Object[] objs = keyGenerator.generateUniqueObjectArrayFromList(constraintArrays, allItemCommonDetailIds, allReviewerIds);           
        Map<String, Object> map = new HashMap<>(5);
        map.put("id", ids[0]);
        map.put("itemCommonDetailId", objs[0]);
        map.put("reviewerId", objs[1]);        
        map.put("ranking", valueGenerator.generatePositiveNumber(10000));
        map.put("text", stringGenerator.generateFixedLengthString(1000));
        return map;
    }
}
