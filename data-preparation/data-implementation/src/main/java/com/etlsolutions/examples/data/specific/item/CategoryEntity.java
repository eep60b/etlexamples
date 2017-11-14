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
package com.etlsolutions.examples.data.specific.item;

import com.etlsolutions.examples.data.general.wrapper.NameWrapper;
import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The CategoryEntity class represents a category table entity in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
@ImmutableClass
@DataClass
public final class CategoryEntity implements Category {

    private final String name;

    /**
     * Construct an object with the given category name.
     *
     * @param name - The given category name.
     */
    public CategoryEntity(String name) {

        this.name = name;
    }

    /**
     * Construct an object with the given category name.
     *
     * @param name - The NameWrapper object which wraps a category name.
     */
    public CategoryEntity(NameWrapper name) {

        this.name = name.getValue();
    }

    public CategoryEntity(Category category) {

        this(category.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
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

        final CategoryEntity other = (CategoryEntity) obj;

        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "CategoryEntity{category name=" + getName() + '}';
    }

    @Override
    public boolean hasSameConstraint(Category category) {

        if (this == category) {
            return true;
        }

        if (category == null) {
            return false;
        }

        return Objects.equals(getName(), category.getName());
    }

    @Override
    public boolean hasSameParameters(Category category) {

        return hasSameConstraint(category);
    }
}
