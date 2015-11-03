package com.connvertex.candor.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.connvertex.candor.model.Address;
 
@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Integer, Address> implements AddressDao {
 
    public Address findByAddressID(int addressID) {
        return getByKey(addressID);
    }
 
    public void saveAddress(Address address) {
        persist(address);
    }
 
    @SuppressWarnings("unchecked")
    public List<Address> findAllAddress() {
        Criteria criteria = createEntityCriteria();
        return (List<Address>) criteria.list();
    }

	@Override
	public void deleteAddress(int addressID) {
		Query query = getSession().createSQLQuery("delete from Address where addressID = :addressID");
        query.setInteger("addressID", addressID);
        query.executeUpdate();
	}
}