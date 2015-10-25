package com.connvertex.candor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.connvertex.candor.dao.PersonDao;
import com.connvertex.candor.model.Person;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

   @Autowired
   private PersonDao dao;
    
   public Person findByPersonID(int id) {
       return dao.findByPersonID(id);
   }

   public void savePerson(Person person) {
       dao.savePerson(person);
   }

   /*
    * Since the method is running with Transaction, No need to call hibernate update explicitly.
    * Just fetch the entity from db and update it with proper values within transaction.
    * It will be updated in db once transaction ends. 
    */
   public void updatePerson(Person person) {
       Person entity = dao.findByPersonID(person.getPersonID());
       if(entity!=null){
           entity.setFirstName(person.getFirstName());
           entity.setMiddleInitial(person.getMiddleInitial());
           entity.setLastName(person.getLastName());
           entity.setBirthDate(person.getBirthDate());
           entity.setSsn(person.getSsn());
           entity.setAddressID(person.getAddressID());
       }
   }

   public void deletePersonBySsn(String ssn) {
       dao.deletePersonBySsn(ssn);
   }
    
   public List<Person> findAllPersons() {
       return dao.findAllPersons();
   }

   public Person findPersonBySsn(String ssn) {
       return dao.findPersonBySsn(ssn);
   }

   public boolean isPersonSsnUnique(Integer id, String ssn) {
       Person person = findPersonBySsn(ssn);
       return ( person == null || ((id != null) && (person.getPersonID() == id)));
   }
    
}