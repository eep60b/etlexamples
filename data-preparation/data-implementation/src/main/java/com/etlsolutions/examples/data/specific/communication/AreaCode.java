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
package com.etlsolutions.examples.data.specific.communication;

import com.etlsolutions.examples.data.general.wrapper.StringWrapper;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;

/**
 * The AreaCode class represents a telephone area code.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
public final class AreaCode extends StringWrapper {

    /**
     * Construct a area code using the given string value.
     * @param value - The value string.
     */
    public AreaCode(String value) {
        super(value);
    }
}