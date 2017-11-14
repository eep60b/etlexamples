/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except encryptedFile compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to encryptedFile writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class FileCryptUtilities.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FileCryptUtilities.class, KeyGenerator.class, KeyFactory.class, Cipher.class, IOUtils.class})
public final class FileCryptUtilitiesTest {

    private final byte[] keyBytes = {1, 22, 12};
    private final File publicKeyFile = Mockito.mock(File.class);
    private final File synmectricKeyFile = Mockito.mock(File.class);
    private final File synmectricKeyParentFile = Mockito.mock(File.class);
    private final FileInputStream publicKeyIputStream = Mockito.mock(FileInputStream.class);
    private final PublicKey pubicKey = Mockito.mock(PublicKey.class);
    private final PrivateKey privateKey = Mockito.mock(PrivateKey.class);
    private final Cipher rsaCipher = PowerMockito.mock(Cipher.class);
    private final CipherOutputStream symmetricKeyCipherOutputStream = Mockito.mock(CipherOutputStream.class);
    private final File encryptedFile = Mockito.mock(File.class);
    private final File decrypedFile = Mockito.mock(File.class);
    private final FileInputStream dataFileIputStream = Mockito.mock(FileInputStream.class);
    private final Cipher symmetricKeyCipher = PowerMockito.mock(Cipher.class);
    private final SecretKeySpec secretKeySpec = Mockito.mock(SecretKeySpec.class);
    private final FileOutputStream dataFileOutputStream = Mockito.mock(FileOutputStream.class);

    @Before
    public void setUp() throws Exception {
        Mockito.when(synmectricKeyFile.getParentFile()).thenReturn(synmectricKeyParentFile);

        Mockito.when(publicKeyFile.length()).thenReturn(1024L);

        X509EncodedKeySpec publicKeySpec = Mockito.mock(X509EncodedKeySpec.class);
        PowerMockito.whenNew(X509EncodedKeySpec.class).withAnyArguments().thenReturn(publicKeySpec);

        PKCS8EncodedKeySpec privateKeySpec = Mockito.mock(PKCS8EncodedKeySpec.class);
        PowerMockito.whenNew(PKCS8EncodedKeySpec.class).withAnyArguments().thenReturn(privateKeySpec);

        KeyFactory keyFactory = PowerMockito.mock(KeyFactory.class);
        PowerMockito.mockStatic(KeyFactory.class);
        Mockito.when(KeyFactory.getInstance("RSA")).thenReturn(keyFactory);

        Mockito.when(keyFactory.generatePublic(publicKeySpec)).thenReturn(pubicKey);
        Mockito.when(keyFactory.generatePrivate(privateKeySpec)).thenReturn(privateKey);

        PowerMockito.whenNew(FileInputStream.class).withArguments(publicKeyFile).thenReturn(publicKeyIputStream);        
        
        PowerMockito.mockStatic(Cipher.class);
        Mockito.when(Cipher.getInstance("RSA")).thenReturn(rsaCipher);
        
        FileOutputStream fos = Mockito.mock(FileOutputStream.class);
        PowerMockito.whenNew(FileOutputStream.class).withArguments(synmectricKeyFile).thenReturn(fos);

        PowerMockito.whenNew(CipherOutputStream.class).withArguments(fos, rsaCipher).thenReturn(symmetricKeyCipherOutputStream);

        PowerMockito.when(Cipher.getInstance("AES")).thenReturn(symmetricKeyCipher);
        PowerMockito.whenNew(SecretKeySpec.class).withArguments(keyBytes, "AES").thenReturn(secretKeySpec);

        PowerMockito.mockStatic(IOUtils.class);
    }

    /**
     * Test of generateKey method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testGenerateAesKey() throws Exception {

        KeyGenerator keyGenerator = PowerMockito.mock(KeyGenerator.class);
        PowerMockito.mockStatic(KeyGenerator.class);
        Mockito.when(KeyGenerator.getInstance("AES")).thenReturn(keyGenerator);

        SecretKey secretKey = Mockito.mock(SecretKey.class);
        Mockito.when(keyGenerator.generateKey()).thenReturn(secretKey);
        Mockito.when(secretKey.getEncoded()).thenReturn(keyBytes);

        assertArrayEquals(keyBytes, FileCryptUtilities.generateSymmetricKey(256, AlgorithmType.AES));

        Mockito.verify(keyGenerator).init(256);
    }

    /**
     * Test of saveEncryptedKey method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testSaveEncryptedKey() throws Exception {

        Mockito.when(synmectricKeyFile.isFile()).thenReturn(Boolean.TRUE);

        FileCryptUtilities.saveEncryptedKey(keyBytes, synmectricKeyFile, publicKeyFile);

        Mockito.verify(publicKeyIputStream).read(Mockito.any(byte[].class));
        Mockito.verify(publicKeyIputStream).close();
        Mockito.verify(rsaCipher).init(Cipher.ENCRYPT_MODE, pubicKey);
        Mockito.verify(symmetricKeyCipherOutputStream).write(keyBytes);
        Mockito.verify(symmetricKeyCipherOutputStream).close();
    }

    /**
     * Test of saveEncryptedKey method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testSaveEncryptedKey_NoFile() throws Exception {

        Mockito.when(synmectricKeyFile.isFile()).thenReturn(Boolean.FALSE);

        FileCryptUtilities.saveEncryptedKey(keyBytes, synmectricKeyFile, publicKeyFile);

        Mockito.verify(synmectricKeyParentFile).mkdirs();
        Mockito.verify(synmectricKeyFile).createNewFile();
        Mockito.verify(publicKeyIputStream).read(Mockito.any(byte[].class));
        Mockito.verify(publicKeyIputStream).close();
        Mockito.verify(rsaCipher).init(Cipher.ENCRYPT_MODE, pubicKey);
        Mockito.verify(symmetricKeyCipherOutputStream).write(keyBytes);
        Mockito.verify(symmetricKeyCipherOutputStream).close();
    }

    /**
     * Test of loadEncryptedKey method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadEncryptedKey() throws Exception {

        int keySize = 256;
        File privateKeyFile = Mockito.mock(File.class);
        Mockito.when(privateKeyFile.length()).thenReturn(1024L);
        FileInputStream privateKeyIputStream = Mockito.mock(FileInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withArguments(privateKeyFile).thenReturn(privateKeyIputStream);
        CipherInputStream is = Mockito.mock(CipherInputStream.class);
        FileInputStream keyFileInputStream = Mockito.mock(FileInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withArguments(synmectricKeyFile).thenReturn(keyFileInputStream);
        PowerMockito.whenNew(CipherInputStream.class).withArguments(keyFileInputStream, rsaCipher).thenReturn(is);

        assertEquals(32, FileCryptUtilities.loadEncryptedKey(keySize, synmectricKeyFile, privateKeyFile).length);

        Mockito.verify(privateKeyIputStream).read(Mockito.any(byte[].class));
        Mockito.verify(privateKeyIputStream).close();
        Mockito.verify(rsaCipher).init(Cipher.DECRYPT_MODE, privateKey);
        Mockito.verify(is).read(Mockito.any(byte[].class));
        Mockito.verify(is).close();
    }

    /**
     * Test of encryptFile method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testEncryptFile() throws Exception {

        PowerMockito.whenNew(FileInputStream.class).withArguments(decrypedFile).thenReturn(dataFileIputStream);
        PowerMockito.whenNew(FileOutputStream.class).withArguments(encryptedFile).thenReturn(dataFileOutputStream);
        CipherOutputStream cos = Mockito.mock(CipherOutputStream.class);
        PowerMockito.whenNew(CipherOutputStream.class).withArguments(dataFileOutputStream, symmetricKeyCipher).thenReturn(cos);

        FileCryptUtilities.encryptFile(keyBytes, AlgorithmType.AES, decrypedFile, encryptedFile);

        Mockito.verify(symmetricKeyCipher).init(Cipher.ENCRYPT_MODE, secretKeySpec);
        PowerMockito.verifyStatic();
        IOUtils.copy(dataFileIputStream, cos);
        Mockito.verify(cos).close();
        Mockito.verify(dataFileIputStream).close();
    }

    /**
     * Test of decryptFile method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testDecrypt() throws Exception {

        PowerMockito.whenNew(FileInputStream.class).withArguments(encryptedFile).thenReturn(dataFileIputStream);
        PowerMockito.whenNew(FileOutputStream.class).withArguments(decrypedFile).thenReturn(dataFileOutputStream);
        CipherInputStream cis = Mockito.mock(CipherInputStream.class);
        PowerMockito.whenNew(CipherInputStream.class).withArguments(dataFileIputStream, symmetricKeyCipher).thenReturn(cis);

        FileCryptUtilities.decryptFile(keyBytes, AlgorithmType.AES, encryptedFile, decrypedFile);

        Mockito.verify(symmetricKeyCipher).init(Cipher.DECRYPT_MODE, secretKeySpec);
        PowerMockito.verifyStatic();
        IOUtils.copy(cis, dataFileOutputStream);
        Mockito.verify(cis).close();
        Mockito.verify(dataFileOutputStream).close();
    }
}
