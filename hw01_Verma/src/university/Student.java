package university;

import java.util.ArrayList;

public class Student {
	
	private String name; 
	private Department department; //check
	private ArrayList<Course> courseList;
	
	
	public Student() {
		name = "unknown";
		courseList = new ArrayList<Course>();
		department = new Department();
	}
	
	public String getName() {
		return name;	
	}
	
	public void setName(String aName ) {
		name = aName;
	}
	
	public void setDepartment(Department aDepartment ) { //Maybe? 
		department = aDepartment;
		//aDepartment.addStudent(this);
	}
	public Department getDepartment() { //Maybe
		return department;	
	}
	
	public void addCourse(Course aCourse){
		courseList.add(aCourse);
		aCourse.addStudent(this);
		//append aCourse to courseList
	}
		
	
}
