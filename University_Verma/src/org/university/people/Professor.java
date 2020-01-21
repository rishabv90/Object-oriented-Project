package org.university.people;

import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.Department;
import org.university.software.Course;

public class Professor {
	
	private String name; 
	private ArrayList<String> schedule;
	private ArrayList<Course> courseList;
	private Department department;
	private Course course;
	ArrayList<String> stringList;
	
	public Professor() {
		name = "1234";
		setSchedule(new ArrayList<String>());
		setDepartment(new Department());
		courseList = new ArrayList<Course>();
		stringList = new ArrayList<String>();
		schedule = new ArrayList<String>();
		//course = new Course();
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<String> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<String> schedule) {
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean detectConflict(Course aCourse) {
		for(String i : schedule) { //needs to fix
			if(i == aCourse.getName()) {
            	return true;
            } 
		}
		return false;
	}
	
	public void addCourse(Course aCourse) { //aCourse needs to make prof to this prof with an error check.
		
		//System.out.println(aCourse.getProfessor().getName());
		
		if(aCourse.getProfessor().getName() == "1234") {
			ArrayList<Integer> cTimeList ;
			String courseName = "";
			String weekVal="";
			String dName="";
			String cName="";
			String cNumber="";
			String rName= aCourse.getRoomAssigned().getRoomNumber();
			String time="";
			
			char weekNum;
			char slotVal;
			String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
			String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		    cTimeList = aCourse.getSchedule();
			courseName = aCourse.getName();
			
				 for (int i = 0; i <= cTimeList.size()-1; i++) {	
					 
	    			 weekVal = String.valueOf(cTimeList.get(i));
					 weekNum = weekVal.charAt(0);
					 slotVal = weekVal.charAt(2);
					 dName = aCourse.getDepartment().getDepartmentName();
					 time = Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1];
					 cNumber = String.valueOf(aCourse.getCourseNumber());
					 
					 
					
					 if(stringList.contains(weekVal)) {
						 System.out.println(dName +cNumber+ " cannot be added to "+ name +"'s Schedule. "+ dName+cNumber +" conflicts with " + "PLACEHOLDER." + " Conflicting time slot is " + time );
					 }
					 else {
					 schedule.add(weekVal+ " " + Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1] + " " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " " + courseName);
					 courseList.add(aCourse);
					 aCourse.setProfessor(this);
					 }
					 
					 stringList.add(weekVal);
			}
				Collections.sort(schedule);
				
		}
		else {
			System.out.println("The professor cannot be assigned to this course because professor "+ aCourse.getProfessor().getName() + " is already assigned to the course" + aCourse.getName()+".");
		}
	}
	
	public void printSchedule() {//need to fix this
		for (int i = 0; i <= schedule.size()-1; i++) {
			  System.out.println(schedule.get(i));
			}
	}

	
}
