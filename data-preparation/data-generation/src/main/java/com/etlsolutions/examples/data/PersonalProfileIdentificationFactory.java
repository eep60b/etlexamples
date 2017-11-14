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
package com.etlsolutions.examples.data;

/**
 *
 * @author Zhipeng Chang
 * 
 * @version 1.0.0
 */
public final class PersonalProfileIdentificationFactory {
    
    private static final int SIZE = 900;
    private static final int BASE = 128;  
    
    public String createIdentification(byte[] bytes) {
        int[] ints = new int[SIZE];
        
        for(int i = 0; i < bytes.length; i++) {
            
            ints[i%SIZE] += (int)bytes[i];
        }
        
        char[] chars = new char[SIZE];
        
        for(int i = 0; i < SIZE; i ++) {
            chars[i] = (char) (ints[i] % BASE);
        }
        
        String str = new String(chars);
        
        return str.length() <= SIZE ? str: str.substring(0, SIZE);
    }
    
}
