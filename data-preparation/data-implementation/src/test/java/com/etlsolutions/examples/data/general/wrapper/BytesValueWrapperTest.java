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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class BytesValueWrapper.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @author 1.0.0
 */
public final class BytesValueWrapperTest {

    
    private final byte[] value1 = {12, 32, 14, 121};
    private final byte[] value2 = {12, 32, 14, 121};
    private final byte[] value3 = {12, 32, 14, 123};
    private final BytesValueWrapper instance1 = new MockBytesColumn(value1);
    private final BytesValueWrapper instance2 = new MockBytesColumn(value2);    
    private final BytesValueWrapper instance3 = new MockBytesColumn(value3); 
    private final BytesValueWrapper instance4 = new MockBytesColumn(null); 

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {

        assertArrayEquals(new byte[]{12, 32, 14, 121}, instance1.getValue());
        instance1.getValue()[2] = 11;
        assertArrayEquals(new byte[]{12, 32, 14, 121}, instance1.getValue()); 
        value1[3] = 4;
        assertArrayEquals(new byte[]{12, 32, 14, 121}, instance1.getValue());
        
        assertNull(instance4.getValue());
    }  

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(instance2.hashCode(), instance1.hashCode());
        assertNotEquals(instance3.hashCode(), instance1.hashCode());
    }
    
    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {
        assertTrue(instance1.equals(instance1));
        assertTrue(instance1.equals(instance2));
        assertFalse(instance1.equals(instance3));        
        assertFalse(instance1.equals(new Object())); 
        assertFalse(instance1.equals(null));            
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        assertEquals("MockBytesColumn{value=", instance1.toString());
    }

    private static final class MockBytesColumn extends BytesValueWrapper {

        public MockBytesColumn(byte[] value) {
            super(value);
        }
    }
}
