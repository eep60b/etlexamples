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
import com.etlsolutions.examples.data.xml.DoctypePublicId;
import com.etlsolutions.examples.data.xml.DoctypeQualifiedName;
import com.etlsolutions.examples.data.xml.DoctypeSystemId;
import com.etlsolutions.examples.data.xml.HrefWrapper;
import static com.etlsolutions.examples.servlet.jnlp.JnlpElementNames.*;
import java.io.IOException;
import java.io.StringWriter;
import org.apache.xml.serialize.OutputFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class JnlpDomProvider {

    public Document getDocument() throws ParserConfigurationException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        DoctypeDeclaration documentTypeDefinition = new DoctypeDeclaration(new DoctypeQualifiedName("jnlp"),
                new DoctypePublicId("-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"), new DoctypeSystemId("http://java.sun.com/dtd/web-app_2_3.dtd"));

        JnlpInformation information = new JnlpInformation(new JnlpInformationTitle("titleA"), new JnlpInformationVendor("oracle A"), new JnlpInformationHomepage(new JnlpInformationHomepageHref("afda..ada")));

        JnlpResourcesJava resourcesJava = new JnlpResourcesJava(new HrefWrapper("adfaa.ada.ada"), new JnlpResourcesJavaInitialHeap("32M"), new JnlpResourcesJavaMaxHeapSize("108M"), new JnlpResourcesJavaVersion("1.6+"));
        JnlpResourcesJar jar = new JnlpResourcesJar(JnlpResourcesJarDownload.EAGER, new HrefWrapper("dada..ada..da.d"), JnlpResourcesJarMain.TRUE);
        JnlpResources resources = new JnlpResources(resourcesJava, new HashSet<>(Arrays.asList(jar)), new Properties());

        JnlpTree tree = new JnlpTree(new JnlpCodebase("https://glas.etlsolutions.com/"), new HrefWrapper("https://glas.etlsolutions.com/JNLP_Generator/272044.php"),
                new JnlpSpec("1.0+"), new JnlpVersion("2.2.1"), information, JnlpSecurity.ALL_PERMISSIONS, resources, new JnlpApplicationDesc(new JnlpApplicationDescMainClass("abc.e")));

        JnlpContent content = new JnlpContent(new DocumentNamespaceUri("jnlp"), documentTypeDefinition, tree);

        Document document = documentBuilder.newDocument();
        DOMImplementation implementation = document.getImplementation();
        DocumentType documentType = implementation.createDocumentType(documentTypeDefinition.getQualifiedName(), documentTypeDefinition.getPublicId(), documentTypeDefinition.getSystemId());
    //    document.appendChild(documentType);

        Element jnlpElement = document.createElement(JNLP);

//        Attr jnlpCodebaseAttr = document.createAttribute(JNLP_CODEBASE);
//        jnlpCodebaseAttr.setValue(tree.getCodebase());
//        jnlpElement.appendChild(jnlpCodebaseAttr);
//
//        Attr jnlpHrefAttr = document.createAttribute(JNLP_HREF);
//        jnlpHrefAttr.setNodeValue(tree.getHref());
//        jnlpElement.appendChild(jnlpHrefAttr);
//
//        Attr jnlpSpecAttr = document.createAttribute(JNLP_SPEC);
//        jnlpSpecAttr.setValue(tree.getSpec());
//        jnlpElement.appendChild(jnlpSpecAttr);

        document.appendChild(jnlpElement);

        return document;
    }

    public String getDocumentContent() throws ParserConfigurationException, IOException {
        OutputFormat outputFormat = new OutputFormat("XML", "ISO-8859-1", true);
        outputFormat.setIndent(1);
        outputFormat.setIndenting(true);
        outputFormat.setDoctype("-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN", "http://java.sun.com/dtd/web-app_2_3.dtd");

        StringWriter outputWriter = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(outputWriter, outputFormat);
        serializer.asDOMSerializer();
        serializer.serialize(getDocument().getDocumentElement());
        return outputWriter.toString();
    }
}
