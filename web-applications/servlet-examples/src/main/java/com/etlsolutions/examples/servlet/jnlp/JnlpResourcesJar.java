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
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class JnlpResourcesJar {

    private final JnlpResourcesJarDownload download;
    private final String href;
    private final JnlpResourcesJarMain main;

    public JnlpResourcesJar(JnlpResourcesJarDownload download, HrefWrapper href, JnlpResourcesJarMain main) {
        this.download = download;
        this.href = href.getValue();
        this.main = main;
    }

    public JnlpResourcesJarDownload getDownload() {
        return download;
    }

    public String getHref() {
        return href;
    }

    public JnlpResourcesJarMain getMain() {
        return main;
    }    
}
