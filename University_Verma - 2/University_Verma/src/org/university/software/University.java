package org.university.software;

import java.util.ArrayList;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Staff;

public class University {	
	
	public ArrayList<Department> departmentList;
	public ArrayList<Classroom> classroomList;
	
	public University() {
		departmentList = new ArrayList<Department>();
		classroomList = new ArrayList<Classroom>();
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

}