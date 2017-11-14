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

import com.etlsolutions.examples.data.api.SimpleBook;
import com.etlsolutions.examples.data.factory.SimpleBookFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * The PublishedBookView class is a control bean for related JSF pages.
 * 
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@ManagedBean(name = "publishedBookView")
@ViewScoped
public class PublishedBookView implements Serializable {

    private static final long serialVersionUID = 774881571416622101L;
    
    private final List<SimpleBook> books = new ArrayList<>();
    
    private Date toDate = new Date();
    private Date fromDate = new Date(new Date().getTime() - 7*24*3600*1000);
    
    @PostConstruct
    public void init() {
        books.addAll(SimpleBookFactory.getGeneratedSimpleBookJavaBeanList(63));
    }
  
    public List<SimpleBook> getBooks() {
        return books;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
}
