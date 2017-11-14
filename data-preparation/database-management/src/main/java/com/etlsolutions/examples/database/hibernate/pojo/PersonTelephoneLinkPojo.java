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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.PersonTelephoneLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiablePersonTelephoneLink;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 * The PersonTelephoneLinkPojo class is a java bean which represents a link
 * between a person and a telephone.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class PersonTelephoneLinkPojo implements Serializable, IdentifiablePersonTelephoneLink {

    private static final long serialVersionUID = 700871680348865325L;

    private PersonalDetailPojo personalDetail;
    private TelephonePojo telephone;

    public PersonTelephoneLinkPojo() {
    }

    public PersonTelephoneLinkPojo(PersonalDetailPojo personalDetail, TelephonePojo telephone) {
        this.personalDetail = personalDetail;
        this.telephone = telephone;
    }

    @Override
    public int getPersonalDetailId() {
        return personalDetail == null ? 0 : personalDetail.getId();
    }

    @Override
    public int getTelephoneId() {
        return telephone == null ? 0 : telephone.getId();
    }

    @Override
    public PersonalDetailPojo getPersonalDetail() {
        return personalDetail;
    }

    @Override
    public TelephonePojo getTelephone() {
        return telephone;
    }

    @Override
    public boolean hasSameConstraint(PersonTelephoneLink link) {

        if (this == link) {
            return true;
        }

        if (link == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return link.hasSameConstraint(((PersonTelephoneLink) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (link instanceof HibernateProxy) {
            return hasSameConstraint(((PersonTelephoneLink) (((HibernateProxy) link).getHibernateLazyInitializer().getImplementation())));
        }

        return ConstrainableUtilities.hasSameConstraint(personalDetail, link.getPersonalDetail()) && ConstrainableUtilities.hasSameConstraint(telephone, link.getTelephone());
    }

    @Override
    public boolean hasSameParameters(PersonTelephoneLink link) {
        
        if (this == link) {
            return true;
        }

        if (link == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return link.hasSameParameters(((PersonTelephoneLink) ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()));
        }

        if (link instanceof HibernateProxy) {
            return hasSameParameters(((PersonTelephoneLink) (((HibernateProxy) link).getHibernateLazyInitializer().getImplementation())));
        }        
        
        return ConstrainableUtilities.hasSameParameters(personalDetail, link.getPersonalDetail()) && ConstrainableUtilities.hasSameParameters(telephone, link.getTelephone());
    }

    @Override
    public int hashCode() {

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }

        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.personalDetail);
        hash = 71 * hash + Objects.hashCode(this.telephone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if (obj instanceof HibernateProxy) {
            return equals(((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation());
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final PersonTelephoneLinkPojo other = (PersonTelephoneLinkPojo) obj;
        if (!Objects.equals(this.personalDetail, other.personalDetail)) {
            return false;
        }

        return Objects.equals(this.telephone, other.telephone);
    }
}
