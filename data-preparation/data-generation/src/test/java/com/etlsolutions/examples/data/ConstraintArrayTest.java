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
package com.etlsolutions.examples.data;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class ConstraintArray.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ConstraintArrayTest {

    private final ConstraintArray instance1 = new ConstraintArray("kdakbc", new Integer(94341));
    private final ConstraintArray instance2 = new ConstraintArray("kdakbc", new Integer(94341));
    private final ConstraintArray instance3 = new ConstraintArray("kdbc", new Integer(94341));
    private final ConstraintArray instance4 = new ConstraintArray("kdakbc", new Integer(941));

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(instance2.hashCode(), instance1.hashCode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_False_1() {
        assertNotEquals(instance3.hashCode(), instance1.hashCode());
    }

    
    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_False_2() {
        assertNotEquals(instance4.hashCode(), instance1.hashCode());
    }
  
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {
        assertTrue(instance1.equals(instance2));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_Not_1() {
        assertFalse(instance1.equals(instance3));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_Not_2() {
        assertFalse(instance1.equals(instance4));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_Other_Object() {
        assertFalse(instance1.equals(new Object()));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_NULL() {
        assertFalse(instance1.equals(null));
    }    

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConstraintArray instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
