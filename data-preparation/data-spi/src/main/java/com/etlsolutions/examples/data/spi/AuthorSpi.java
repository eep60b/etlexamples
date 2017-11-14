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
package com.etlsolutions.examples.data.spi;

import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.PersonalDetail;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAuthor;

/**
 * The AuthorSpi interface contains information about a book author.
 *
 * @author Zhipeng Chang
 * 
 * @param <P> - The concrete PersonalDetailSpi type used in this object.
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public interface AuthorSpi<P extends PersonalDetail> extends IdentifiableAuthor, IdentifiableSpi {
         
    /**
     * Set the author biographic object.
     *
     * @param biography - The author's biographic object.
     */
    void setBiography(byte[] biography);

    /**
     * Set the author web page link.
     *
     * @param webpageUrl - The web page string.
     */
    void setWebpageUrl(String webpageUrl);

    /**
     * Set the image object of this author.
     *
     * @param image - The photo object.
     */
    void setImage(byte[] image);

    /**
     * Set the personal detail for this author.
     *
     * @param personalDetail - The PersonalDetailSpi object.
     */
    void setPersonalDetail(P personalDetail);

}
