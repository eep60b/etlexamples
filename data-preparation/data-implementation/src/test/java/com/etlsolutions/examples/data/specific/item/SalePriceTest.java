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
 * Test of class SalePrice.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SalePriceTest {

    /**
     * Test of constructor.
     */
    @Test
    public void testConstructor() {

        SalePrice instance1 = new SalePrice(28.564);
        SalePrice instance2 = new SalePrice(new BigDecimal(28.564));

        assertTrue(NumberUtilities.equals(new BigDecimal(28.56), instance1.getValue()));
        assertTrue(NumberUtilities.equals(new BigDecimal(28.56), instance2.getValue()));
    }
    
    /**
     * Test of public static fields.
     */
    @Test
    public void testStaticField() {
        assertTrue(NumberUtilities.equals(new BigDecimal(0), SalePrice.ZERO.getValue()));
    }

}
