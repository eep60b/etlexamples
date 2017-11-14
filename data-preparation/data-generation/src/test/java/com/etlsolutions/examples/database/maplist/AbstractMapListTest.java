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

import com.etlsolutions.examples.data.KeyGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class AbstractMapList.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({AbstractMapList.class})
public final class AbstractMapListTest {

    private final KeyGenerator keyGenerator = PowerMockito.mock(KeyGenerator.class);
    @SuppressWarnings("unchecked")
    private final List<Integer> ids1 = Mockito.mock(List.class);
    @SuppressWarnings("unchecked")
    private final List<Integer> ids2 = Mockito.mock(List.class);
    private final List<Integer> indexes1 = Arrays.asList(1, 2);
    private final List<Integer> indexes2 = Arrays.asList(1, 2);
    private final int size1 = 2;
    private final SequenceIdGenerationDefinition definition1 = new SequenceIdGenerationDefinition(size1, 10, 2);     
    private final IdGenerationDefinition definition2 = Mockito.mock(IdGenerationDefinition.class);    
    private final int size2 = 1;       
    private final String key = "2203";
    private final Object value = Mockito.mock(Object.class);
    
    @SuppressWarnings("unchecked")
    private final Map<String, Object> map11 = Mockito.mock(Map.class);
    @SuppressWarnings("unchecked")
    private final Map<String, Object> map12 = Mockito.mock(Map.class);
    private final List<Map<String, Object>> maps1 = Arrays.asList(map11, map12);
    
    @SuppressWarnings("unchecked")
    private final Map<String, Object> map21 = Mockito.mock(Map.class);
    private final List<Map<String, Object>> maps2 = Arrays.asList(map21);
    
    private AbstractMapList instance1;
    private AbstractMapList instance2;
    
    @Before
    public void setUp() throws Exception {
        
        PowerMockito.whenNew(KeyGenerator.class).withNoArguments().thenReturn(keyGenerator);
        Mockito.when(definition2.getSize()).thenReturn(size2);
        
        Mockito.when(keyGenerator.generateSequenceKeyList(size1, 0, 1)).thenReturn(indexes1);
        Mockito.when(keyGenerator.generateSequenceKeyList(size2, 0, 1)).thenReturn(indexes2);
        
        Mockito.when(keyGenerator.generateSequenceKeyList(size1, 10, 2)).thenReturn(ids1);
        Mockito.when(keyGenerator.generateRamdonKeys(size2)).thenReturn(ids2);
        
        instance1 = new AbstractMapListImpl(definition1);
        instance2 = new AbstractMapListImpl(definition2);        
    }

    /**
     * Test of getIds method.
     */
    @Test
    public void testGetIds() {
        assertEquals(ids1, instance1.getIds());
        assertEquals(ids2, instance2.getIds());        
    }

    /**
     * Test of getMap method.
     */
    @Test
    public void testGetMap() {

        instance1.setMaps(maps1);
        Mockito.when(map11.get(key)).thenReturn(value);

        assertEquals(map11, instance1.getMap(key, value));
    }

    /**
     * Test of getMap method.
     */
    @Test
    public void testGetMap_null() {
        
        instance1.setMaps(maps1);
        
        assertNull(instance1.getMap(key, value));
    }

    /**
     * Test of getMaps method.
     */
    @Test
    public void testGetMaps() {
        assertTrue(instance1.getMaps().isEmpty());
    }

    /**
     * Test of setMaps method.
     */
    @Test
    public void testSetMaps() {

        instance1.setMaps(maps1);
        assertEquals(maps1, instance1.getMaps());
    }

    /**
     * Test of initMaps method.
     */
    @Test
    public void testInitMaps() {
        Mockito.when(ids1.get(0)).thenReturn(1);
        Mockito.when(ids1.get(1)).thenReturn(4);
        
        instance1.initMaps();
        assertEquals(maps1, instance1.getMaps());        
    }

    /**
     * Test of initMaps method.
     */
    @Test
    public void testInitMaps_NoIds() {
        
        Mockito.when(ids1.isEmpty()).thenReturn(true);
        
        instance1.initMaps();
        assertEquals(maps2, instance1.getMaps());        
    }    
    
    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {
        
        instance1.setMaps(maps1);
        instance2.setMaps(maps1);
        assertEquals(instance2.hashCode(), instance1.hashCode());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode_false() {
        
        instance1.setMaps(maps1);
        instance2.setMaps(maps2);
        assertNotEquals(instance2.hashCode(), instance1.hashCode());
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {
        
        instance1.setMaps(maps1);
        instance2.setMaps(maps1);
        
        assertTrue(instance1.equals(instance2));
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_Same() {
        
        instance1.setMaps(maps1);        
        assertTrue(instance1.equals(instance1));
    }    
    
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_false() {
        
        instance1.setMaps(maps1);
        instance2.setMaps(maps2);
        
        assertFalse(instance1.equals(instance2));
    }    
    
    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals_null() {
        
        assertFalse(instance1.equals(null));
    }
    
    /**
     * Test of equals method.
     */
    @Test
    public void testEquals_OtherObject() {
        
        assertFalse(instance1.equals(new Object()));
    }    
    
    private final class AbstractMapListImpl extends AbstractMapList {

        public AbstractMapListImpl(IdGenerationDefinition definition) {
            super(definition);
        }

        @Override
        public Map<String, Object> createMap(Integer... ids) {
            for(int id : ids) {
                if(id == 1) {
                    return map11;
                } 
                
                if(id == 4) {
                    return map12;
                }  
                     
            }
            
            return map21;
        }
    }
}
