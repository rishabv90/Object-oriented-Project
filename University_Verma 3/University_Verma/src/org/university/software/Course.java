package org.university.software;

import org.university.people.*;

import java.io.Serializable;
import java.util.ArrayList;


import org.university.hardware.Classroom;
import org.university.hardware.Department;

public abstract class Course implements Serializable{
	
	protected String name;
	protected int courseNumber; 
	protected Department department;  
	protected ArrayList<Person> studentRoster;	//changed from student to Person
	protected Professor professor;
	
	private String coureVal;
	protected Integer numCredits;
	private Classroom cR;
	public ArrayList<Integer> schedule;
	public abstract boolean availableTo(Student aStudent); 
	
	
	
	public Course() {
		name = "x";
		courseNumber = 513;
		department= new Department();
		studentRoster = new ArrayList<Person>();
		schedule = new ArrayList<Integer>();
		//schedule2 = new ArrayList<String>();
		setProfessor(new Professor());
		cR = new Classroom();
		numCredits = 0;		
		coureVal = "ntohing";
	}
	
	public void setCreditUnits(Integer aNumCredits ) {
		numCredits = aNumCredits;
	}
	
	public Integer getCreditUnits() {
		return numCredits;
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
	
	public void setCourseNumber(int aCourseNumber ) {
		courseNumber = aCourseNumber;
	}
	public Integer getCourseNumber() {
		return courseNumber;
	}
	
	/*public void addStudent(Student student){
		studentRoster.add(student);
	}*/
	
	public void addStudentToRoster(Person s) {
		studentRoster.add(s);
	}
	public void removeStudent(Person bad) {
		studentRoster.remove(bad);
	}
	
	public ArrayList<Person> getStudentRoster(){
		return studentRoster;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor aProfessor) {
		professor = aProfessor;
	}
	
//	public void setSchedule(int aSchedule ) {
//		schedule.add(aSchedule);
//	}
//
//
	public ArrayList<Integer> getSchedule(){
		return schedule;
	}
	
	/*
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
		}*/

	
	public Classroom getRoomAssigned() {
		return cR;
	}
/*
	public void setRoomAssigned(Classroom cr) {
		cr.addCourse(this);
		this.cR = cr;
	}
	public boolean scheduleDetect(Course cCheck) {
		for (int i: cCheck.schedule) {
			if (schedule.contains(i)) {
				return true;
			}
		}
		return false;
	}
	public String conflictDetect(Course cCheck) {
		String[] week = {"Mon","Tue","Wed","Thu","Fri"};
		String [] slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};		
		String t = null;
		for (int i: cCheck.schedule) {
			if (schedule.contains(i)) {
				t = week[i/100-1] + " " + slot[i % 100-1] + " ";
			}
		}
		return t;
	}
	
	*/



	public String getCoureVal() {
		return coureVal;
	}



	public void setCoureVal(String coureVal) {
		this.coureVal = coureVal;
	}
}
