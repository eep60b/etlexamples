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
@Table(name = "view_system_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewSystemProperties.findAll", query = "SELECT v FROM ViewSystemProperties v"),
    @NamedQuery(name = "ViewSystemProperties.findByDealer", query = "SELECT v FROM ViewSystemProperties v WHERE v.dealer = :dealer"),
    @NamedQuery(name = "ViewSystemProperties.findByEntryId", query = "SELECT v FROM ViewSystemProperties v WHERE v.entryId = :entryId"),
    @NamedQuery(name = "ViewSystemProperties.findByEntry", query = "SELECT v FROM ViewSystemProperties v WHERE v.entry = :entry"),
    @NamedQuery(name = "ViewSystemProperties.findBySystemTypeId", query = "SELECT v FROM ViewSystemProperties v WHERE v.systemTypeId = :systemTypeId"),
    @NamedQuery(name = "ViewSystemProperties.findByDmsGroup", query = "SELECT v FROM ViewSystemProperties v WHERE v.dmsGroup = :dmsGroup"),
    @NamedQuery(name = "ViewSystemProperties.findByDms", query = "SELECT v FROM ViewSystemProperties v WHERE v.dms = :dms"),
    @NamedQuery(name = "ViewSystemProperties.findByTransformId", query = "SELECT v FROM ViewSystemProperties v WHERE v.transformId = :transformId"),
    @NamedQuery(name = "ViewSystemProperties.findByTransform", query = "SELECT v FROM ViewSystemProperties v WHERE v.transform = :transform"),
    @NamedQuery(name = "ViewSystemProperties.findByName", query = "SELECT v FROM ViewSystemProperties v WHERE v.name = :name"),
    @NamedQuery(name = "ViewSystemProperties.findByValue", query = "SELECT v FROM ViewSystemProperties v WHERE v.value = :value"),
    @NamedQuery(name = "ViewSystemProperties.findByType", query = "SELECT v FROM ViewSystemProperties v WHERE v.type = :type")})
public class ViewSystemProperties implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "dealer")
    private String dealer;
    @Column(name = "entry_id")
    private Integer entryId;
    @Column(name = "entry")
    private Integer entry;
    @Column(name = "system_type_id")
    private Integer systemTypeId;
    @Column(name = "dms_group")
    private String dmsGroup;
    @Column(name = "dms")
    private String dms;
    @Column(name = "transform_id")
    private Integer transformId;
    @Column(name = "transform")
    private String transform;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;
    @Column(name = "type")
    private String type;

    public ViewSystemProperties() {
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public Integer getSystemTypeId() {
        return systemTypeId;
    }

    public void setSystemTypeId(Integer systemTypeId) {
        this.systemTypeId = systemTypeId;
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

    public Integer getTransformId() {
        return transformId;
    }

    public void setTransformId(Integer transformId) {
        this.transformId = transformId;
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
