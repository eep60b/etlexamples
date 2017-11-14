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
package com.etlsolutions.examples.database;

import com.etlsolutions.examples.data.general.container.MapList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 * Test of class InsertQueryUnit.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class InsertQueryUnitTest {

    private final String query = "query to run";
    private final String query1 = "query to select";
    private final MapList mapList = Mockito.mock(MapList.class);
    private final MapList mapList2 = Mockito.mock(MapList.class);

    private final InsertQueryUnit instance = new InsertQueryUnit(query, mapList);
    private final InsertQueryUnit instance00 = new InsertQueryUnit(query, mapList);
    private final InsertQueryUnit instance01 = new InsertQueryUnit(query1, mapList);
    private final InsertQueryUnit instance02 = new InsertQueryUnit(query, mapList2);

    /**
     * Test of getQuery method.
     */
    @Test
    public void testGetQuery() {

        assertEquals("query to run", instance.getQuery());
    }

    /**
     * Test of getMapList method.
     */
    @Test
    public void testGetMapList() {

        assertEquals(mapList, instance.getMapList());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(new Object()));
        assertFalse(instance.equals(null));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        Mockito.when(mapList.toString()).thenReturn("my list");
        assertEquals("InsertQueryUnit{query=query to run, mapList=my list}", instance.toString());
    }
}
