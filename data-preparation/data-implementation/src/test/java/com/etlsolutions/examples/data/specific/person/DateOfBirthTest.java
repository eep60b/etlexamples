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
package com.etlsolutions.examples.data.specific.person;

import com.etlsolutions.examples.data.specific.person.DateOfBirth;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class DateOfBirth.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class DateOfBirthTest {

    /**
     * Test of getValue method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testGetValue() throws Exception {

        Date before = new Date();
        DateOfBirth instance1 = new DateOfBirth();
        Date after = new Date();
        
        assertTrue(before.getTime() <= instance1.getValue().getTime());
        assertTrue(after.getTime()  >= instance1.getValue().getTime());        

        DateOfBirth instance2 = new DateOfBirth(new Date(39134190893L));        
        assertEquals(new Date(39134190893L), instance2.getValue());
    }

}
