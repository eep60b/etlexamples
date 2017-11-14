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
package com.etlsolutions.examples.utility;

/**
 *
 * @author zc
 */
public final class StringUtilities {

    private StringUtilities() {
    }
        
    public static boolean getBooleanValue(String str) {

        if (str == null || str.trim().toUpperCase().equals("FALSE")) {
            return false;
        } else if (str.trim().toUpperCase().equals("TRUE")) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid value for the property.");
        }
    }    
}
