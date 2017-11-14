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
package com.etlsolutions.examples.data.general.wrapper;

import com.etlsolutions.examples.utility.annotation.DataClass;
import java.util.Objects;

/**
 * The TypedValueWrapper class provides common implementation for the classes to
 * represent a column in the table.
 *
 * @param <T> - The value type.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@DataClass
public abstract class TypedValueWrapper<T extends Comparable<T>> implements ComparableWrapper<TypedValueWrapper<T>> {

    private final T value;

    /**
     *
     * @param value
     */
    protected TypedValueWrapper(T value) {
        this.value = value;
    }

    @Override
    public final T getValue() {
        return value;
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked")
        final TypedValueWrapper<T> other = (TypedValueWrapper<T>) obj;

        return Objects.equals(this.value, other.value);
    }

    @Override
    public final int compareTo(TypedValueWrapper<T> o) {

        if (o == null) {
            return 1;
        }

        if (this.value == null && o.value == null) {
            return 0;
        }

        if (this.value == null) {
            return -1;
        }

        return this.value.compareTo(o.getValue());
    }

    @Override
    public final String toString() {
        return getClass().getSimpleName() + "{value=" + value + '}';
    }
}
