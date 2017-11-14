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
@Table(name = "general_property_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralPropertyView.findAll", query = "SELECT g FROM GeneralPropertyView g"),
    @NamedQuery(name = "GeneralPropertyView.findByAdapterId", query = "SELECT g FROM GeneralPropertyView g WHERE g.adapterId = :adapterId"),
    @NamedQuery(name = "GeneralPropertyView.findByClassname", query = "SELECT g FROM GeneralPropertyView g WHERE g.classname = :classname"),
    @NamedQuery(name = "GeneralPropertyView.findByDescription", query = "SELECT g FROM GeneralPropertyView g WHERE g.description = :description"),
    @NamedQuery(name = "GeneralPropertyView.findByProperty", query = "SELECT g FROM GeneralPropertyView g WHERE g.property = :property"),
    @NamedQuery(name = "GeneralPropertyView.findByValue", query = "SELECT g FROM GeneralPropertyView g WHERE g.value = :value"),
    @NamedQuery(name = "GeneralPropertyView.findByPropertyDesc", query = "SELECT g FROM GeneralPropertyView g WHERE g.propertyDesc = :propertyDesc"),
    @NamedQuery(name = "GeneralPropertyView.findByType", query = "SELECT g FROM GeneralPropertyView g WHERE g.type = :type"),
    @NamedQuery(name = "GeneralPropertyView.findByTypeDesc", query = "SELECT g FROM GeneralPropertyView g WHERE g.typeDesc = :typeDesc")})
public class GeneralPropertyView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "adapter_id")
    private Integer adapterId;
    @Column(name = "classname")
    private String classname;
    @Column(name = "description")
    private String description;
    @Column(name = "property")
    private String property;
    @Column(name = "value")
    private String value;
    @Column(name = "property_desc")
    private String propertyDesc;
    @Column(name = "type")
    private String type;
    @Column(name = "type_desc")
    private String typeDesc;

    public GeneralPropertyView() {
    }

    public Integer getAdapterId() {
        return adapterId;
    }

    public void setAdapterId(Integer adapterId) {
        this.adapterId = adapterId;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPropertyDesc() {
        return propertyDesc;
    }

    public void setPropertyDesc(String propertyDesc) {
        this.propertyDesc = propertyDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
    
}
