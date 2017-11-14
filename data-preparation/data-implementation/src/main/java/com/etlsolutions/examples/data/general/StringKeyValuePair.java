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
package com.etlsolutions.examples.data.general;

import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The StringKeyValuePair class holds a key-value-pair. The key is a string
 * object and the value can be any object.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
public final class StringKeyValuePair {

    private final String key;
    private final Object value;

    /**
     * Construct an object use the given key-value pair.
     *
     * @param key - The key string.
     * @param value - The value object.
     */
    public StringKeyValuePair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Get the key string.
     * @return the key string.
     */
    public String getKey() {
        return key;
    }

    /**
     * Get the value in this object.
     * @return the value object.
     */
    public Object getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.key);
        hash = 79 * hash + Objects.hashCode(this.value);
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
        final StringKeyValuePair other = (StringKeyValuePair) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return Objects.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        return "StringKeyValuePair{key=" + key + ", value=" + value + '}';
    }
}
