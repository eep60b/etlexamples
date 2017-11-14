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
package com.etlsolutions.examples.ha.pojo;
// Generated 28-Nov-2015 11:36:09 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.data.api.Administrator;
import com.etlsolutions.examples.data.api.AdministratorRole;
import com.etlsolutions.examples.data.spi.AdministratorSpi;
import com.etlsolutions.examples.ha.control.QueryNames;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * The AdministratorPojo class is generated automatically then modified
 * manually.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0 - Generated by NetBeans.
 * @version 1.0.1 - Change the field name from "addressId" to "id".
 * @version 2.0.0 - Add named query "findAdministrators".
 * @version 3.0.0 - Add named native query "findAdministratorsNative".
 * @version 3.1.0 - Add equals and hashCode methods.
 */
@Entity
@Table(name = "administrator", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = "personal_detail_id"),
    @UniqueConstraint(columnNames = "username")}
)
@NamedQueries({
    @NamedQuery(name = QueryNames.findAdministrators, query = "from AdministratorPojo", readOnly = true)
})
@NamedNativeQueries({
    @NamedNativeQuery(name = QueryNames.findAdministratorsNative, query = "select * from administrator", resultClass = AdministratorPojo.class, readOnly = true)
})
public class AdministratorPojo implements Serializable, AdministratorSpi<PersonalDetailPojo> {

    private static final long serialVersionUID = 128795587919556287L;

    @Id
    @Column(name = "administrator_id", unique = true, nullable = false)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_detail_id", unique = true)
    private PersonalDetailPojo personalDetail;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "administrator_role", nullable = false, length = 10)
    private AdministratorRole role;
    
    @Column(name = "username", unique = true, nullable = false, length = 200)
    private String username;
    
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    /**
     * Construct a default object with no fields are initialised.
     */
    public AdministratorPojo() {
    }

    /**
     *
     * @param personalDetail
     * @param role
     * @param username
     * @param password
     */
    public AdministratorPojo(PersonalDetailPojo personalDetail, AdministratorRole role, String username, String password) {

        this.personalDetail = personalDetail;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public PersonalDetailPojo getPersonalDetail() {
        return this.personalDetail;
    }

    @Override
    public void setPersonalDetail(PersonalDetailPojo person) {
        this.personalDetail = person;
    }

    @Override
    public AdministratorRole getRole() {
        return this.role;
    }

    @Override
    public void setRole(AdministratorRole role) {
        this.role = role;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        //This code should be kept to show a method to compare the class. 
        //For Hibernate directly comparison of the class names is no good since 
        //its children should be considered as equals when their IDs are the same. 
        if (Hibernate.getClass(this) != Hibernate.getClass(obj)) {
            return false;
        }

        final AdministratorPojo other = (AdministratorPojo) obj;
        return this.getId() == other.getId();
    }

    @Override
    public boolean hasSameConstraint(Administrator constraintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasSameParameters(Administrator constraintable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
