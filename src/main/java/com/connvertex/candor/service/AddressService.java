package com.connvertex.candor.service;

import java.util.List;

import com.connvertex.candor.model.Address;
 
public interface AddressService {
 
    Address findByAddressID(int addressID);
     
    void saveAddress(Address address);
     
    void updateAddress(Address address);
     
    void deleteAddress(int addressID);
 
    List<Address> findAllAddress();
     
}