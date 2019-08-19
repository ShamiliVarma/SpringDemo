package org.arpit.java2blog.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arpit.java2blog.bean.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {
	
	List<Employee> emplist = new ArrayList<Employee>();
	Map<Integer,Employee> empMap = new HashMap<Integer,Employee>();
	private static int idPrefix = 1010;  
	
	public EmployeeDAO() {
		
		empMap.put(1001, new Employee(1001,"Shamili", "T"));
		empMap.put(1002, new Employee(1002,"Asvi", "P"));
		empMap.put(1003, new Employee(1003,"Ivaan", "L"));
		empMap.put(1004, new Employee(1004,"Jessi", "G"));
		empMap.put(1005, new Employee(1005,"Mickey", "M"));
		
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
