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
 * The WarnType class
 *
 * @author Zhipeng Chang
 */

//TODO: Implementation. Add tests. Add Java docs. Add annotations.
public enum WarnType implements MessageType {

    CANNOT_READ_CONFIG_FILE("The configuration file cannot be read from: "),    
    CANNOT_STORE_CONFIG_FILE("The configuration file cannot be stored to the repository: "),
    ATTEMPT_WRITE_EMPTY_CONFIG_FILE("Attempt to write the empty configuation file to disk. No action is taken."), 
    CANNOT_CLOSE_CONFIG_FILE("The configuration file cannot be closed properly.");
    
    private final String message;

    private WarnType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
