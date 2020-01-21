package university;

import java.util.ArrayList;

public class University {	
	
	public ArrayList<Department> departmentList;
	
	public University() {
		departmentList = new ArrayList<Department>();
	}
		
	public void printDepartmentList(){
		for (int i = 0; i <= departmentList.size()-1; i++) {
			  System.out.println(departmentList.get(i).getDepartmentName());
			  //System.out.println("RISHAB");
			}
		
	}
	
	public void printStudentList(){
		
		for (int i = 0; i <= departmentList.size()-1; i++) {
			for (int j = 0; j <= departmentList.get(i).getStudents().size()-1; j++) {
			    System.out.println(departmentList.get(i).getStudents().get(j).getName());
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
	

}
