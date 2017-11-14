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

import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * The UniqueValuedHashMap class is a subclass of HashMap which have an unique
 * set of key/value pairs. Two UniqueValuedHashMap objects are considered as
 * equal if their unique key/value pairs are equal. Other key/value pairs are
 * not used to compare.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@DataClass
@NotThreadSafe
public final class UniqueValuedHashMap<K, V> extends HashMap<K, V> {

    private static final long serialVersionUID = 551566277973159028L;
            
    private final Set<K> uniqueValueKeys;
    private final HashMap<K, V> uniqueValues = new HashMap<>();

    /**
     * Constructs an empty <tt>UniqueValuedHashMap</tt> with the specified
     * initial capacity and load factor.
     *
     * @param uniqueValueKeys - The key set of unique values.
     * @param initialCapacity - The initial capacity.
     * @param loadFactor - The load factor.
     * @throws IllegalArgumentException if the initial capacity is negative or
     * the load factor is nonpositive.
     */
    public UniqueValuedHashMap(Set<K> uniqueValueKeys, int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        this.uniqueValueKeys = new HashSet<>(uniqueValueKeys);

    }

    /**
     * Constructs an empty <tt>UniqueValuedHashMap</tt> with the specified
     * initial capacity and the default load factor (0.75).
     *
     * @param uniqueValueKeys - The key set of unique values.
     * @param initialCapacity - The initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public UniqueValuedHashMap(Set<K> uniqueValueKeys, int initialCapacity) {
        super(initialCapacity);
        this.uniqueValueKeys = new HashSet<>(uniqueValueKeys);
    }

    /**
     * Constructs an empty <tt>UniqueValuedHashMap</tt> with the default initial
     * capacity (16) and the default load factor (0.75).
     *
     * @param uniqueValueKeys - The key set of unique values.
     */
    public UniqueValuedHashMap(Set<K> uniqueValueKeys) {
        this.uniqueValueKeys = new HashSet<>(uniqueValueKeys);
    }

    /**
     * Constructs a new <tt>UniqueValuedHashMap</tt> with the same mappings as
     * the specified <tt>Map</tt>. The <tt>HashMap</tt> is created with default
     * load factor (0.75) and an initial capacity sufficient to hold the
     * mappings in the specified <tt>Map</tt>. The key set of specified map must
     * contains all the keys in the unique key set.
     *
     * @param uniqueValueKeys - The key set of unique values.
     * @param m - The map whose mappings are to be placed in this map.
     * @throws NullPointerException if the specified map is null.
     * @throws IllegalArgumentException if the specified map does not
     */
    public UniqueValuedHashMap(Set<K> uniqueValueKeys, Map<? extends K, ? extends V> m) {
        super(m);
        this.uniqueValueKeys = new HashSet<>(uniqueValueKeys);
        resetUniqueValues();

    }

    private void resetUniqueValues() {
        uniqueValues.clear();
        uniqueValueKeys.stream().forEach((key) -> {
            V v = get(key);
            if (v != null) {
                uniqueValues.put(key, v);
            }
        });
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        super.replaceAll(function);
        resetUniqueValues();
    }

    @Override
    public V replace(K key, V value) {
        if (uniqueValueKeys.contains(key)) {
            uniqueValues.replace(key, value);
        }
        return super.replace(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        if (uniqueValueKeys.contains(key)) {
            uniqueValues.replace(key, oldValue, newValue);
        }
        return super.replace(key, oldValue, newValue);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        if (uniqueValueKeys.contains(key)) {
            uniqueValues.putIfAbsent(key, value);
        }

        return super.putIfAbsent(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
        resetUniqueValues();
    }

    @Override
    public V put(K key, V value) {
        if (uniqueValueKeys.contains(key)) {
            uniqueValues.put(key, value);
        }
        return super.put(key, value);

    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        V v = super.merge(key, value, remappingFunction);
        resetUniqueValues();
        return v;
    }

    @Override
    public boolean remove(Object key, Object value) {
        uniqueValues.remove(key, value);
        return super.remove(key, value);
    }

    @Override
    public void clear() {
        uniqueValues.clear();
        super.clear();
    }

    @Override
    public V remove(Object key) {
        uniqueValues.remove(key);
        return super.remove(key);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.uniqueValues);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final UniqueValuedHashMap<?, ?> other = (UniqueValuedHashMap<?, ?>) obj;
        return Objects.equals(this.uniqueValues, other.uniqueValues);
    }

    /**
     * Get the key set for all the unique values in this map.
     *
     * @return the key set.
     */
    public Set<K> getUniqueValueKeys() {
        return new HashSet<>(uniqueValueKeys);
    }

    /**
     * Get the map which contains all the unique values.
     *
     * @return the unique value maps.
     */
    public Map<K, V> getUniqueValueMap() {
        return new HashMap<>(uniqueValues);
    }
    
    /**
     * Returns a shallow copy of this <tt>UniqueValuedHashMap</tt> instance: the keys and
     * values themselves are not cloned.
     *
     * @return a shallow copy of this map
     */    
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        
        HashMap<K,V> set = (HashMap<K,V>)super.clone();
        return new UniqueValuedHashMap<>(uniqueValueKeys, set);
    }    
}
