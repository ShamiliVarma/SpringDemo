package org.spring.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.service.EmployeeService;

@ContextConfiguration(locations = {"file:WebContent/WEB-INF/springrest-servlet.xml"})
@WebAppConfiguration
@Listeners(org.spring.demo.listener.Listener.class)
public class TestEmployee extends AbstractTestNGSpringContextTests{

	@Autowired
	EmployeeService empService;
	
	Employee emp = null;

	@Test
	public void addInt() {
		int a = 2;
		int b =2;

		assertEquals(a+b,4);
	}


	@Test
	public void getEmployeeTest() {
		Employee employee = empService.getEmployee(1001);
		assertEquals(employee.toString(), emp.toString());
	}
	@Test
	public void getEmployeeTestNE() {
		Employee employee = empService.getEmployee(1002);
		assertNotEquals(employee.toString(), emp.toString());
	}
	@Test(groups = {"fetchData"}, priority = 1)
	public void getEmployeeListTest() {
		System.out.println("In getEmployeeListTest with priority 1");
		List<Employee> employee = empService.getEmployeeList();
		assertEquals(employee.size(), 2);
	}
	@Test
	public void getEmployeeListTestNE() {
		List<Employee> employee = empService.getEmployeeList();
		assertNotEquals(employee.size(), 3);
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("TestEmployee :: Before Test");
		emp = new Employee();
		emp.setEmpId(1001);
		emp.setFirstName("Mickey");
		emp.setLastName("Mouse");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("TestEmployee :: After Test");
	}
	
	/*
	 * public void insertEmployeeTest() { empService.addEmployee(emp); }
	 */
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("TestEmployee :: Before Suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("TestEmployee :: After Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@BeforeGroups
	public void beforeGroups() {
		System.out.println("Before Groups");
	}
	@AfterGroups
	public void afterGroups() {
		System.out.println("After Groups");
	}
}
