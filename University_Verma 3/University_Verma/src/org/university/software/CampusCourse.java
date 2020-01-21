package org.university.software;
import java.io.Serializable;
import java.util.ArrayList;

import org.university.hardware.Classroom;
import org.university.people.Student;

public class CampusCourse extends Course implements Serializable {
	
	private Integer maxCourseLimit; //maxStudents
	private ArrayList<Integer> schedule;
	private Classroom classRoom;
	private String ccVAAl ;
	public String conflictMessage ;
	
	
	public CampusCourse() {
		setMaxCourseLimit(0);
		schedule = new ArrayList<Integer>();	
		classRoom = new Classroom();
		setCcVAAl("nothing");
		conflictMessage = "nothingsss";
		
	}
	
	public boolean scheduleDetect(CampusCourse cCourse) {
		setCcVAAl(getCcVAAl() + "schedule Detect");
		
		@SuppressWarnings("unused")
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		@SuppressWarnings("unused")
		String [] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		return testScheduleDetect(cCourse);
	}
	
	public boolean testScheduleDetect(CampusCourse cCourse) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test = cCourse.schedule;
		for (int i: test) {
			if (schedule.contains(i)) {
				return true;
			}
		}
		return false;
	}
	
	public String getConflict(CampusCourse cCourse) {
		setCcVAAl(getCcVAAl() + "getCOnflict");
		return testGetConflict(cCourse);
	}
	
	public String testGetConflict(CampusCourse cCourse) {
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		String [] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		String string = "nothing";
		int weekVal=0;
		int slotVal=0;
		@SuppressWarnings("unused")
		String [ ] week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		@SuppressWarnings("unused")
		String [] slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		
		
		for (int i: cCourse.schedule) {
			if (schedule.contains(i)) {
				weekVal = (i/100)-1;
				slotVal= (i%100)-1;
				string = Week[weekVal] + " " + Slot[slotVal] ;
			}
			return string;
		}
		return string;
	}
	

	public Integer getMaxCourseLimit() {
		return maxCourseLimit;
	}

	public void setMaxCourseLimit(Integer maxCourseLimit) {
		this.maxCourseLimit = maxCourseLimit;
	}
	
	/*
	public void printSchedule(){
		System.out.println("Campus course Print schedule");
	}*/

	public ArrayList<Integer> getSchedule() {
		return schedule;
	}

	public void setSchedule(Integer newTime) {
		schedule.add(newTime);
	}

	public Classroom getRoomAssigned() {
		return classRoom;
	}
	public void setRoomAssigned(Classroom aClassRoom) { //check
		classRoom = aClassRoom;
		aClassRoom.addCourse(this);
	}
	
	public boolean availableTo(Student aStudent) {
		return test(aStudent);
	}
	
	public boolean test(Student astudent) {
		String name1 = "nothing";
		if(studentRoster.size() < maxCourseLimit) {
			name1 = astudent.getName();
			conflictMessage = name1 + " can't add Campus Course "+this.getDepartment().getDepartmentName()+this.getCourseNumber()+" "+ this.getName() +". Because this Campus course has enough student.";
			//System.out.println("CAMPUS COURSE It is avaqilable to this student as studentROster<maxCOurseLimit");
			return true;
		}
		//System.out.println("CAMPUS COURSE NOT avaqilable to this student as studentROster>maxCOurseLimit");
		return false;
	}
	
	public void printSchedule(){
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		String [] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		int maxWeek=500;
		int minWeek=100;
		int maxSlot=6;
		int minSlot=0;
		String print = "nothing";
		@SuppressWarnings("unused")
		String print2 = "nothing";
		int timeSchedule = 0;
		String weekVal = "nothing";
		String slotVal = "nothing";
		
		for(int i = minWeek; i <=maxWeek;i=i+minWeek) {
			for(int j =minSlot;j <= maxSlot; j++) {
				timeSchedule=i+j;
				if (this.getSchedule().contains(timeSchedule)) {
					weekVal = Week[(i/100)-1];
					slotVal =  Slot[j-1];
					print = weekVal+" "+slotVal+" "+this.getRoomAssigned().getRoomNumber(); 
					System.out.println(print);
					break;
			}
		}
		
		
		}
	}

	public String getCcVAAl() {
		return ccVAAl;
	}

	public void setCcVAAl(String ccVAAl) {
		this.ccVAAl = ccVAAl;
	}
}