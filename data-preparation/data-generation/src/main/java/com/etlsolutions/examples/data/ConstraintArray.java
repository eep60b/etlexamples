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

import java.util.Arrays;

/**
 * The ConstraintArray class represents a set of constraint data in a database
 * table. Since there is no information about column names, the values in the
 * object array must keep the same order so they can be compared to each other.
 *
 * This class will NOT be an immutable class if the argument is an object array.
 * The object array passed in from constructor is a reference rather than a
 * newly created array. This design is to ensure the maximum performance. It is
 * recommended NOT to user Object[] as the argument.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Created.
 */
public final class ConstraintArray {

    private final Object[] objects;

    public ConstraintArray(Object... objects) {
        this.objects = objects;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Arrays.deepHashCode(this.objects);
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
        final ConstraintArray other = (ConstraintArray) obj;
        return Arrays.deepEquals(this.objects, other.objects);
    }

    @Override
    public String toString() {
        return "ConstraintArray{" + "objects=" + Arrays.toString(objects) + '}';
    }
}
