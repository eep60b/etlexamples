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
package com.etlsolutions.examples.data;

import com.etlsolutions.examples.utility.annotation.OperationClass;
import com.etlsolutions.examples.utility.annotation.StatelessClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * The KeyGenerator class generates key collections for different purpose.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 * @version 1.1.0 - Add sever methods to generate key sets.
 * @version 1.2.0 - Add the generateRandomKey method.
 * @version 1.3.0 - Add the generateUniqueObjectFromList and
 * generateUniqueObjectArrayFromList methods.
 * @version 1.3.1 - Add implementations for equals, hashCode and toString
 * methods.
 */
@OperationClass
@StatelessClass
public final class KeyGenerator {

    private static final int INTEGER_KEY_LIMIT = 10000000;

    private final Random random = new Random();

    /**
     * Generate a list of integers while each integer is unique so they can be
     * used as keys.
     *
     * The maximum of the key is 1000000.
     *
     * @param size - The size of the list.
     * @return the key list.
     */
    public List<Integer> generateRamdonKeys(int size) {
        List<Integer> list = new ArrayList<>(generateRamdonKeySet(size));
        Collections.sort(list);
        return list;
    }

    /**
     * Generate a set of integers which can be used as keys.
     *
     * The maximum of the key is 1000000.
     *
     * @param size - The set size.
     * @return the key set.
     */
    public Set<Integer> generateRamdonKeySet(int size) {

        Set<Integer> set = new HashSet<>();
        while (set.size() < size) {
            int key = random.nextInt(INTEGER_KEY_LIMIT);
            set.add(key);
        }

        return set;
    }

    /**
     * Generate a set of number keys with random numbers. Each the number is
     * unique.
     *
     * @param number - How many keys to be generated.
     * @return the key set.
     */
    public Set<Long> generateRandomKeySet(int number) {

        Set<Long> set = new HashSet<>();
        while (set.size() < number) {
            UUID uuid = UUID.randomUUID();
            long key = uuid.getLeastSignificantBits();
            set.add(key);
        }

        return set;
    }

    /**
     * Generate a set of number keys with random numbers. Each the number is
     * unique. The keys is in an order from the smallest number.
     *
     * @param number - How many keys to be generated.
     * @return the key set.
     */
    public List<Long> generateRandomKeyList(int number) {

        List<Long> list = new ArrayList<>(generateRandomKeySet(number));
        Collections.sort(list);
        return list;
    }

    /**
     * Generate a sequence key list with the specified start size and step. The
     * list will start will the smallest size.
     *
     * @param size - How many keys to be generated.
     * @param start - The smallest size to start.
     * @param step - The step between two numbers.
     * @return the key list.
     */
    public List<Integer> generateSequenceKeyList(int size, int start, int step) {

        List<Integer> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add(start + i * step);
        }

        return list;
    }

    /**
     * Generate a sequence key set with the specified start size and step.
     *
     * @param size - How many keys to be generated.
     * @param start - The smallest size to start.
     * @param step - The step between two numbers.
     * @return the key set.
     */
    public Set<Integer> generateSequenceKeySet(int size, int start, int step) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            set.add(start + i * step);
        }

        return set;
    }

    /**
     * Randomly select a key from the specified list.
     *
     * @param <T>
     * @param list - The specified list.
     * @return the generated integer key.
     */
    public <T> T generateRandomKeyFromList(List<T> list) {

        int index = random.nextInt(list.size());
        return list.get(index);
    }

    /**
     * Randomly select an object from the list. The object will be added to a
     * set. The object must be unique in the set.
     *
     * @param <T> - The object type.
     * @param generatedObjects - The set where the object to be added.
     * @param list - The list from witch the object is selected.
     * @return - The selected object.
     */
    public <T> T generateUniqueObjectFromList(Set<T> generatedObjects, List<T> list) {
        T personalDetailId;
        if (generatedObjects.size() >= list.size()) {
            throw new IllegalStateException("All objects in the list have been used.");
        }

        while (true) {
            personalDetailId = generateRandomKeyFromList(list);
            if (!generatedObjects.contains(personalDetailId)) {
                generatedObjects.add(personalDetailId);
                return personalDetailId;
            }
        }
    }

    /**
     * Randomly select an object array from the list. The elements in the
     * selected object array must have a unique constraint. All the used
     * constraint are passed in as a set. the constraint of newly selected array
     * will be added to the given constraint set after the selection.
     *
     * @param constraintArrays - The constraint set.
     * @param arrays - The list from witch the object array is selected.
     * @return - The selected object array.
     */
    public Object[] generateUniqueObjectArrayFromList(Set<ConstraintArray> constraintArrays, List<?>... arrays) {

        int size = arrays.length;

        if (size == 0) {
            throw new IllegalArgumentException("No object lists have been provided.");
        }

        int totalSize = arrays[0].size();

        for (int i = 1; i < size; i++) {
            totalSize = totalSize * arrays[i].size();
        }

        if (constraintArrays.size() >= totalSize) {
            throw new IllegalStateException("All objects in the lists have been used.");
        }

        Object[] objs = new Object[size];

        while (true) {

            for (int i = 0; i < size; i++) {
                objs[i] = generateRandomKeyFromList(arrays[i]);
            }

            ConstraintArray constraintArray = new ConstraintArray(objs);
            if (!constraintArrays.contains(constraintArray)) {
                constraintArrays.add(constraintArray);
                return objs;
            }
        }
    }

    /**
     * Generate a set of keys from the existing set.
     *
     * @param <T> - The type of the keys.
     * @param size - The generated key set size.
     * @param seeds - The existing set.
     * @return the generated key set.
     */
    public <T> List<T> generateRandomKeysFromList(int size, List<T> seeds) {

        List<T> list = new ArrayList<>();

        if (size > seeds.size()) {
            throw new IllegalArgumentException();
        }

        while (list.size() < size) {

            T key = generateRandomKeyFromList(seeds);

            if (!list.contains(key)) {
                list.add(key);
            }
        }

        return list;
    }

    /**
     * Generate a integer key set randomly in the specified ranges. If not
     * enough keys can be generated using the specified parameters, an empty set
     * will be returned.
     *
     * @param min - The smallest possible key.
     * @param max - The largest possible key.
     * @param size - The key set size.
     * @return the key set.
     */
    public Set<Integer> generateRandomKeySet(int min, int max, int size) {

        Set<Integer> set = new HashSet<>();

        if (min > max || max - min + 1 < size) {
            return set;
        }

        if (3 * (max - min + 1) > 5 * size) {
            addKeysToSet(set, size, max, min);
        } else {
            set = generateRandomKeySet(min, max, 1);
            removeKeysFromSet(set, size, max, min);
        }
        return set;
    }

    private void addKeysToSet(Set<Integer> set, int size, int max, int min) {
        while (set.size() < size) {
            int key = min + random.nextInt(max - min + 1);
            if (key >= min) {
                set.add(key);
            }
        }
    }

    private void removeKeysFromSet(Set<Integer> set, int size, int max, int min) {

        while (set.size() > size) {
            int key = min + random.nextInt(max - min + 1);
            set.remove(key);
        }
    }

    public int generateRandomKey() {
        return random.nextInt(999999);
    }

    @Override
    public int hashCode() {
        int hash = 914117;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

    @Override
    public String toString() {
        return "KeyGenerator{hashCode=" + hashCode() + "}";
    }
}
