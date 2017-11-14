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

import com.etlsolutions.examples.message.ErrorType;
import static com.etlsolutions.examples.message.MessageFactory.getMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.FileUtils;

/**
 * The FileUtilities class is a collection of utility methods which operates on
 * files.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class FileUtilities {

    private FileUtilities() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    //TODO: test
    public static Set<Character> readCharSet(File file) throws IOException {

        Set<Character> set = new HashSet<>();

        String text = readFileToString(file);

        for (int i = 0; i < text.length(); i++) {
            set.add(text.charAt(i));
        }

        return set;
    }

    //TODO: test
    public static String readFileToString(File file) throws IOException {
        return FileUtils.readFileToString(file);
    }

    public static void copyFile(File defaultConfigFile, File configFile) throws IOException {
        FileUtils.copyFile(defaultConfigFile, configFile);
    }
    
    public static void write(Object object, String path) throws IOException {
        write(object, new File(path));
    }

    public static void write(Object object, File file) throws IOException {

        file.getParentFile().mkdirs();
        file.delete();
        file.createNewFile();
        write(object, new FileOutputStream(file));
    }

    public static void write(Object object, FileOutputStream fileOutputStream) throws IOException {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        }
    }

    public static <T> T read(String path) throws IOException, ClassNotFoundException {
        return read(new FileInputStream(path));
    }

    public static <T> T read(File file) throws IOException, ClassNotFoundException {
        return read(new FileInputStream(file));
    }

    public static <T> T read(FileInputStream fileInputStream) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (T) objectInputStream.readObject();
        }
    }    
}
