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
		//Using Select Statement and Rowmapper
		//return empDAO.getAllEmployeesfromDB();
		//Using Select Statement and ResultSet
		//return empDAO.getAllEmployeesfromDBRS();
		return empDAO.getAllEmployeesAndAddressfromDB();
		
	}
	
	public Employee getEmployee(int id) {
		//return empDAO.getEmployeebyIdfromDB(id);
		//return empDAO.getEmpbyIdPrepStmnt(id);
		return empDAO.getEmployeesAndAddressbyIdfromDB(id);
	}
	
	public int addEmployee(Employee emp) {
		//return empDAO.insertData(emp);
		return empDAO.insertEmployeesAndAddress(emp);
	}

	
	public int editEmployee(Employee emp) {
		//return empDAO.updateData(emp);
		return empDAO.updateEmployeesAndAddress(emp);
	}

	
	public int deleteEmployee(Employee emp) {
		//return empDAO.deleteData(emp);
		return empDAO.deleteEmployeesAndAddress(emp);
	}


}
