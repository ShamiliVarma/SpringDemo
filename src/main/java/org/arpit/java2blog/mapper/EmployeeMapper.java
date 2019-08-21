package org.arpit.java2blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.bean.EmployeeAddress;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("id"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		EmployeeAddress empAddress = new EmployeeAddress();
		empAddress.setEmpId(employee.getEmpId());
		empAddress.setCounty(rs.getString("county"));
		empAddress.setCity(rs.getString("city"));
		empAddress.setState(rs.getString("state"));
		employee.setEmployeeAddress(empAddress);
		System.out.println(employee.getEmpId());
		return employee;
	}

}
