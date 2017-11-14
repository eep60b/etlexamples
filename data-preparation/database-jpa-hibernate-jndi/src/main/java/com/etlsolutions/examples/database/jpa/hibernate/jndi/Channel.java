/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "channel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Channel.findAll", query = "SELECT c FROM Channel c"),
    @NamedQuery(name = "Channel.findByChannelId", query = "SELECT c FROM Channel c WHERE c.channelId = :channelId"),
    @NamedQuery(name = "Channel.findByChannelName", query = "SELECT c FROM Channel c WHERE c.channelName = :channelName")})
public class Channel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "channel_id")
    private Integer channelId;
    @Column(name = "channel_name")
    private String channelName;
    @JoinTable(name = "channel_project", joinColumns = {
        @JoinColumn(name = "channel_id", referencedColumnName = "channel_id")}, inverseJoinColumns = {
        @JoinColumn(name = "transform_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Transform> transformList;

    public Channel() {
    }

    public Channel(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @XmlTransient
    public List<Transform> getTransformList() {
        return transformList;
    }

    public void setTransformList(List<Transform> transformList) {
        this.transformList = transformList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelId != null ? channelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channel)) {
            return false;
        }
        Channel other = (Channel) object;
        if ((this.channelId == null && other.channelId != null) || (this.channelId != null && !this.channelId.equals(other.channelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Channel[ channelId=" + channelId + " ]";
    }
    
}
