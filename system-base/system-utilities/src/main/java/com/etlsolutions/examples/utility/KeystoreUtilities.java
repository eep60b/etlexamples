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
import static com.etlsolutions.examples.utility.AlgorithmType.RSA;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;

/**
 * 
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class KeystoreUtilities {

    /**
     *
     */
    public enum KeystoreType {

        JKS
    }

    /**
     * Private constructor should not be invoked.
     */
    private KeystoreUtilities() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     *
     * @param keystoreFile
     * @param keypass
     * @param keyFile
     * @param certFile
     * @param defaultalias
     * @throws KeyStoreException
     * @throws NoSuchProviderException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws InvalidKeySpecException
     */
    public static final void addKeyCertPairToKeystore(File keystoreFile, String keypass, File keyFile, File certFile, String defaultalias) throws KeyStoreException, NoSuchProviderException, IOException, NoSuchAlgorithmException, CertificateException, InvalidKeySpecException {
        addKeyCertPairToKeystore(KeystoreType.JKS, "SUN", keystoreFile, keypass, keyFile, certFile, defaultalias);
    }

    public static final void createKeyStoreFile(File file, String password) throws IOException, KeyStoreException, NoSuchProviderException, NoSuchAlgorithmException, CertificateException {

        createKeyStoreFile(KeystoreType.JKS, "SUN", file, password);
    }

    public static final void createKeyStoreFile(KeystoreType type, String providerName, File file, String password) throws IOException, KeyStoreException, NoSuchProviderException, NoSuchAlgorithmException, CertificateException {

        file.getParentFile().mkdirs();

        if (!file.createNewFile()) {
            throw new IOException(ErrorType.PATH_HAS_BEEN_USED.getMessage() + file.getAbsolutePath());
        }

        KeyStore keyStore = KeyStore.getInstance(type.name(), providerName);

        char[] pass = password.toCharArray();
        keyStore.load(null, pass);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            keyStore.store(fos, pass);
        }
    }

    /**
     *
     * @param type - The key store type.
     * @param providerName
     * @param keystoreFile
     * @param keypass
     * @param keyFile
     * @param certFile
     * @param defaultalias
     * @throws KeyStoreException
     * @throws NoSuchProviderException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws InvalidKeySpecException
     */
    public static final void addKeyCertPairToKeystore(KeystoreType type, String providerName, File keystoreFile, String keypass, File keyFile, File certFile, String defaultalias) throws KeyStoreException, NoSuchProviderException, IOException, NoSuchAlgorithmException, CertificateException, InvalidKeySpecException {

        KeyStore keyStore = KeyStore.getInstance(type.name(), providerName);

        char[] pass = keypass.toCharArray();

        if (!keystoreFile.exists()) {
            keystoreFile.getParentFile().mkdirs();
            keystoreFile.createNewFile();
            keyStore.load(null, pass);
            try (FileOutputStream fos = new FileOutputStream(keystoreFile)) {
                keyStore.store(fos, pass);
            }
        }

        try (FileInputStream fis = new FileInputStream(keystoreFile)) {

            //Use the keystoreFile
            keyStore.load(fis, pass);
        }

        try (InputStream keyInputStream = createStreamWithData(keyFile); InputStream certInputStream = createStreamWithData(certFile); FileOutputStream keyStoreOutputStream = new FileOutputStream(keystoreFile);) {

            // loading Key
            KeyFactory keyFactory = KeyFactory.getInstance(RSA.name());
            byte[] key = new byte[keyInputStream.available()];
            keyInputStream.read(key, 0, keyInputStream.available());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // loading CertificateChain 
            CertificateFactory cf = CertificateFactory.getInstance(KeyFormat.X509.getFormat());
            Collection c = cf.generateCertificates(certInputStream);
            Certificate[] certs = (Certificate[]) c.toArray(new Certificate[]{});

            // storing keystore
            keyStore.setKeyEntry(defaultalias, privateKey, pass, certs);            
            keyStore.store(keyStoreOutputStream, pass);
        }
    }

    /**
     * <p>
     * Creates an InputStream from a file, and fills it with the complete file.
     * Thus, available() on the returned InputStream will return the full number
     * of bytes the file contains</p>
     *
     * @param file The filename
     * @return The filled InputStream
     * @exception IOException, if the Streams couldn't be created.
     *
     */
    private static InputStream createStreamWithData(File file) throws IOException {
        byte[] bytes;
        try (FileInputStream fis = new FileInputStream(file); DataInputStream dis = new DataInputStream(fis)) {
            bytes = new byte[dis.available()];
            dis.readFully(bytes);
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return bais;
    }

    /**
     *
     * @param file
     * @param password
     * @return
     * @throws KeyStoreException
     * @throws NoSuchProviderException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     */
    public static KeyStore loadKeyStore(File file, String password) throws KeyStoreException, NoSuchProviderException, IOException, FileNotFoundException, NoSuchAlgorithmException, CertificateException {
        return loadKeyStore(KeystoreType.JKS, "SUN", file, password);
    }

    /**
     *
     * @param type
     * @param providerName
     * @param file
     * @param password
     * @return
     * @throws KeyStoreException
     * @throws NoSuchProviderException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     */
    public static KeyStore loadKeyStore(KeystoreType type, String providerName, File file, String password) throws KeyStoreException, NoSuchProviderException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException {

        KeyStore keyStore = KeyStore.getInstance(type.name(), providerName);
        try (FileInputStream fis = new FileInputStream(file)) {
            keyStore.load(fis, password.toCharArray());
        }
        return keyStore;
    }
}
