package org.university.people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

public class Professor extends Employee implements Serializable{
	
	private String name; 
	private ArrayList<String> schedule;
	private ArrayList<Course> courseList;
	private Department department;
	@SuppressWarnings("unused")
	private Course course;
	ArrayList<String> stringList;
	ArrayList<String> nameList;
	ArrayList<String> collisionList;
	private Double salary;
	private String profVal;
	
	
	public Professor() {
		name = null;
		setSchedule(new ArrayList<String>());
		setDepartment(new Department());
		courseList = new ArrayList<Course>();
		stringList = new ArrayList<String>();
		schedule = new ArrayList<String>();
		nameList = new ArrayList<String>();
		collisionList = new ArrayList<String>();
		salary=(double)0;
		profVal = "nothign";
		
	}
	
	public void raise(double raisePercent) {
		profVal += "adding salary";
		salary *= (1 + (0.01 * raisePercent)) ; 
	};
	
	public double earns() {
		profVal += "earns";
		return (salary/26);
	};
	
	public void addCourse(CampusCourse cCourse) {
		@SuppressWarnings("unused")
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		@SuppressWarnings("unused")
		String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		String print = "nothing";
		String ccName = "nothing";
		ccName = cCourse.getProfessor().getName();
		
		if(ccName != null && profVal != "x" && cCourse.getName()!= "rishab") { 
			print = "The professor "+ getName()+" cannot be assigned to this campus course because professor "+cCourse.getProfessor().getName()+" is already assigned to the course "+cCourse.getName()+".";
			profVal += "nullVal " + print;
			System.out.println(print);
		}else if(!detectConflict(cCourse)) {
			profVal += "addCourse cc ";
			cCourse.setProfessor(this);
			this.getCampusCourseList().add(cCourse);
		}
					
	}
	
	public void addCourse(OnlineCourse oCourse) {
		@SuppressWarnings("unused")
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		@SuppressWarnings("unused")
		String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		String print = "nothing";
		String ocName = "ntohing";
		ocName = oCourse.getProfessor().getName();
		
		if( ocName != null) {
			print = "The professor "+ getName()+" cannot be assigned to this online course because professor "+ocName+" is already assigned to the online course "+oCourse.getName()+".";
			profVal += "fail " + print;
			System.out.println(print);
		}else {
			profVal += "addCourse oc ";
			oCourse.setProfessor(this);
			this.getOnlineCourseList().add(oCourse);
		}
			
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
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double aSalary) {
		salary = aSalary;
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
		
		for (@SuppressWarnings("unused") String i: collisionList) {				
				System.out.println("There is a conflict between with a COurses !");
		}
		return false;
	}
	
	
	
	public void addCourse(Course aCourse) { //aCourse needs to make prof to this prof with an error check.
		
		if(aCourse.getProfessor().getName() == "1234") {
			ArrayList<Integer> cTimeList ;
			String courseName = "";
			String weekVal="";
			String dName="";
			String cName="";
			String cNumber="";
			@SuppressWarnings("unused")
			String rName= aCourse.getRoomAssigned().getRoomNumber();
			String time="";
			
			
			char weekNum;
			char slotVal;
			String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
			String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		    cTimeList = aCourse.getSchedule();
			courseName = aCourse.getName();
			String print = "nothing";
			
				 for (int i = 0; i <= cTimeList.size()-1; i++) {	
					 int u = 0;
	    			 weekVal = String.valueOf(cTimeList.get(i));
					 weekNum = weekVal.charAt(0);
					 slotVal = weekVal.charAt(2);
					 dName = aCourse.getDepartment().getDepartmentName();
					 time = Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1];
					 cNumber = String.valueOf(aCourse.getCourseNumber());
					 cName = dName +cNumber;
					
					 if(stringList.contains(weekVal)) {
						print = dName +cNumber+ " cannot be added to "+ name +"'s Schedule. "+ dName+cNumber +" conflicts with " +courseList.get(u).getDepartment().getDepartmentName()+ courseList.get(u).getCourseNumber() + " Conflicting time slot is " + time;
						profVal += "addCourse ac " + print;
						System.out.println(print);
						//collisionList.add(dName +cNumber+ " cannot be added to "+ name +"'s Schedule. "+ dName+cNumber +" conflicts with " +courseList.get(u).getDepartment().getDepartmentName()+ courseList.get(u).getCourseNumber() + " Conflicting time slot is " + time);
					 }
					 else {
					 schedule.add(weekVal+ " " + Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1] + " " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " " + courseName);
					 courseList.add(aCourse);
					 aCourse.setProfessor(this);
					 u=u+1;
					 }
					 
					 stringList.add(weekVal);
					 nameList.add(cName);
					 
					 
			}
				 
				Collections.sort(schedule);
				
		}
		else {
			System.out.println("The professor cannot be assigned to this course because professor "+ aCourse.getProfessor().getName() + " is already assigned to the course" + aCourse.getName()+".");
		}
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
		int numOnlineCourse = this.getOnlineCourseList().size();
		int timeSchedule = 0;
		ArrayList <CampusCourse> ccList = new ArrayList<CampusCourse>();
		ArrayList <OnlineCourse> ocList = new ArrayList<OnlineCourse>();
		ccList = this.getCampusCourseList();
		ocList = this.getOnlineCourseList();
		String print = "nothing";
		String print2 = "nothing";
		
		for(int i = minWeek; i <=maxWeek;i=i+minWeek) {
			for(int j =minSlot;j <= maxSlot; j++) {
				timeSchedule=i+j;
				for(CampusCourse cc : ccList) {
					if(cc.getSchedule().contains(timeSchedule)) {
						weekVal = Week[(i/100)-1];
						slotVal =  Slot[j-1];
						print=weekVal+" " +slotVal+" "+cc.getDepartment().getDepartmentName()+cc.getCourseNumber()+" "+cc.getName();
						profVal += "print SCH " + print;
						System.out.println(print);
					}
				}
			}
		}
		if(numOnlineCourse != 0) {
			for(OnlineCourse oc : ocList) {
				print2=oc.getCourseNumber()+ " "+oc.getName();
				profVal += "OCcourse printSCh " + print2;
				System.out.println(print2);
			}
		}
		
	}

	public String getProfVal() {
		return profVal;
	}

	public void setProfVal(String profVal) {
		this.profVal = profVal;
	}
	
	
}
