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

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class PublishDate.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class PublishDateTest {

    /**
     * Test of constructor.
     */
    @Test
    public void testConstructor() {
        PublishDate instance1 = new PublishDate(new Date(1947671238545L));
        Date before = new Date();
        PublishDate instance2 = new PublishDate();
        Date after = new Date();
        PublishDate instance3 = new PublishDate(1947671238545L);
        
        assertEquals(new Date(1947671238545L), instance1.getValue());
        assertTrue(before.getTime() <= instance2.getValue().getTime());
        assertTrue(after.getTime() >= instance2.getValue().getTime());        
        assertEquals(new Date(1947671238545L), instance3.getValue());
    }

}
