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

import com.etlsolutions.examples.data.xml.HrefWrapper;

/**
 * The JnlpResourcesJava class represents the java (or j2se) node in a JNLP
 * file. Since "java" and "j2se" are the same node, here is no class
 * corresponding to "j2se".
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class JnlpResourcesJava {

    private final String href;
    private final String initialHeap;
    private final String maxHeapSize;
    private final String version;

    public JnlpResourcesJava(HrefWrapper href, JnlpResourcesJavaInitialHeap initialHeap, JnlpResourcesJavaMaxHeapSize maxHeapSize, JnlpResourcesJavaVersion version) {

        this.href = href.getValue();
        this.initialHeap = initialHeap.getValue();
        this.maxHeapSize = maxHeapSize.getValue();
        this.version = version.getValue();
    }

    public String getHref() {
        return href;
    }

    public String getInitialHeap() {
        return initialHeap;
    }

    public String getMaxHeapSize() {
        return maxHeapSize;
    }

    public String getVersion() {
        return version;
    }
}
