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
package com.etlsolutions.examples.data.xml;

import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import java.util.Objects;

/**
 * The DoctypeDeclaration class represents the DOCTYPE declaration used by XML
 * parsers to identify the DTD and ensure that the document does conform to it.
 * A typical declaration for a document written to conform with version 1.0 of
 * the XHTML DTD looks like this:
 * <hr><blockquote><pre>
 *<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 * </pre></blockquote><hr>
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@ImmutableClass
@DataClass
public final class DoctypeDeclaration {

    private final String qualifiedName;
    private final String publicId;
    private final String systemId;

    /**
     *
     * @param qualifiedName
     * @param publicId
     * @param systemId
     *
     * @throws NullPointerException if any of the parameters is null.
     */
    public DoctypeDeclaration(DoctypeQualifiedName qualifiedName, DoctypePublicId publicId, DoctypeSystemId systemId) {
        this.qualifiedName = qualifiedName.getValue();
        this.publicId = publicId.getValue();
        this.systemId = systemId.getValue();
    }

    /**
     *
     * @return
     */
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     *
     * @return
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * Get the system ID which represents a local filename or a URL to find the
     * DTD.
     *
     * @return
     */
    public String getSystemId() {
        return systemId;
    }

    @Override
    public int hashCode() {

        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.qualifiedName);
        hash = 59 * hash + Objects.hashCode(this.publicId);
        hash = 59 * hash + Objects.hashCode(this.systemId);
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

        final DoctypeDeclaration other = (DoctypeDeclaration) obj;

        return Objects.equals(this.qualifiedName, other.qualifiedName) && Objects.equals(this.systemId, other.systemId) && Objects.equals(this.publicId, other.publicId);
    }

    @Override
    public String toString() {
        return "DocumentType{qualified name=" + qualifiedName + ", public ID=" + publicId + ", system ID=" + systemId + '}';
    }
}
