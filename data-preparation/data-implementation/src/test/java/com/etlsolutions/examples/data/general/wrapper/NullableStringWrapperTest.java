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
package com.etlsolutions.examples.data.general.wrapper;

import com.etlsolutions.examples.data.general.wrapper.NullableStringWrapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class NullableStringWrapper.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class NullableStringWrapperTest {

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        NullableStringWrapper instance1 = new NullableStringWrapper("klainlalin");
        NullableStringWrapper instance2 = new NullableStringWrapper(null);
        assertEquals("klainlalin", instance1.getValue());
        assertEquals("", instance2.getValue());
    }
}
