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
package com.etlsolutions.examples.data.specific.payment;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class StartDate
 *
 * @author Zhipeng Chang
 *
 *@since 1.0.0
 * 
 * @version 1.0.0
 */
public final class StartDateTest {

    /**
     * Test of constructor.
     */
    @Test
    public void testConstructor() {
        
        Date before = new Date();
        StartDate instance1 = new StartDate();
        Date after = new Date();
        assertTrue(instance1.getValue().getTime() >= before.getTime());
        assertTrue(instance1.getValue().getTime() <= after.getTime());
        
        Date date = new Date(2319889L);
        StartDate instance2 = new StartDate(date);
        assertEquals(date, instance2.getValue());
        
        StartDate instance3 = new StartDate(2319889L);
        assertEquals(date, instance3.getValue());        
    }
}
