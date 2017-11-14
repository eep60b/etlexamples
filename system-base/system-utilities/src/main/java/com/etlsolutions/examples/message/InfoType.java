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

package com.etlsolutions.examples.message;

/**
 * The InfoType enum
 *
 * @author Zhipeng Chang
 */

//TODO: Add tests. Add Java docs. Add annotations.
public enum InfoType implements MessageType {

    NO_CONFIG_FILE("There is no configuration file in the user home."),
    COPY_DEFAULT_CONFIG_FILE("Copying the default clinet configuraion file etl-example.properties."),
    FILE_COPY_SUCCESS("The file has been copied sucessfully."),
    STORE_CONFIG_FILE("The ETL examples configure file."),
    STORE_CONFIG_FILE_SUCCESS("The ETL examples configure file has been successfully stored."),
    CONFIG_FILE_COMMENTS("The system configuration file for this application. If you want to change any property in this file, you need to restart the application. Otherwise it will not take effect.");

    private final String message;

    private InfoType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
