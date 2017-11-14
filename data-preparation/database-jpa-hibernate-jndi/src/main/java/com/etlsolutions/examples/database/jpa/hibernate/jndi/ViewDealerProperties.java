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
@Table(name = "view_dealer_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewDealerProperties.findAll", query = "SELECT v FROM ViewDealerProperties v"),
    @NamedQuery(name = "ViewDealerProperties.findByDealer", query = "SELECT v FROM ViewDealerProperties v WHERE v.dealer = :dealer"),
    @NamedQuery(name = "ViewDealerProperties.findByEntryId", query = "SELECT v FROM ViewDealerProperties v WHERE v.entryId = :entryId"),
    @NamedQuery(name = "ViewDealerProperties.findByEntry", query = "SELECT v FROM ViewDealerProperties v WHERE v.entry = :entry"),
    @NamedQuery(name = "ViewDealerProperties.findBySystemTypeId", query = "SELECT v FROM ViewDealerProperties v WHERE v.systemTypeId = :systemTypeId"),
    @NamedQuery(name = "ViewDealerProperties.findByDmsGroup", query = "SELECT v FROM ViewDealerProperties v WHERE v.dmsGroup = :dmsGroup"),
    @NamedQuery(name = "ViewDealerProperties.findByDms", query = "SELECT v FROM ViewDealerProperties v WHERE v.dms = :dms"),
    @NamedQuery(name = "ViewDealerProperties.findByTransformId", query = "SELECT v FROM ViewDealerProperties v WHERE v.transformId = :transformId"),
    @NamedQuery(name = "ViewDealerProperties.findByTransform", query = "SELECT v FROM ViewDealerProperties v WHERE v.transform = :transform"),
    @NamedQuery(name = "ViewDealerProperties.findByAdapterId", query = "SELECT v FROM ViewDealerProperties v WHERE v.adapterId = :adapterId"),
    @NamedQuery(name = "ViewDealerProperties.findByAdapterClass", query = "SELECT v FROM ViewDealerProperties v WHERE v.adapterClass = :adapterClass"),
    @NamedQuery(name = "ViewDealerProperties.findByDescription", query = "SELECT v FROM ViewDealerProperties v WHERE v.description = :description"),
    @NamedQuery(name = "ViewDealerProperties.findByName", query = "SELECT v FROM ViewDealerProperties v WHERE v.name = :name"),
    @NamedQuery(name = "ViewDealerProperties.findByValue", query = "SELECT v FROM ViewDealerProperties v WHERE v.value = :value")})
public class ViewDealerProperties implements Serializable {
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
    @Column(name = "adapter_id")
    private Integer adapterId;
    @Column(name = "adapter_class")
    private String adapterClass;
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;

    public ViewDealerProperties() {
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

    public Integer getAdapterId() {
        return adapterId;
    }

    public void setAdapterId(Integer adapterId) {
        this.adapterId = adapterId;
    }

    public String getAdapterClass() {
        return adapterClass;
    }

    public void setAdapterClass(String adapterClass) {
        this.adapterClass = adapterClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
}
