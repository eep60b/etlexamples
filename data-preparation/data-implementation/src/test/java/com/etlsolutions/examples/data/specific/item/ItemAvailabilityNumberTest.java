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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ItemAvailabilityNumber.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ItemAvailabilityNumberTest {

    /**
     * Test of constructors.
     */
    @Test
    public void testConstructor() {

        ItemAvailabilityNumber instance1 = new ItemAvailabilityNumber(20);

        assertTrue(instance1.getValue() == 20);
    }
    
    @Test
    public void testPublicFields(){
        assertEquals(new ItemAvailabilityNumber(0), ItemAvailabilityNumber.ZERO);
    }
}
