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

import com.etlsolutions.examples.base.configuration.SystemConstants;
import java.math.BigDecimal;

/**
 * The BigDecimalValueWrapper class is an abstract class which can be extended by classes which represents a numeric value.
 * 
 * All the rounding mode is defined as RoundingMode.UP.
 * 
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public abstract class BigDecimalValueWrapper extends TypedValueWrapper<BigDecimal> {

    
    /**
     * Construct an object.
     * @param value - The column value.
     * @param scale - The value scale.
     * @param rounding - The rounding.
     */
    public BigDecimalValueWrapper(BigDecimal value, int scale, int rounding) {
        super(value.setScale(scale, rounding));
    }
    
    /**
     * Construct an object.
     * @param value - The column value.
     * @param scale - The value scale.
     */
    public BigDecimalValueWrapper(BigDecimal value, int scale) {
        this(value, scale, SystemConstants.DEFAULT_ROUNDIND);
    }
    
        /**
     * Construct an object.
     * @param value - The column value.
     */
    public BigDecimalValueWrapper(BigDecimal value) {
        this(value, SystemConstants.DEFAULT_SCALE);
    }
}
