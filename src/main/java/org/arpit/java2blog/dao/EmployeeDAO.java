package org.arpit.java2blog.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.mapper.EmployeeMapper;
import org.arpit.java2blog.mapper.EmployeeResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {
	
	List<Employee> emplist = new ArrayList<Employee>();
	Map<Integer,Employee> empMap = new HashMap<Integer,Employee>();
	private static int idPrefix = 1010;  
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public EmployeeDAO() {
		//getAllEmployeesfromDB();
		empMap.put(1001, new Employee(1001,"Shamili", "T"));
		empMap.put(1002, new Employee(1002,"Asvi", "P"));
		empMap.put(1003, new Employee(1003,"Ivaan", "L"));
		empMap.put(1004, new Employee(1004,"Jessi", "G"));
		empMap.put(1005, new Employee(1005,"Mickey", "M"));
		
	}
	
	/*
	 * Methods to get hardcoded employee data which is set in constructor
	 */
	
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(empMap.values());
	}
	
	public Employee getEmployee(int id) {
		if(empMap.containsKey(id)) {
			return empMap.get(id);
		}else {
			return null;
		}
	}
	public int addEmployee(Employee emp) {
		int idForNewEmployee =  idPrefix++;
		emp.setEmpId(idForNewEmployee);
		empMap.put(idForNewEmployee, emp);
		return emp.getEmpId();
	}
	
	public int editEmployee(Employee emp) {
		empMap.put(emp.getEmpId(), emp);
		return emp.getEmpId();
	}
	
	public int deleteEmployee(Employee emp) {
		empMap.remove(emp.getEmpId());
		return emp.getEmpId();
		
	}
	
	/*
	 * Methods to get employee data from DB
	 */
	
	public List<Employee> getAllEmployeesfromDB() {
		String selectQuery = "SELECT * FROM EMPLOYEES";
		return jdbcTemplate.query(selectQuery, new EmployeeMapper());
	}
	
	/*
	 * public List<Employee> getAllEmployeesfromDBRS() { String selectQuery =
	 * "SELECT * FROM EMPLOYEES"; return jdbcTemplate.query(selectQuery, new
	 * EmployeeResultSet()); }
	 */

	public Employee getEmployeebyIdfromDB(int id) {
		String selectQuery = "SELECT * FROM EMPLOYEES WHERE ID="+id;
		return jdbcTemplate.query(selectQuery, new EmployeeResultSet());
		//return jdbcTemplate.queryForObject(selectQuery,new Object[] {id}, new EmployeeMapper());
	}
	
	public List<Employee> getEmpbyIdPrepStmnt(final int id) {
		String selectQuery = "SELECT * FROM EMPLOYEES WHERE ID=?";
		
		return jdbcTemplate.query(selectQuery
				,new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement arg0) throws SQLException {
						arg0.setInt(1, id);
						
					}
				}, new EmployeeMapper());
	}

	public int insertData(Employee emp) {
		int idForNewEmployee =  idPrefix++;
		emp.setEmpId(idForNewEmployee);
		String insertDataQuery = "Insert INTO Employees (id, first_name,last_name,email) values("+idForNewEmployee+",'"+emp.getFirstName()+"','"+emp.getLastName()+"','Minnie@gmail.com')";
		jdbcTemplate.update(insertDataQuery);
		return emp.getEmpId();
	}
	public int updateData(Employee emp) {
		String updateDataQuery ="UPDATE Employees SET first_name = '"+emp.getFirstName()+"',last_name='"+emp.getLastName()+"' WHERE ID = "+emp.getEmpId();
		jdbcTemplate.update(updateDataQuery);
		return emp.getEmpId();
	}
	public int deleteData(Employee emp) {
		String deleteDataQuery ="DELETE FROM Employees WHERE ID = "+emp.getEmpId();
		jdbcTemplate.update(deleteDataQuery);
		return emp.getEmpId();
	}
	
	/*
	 * Methods to get employee and address from DB
	 */
	
	public List<Employee> getAllEmployeesAndAddressfromDB() {
		String selectQuery = "SELECT Employee.id, Employee.first_name, Employee.last_name, address.county,"
				+ "address.city,address.state FROM EMPLOYEES Employee, EmployeeAddress address WHERE Employee.id=address.id";
		return jdbcTemplate.query(selectQuery, new EmployeeMapper());
	}
	
	public Employee getEmployeesAndAddressbyIdfromDB(int id) {
		String selectQuery = "SELECT Employee.id, Employee.first_name, Employee.last_name, address.county,"
				+ "address.city,address.state FROM EMPLOYEES Employee, EmployeeAddress address WHERE Employee.id=address.id AND Employee.id="+id;
		return jdbcTemplate.query(selectQuery, new EmployeeResultSet());
		
	}

	public int insertEmployeesAndAddress(Employee emp) {
		/*
		 * String insertDataQuery =
		 * "Insert INTO Employees (first_name,last_name,email) values('"+emp.
		 * getFirstName()+"','"+emp.getLastName()+"','"+emp.getFirstName()+
		 * "@gmail.com')"; emp.setEmpId(jdbcTemplate.update(insertDataQuery)); String
		 * insertAddressQuery =
		 * "Insert INTO EmployeeAddress (id,county,city,state) values("+emp.getEmpId()+
		 * ",'"+emp.getEmployeeAddress().getCounty()+"','"+emp.getEmployeeAddress().
		 * getCity()+"','"+emp.getEmployeeAddress().getState()+"')";
		 * jdbcTemplate.update(insertAddressQuery);
		 */
		
		int idForNewEmployee =  idPrefix++;
		emp.setEmpId(idForNewEmployee);
		String insertDataQuery ="Insert INTO Employees (id,first_name,last_name,email) values(?,?,?,?)";
		jdbcTemplate.update(insertDataQuery,emp.getEmpId(),emp.getFirstName(),emp.getLastName(),emp.getFirstName()+"@gmail.com"); 
		String insertAddressQuery ="Insert INTO EmployeeAddress (id, county, city, state) values(?,?,?,?)";
		jdbcTemplate.update(insertAddressQuery,emp.getEmpId(),emp.getEmployeeAddress().getCounty(),emp.getEmployeeAddress().getCity(),emp.getEmployeeAddress().getState());
		System.out.println("Inserted data into 2 tables with Id :: "+emp.getEmpId());
		 
		
		/*
		String insertDataQuery = "insert into Employees (first_name,last_name,email) values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		//execption :: PreparedStatementCallback; uncategorized SQLException for SQL [insert into Employees (first_name,last_name,email) values(?,?,?)]; SQL state [90026]; error code [90026]; Serialization failed, cause: "java.io.NotSerializableException: org.arpit.java2blog.dao.EmployeeDAO$2" [90026-196]; nested exception is org.h2.jdbc.JdbcSQLException: Serialization failed, cause: "java.io.NotSerializableException: org.arpit.java2blog.dao.EmployeeDAO$2" [90026-196]
		jdbcTemplate.update(insertDataQuery,
				new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement arg0) throws SQLException {
				arg0.setString(1, emp.getFirstName());
				arg0.setString(2, emp.getLastName());
				arg0.setString(3, emp.getFirstName()+"@gmail.com");

			}
		},
				keyHolder);
		
		System.out.println(keyHolder.getKey());
		
		String insertAddressQuery = "Insert INTO EmployeeAddress (id, county, city, state) values(?,?,?,?)";
		jdbcTemplate.update(insertAddressQuery,keyHolder.getKey(),emp.getEmployeeAddress().getCounty(),emp.getEmployeeAddress().getCity(),emp.getEmployeeAddress().getState());
		*/
		return emp.getEmpId();
	}
	public int updateEmployeesAndAddress(Employee emp) {
		String updateDataQuery ="UPDATE Employees SET first_name = ?,last_name=? WHERE ID = ? ";
		jdbcTemplate.update(updateDataQuery,emp.getFirstName(),emp.getLastName(),emp.getEmpId());
		String updateAddressQuery ="UPDATE EmployeeAddress SET county = ?,city=?, state=?  WHERE ID = ?";
		jdbcTemplate.update(updateAddressQuery,emp.getEmployeeAddress().getCounty(),emp.getEmployeeAddress().getCity(),emp.getEmployeeAddress().getState(),emp.getEmpId());
		return emp.getEmpId();
	}
	public int deleteEmployeesAndAddress(Employee emp) {
		String deleteDataQuery ="DELETE FROM EmployeeAddress WHERE ID = ?";
		jdbcTemplate.update(deleteDataQuery,emp.getEmpId());
		deleteDataQuery ="DELETE FROM Employees WHERE ID = ?";
		jdbcTemplate.update(deleteDataQuery,emp.getEmpId());
		return emp.getEmpId();
	}
	
}
