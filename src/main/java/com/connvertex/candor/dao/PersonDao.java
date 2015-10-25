package com.connvertex.candor.dao;

import java.util.List;

import com.connvertex.candor.model.Person;
 
public interface PersonDao {
 
    Person findByPersonID(int id);
 
    void savePerson(Person person);
     
    void deletePersonBySsn(String ssn);
     
    List<Person> findAllPersons();
 
    Person findPersonBySsn(String ssn);
 
}