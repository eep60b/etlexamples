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
package com.etlsolutions.examples.data.general;

import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class StringKeyValuePair.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class StringKeyValuePairTest {

    private final String key1 = "sgngkey1";
    private final String key2 = "sgngkey2";
    private final String valueString1 = "valiekl1";
    private final String valueString2 = "valiekl2";
    private final Object value1 = new MockObject(valueString1);
    private final Object value2 = new MockObject(valueString2);    
    private final StringKeyValuePair instance = new StringKeyValuePair(key1, value1);      
    private final StringKeyValuePair instance11 = new StringKeyValuePair(key1, value1);    
    private final StringKeyValuePair instance12 = new StringKeyValuePair(key1, value2);
    private final StringKeyValuePair instance21 = new StringKeyValuePair(key2, value1);

    /**
     * Test of getKey method.
     */
    @Test
    public void testGetKey() {
        
        assertEquals(key1, instance.getKey());
    }

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
        
        assertEquals(value1, instance.getValue());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(instance11.hashCode(), instance.hashCode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_false() {
        assertNotEquals(instance12.hashCode(), instance.hashCode());
        assertNotEquals(instance21.hashCode(), instance.hashCode());        
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {
        assertTrue(instance.equals(instance));        
        assertTrue(instance.equals(instance11));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_false() {
        assertFalse(instance.equals(null));        
        assertFalse(instance.equals(instance12));
        assertFalse(instance.equals(instance21));
        assertFalse(instance.equals(new Object()));        
    }    

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("StringKeyValuePair{key=sgngkey1, value=valiekl1}", instance.toString());
    }

    
    private final class MockObject {
        private final String value;

        public MockObject(String value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 19 * hash + Objects.hashCode(this.value);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final MockObject other = (MockObject) obj;
            return Objects.equals(this.value, other.value);
        }

        @Override
        public String toString() {
            return value;
        }   
    }
}
