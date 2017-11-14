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
package com.etlsolutions.examples.utility.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The StatelessClass annotation indicates a stateless operation class.
 * 
 * A stateless operation class is define as such:
 * 
 * 1. The class must be final.
 * 2. The class has no field which can be modified.
 * 3. It contains no data information, i.e. it doesn't cache any data.
 * 4. The class can ONLY have unmodifiable field for its own usage, therefore it is thread-safe.
 * 5. It is advisory that the equals method of a stateless operation class should be implemented to return true all the time when it is compared to another object with the same type,
 * since any object of this class will operate the same way.
 * 
 * This annotation applies at class level only.
 * 
 * @author Zhipeng Chang
 * @version 1.0.0
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface StatelessClass {
    
}
