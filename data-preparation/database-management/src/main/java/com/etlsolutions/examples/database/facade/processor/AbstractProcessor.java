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
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.database.facade.BookshopFacade;
import java.util.Objects;

/**
 * The AbstractProcessor class process database-related operations such as save, retrieve etc.
 * 
 * @author Zhipeng Chang
 *
 * @param <T> - The type of object to be processed.
 * 
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public abstract class AbstractProcessor<T> {

    protected final BookshopFacade facade;

    public AbstractProcessor(BookshopFacade facade) {
        this.facade = facade;
    }

    /**
     * Retrieve the entry which represents the parameter contained by this
     * processor from the database and convert it to the given identifiable object.
     *
     * @param object - The given identifiable object.
     * @return the identifiable object or null if there is not such an entry.
     */
    public abstract Object retrieve(T object);    
    
    
    /**
     * Save the parameters obtained by this processor to an entry in the
     * database if there is no identical entry in the database. If there is an
     * identical entry already in the database, no action will taken on the
     * database.
     *
     * @param object - The given object whose information will be saved into the
     * database.
     *
     * @return an object which represents the saved entry. This method will NOT
     * return null. If the parameters cannot be saved correctly, an exception
     * will be thrown. If the entry is already in the database, an object which
     * represents the saved entry will be still returned.
     */
    public abstract Object save(T object);
    
    

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.facade);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        
        if(this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final AbstractProcessor<?> other = (AbstractProcessor<?>) obj;
        return Objects.equals(this.facade, other.facade);
    }

    @Override
    public final String toString() {
        return getClass().getSimpleName() + "{facade=" + facade + '}';
    }    
}
