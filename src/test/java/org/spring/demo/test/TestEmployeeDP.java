package org.spring.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.arpit.java2blog.bean.Employee;
import org.arpit.java2blog.entity.EmployeeEntity;
import org.arpit.java2blog.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"file:WebContent/WEB-INF/springrest-servlet.xml"})
@WebAppConfiguration
public class TestEmployeeDP extends AbstractTestNGSpringContextTests{

	@Autowired
	EmployeeService empService;
	
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { 2,2 }, { 1,3 } ,{ 4,0}};
	}
	
	@Test(dataProvider = "data-provider")
	public void addInt(int a, int b) {
		System.out.println("a :: "+a+";b :: "+b);
		assertEquals(a+b,4);
	}

	
	/*
	 * @Test(groups = {"fetchData"}, priority = 0)
	 * 
	 * @Parameters({"empId"}) public void getEmployeeTest(int empId) {
	 * System.out.println("In getEmployeeTest :: 0 Pri");
	 * System.out.println("empId :: "+empId); Employee employee =
	 * empService.getEmployee(empId); assertNotNull(employee); }
	 */

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("TestEmployeeDP :: Before Suite");
	}
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("TestEmployeeDP :: After Suite");
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
	
	
	//insert methods
	@Test
	public void insertDataTest() {
		Employee emp = new Employee();
		emp.setFirstName("John");
		emp.setLastName("B");
		Integer id = empService.addEmployee(emp);
		System.out.println("In insertTest :: id ::"+id);
		assertNotNull(id);
	}
	
	@Test
	public void updateDataTest() {
		Employee emp = new Employee();
		emp.setEmpId(1001);
		emp.setFirstName("Ben");
		emp.setLastName("Stroke");
		
		
		Integer id = empService.editEmployee(emp);
		System.out.println("In updateTest :: id ::"+id);
		assertNotNull(id);
	}
}
