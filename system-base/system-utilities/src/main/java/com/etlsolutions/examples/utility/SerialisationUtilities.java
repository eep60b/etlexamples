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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.commons.lang.SerializationUtils;

/**
 * The SerialisationUtilities class contains utility methods for serialisation.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SerialisationUtilities {

    private SerialisationUtilities() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * Check if the given object is serialisable. This method serialise the
     * given object then read it back to check if the copy is the same as the original.
     *
     * @param serializable - The given object.
     * @return true if the the object is serialisable. Otherwise return false.
     * @throws NullPointerException if the given object is null.
     */
    public static boolean isSerializable(Serializable serializable) {
        return serializable.equals(clone(serializable));
    }

    /**
     * <p>
     * Deep clone an <code>Object</code> using serialisation.</p>
     *
     * <p>
     * This is many times slower than writing clone methods by hand on all
     * objects in your object graph. However, for complex object graphs, or for
     * those that don't support deep cloning this can be a simple alternative
     * implementation. Of course all the objects must be
     * <code>Serializable</code>.</p>
     *
     * @param serializable the <code>Serializable</code> object to clone
     * @return the cloned object
     * @throws SerializationException (runtime) if the serialization fails.
     */
    public static Object clone(Serializable serializable) {
        return SerializationUtils.clone(serializable);
    }

    public static void serialize(Serializable serializable, String path) throws IOException {
        serialize(serializable, new File(path));
    }

    public static void serialize(Serializable serializable, File file) throws IOException {

        file.getParentFile().mkdirs();
        file.delete();
        file.createNewFile();
        serialize(serializable, new FileOutputStream(file));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        SerializationUtils.serialize(serializable, outputStream);
    }

    public byte[] serialize(Serializable serializable) {
        return SerializationUtils.serialize(serializable);
    }

    public static Object deserialize(String path) throws FileNotFoundException {
        return SerializationUtils.deserialize(new FileInputStream(path));
    }

    public static Object deserialize(File file) throws FileNotFoundException {
        return SerializationUtils.deserialize(new FileInputStream(file));
    }

    public static Object deserialize(InputStream inputStream) {
        return SerializationUtils.deserialize(inputStream);
    }

    public static Object deserialize(byte[] objectData) {
        return SerializationUtils.deserialize(objectData);
    }
}
