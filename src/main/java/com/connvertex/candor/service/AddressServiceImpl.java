package com.connvertex.candor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.connvertex.candor.dao.AddressDao;
import com.connvertex.candor.model.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

   @Autowired
   private AddressDao dao;
    
   public Address findByAddressID(int id) {
       return dao.findByAddressID(id);
   }

   public void saveAddress(Address address) {
       dao.saveAddress(address);
   }

   /*
    * Since the method is running with Transaction, No need to call hibernate update explicitly.
    * Just fetch the entity from db and update it with proper values within transaction.
    * It will be updated in db once transaction ends. 
    */
   public void updateAddress(Address address) {
       Address entity = dao.findByAddressID(address.getAddressID());
       if(entity!=null){
           entity.setAddressLineOne(address.getAddressLineOne());
           entity.setAddressLineTwo(address.getAddressLineTwo());
           entity.setAddressLineThree(address.getAddressLineThree());
           entity.setCity(address.getCity());
           entity.setState(address.getState());
           entity.setZipCode(address.getZipCode());
       }
   }

   public void deleteAddress(int addressID) {
       dao.deleteAddress(addressID);
   }
    
   public List<Address> findAllAddress() {
       return dao.findAllAddress();
   }
    
}