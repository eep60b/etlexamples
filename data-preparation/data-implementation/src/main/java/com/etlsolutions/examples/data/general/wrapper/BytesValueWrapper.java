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

import com.etlsolutions.examples.data.general.SimpleWrapper;
import java.util.Arrays;
import java.util.Objects;

/**
 * The BytesColum class defines an object which represents a table column in
 * byte arrays, Blob or Clob types.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public abstract class BytesValueWrapper implements SimpleWrapper {

    private final byte[] value;

    /**
     * Construct an object with the given byte array.
     *
     * @param value - The given byte array.
     */
    protected BytesValueWrapper(byte[] value) {
        this.value = value == null ? null : Arrays.copyOf(value, value.length);
    }

    @Override
    public final byte[] getValue() {
        return value == null ? null : Arrays.copyOf(value, value.length);
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 79 * hash + subtotal(value);
        return hash;
    }

    private int subtotal(byte[] bytes) {
        
        if(bytes == null) {
            return 0;
        }
        
        int result = 0;
        for (byte item : bytes) {
            result += item;
        }
        return result;
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

        final BytesValueWrapper other = (BytesValueWrapper) obj;

        return Arrays.equals(this.value, other.value);
    }

    @Override
    public final String toString() {
        return getClass().getName() + "value=" + String.valueOf(value) + '}';
    }
}
