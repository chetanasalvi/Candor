package com.connvertex.candor.service.test;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.connvertex.candor.dao.PersonDaoImpl;
import com.connvertex.candor.model.Person;
import com.connvertex.candor.service.PersonServiceImpl;

public class EmployeeServiceImplTest {

  Logger logger = LoggerFactory.getLogger(EmployeeServiceImplTest.class);
  
  private static final int PERSON_ID = 10;
  private static final String FIRST_NAME = "John";
  private static final String MI = "H";
  private static final String LAST_NAME = "Smith";
  private static final LocalDate BIRTH_DATE = new LocalDate(2002,12,12);
  private static final String SSN_NUM = "123-45-6789";
  private static final int ADDRESS_ID = 10;
  
  @InjectMocks
  private PersonServiceImpl personServiceImpl;
  
  @Mock
  private PersonDaoImpl personDaoImpl;
  
  @BeforeMethod
  public void initMocks(){
        MockitoAnnotations.initMocks(this);        
  }
  
  @Test
  public void findEmployeeBySsn() {
	  
	  Person person = new Person();
	  person.setPersonID(PERSON_ID);
	  person.setFirstName(FIRST_NAME);
	  person.setMiddleInitial(MI);
	  person.setLastName(LAST_NAME);
	  person.setBirthDate(BIRTH_DATE);
	  person.setSsn(SSN_NUM);
	  person.setAddressID(ADDRESS_ID);
	  
	  personDaoImpl.savePerson(person);
	  
	  //test method call
	  personServiceImpl.findPersonBySsn(SSN_NUM);
	  
	  Assert.assertEquals(person.getSsn(),SSN_NUM);
	  
	  logger.debug(" <<<<<<<<<<<<<<<<<<<<<<<< I RAN >>>>>>>>>>>>>>>>>>>>>>>>>>>");

  }
  
}
