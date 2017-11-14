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
package com.etlsolutions.examples.database.maplist;

/**
 * The SequenceIdGenerationDefinition class
 * 
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 */
public final class SequenceIdGenerationDefinition implements IdGenerationDefinition {
    
    private final int start;
    private final int step;
    private final int size;

    /**
     * 
     * @param size
     * @param start
     * @param Step 
     */
    public SequenceIdGenerationDefinition(int size, int start, int Step) {
        this.start = start;
        this.step = Step;
        this.size = size;
    }

    /**
     * 
     * @param size
     * @param start 
     */
    public SequenceIdGenerationDefinition(int size, int start) {
        this(size, start, 1);
    }

    /**
     * 
     * @param size 
     */
    public SequenceIdGenerationDefinition(int size) {
        this(size, 1, 1);
    }    
    
    public int getStart() {
        return start;
    }

    public int getStep() {
        return step;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.start;
        hash = 83 * hash + this.step;
        hash = 83 * hash + this.size;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SequenceIdGenerationDefinition other = (SequenceIdGenerationDefinition) obj;
        if (this.start != other.start) {
            return false;
        }
        if (this.step != other.step) {
            return false;
        }
        return this.size == other.size;
    }
}
