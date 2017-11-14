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
@Table(name = "view_adapter_properties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewAdapterProperties.findAll", query = "SELECT v FROM ViewAdapterProperties v"),
    @NamedQuery(name = "ViewAdapterProperties.findByAdapterId", query = "SELECT v FROM ViewAdapterProperties v WHERE v.adapterId = :adapterId"),
    @NamedQuery(name = "ViewAdapterProperties.findByAdapterClass", query = "SELECT v FROM ViewAdapterProperties v WHERE v.adapterClass = :adapterClass"),
    @NamedQuery(name = "ViewAdapterProperties.findByDescription", query = "SELECT v FROM ViewAdapterProperties v WHERE v.description = :description"),
    @NamedQuery(name = "ViewAdapterProperties.findByName", query = "SELECT v FROM ViewAdapterProperties v WHERE v.name = :name"),
    @NamedQuery(name = "ViewAdapterProperties.findByValue", query = "SELECT v FROM ViewAdapterProperties v WHERE v.value = :value")})
public class ViewAdapterProperties implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public ViewAdapterProperties() {
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
