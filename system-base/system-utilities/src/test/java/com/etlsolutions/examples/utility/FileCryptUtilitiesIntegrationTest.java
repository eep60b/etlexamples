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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * The integration tests of class FileCryptUtilities.
 *
 * To make this test work with Windows, 1) the JAVA_HOME should be the same used
 * by NetBeans, 2) The JCE Policy module should be downloaded
 * (http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html),
 * unzipped and two files (local_policy.jar and US_export_policy.jar) copied to
 * C:\Program Files\Java\jdk1.7.0_79\jre\lib\security to override the existing
 * jars.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class FileCryptUtilitiesIntegrationTest {

    /**
     * Test of the private constructor.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws Exception {
        Constructor[] constructors = FileCryptUtilities.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);

        Constructor constructor = constructors[0];
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    /**
     * Test of all methods of class FileCryptUtilities.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testEncrypt() throws Exception {
        int encryptionKeySize = 256;
        File inputFile = new File("src/test/resources/FileUtilities/plainText.txt");
        File encryptedFile = new File("target/test/resources/FileUtilities/encryptedText.txt");
        File encryptedKeyFile = new File("target/test/resources/FileUtilities/encryptedKey.txt");
        File publicKeyFile = new File("src/test/resources/FileUtilities/public.der");
        File privateKeyFile = new File("src/test/resources/FileUtilities/private.der");
        File decryptedFile = new File("target/test/resources/FileUtilities/decryptedEncrypRsaText.txt");

        byte[] initialKey = FileCryptUtilities.generateSymmetricKey(encryptionKeySize, AlgorithmType.AES);
        FileCryptUtilities.saveEncryptedKey(initialKey, encryptedKeyFile, publicKeyFile);
        FileCryptUtilities.encryptFile(initialKey, AlgorithmType.AES, inputFile, encryptedFile);

        // to decryptFile it again
        byte[] loadedKey = FileCryptUtilities.loadEncryptedKey(encryptionKeySize, encryptedKeyFile, privateKeyFile);
        FileCryptUtilities.decryptFile(loadedKey, AlgorithmType.AES, encryptedFile, decryptedFile);

        assertTrue(FileUtils.contentEquals(inputFile, decryptedFile));
    }

    @Test(expected = IOException.class)
    public void testSaveEncryptedKey_NoPublicKey() throws Exception {
        int encryptionKeySize = 256;
        File encryptedKeyFile = new File("target/test/resources/FileUtilities/encryptedKey.txt");
        File publicKeyFile = new File("src/test/resources/FileUtilities/public.derA");

        byte[] initialKey = FileCryptUtilities.generateSymmetricKey(encryptionKeySize, AlgorithmType.AES);
        FileCryptUtilities.saveEncryptedKey(initialKey, encryptedKeyFile, publicKeyFile);
    }
    

    @Test(expected = IOException.class)
    public void testSaveEncryptedKey_CannotWriteKey() throws Exception {
        int encryptionKeySize = 256;
        File encryptedKeyFile = new File("target/test/resources/FileUtilities/encryptedKey.txt");
        File publicKeyFile = new File("src/test/resources/FileUtilities/public.der");

        byte[] initialKey = FileCryptUtilities.generateSymmetricKey(encryptionKeySize, AlgorithmType.AES);
        FileCryptUtilities.saveEncryptedKey(initialKey, encryptedKeyFile, publicKeyFile);
        
        encryptedKeyFile.setReadOnly();
        FileCryptUtilities.saveEncryptedKey(initialKey, encryptedKeyFile, publicKeyFile);
    }    
}
