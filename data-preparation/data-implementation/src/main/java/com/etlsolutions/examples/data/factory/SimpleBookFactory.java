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
package com.etlsolutions.examples.data.factory;

import com.etlsolutions.examples.data.api.SimpleBook;
import com.etlsolutions.examples.data.bean.SimpleBookJavaBean;
import com.etlsolutions.examples.message.ErrorType;
import static com.etlsolutions.examples.message.MessageFactory.getMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The SimpleBookFactory class is used to generate SimpleBook objects.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class SimpleBookFactory {

    private SimpleBookFactory() {
        throw new UnsupportedOperationException(getMessage(ErrorType.PRIVATE_CONSTRUCTOR));
    }

    /**
     * Get a generated list for the SimpleBook objects. These objects are
     * strictly following the JavaBean conventions. All the book will be named
     * as "untitled". The current date will be used as the published date. They
     * are not guaranteed to be the same. The book ID will start with 1
     * incrementally.
     *
     * @param number - How many books should be in the list. An empty list will
     * be generated if the number is negative or zero.
     * @return the book list. This list can be empty but CANNOT be null.
     */
    public static List<SimpleBook> getGeneratedSimpleBookJavaBeanList(int number) {

        List<SimpleBook> list = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            list.add(new SimpleBookJavaBean(i, "untitled", new Date()));
        }

        return list;
    }
}
