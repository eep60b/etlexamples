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

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class JnlpElementNames {

    private JnlpElementNames() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    public static final String JNLP = "jnlp";
    public static final String JNLP_CODEBASE = "codebase";
    public static final String JNLP_HREF = "href";
    public static final String JNLP_SPEC = "spec";
    public static final String JNLP_VERSION = "version";
    public static final String JNLP_INFORMATION = "information";
    public static final String JNLP_INFORMATION_OS = "os";
    public static final String JNLP_INFORMATION_ARCH = "arch";
    public static final String JNLP_INFORMATION_PLATFORM = "platform";
    public static final String JNLP_INFORMATION_LOCALE = "locale";
    public static final String JNLP_INFORMATION_TITLE = "title";
    public static final String JNLP_INFORMATION_VENDOR = "vendor";
    public static final String JNLP_INFORMATION_HOMEPAGE = "homepage";
    public static final String JNLP_INFORMATION_HOMEPAGE_HREF = "href";
    public static final String JNLP_INFORMATION_DESCRIPTION = "description";
    public static final String JNLP_SECURITY = "security";
    public static final String JNLP_UPDATE = "update";
    public static final String JNLP_UPDATE_CHECK = "check";
    public static final String JNLP_UPDATE_POLICY = "policy";
    public static final String JNLP_RESOURCES = "resources";
    public static final String JNLP_RESOURCES_JAVA = "java";
    public static final String JNLP_RESOURCES_JAVA_HREF = "href";
    public static final String JNLP_RESOURCES_JAVA_INITIAL_HEAP_SIZE = "initial-heap-size";
    public static final String JNLP_RESOURCES_JAVA_MAX_HEAP_SIZE = "max-heap-size";
    public static final String JNLP_RESOURCES_JAVA_VERSION = "1.5+";
    public static final String JNLP_RESOURCES_JAR = "jar";
    public static final String JNLP_RESOURCES_JAR_DOWNLOAD = "download";
    public static final String JNLP_RESOURCES_JAR_HREF = "href";
    public static final String JNLP_RESOURCES_JAR_MAIN = "main";
    public static final String JNLP_RESOURCES_PROPERTY = "property";
    public static final String JNLP_RESOURCES_PROPERTY_NAME = "name";
    public static final String JNLP_RESOURCES_PROPERTY_VALUE = "value";
    public static final String JNLP_APPLICATION_DESC = "application-desc";
    public static final String JNLP_APPLICATION_DESC_MAIN_CLASS = "main-class";
}
