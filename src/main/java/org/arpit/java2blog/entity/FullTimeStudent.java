package org.arpit.java2blog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FULLTIMESTUDENTS")
public class FullTimeStudent extends CollegeStudentEntity{

	private int attendance;

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
}
