package org.arpit.java2blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.arpit.java2blog.bean.EmployeeAddress;

@Entity
@Table(name = "Employees")
public class EmployeeEntity {

	@Id @GeneratedValue
	@Column(name = "id")
	private int empId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	public EmployeeEntity() {
		super();
	}
	
	public EmployeeEntity(int empId, String firstName, String lastName, String email) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/*
	 * public EmployeeAddress getEmployeeAddress() { return employeeAddress; }
	 * 
	 * public void setEmployeeAddress(EmployeeAddress employeeAddress) {
	 * this.employeeAddress = employeeAddress; }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
