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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class NameComparator.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
public final class NameComparatorTest {

    private final Nameable nc1 = Mockito.mock(Nameable.class);
    private final Nameable nc2 = Mockito.mock(Nameable.class);
    private final NameComparator instance = new NameComparator();

    @Before
    public void setUp() {

    }

    /**
     * Test of compare method.
     */
    @Test
    public void testCompare() {
        Mockito.when(nc1.getName()).thenReturn("aldad");
        Mockito.when(nc2.getName()).thenReturn("aldad");

        assertEquals(0, instance.compare(nc1, nc2));
    }

    /**
     * Test of compare method.
     */
    @Test
    public void testCompare_null_names() {
        assertEquals(0, instance.compare(nc1, nc2));
    }    
    
    /**
     * Test of compare method.
     */
    @Test
    public void testCompare_great() {
        Mockito.when(nc1.getName()).thenReturn("bldad");
        Mockito.when(nc2.getName()).thenReturn("aldad");

        assertTrue(instance.compare(nc1, nc2) > 0);
    }

    /**
     * Test of compare method.
     */
    @Test
    public void testCompare_less() {
        Mockito.when(nc1.getName()).thenReturn("aldad");
        Mockito.when(nc2.getName()).thenReturn("bldad");

        assertTrue(instance.compare(nc1, nc2) < 0);
    }
    
    /**
     * Test of compare method.
     */
    @Test
    public void testCompare_null_name_1() {
        Mockito.when(nc2.getName()).thenReturn("aldad");

        assertTrue(instance.compare(nc1, nc2) < 0);
    }

    /**
     * Test of compare method.
     */
    @Test
    public void testCompare_less_null_name_2() {
        Mockito.when(nc1.getName()).thenReturn("aldad");
 
        assertTrue(instance.compare(nc1, nc2) > 0);
    }    
    
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {

        assertTrue(instance.equals(new NameComparator()));
    }


    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_other_object() {

        assertFalse(instance.equals(new Object()));
    }
    
    

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_null() {

        assertFalse(instance.equals(null));
    }    
     
    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        assertEquals(4322087, instance.hashCode());
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        assertEquals("NameComparator{hashcode=4322087}", instance.toString());
    }
}
