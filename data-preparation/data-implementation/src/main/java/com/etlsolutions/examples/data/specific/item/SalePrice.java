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
package com.etlsolutions.examples.data.specific.item;

import com.etlsolutions.examples.data.general.wrapper.BigDecimalValueWrapper;
import java.math.BigDecimal;

/**
 * The SalePrice class represents the sale price of an item.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SalePrice extends BigDecimalValueWrapper {

    /**
     * The value 0. This is useful when the item is set to be free of charge.
     */
    public static final SalePrice ZERO = new SalePrice(0);

    /**
     *
     * @param value
     */
    public SalePrice(BigDecimal value) {
        super(value);
    }

    public SalePrice(double value) {
        this(new BigDecimal(value));
    }

}
