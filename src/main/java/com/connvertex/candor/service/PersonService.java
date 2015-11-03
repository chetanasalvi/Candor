package com.connvertex.candor.service;

import java.util.List;

import com.connvertex.candor.model.Person;
 
public interface PersonService {
 
    Person findByPersonID(int id);
     
    void savePerson(Person person);
     
    void updatePerson(Person person);
     
    void deletePersonBySsn(String ssn);
 
    List<Person> findAllPersons(); 
     
    Person findPersonBySsn(String ssn);
 
    boolean isPersonSsnUnique(Integer id, String ssn);
     
}