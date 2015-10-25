package com.connvertex.candor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author mahesh
 * 
 * Database Schema
 * 
 * CREATE TABLE PERSON(
   personID INT NOT NULL auto_increment, 
   firstName VARCHAR(50) NOT NULL,
   lastName VARCHAR(50) NOT NULL,
   middle_initial VARCHAR(1),
   birth_date DATE,
   ssn VARCHAR(30),
   addressID INT,
   PRIMARY KEY (personID));
 *
 */

@Entity
@Table(name="PERSON")
public class Person {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personID;
 
    @Size(min=3, max=50)
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
 
    @Size(min=3, max=50)
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
    
    @Size(min=0, max=1)
    @Column(name = "MIDDLE_INITIAL")
    private String middleInitial;
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "BIRTH_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birthDate;
 
    /*
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;*/
     
    @NotEmpty
    @Column(name = "SSN", unique=true, nullable = false)
    private String ssn;
    
    @Column(name = "ADDRESSID")
    private int addressID;
 
    public int getPersonID() {
        return personID;
    }
 
    public void setPersonID(int personID) {
        this.personID = personID;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }
 
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
 
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
 
    public String getSsn() {
        return ssn;
    }
 
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    public int getAddressID() {
        return addressID;
    }
 
    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
    
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + personID;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        if (personID != other.personID)
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Person [personID=" + personID + ", firstName=" + firstName + ", lastName=" + lastName + 
        		", middleInitial=" + middleInitial + ", birthDate=" + birthDate + ", ssn=" + ssn + 
        		", addressID=" + addressID + "]";
    }
     
}