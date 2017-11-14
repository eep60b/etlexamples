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

import com.etlsolutions.examples.utility.annotation.ImmutableClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.io.IOException;
import java.util.Random;

/**
 * The RandomWordGroupGenerator class
 *
 * @author Zhipeng Chang
 */
//TODO: Implementation. Add tests. Add Java docs. Add annotations.
@ThreadSafe
@ImmutableClass
public final class RandomWordGroupGenerator {

    private final RandomWordGenerator randomWordGenerator = new RandomWordGenerator();

    public String getPhrase(int maxWordNumber, String separater) throws IOException {
        if (randomWordGenerator.isEmpty()) {
            randomWordGenerator.init();
        }

        StringBuilder builder = new StringBuilder();
        int wordNumber = new Random().nextInt(maxWordNumber) + 1;
        for (int i = 0; i < wordNumber; i++) {

            builder.append(randomWordGenerator.getWord());
            
            if (i < wordNumber - 1) {
                builder.append(separater);
            }
        }

        return new String(builder);
    }
    
    /**
     * 
     * @param maxWordNumber
     * @param separater
     * @param terminal
     * @return
     * @throws IOException 
     */
    public String getSentence(int maxWordNumber, String separater, String terminal) throws IOException {
        
        return getPhrase(maxWordNumber, separater) + terminal;        
    }
}
