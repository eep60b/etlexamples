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
import javax.swing.Action;
import org.openide.actions.CopyAction;
import org.openide.actions.CutAction;
import org.openide.actions.DeleteAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Zhipeng Chang
 */
public class CategoryNode extends AbstractNode {

    public CategoryNode(Category category) {
        super(Children.LEAF, Lookups.fixed( new Object[] {category} ));
        setDisplayName(category.getName());
    //    setIconBaseWithExtension("org/netbeans/myfirstexplorer/marilyn.gif");
    }

    @Override
    public boolean canCut() {
        return true;
    }

    @Override
    public boolean canDestroy() {
        return true;
    }

    @Override
    public Action[] getActions(boolean popup) {
        return new Action[]{SystemAction.get(CopyAction.class), SystemAction.get(CutAction.class), null, SystemAction.get(DeleteAction.class)};
    }
}
