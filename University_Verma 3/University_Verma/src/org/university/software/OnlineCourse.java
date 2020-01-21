package org.university.software;
import java.io.Serializable;

import org.university.people.Student;

public class OnlineCourse extends Course implements Serializable{
	private Integer test;
	
	public OnlineCourse() {
		setTest(0);
	}
	
	public boolean availableTo(Student aStudent){//is this correct ??
		return testAvailableTo(aStudent);
	}
	
	public boolean testAvailableTo(Student aStudent) {
		int cUnits = 0;
		cUnits = aStudent.getCampusUnits();
		if (cUnits >= 6) { 
			//System.out.println("CHECK get campusunits method. ONLINE COURSE It is avaqilable to this student as studentROster<maxCOurseLimit");
			return true;
		}
		//System.out.println("ONLINE COURSE It is avaqilable to this student as studentROster<maxCOurseLimit");
		return false;
	}

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
	}

}
