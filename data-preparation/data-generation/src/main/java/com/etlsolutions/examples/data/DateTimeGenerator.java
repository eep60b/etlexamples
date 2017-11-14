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

import com.etlsolutions.examples.utility.annotation.OperationClass;
import com.etlsolutions.examples.utility.annotation.StatelessClass;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@StatelessClass
@OperationClass
public final class DateTimeGenerator {

    private final Random random = new Random();
    private final long timeBase = new Date().getTime();

    public long generateRandomMiliSecondLong(int maxSecond) {

        long second = (long) random.nextInt(maxSecond);
        return second * 1000L;
    }

    public Date generateRandomOldDate(long year) {

        int maxSeconds = 365 * 24 * 3600;
        long miliseconds = generateRandomMiliSecondLong(maxSeconds);

        return new Date(timeBase - year * miliseconds);
    }

    public Object generateRandomFutureDate(long year) {
        int maxSeconds = 365 * 24 * 3600;
        long miliseconds = generateRandomMiliSecondLong(maxSeconds);

        return new Date(timeBase + year * miliseconds);
    }

    @Override
    public int hashCode() {
        int hash = 390148;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DateTimeGenerator other = (DateTimeGenerator) obj;
        return true;
    }

    @Override
    public String toString() {
        return "DateTimeGenerator{" + '}';
    }    
}
