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
package com.etlsolutions.examples.utility;

import com.etlsolutions.examples.data.general.Constrainable;

/**
 * The ConstrainableUtilities class represents an entry in the AUGHOR_BOOK_LINK
 table of the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ConstrainableUtilities {

    /**
     * Check if the two objects have the same constraint.
     *
     * @param <C>
     * @param constrainable1 - The first object.
     * @param constrainable2 - The second object.
     * @return true if they have the same constraint, otherwise return false.
     */
    public static final <C extends Constrainable<C>> boolean hasSameConstraint(C constrainable1, C constrainable2) {

        if (constrainable1 == constrainable2) {
            return true;
        }

        if (constrainable1 == null) {
            return false;
        }

        return constrainable1.hasSameConstraint(constrainable2);
    }

    /**
     * Check if the two objects have the same parameters.
     *
     * @param <T>
     * @param constrainable1 - The first object.
     * @param constrainable2 - The second object.
     * @return true if they have the same parameters, otherwise return false.
     */
    public static final <T extends Constrainable<T>> boolean hasSameParameters(T constrainable1, T constrainable2) {

        if (constrainable1 == constrainable2) {
            return true;
        }

        if (constrainable1 == null) {
            return false;
        }

        return constrainable1.hasSameParameters(constrainable2);
    }
}
