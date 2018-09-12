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
package com.etlsolutions.examples.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 *
 * @author zc
 */
public class FxmlController implements Initializable {

    @FXML
    private TreeView<String> plantsTreeView;
    @FXML
    private TreeView<String> locationsTreeView;  
    @FXML
    private TreeView<String> logsTreeView;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTreeItems("initial 1", "initial 2", "initial 3");
    }

    // loads some strings into the tree in the application UI.
    public void loadTreeItems(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("All plants");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }

        plantsTreeView.setRoot(root);
    }
}
