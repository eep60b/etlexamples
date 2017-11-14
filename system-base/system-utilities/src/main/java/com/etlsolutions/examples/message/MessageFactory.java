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
package com.etlsolutions.examples.message;

/**
 * The MessageFactory class is a factory class which generates the messages for log etc.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class MessageFactory {

    private MessageFactory() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     *
     * @param type
     * @return
     */
    public static String getMessage(MessageType type) {
        return type.getMessage();
    }

    /**
     *
     * @param type
     * @param objects
     * @return the message.
     */
    public static String getMessage(MessageType type, Object... objects) {

        StringBuilder builder = new StringBuilder(MessageFactory.getMessage(type));
        addObjectsToStringBuilder(builder, objects);
        return new String(builder);
    }

    /**
     *
     * @param type
     * @param details
     * @return
     */
    public static String getMessage(MessageType type, String details) {
        return MessageFactory.getMessage(type) + details + "\n";
    }

    /**
     *
     * @param type
     * @param details
     * @param objects
     * @return
     */
    public static String getMessage(MessageType type, String details, Object... objects) {

        StringBuilder builder = new StringBuilder(MessageFactory.getMessage(type) + details);
        addObjectsToStringBuilder(builder, objects);
        return new String(builder);
    }

    /**
     *
     * @param type
     * @param preObjectsInformation
     * @param objects
     * @param postObjectsInformation
     * @return
     */
    public static String getMessage(MessageType type, String preObjectsInformation, Object[] objects, String postObjectsInformation) {

        return  getMessage(type, preObjectsInformation, objects) + postObjectsInformation + "\n";
    }

    private static void addObjectsToStringBuilder(StringBuilder builder, Object[] objects) {
        for (Object object : objects) {
            builder.append("[").append(object).append("], ");
        }
        int length = builder.length();
        builder.replace(length - 2, length, ".");
        builder.append("\n");
    }
}
