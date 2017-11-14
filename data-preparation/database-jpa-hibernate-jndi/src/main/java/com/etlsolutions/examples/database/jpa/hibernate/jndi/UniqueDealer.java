/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "unique_dealer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniqueDealer.findAll", query = "SELECT u FROM UniqueDealer u"),
    @NamedQuery(name = "UniqueDealer.findById", query = "SELECT u FROM UniqueDealer u WHERE u.id = :id")})
public class UniqueDealer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dealercode")
    private PartsDealerSched partsDealerSched;

    public UniqueDealer() {
    }

    public UniqueDealer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PartsDealerSched getPartsDealerSched() {
        return partsDealerSched;
    }

    public void setPartsDealerSched(PartsDealerSched partsDealerSched) {
        this.partsDealerSched = partsDealerSched;
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
        if (!(object instanceof UniqueDealer)) {
            return false;
        }
        UniqueDealer other = (UniqueDealer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.UniqueDealer[ id=" + id + " ]";
    }
    
}
