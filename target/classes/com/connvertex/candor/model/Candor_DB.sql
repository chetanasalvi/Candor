DROP TABLE IF EXISTS ADDRESS;
   
CREATE TABLE ADDRESS(
   addressID INT NOT NULL auto_increment, 
   addressLineOne VARCHAR(50) NOT NULL,
   addressLineTwo VARCHAR(50),
   addressLineThree VARCHAR(50),
   city VARCHAR(50) NOT NULL,
   state VARCHAR(20) NOT NULL,
   zipCode VARCHAR(10) NOT NULL,
   status VARCHAR(10) NOT NULL,
   PRIMARY KEY (addressID));

DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON(
   personID INT NOT NULL auto_increment, 
   firstName VARCHAR(50) NOT NULL,
   lastName VARCHAR(50) NOT NULL,
   middle_initial VARCHAR(1),
   birth_date DATE,
   ssn VARCHAR(30),
   addressID INT,
   PRIMARY KEY (personID),
   CONSTRAINT fk_PersonAddress FOREIGN KEY (addressID)
   REFERENCES Address(addressID)
   );