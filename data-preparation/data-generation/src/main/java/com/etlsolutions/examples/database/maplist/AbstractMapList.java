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

import com.etlsolutions.examples.data.general.container.MapList;
import com.etlsolutions.examples.data.KeyGenerator;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The AbstractMapList class is a package level abstract class which implements
 * common MapList methods for its children. The AbstractMapList class is
 * designed for fast operation under a single thread, so it is NOT thread-safe.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.0.1 - Add an extra constructor with the initial capacity
 * specified.
 */
@NotThreadSafe
abstract class AbstractMapList implements MapList {

    protected final KeyGenerator keyGenerator = new KeyGenerator();
    private final List<Integer> ids;
    private final List<Integer> indexes;
    private List<Map<String, Object>> maps;

    /**
     * Construct an object with the specified capacity size.
     *
     * @param initialCapacity - the specified capacity size.
     */
    public AbstractMapList(IdGenerationDefinition definition) {
        this.ids = getIds(definition);
        int size = definition.getSize();
        indexes = keyGenerator.generateSequenceKeyList(size, 0, 1);
        maps = new ArrayList<>(size);
    }

    private List<Integer> getIds(IdGenerationDefinition definition) {
        
        if(definition instanceof SequenceIdGenerationDefinition) {
            SequenceIdGenerationDefinition sd = (SequenceIdGenerationDefinition) definition;
            return keyGenerator.generateSequenceKeyList(sd.getSize(), sd.getStart(), sd.getStep());            
        } else {
            return keyGenerator.generateRamdonKeys(definition.getSize());
        } 
       
    }
    
    /**
     * Create a map and add to this map list. If the map needs
     *
     * @param ids - The IDs used to create the map. 
     * @return
     */
    protected abstract Map<String, Object> createMap(Integer... ids);

    /**
     * Get the ID newMaps from this object. The newMaps can be empty but it
     * should not be null. Each map is denoted with an ID. The size of ID
     * newMaps must match the size of map newMaps. The ID is not necessarily
     * related to the key in newMaps. Although it is not compulsory to have a
     * unique key for each map, it is advised to do so.
     *
     * @return the ID newMaps.
     */
    protected final List<Integer> getIds() {
        return ids;
    }

    /**
     * Get a map with the same key and value from the map list. 
     * @param key - The map key.
     * @param value - The map value.
     * @return the map if the map exists. Otherwise return null.
     */
    protected Map<String, Object> getMap(String key, Object value) {
        for (Map<String, Object> map : maps) {
            if (value.equals(map.get(key))) {
                return map;
            }
        }
        return null;
    }

    @Override
    public final List<Map<String, Object>> getMaps() {
        return maps;
    }

    @Override
    public final void setMaps(List<Map<String, Object>> maps) {
        this.maps = maps;
    }
    
    @Override
    public final void initMaps() {
        List<Map<String, Object>> newMaps = new ArrayList<>();

        boolean haveId = !ids.isEmpty();

        indexes.stream().forEach((index) -> {
            if (haveId) {
                newMaps.add(createMap(ids.get(index)));
            } else {
                newMaps.add(createMap());
            }
        });

        setMaps(newMaps);
    }    

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.maps);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        
        if(this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractMapList other = (AbstractMapList) obj;
        return Objects.equals(this.maps, other.maps);
    }    

    @Override
    public final String toString() {
        return getClass().getSimpleName() + "{hashcode=" +  hashCode() + '}';
    }    
}
