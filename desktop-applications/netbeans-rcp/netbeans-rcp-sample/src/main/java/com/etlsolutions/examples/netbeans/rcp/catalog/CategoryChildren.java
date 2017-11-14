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
package com.etlsolutions.examples.netbeans.rcp.catalog;

import com.etlsolutions.examples.data.api.Category;
import com.etlsolutions.examples.ha.control.DatabaseManager;
import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.Index;
import org.openide.nodes.Node;

/**
 *
 * @author Zhipeng Chang
 */
public class CategoryChildren extends Index.ArrayChildren {

    private final List<Category> categories = DatabaseManager.getInstance().findAll(Category.class);

    public CategoryChildren() {
        
    }

    @Override
    protected List<Node> initCollection() {
        List<Node> childrenNodes = new ArrayList(categories.size());
        for (Category cateory : categories) {
            childrenNodes.add(new CategoryNode(cateory));
        }
        return childrenNodes;
    }
}
