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

import com.etlsolutions.examples.utility.NumberUtilities;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ListPrice.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ListPriceTest {

    /**
     * Test of method getValue.
     */
    @Test
    public void testGetValue() {

        ListPrice instance1 = new ListPrice(new BigDecimal(23.11));
        ListPrice instance2 = new ListPrice(23.11);
        ListPrice instance3 = new ListPrice();

        assertTrue(NumberUtilities.equals(new BigDecimal(23.11), instance1.getValue()));
        assertTrue(NumberUtilities.equals(new BigDecimal(23.11), instance2.getValue()));
        assertTrue(NumberUtilities.equals(new BigDecimal(0), instance3.getValue()));
    }

}
