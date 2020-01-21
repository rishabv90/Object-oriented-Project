package university;

import java.util.ArrayList;

public class Course {
	
	private String name;
	private int courseNumber; //is this an int
	private Department department; //is this correct? 
	private ArrayList<Student> studentRoster;	
	private ArrayList<Integer> schedule;
	
	
	public Course() {
		name = "x";
		courseNumber = 373;
		department= new Department();
		studentRoster = new ArrayList<Student>();
		schedule = new ArrayList<Integer>();
		//ArrayList<Integer> studentList = new ArrayList<Integer>(10);
	}
	
	public void setName(String aName ) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public Department getDepartment() {
		return department;	
	}
	public void setDepartment(Department aDepartment) {
		department = aDepartment;	
	}
	public void setSchedule(int aSchedule ) {
		schedule.add(aSchedule);
		//schedule.add(aSchedule);            need to append 
	}
	
	public ArrayList<Integer> getSchedule(){
		return schedule;
		
	}
	
	public void setCourseNumber(int aCourseNumber ) {
		courseNumber = aCourseNumber;
	}
	
	public void addStudent(Student student){
		studentRoster.add(student);
	}
	
	public ArrayList<Student> getStudentRoster(){
		return studentRoster;
		
	}
	
	
}
