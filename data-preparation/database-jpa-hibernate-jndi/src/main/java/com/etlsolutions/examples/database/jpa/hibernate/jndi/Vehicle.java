/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findByEtlVehicleid", query = "SELECT v FROM Vehicle v WHERE v.etlVehicleid = :etlVehicleid"),
    @NamedQuery(name = "Vehicle.findByEtlDateCreated", query = "SELECT v FROM Vehicle v WHERE v.etlDateCreated = :etlDateCreated"),
    @NamedQuery(name = "Vehicle.findByEtlDateUpdated", query = "SELECT v FROM Vehicle v WHERE v.etlDateUpdated = :etlDateUpdated"),
    @NamedQuery(name = "Vehicle.findByVehiclePurchaseDate", query = "SELECT v FROM Vehicle v WHERE v.vehiclePurchaseDate = :vehiclePurchaseDate"),
    @NamedQuery(name = "Vehicle.findByVehicleRegistrationDate", query = "SELECT v FROM Vehicle v WHERE v.vehicleRegistrationDate = :vehicleRegistrationDate"),
    @NamedQuery(name = "Vehicle.findByVehicleDeliveryDate", query = "SELECT v FROM Vehicle v WHERE v.vehicleDeliveryDate = :vehicleDeliveryDate"),
    @NamedQuery(name = "Vehicle.findByModelName", query = "SELECT v FROM Vehicle v WHERE v.modelName = :modelName"),
    @NamedQuery(name = "Vehicle.findByModelYear", query = "SELECT v FROM Vehicle v WHERE v.modelYear = :modelYear"),
    @NamedQuery(name = "Vehicle.findByVin", query = "SELECT v FROM Vehicle v WHERE v.vin = :vin"),
    @NamedQuery(name = "Vehicle.findByVehicleUniqueId", query = "SELECT v FROM Vehicle v WHERE v.vehicleUniqueId = :vehicleUniqueId"),
    @NamedQuery(name = "Vehicle.findByRegistrationNumber", query = "SELECT v FROM Vehicle v WHERE v.registrationNumber = :registrationNumber"),
    @NamedQuery(name = "Vehicle.findByOwnershipCycle", query = "SELECT v FROM Vehicle v WHERE v.ownershipCycle = :ownershipCycle")})
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "etl_vehicleid")
    private String etlVehicleid;
    @Basic(optional = false)
    @Column(name = "etl_date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etlDateCreated;
    @Basic(optional = false)
    @Column(name = "etl_date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etlDateUpdated;
    @Column(name = "vehicle_purchase_date")
    @Temporal(TemporalType.DATE)
    private Date vehiclePurchaseDate;
    @Column(name = "vehicle_registration_date")
    @Temporal(TemporalType.DATE)
    private Date vehicleRegistrationDate;
    @Column(name = "vehicle_delivery_date")
    @Temporal(TemporalType.DATE)
    private Date vehicleDeliveryDate;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "model_year")
    private String modelYear;
    @Column(name = "vin")
    private String vin;
    @Column(name = "vehicle_unique_id")
    private String vehicleUniqueId;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "ownership_cycle")
    private String ownershipCycle;

    public Vehicle() {
    }

    public Vehicle(String etlVehicleid) {
        this.etlVehicleid = etlVehicleid;
    }

    public Vehicle(String etlVehicleid, Date etlDateCreated, Date etlDateUpdated) {
        this.etlVehicleid = etlVehicleid;
        this.etlDateCreated = etlDateCreated;
        this.etlDateUpdated = etlDateUpdated;
    }

    public String getEtlVehicleid() {
        return etlVehicleid;
    }

    public void setEtlVehicleid(String etlVehicleid) {
        this.etlVehicleid = etlVehicleid;
    }

    public Date getEtlDateCreated() {
        return etlDateCreated;
    }

    public void setEtlDateCreated(Date etlDateCreated) {
        this.etlDateCreated = etlDateCreated;
    }

    public Date getEtlDateUpdated() {
        return etlDateUpdated;
    }

    public void setEtlDateUpdated(Date etlDateUpdated) {
        this.etlDateUpdated = etlDateUpdated;
    }

    public Date getVehiclePurchaseDate() {
        return vehiclePurchaseDate;
    }

    public void setVehiclePurchaseDate(Date vehiclePurchaseDate) {
        this.vehiclePurchaseDate = vehiclePurchaseDate;
    }

    public Date getVehicleRegistrationDate() {
        return vehicleRegistrationDate;
    }

    public void setVehicleRegistrationDate(Date vehicleRegistrationDate) {
        this.vehicleRegistrationDate = vehicleRegistrationDate;
    }

    public Date getVehicleDeliveryDate() {
        return vehicleDeliveryDate;
    }

    public void setVehicleDeliveryDate(Date vehicleDeliveryDate) {
        this.vehicleDeliveryDate = vehicleDeliveryDate;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVehicleUniqueId() {
        return vehicleUniqueId;
    }

    public void setVehicleUniqueId(String vehicleUniqueId) {
        this.vehicleUniqueId = vehicleUniqueId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnershipCycle() {
        return ownershipCycle;
    }

    public void setOwnershipCycle(String ownershipCycle) {
        this.ownershipCycle = ownershipCycle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etlVehicleid != null ? etlVehicleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.etlVehicleid == null && other.etlVehicleid != null) || (this.etlVehicleid != null && !this.etlVehicleid.equals(other.etlVehicleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.Vehicle[ etlVehicleid=" + etlVehicleid + " ]";
    }
    
}
