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
package com.etlsolutions.examples.base.configuration;

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The SystemConstants class contains the system constant used by the project.
 *
 * @author Zhipeng Chang
 * @since 1.0.0
 * 
 * @version 1.0.0
 * @version 1.1.0 - The digit set is added.
 * 
 */
public final class SystemConstants {

    private SystemConstants() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * The user home in this application.
     */
    public static final String USER_HOME = System.getProperty("user.home");

    /**
     * The name of ETL examples home which contains the configuration
     * information and locates the user home.
     */
    public static final String APPLICATION_HOME_NAME = ".etl-examples";

    /**
     * The file name of configuration for the ETL examples project.
     */
    static final String SYSTEM_CONFIG_FILE_NAME = "etl-examples.properties";

    /**
     * The default path for the file of configuration properties. The file will
     * be used if no configuration file can be found in the user home.
     */
    static final String SYSTEM_CONFIG_FILE_DEFAULT_PATH = "../../base/configuration/src/main/resources/scripts/prop" + File.separator + SYSTEM_CONFIG_FILE_NAME;

    /**
     * The property to locate the file set for the random word generation.
     */
    static final String RANDOM_WORD_GENERATION_FILESET_PATH_PROPERTY = "random.word.generation.fileset.path";

    /**
     * The default path for the file set to generation random word.
     */
    static final String RANDOM_WORD_GENERATION_FILESET_DEFAULT_PATH = "src/main/resources/text/all-english-words.txt";

    /**
     * The array of 26 basic English characters in lower case.
     */
    public static final Character[] BASIC_26_CHARACTER_ARRAY = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * The set of basic English characters in lower case.
     */
    public static final Set<Character> BASIC_26_CHARACTER_SET = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(BASIC_26_CHARACTER_ARRAY)));

    /**
     * The arrays of vowels in English.
     */
    public static final char[] ENGLISH_VOWELS = {'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'õ', 'ü', 'y'};

    /**
     * The arrays of consonants in English.
     */
    public static final char[] ENGLISH_CONSONANTS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    /**
     * The arrays of digits.
     */
    public static final Character[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * The set of basic English characters in lower case.
     */
    public static final Set<Character> DIGITS_SET = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(DIGITS)));
    
    /**
     * The scale used by BigDecimal objects for money.
     */
    public static final int DEFAULT_SCALE = 2;
    
    /**
     * The rounding strategy for money.
     */
    public static final int DEFAULT_ROUNDIND = BigDecimal.ROUND_HALF_UP;
}
