package org.spring.demo.test;

import static org.junit.Assert.assertNotNull;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.dao.EmployeeDAO;
import org.arpit.java2blog.entity.DepartmentEntity;
import org.arpit.java2blog.entity.EmployeeEntity;
import org.arpit.java2blog.service.EmployeeService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;

@ContextConfiguration(locations = {"file:WebContent/WEB-INF/springrest-servlet.xml"})
@WebAppConfiguration
public class TestEmployeeWithMock extends AbstractTestNGSpringContextTests{

	@InjectMocks
	EmployeeService empService;
	
	@Mock
	EmployeeDAO empDAO;
	
	@BeforeTest
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testInsertData() {
		Employee emp = new Employee();
		emp.setFirstName("John");
		emp.setLastName("B");
		
		//EmployeeEntity empEn = mock(EmployeeEntity.class);
		//when(empDAO.insertEmployeesAndAddress(empEn)).thenReturn(1003);
		
		//Mocking behaviour
		when(empDAO.insertEmployeesAndAddress(any(EmployeeEntity.class))).thenReturn(1003);
		
		
		Integer id = empService.addEmployee(emp);
		System.out.println("In insertTest :: id ::"+id);
		assertNotNull(id);
	}
	
	@Test
	public void testUpdateData() {
		Employee emp = new Employee();
		emp.setEmpId(1002);
		emp.setFirstName("John");
		emp.setLastName("Rey");
		
		EmployeeEntity empEn = new EmployeeEntity();
		empEn.setEmpId(1002);
		empEn.setFirstName("Minnie");
		empEn.setLastName("Mouse");
		//Mocking behaviour
		when(empDAO.getEmployeebyIdfromDB(emp.getEmpId())).thenReturn(empEn);
		when(empDAO.changeEmpAndAddress(any(EmployeeEntity.class))).thenReturn(1003);
		//when(empDAO.insertEmployeesAndAddress(empEn)).thenReturn(1003);
		
		
		Integer id = empService.editEmployee(emp);
		System.out.println("In updateTest :: id ::"+id);
		assertNotNull(id);
	}
	
	
	@Test
	public void testDeleteData() {
		Employee emp = new Employee();
		emp.setEmpId(1002);
		emp.setFirstName("Minnie");
		emp.setLastName("Mouse");
		
		EmployeeEntity empEn = new EmployeeEntity();
		empEn.setEmpId(1002);
		empEn.setFirstName("Minnie");
		empEn.setLastName("Mouse");
		empEn.setDepartments(new HashSet<DepartmentEntity>());
		//Mocking behaviour
		when(empDAO.getEmployeebyIdfromDB(emp.getEmpId())).thenReturn(empEn);
		//when(empDAO.insertEmployeesAndAddress(empEn)).thenReturn(1003);
		doNothing().when(empDAO).deleteEmployeesAndAddress(isA(EmployeeEntity.class));
		
		
		boolean deleted = empService.deleteEmployee(emp);
		System.out.println("In deleteTest end");
		assertTrue(deleted);
	}

	/*
	 * @Test public void testDeleteDataPartialMock() { Employee emp = new
	 * Employee(); emp.setEmpId(1002); emp.setFirstName("Minnie");
	 * emp.setLastName("Mouse");
	 * 
	 * EmployeeEntity empEn = new EmployeeEntity(); empEn.setEmpId(1002);
	 * empEn.setFirstName("Minnie"); empEn.setLastName("Mouse");
	 * empEn.setDepartments(new HashSet<DepartmentEntity>()); //Mocking behaviour //
	 * when(empDAO.getEmployeebyIdfromDB(emp.getEmpId())).thenReturn(empEn);
	 * doCallRealMethod().when(empDAO).getEmployeebyIdfromDB(emp.getEmpId());
	 * //when(empDAO.insertEmployeesAndAddress(empEn)).thenReturn(1003);
	 * doNothing().when(empDAO).deleteEmployeesAndAddress(isA(EmployeeEntity.class))
	 * ;
	 * 
	 * 
	 * boolean deleted = empService.deleteEmployee(emp);
	 * System.out.println("In deleteTest end"); assertTrue(deleted); }
	 */
}
