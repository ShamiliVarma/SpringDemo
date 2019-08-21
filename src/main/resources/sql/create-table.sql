CREATE TABLE Employees (
  id int(10) NOT NULL AUTO_INCREMENT,
  first_name varchar(20) NOT NULL,
  last_name varchar(15) NOT NULL,
  email varchar(100) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE EmployeeAddress (
  id int(10) NOT NULL,
  county varchar(30) NOT NULL,
  city varchar(30) NOT NULL,
  state varchar(30) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES Employees(id)
);
