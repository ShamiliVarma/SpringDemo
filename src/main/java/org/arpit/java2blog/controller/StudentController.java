package org.arpit.java2blog.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.arpit.java2blog.bean.Department;
import org.arpit.java2blog.bean.Student;
import org.arpit.java2blog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	private static Logger log = Logger.getLogger(StudentController.class);
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getStudents(){
		System.out.println("In StudentController :: getStudents");
		return studentService.getStudentsList();
	}

	@RequestMapping(value = "/studentbyId", method = RequestMethod.GET)
	public Student getStudentById(@RequestBody Student stu){
		System.out.println("In StudentController :: getStudents");
		return studentService.getStudentById(stu);
	}
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String addStudent(@RequestBody Student stu){
		System.out.println("In StudentController :: addStudent");
		return studentService.insertStudent(stu);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	public String updateStudent(@RequestBody Student stu) {
		System.out.println("In StudentController :: updateStudent");
		return studentService.updateStudent(stu);
	}
	@RequestMapping(value = "/students", method = RequestMethod.DELETE)
	public String deleteStudent(@RequestBody Student stu) {
		System.out.println("In StudentController :: deleteStudent");
		return studentService.deleteStudent(stu);
	}
	
	
	//PartTime and FullTime Student
	
	@RequestMapping(value = "/ptstudents", method = RequestMethod.GET)
	public List<Student> getPTStudents(){
		System.out.println("In StudentController :: getPTStudents");
		return studentService.getPTStudentsList();
	}
	
	@RequestMapping(value = "/ftstudents", method = RequestMethod.GET)
	public List<Student> getFTStudents(){
		System.out.println("In StudentController :: getFTStudents");
		return studentService.getFTStudentsList();
	}
	
	@RequestMapping(value = "/fptstudents", method = RequestMethod.GET)
	public List<Student> getAllFPTStudents(){
		System.out.println("In StudentController :: getAllFPTStudents");
		return studentService.getFPTStudentsList();
	}
	
	//Sales & Security Department 
	
	@RequestMapping(value = "/salesdepartment", method = RequestMethod.GET)
	public List<Department> getSalesDept(){
		System.out.println("In StudentController :: getSalesDept");
		return studentService.getSalesDept();
	}
	
	@RequestMapping(value = "/securitydepartment", method = RequestMethod.GET)
	public List<Department> getSecDept(){
		System.out.println("In StudentController :: getSecDept");
		return studentService.getSecurityDept();
	}
	@RequestMapping(value = "/xdepartment", method = RequestMethod.GET)
	public List<Department> getXDept(){
		System.out.println("In StudentController :: getXDept");
		return studentService.getAllXDept();
	}
	@RequestMapping(value = "/xdepartment/{id}", method = RequestMethod.GET)
	public Department getXDeptById(@PathVariable int id){
		System.out.println("In StudentController :: getXDeptById");
		return studentService.getXDepartmentById(id);
	}
	@RequestMapping(value = "/xdepartment", method = RequestMethod.POST)
	public String addXDept(@RequestBody Department dept){
		System.out.println("In StudentController :: addXDept");
		return studentService.insertXDept(dept);
	}
	
	@RequestMapping(value = "/xdepartment", method = RequestMethod.PUT)
	public String updateXDept(@RequestBody Department dept) {
		System.out.println("In StudentController :: updateXDept");
		return studentService.updateXDept(dept);
	}
	@RequestMapping(value = "/xdepartment", method = RequestMethod.DELETE)
	public String deleteXDept(@RequestBody Department dept) {
		System.out.println("In StudentController :: deleteXDept");
		return studentService.deleteXDept(dept);
	}
}
