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

import com.etlsolutions.examples.data.constant.KeyNames;
import com.etlsolutions.examples.data.constant.QueryNames;
import com.etlsolutions.examples.data.general.StringKeyValuePair;
import com.etlsolutions.examples.data.api.PersonTelephoneLink;
import com.etlsolutions.examples.data.api.Telephone;
import com.etlsolutions.examples.database.facade.BookshopFacade;
import com.etlsolutions.examples.database.hibernate.pojo.PersonTelephoneLinkPojo;
import com.etlsolutions.examples.database.hibernate.pojo.PersonalDetailPojo;
import com.etlsolutions.examples.database.hibernate.pojo.TelephonePojo;
import java.util.Set;

/**
 * The PersonTelephoneLinkProcessor class
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public final class PersonTelephoneLinkProcessor extends AbstractProcessor<PersonTelephoneLink> {

    private final PersonalDetailProcessor personalDetailProcessor;
    private final TelephoneProcessor telephoneProcessor;

    /**
     * Construct an object with the given facade object.
     *
     * @param facade
     */
    public PersonTelephoneLinkProcessor(BookshopFacade facade) {
        super(facade);
        personalDetailProcessor = new PersonalDetailProcessor(facade);
        telephoneProcessor = new TelephoneProcessor(facade);
    }

    @Override
    public PersonTelephoneLinkPojo retrieve(PersonTelephoneLink personTelephoneLink) {

        PersonalDetailPojo personalDetailPojo = personalDetailProcessor.retrieve(personTelephoneLink.getPersonalDetail());
        TelephonePojo telephonePojo = telephoneProcessor.retrieve(personTelephoneLink.getTelephone());

        if (personalDetailPojo == null || telephonePojo == null) {
            return null;
        }

        if (facade.retrieveList(QueryNames.SELECT_FROM_PERSON_TELEPHONE_LINK,
                new StringKeyValuePair(KeyNames.PERSONAL_TELEPHONE_LINK_PERSIONAL_DETAIL_ID, personalDetailPojo.getId()),
                new StringKeyValuePair(KeyNames.PERSONAL_TELEPHONE_LINK_TELEPHONE_ID, telephonePojo.getId())).isEmpty()) {
            return null;
        }

        return new PersonTelephoneLinkPojo(personalDetailPojo, telephonePojo);
    }

    @Override
    public PersonTelephoneLinkPojo save(PersonTelephoneLink personTelephoneLink) {

        PersonTelephoneLinkPojo linkPojo = retrieve(personTelephoneLink);

        if (linkPojo == null) {

            TelephonePojo telephonePojo = telephoneProcessor.save(personTelephoneLink.getTelephone());
            PersonalDetailPojo personalDetailPojo = personalDetailProcessor.save(personTelephoneLink.getPersonalDetail());

            Set<PersonalDetailPojo> personalDetails = telephonePojo.getPersonalDetails();
            personalDetails.add(personalDetailPojo);
            telephonePojo.setPersonalDetails(personalDetails);
            
            Set<Telephone> telephones = personalDetailPojo.getTelephones();
            telephones.add(telephonePojo);
            personalDetailPojo.setTelephones(telephones);
            
            facade.update(telephonePojo, personalDetailPojo);
            
            linkPojo = new PersonTelephoneLinkPojo(personalDetailPojo, telephonePojo);
        }

        return linkPojo;
    }
}
