package org.university.hardware;

import java.util.ArrayList;
import java.util.Collections;

import org.university.software.Course;

public class Classroom {
	
	private String roomNumber;
	private ArrayList<String> schedule;
	private ArrayList<Course> courseList;
	ArrayList<String> stringList;
	
	public Classroom() {
		roomNumber = "";		
		courseList = new ArrayList<Course>();
		schedule = new ArrayList<String>();
		stringList = new ArrayList<String>();
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		
		this.roomNumber = roomNumber;
	}

	public ArrayList<String> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<String> schedule) {
		this.schedule = schedule;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	
	public void addCourse(Course aCourse){
		courseList.add(aCourse);
	}
	
	public void printSchedule() {
			String courseName = "";
			String weekVal="";
			ArrayList<Integer> cTimeList ;
			char weekNum;
			char slotVal;
			String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
			String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		    	
		
		for(Course i : courseList) {
			String time="";
			cTimeList = i.getSchedule();
			courseName = i.getName();
			
			 for (int j = 0; j <= cTimeList.size()-1; j++) {		 				 
    			 weekVal = String.valueOf(cTimeList.get(j));
				 weekNum = weekVal.charAt(0);
				 slotVal = weekVal.charAt(2);
				 time = Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1];
				 
				 if(stringList.contains(weekVal)) {
					 
					 System.out.println(i.getDepartment().getDepartmentName()+ i.getCourseNumber()+ " conflicts with "+ "PLACEHOLDER" + ". Conflicting time slot "+ time+ ". " +i.getDepartment().getDepartmentName()+ i.getCourseNumber()+" course cannot be added to "+ roomNumber+"'s Schedule." );
				 }else {
					 schedule.add(weekVal+ " " + Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1] + " " + i.getDepartment().getDepartmentName() + i.getCourseNumber() + " " + courseName );
				 }
				 stringList.add(weekVal);	 
			 	}
		}
		Collections.sort(schedule);
		
		for (int i = 0; i <= schedule.size()-1; i++) {//needs fixing.
			System.out.println(schedule.get(i).substring(4));
			}
	}
	
}
