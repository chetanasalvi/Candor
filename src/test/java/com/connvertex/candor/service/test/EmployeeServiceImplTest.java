package com.connvertex.candor.service.test;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.connvertex.candor.dao.EmployeeDaoImpl;
import com.connvertex.candor.model.Employee;
import com.connvertex.candor.service.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

  Logger logger = LoggerFactory.getLogger(EmployeeServiceImplTest.class);
  
  private static final int ID = 10;
  private static final String NAME = "John Smith";
  private static final LocalDate JOINING_DATE = new LocalDate(2002,12,12);
  private static final BigDecimal SALARY = new BigDecimal(2000.00);
  private static final String SSN_NUM = "123-45-6789";
  
  
  @InjectMocks
  private EmployeeServiceImpl employeeServiceImpl;
  
  @Mock
  private EmployeeDaoImpl employeeDaoImpl;
  
  @BeforeMethod
  public void initMocks(){
        MockitoAnnotations.initMocks(this);        
  }
  
  @Test
  public void findEmployeeBySsn() {
	  
	  Employee employee = new Employee();
	  employee.setId(ID);
	  employee.setName(NAME);
	  employee.setJoiningDate(JOINING_DATE);
	  employee.setSalary(SALARY);
	  employee.setSsn(SSN_NUM);
	  
	  employeeDaoImpl.saveEmployee(employee);
	  
	  //test method call
	  employeeServiceImpl.findEmployeeBySsn(SSN_NUM);
	  
	  Assert.assertEquals(employee.getSsn(),SSN_NUM);
	  
	  logger.debug(" <<<<<<<<<<<<<<<<<<<<<<<< I RAN >>>>>>>>>>>>>>>>>>>>>>>>>>>");

  }
  
}
