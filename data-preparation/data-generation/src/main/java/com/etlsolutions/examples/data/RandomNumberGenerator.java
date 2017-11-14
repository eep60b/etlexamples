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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * The RandomNumberGenerator class generate double numbers.
 *
 * @author Zhipeng Chang
 * @since 1.0.0
 *
 * @version 1.0.0 - One method generatePositiveNumber(double min, double max) is
 * created.
 * @version 1.1.0 - The method generteRandomBytes(int length) and
 * generatePositiveNumber(int max) are added.
 */
//TODO: Add tests.
public final class RandomNumberGenerator {

    private final Random random = new Random();
    
    //TODO: add scale.
    public BigDecimal generateNumber(double min, double max, int scale) {

        BigDecimal bigDecimal = new BigDecimal(Math.round((min + (max - min) * Math.random()) * 100.0) / 100.0);
        return bigDecimal.setScale(scale, RoundingMode.UP);
    }

    public byte[] generteRandomBytes(int length) {
        byte[] b = new byte[length];
        random.nextBytes(b);
        return b;
    }

    public int generatePositiveNumber(int max) {
        return random.nextInt(max) + 1;
    }
    
    public int generateRandomNumberFromList(List<Integer> list) {
        
        int index = random.nextInt(list.size());        
        return list.get(index);
    }
    
    public byte[] generateRandomUniqueBytes(Set<byte[]> usedBytes, int length) {
        
        while (true) {
            byte[] bytes = generteRandomBytes(length);
            if(!usedBytes.contains(bytes)) {
                usedBytes.add(bytes);
                return bytes;
            }
        }
    }
}
