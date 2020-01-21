package org.university.software;

import java.util.ArrayList;

import org.university.hardware.Classroom;
import org.university.hardware.Department;

public class University {	
	
	public ArrayList<Department> departmentList;
	public ArrayList<Classroom> classroomList;
	
	public University() {
		departmentList = new ArrayList<Department>();
		classroomList = new ArrayList<Classroom>();
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

	public void printCourseList(){
	
		for (int i = 0; i <= departmentList.size()-1; i++) {
			for (int j = 0; j <= departmentList.get(i).getCourseList().size()-1; j++) {
			    System.out.println(departmentList.get(i).getCourseList().get(j).getName());
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
	
	

}
