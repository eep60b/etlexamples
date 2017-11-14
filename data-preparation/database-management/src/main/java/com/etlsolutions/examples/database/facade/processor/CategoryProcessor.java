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

import com.etlsolutions.examples.data.constant.KeyNames;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.CategoryPojo;

/**
 * The CategoryProcessor class contains methods which process the operations
 * associated to the Category table in the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class CategoryProcessor extends AbstractIdentifiableEdentityProcessor<CategoryPojo, Category> {

    /**
     * Construct an object using the given BookshopFacade.
     * @param facade 
     */
    public CategoryProcessor(BookshopFacade facade) {
        super(facade);
    }

    @Override
    public CategoryPojo retrieve(Category category) {
        return findConstraintableWithSameParameters(QueryNames.FIND_CATEGORY_BY_UNIQUE_CONSTRAINT, category, new StringKeyValuePair(KeyNames.CATEGORY_NAME, category.getName()));
    }

    @Override
    protected CategoryPojo doSave(Category category) {
        
        CategoryPojo pojo = retrieve(category);       
        return pojo == null ? new CategoryPojo(category) : pojo;
    }
}
