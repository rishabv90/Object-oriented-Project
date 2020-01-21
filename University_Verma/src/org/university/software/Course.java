package org.university.software;

import org.university.people.Professor;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Student;

public class Course {
	
	private String name;
	private int courseNumber; 
	private Department department;  
	private ArrayList<Student> studentRoster;	
	private ArrayList<Integer> schedule;
	private ArrayList<String> schedule2;
	ArrayList<String> stringList;
	
	private Classroom cR;
	//new
	private Professor professor;
	
	public Course() {
		name = "x";
		courseNumber = 373;
		department= new Department();
		studentRoster = new ArrayList<Student>();
		schedule = new ArrayList<Integer>();
		schedule2 = new ArrayList<String>();
		setProfessor(new Professor());
		cR = new Classroom();
		stringList = new ArrayList<String>();
		
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
	}
	
	
	public ArrayList<Integer> getSchedule(){
		return schedule;
		
	}
	
	public void setCourseNumber(int aCourseNumber ) {
		courseNumber = aCourseNumber;
	}
	public Integer getCourseNumber() {
		return courseNumber;
	}
	
	public void addStudent(Student student){
		studentRoster.add(student);
	}
	
	public ArrayList<Student> getStudentRoster(){
		return studentRoster;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor aProfessor) {
		professor = aProfessor;
	}
	
	public void printSchedule() {//need to fix this
        ArrayList<Integer> cTimeList ;	
		String courseName = "";
		String weekVal="";
		char weekNum;
		char slotVal;
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	    cTimeList = this.getSchedule();
		courseName = this.getName();
		String dName="";
		String cName="";
		String cNumber="";
		String rName= this.getRoomAssigned().getRoomNumber();
		String time="";
		
		
			 for (int i = 0; i <= cTimeList.size()-1; i++) {		 
    			 //System.out.println(aCourse.getName() + " " + aCourse.getSchedule());
				 
    			 weekVal = String.valueOf(cTimeList.get(i));
				 weekNum = weekVal.charAt(0);
				 slotVal = weekVal.charAt(2);
				
				 
				 schedule2.add(weekVal+ " " + Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1] + " " + cR.getRoomNumber() );
				
			 }
			 
			 for (int i = 0; i <= schedule2.size()-1; i++) {//needs fixing.
					System.out.println(schedule2.get(i).substring(4));
					}
		}

	public Classroom getRoomAssigned() {
		return cR;
	}

	public void setRoomAssigned(Classroom cr) {
		cr.addCourse(this);
		this.cR = cr;
	}
	
	
}
