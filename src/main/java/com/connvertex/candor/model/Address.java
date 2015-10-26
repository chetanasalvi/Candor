package com.connvertex.candor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author mahesh
 * 
 * Database Schema
 * 
 * CREATE TABLE ADDRESS(
   addressID INT NOT NULL auto_increment, 
   addressLineOne VARCHAR(50) NOT NULL,
   addressLineTwo VARCHAR(50),
   addressLineThree VARCHAR(50),
   city VARCHAR(50) NOT NULL,
   state VARCHAR(20) NOT NULL,
   zipCode VARCHAR(10) NOT NULL,
   status VARCHAR(10) NOT NULL,
   PRIMARY KEY (addressID));
 *
 */

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressID;
 
    @NotEmpty
    @Size(min=3, max=50)
    @Column(name = "addressLineOne", nullable = false)
    private String addressLineOne;
 
    @Size(min=3, max=50)
    @Column(name = "addressLineTwo")
    private String addressLineTwo;
    
    @Size(min=3, max=50)
    @Column(name = "addressLineThree")
    private String addressLineThree;
    
    @NotEmpty
    @Size(min=3, max=50)
    @Column(name = "city", nullable = false)
    private String city;
 
    @NotEmpty
    @Size(min=3, max=20)
    @Column(name = "state", nullable = false)
    private String state;
    
    @NotEmpty
    @Size(min=3, max=10)
    @Column(name = "zipCode", nullable = false)
    private String zipCode;
    
    @NotEmpty
    @Size(min=3, max=10)
    @Column(name = "status", nullable = false)
    private String status;
    
    public int getAddressID() {
        return addressID;
    }
 
    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
 
    public String getAddressLineOne() {
        return addressLineOne;
    }
 
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }
    
    public String getAddressLineTwo() {
        return addressLineTwo;
    }
 
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }
    
    public String getAddressLineThree() {
        return addressLineThree;
    }
 
    public void setAddressLineThree(String addressLineThree) {
        this.addressLineThree = addressLineThree;
    }
    
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
 
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
 
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
 
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + addressID;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
    	
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (!(obj instanceof Address))
            return false;
        
        Address other = (Address) obj;
        if (addressID != other.addressID)
            return false;

        return true;
    }
 
    @Override
    public String toString() {
        return "Address [addressID=" + addressID + ", addressLineOne=" + addressLineOne 
        		+ ", addressLineTwo=" + addressLineTwo + ", addressLineThree=" + addressLineThree 
                + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode 
                + ", status=" + status + "]";
    }
     
}