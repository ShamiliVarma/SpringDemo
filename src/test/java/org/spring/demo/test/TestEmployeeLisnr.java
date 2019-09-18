package org.spring.demo.test;

import static org.testng.Assert.assertEquals;

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

@ContextConfiguration(locations = {"file:WebContent/WEB-INF/springrest-servlet.xml"})
@WebAppConfiguration
@Listeners(org.spring.demo.listener.Listener.class)
public class TestEmployeeLisnr extends AbstractTestNGSpringContextTests{

	@Test
	public void addInt() {
		int a = 2;
		int b =2;

		assertEquals(a+b,4);
	}

	@Test
	public void addIntFail() {
		int a = 2;
		int b =2;

		assertEquals(a+b,5);
	}


	@BeforeTest
	public void beforeTest() {
		System.out.println("TestEmployeeLisnr :: Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("TestEmployeeLisnr :: After Test");
	}
	
	/*
	 * public void insertEmployeeTest() { empService.addEmployee(emp); }
	 */
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("TestEmployeeLisnr :: Before Suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("TestEmployeeLisnr :: After Suite");
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
