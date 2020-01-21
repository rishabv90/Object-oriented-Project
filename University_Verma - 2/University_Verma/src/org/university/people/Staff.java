package org.university.people;

import java.util.ArrayList;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

public class Staff extends Employee {
	
	private Department department; 
	private Double payRate;
	private Double hoursWorked;
	private Integer tuitionFee;
	private Double salary;
	private String staffVal;
		
	public Staff() {	
		setDepartment(new Department());
		payRate=(double) 0;
		hoursWorked = (double) 0;
		tuitionFee = 0;
		setSalary((double)0);
		setStaffVal("nothign");
	}
	
	public double earns() {
		salary = hoursWorked * payRate;
		staffVal += "earns calculation";
		return (hoursWorked * payRate);
	}
	
	public void setMonthlyHours(double aHours) {
		staffVal += "mothing hours calculation";
		hoursWorked = (double) aHours;
	}
	public double getMonthlyHours() {
		return hoursWorked;
	}
	
	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(Double payRate) {
		this.payRate = payRate;
	}

	public Double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(Double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void raise(double raisePercent) {	
		
		payRate += payRate * (raisePercent / 100);	
		staffVal += "raise = " + payRate;
	}
	
	public int getTuitionFee() {
		staffVal += "tutionfee calc =  " + tutionTest();
		return tutionTest();
		
	}
	
	public int tutionTest() {
		int onCampusFee = 0;
		int onlineFee = 0;
		@SuppressWarnings("unused")
		int ixy=0;
	
		for (CampusCourse i : campusCourseList) {
			onCampusFee += i.getCreditUnits()*300;
			ixy+=1;
		}	
		
		for (OnlineCourse i : onlineCourseList) {
			if(i.getCreditUnits()==4) {
				onlineFee += 3000;
			}
			else if(i.getCreditUnits()==3) {
				onlineFee += 2000;
			}		
			ixy+=1;
		}	
		
		
		tuitionFee = onCampusFee + onlineFee;
		return tuitionFee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void addCourse(Course aCourse) {
		int numCoursesOnline = super.getOnlineCourseList().size();
		int numCoursesCampus = super.getCampusCourseList().size();
		
		if(aCourse instanceof OnlineCourse ) {
			OnlineCourse oChild = (OnlineCourse) aCourse;			
			
			if(numCoursesOnline != 0 && numCoursesCampus == 0) {//Online course overWrite with only online course before
				System.out.println(super.getOnlineCourseList().get(0).getDepartment().getDepartmentName() + this.getOnlineCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time)."+ aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.");
				//remove and add
				super.getOnlineCourseList().remove(0);
				super.getOnlineCourseList().add(oChild);
				aCourse.addStudentToRoster(this);
				
			}else if(numCoursesOnline == 0 && numCoursesCampus != 0) { //online course over write with campus course before
				System.out.println(super.getCampusCourseList().get(0).getDepartment().getDepartmentName() + this.getCampusCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time)."+ aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.");
				super.getCampusCourseList().remove(0);
				super.getOnlineCourseList().add(oChild);
				aCourse.addStudentToRoster(this);	
			}
			
			else {	//empty and add online course
				super.getOnlineCourseList().add(oChild);
				aCourse.addStudentToRoster(this);
			}			
		}
		else if(aCourse instanceof CampusCourse) {
			CampusCourse cChild = (CampusCourse) aCourse;			
			
			if(numCoursesCampus != 0 && numCoursesOnline==0) { //Overwrite campus course
				System.out.println(super.getCampusCourseList().get(0).getDepartment().getDepartmentName() + this.getCampusCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time)."+ aCourse.getDepartment().getDepartmentName()+ aCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.");
				super.getCampusCourseList().remove(0);
				super.getCampusCourseList().add(cChild);
				aCourse.addStudentToRoster(this);
			}else if(numCoursesCampus == 0 && numCoursesOnline != 0) { //online course over write with Online course before
				System.out.println(super.getOnlineCourseList().get(0).getDepartment().getDepartmentName() + this.getOnlineCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time)."+ aCourse.getDepartment().getDepartmentName() + aCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.");
				super.getOnlineCourseList().remove(0);
				super.getCampusCourseList().add(cChild);
				aCourse.addStudentToRoster(this);	
			}else {	//empty and add online course
				super.getCampusCourseList().add(cChild);
				aCourse.addStudentToRoster(this);
			}
			
		}
	}
	
	public void addCourse(OnlineCourse oCourse) {
		testAddCourse1(oCourse);			
	}
	
	public void addCourse(CampusCourse cCourse) {
		testAddCourse2(cCourse);
	}
	public void testAddCourse2(CampusCourse cCourse) {
		int numCoursesOnline = super.getOnlineCourseList().size();
		int numCoursesCampus = super.getCampusCourseList().size();
		
		if(numCoursesCampus != 0 && numCoursesOnline==0) { //Overwrite campus course
			System.out.println(super.getCampusCourseList().get(0).getDepartment().getDepartmentName() + this.getCampusCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time). "+ cCourse.getDepartment().getDepartmentName()+ cCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.");
			super.getCampusCourseList().remove(0);
			super.getCampusCourseList().add(cCourse);
			cCourse.addStudentToRoster(this);
		}else if(numCoursesCampus == 0 && numCoursesOnline != 0) { //online course over write with Online course before
			System.out.println(super.getOnlineCourseList().get(0).getDepartment().getDepartmentName() + this.getOnlineCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time). "+ cCourse.getDepartment().getDepartmentName() + cCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.");
			super.getOnlineCourseList().remove(0);
			super.getCampusCourseList().add(cCourse);
			cCourse.addStudentToRoster(this);	
		}else {	//empty and add online course
			super.getCampusCourseList().add(cCourse);
			cCourse.addStudentToRoster(this);
		}	
	} 
	
	public void testAddCourse1(OnlineCourse oCourse) {
		int numCoursesOnline = super.getOnlineCourseList().size();
		String print = "nothing";
		String print2 = "nothing";
		int numCoursesCampus = super.getCampusCourseList().size();
	
					
			if(numCoursesOnline != 0 && numCoursesCampus == 0) {//Online course overWrite with only online course before
				
				print = super.getOnlineCourseList().get(0).getDepartment().getDepartmentName() + this.getOnlineCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time). "+ oCourse.getDepartment().getDepartmentName() + oCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.";
				
				System.out.println(print);
				//remove and add
				super.getOnlineCourseList().remove(0);
				super.getOnlineCourseList().add(oCourse);
				oCourse.addStudentToRoster(this);
				
			}else if(numCoursesOnline == 0 && numCoursesCampus != 0) { //online course over write with campus course before
				print2 = super.getCampusCourseList().get(0).getDepartment().getDepartmentName() + this.getCampusCourseList().get(0).getCourseNumber()+" is removed from " + name + "'s schedule(Staff can only take one class at a time). "+ oCourse.getDepartment().getDepartmentName() + oCourse.getCourseNumber()+" has been added to "+ getName()+"'s Schedule.";
				System.out.println(print2);
				super.getCampusCourseList().remove(0);
				super.getOnlineCourseList().add(oCourse);
				oCourse.addStudentToRoster(this);	
			}
			else {	//empty and add online course
				super.getOnlineCourseList().add(oCourse);
				oCourse.addStudentToRoster(this);
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
		String print = "nothing";
		String print2 = "nothing";
		ArrayList <CampusCourse> ccList = new ArrayList<CampusCourse>();
		ArrayList <OnlineCourse> ocList = new ArrayList<OnlineCourse>();
		ccList = this.getCampusCourseList();
		ocList = this.getOnlineCourseList();
		
		
		for(int i = minWeek; i <=maxWeek;i=i+minWeek) {
			for(int j =minSlot;j <= maxSlot; j++) {
				timeSchedule=i+j;
				for(CampusCourse cc : ccList) {
					if(cc.getSchedule().contains(timeSchedule)) {
						
						weekVal = Week[(i/100)-1];
						slotVal =  Slot[j-1];
						print = weekVal+" "+slotVal+" "+cc.getDepartment().getDepartmentName()+cc.getCourseNumber() + " " + cc.getName();
						staffVal += print;
						System.out.println(print);
					}
				}
				
			}
		}
		if(numOnlineCourse != 0) {
			for(OnlineCourse oc : ocList) {
				print2=oc.getCourseNumber()+ " "+oc.getName();
				staffVal += print2;
				System.out.println(print2);
			}
		}
	}

	public String getStaffVal() {
		return staffVal;
	}

	public void setStaffVal(String staffVal) {
		this.staffVal = staffVal;
	}

}
