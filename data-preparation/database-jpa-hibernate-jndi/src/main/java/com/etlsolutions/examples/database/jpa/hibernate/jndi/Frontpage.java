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
@Table(name = "frontpage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frontpage.findAll", query = "SELECT f FROM Frontpage f"),
    @NamedQuery(name = "Frontpage.findById", query = "SELECT f FROM Frontpage f WHERE f.id = :id"),
    @NamedQuery(name = "Frontpage.findByDealerid", query = "SELECT f FROM Frontpage f WHERE f.dealerid = :dealerid"),
    @NamedQuery(name = "Frontpage.findByProjectclassname", query = "SELECT f FROM Frontpage f WHERE f.projectclassname = :projectclassname"),
    @NamedQuery(name = "Frontpage.findByVendor", query = "SELECT f FROM Frontpage f WHERE f.vendor = :vendor"),
    @NamedQuery(name = "Frontpage.findByName", query = "SELECT f FROM Frontpage f WHERE f.name = :name"),
    @NamedQuery(name = "Frontpage.findByVersion", query = "SELECT f FROM Frontpage f WHERE f.version = :version"),
    @NamedQuery(name = "Frontpage.findByUsername", query = "SELECT f FROM Frontpage f WHERE f.username = :username"),
    @NamedQuery(name = "Frontpage.findByPassword", query = "SELECT f FROM Frontpage f WHERE f.password = :password"),
    @NamedQuery(name = "Frontpage.findByUrl", query = "SELECT f FROM Frontpage f WHERE f.url = :url")})
public class Frontpage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    private Integer id;
    @Column(name = "dealerid")
    private String dealerid;
    @Column(name = "projectclassname")
    private String projectclassname;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "name")
    private String name;
    @Column(name = "version")
    private String version;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "url")
    private String url;

    public Frontpage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDealerid() {
        return dealerid;
    }

    public void setDealerid(String dealerid) {
        this.dealerid = dealerid;
    }

    public String getProjectclassname() {
        return projectclassname;
    }

    public void setProjectclassname(String projectclassname) {
        this.projectclassname = projectclassname;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
