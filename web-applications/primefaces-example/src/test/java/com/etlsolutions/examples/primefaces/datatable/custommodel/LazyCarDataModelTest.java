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
package com.etlsolutions.examples.primefaces.datatable.custommodel;

import com.etlsolutions.examples.primefaces.data.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 * Test of class LazyCarDataModel.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class LazyCarDataModelTest {

    private final Car car1 = new Car("car1", "Ford", 1922, "blue", 2123.22, true);
    private final Car car2 = new Car("bar1", "BMW", 1931, "red", 8223.54, true);
    private final Car car3 = new Car("dar1", "BMW", 1998, "blue", 3242.78, false);
    private final Car car4 = new Car("aar1", "Ford", 1913, "brown", 5577.00, true);
    private final Car car5 = new Car("ear1", "Nissan", 1947, "red", 7863.98, false);
    private final Car car6 = new Car("far1", "Ford", 1998, "blue", 2123.22, true);

    private final List<Car> cars = Arrays.asList(car1, car2, car3, car4, car5);

    private final Map<String, Object> filters = new HashMap<>();

    private final LazyCarDataModel instance = new LazyCarDataModel(cars);

    @Before
    public void setUp() {
    }

    /**
     * Test of getRowData method.
     */
    @Test
    public void testGetRowData() {
        assertEquals(car3, instance.getRowData("dar1"));
    }

    /**
     * Test of getRowData method.
     */
    @Test
    public void testGetRowData_null() {
        assertNull(instance.getRowData("far1"));
    }

    /**
     * Test of getRowKey method.
     */
    @Test
    public void testGetRowKey() {
        assertEquals("aar1", instance.getRowKey(car4));
    }

    /**
     * Test of getRowKey method.
     */
    @Test
    public void testGetRowKey_null() {
        assertNull(instance.getRowKey(car6));
    }

    /**
     * Test of load method.
     */
    @Test
    public void voidtestLoad_4args() {
        assertEquals(Arrays.asList(car1, car2, car3, car4, car5), instance.load(0, 5, null, null));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_filter_empty() {

        assertEquals(Arrays.asList(car1, car2, car3, car4, car5), instance.load(0, 5, null, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_filter_normal() {

        filters.put("color", "b");

        assertEquals(Arrays.asList(car1, car3, car4), instance.load(0, 5, null, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_filter_normal_2() {
        filters.put("brand", "B");
        filters.put("color", "b");

        assertEquals(Arrays.asList(car3), instance.load(0, 5, null, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_sort_ascending() {

        SortMeta sortMeta1 = new SortMeta(null, "color", SortOrder.ASCENDING, null);
        SortMeta sortMeta2 = new SortMeta(null, "id", SortOrder.ASCENDING, null);
        List<SortMeta> sortMetas = Arrays.asList(sortMeta1, sortMeta2);

        assertEquals(Arrays.asList(car4, car2, car1, car3, car5), instance.load(0, 5, sortMetas, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_sort_descending() {

        SortMeta sortMeta1 = new SortMeta(null, "color", SortOrder.DESCENDING, null);
        SortMeta sortMeta2 = new SortMeta(null, "id", SortOrder.DESCENDING, null);
        List<SortMeta> sortMetas = Arrays.asList(sortMeta1, sortMeta2);
        assertEquals(Arrays.asList(car5, car3, car1, car2, car4), instance.load(0, 5, sortMetas, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_sort_unsorted() {
        SortMeta sortMeta1 = new SortMeta(null, "color", SortOrder.UNSORTED, null);
        SortMeta sortMeta2 = new SortMeta(null, "id", SortOrder.UNSORTED, null);
        List<SortMeta> sortMetas = Arrays.asList(sortMeta1, sortMeta2);

        assertEquals(Arrays.asList(car1, car2, car3, car4, car5), instance.load(0, 5, sortMetas, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_sort_mixture_1() {

        SortMeta sortMeta1 = new SortMeta(null, "color", SortOrder.ASCENDING, null);
        SortMeta sortMeta2 = new SortMeta(null, "id", SortOrder.DESCENDING, null);
        List<SortMeta> sortMetas = Arrays.asList(sortMeta1, sortMeta2);
        assertEquals(Arrays.asList(car5, car3, car1, car2, car4), instance.load(0, 5, sortMetas, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_sort_mixture_2() {
        
        SortMeta sortMeta2 = new SortMeta(null, "id", SortOrder.DESCENDING, null);        
        SortMeta sortMeta1 = new SortMeta(null, "color", SortOrder.DESCENDING, null);
        List<SortMeta> sortMetas = Arrays.asList(sortMeta1, sortMeta2);
        assertEquals(Arrays.asList(car5, car3, car1, car2, car4), instance.load(0, 5, sortMetas, filters));
    }


    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_sort_mixture_3() {
        
        SortMeta sortMeta1 = new SortMeta(null, "id", SortOrder.ASCENDING, null);        
        SortMeta sortMeta2 = new SortMeta(null, "color", SortOrder.ASCENDING, null);
        List<SortMeta> sortMetas = Arrays.asList(sortMeta1, sortMeta2);
        assertEquals(Arrays.asList(car1, car3, car4, car2, car5), instance.load(0, 5, sortMetas, filters));
    }
    
    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_sort_mixture_4() {
        
        SortMeta sortMeta1 = new SortMeta(null, "id", SortOrder.ASCENDING, null);        
        SortMeta sortMeta2 = new SortMeta(null, "color", SortOrder.DESCENDING, null);
        List<SortMeta> sortMetas = Arrays.asList(sortMeta1, sortMeta2);
        assertEquals(Arrays.asList(car2, car5, car4, car1, car3), instance.load(0, 5, sortMetas, filters));
    }    
    
    
    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_paginate_1() {
        List<SortMeta> sortMetas = new ArrayList<>();
        assertEquals(Arrays.asList(car1, car2, car3), instance.load(0, 3, sortMetas, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_4args_paginate_2() {
        List<SortMeta> sortMetas = new ArrayList<>();
        assertEquals(Arrays.asList(car4, car5), instance.load(3, 3, sortMetas, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args() {
        assertEquals(Arrays.asList(car1, car2, car3, car4, car5), instance.load(0, 5, null, null, null));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_filter_empty() {

        assertEquals(Arrays.asList(car1, car2, car3, car4, car5), instance.load(0, 5, null, null, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_filter_normal() {

        filters.put("color", "b");

        assertEquals(Arrays.asList(car1, car3, car4), instance.load(0, 5, null, null, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_filter_normal_2() {
        filters.put("brand", "B");
        filters.put("color", "b");

        assertEquals(Arrays.asList(car3), instance.load(0, 5, null, null, filters));
    }

    /**
     * Test of load method.
     */
    @Test(expected = IllegalStateException.class)
    public void testLoad_5args_filter_exception_1() {
        filters.put("brandy", "B");
        instance.load(0, 5, null, null, filters);
    }   
    
    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_sort_ascending() {

        assertEquals(Arrays.asList(car4, car2, car1, car3, car5), instance.load(0, 5, "id", SortOrder.ASCENDING, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_sort_descending() {

        assertEquals(Arrays.asList(car5, car3, car1, car2, car4), instance.load(0, 5, "id", SortOrder.DESCENDING, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_sort_unsorted() {

        assertEquals(Arrays.asList(car1, car2, car3, car4, car5), instance.load(0, 5, "id", SortOrder.UNSORTED, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_paginate_1() {

        assertEquals(Arrays.asList(car1, car2, car3), instance.load(0, 3, "id", SortOrder.UNSORTED, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_paginate_2() {

        assertEquals(Arrays.asList(car4, car5), instance.load(3, 3, "id", SortOrder.UNSORTED, filters));
    }

    /**
     * Test of load method.
     */
    @Test
    public void testLoad_5args_paginate_3() {

        assertEquals(Arrays.asList(car3, car4), instance.load(2, 2, "id", SortOrder.UNSORTED, filters));
    }    
    
}
