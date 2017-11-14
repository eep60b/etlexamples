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

import com.etlsolutions.examples.data.specific.book.BookWidth;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class BookWidth.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BookWidthTest {

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        BookWidth instance1 = new BookWidth();
        assertEquals(new BigDecimal(0).setScale(1, RoundingMode.HALF_UP), instance1.getValue());

        BookWidth instance2 = new BookWidth(new BigDecimal(3828.771));
        assertEquals(new BigDecimal(3828.83).setScale(1, RoundingMode.HALF_UP), instance2.getValue());
    }
}
