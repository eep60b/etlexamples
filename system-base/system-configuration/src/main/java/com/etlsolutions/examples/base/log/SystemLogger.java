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
package com.etlsolutions.examples.base.log;

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import com.etlsolutions.examples.utility.annotation.OperationClass;
import org.apache.log4j.Logger;

/**
 * The SystemLogger class delegate some methods of the log4j Logger class which
 * can be used in this application.
 *
 * @author Zhipeng Chang
 * 
 * @version 1.0.0
 */
@OperationClass
@NotThreadSafe
public final class SystemLogger {

    private SystemLogger() {
        throw new UnsupportedOperationException(MessageFactory.getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * Log a message for a class with the <code>ERROR</code> level including the stack trace
     * of the {@link Throwable} <code>t</code> passed as parameter.
     *
     * @param sourceClass - The source class.
     * @param message - The message to be logged.
     * @param t - The object which produces the stack trace to be logged.
     */
    public static void error(Class sourceClass, String message, Throwable t) {
        Logger.getLogger(sourceClass).error(message, t);
    }

    /**
     * Log a message for a class with the <code>ERROR</code> level.
     *
     * @param sourceClass  - The source class.
     * @param message - The message to be logged.
     */
    public static void error(Class sourceClass, String message) {
        Logger.getLogger(sourceClass).error(message);
    }

    /**
     * Log a message for a class with the <code>INFO</code> level including the stack trace
     * of the {@link Throwable} <code>t</code> passed as parameter.
     *
     * @param sourceClass  - The source class.
     * @param message - The message to be logged.
     * @param t - The object which produces the stack trace to be logged.
     */
    public static void info(Class sourceClass, String message, Throwable t) {
        Logger.getLogger(sourceClass).info(message, t);
    }

    /**
     * Log a message for a class with the <code>INFO</code> level.
     *
     * @param sourceClass - The source class.
     * @param message - The message to be logged.
     */
    public static void info(Class sourceClass, String message) {
        Logger.getLogger(sourceClass).info(message);
    }

    /**
     * Log a message for a class with the <code>WARN</code> level including the stack trace
     * of the {@link Throwable} <code>t</code> passed as parameter.
     *
     * @param sourceClass  - The source class.
     * @param message - The message to be logged.
     * @param t - The object which produces the stack trace to be logged.
     */
    public static void warn(Class sourceClass, String message, Throwable t) {
        Logger.getLogger(sourceClass).warn(message, t);
    }


    /**
     * Log a message for a class with the <code>WARN</code> level.
     *
     * @param sourceClass  - The source class.
     * @param message - The message to be logged.
     */
    public static void warn(Class sourceClass, String message) {
        Logger.getLogger(sourceClass).warn(message);
    }

    /**
     * Log a message for a class with the <code>FATAL</code> level including the stack trace
     * of the {@link Throwable} <code>t</code> passed as parameter.
     *
     * @param sourceClass - The source class.
     * @param message - The message to be logged.
     * @param t - The object which produces the stack trace to be logged.
     */
    public static void fatal(Class sourceClass, String message, Throwable t) {
        Logger.getLogger(sourceClass).fatal(message, t);
    }


    /**
     * Log a message for a class with the <code>FATAL</code> level.
     *
     * @param sourceClass - The source class.
     * @param message - The message to be logged.
     */
    public static void fatal(Class sourceClass, String message) {
        Logger.getLogger(sourceClass).fatal(message);
    }
    
    /**
     * Log the stack trace of the {@link Throwable} <code>t</code> passed as parameter.
     *
     * @param sourceClass - The source class.
     * @param t - The object which produces the stack trace to be logged.
     */    
    public static void fatal(Class sourceClass, Throwable t) {
        fatal(sourceClass, "", t);
    }    
}
