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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class ServerConfigLoader {

    private static final ServerConfigLoader INSTANCE = new ServerConfigLoader();

    private final File propertiesFile = new File(ConstantSettings.CONFIG_FILE_LOCATION);
    private final Properties properties = new Properties();
    
    private boolean initialized = false;

    public static ServerConfigLoader getInstance() {
        return INSTANCE;
    }

    private void init() throws IOException {
        
        if(initialized) {
            return;
        }
        
        try (FileInputStream inputStream = new FileInputStream(propertiesFile)) {
            properties.loadFromXML(inputStream);
            initialized = true;
        } catch (IOException ex) {
            throw ex;
        }
    }
    
    public synchronized ServerType getServerType() throws IOException {
        
        init();
        String typeString = properties.getProperty(ConstantSettings.SERVER_TYPE_KEY);
        
        if(typeString == null || typeString.trim().isEmpty()) {
            return ConstantSettings.DEFAULT_SERVER_TYPE;
        }
        
        for(ServerType type : ServerType.values()) {
            if(typeString.trim().equalsIgnoreCase(type.name())) {
                return type;
            }
        }
        
        throw new IllegalStateException("Invalid server type.");
    }
    
    public synchronized Properties getProperties () throws IOException {
        init();
        return new Properties(properties);
    }
}
