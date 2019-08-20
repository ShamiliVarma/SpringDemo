package org.arpit.java2blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.arpit.java2blog.bean.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("id"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		
		return employee;
	}

}
