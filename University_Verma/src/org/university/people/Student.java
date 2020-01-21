package org.university.people;

import java.util.ArrayList;
import java.util.*;

import org.university.hardware.Department;
import org.university.software.Course;

public class Student {
	
	private String name; 
	private Department department; 
	private ArrayList<Course> courseList;
	
	ArrayList<String> stringList;
	ArrayList<String> stringList2;
	
	//new
	private ArrayList<String> schedule;
	private Integer unitsCompleted; 
	private Integer unitsNeeded;
	
	
	public Student() {
		name = "unknown";
		courseList = new ArrayList<Course>();
		department = new Department();
		schedule= new ArrayList<String>();
		unitsCompleted=0;
		unitsNeeded=0;
		stringList = new ArrayList<String>();
		stringList2 = new ArrayList<String>();
	}
	
	public String getName() {
		return name;	
	}
	
	public void setName(String aName ) {
		name = aName;
	}
	
	public void setDepartment(Department aDepartment ) { 
		department = aDepartment;
		
	}
	public Department getDepartment() { 
		return department;	
	}
		
	public void setCompletedUnits(Integer aUnitsCompleted) {
		unitsCompleted = aUnitsCompleted;		
	}
	
	public void setRequiredCredits(Integer aUnitsNeeded) {
		unitsNeeded = aUnitsNeeded;
	}
	
	public Integer requiredToGraduate() {
		return (unitsNeeded-unitsCompleted);		
	}
	
	public void addCourse(Course aCourse){//check!!!
		ArrayList<Integer> cTimeList ;
		
		String courseName = "";
		String weekVal="";
		char weekNum;
		char slotVal;
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
	    cTimeList = aCourse.getSchedule();
		courseName = aCourse.getName();
		
		String dName="";
		String cName="";
		String cNumber="";
		String rName= aCourse.getRoomAssigned().getRoomNumber();
		String time="";
		
		
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
				 aCourse.addStudent(this);
				 }
				 stringList.add(weekVal);
		}
			

			Collections.sort(schedule);
	}
		
	public Boolean detectConflict(Course aCourse) {
		
		for (int i = 0 ; i <= courseList.size()-1;i++ ) {
			if(courseList.get(i).getSchedule() == aCourse.getSchedule())
				//System.out.println("There is a conflict between " +  courseList.get(i).getName() + " and" + aCourse.getName() );
				//System.out.print(courseList.get(i).getName() + courseList.get(i).getSchedule() + "  == " + aCourse.getName());
				return true;
		}
		
		return false;
	}
	
	
	public void dropCourse(Course aCourse) {
		ArrayList<Integer> cTimeList ;
		String courseName = "";
		String weekVal="";
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
			 
			 stringList2.add(weekVal+ " " + Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1] + " " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " " + courseName);
			 
		 }		
		
		 
		 if(Collections.disjoint(schedule, stringList2)) {
			 System.out.println("The course " + aCourse.getName()+  " could not be dropped because " +this.getName()+ " is not enrolled in " + aCourse.getName());
		 }else {
			 schedule.removeAll(stringList2);
		 }
		 
		
	}
	
	public void printSchedule() {//need to fix this
		
		for (int i = 0; i <= schedule.size()-1; i++) {//needs fixing.
			System.out.println(schedule.get(i).substring(4));
			}
	}
	
	
}
