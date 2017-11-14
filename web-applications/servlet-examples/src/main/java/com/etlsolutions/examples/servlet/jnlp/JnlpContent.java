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
package com.etlsolutions.examples.servlet.jnlp;

import com.etlsolutions.examples.data.xml.DocumentNamespaceUri;
import com.etlsolutions.examples.data.xml.DoctypeDeclaration;

/**
 *
 * The JnlpContent class represents the tree structure of a JNLP file.
 *
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 * @see
 * http://docs.oracle.com/javase/7/docs/technotes/guides/javaws/developersguide/syntax.html
 *
 * @version 1.0.0
 */
public final class JnlpContent {

    private final String documentNamespaceUri;
    private final DoctypeDeclaration documentType;
    private final JnlpTree tree;

    public JnlpContent(DocumentNamespaceUri documentNamespaceUri, DoctypeDeclaration documentType, JnlpTree tree) {
        this.documentNamespaceUri = documentNamespaceUri.getValue();
        this.documentType = documentType;
        this.tree = tree;
    }

    public String getDocumentNamespaceUri() {
        return documentNamespaceUri;
    }

    public DoctypeDeclaration getDocumentType() {
        return documentType;
    }

    public JnlpTree getTree() {
        return tree;
    }
}
