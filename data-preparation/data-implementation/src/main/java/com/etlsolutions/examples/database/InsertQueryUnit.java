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
package com.etlsolutions.examples.database;

import com.etlsolutions.examples.data.general.container.MapList;
import com.etlsolutions.examples.utility.annotation.DataClass;
import java.util.Objects;

/**
 * The InsertQueryUnit class contains enough information for one INSERT INTO
 * query. This class will be thread-safe if the MapList object passed in from
 * the constructor is thread-safe.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
@DataClass
public final class InsertQueryUnit {

    private final String query;
    private final MapList mapList;

    /**
     *
     * @param query
     * @param maplist
     */
    public InsertQueryUnit(String query, MapList maplist) {
        this.query = query;
        this.mapList = maplist;
    }

    /**
     * Get the query string.
     * @return the query string.
     */
    public String getQuery() {
        return query;
    }

    /**
     *
     * @return
     */
    public MapList getMapList() {
        return mapList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.query);
        hash = 37 * hash + Objects.hashCode(this.mapList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InsertQueryUnit other = (InsertQueryUnit) obj;
        if (!Objects.equals(this.query, other.query)) {
            return false;
        }
        return Objects.equals(this.mapList, other.mapList);
    }

    @Override
    public String toString() {
        return "InsertQueryUnit{query=" + query + ", mapList=" + mapList + '}';
    }
}
