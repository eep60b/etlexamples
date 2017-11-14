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
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ExpireDateTest {

    @Test
    public void testConstructor() {

        Date before = new Date();
        ExpireDate instance1 = new ExpireDate();
        Date after = new Date();
        ExpireDate instance2 = new ExpireDate(new Date(691249047391247L));
        ExpireDate instance3 = new ExpireDate(691249047391247L);

        assertTrue(before.getTime() <= instance1.getValue().getTime());
        assertTrue(after.getTime() >= instance1.getValue().getTime());
        assertEquals(new Date(691249047391247L), instance2.getValue());
        assertEquals(new Date(691249047391247L), instance3.getValue());
    }
}
