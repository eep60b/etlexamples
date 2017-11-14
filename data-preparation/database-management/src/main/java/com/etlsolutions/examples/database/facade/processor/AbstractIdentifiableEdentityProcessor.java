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
package com.etlsolutions.examples.database.facade.processor;

import com.etlsolutions.examples.data.general.Constrainable;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.spi.IdentifiableSpi;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.utility.annotation.OperationClass;
import java.util.List;

/**
 * The AbstractIdentifiableEdentityProcessor class contains methods to save
 * operations for a table column in the database. Each processor will only save
 * one identifiable entity which represent a single role in the database.
 *
 * @author Zhipeng Chang
 *
 * @param <I> - The concrete type of Identifiable object which will be used in
 * this class.
 * @param <T> - The object type which contains parameters for the arguments of
 * save and retrieve methods.
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@OperationClass
public abstract class AbstractIdentifiableEdentityProcessor<I extends IdentifiableSpi, T> extends AbstractProcessor<T>{



    /**
     * Construct an object with the specified parameters.
     *
     * @param facade - The BookshopFacade object which is created using the
     * specified Hibernate configuration file.
     */
    protected AbstractIdentifiableEdentityProcessor(BookshopFacade facade) {
        super(facade);
    }


    /**
     * This is the method which do the concrete save operation.
     *
     * @param object
     * @return an identifiable object which represents the saved entry. This
     * method will NOT return null. If the parameters cannot be saved, an
     * exception will be thrown.
     */
    protected abstract I doSave(T object);

    @Override
    public final I save(T object) {

        I pojo = doSave(object);

        //If the id is zero, the entry associated with the pojo is not in the database.
        if (pojo.getId() == 0) {

            //There should be only one ID in the list. Therefore we don't check the list.
            List<Object> ids = facade.save(pojo);
            
            pojo.setId((Integer)ids.get(0));
        }
        return pojo;
    }

    /**
     * Find the object which has the same constraints as the given object in the
     * database.
     *
     * @param <C> - The type of object which is going to be found.
     * @param <T>
     * @param queryStringKey - The query string key.
     * @param keyValuePairs
     * @param constraintable
     * @return
     */
    protected final <C extends Constrainable<C>, T extends C> T findConstraintableWithSameParameters(String queryStringKey, C constraintable, StringKeyValuePair... keyValuePairs) {

        List<T> list = facade.retrieveList(queryStringKey, keyValuePairs);
        for (T pojo : list) {
            if (pojo.hasSameParameters(constraintable)) {
                return pojo;
            }
            throw new IllegalStateException("Error - There is an entry in the database with the same constraints as the object to be retrieved but some of its parameters are NOT the sase as the object to be retrieved .");
        }
        return null;
    }
}
