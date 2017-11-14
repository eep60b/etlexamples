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
package com.etlsolutions.examples.primefaces.datatable.filter.calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Zhipeng Chang
 */
@ManagedBean(name = "datedCarRangedFilterView")
@ViewScoped
public class DatedCarRangedFilterView  implements Serializable {

    private static final long serialVersionUID = 978770613134439198L;
    
    private Date fromDate = new Date(new Date().getTime() - 1000 * 3600 * 24 * 3);
    private Date toDate = new Date();
    private List<DatedCar> cars;

    @ManagedProperty("#{datedCarService}")
    private DatedCarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars(100);
    }

    public void setService(DatedCarService service) {
        this.service = service;
    }
    
    
    public List<DatedCar> getCars() {
        return cars;
    }


    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    
    public Date getCurrentDate() {
        return new Date();
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
 
}
