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
 * The ConventionalJavaBeanClass annotation indicates that a class is JavaBean.
 *
 * It will also follow these conventions:
 *
 * 1. The class must have a public default constructor (with no arguments). This
 * allows easy instantiation within editing and activation frameworks.
 *
 * 2. The class properties must be accessible using get, set, is (can be used
 * for boolean properties instead of get), and other methods (so-called accessor
 * methods and mutator methods) according to a standard naming convention. This
 * allows easy automated inspection and updating of bean state within
 * frameworks, many of which include custom editors for various types of
 * properties. Setters can have one or more than one argument.
 *
 * 3. The class should be serialisable. [This allows applications and frameworks
 * to reliably save, store, and restore the bean's state in a manner independent
 * of the VM and of the platform.]
 *
 * 4. The class itself should NOT be marked as final.
 * 
 * 5. No methods should be marked as final.
 * 
 * This annotation applies at class level only.
 *
 * @author Zhipeng Chang
 * @version 1.0.0
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ConventionalJavaBeanClass {

}
