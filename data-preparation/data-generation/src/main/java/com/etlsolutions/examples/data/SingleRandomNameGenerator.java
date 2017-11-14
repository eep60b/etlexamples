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

import static com.etlsolutions.examples.base.configuration.SystemConstants.ENGLISH_CONSONANTS;
import static com.etlsolutions.examples.base.configuration.SystemConstants.ENGLISH_VOWELS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The SingleRandomNameGenerator class generate a random name based on a
 *
 * @author Zhipeng Chang
 */
public final class SingleRandomNameGenerator {

    ArrayList<String> pre = new ArrayList<>();
    ArrayList<String> mid = new ArrayList<>();
    ArrayList<String> sur = new ArrayList<>();

    private final String fileName;

    /**
     * Create new random name generator object. refresh() is automatically
     * called.
     *
     * @param fileName insert file name, where syllables are located
     * @throws IOException
     */
    public SingleRandomNameGenerator(String fileName) throws IOException {
        this.fileName = fileName;
        refresh();
    }

    /**
     * Refresh names from file. No need to call that method, if you are not
     * changing the file during the operation of program, as this method is
     * called every time file name is changed or new SingleRandomNameGenerator
     * object created.
     *
     * @throws IOException
     */
    public void refresh() throws IOException {

        FileReader input = null;
        BufferedReader bufRead = null;
        try {

            input = new FileReader(fileName);

            bufRead = new BufferedReader(input);
            String line = "";

            while (line != null) {
                line = bufRead.readLine();
                if (line != null && !line.equals("")) {
                    if (line.charAt(0) == '-') {
                        pre.add(line.substring(1).toLowerCase());
                    } else if (line.charAt(0) == '+') {
                        sur.add(line.substring(1).toLowerCase());
                    } else {
                        mid.add(line.toLowerCase());
                    }
                }
            }
        } finally {

            if (input != null) {
                input.close();
            }
            if (bufRead != null) {
                bufRead.close();
            }
        }
    }

    private String upper(String s) {
        return s.substring(0, 1).toUpperCase().concat(s.substring(1));
    }

    private boolean containsConsFirst(ArrayList<String> array) {

        if (array.stream().anyMatch((s) -> (consonantFirst(s)))) {
            return true;
        }
        return false;
    }

    private boolean containsVocFirst(ArrayList<String> array) {
        
        if (array.stream().anyMatch((s) -> (VowelFirst(s)))) {
            return true;
        }
        return false;
    }

    private boolean allowCons(ArrayList<String> array) {
        for (String s : array) {
            if (hatesPreviousVowels(s) || hatesPreviousConsonants(s) == false) {
                return true;
            }
        }
        return false;
    }

    private boolean allowVocs(ArrayList<String> array) {
        for (String s : array) {
            if (hatesPreviousConsonants(s) || hatesPreviousVowels(s) == false) {
                return true;
            }
        }
        return false;
    }

    private boolean expectsVowel(String s) {
        if (s.substring(1).contains("+v")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean expectsConsonant(String s) {
        if (s.substring(1).contains("+c")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hatesPreviousVowels(String s) {
        if (s.substring(1).contains("-c")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hatesPreviousConsonants(String s) {
        if (s.substring(1).contains("-v")) {
            return true;
        } else {
            return false;
        }
    }

    private String pureSyl(String s) {
        s = s.trim();
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        return s.split(" ")[0];
    }

    private boolean VowelFirst(String s) {
        return (String.copyValueOf(ENGLISH_VOWELS).contains(String.valueOf(s.charAt(0)).toLowerCase()));
    }

    private boolean consonantFirst(String s) {
        return (String.copyValueOf(ENGLISH_CONSONANTS).contains(String.valueOf(s.charAt(0)).toLowerCase()));
    }

    private boolean VowelLast(String s) {
        return (String.copyValueOf(ENGLISH_VOWELS).contains(String.valueOf(s.charAt(s.length() - 1)).toLowerCase()));
    }

    private boolean consonantLast(String s) {
        return (String.copyValueOf(ENGLISH_CONSONANTS).contains(String.valueOf(s.charAt(s.length() - 1)).toLowerCase()));
    }

    /**
     * Compose a new name.
     *
     * @param syls The number of syllables used in name.
     * @return Returns composed name as a String
     * @throws RuntimeException when logical mistakes are detected inside chosen
     * file, and program is unable to complete the name.
     */
    public String compose(int syls) {
        if (syls > 2 && mid.size() == 0) {
            throw new RuntimeException("You are trying to create a name with more than 3 parts, which requires middle parts, "
                    + "which you have none in the file " + fileName + ". You should add some. Every word, which doesn't have + or - for a prefix is counted as a middle part.");
        }
        if (pre.size() == 0) {
            throw new RuntimeException("You have no prefixes to start creating a name. add some and use \"-\" prefix, to identify it as a prefix for a name. (example: -asd)");
        }
        if (sur.size() == 0) {
            throw new RuntimeException("You have no suffixes to end a name. add some and use \"+\" prefix, to identify it as a suffix for a name. (example: +asd)");
        }
        if (syls < 1) {
            throw new RuntimeException("compose(int syls) can't have less than 1 syllable");
        }
        int expecting = 0; // 1 for Vowel, 2 for consonant
        int last = 0; // 1 for Vowel, 2 for consonant
        String name;
        int a = (int) (Math.random() * pre.size());

        if (VowelLast(pureSyl(pre.get(a)))) {
            last = 1;
        } else {
            last = 2;
        }

        if (syls > 2) {
            if (expectsVowel(pre.get(a))) {
                expecting = 1;
                if (containsVocFirst(mid) == false) {
                    throw new RuntimeException("Expecting \"middle\" part starting with Vowel, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
            }
            if (expectsConsonant(pre.get(a))) {
                expecting = 2;
                if (containsConsFirst(mid) == false) {
                    throw new RuntimeException("Expecting \"middle\" part starting with consonant, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
            }
        } else {
            if (expectsVowel(pre.get(a))) {
                expecting = 1;
                if (containsVocFirst(sur) == false) {
                    throw new RuntimeException("Expecting \"suffix\" part starting with Vowel, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
            }
            if (expectsConsonant(pre.get(a))) {
                expecting = 2;
                if (containsConsFirst(sur) == false) {
                    throw new RuntimeException("Expecting \"suffix\" part starting with consonant, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
            }
        }
        if (VowelLast(pureSyl(pre.get(a))) && allowVocs(mid) == false) {
            throw new RuntimeException("Expecting \"middle\" part that allows last character of prefix to be a Vowel, "
                    + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the prefix used, was : \"" + pre.get(a) + "\", which"
                    + "means there should be a part available, that has \"-v\" requirement or no requirements for previous syllables at all.");
        }

        if (consonantLast(pureSyl(pre.get(a))) && allowCons(mid) == false) {
            throw new RuntimeException("Expecting \"middle\" part that allows last character of prefix to be a consonant, "
                    + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the prefix used, was : \"" + pre.get(a) + "\", which"
                    + "means there should be a part available, that has \"-c\" requirement or no requirements for previous syllables at all.");
        }

        int b[] = new int[syls];
        for (int i = 0; i < b.length - 2; i++) {

            do {
                b[i] = (int) (Math.random() * mid.size());
                //System.out.println("exp " +expecting+" VowelF:"+VowelFirst(mid.get(b[i]))+" syl: "+mid.get(b[i]));
            } while (expecting == 1 && VowelFirst(pureSyl(mid.get(b[i]))) == false || expecting == 2 && consonantFirst(pureSyl(mid.get(b[i]))) == false
                    || last == 1 && hatesPreviousVowels(mid.get(b[i])) || last == 2 && hatesPreviousConsonants(mid.get(b[i])));

            expecting = 0;
            if (expectsVowel(mid.get(b[i]))) {
                expecting = 1;
                if (i < b.length - 3 && containsVocFirst(mid) == false) {
                    throw new RuntimeException("Expecting \"middle\" part starting with Vowel, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
                if (i == b.length - 3 && containsVocFirst(sur) == false) {
                    throw new RuntimeException("Expecting \"suffix\" part starting with Vowel, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
            }
            if (expectsConsonant(mid.get(b[i]))) {
                expecting = 2;
                if (i < b.length - 3 && containsConsFirst(mid) == false) {
                    throw new RuntimeException("Expecting \"middle\" part starting with consonant, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
                if (i == b.length - 3 && containsConsFirst(sur) == false) {
                    throw new RuntimeException("Expecting \"suffix\" part starting with consonant, "
                            + "but there is none. You should add one, or remove requirement for one.. ");
                }
            }
            if (VowelLast(pureSyl(mid.get(b[i]))) && allowVocs(mid) == false && syls > 3) {
                throw new RuntimeException("Expecting \"middle\" part that allows last character of last syllable to be a Vowel, "
                        + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which "
                        + "means there should be a part available, that has \"-v\" requirement or no requirements for previous syllables at all.");
            }

            if (consonantLast(pureSyl(mid.get(b[i]))) && allowCons(mid) == false && syls > 3) {
                throw new RuntimeException("Expecting \"middle\" part that allows last character of last syllable to be a consonant, "
                        + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which "
                        + "means there should be a part available, that has \"-c\" requirement or no requirements for previous syllables at all.");
            }
            if (i == b.length - 3) {
                if (VowelLast(pureSyl(mid.get(b[i]))) && allowVocs(sur) == false) {
                    throw new RuntimeException("Expecting \"suffix\" part that allows last character of last syllable to be a Vowel, "
                            + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which "
                            + "means there should be a suffix available, that has \"-v\" requirement or no requirements for previous syllables at all.");
                }

                if (consonantLast(pureSyl(mid.get(b[i]))) && allowCons(sur) == false) {
                    throw new RuntimeException("Expecting \"suffix\" part that allows last character of last syllable to be a consonant, "
                            + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which "
                            + "means there should be a suffix available, that has \"-c\" requirement or no requirements for previous syllables at all.");
                }
            }
            if (VowelLast(pureSyl(mid.get(b[i])))) {
                last = 1;
            } else {
                last = 2;
            }
        }

        int c;
        do {
            c = (int) (Math.random() * sur.size());
        } while (expecting == 1 && VowelFirst(pureSyl(sur.get(c))) == false || expecting == 2 && consonantFirst(pureSyl(sur.get(c))) == false
                || last == 1 && hatesPreviousVowels(sur.get(c)) || last == 2 && hatesPreviousConsonants(sur.get(c)));

        name = upper(pureSyl(pre.get(a).toLowerCase()));
        for (int i = 0; i < b.length - 2; i++) {
            name = name.concat(pureSyl(mid.get(b[i]).toLowerCase()));
        }
        if (syls > 1) {
            name = name.concat(pureSyl(sur.get(c).toLowerCase()));
        }
        return name;
    }
}
