package org.university.software;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Person;
import org.university.people.Professor;
import org.university.people.Staff;
import org.university.people.Student;

@SuppressWarnings("serial")
public class University implements Serializable{	
	
	public ArrayList<Department> departmentList;
	public ArrayList<Classroom> classroomList;
	
	public University() {
		departmentList = new ArrayList<Department>();
		classroomList = new ArrayList<Classroom>();
	}
	public University (University u) {
		this.classroomList = u.getClassroom();
		this.departmentList = u.getDepartment();
		
	}
	public ArrayList<Classroom> getClassroom(){
		return classroomList;
	}
	
	public ArrayList<Department> getDepartment(){
		return departmentList;
	}
	
	public void setDepartment(ArrayList<Department> aDepartment) {
		departmentList = aDepartment;
	}
	
	public void printDepartmentList(){
		for (int i = 0; i <= departmentList.size()-1; i++) {
			  System.out.println(departmentList.get(i).getDepartmentName());
			  //System.out.println("RISHAB");
			}
		
	}
	
	public void printStudentList(){
		
		for (int i = 0; i <= departmentList.size()-1; i++) {
			for (int j = 0; j <= departmentList.get(i).getStudentList().size()-1; j++) {
			    System.out.println(departmentList.get(i).getStudentList().get(j).getName());
				}
			}
	}

	
	public void printCourseList() {
		String print = "nothing";
		String print2 = "nothing";
		
		for (Department d : departmentList) {
			for (CampusCourse cc : d.getCampusCourseList()) {
				print = d.getDepartmentName()+cc.getCourseNumber()+" "+cc.getName();
				System.out.println(print);
			}
		}
		
		for (Department d : departmentList) {
			for (OnlineCourse oc : d.getOnlineCourseList()) {
				print2 = d.getDepartmentName()+oc.getCourseNumber()+" "+oc.getName();
				System.out.println(print2);
			}
			
		}
	}
	
	public void printCourseList1(){
	
		for (int i = 0; i <= departmentList.size()-1; i++) {
			for (int j = 0; j <= departmentList.get(i).getCourseList().size()-1; j++) {
			    System.out.println(departmentList.get(i).getCourseList().get(j).getName() + "HERE!!!!!!!!!!!");

				}
			}

	}
	
	public void printProfessorList(){
		
		for (int i = 0; i <= departmentList.size()-1; i++) {
			for (int j = 0; j <= departmentList.get(i).getProfessorList().size()-1; j++) {
			    System.out.println(departmentList.get(i).getProfessorList().get(j).getName());
				}
			}

	}
	
	
	public void printStaffList() {
		String print = "nothing";
		
		for(Department d : departmentList) {
			for(Staff st : d.getStaffList()) {
				print = st.getName();
				System.out.println(print);
			}
		}
	
	}
	
	
	//**************************NEW********************************************************//
	
	public static void saveData(University aUniversity) {
		FileOutputStream file = null;
		ObjectOutputStream object = null;
				
		try {
			file = new FileOutputStream("University.ser");
			object = new ObjectOutputStream(file); 
			object.writeObject(aUniversity);
			object.close();
			file.close();		//?? do i need thiss??
			System.out.println("Saving.....");
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	public static University loadData() {
		
		University uni = null;
		FileInputStream file = null;
		ObjectInputStream object = null;
		
		try {
			uni = new University();
			file = new FileInputStream("University.ser");
			object = new ObjectInputStream(file); 
			uni = (University) object.readObject(); // this needs class not found exception
			System.out.println("Loading.....");
		}catch(IOException i ) {
			i.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return uni;
	}
	
	
	public void printClassroomList() {
		@SuppressWarnings("unused")
		String print = "nothing";
		for (Classroom c : classroomList) {
			print = c.getRoomNumber();
			System.out.println(c.getRoomNumber());
		}
	}
	public void printProfessorList2() { //for assignment 4
		@SuppressWarnings("unused")
		String print = "nothing";
		
		for (Department d : departmentList){
			System.out.println("\nThe professor list for department "+ d.getDepartmentName());
			for (Professor p : d.getProfessorList()) {
				print = p.getName();
				System.out.println(p.getName());
			}
		}
	}
	
	public void printCourseList2() {
		
		String printCampusCourses = "nothing";
		String printOnlineCourses = "nothing";
		
		for(Department d : departmentList) {
			System.out.print("\nThe course list for department " + d.getDepartmentName()+"\n");
			for (CampusCourse cc : d.getCampusCourseList()) {
				printCampusCourses = d.getDepartmentName() + cc.getCourseNumber() + " " + cc.getName()  +"\n";
				System.out.print(printCampusCourses);
			}
			for (OnlineCourse oc : d.getOnlineCourseList()) {
				printOnlineCourses = d.getDepartmentName() + oc.getCourseNumber() + " " + oc.getName()  + "\n";
				System.out.print(printOnlineCourses);
			}
		}
	}
	
	public void printClassroomSchedule() {
		
		for(Classroom c : classroomList) {
			System.out.println("\nThe schedule for classroom " + c.getRoomNumber());
			c.printSchedule();
		}
		
	}
	
	public void printDepartmentPersonel() {
		
		for (Department d : departmentList){
			System.out.println("\n\nDepartment "+ d.getDepartmentName()+ "\n\nPrinting Professor Schedules:");
			for (Professor p : d.getProfessorList()) {
				System.out.println("\nThe Schedule for Prof. "+ p.getName()+ ":");
				p.printSchedule();
			}
			
			System.out.println("\nPrinting Student Schedules: ");
			
			for (Student s : d.getStudentList()) {
				System.out.println("\nThe schedule for Student "+ s.getName()+ ":");
				s.printSchedule();
			}
			
			System.out.println("\nPrinting Staff Schedules: ");
			
			for (Staff st : d.getStaffList()) {
				System.out.println("\nThe schedule for Employee "+ st.getName()+ ":");
				st.printSchedule();
				//System.out.println("\n\nStaff : "+departmentList.get(j).getStaffList().get(m).getName()+ " earns $" + departmentList.get(j).getStaffList().get(m).getSalary()+" this month");
			}
			
			System.out.println("\nThe rosters for courses offered by "+ d.getDepartmentName()  );
			
			for (CampusCourse cc: d.getCampusCourseList()) {
				System.out.println("\nThe roster for course "+ d.getDepartmentName() + cc.getCourseNumber());
				for (Person s : cc.getStudentRoster()) {
					System.out.println(s.getName());
				}
			}
		}
		
	}
	
	
	public void printAll() {
		
		
		System.out.println("\n");
		System.out.println("List of departments:");
		this.printDepartmentList();
		System.out.println("\n");
		System.out.println("Classroom list:");
		this.printClassroomList();
		
		printProfessorList2();
			
		printCourseList2();
		
		printClassroomSchedule();
		
		printDepartmentPersonel();
		
	}
	
	public void printAllForAdmin() {
		printAll();
	}
	

}