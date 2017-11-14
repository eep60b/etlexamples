/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "view_system_properties_short")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewSystemPropertiesShort.findAll", query = "SELECT v FROM ViewSystemPropertiesShort v"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByDealer", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.dealer = :dealer"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByEntry", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.entry = :entry"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByDmsGroup", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.dmsGroup = :dmsGroup"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByDms", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.dms = :dms"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByTransform", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.transform = :transform"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByName", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.name = :name"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByValue", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.value = :value"),
    @NamedQuery(name = "ViewSystemPropertiesShort.findByType", query = "SELECT v FROM ViewSystemPropertiesShort v WHERE v.type = :type")})
public class ViewSystemPropertiesShort implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "dealer")
    private String dealer;
    @Column(name = "entry")
    private Integer entry;
    @Column(name = "dms_group")
    private String dmsGroup;
    @Column(name = "dms")
    private String dms;
    @Column(name = "transform")
    private String transform;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;
    @Column(name = "type")
    private String type;

    public ViewSystemPropertiesShort() {
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public String getDmsGroup() {
        return dmsGroup;
    }

    public void setDmsGroup(String dmsGroup) {
        this.dmsGroup = dmsGroup;
    }

    public String getDms() {
        return dms;
    }

    public void setDms(String dms) {
        this.dms = dms;
    }

    public String getTransform() {
        return transform;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
