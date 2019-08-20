package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO empDAO;
	
	
	public List<Employee> getEmployeeList(){
		return empDAO.getAllEmployeesfromDB();		
	}
	
	public Employee getEmployee(int id) {
		return empDAO.getEmployeebyIdfromDB(id);
	}
	
	public int addEmployee(Employee emp) {
		return empDAO.insertData(emp);
	}

	
	public int editEmployee(Employee emp) {
		return empDAO.updateData(emp);
	}

	
	public int deleteEmployee(Employee emp) {
		return empDAO.deleteData(emp);
	}


}
