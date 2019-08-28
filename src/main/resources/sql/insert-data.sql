INSERT INTO Employees (id, first_name, last_name, email) values (1001, 'Mickey', 'Mouse', 'Mickey@gmail.com');
INSERT INTO Employees (id, first_name, last_name, email) values (1002, 'Minnie', 'Mouse', 'Minnie@gmail.com');

INSERT INTO EmployeeAddress (id,empid, county, city, state) values (1,1001, 'West County', 'St. Louis', 'MO');
INSERT INTO EmployeeAddress (id,empid, county, city, state) values (2,1002, 'North County', 'St. Louis', 'MO');

INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (101,'DEEP','123456',1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (102,'SHAMILI','123456',1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, ENABLED) VALUES (103,'MICKEY','123456',1);

INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (101,'ROLE_USER');
INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (102,'ROLE_USER');
INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (103,'ROLE_ADMIN');
INSERT INTO USER_ROLE (USER_ID, ROLE) VALUES (102,'ROLE_ADMIN');