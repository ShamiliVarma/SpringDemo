package org.arpit.java2blog.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	public List<Employee> getAllEmployeesfromDB() {
		String selectQuery = "SELECT * FROM EMPLOYEES";
		return jdbcTemplate.query(selectQuery, new EmployeeMapper());
	}
	
	public Employee getEmployeebyIdfromDB(int id) {
		String selectQuery = "SELECT * FROM EMPLOYEES WHERE ID=?";
		return jdbcTemplate.queryForObject(selectQuery,new Object[] {id}, new EmployeeMapper());
	}
	
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
	
}
