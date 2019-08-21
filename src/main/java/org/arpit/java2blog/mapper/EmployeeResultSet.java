package org.arpit.java2blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.bean.EmployeeAddress;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeResultSet implements ResultSetExtractor<Employee> {

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
		Employee employee = new Employee();
		//while(rs.next()) {
		if(rs.next()) {
			
			employee.setEmpId(rs.getInt("id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			EmployeeAddress empAddress = new EmployeeAddress();
			empAddress.setEmpId(employee.getEmpId());
			empAddress.setCounty(rs.getString("county"));
			empAddress.setCity(rs.getString("city"));
			empAddress.setState(rs.getString("state"));
			employee.setEmployeeAddress(empAddress);
			
			//empList.add(employee);
		}
		
		return employee;
	}

}
