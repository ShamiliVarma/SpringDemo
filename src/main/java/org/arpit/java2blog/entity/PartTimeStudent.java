package org.arpit.java2blog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PARTTIMESTUDENTS")
public class PartTimeStudent extends CollegeStudentEntity{

	private String placeOfWork;

	public String getPlaceOfWork() {
		return placeOfWork;
	}

	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}

}
