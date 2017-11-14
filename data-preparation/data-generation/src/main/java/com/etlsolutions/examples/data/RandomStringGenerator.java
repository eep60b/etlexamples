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

import com.etlsolutions.examples.base.configuration.SystemConstants;
import com.etlsolutions.examples.utility.annotation.StatelessClass;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * The RandomStringGenerator class generate a string according to the character
 * set.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - have added the two methods which use default char sets.
 * @version 1.2.0 - have added the method generateFixedLengthString(int length),
 * generateStringFromList(List list) and generateStringFromArray(String[] list).
 * @version 1.3.0 - Add the generateUniqueObjectArray method.
 *
 */
@StatelessClass
@ThreadSafe
public final class RandomStringGenerator implements Generator {

    
    private final Random random = new Random();
    /**
     * Generate a string using the given character set. The maximum length of
     * the string is limited.
     *
     * @param minLength - The minimum length of generated string.
     * @param maxLength - The maximum length of generated string.
     * @param charSet - The character set used for generating the string.
     * @return the generated string.
     */
    public String generateString(int minLength, int maxLength, Set<Character> charSet) {

        int length = random.nextInt(maxLength);
        while (length < minLength) {
            length = random.nextInt(maxLength + 1);
        }

        return generateFixedLengthString(length, charSet);
    }

    /**
     * Generate a string using the given character set. The maximum length of
     * the string is limited.
     *
     * @param minLength - The minimum length of generated string.
     * @param maxLength - The maximum length of generated string.
     * @return the generated string.
     */
    public String generateString(int minLength, int maxLength) {

        return generateString(minLength, maxLength, SystemConstants.BASIC_26_CHARACTER_SET);
    }

    /**
     * Generate a string using the given character set. The maximum length of
     * the string is limited. The minimum length of generated string is 1.
     *
     * @param maxLength - The maximum length of the generated string.
     * @param charSet - The character set used for generating the string.
     * @return the generated string.
     */
    public String generateString(int maxLength, Set<Character> charSet) {
        return generateString(1, maxLength, charSet);
    }

    /**
     * Generate a string using the given character set. The maximum length of
     * the string is limited. The minimum length of generated string is 1.
     *
     * @param maxLength - The maximum length of the generated string.
     * @return the generated string.
     */
    public String generateString(int maxLength) {
        return generateString(maxLength, SystemConstants.BASIC_26_CHARACTER_SET);
    }

    public String generateUniqueString(Set<String> usedStrings, int maxLength) {
        String str;
        while (true) {
            str = generateString(maxLength, SystemConstants.BASIC_26_CHARACTER_SET);
            if (!usedStrings.contains(str)) {
                usedStrings.add(str);
                return str;
            }
        }
    }

    /**
     * 
     * @param maxLength
     * @param size
     * @return 
     */
    public Set<String> generateStringList(int maxLength, int size) {
        Set<String> strs = new HashSet<>();
        while (true) {
            strs.add(generateString(maxLength));
            if (strs.size() >= size) {
                return strs;
            }
        }
    }

    /**
     * Generate a fixed length string using the given character set.
     *
     * @param length - The length of the generated String. If the length is zero
     * or negative, an empty string will be generated.
     * @param charSet - The character set used for generating the string.
     * @return the generated string.
     * @throws NullPointerException if the charSet is null.
     */
    public String generateFixedLengthString(int length, Set<Character> charSet) {

        List<Character> charList = new ArrayList<>(charSet);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(charList.get(random.nextInt(charSet.size())));
        }

        return new String(builder);
    }

    /**
     * Generate a fixed length string using the default char set.
     *
     * @param length - The length of the generated String. If the length is zero
     * or negative, an empty string will be generated.
     * @return the generated string.
     */
    //TODO: add test.
    public String generateFixedLengthString(int length) {

        return generateFixedLengthString(length, SystemConstants.BASIC_26_CHARACTER_SET);
    }

    //TODO: add test.    
    public String generateStringFromList(List<String> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    //TODO: add test.    
    public String generateStringFromArray(String[] strings) {
        int index = random.nextInt(strings.length);
        return strings[index];
    }

    /**
     * 
     * @param length
     * @return 
     */
    public String generateFixedLengthDigitalString(int length) {
        return generateFixedLengthString(length, SystemConstants.DIGITS_SET);
    }

    /**
     * 
     * @param maxLength
     * @return 
     */
    public String generateVariableLengthDigitalString(int maxLength) {
        return generateString(maxLength, SystemConstants.DIGITS_SET);
    }
    
    /**
     * 
     * @param usedStrings
     * @param length
     * @return 
     */
    public String generateFixedLengthUniqueString(Set<String> usedStrings, int length) {
                
        while (true) {
            String string = generateFixedLengthString(length);

            if (!usedStrings.contains(string)) {
                usedStrings.add(string);
                return string;
            }
        }
    }
    
    /**
     * 
     * @param usedStrings
     * @param length
     * @return 
     */
    public String generateFixedLengthUniqueDigitalString(Set<String> usedStrings, int length) {
                
        while (true) {
            String string = generateFixedLengthDigitalString(length);

            if (!usedStrings.contains(string)) {
                usedStrings.add(string);
                return string;
            }
        }
    }    
}
