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
package com.etlsolutions.examples.database.maplist;

import com.etlsolutions.examples.data.DateTimeGenerator;
import com.etlsolutions.examples.data.RandomNumberGenerator;
import com.etlsolutions.examples.data.RandomStringGenerator;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class VoucherMapList.
 *
 * @author Zhipeng Chang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({VoucherMapList.class, RandomStringGenerator.class})
public final class VoucherMapListTest {

    private final RandomStringGenerator randomStringGenerator = PowerMockito.mock(RandomStringGenerator.class);
    private final RandomNumberGenerator randomNumberGenerator = PowerMockito.mock(RandomNumberGenerator.class);
    private final DateTimeGenerator dateTimeGenerator = PowerMockito.mock(DateTimeGenerator.class);

    @Before
    public void setUp() {
    }

    /**
     * Test of createMap method, of class VoucherMapList.
     */
    @Test
    public void testCreateMap() {
        System.out.println("createMap");
        Integer[] ids = null;
        VoucherMapList instance = null;
        Map<String, Object> expResult = null;
        Map<String, Object> result = instance.createMap(ids);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
