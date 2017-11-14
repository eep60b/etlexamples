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
import static com.etlsolutions.examples.utility.AlgorithmType.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.IOUtils;

/**
 * The FileCryptUtilities class is a utility class which encrypts and decrypts
 * files.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class FileCryptUtilities {

    private FileCryptUtilities() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * Generate a symmetric key according to the key size and algorithm.
     *
     * @param keySize - the key size.
     * @param type - the algorithm type.
     * @return the key in a byte array.
     * @throws NoSuchAlgorithmException if the algorithm type is not supported.
     */
    public static byte[] generateSymmetricKey(int keySize, AlgorithmType type) throws NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance(type.name());
        kgen.init(keySize);
        SecretKey key = kgen.generateKey();
        return key.getEncoded();
    }

    /**
     * Encrypt and save the given key in a byte array via RSA algorithm.
     *
     * @param key - The key in a byte array.
     * @param keyFile - The file where the key should be saved.
     * @param publicKeyFile - The file where the public key is loaded. The
     * public key/private key pair can be generated via the following steps:
     *
     * 1. To generate a private key of length 2048 bits:
     *
     * <code>openssl genrsa -out private.pem 2048</code>
     *
     * 2. To get it into the required (PKCS#8, DER) format:
     *
     * <code>openssl pkcs8 -topk8 -in private.pem -outform DER -out private.der -nocrypt
     * </code>
     *
     * 3. To generate a public key from the private key:
     *
     * <code>openssl rsa -in private.pem -pubout -outform DER -out public.der</code>
     *
     *
     * @throws IOException if an IO error occurs.
     * @throws GeneralSecurityException if the public key cannot be created.
     */
    public static void saveEncryptedKey(byte[] key, File keyFile, File publicKeyFile) throws IOException, GeneralSecurityException {

        if (!keyFile.isFile()) {
            keyFile.getParentFile().mkdirs();
            keyFile.createNewFile();
        }

        // read public key to be used to encrypt the AES key
        byte[] encodedKey = new byte[(int) publicKeyFile.length()];

        try (InputStream in = new FileInputStream(publicKeyFile)) {
            in.read(encodedKey);
        }

        // create public key
        String algorithmName = RSA.name();
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedKey);
        KeyFactory kf = KeyFactory.getInstance(algorithmName);
        PublicKey pk = kf.generatePublic(publicKeySpec);

        // write AES key
        Cipher cipher = Cipher.getInstance(algorithmName);
        cipher.init(Cipher.ENCRYPT_MODE, pk);
        try (CipherOutputStream os = new CipherOutputStream(new FileOutputStream(keyFile), cipher)) {
            os.write(key);
        }
    }

    /**
     * Load an encrypted key from the given file.
     *
     * @param keySize
     * @param keyFile
     * @param privateKeyFile
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static byte[] loadEncryptedKey(int keySize, File keyFile, File privateKeyFile) throws GeneralSecurityException, IOException {
        // read private key to be used to decryptFile the AES key
        byte[] encodedKey = new byte[(int) privateKeyFile.length()];
        try (InputStream in = new FileInputStream(privateKeyFile)) {
            in.read(encodedKey);
        }

        // create private key
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedKey);
        KeyFactory kf = KeyFactory.getInstance(RSA.name());
        PrivateKey pk = kf.generatePrivate(privateKeySpec);

        // read AES key
        Cipher cipher = Cipher.getInstance(RSA.name());
        cipher.init(Cipher.DECRYPT_MODE, pk);
        byte[] aesKey = new byte[keySize / 8];  //Still don't know why there is a number 8 here.

        try (CipherInputStream is = new CipherInputStream(new FileInputStream(keyFile), cipher)) {
            is.read(aesKey);
        }
        
        return aesKey;
    }

    public static void encryptFile(byte[] key, AlgorithmType type, File in, File out) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {

        String typeName = type.name();
        Cipher ciipher = Cipher.getInstance(typeName);
        SecretKeySpec spec = new SecretKeySpec(key, typeName);
        ciipher.init(Cipher.ENCRYPT_MODE, spec);

        try (FileInputStream is = new FileInputStream(in); CipherOutputStream os = new CipherOutputStream(new FileOutputStream(out), ciipher)) {
            IOUtils.copy(is, os);
        }
    }

    public static void decryptFile(byte[] key, AlgorithmType type, File in, File out) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {

        String typeName = type.name();
        Cipher cipher = Cipher.getInstance(typeName);
        SecretKeySpec spec = new SecretKeySpec(key, typeName);
        cipher.init(Cipher.DECRYPT_MODE, spec);

        try (CipherInputStream is = new CipherInputStream(new FileInputStream(in), cipher); FileOutputStream os = new FileOutputStream(out)) {
            IOUtils.copy(is, os);
        }
    }
}
