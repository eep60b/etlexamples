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

import com.etlsolutions.examples.data.general.Nameable;
import com.etlsolutions.examples.utility.annotation.StatelessClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.util.Comparator;

/**
 * The NameComparator class compare two Nameable objects using their comparable
 * names. This class is usually used to sort the object list against the object
 * name.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@StatelessClass
@ThreadSafe
public final class NameComparator implements Comparator<Nameable> {

    @Override
    public int compare(Nameable nc1, Nameable nc2) {
        String name1 = nc1.getName();
        String name2 = nc2.getName();

        if (name1 == null && name2 == null) {
            return 0;
        }

        if (name1 == null) {
            return -1;
        }

        if (name2 == null) {
            return 1;
        }

        return name1.compareTo(name2);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        return other instanceof NameComparator;
    }

    @Override
    public int hashCode() {
        return 4322087;
    }

    @Override
    public String toString() {
        return "NameComparator{hashcode=" + hashCode() + '}';
    }
}
