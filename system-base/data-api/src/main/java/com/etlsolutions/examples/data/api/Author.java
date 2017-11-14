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
package com.etlsolutions.examples.data.api;

import com.etlsolutions.examples.data.general.Constrainable;

/**
 * The Author interface contains information about a book author.
 *
 *
 * @author Zhipeng Chang
 * 
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface Author extends Constrainable<Author> {

    /**
     * Get the personal detail for this author.
     *
     * @return the PersonalDetail object.
     */
    PersonalDetail getPersonalDetail();

    /**
     * Get the object of author biography.
     *
     * @return the object of author biography.
     */
    byte[] getBiography();

    /**
     * Get the web page of this author.
     *
     * @return the URL string.
     */
    String getWebpageUrl();

    /**
     * Get the image of this author.
     *
     * @return the author's image.
     */
    byte[] getImage();   
}
