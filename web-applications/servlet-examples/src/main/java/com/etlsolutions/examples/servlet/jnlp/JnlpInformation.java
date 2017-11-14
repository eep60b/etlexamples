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

import java.util.Objects;

/**
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class JnlpInformation {
    private final String title;
    private final String vendor;
    private final JnlpInformationHomepage homepage;

    public JnlpInformation(JnlpInformationTitle title, JnlpInformationVendor vendor, JnlpInformationHomepage homepage) {
        this.title = title.getValue();
        this.vendor = vendor.getValue();
        this.homepage = homepage;
    }

    public String getTitle() {
        return title;
    }

    public String getVendor() {
        return vendor;
    }

    public JnlpInformationHomepage getHomepage() {
        return homepage;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.vendor);
        hash = 97 * hash + Objects.hashCode(this.homepage);
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
        final JnlpInformation other = (JnlpInformation) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.vendor, other.vendor)) {
            return false;
        }
        return Objects.equals(this.homepage, other.homepage);
    }

    @Override
    public String toString() {
        return "JnlpInformation{" + "title=" + title + ", vendor=" + vendor + ", homepage=" + homepage + '}';
    }
    
}
