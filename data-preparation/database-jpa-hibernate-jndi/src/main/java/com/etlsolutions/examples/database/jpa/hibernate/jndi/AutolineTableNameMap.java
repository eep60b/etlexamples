/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "autoline_table_name_map")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutolineTableNameMap.findAll", query = "SELECT a FROM AutolineTableNameMap a"),
    @NamedQuery(name = "AutolineTableNameMap.findById", query = "SELECT a FROM AutolineTableNameMap a WHERE a.id = :id"),
    @NamedQuery(name = "AutolineTableNameMap.findByModule", query = "SELECT a FROM AutolineTableNameMap a WHERE a.module = :module"),
    @NamedQuery(name = "AutolineTableNameMap.findByLongName", query = "SELECT a FROM AutolineTableNameMap a WHERE a.longName = :longName"),
    @NamedQuery(name = "AutolineTableNameMap.findByShortName", query = "SELECT a FROM AutolineTableNameMap a WHERE a.shortName = :shortName")})
public class AutolineTableNameMap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "module")
    private String module;
    @Column(name = "long_name")
    private String longName;
    @Column(name = "short_name")
    private String shortName;

    public AutolineTableNameMap() {
    }

    public AutolineTableNameMap(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutolineTableNameMap)) {
            return false;
        }
        AutolineTableNameMap other = (AutolineTableNameMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.AutolineTableNameMap[ id=" + id + " ]";
    }
    
}
