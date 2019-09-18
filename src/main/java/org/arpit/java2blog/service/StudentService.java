package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.arpit.java2blog.bean.Department;
import org.arpit.java2blog.bean.Student;
import org.arpit.java2blog.dao.StudentDAO;
import org.arpit.java2blog.entity.FullTimeStudent;
import org.arpit.java2blog.entity.PartTimeStudent;
import org.arpit.java2blog.entity.SalesDepartment;
import org.arpit.java2blog.entity.SecurityDepartment;
import org.arpit.java2blog.entity.StudentEntity;
import org.arpit.java2blog.entity.StudentIdPK;
import org.arpit.java2blog.entity.XDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	@Autowired
	StudentDAO studentDAO;


	@Transactional
	public List<Student> getStudentsList(){
		System.out.println("In getStudentsList");
		List<StudentEntity> students = studentDAO.getStudents();
		System.out.println("Student List Size :: "+students.size());
		List<Student> studentsList = new ArrayList<>();

		for(StudentEntity student: students ) {
			Student stu = new Student();

			stu.setBranchId(student.getStudentIdPK().getBranchId());
			stu.setStudentId(student.getStudentIdPK().getStudentId());
			stu.setFirstName(student.getFirstName());
			stu.setLastName(student.getLastName());
			stu.setDob((java.util.Date)student.getDob());
			System.out.println(stu.toString());
			studentsList.add(stu);
		}

		return studentsList;
	}

	@Transactional
	public Student getStudentById(Student stu) {
		System.out.println("In StudentService :: getStudentById");
		StudentIdPK stuPK = new StudentIdPK();
		stuPK.setBranchId(stu.getBranchId());
		stuPK.setStudentId(stu.getStudentId());
		StudentEntity students = studentDAO.getStudentById(stuPK);
		//stu.setBranchId(students.getStudentIdPK().getBranchId());
		//stu.setStudentId(students.getStudentIdPK().getStudentId());
		stu.setFirstName(students.getFirstName());
		stu.setLastName(students.getLastName());
		stu.setDob(students.getDob());
		return stu;
	}

	@Transactional
	public String insertStudent(Student student){

		StudentEntity stu = new StudentEntity();
		stu.setStudentIdPK(new StudentIdPK(student.getBranchId(),student.getStudentId()));
		stu.setFirstName(student.getFirstName());
		stu.setLastName(student.getLastName());
		stu.setDob((Date)student.getDob());

		return studentDAO.insertStudent(stu);
	}
	@Transactional
	public String updateStudent(Student student){
		StudentIdPK stuPK = new StudentIdPK(student.getBranchId(),student.getStudentId());
		StudentEntity stu = studentDAO.getStudentById(stuPK);
		stu.setFirstName(student.getFirstName());
		stu.setLastName(student.getLastName());
		stu.setDob((Date)student.getDob());

		return studentDAO.updateStudent(stu);
	}

	@Transactional
	public String deleteStudent(Student student){
		StudentIdPK stuPK = new StudentIdPK(student.getBranchId(),student.getStudentId());
		StudentEntity stu = studentDAO.getStudentById(stuPK);
		stu.setFirstName(student.getFirstName());
		stu.setLastName(student.getLastName());
		stu.setDob((Date)student.getDob());

		return studentDAO.deleteStudent(stu);
	}


	@Transactional
	public List<Student> getFTStudentsList(){
		System.out.println("In getStudentsList");
		List<FullTimeStudent> students = studentDAO.getAllFTCollegeStudents();
		System.out.println("Student List Size :: "+students.size());
		List<Student> studentsList = new ArrayList<>();

		for(FullTimeStudent student: students ) {
			Student stu = new Student();

			stu.setStudentId(student.getStudentId());
			stu.setFirstName(student.getFirstName());
			stu.setLastName(student.getLastName());
			System.out.println(" getAttendance :: "+student.getAttendance());
			System.out.println(stu.toString());
			studentsList.add(stu);
		}

		return studentsList;
	}

	@Transactional
	public List<Student> getPTStudentsList(){
		System.out.println("In getStudentsList");
		List<PartTimeStudent> students = studentDAO.getAllPTCollegeStudents();
		System.out.println("Student List Size :: "+students.size());
		List<Student> studentsList = new ArrayList<>();

		for(PartTimeStudent student: students ) {
			Student stu = new Student();

			stu.setStudentId(student.getStudentId());
			stu.setFirstName(student.getFirstName());
			stu.setLastName(student.getLastName());
			System.out.println(" POW :: "+student.getPlaceOfWork());
			System.out.println(stu.toString());
			studentsList.add(stu);
		}

		return studentsList;
	}

	@Transactional
	public List<Student> getFPTStudentsList() {
		List<PartTimeStudent> ptstudents = studentDAO.getAllPTCollegeStudents();
		List<FullTimeStudent> ftstudents = studentDAO.getAllFTCollegeStudents();
		System.out.println("Student List Size :: "+ptstudents.size()+ftstudents.size());
		List<Student> studentsList = new ArrayList<>();

		for(PartTimeStudent student: ptstudents ) {
			Student stu = new Student();

			stu.setStudentId(student.getStudentId());
			stu.setFirstName(student.getFirstName());
			stu.setLastName(student.getLastName());
			stu.setDob(student.getDob());
			System.out.println(" POW :: "+student.getPlaceOfWork());
			System.out.println(stu.toString());
			studentsList.add(stu);
		}
		for(FullTimeStudent student: ftstudents ) {
			Student stu = new Student();

			stu.setStudentId(student.getStudentId());
			stu.setFirstName(student.getFirstName());
			stu.setLastName(student.getLastName());
			stu.setDob(student.getDob());
			System.out.println(" getAttendance :: "+student.getAttendance());
			System.out.println(stu.toString());
			studentsList.add(stu);
		}
		return studentsList;
	}

	@Transactional
	public List<Department> getSalesDept(){
		System.out.println("In getSalesDept");
		List<SalesDepartment> dept = studentDAO.getSalesDept();
		System.out.println("dept List Size :: "+dept.size());

		List<Department> dList = new ArrayList<Department>();
		for(SalesDepartment sd : dept) {
			Department d = new Department();
			d.setId(sd.getXdepartmentId());
			d.setDepartmentName(sd.getXdepartmentName());
			System.out.println(sd.getMonthlySales() + " Dept Type :: "+sd.getXdepartmentType());
			dList.add(d);
		}
		return dList;
	}
	@Transactional
	public List<Department> getSecurityDept(){
		System.out.println("In getSecurityDept");
		List<SecurityDepartment> dept = studentDAO.getSecurityDept();
		System.out.println("dept List Size :: "+dept.size());

		List<Department> dList = new ArrayList<Department>();
		for(SecurityDepartment sd : dept) {
			Department d = new Department();
			d.setId(sd.getXdepartmentId());
			d.setDepartmentName(sd.getXdepartmentName());
			System.out.println(sd.getSecurityBreechCount() + " Dept Type :: "+sd.getXdepartmentType());
			dList.add(d);
		}
		return dList;
	}
	@Transactional
	public List<Department> getAllXDept(){
		System.out.println("In getAllXDept");
		List<SecurityDepartment> secDept = studentDAO.getSecurityDept();
		List<SalesDepartment> salesDept = studentDAO.getSalesDept();
		System.out.println("dept List Size :: "+secDept.size()+salesDept.size());

		List<Department> dList = new ArrayList<Department>();
		for(SecurityDepartment sd : secDept) {
			Department d = new Department();
			d.setId(sd.getXdepartmentId());
			d.setDepartmentName(sd.getXdepartmentName());
			d.setDepartmentType(sd.getXdepartmentType());
			d.setSecurityBreech(sd.getSecurityBreechCount());
			dList.add(d);
		}
		for(SalesDepartment sd : salesDept) {
			Department d = new Department();
			d.setId(sd.getXdepartmentId());
			d.setDepartmentName(sd.getXdepartmentName());
			d.setDepartmentType(sd.getXdepartmentType());
			d.setMonthlySales(sd.getMonthlySales());
			dList.add(d);
		}
		return dList;
	}


	@Transactional
	public Department getXDepartmentById(int id) { 
		XDepartment xd = studentDAO.getXDeptById(id); 
		Department dept = new Department();
		if(xd.getXdepartmentType().equals("Sales")) { SalesDepartment sd =
				studentDAO.getSalesDeptById(id); dept.setId(id);
				dept.setDepartmentName(sd.getXdepartmentName());
				dept.setDepartmentType(sd.getXdepartmentType());
				dept.setMonthlySales(sd.getMonthlySales()); 
		}else if(xd.getXdepartmentType().equals("Security")) { 
			SecurityDepartment sd = studentDAO.getSecDeptById(id); dept.setId(id);
					dept.setDepartmentName(sd.getXdepartmentName());
					dept.setDepartmentType(sd.getXdepartmentType());
					dept.setSecurityBreech(sd.getSecurityBreechCount()); 
			} return dept; }


	/*
	 * @Transactional public Department getXDepartmentById(int id) { XDepartment xd
	 * = studentDAO.getXDeptById(id); Department dept = new Department();
	 * dept.setId(id); dept.setDepartmentName(xd.getXdepartmentName());
	 * dept.setDepartmentType(xd.getXdepartmentType()); return dept; }
	 */

	@Transactional
	public String insertXDept(Department dept) {
		String returnValue = null;
		if(dept.getDepartmentType().equals("Sales")) {
			SalesDepartment sd = new SalesDepartment();
			sd.setXdepartmentId(dept.getId());
			sd.setXdepartmentName(dept.getDepartmentName());
			sd.setXdepartmentType(dept.getDepartmentType());	
			sd.setMonthlySales(dept.getMonthlySales());
			returnValue = studentDAO.insertSalesDept(sd);
		}else if(dept.getDepartmentType().equals("Security")){
			SecurityDepartment sd = new SecurityDepartment();
			sd.setXdepartmentId(dept.getId());
			sd.setXdepartmentName(dept.getDepartmentName());
			sd.setXdepartmentType(dept.getDepartmentType());
			sd.setSecurityBreechCount(dept.getSecurityBreech());
			returnValue = studentDAO.insertSecDept(sd);
		}
		return returnValue;

	}
	@Transactional
	public String updateXDept(Department dept) {
		String returnValue = null;
		XDepartment xd = studentDAO.getXDeptById(dept.getId());
		if(xd.getXdepartmentType().equals("Sales")) {
			SalesDepartment sd = studentDAO.getSalesDeptById(dept.getId());
			sd.setXdepartmentName(dept.getDepartmentName());
			sd.setXdepartmentType(dept.getDepartmentType());	
			sd.setMonthlySales(dept.getMonthlySales());
			returnValue = studentDAO.updateSalesDept(sd);
		}else if(xd.getXdepartmentType().equals("Security")){
			SecurityDepartment sd = studentDAO.getSecDeptById(dept.getId());
			sd.setXdepartmentName(dept.getDepartmentName());
			sd.setXdepartmentType(dept.getDepartmentType());
			sd.setSecurityBreechCount(dept.getSecurityBreech());
			returnValue = studentDAO.updateSecDept(sd);
		}
		return returnValue;

	}
	@Transactional
	public String deleteXDept(Department dept) {
		System.out.println("In Student Service :: deleteXDept");
		XDepartment xd = studentDAO.getXDeptById(dept.getId());
		System.out.println("xd id :: "+xd.getXdepartmentId());
		return studentDAO.deleteXDept(xd);

	}

}
