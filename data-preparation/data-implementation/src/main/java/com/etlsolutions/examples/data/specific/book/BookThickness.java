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
package com.etlsolutions.examples.data.specific.book;

import com.etlsolutions.examples.data.general.wrapper.BigDecimalValueWrapper;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.math.BigDecimal;

/**
 * The BookThickness class represents the thickness of a book.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class BookThickness extends BigDecimalValueWrapper {

    private static final int SCALE = 1;

    private static final BookThickness DEFAULT_BOOK_THICKNESS = new BookThickness(BigDecimal.ZERO);

    /**
     * 
     * @param value 
     */
    public BookThickness(BigDecimal value) {
        super(value, SCALE);
    }

    /**
     * 
     * @param value 
     */
    public BookThickness(double value) {
        this(new BigDecimal(value));
    }    
    
    /**
     * Get a default instance with zero thickness.
     * @return the default instance.
     */
    public static BookThickness getDefault() {
        return DEFAULT_BOOK_THICKNESS;
    }
}
