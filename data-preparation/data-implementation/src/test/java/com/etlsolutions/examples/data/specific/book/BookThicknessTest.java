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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test of class BookThickness.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class BookThicknessTest {

    /**
     * Test of constructor.
     */
    @Test
    public void testGetValue() {

        BookThickness instance1 = new BookThickness(23.97);
        BookThickness instance2 = new BookThickness(new BigDecimal(23.97));

        assertEquals(new BigDecimal(23.97), instance1.getValue());
        assertEquals(new BigDecimal(23.97), instance2.getValue());
    }

    /**
     * Test of getDefault method.
     */
    @Test
    public void testGetDefault() {

        assertEquals(new BookThickness(BigDecimal.ZERO), BookThickness.getDefault());
        assertFalse(BookThickness.getDefault() == new BookThickness(BigDecimal.ZERO));        
        assertTrue(BookThickness.getDefault() == BookThickness.getDefault());    
    }
}
