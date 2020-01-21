package org.university.people;

import java.io.Serializable;
import java.util.ArrayList;

import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

@SuppressWarnings("unused")
public abstract class Employee extends Person implements Serializable{
	
	private String empName;
	
	public Employee() {
		setEmpName("Person");
				
	}
		
	
	public abstract void raise(double percentage);
	public abstract double earns();


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
