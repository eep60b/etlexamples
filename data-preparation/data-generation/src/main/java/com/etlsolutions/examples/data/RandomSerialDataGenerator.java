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
package com.etlsolutions.examples.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Zhipeng Chang
 */
public class RandomSerialDataGenerator {

    /**
     * Get a map which represent the data for x,y-axis in a chart.
     * @param limit - The maximum number which can be generated.
     * @param length - How many numbers should be in the list.
     * @param start - The start point on x-axis.
     * @param step -The step on x-axis.
     * @return 
     */
    public Map<Integer, Integer> getDataMap(int limit, int length, int start, int step) {
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            map.put(start + i * step, random.nextInt(limit));
        }
        
        return map;
    }

    
    /**
     * Get a list of random number which the maximum is set.
     * @param limit - The maximum number which can be generated.
     * @param length - How many numbers should be in the list.
     * @return the random number list.
     */
    public List<Integer> getDataList(int limit, int length) {
        
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        random.setSeed(limit);
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(limit));
        }
        
        return list;
    }
}
