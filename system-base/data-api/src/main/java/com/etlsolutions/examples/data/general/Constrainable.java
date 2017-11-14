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

/**
 * The Constrainable interface defines an object which has constraint.
 *
 * @author Zhipeng Chang
 *
 * @param <C> - The type of object which to be checked if it has the same
 * parameters as this Constrainable object.
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface Constrainable<C extends Constrainable<C>> {

    /**
     * Check if the given object has the constraint as this object.
     *
     * @param constraintable - The Constrainable object to be checked.
     * @return true the given constrainable object has the same constraint with
     * this one. Otherwise return false.
     */
    boolean hasSameConstraint(C constraintable);

    /**
     * Check if the specified object has the same parameters as this object. The
     * ID will NOT be checked.
     *
     * @param constraintable - The specified object.
     * @return true if the two objects has the parameter sets.
     */
    boolean hasSameParameters(C constraintable);
}
