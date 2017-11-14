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
 * The ErrorType enum
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public enum ErrorType implements MessageType {

    /**
     * 
     */
    DUPLICATED_VALUE("There are duplicated values.\n"),    
    EMPTY_WORD_SET_AFTER_INIT("The word set is still empty after initialization.\n"),    
    FAILED_TO_CREATE_DIRECTORY("Failed to create the directory: "),
    NULL_PARAMETER("At least one null value has been found in the following parameters: "),
    PATH_HAS_BEEN_USED("The path has already been used by another file or directory: "),
    PRIVATE_CONSTRUCTOR("This private constructor should not be initialized.\n"),
    SESSION_FACTORY_CREATION_FAILURE("The initial SessionFactory creation has been failed.\n");

    
    private final String message;

    private ErrorType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
