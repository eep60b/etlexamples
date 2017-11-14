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

import com.etlsolutions.examples.base.configuration.SystemConstants;
import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.specific.communication.AddressAdditionalInformation;
import com.etlsolutions.examples.data.specific.communication.AddressArea;
import com.etlsolutions.examples.data.specific.communication.AddressCity;
import com.etlsolutions.examples.data.specific.communication.AddressCountry;
import com.etlsolutions.examples.data.specific.communication.AddressEntity;
import com.etlsolutions.examples.data.specific.communication.AddressHouse;
import com.etlsolutions.examples.data.specific.communication.AddressPobox;
import com.etlsolutions.examples.data.specific.communication.AddressPostcode;
import com.etlsolutions.examples.data.specific.communication.AddressStreet;
import com.etlsolutions.examples.data.specific.communication.EmailAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * The AddressGenerator class generates
 *
 * @author Zhipeng Chang
 * @since 1.0.0
 * 
 * @version 1.0.0 - The UK address style.
 * @version 1.1.0 - Add generateUniqueAddress method.
 */
//TODO: test and javadoc
public final class AddressGenerator implements Generator {

    private static final int MAXIUM_POSTCODE_PREFIX_LENGTH = 2;

    private static final int MAXIUM_POSTCODE_FIRST_NUMBER = 100;

    private static final int MAXIUM_POSTCODE_SECOND_NUMBER = 10;

    private static final String WHITE_SPACE = " ";

    private static final int MAXIUM_HOUSE_NUMBER = 1000;

    private static final int POSTCODE_POSTFIX_LENGTH = 2;

    private static final List<String> ROAD_TYPE_NAME = Arrays.asList("avenue", "close", "drive", "road", "street", "way");
    
    private final RandomStringGenerator singleWordGenerator = new RandomStringGenerator();
    private final Random random = new Random();

    /**
     * Generate an object to present the postcode.
     * @return the generated AddressPostcode object.
     */
    public AddressPostcode generatePostcode() {
        
        StringBuilder builder = new StringBuilder();        
        String prefix = singleWordGenerator.generateString(MAXIUM_POSTCODE_PREFIX_LENGTH, SystemConstants.BASIC_26_CHARACTER_SET).toUpperCase();
        String postfix = singleWordGenerator.generateFixedLengthString(POSTCODE_POSTFIX_LENGTH, SystemConstants.BASIC_26_CHARACTER_SET).toUpperCase();
        builder.append(prefix);
        builder.append(random.nextInt(MAXIUM_POSTCODE_FIRST_NUMBER) + 1);
        builder.append(WHITE_SPACE);
        builder.append(random.nextInt(MAXIUM_POSTCODE_SECOND_NUMBER) + 1);
        builder.append(postfix);

        return new AddressPostcode(new String(builder));
    }

    /**
     * 
     * @return 
     */
    public AddressHouse generateHouseName() {
        return new AddressHouse(String.valueOf(random.nextInt(MAXIUM_HOUSE_NUMBER) + 1));
    }

    /**
     * 
     * @return 
     */
    public AddressPobox generateAddressPobx() {
        return null;
    }
    
    /**
     * 
     * @return 
     */
    public AddressStreet generateAddressStreet() {
        
        StringBuilder builder = new StringBuilder();
        builder.append(random.nextInt(MAXIUM_HOUSE_NUMBER) + 1).append(WHITE_SPACE);
        builder.append(new RandomStringGenerator().generateString(28, SystemConstants.BASIC_26_CHARACTER_SET)).append(WHITE_SPACE);
        builder.append(ROAD_TYPE_NAME.get(random.nextInt(ROAD_TYPE_NAME.size())));

        return new AddressStreet(new String(builder));
    }

    /**
     * 
     * @return 
     */
    public AddressAdditionalInformation generateAdditionalInformation() {
        
        StringBuilder builder = new StringBuilder();
        int limit = random.nextInt(20);
        for(int i = 0; i < limit; i++) {
            builder.append(singleWordGenerator.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET)).append(WHITE_SPACE);
        }
        builder.trimToSize();
        
        return new AddressAdditionalInformation(new String(builder));
    }

    /**
     * 
     * @return 
     */
    public AddressCity generateCity() {
        return new AddressCity(singleWordGenerator.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET));
    }

    /**
     * 
     * @return 
     */
    public AddressArea generateArea() {
        return new AddressArea(singleWordGenerator.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET));
    }

    public AddressCountry generateCountry() {
        return new AddressCountry(singleWordGenerator.generateString(20, SystemConstants.BASIC_26_CHARACTER_SET));
    }

    public EmailAddress generateEmailAddress() {
        return new EmailAddress(singleWordGenerator.generateString(10) +"@" + singleWordGenerator.generateString(10));
    }
 
   /**
     * Randomly generate an Address object to represent a unique address. All the used
     * constraint are passed in as a set. the constraint of new array
     * will be added to the set after the array is created.
     *
     * @param addresses - The constraint set.
     * @return - The generated object array.
     */
    public Address generateUniqueAddress(Set<Address> addresses) {

        while (true) {

            Address address = new AddressEntity(generateHouseName(), generateAddressStreet(), generateAdditionalInformation(), generateArea(), generateCity(), generateCountry(), generatePostcode());
            
            if (!addresses.contains(address)) {
                addresses.add(address);
                return address;
            }
        }
    }      
}
