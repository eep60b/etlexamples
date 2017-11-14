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
package com.etlsolutions.examples.data.general;

import java.util.Collection;

/**
 * The TreeNode interfaces defines objects which can have children. Its children
 * can have any functionalities but they themselves must be TreeNode objects.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface TreeNode {

    /**
     * Check if this node can have children.
     *
     * @return true if it is a leaf node and CANNOT have children. Otherwise
     * return false.
     */
    boolean isLeaf();

    /**
     * Get the children nodes of this node.
     * @return a collection of the children nodes.
     */
    Collection<TreeNode> getChildren();
}
