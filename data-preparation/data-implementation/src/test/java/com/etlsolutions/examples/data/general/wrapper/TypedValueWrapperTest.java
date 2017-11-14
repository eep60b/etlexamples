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

import com.etlsolutions.examples.utility.annotation.DataClass;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class TypedValueWrapper.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class TypedValueWrapperTest {

    private final MockComparable comparable1 = new MockComparable("comaVale1");
    private final MockComparable comparable3 = new MockComparable("comaVale3");    
    
    private final TypedValueWrapper<MockComparable> instance1 = new MockTypedColumn(comparable1);
    private final TypedValueWrapper<MockComparable> instance2 = new MockTypedColumn(comparable1);
    private final TypedValueWrapper<MockComparable> instance3 = new MockTypedColumn(comparable3);
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testClassAnnotations(){
        Class<?> klass = TypedValueWrapper.class;
        assertEquals(1, klass.getAnnotations().length);
        assertTrue(klass.isAnnotationPresent(DataClass.class));
    }

    /**
     * Test of getValue method.
     */
    @Test
    public void testGetValue() {
 
        assertEquals(comparable1, instance1.getValue());
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
        assertTrue(instance1.equals(instance3));
        assertTrue(instance1.equals(null));
        assertTrue(instance1.equals(new Object()));        
    }

    /**
     * Test of compareTo method.
     */
    @Test
    public void testCompareTo() {

        assertEquals(0, instance1.compareTo(instance2));
        assertTrue(instance1.compareTo(instance3) < 0);
        assertTrue(instance1.compareTo(instance3) < 0);
        assertTrue(instance1.compareTo(new MockTypedColumn(null)) > 0);        
        assertTrue(new MockTypedColumn(null).compareTo(instance3) < 0);
        assertTrue(instance3.compareTo(instance1) < 0);        
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("MockTypedColumn{value=comaVale1}", instance1.toString());
    }

    private final class MockComparable implements Comparable<MockComparable> {

        private final String value;

        public MockComparable(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(MockComparable o) {
            if (o == null) {
                return 1;
            }

            if (value == null && o.value == null) {
                return 0;
            }

            if (value == null && o.value != null) {
                return -1;
            }

            return value.compareTo(o.value);
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 41 * hash + Objects.hashCode(this.value);
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
            
            final MockComparable other = (MockComparable) obj;
            
            return Objects.equals(this.value, other.value);
        }
    }

    private final class MockTypedColumn extends TypedValueWrapper<MockComparable> {

        public MockTypedColumn(MockComparable value) {
            super(value);
        }
    }
}
