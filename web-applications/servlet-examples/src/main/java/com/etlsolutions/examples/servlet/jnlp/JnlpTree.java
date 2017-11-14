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
import java.util.Objects;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class JnlpTree {

    private final String codebase;
    private final String href;
    private final String spec;    
    private final String version;    
    private final JnlpInformation information;
    private final JnlpSecurity security;
    private final JnlpResources resources;
    private final JnlpApplicationDesc applicationDesc;

    public JnlpTree(JnlpCodebase codebase, HrefWrapper href, JnlpSpec spec, JnlpVersion version, JnlpInformation information, JnlpSecurity security, JnlpResources resources, JnlpApplicationDesc applicationDesc) {
        this.codebase = codebase.getValue();
        this.href = href.getValue();
        this.spec = spec.getValue();
        this.version = version.getValue();
        this.information = information;
        this.security = security;
        this.resources = resources;
        this.applicationDesc = applicationDesc;
    }

    public String getCodebase() {
        return codebase;
    }

    public String getHref() {
        return href;
    }

    public String getSpec() {
        return spec;
    }
    
    public String getVersion() {
        return version;
    }

    public JnlpInformation getInformation() {
        return information;
    }

    public JnlpSecurity getSecurity() {
        return security;
    }

    public JnlpResources getResources() {
        return resources;
    }

    public JnlpApplicationDesc getApplicationDesc() {
        return applicationDesc;
    }
}
