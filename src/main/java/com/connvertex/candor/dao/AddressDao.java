package com.connvertex.candor.dao;

import java.util.List;

import com.connvertex.candor.model.Address;
 
public interface AddressDao {
 
    Address findByAddressID(int addressID);
 
    void saveAddress(Address address);
     
    void deleteAddress(int addressID);
     
    List<Address> findAllAddress();
 
}