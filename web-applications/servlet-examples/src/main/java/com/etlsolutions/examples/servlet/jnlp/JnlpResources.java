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

import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Collections;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@ImmutableClass
public final class JnlpResources {

    private final JnlpResourcesJava resourcesJava;
    private final Set<JnlpResourcesJar> jars;
    private final Properties properties;

    public JnlpResources(JnlpResourcesJava resourcesJava, Set<JnlpResourcesJar> jars, Properties properties) {

        if(jars == null || jars.isEmpty()) {
            throw new IllegalArgumentException("There is no jars in this JNLP file.");
        }
        
        this.resourcesJava = resourcesJava;
        this.jars = Collections.unmodifiableSet(jars);
        this.properties = new Properties();
        for (String key : properties.stringPropertyNames()) {
            this.properties.setProperty(key, properties.getProperty(key));
        }
    }

    public JnlpResourcesJava getResourcesJava() {
        return resourcesJava;
    }
    
    public Set<JnlpResourcesJar> getJars() {
        return jars;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.resourcesJava);        
        hash = 13 * hash + Objects.hashCode(this.jars);
        hash = 13 * hash + Objects.hashCode(this.properties);
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
        
        final JnlpResources other = (JnlpResources) obj;
 
        if (!Objects.equals(this.resourcesJava, other.resourcesJava)) {
            return false;
        }        
        
        if (!Objects.equals(this.jars, other.jars)) {
            return false;
        }
        
        return Objects.equals(this.properties, other.properties);
    }

    @Override
    public String toString() {
        return "JnlpResources{" + "resourcesJava=" + resourcesJava + ", jars=" + jars + ", properties=" + properties + '}';
    }
}
