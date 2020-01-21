
//10/9/2019
package org.university.people;
import org.university.software.*;
import java.util.ArrayList;

public abstract class Person {
	protected String name;
	protected ArrayList<String> schedule; //int or string 
	protected ArrayList<CampusCourse> campusCourseList;
	protected ArrayList<OnlineCourse> onlineCourseList;
	private String personVal;
	
	public abstract void addCourse(CampusCourse cCourse);
	public abstract void addCourse(OnlineCourse oCourse);
	
	public Person() {
		name = "Person";
		schedule = new ArrayList<String>();
		campusCourseList = new ArrayList<CampusCourse>();
		setPersonVal("nothing");
		onlineCourseList = new ArrayList<OnlineCourse>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String aName) {
		name = aName;
	}
	public ArrayList<CampusCourse> getCampusCourseList() {
		return campusCourseList;
	}
	public ArrayList<OnlineCourse> getOnlineCourseList(){
		return onlineCourseList;
	}
	
	public boolean detectConflict(CampusCourse cCourse) {
		personVal += "detecting Conflict for ccOurse";
		return (testConflict(cCourse));
	}
	
	public boolean testConflict(CampusCourse cCourse) {
		personVal += "test Conflict for ccOurse";
		String[] week = {"Mon","Tue","Wed","Thu","Fri"};
		String[] slot={"8:00am to 9:15am","9:30am to 10:45am","11:00am to 12:15pm","12:30pm to 1:45pm","2:00pm  to  3:15pm","3:30pm  to  4:45pm"};
		String timeSlot = "nothing!!";
		int courseNum=0;
		String weekVal = "nothing";
		String slotVal="nothing";
		String print = "nothing";
		String pName="NoSir";
		
		for(CampusCourse i : campusCourseList) {
			if(i.scheduleDetect(cCourse)) {
				courseNum=i.getCourseNumber();
				for(int j : i.getSchedule()) {
					if(cCourse.getSchedule().contains(j)) {
						weekVal = week[j/100-1];
						slotVal = slot[j%100-1];
						timeSlot = weekVal + " " + slotVal;
						pName = this.getName();
						print = cCourse.getDepartment().getDepartmentName()+cCourse.getCourseNumber()+" course cannot be added to "+pName+"'s Schedule. "+cCourse.getDepartment().getDepartmentName()+cCourse.getCourseNumber()+" conflicts with "+i.getDepartment().getDepartmentName()+courseNum+". Conflicting time slot is "+timeSlot+ ".";
						System.out.println(print);
					}//check the line above
				}
				return true;
			}
		}
		return false;	
		
	}
	
	public void printSchedule() {//Change
		
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
						this.personVal += print;
						print=weekVal+" " +slotVal+" "+cc.getDepartment().getDepartmentName()+cc.getCourseNumber()+" "+cc.getName();
						System.out.println(print);
					}
				}
			}
		}
		if(numOnlineCourse != 0) {
			for(OnlineCourse oc : ocList) {
				this.personVal += print2;
				print2=oc.getCourseNumber()+ " "+oc.getName();
				System.out.println(print2);
			}
		}
	}
	public String getPersonVal() {
		return personVal;
	}
	public void setPersonVal(String personVal) {
		this.personVal = personVal;
	}
	
}
