package org.university.people;

import java.io.Serializable;
import java.util.*;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

public class Student extends Person implements Serializable{
	
	private String name; 
	private Department department; 
	private ArrayList<Course> courseList;
	//new
	private ArrayList<String> schedule;
	private Integer unitsCompleted; 
	private Integer unitsNeeded;
	private Integer campusUnits;
	private Integer tuitionFee;
	private Integer totalUnits;
	private String studentVal;
	public String conflictMessage1;
	public String conflictMessageDrop;
	public String conflictMessageStudent;
	public String conflictMessageOnline;
	
	public Student() {
		name = "unknown";
		setCourseList(new ArrayList<Course>());
		department = new Department();
		setSchedule(new ArrayList<String>());
		unitsCompleted=0;
		unitsNeeded=0;
		setTuitionFee(0);
		campusUnits=0;
		totalUnits = 0;
		setStudentVal("nothign");
		conflictMessage1 = "nothing Person";
		conflictMessageDrop = "drop for cc";
		conflictMessageStudent = "conflictMessageStudent";
		conflictMessageOnline = "conflictMessageOnline";
		
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
		int ret = unitsNeeded-unitsCompleted-campusUnits;
		return (ret);		
	}
	public Integer getRequiredCredits() {
		return unitsNeeded;
	}
	
	public void addCourse(CampusCourse cCourse) {
		@SuppressWarnings("unused")
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		@SuppressWarnings("unused")
		String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		
		testAddCourse1(cCourse);
		
	}
	
	public void testAddCourse1(CampusCourse cCourse) {
		String print = "nothing***";
		if(!cCourse.availableTo(this)) { 
			print = name + " can't add Campus Course "+cCourse.getDepartment().getDepartmentName()+cCourse.getCourseNumber()+" "+cCourse.getName()+". Because this Campus course has enough student.";
			studentVal += print;
			conflictMessageStudent = print;
			System.out.println(print);
		}
		else if(!detectConflict(cCourse)) {
			campusUnits += cCourse.getCreditUnits();
			totalUnits = campusUnits + cCourse.getCreditUnits();
			
			cCourse.addStudentToRoster(this);
			this.getCampusCourseList().add(cCourse);
		}
	}
	
	
	public void addCourse(OnlineCourse oCourse) {
		@SuppressWarnings("unused")
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		@SuppressWarnings("unused")
		String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		testAddCourse2( oCourse);
		
	}
	public void testAddCourse2(OnlineCourse oCourse) {
		String print1 = "";
		String print2 = "";

		int cUnits=0;
		for (CampusCourse i : this.getCampusCourseList()) {
			cUnits += i.getCreditUnits();			
		}
		if(cUnits<6) {
			print1 = "Student " + name + " has only "+campusUnits+" on campus credits enrolled. Should have at least 6 credits registered before registering online courses. ";
			System.out.println(print1);
			print2 = this.getName()+" can't add online Course "+oCourse.getDepartment().getDepartmentName()+oCourse.getCourseNumber()+" "+oCourse.getName()+ ". Because this student doesn't have enough Campus course credit. ";
			System.out.println(print2);
			conflictMessageOnline = print1+print2;
			studentVal += print1+print2;
		}else if(cUnits>=6) {
			totalUnits += oCourse.getCreditUnits();
			this.getOnlineCourseList().add(oCourse);
			oCourse.addStudentToRoster(this);
		}
	}
	
	
	public void dropCourse(CampusCourse cCourse) {
		testDropCourse(cCourse);
		
	}
	public void testDropCourse(CampusCourse cCourse) {
		int creditsAfterMinus = 0;
		int onlineCredits = 0;
		int currentCredits =0;
		onlineCredits=onlineCredits+1;//nullVal
		String print1 = "";
		
		for(CampusCourse i : this.getCampusCourseList()) { //to get current credits
			currentCredits += i.getCreditUnits();
		}
		
		creditsAfterMinus = currentCredits - cCourse.getCreditUnits();
		
		if((this.getCampusCourseList().contains(cCourse)==true) && (creditsAfterMinus<6 && this.getOnlineCourseList().size()!=0)) {
			print1 = this.getName()+" can't drop this CampusCourse, because this student doesn't have enough campus course credit to hold the online course"+'\n';
			conflictMessageDrop = print1;
			System.out.print(print1);
		}else if(!(this.getCampusCourseList().contains(cCourse))) {//course not in course List
			studentVal += "Contains course drop";
			print1 = "The course "+cCourse.getDepartment().getDepartmentName()+cCourse.getCourseNumber()+" could not be dropped because "+this.getName()+" is not enrolled in "+cCourse.getDepartment().getDepartmentName()+cCourse.getCourseNumber()+ ".";
			System.out.println(print1);
			conflictMessageDrop = print1;
		}else {//drop
			totalUnits -= cCourse.getCreditUnits();
			campusUnits -= cCourse.getCreditUnits();
			this.getCampusCourseList().remove(cCourse);
			cCourse.removeStudent(this);
			conflictMessageDrop = "You have successfully drop the course " + cCourse.getDepartment().getDepartmentName() + cCourse.getCourseNumber()+ " " + cCourse.getName();
		}
	}
	
	
	
	public void dropCourse(OnlineCourse oCourse) {
		@SuppressWarnings("unused")
		String [ ] Week = { "Mon" , "Tue", "Wed", "Thu", "Fri" } ;
		@SuppressWarnings("unused")
		String [] Slot = {" 8:00am to 9:15am", "9:30am to 10:45am", "11:00am to 12:15pm", "12:30pm to 1:45pm", "2:00pm to 3:15pm", "3:30pm to 4:45pm"};
		
		testDropCourse2(oCourse);
		
	}
	
	public void testDropCourse2(OnlineCourse oCourse) {
		if(this.getOnlineCourseList().contains(oCourse)) {
			totalUnits -= oCourse.getCreditUnits();
			oCourse.removeStudent(this);
			this.getOnlineCourseList().remove(oCourse);
		}else {
			studentVal += "dropCourse2";
			System.out.println("The course "+oCourse.getDepartment().getDepartmentName()+oCourse.getCourseNumber()+" could not be dropped because " + this.getName()+ " is not enrolled in "+oCourse.getDepartment().getDepartmentName()+ oCourse.getCourseNumber()+".");	
		}
	}
	
/*	public void printSchedule() {//need to fix this
		
		for (int i = 0; i <= schedule.size()-1; i++) {//needs fixing.
			System.out.println(schedule.get(i).substring(4));
			}
	}*/

	public Integer getCampusUnits() {
		return campusUnits;
	}

	public void setCreditUnits(Integer creditUnits) {
		this.campusUnits = creditUnits;
	}

	public Integer getTuitionFee() {
		studentVal += "tutionfee";
		return testGetTuitionFee();
		
	}
	public Integer testGetTuitionFee() {
		studentVal += "dropCourse2";
		int campusFee= 0;
		int onlineFee = 0;
		
		campusFee = campusUnits*300;
		
		for (OnlineCourse i : this.getOnlineCourseList()) {
			if(i.getCreditUnits()==4) {
				onlineFee +=3000;
			}else if(i.getCreditUnits()==3) {
				onlineFee += 2000;
			}
		}
		tuitionFee = campusFee+onlineFee;
		return tuitionFee;
	}
	
	
	public void setTuitionFee(Integer tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public ArrayList<String> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<String> schedule) {
		this.schedule = schedule;
	}

	public String getStudentVal() {
		return studentVal;
	}

	public void setStudentVal(String studentVal) {
		this.studentVal = studentVal;
	}
	
	
	
	/*public Boolean detectConflict(Course aCourse) {//needs fixing
	
	for (int i = 0 ; i <= courseList.size()-1;i++ ) {
		if(courseList.get(i).getSchedule() == aCourse.getSchedule())
			return true;
	}
	return false;
}*/
/*
	
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
				 int u =0;
    			 weekVal = String.valueOf(cTimeList.get(i));
				 weekNum = weekVal.charAt(0);
				 slotVal = weekVal.charAt(2);
				 dName = aCourse.getDepartment().getDepartmentName();
				 time = Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1];
				 cNumber = String.valueOf(aCourse.getCourseNumber());
				 
				 if(stringList.contains(weekVal)) {
					 System.out.println(dName +cNumber+ " cannot be added to "+ name +"'s Schedule. "+ dName+cNumber +" conflicts with " +courseList.get(u).getDepartment().getDepartmentName()+ courseList.get(u).getCourseNumber() + " Conflicting time slot is " + time );
				 }
				 else {
				 schedule.add(weekVal+ " " + Week[Character.getNumericValue(weekNum)-1] + " " + Slot[Character.getNumericValue(slotVal)-1] + " " + aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber() + " " + courseName);
				 courseList.add(aCourse);
				 aCourse.addStudent(this);
				 u=u+1;
				 }
				 stringList.add(weekVal);
		}
			Collections.sort(schedule);
	}*/
	
	/*public void dropCourse(Course aCourse) {
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
		
	}*/
	
}
