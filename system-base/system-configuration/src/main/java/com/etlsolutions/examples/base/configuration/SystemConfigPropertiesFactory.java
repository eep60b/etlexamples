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

import com.etlsolutions.examples.base.log.SystemLogger;
import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.InfoType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.message.WarnType;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.SynchronizedMethod;
import com.etlsolutions.examples.utility.annotation.OperationClass;
import com.etlsolutions.examples.utility.annotation.SynchronizedMethod.MethodLockType;
import com.etlsolutions.examples.utility.annotation.ThreadSafe;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The SystemConfigPropertiFactory class provides a SystemConfigProperties
 * singleton object for the application. The object will be used until the
 * application terminate.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
@OperationClass
@ThreadSafe
public final class SystemConfigPropertiesFactory {

    private static final Object LOCK = new Object();

    private static SystemConfigProperties systemConfigProperties;

    private SystemConfigPropertiesFactory() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }
      
    /**
     * Get the SystemConfigProperties object using for the application. Create a
     * new one if it is not available.
     *
     * @return the valid SystemConfigProperties object.
     */
    @SynchronizedMethod(lockType = MethodLockType.EXPLICIT,
            description = "An explicit private lock which cannot be shared from outside.",
            otherSynchronizedMethods = {"storeSystemConfigProperties"})
    public static SystemConfigProperties getSystemConfigProperties() {
        synchronized (LOCK) {
            if (systemConfigProperties == null) {

                Properties properties = new Properties();

                String repositoryPath = SystemConstants.USER_HOME + File.separator + SystemConstants.APPLICATION_HOME_NAME;
                String configPath = repositoryPath + File.separator + SystemConstants.SYSTEM_CONFIG_FILE_NAME;
                File configFile = new File(configPath);

                if (configFile.isFile()) {
                    FileInputStream fileInputStream = null;

                    try {
                        fileInputStream = new FileInputStream(configFile);
                        properties.load(fileInputStream);
                    } catch (IOException ex) {
                        SystemLogger.warn(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(WarnType.CANNOT_READ_CONFIG_FILE, repositoryPath), ex);
                        setDefaultProperties(configFile, properties, repositoryPath);
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException ex) {
                                SystemLogger.warn(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(WarnType.CANNOT_CLOSE_CONFIG_FILE, repositoryPath), ex);
                            }
                        }
                    }

                } else {

                    setDefaultProperties(configFile, properties, repositoryPath);
                }

                return new SystemConfigProperties(properties);
            }

            return systemConfigProperties;
        }
    }

    private static void setDefaultProperties(File configFile, Properties properties, String repositoryPath) {
        SystemLogger.info(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(InfoType.NO_CONFIG_FILE, repositoryPath));
        SystemLogger.info(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(InfoType.COPY_DEFAULT_CONFIG_FILE, repositoryPath));

        properties.setProperty(SystemConstants.RANDOM_WORD_GENERATION_FILESET_PATH_PROPERTY, SystemConstants.RANDOM_WORD_GENERATION_FILESET_DEFAULT_PATH);
        FileOutputStream fileOutputStream = null;
        try {

            File configDirectory = configFile.getParentFile();

            if (configDirectory == null) {
                throw new IOException();
            }

            boolean hasDirectory = configDirectory.exists();

            if (!hasDirectory) {
                hasDirectory = configDirectory.mkdirs();
            }

            if (hasDirectory) {

                fileOutputStream = new FileOutputStream(configFile);
                properties.store(fileOutputStream, MessageFactory.getMessage(InfoType.CONFIG_FILE_COMMENTS));
            } else {
                throw new IOException();
            }

        } catch (Exception ex) {
            SystemLogger.warn(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(WarnType.CANNOT_STORE_CONFIG_FILE, repositoryPath), ex);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException ex) {
                    SystemLogger.warn(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(WarnType.CANNOT_CLOSE_CONFIG_FILE, repositoryPath), ex);
                }
            }
        }
    }

    /**
     * Write the properties in the writeSystemConfigProperties singleton object
     * to the configuration file on the disk.
     */
    @SynchronizedMethod(lockType = MethodLockType.EXPLICIT,
            description = "An explicit private lock which cannot be shared from outside.",
            otherSynchronizedMethods = {"getSystemConfigProperties"})
    public static void storeSystemConfigProperties() {
        synchronized (LOCK) {

            if (systemConfigProperties == null) {
                SystemLogger.warn(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(WarnType.ATTEMPT_WRITE_EMPTY_CONFIG_FILE));
            }
            String repositoryPath = SystemConstants.USER_HOME + File.separator + SystemConstants.APPLICATION_HOME_NAME;
            String configPath = repositoryPath + File.separator + SystemConstants.SYSTEM_CONFIG_FILE_NAME;
            FileOutputStream fileOutputStream = null;
            try {
                systemConfigProperties.properties.store(new FileOutputStream(new File(configPath)), MessageFactory.getMessage(InfoType.STORE_CONFIG_FILE));
                SystemLogger.info(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(InfoType.STORE_CONFIG_FILE_SUCCESS));
            } catch (IOException ex) {
                SystemLogger.warn(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(WarnType.CANNOT_STORE_CONFIG_FILE, repositoryPath), ex);
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException ex) {
                        SystemLogger.warn(SystemConfigPropertiesFactory.class, MessageFactory.getMessage(WarnType.CANNOT_CLOSE_CONFIG_FILE, repositoryPath), ex);
                    }
                }

            }
        }
    }

    /**
     * The SystemConfigProperties class contains all the system configuration
     * for this application.
     */
    @ThreadSafe
    @DataClass
    public static final class SystemConfigProperties {

        private final Object randomWordGenerationFileSetPathLock = new Object();

        private final Properties properties;

        private SystemConfigProperties(Properties properties) {
            this.properties = properties;
        }

        /**
         * Get the random word generation file set path. The path can point to
         * either a directory or a text file.
         *
         * @return the path string.
         */
        @SynchronizedMethod(lockType = MethodLockType.EXPLICIT,
                description = "An explicit private lock which cannot be shared from outside.",
                otherSynchronizedMethods = "setRandomWordGenerationFileSetPath")
        public String getRandomWordGenerationFileSetPath() {
            synchronized (randomWordGenerationFileSetPathLock) {
                return properties.getProperty(SystemConstants.RANDOM_WORD_GENERATION_FILESET_PATH_PROPERTY);
            }
        }

        /**
         * Set the random word generation file set path into the configuration
         * properties object. This will not save the change to the disk. To save the configuration see {@link #storeSystemConfigProperties()}.
         *
         * @param path - The path to be used.
         */
        @SynchronizedMethod(lockType = MethodLockType.EXPLICIT,
                description = "An explicit private lock which cannot be shared from outside.",
                otherSynchronizedMethods = "getRandomWordGenerationFileSetPath")
        public void setRandomWordGenerationFileSetPath(String path) {
            synchronized (randomWordGenerationFileSetPathLock) {
                properties.setProperty(SystemConstants.RANDOM_WORD_GENERATION_FILESET_PATH_PROPERTY, path);
            }
        }
    }
}
