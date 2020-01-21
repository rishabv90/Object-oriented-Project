package org.university.hardware;
import org.university.software.CampusCourse;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Collections;


public class Classroom implements Serializable{
	
	private String roomNumber;
	private ArrayList<Integer> schedule;
	private ArrayList<CampusCourse> courseList;//only campus courses have classrooms
	@SuppressWarnings("unused")
	private ArrayList<String> stringList;
	private String classRoomVal; //NEVERAGAIN
	
	public Classroom() {
		roomNumber = "";		
		courseList = new ArrayList<CampusCourse>();
		schedule = new ArrayList<Integer>();
		stringList = new ArrayList<String>();
		setClassRoomVal("ntohing");
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		
		this.roomNumber = roomNumber;
	}

	public ArrayList<Integer> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Integer> aSchedule) {
		this.schedule = aSchedule;
	}

	public ArrayList<CampusCourse> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<CampusCourse> courseList) {
		this.courseList = courseList;
	}
	
	public void addCourse(CampusCourse aCourse){
		String print = "nothing";
		int cNum = 0;
		String dName = "nothing";
		String crVal = "test";
		
		for (CampusCourse c: courseList) {
			if (c.scheduleDetect(aCourse)) {
				cNum =aCourse.getCourseNumber();
				dName = aCourse.getDepartment().getDepartmentName();
				print = dName + cNum +" conflicts with "+c.getDepartment().getDepartmentName()+c.getCourseNumber()+". Conflicting time slot " + aCourse.getConflict(c)+". "+aCourse.getDepartment().getDepartmentName()+ aCourse.getCourseNumber()+" course cannot be added to "+roomNumber + "'s Schedule.";
				crVal += print;
				System.out.println(print);
				break;
			}
		}
		classRoomVal = crVal;
		courseList.add(aCourse);
	}
	
	public void printSchedule() {
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		String [] Slot = {"8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		String weekVal = "nothing";
		String slotVal = "nothing";
		int maxWeek=500;
		int minWeek=100;
		int maxSlot=6;
		int minSlot=0;
		int timeSchedule = 0;
		String print = "nothing";
		String crVal = "nothing";
		
		for(int i = minWeek; i <=maxWeek;i=i+minWeek) {
			for(int j =minSlot;j <= maxSlot; j++) {
				timeSchedule=i+j;
				for(CampusCourse cc : courseList) {
					if(cc.getSchedule().contains(timeSchedule)) {
						weekVal = Week[(i/100)-1];
						slotVal =  Slot[j-1];
						print = weekVal + " " + slotVal + " " + cc.getDepartment().getDepartmentName() +cc.getCourseNumber() + " " + cc.getName();
						crVal += print;
						System.out.println(print);
						break;
					}
				}
			}
		}
		classRoomVal = crVal;		
	}

	public String getClassRoomVal() {
		return classRoomVal;
	}

	public void setClassRoomVal(String classRoomVal) {
		this.classRoomVal = classRoomVal;
	}

	
	
	/*
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
					 continue;
					 
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
	}*/
	
}
