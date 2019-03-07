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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 * The LazyCarDataModel class is an implementation of LazyDataModel that uses a
 * list to mimic a real data source like a database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class LazyCarDataModel extends LazyDataModel<Car> {

    private static final long serialVersionUID = 886732626550437281L;

    private final List<Car> datasource;

    public LazyCarDataModel(List<Car> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Car getRowData(String rowKey) {
        for (Car car : datasource) {
            if (car.getId().equals(rowKey)) {
                return car;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(Car car) {
        if (datasource.contains(car)) {

            return car.getId();
        }

        return null;
    }

    @Override
    public List<Car> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {

        //filter
        List<Car> data = filter(filters);

        //sort
        if (multiSortMeta != null) {
            for (SortMeta meta : multiSortMeta) {
                data.sort(new LazySorter(meta.getSortField(), meta.getSortOrder()));
            }
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        return paginate(dataSize, pageSize, data, first);
    }

    @Override
    public List<Car> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        //filter
        List<Car> data = filter(filters);

        //sort
        if (sortField != null) {
            data.sort(new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        return paginate(dataSize, pageSize, data, first);
    }

    //PrimeFaces won't handle the RuntimeExceptions very well. Those exceptions should be logged before thrown out again. 
    private List<Car> filter(Map<String, Object> filters) {
        List<Car> data = new ArrayList<>();
        for (Car car : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        Field field = car.getClass().getDeclaredField(filterProperty);
                        field.setAccessible(true);
                        String fieldValue = String.valueOf(field.get(car));

                        if (filterValue != null && !fieldValue.startsWith(filterValue.toString())) {
                            match = false;
                            break;
                        }
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }

            if (match) {
                data.add(car);
            }
        }
        return data;
    }

    private List<Car> paginate(int dataSize, int pageSize, List<Car> data, int first) {
        
        if (dataSize <= pageSize) {
            return data;
        }

        if (first + pageSize < data.size()) {
            return data.subList(first, first + pageSize);
        }
        
        return data.subList(first, first + (dataSize % pageSize));
    }
}
