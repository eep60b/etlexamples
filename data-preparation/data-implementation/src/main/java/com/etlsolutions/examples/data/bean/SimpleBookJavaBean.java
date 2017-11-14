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
package com.etlsolutions.examples.data.bean;

import com.etlsolutions.examples.data.spi.SimpleBookSpi;
import com.etlsolutions.examples.utility.annotation.ConventionalJavaBeanClass;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The SimpleBookJavaBean class is a standard Java bean class which represents
 * the minimum information of a book. It is only for the test purpose.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@ConventionalJavaBeanClass
@NotThreadSafe
public class SimpleBookJavaBean implements SimpleBookSpi, Serializable {

    private static final long serialVersionUID = 983632502575290218L;

    private int id;
    private String bookName;
    private Date publishedDate;

    /**
     * Construct an object with no parameters are initialised.
     */
    public SimpleBookJavaBean() {
    }

    /**
     * 
     * @param id
     * @param bookName
     * @param publishedDate 
     */
    public SimpleBookJavaBean(int id, String bookName, Date publishedDate) {
        this.id = id;
        this.bookName = bookName;
        this.publishedDate = publishedDate == null ? null : new Date(publishedDate.getTime());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getBookName() {
        return bookName;
    }

    @Override
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public Date getPublishedDate() {
        return publishedDate == null ? null : new Date(publishedDate.getTime());
    }

    @Override
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate == null ? null : new Date(publishedDate.getTime());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.bookName);
        hash = 37 * hash + Objects.hashCode(this.publishedDate);
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
        
        final SimpleBookJavaBean other = (SimpleBookJavaBean) obj;
        
        if (this.id != other.id) {
            return false;
        }
        
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        
        return Objects.equals(this.publishedDate, other.publishedDate);
    }

    @Override
    public String toString() {
        return "SimpleBookJavaBean{" + "id=" + id + ", bookName=" + bookName + ", publishedDate=" + publishedDate + '}';
    }
}
