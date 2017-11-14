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

import com.etlsolutions.examples.base.configuration.SystemConfigPropertiesFactory.SystemConfigProperties;
import com.etlsolutions.examples.base.log.SystemLogger;
import com.etlsolutions.examples.message.MessageFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

/**
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@PrepareForTest({SystemConfigPropertiesFactory.class, SystemLogger.class, MessageFactory.class})
public final class SystemConfigPropertiesFactoryTest {

    @Rule
    public final PowerMockRule rule = new PowerMockRule();

    private final Properties properties = PowerMockito.mock(Properties.class);
    private final String repositoryPath = SystemConstants.USER_HOME + File.separator + ".etl-examples";
    private final String configPath = repositoryPath + File.separator + "etl-examples.properties";
    private final File configFile = Mockito.mock(File.class);
    private final FileInputStream fileInputStream = Mockito.mock(FileInputStream.class);

    private final SystemConfigProperties systemConfigProperties = PowerMockito.mock(SystemConfigProperties.class);

    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Properties.class).withNoArguments().thenReturn(properties);
        PowerMockito.whenNew(File.class).withArguments(configPath).thenReturn(configFile);
        PowerMockito.whenNew(FileInputStream.class).withArguments(configFile).thenReturn(fileInputStream);

        PowerMockito.mockStatic(SystemLogger.class);

        PowerMockito.whenNew(SystemConfigProperties.class).withArguments(properties).thenReturn(systemConfigProperties);
    }

    /**
     * Test of the private constructor.
     */
    @Test
    public void testConstructor() {
        Constructor[] constructors = SystemConfigPropertiesFactory.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);
        assertFalse(Modifier.isPrivate(constructors[0].getModifiers()));
    }

    /**
     * Test of getSystemConfigProperties method. The first time called. The
     * configuration file is a valid file.
     *
     * @throws IOException
     */
    @Test
    public void testGetSystemConfigProperties() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_SystemConfiPropertiesExists() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_NoConfigFile() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_NullFileInputString() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_FilInputStringCloseException() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_NullConfigFileParentDirectory() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_NoConfigFileParentDirectoryCanCreate() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_NoConfigFileParentDirectoryCannotCreate() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_NullFileOutputStream() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    @Test
    public void testGetSystemConfigProperties_FileOutputStreamCloseException() throws IOException {
        Mockito.when(configFile.isFile()).thenReturn(Boolean.TRUE);

        assertEquals(systemConfigProperties, SystemConfigPropertiesFactory.getSystemConfigProperties());
        Mockito.verify(properties).load(fileInputStream);
        Mockito.verify(fileInputStream).close();

        PowerMockito.verifyStatic(Mockito.never());
        SystemLogger.warn(Mockito.eq(SystemConfigPropertiesFactory.class), Mockito.anyString(), Mockito.any(Throwable.class));
    }

    /**
     * Test of storeSystemConfigProperties method.
     */
    @Test
    public void testStoreSystemConfigProperties() {
        System.out.println("storeSystemConfigProperties");
        SystemConfigPropertiesFactory.storeSystemConfigProperties();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
