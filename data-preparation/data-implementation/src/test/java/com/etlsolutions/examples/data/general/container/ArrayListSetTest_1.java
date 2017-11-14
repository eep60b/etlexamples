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
package com.etlsolutions.examples.data.general.container;

import com.etlsolutions.examples.data.general.container.ArrayListSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

/**
 * Test of class ArrayListSet.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@PrepareForTest({ArrayListSet.class})
public final class ArrayListSetTest_1 {

    @Rule
    public final PowerMockRule rule = new PowerMockRule();
    
    private final ArrayList innerList = Mockito.mock(ArrayList.class);
    
    private ArrayListSet<String> instance;
  
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(ArrayList.class).withNoArguments().thenReturn(innerList);
        instance = new ArrayListSet<>();
    }

    /**
     * Test of trimToSize method.
     */
    @Test
    public void testTrimToSize() {
       
        instance.trimToSize();
        
        Mockito.verify(innerList).trimToSize();
    }

    /**
     * Test of ensureCapacity method.
     */
    @Test
    public void testEnsureCapacity() {
        instance.ensureCapacity(5);
        Mockito.verify(innerList).ensureCapacity(5);
    }

    /**
     * Test of size method.
     */
    @Test
    public void testSize() {
        Mockito.when(innerList.size()).thenReturn(423243);
        assertEquals(423243, instance.size());
    }

    /**
     * Test of isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        Mockito.when(innerList.isEmpty()).thenReturn(Boolean.TRUE);
        
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of isEmpty method.
     */
    @Test
    public void testIsEmpty_False() {
        Mockito.when(innerList.isEmpty()).thenReturn(Boolean.FALSE);
        
        assertFalse(instance.isEmpty());
    }
 

    /**
     * Test of listIterator method.
     */
    @Test
    public void testListIterator_int() {
        
        int index = 2431;
        ListIterator listIterator = Mockito.mock(ListIterator.class);
        Mockito.when(instance.listIterator(index)).thenReturn(listIterator);
        assertEquals(listIterator, instance.listIterator(index));
    }

    /**
     * Test of listIterator method.
     */
    @Test
    public void testListIterator_0args() {
        
        ListIterator listIterator = Mockito.mock(ListIterator.class);
        
        Mockito.when(instance.listIterator()).thenReturn(listIterator);
        assertEquals(listIterator, instance.listIterator());
    }

    /**
     * Test of iterator method.
     */
    @Test
    public void testIterator() {

        Iterator iterator = Mockito.mock(Iterator.class);
        Mockito.when(instance.iterator()).thenReturn(iterator);
        
        assertEquals(iterator, instance.iterator());
    }

    /**
     * Test of forEach method.
     */
    @Test
    public void testForEach() {

        Consumer action = Mockito.mock(Consumer.class);
        instance.forEach(action);
        Mockito.verify(innerList).forEach(action);
    }

    /**
     * Test of spliterator method.
     */
    @Test
    public void testSpliterator() {

        Spliterator spliterator = Mockito.mock(Spliterator.class);
        Mockito.when(innerList.spliterator()).thenReturn(spliterator);       
        assertEquals(spliterator, instance.spliterator());
    }

    /**
     * Test of removeIf method.
     */
    @Test
    public void testRemoveIf() {

        Predicate filter = Mockito.mock(Predicate.class);
        Mockito.when(innerList.removeIf(filter)).thenReturn(Boolean.TRUE);
        assertTrue(instance.removeIf(filter));
        Mockito.when(innerList.removeIf(filter)).thenReturn(Boolean.FALSE);
        assertFalse(instance.removeIf(filter));        

    }

    /**
     * Test of replaceAll method.
     * @throws java.lang.Exception if the ArrayList cannot be mocked.
     */
    @Test
    public void testReplaceAll() throws Exception {
        ArrayList<String> oldList = Mockito.mock(ArrayList.class);
        PowerMockito.whenNew(ArrayList.class).withArguments(innerList).thenReturn(oldList);
        UnaryOperator unaryOperator = Mockito.mock(UnaryOperator.class);

        assertTrue(instance.replaceAll(unaryOperator));
        
        Mockito.verify(innerList).replaceAll(unaryOperator);
        
    }

    /**
     * Test of replaceAll method.
     * @throws java.lang.Exception if the ArrayList cannot be mocked.
     */
    @Test
    public void testReplaceAll_False() throws Exception {
        PowerMockito.whenNew(ArrayList.class).withArguments(innerList).thenReturn(innerList);
        UnaryOperator unaryOperator = Mockito.mock(UnaryOperator.class);

        assertFalse(instance.replaceAll(unaryOperator));
        
        Mockito.verify(innerList).replaceAll(unaryOperator);
        
    }    
    
    /**
     * Test of sort method.
     */
    @Test
    public void testSort() {

        Comparator c = Mockito.mock(Comparator.class);
        instance.sort(c);
        Mockito.verify(innerList).sort(c);
    }


    /**
     * Test of containsAll method.
     */
    @Test
    public void testContainsAll() {

        Collection c = Mockito.mock(Collection.class);
        Mockito.when(innerList.contains(c)).thenReturn(Boolean.TRUE);
        assertTrue(instance.containsAll(c));
        Mockito.when(innerList.contains(c)).thenReturn(Boolean.FALSE);
        assertFalse(instance.containsAll(c));        

    }


    /**
     * Test of stream method.
     */
    @Test
    public void testStream() {

        Stream stream = Mockito.mock(Stream.class);
        Mockito.when(innerList.stream()).thenReturn(stream);
        assertEquals(stream, instance.stream());
    }

    /**
     * Test of parallelStream method.
     */
    @Test
    public void testParallelStream() {
        Stream stream = Mockito.mock(Stream.class);
        Mockito.when(innerList.parallelStream()).thenReturn(stream);
        assertEquals(stream, instance.parallelStream());
    }

}
