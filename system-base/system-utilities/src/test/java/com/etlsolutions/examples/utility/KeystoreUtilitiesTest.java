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

import com.etlsolutions.examples.utility.KeystoreUtilities.KeystoreType;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class KeystoreUtilities.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({KeystoreUtilities.class, KeyStore.class, KeyFactory.class, CertificateFactory.class, DataInputStream.class})
public final class KeystoreUtilitiesTest {

    private final KeystoreType type = KeystoreType.JKS;
    private final String providerName = "SUN";
    private final File keystoreFile = Mockito.mock(File.class);
    private final File keyStoreFileParent = Mockito.mock(File.class);
    private final String keypass = "passwerodcannotbeseen";
    private final char[] pass = keypass.toCharArray();
    private final File keyFile = Mockito.mock(File.class);
    private final FileInputStream keyFileInputStream = Mockito.mock(FileInputStream.class);
    private final DataInputStream keyFileDataInputStream = PowerMockito.mock(DataInputStream.class);
    private final ByteArrayInputStream keyFileByteArrayInputStream = Mockito.mock(ByteArrayInputStream.class);
    private final FileInputStream certFileInputStream = Mockito.mock(FileInputStream.class);
    private final DataInputStream certFileDataInputStream = PowerMockito.mock(DataInputStream.class);
    private final ByteArrayInputStream certFileByteArrayInputStream = Mockito.mock(ByteArrayInputStream.class);
    private final File certFile = Mockito.mock(File.class);
    private final String defaultalias = "defanl aalr";
    private final KeyStore keyStore = PowerMockito.mock(KeyStore.class);
    private final FileOutputStream keystoreFileOutputStream = Mockito.mock(FileOutputStream.class);
    private final FileInputStream keystoreFileInputStream = Mockito.mock(FileInputStream.class);
    private final KeyFactory keyFactory = PowerMockito.mock(KeyFactory.class);
    private final PKCS8EncodedKeySpec keySpec = Mockito.mock(PKCS8EncodedKeySpec.class);
    private final PrivateKey privateKey = Mockito.mock(PrivateKey.class);
    private final CertificateFactory cf = PowerMockito.mock(CertificateFactory.class);
    private final Certificate[] certs = new Certificate[]{};

    private final InOrder inOrder = Mockito.inOrder(keyStore, keystoreFileOutputStream, keyStoreFileParent, keystoreFileInputStream, keystoreFile,
            keyFileInputStream, keyFileDataInputStream, keyFileByteArrayInputStream, certFileInputStream, certFileDataInputStream, certFileByteArrayInputStream);

    @Before
    public void setUp() throws Exception {

        Mockito.when(keystoreFile.getParentFile()).thenReturn(keyStoreFileParent);

        PowerMockito.mockStatic(KeyStore.class);
        Mockito.when(KeyStore.getInstance("JKS", "SUN")).thenReturn(keyStore);

        PowerMockito.whenNew(FileOutputStream.class).withArguments(keystoreFile).thenReturn(keystoreFileOutputStream);
        PowerMockito.whenNew(FileInputStream.class).withArguments(keystoreFile).thenReturn(keystoreFileInputStream);

        PowerMockito.whenNew(FileInputStream.class).withArguments(keyFile).thenReturn(keyFileInputStream);
        PowerMockito.whenNew(DataInputStream.class).withArguments(keyFileInputStream).thenReturn(keyFileDataInputStream);
        PowerMockito.whenNew(FileInputStream.class).withArguments(certFile).thenReturn(certFileInputStream);
        PowerMockito.whenNew(DataInputStream.class).withArguments(certFileInputStream).thenReturn(certFileDataInputStream);
        PowerMockito.whenNew(ByteArrayInputStream.class).withArguments(Mockito.any(byte[].class)).thenReturn(keyFileByteArrayInputStream).thenReturn(certFileByteArrayInputStream);

        PowerMockito.mockStatic(KeyFactory.class);
        Mockito.when(KeyFactory.getInstance("RSA")).thenReturn(keyFactory);

        Mockito.when(keyFileByteArrayInputStream.available()).thenReturn(23821);
        Mockito.when(certFileByteArrayInputStream.available()).thenReturn(77821);        
        PowerMockito.whenNew(PKCS8EncodedKeySpec.class).withArguments(Mockito.any(byte[].class)).thenReturn(keySpec);

        Mockito.when(keyFactory.generatePrivate(keySpec)).thenReturn(privateKey);

        PowerMockito.mockStatic(CertificateFactory.class);
        Mockito.when(CertificateFactory.getInstance("X.509")).thenReturn(cf);

        Collection c = Mockito.mock(Collection.class);
        Mockito.when(c.toArray(new Certificate[]{})).thenReturn(certs);
    }

    /**
     * Test of createKeyStoreFile method.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testCreateKeyStoreFile_File_String() throws Exception {

        Mockito.when(keystoreFile.createNewFile()).thenReturn(Boolean.TRUE);

        KeystoreUtilities.createKeyStoreFile(keystoreFile, keypass);

        inOrder.verify(keyStoreFileParent).mkdirs();
        inOrder.verify(keyStore).load(null, pass);
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keystoreFileOutputStream).close();
    }

    /**
     * Test of createKeyStoreFile method.
     *
     * @throws Exception if an error occurs
     */
    @Test(expected = IOException.class)
    public void testCreateKeyStoreFile_File_String_CannotCreateNewFile() throws Exception {

        Mockito.when(keystoreFile.createNewFile()).thenReturn(Boolean.FALSE);

        KeystoreUtilities.createKeyStoreFile(keystoreFile, keypass);
    }

    /**
     * Test of createKeyStoreFile method.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testCreateKeyStoreFile_4args() throws Exception {

        Mockito.when(keystoreFile.createNewFile()).thenReturn(Boolean.TRUE);
        
        KeystoreUtilities.createKeyStoreFile(KeystoreType.JKS, "SUN", keystoreFile, keypass);

        inOrder.verify(keyStore).load(null, pass);
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keystoreFileOutputStream).close();
    }

    /**
     * Test of addKeyCertPairToKeystore method.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testAddKeyCertPairToKeystore_5args() throws Exception {

        Mockito.when(keystoreFile.exists()).thenReturn(Boolean.TRUE);

        KeystoreUtilities.addKeyCertPairToKeystore(keystoreFile, keypass, keyFile, certFile, defaultalias);

        inOrder.verify(keyStore).load(keystoreFileInputStream, pass);
        inOrder.verify(keystoreFileInputStream).close();
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keyFileDataInputStream).readFully(Mockito.any(byte[].class));
        inOrder.verify(keyFileInputStream).close();
        inOrder.verify(keyFileDataInputStream).close();
        inOrder.verify(keyFileByteArrayInputStream).read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt());
        inOrder.verify(certFileDataInputStream).readFully(Mockito.any(byte[].class)); 
        inOrder.verify(certFileInputStream).close();
        inOrder.verify(certFileDataInputStream).close();        
        inOrder.verify(certFileByteArrayInputStream).read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.eq(77821));        
        inOrder.verify(keyStore).setKeyEntry(defaultalias, privateKey, pass, certs);
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keyFileByteArrayInputStream).close();
        Mockito.verify(keystoreFileOutputStream, Mockito.times(2)).close();
    }

    /**
     * Test of addKeyCertPairToKeystore method.
     *
     * @throws Exception if an error occurs
     */
    @Test
    public void testAddKeyCertPairToKeystore_5args_newKeyStore() throws Exception {

        Mockito.when(keystoreFile.exists()).thenReturn(Boolean.FALSE);

        KeystoreUtilities.addKeyCertPairToKeystore(keystoreFile, keypass, keyFile, certFile, defaultalias);

        inOrder.verify(keyStoreFileParent).mkdirs();
        inOrder.verify(keystoreFile).createNewFile();
        inOrder.verify(keyStore).load(null, pass);
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keystoreFileOutputStream).close();
        inOrder.verify(keyStore).load(keystoreFileInputStream, pass);
        inOrder.verify(keystoreFileInputStream).close();
        inOrder.verify(keyFileDataInputStream).readFully(Mockito.any(byte[].class)); 
        inOrder.verify(keyFileInputStream).close();
        Mockito.verify(keyFileDataInputStream).close();        
        inOrder.verify(keyFileByteArrayInputStream).read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.eq(23821));
        inOrder.verify(certFileDataInputStream).readFully(Mockito.any(byte[].class)); 
        inOrder.verify(certFileInputStream).close();
        inOrder.verify(certFileDataInputStream).close();        
        inOrder.verify(certFileByteArrayInputStream).read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.eq(77821));         
        inOrder.verify(keyStore).setKeyEntry(defaultalias, privateKey, pass, certs);
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keyFileByteArrayInputStream).close();
        Mockito.verify(keystoreFileOutputStream, Mockito.times(2)).close();
    }

    /**
     * Test of addKeyCertPairToKeystore method.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testAddKeyCertPairToKeystore_7args() throws Exception {

        Mockito.when(keystoreFile.exists()).thenReturn(Boolean.TRUE);

        KeystoreUtilities.addKeyCertPairToKeystore(type, providerName, keystoreFile, keypass, keyFile, certFile, defaultalias);

        inOrder.verify(keyStore).load(keystoreFileInputStream, pass);
        inOrder.verify(keystoreFileInputStream).close();
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keyFileDataInputStream).readFully(Mockito.any(byte[].class));    
        inOrder.verify(keyFileInputStream).close();
        inOrder.verify(keyFileDataInputStream).close();        
        inOrder.verify(keyFileByteArrayInputStream).read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.eq(23821));
        inOrder.verify(certFileDataInputStream).readFully(Mockito.any(byte[].class)); 
        inOrder.verify(certFileInputStream).close();
        inOrder.verify(certFileDataInputStream).close();        
        inOrder.verify(certFileByteArrayInputStream).read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.eq(77821));         
        inOrder.verify(keyStore).setKeyEntry(defaultalias, privateKey, pass, certs);
        inOrder.verify(keyStore).store(keystoreFileOutputStream, pass);
        inOrder.verify(keyFileByteArrayInputStream).close();
        Mockito.verify(keystoreFileOutputStream, Mockito.times(2)).close();
    }

    /**
     * Test of loadKeyStore method, of class KeystoreUtilities.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadKeyStore_File_String() throws Exception {

        assertEquals(keyStore, KeystoreUtilities.loadKeyStore(keystoreFile, keypass));
        inOrder.verify(keyStore).load(keystoreFileInputStream, pass);
        inOrder.verify(keystoreFileInputStream).close();
    }

    /**
     * Test of loadKeyStore method, of class KeystoreUtilities.
     *
     * @throws Exception if an error occurs.
     */
    @Test
    public void testLoadKeyStore_4args() throws Exception {

        assertEquals(keyStore, KeystoreUtilities.loadKeyStore(type, providerName, keystoreFile, keypass));
        inOrder.verify(keyStore).load(keystoreFileInputStream, pass);
        inOrder.verify(keystoreFileInputStream).close();
    }

}
