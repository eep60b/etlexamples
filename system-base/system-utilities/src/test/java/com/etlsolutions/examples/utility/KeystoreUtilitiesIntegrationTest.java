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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.security.Key;
import java.security.KeyStore;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class KeystoreUtilities.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class KeystoreUtilitiesIntegrationTest {

    /**
     * Test of the private constructor.
     *
     * @throws Exception if an error occurs.
     */
    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws Exception {
        Constructor[] constructors = KeystoreUtilities.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);

        Constructor constructor = constructors[0];
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    /**
     * Test of addKeyCertPairToKeystore method.
     *
     * To generate the keystore, run the following code: keytool -genkey -alias
     * mykeystore -keyalg RSA -keystore mykeystore.jks -keysize 2048
     *
     * To generate the private key (prv.der) and the certificate, follow these
     * steps: 1. openssl genrsa -out prv.pem 2048 2. openssl rsa -in prv.pem
     * -pubout > pub.pem 3. openssl pkcs8 -topk8 -inform PEM -outform DER -in
     * prv.pem -out prv.der -nocrypt 4. openssl req -new -key prv.pem -out
     * test.csr 5. openssl x509 -req -days 365 -in test.csr -signkey prv.pem
     * -sha1 -out test.cert
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testAddKeyCertPairToKeystore() throws Exception {

        FileUtils.copyDirectory(new File("src/test/resources/KeystoreUtilities"), new File("target/test/resources/KeystoreUtilities"));
        File keystoreFile = new File("target/test/resources/KeystoreUtilities/mykeystore.jks");
        String keypass = "passtest";
        File keyFile = new File("target/test/resources/KeystoreUtilities/prv.der");
        File certFile = new File("target/test/resources/KeystoreUtilities/test.cert");
        String defaultalias = "goodtest";
        KeystoreUtilities.addKeyCertPairToKeystore(keystoreFile, keypass, keyFile, certFile, defaultalias);

        KeyStore keyStore = KeystoreUtilities.loadKeyStore(keystoreFile, keypass);

        assertEquals(2, keyStore.size());        
        assertTrue(keyStore.containsAlias(defaultalias));

        Key key = keyStore.getKey(defaultalias, keypass.toCharArray());
        assertEquals("RSA", key.getAlgorithm());
        assertEquals("PKCS#8", key.getFormat());
    }

    @Test
    public void testAddKeyCertPairToKeystore_NoStoreFile() throws Exception {

        FileUtils.copyDirectory(new File("src/test/resources/KeystoreUtilities"), new File("target/test/resources/KeystoreUtilities"));
        File keystoreFile = new File("target/test/resources/KeystoreUtilities/newkeystore.jks");
        String keypass = "passtest";
        File keyFile = new File("target/test/resources/KeystoreUtilities/prv.der");
        File certFile = new File("target/test/resources/KeystoreUtilities/test.cert");
        String defaultalias = "goodtest";
        
        keystoreFile.delete();
        
        KeystoreUtilities.addKeyCertPairToKeystore(keystoreFile, keypass, keyFile, certFile, defaultalias);

        KeyStore keyStore = KeystoreUtilities.loadKeyStore(keystoreFile, keypass);

        assertEquals(1, keyStore.size());        
        assertTrue(keyStore.containsAlias(defaultalias));

        Key key = keyStore.getKey(defaultalias, keypass.toCharArray());
        assertEquals("RSA", key.getAlgorithm());
        assertEquals("PKCS#8", key.getFormat());
    }    
    
    /**
     * Test of createKeyStoreFile method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testCreateKeyStoreFile() throws Exception {

        File keystoreFile = new File("target/test/resources/KeystoreUtilities/test/newkeystore.jks");
        keystoreFile.delete();
        String password = "afdakbbadj";
        
        KeystoreUtilities.createKeyStoreFile(keystoreFile, password);

        KeyStore keyStore = KeystoreUtilities.loadKeyStore(keystoreFile, password);

        assertEquals(0, keyStore.size());
    }

}
