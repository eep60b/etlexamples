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
public final class JnlpApplicationDesc {

    private final String mainClassValue;

    public JnlpApplicationDesc(JnlpApplicationDescMainClass mainClass) {
        this.mainClassValue = mainClass.getValue();
    }

    public String getMainClassValue() {
        return mainClassValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.mainClassValue);
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
        final JnlpApplicationDesc other = (JnlpApplicationDesc) obj;
        return Objects.equals(this.mainClassValue, other.mainClassValue);
    }

    @Override
    public String toString() {
        return "JnlpApplicationDesc{" + "mainClass=" + mainClassValue + '}';
    }
}
