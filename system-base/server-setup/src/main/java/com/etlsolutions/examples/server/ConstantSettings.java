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
package com.etlsolutions.examples.server;

import java.io.File;

/**
 *
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class ConstantSettings {
    
    private static final String CONFIG_FILE_NAME = "server-setup-config.xml";
    
    public static final String CONFIG_FILE_LOCATION = System.getProperty("user.home") + File.separator + "etlExamples" + File.separator + "serverSetup" + File.separator + CONFIG_FILE_NAME; 
     
    public static final ServerType DEFAULT_SERVER_TYPE = ServerType.GLASSFISH;
    
    public static final String GLASSFISH_APPLICATION_PATH = "/Programs/glassfish/glassfish4";
    
    public static final int GLASSFISH_DOMAIN_PORT_BASE = 9200;
   
        
    public static final int TOMCAT_HTTP_PORT = 9180;
    
    public static final int TOMCAT_STOP_PORT = 9105;
    
    public static final String SERVER_TYPE_KEY="server.type";
}
