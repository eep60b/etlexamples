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

import com.etlsolutions.examples.data.general.ImmutableDate;
import java.util.Date;

/**
 * The DateWrapper class represents a date value.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public abstract class DateWrapper extends TypedValueWrapper<Date> {

    /**
     * Construct an object use the given Date object.
     * 
     * @param value - The Date object. 
     */
    public DateWrapper(Date value) {
        super(new ImmutableDate(value));
    }
}
