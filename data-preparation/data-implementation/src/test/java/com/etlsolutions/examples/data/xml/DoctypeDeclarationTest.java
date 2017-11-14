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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of getQualifiedName method, of class DoctypeDeclaration.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class DoctypeDeclarationTest {

    private final DoctypeQualifiedName qualifiedName = new DoctypeQualifiedName("jnlp");
    private final DoctypeQualifiedName qualifiedName1 = new DoctypeQualifiedName("html");
    private final DoctypePublicId publicId = new DoctypePublicId("-//W3C//DTD XHTML 1.0 Transitional//EN");
    private final DoctypePublicId publicId2 = new DoctypePublicId("NNN");
    private final DoctypeSystemId systemId = new DoctypeSystemId("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd");
    private final DoctypeSystemId systemId3 = new DoctypeSystemId("/home/ab/xhtml1-transitional.dtd");

    private final DoctypeDeclaration instance = new DoctypeDeclaration(qualifiedName, publicId, systemId);
    private final DoctypeDeclaration instance00 = new DoctypeDeclaration(qualifiedName, publicId, systemId);
    private final DoctypeDeclaration instance01 = new DoctypeDeclaration(qualifiedName1, publicId, systemId);
    private final DoctypeDeclaration instance02 = new DoctypeDeclaration(qualifiedName, publicId2, systemId);
    private final DoctypeDeclaration instance03 = new DoctypeDeclaration(qualifiedName, publicId, systemId3);

    /**
     * Test of getQualifiedName method.
     */
    @Test
    public void testGetQualifiedName() {

        assertEquals("jnlp", instance.getQualifiedName());
    }

    /**
     * Test of getPublicId method.
     */
    @Test
    public void testGetPublicId() {

        assertEquals("-//W3C//DTD XHTML 1.0 Transitional//EN", instance.getPublicId());
    }

    /**
     * Test of getSystemId method.
     */
    @Test
    public void testGetSystemId() {

        assertEquals("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd", instance.getSystemId());
    }

    /**
     * Test of hashCode method.
     */
    @Test
    public void testHashCode() {

        assertEquals(instance00.hashCode(), instance.hashCode());

        assertNotEquals(instance01.hashCode(), instance.hashCode());
        assertNotEquals(instance02.hashCode(), instance.hashCode());
        assertNotEquals(instance03.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method.
     */
    @Test
    public void testEquals() {

        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(instance00));

        assertFalse(instance.equals(instance01));
        assertFalse(instance.equals(instance02));
        assertFalse(instance.equals(instance03));
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {

        assertEquals("DocumentType{qualified name=jnlp, public ID=-//W3C//DTD XHTML 1.0 Transitional//EN, system ID=http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd}", instance.toString());
    }

}
