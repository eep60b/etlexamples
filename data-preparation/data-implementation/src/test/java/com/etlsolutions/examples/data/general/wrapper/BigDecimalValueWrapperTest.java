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

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class BigDecimalValueWrapper
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BigDecimalValueWrapperTest {

    /**
     * Test of method getValue.
     */
    @Test
    public void testGetValue() {

        assertEquals(new BigDecimal(12.64).setScale(2, BigDecimal.ROUND_HALF_DOWN), new MockBigDecimalColumn(new BigDecimal(12.646), 2, BigDecimal.ROUND_HALF_DOWN).getValue());

        assertEquals(new BigDecimal(12.65).setScale(2, BigDecimal.ROUND_HALF_UP), new MockBigDecimalColumn(new BigDecimal(12.646), 2).getValue());
        assertEquals(new BigDecimal(12.65).setScale(2, BigDecimal.ROUND_HALF_UP), new MockBigDecimalColumn(new BigDecimal(12.651), 2).getValue());

        assertEquals(new BigDecimal(12.65).setScale(2, BigDecimal.ROUND_HALF_UP), new MockBigDecimalColumn(new BigDecimal(12.646)).getValue());
    }

    private static final class MockBigDecimalColumn extends BigDecimalValueWrapper {

        public MockBigDecimalColumn(BigDecimal value, int scale, int rounding) {
            super(value, scale, rounding);
        }

        public MockBigDecimalColumn(BigDecimal value, int scale) {
            super(value, scale);
        }

        public MockBigDecimalColumn(BigDecimal value) {
            super(value);
        }
    }
}
