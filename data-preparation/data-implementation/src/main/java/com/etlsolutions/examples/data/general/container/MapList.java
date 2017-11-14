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
package com.etlsolutions.examples.data.general.container;

import java.util.List;
import java.util.Map;

/**
 * The MapList interface define a list of map which holds a string/object pair
 * which can be used in the insert into clause. 
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public interface MapList {


    /**
     * Get the map list from this object. The list can be empty but it should not be null.
     * @return the map list. 
     */
    List<Map<String, Object>> getMaps();
    
    /**
     * Set the map list for this object.
     * @param maps - The given list.
     */
    void setMaps(List<Map<String, Object>> maps);
    
    /**
     * Initialise the maps in this object.
     */
    void initMaps();
}
