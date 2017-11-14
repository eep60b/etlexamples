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

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test of class BookLength.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BookLengthTest {

    /**
     * Test of method getValue.
     */
    @Test
    public void testConstructor() {

        BookLength instance1 = new BookLength(new BigDecimal(3.777));

        assertEquals(new BigDecimal(3.8).setScale(1, BigDecimal.ROUND_HALF_UP), instance1.getValue());
    }

    @Test
    public void testStaticFields() {
        assertEquals(BigDecimal.ZERO.setScale(1, BigDecimal.ROUND_HALF_UP), BookLength.ZERO.getValue());
    }
}
