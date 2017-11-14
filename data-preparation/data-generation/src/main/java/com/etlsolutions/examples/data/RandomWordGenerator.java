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

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.utility.annotation.OperationClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * The RandomWordGenerator class
 *
 * @author Zhipeng Chang
 * @version 1.0.0
 */
//TODO: Add tests. Add Java docs. Add annotations.
@ThreadSafe
@OperationClass
public final class RandomWordGenerator {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private List<String> wordList = WordSetReader.getWordList();
    private Random random = new Random();
    private boolean isEmpty = wordList.isEmpty();

    public void init() throws IOException {
        writeLock.lock();
        try {
            WordSetReader.init();
            wordList = WordSetReader.getWordList();
            random = new Random();
            isEmpty = wordList.isEmpty();
            if(isEmpty) {
                throw new IOException(MessageFactory.getMessage(ErrorType.EMPTY_WORD_SET_AFTER_INIT));
            }
            
        } finally {
            writeLock.unlock();
        }
    }

    public String getWord() {
        readLock.lock();
        try {
            if (wordList.isEmpty()) {
                return "";
            }
            return wordList.get(random.nextInt(wordList.size()));
        } finally {
            readLock.unlock();
        }
    }

    public boolean isEmpty() {
        readLock.lock();
        try {
            return wordList.isEmpty();
        } finally {
            readLock.unlock();
        }
    }
}
