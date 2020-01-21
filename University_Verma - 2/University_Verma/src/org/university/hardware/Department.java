package org.university.hardware;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;
import org.university.people.Student;
import org.university.people.Professor;
import org.university.people.Staff;

//import java.io.*; 
import java.util.*; 

public class Department {

	
	private String name; 
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<Professor> professorList;
	private ArrayList<Staff> staffList;
	private String departmentVal;//NEVERAGAIN
	
	private ArrayList<CampusCourse> campusCourseList;
	private ArrayList<OnlineCourse> onlineCourseList;
	
	public Department() {
		departmentVal = "nothing";
		name = "x";
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		professorList = new ArrayList<Professor>();
		setStaffList(new ArrayList<Staff>());
		campusCourseList = new ArrayList<CampusCourse>();
		onlineCourseList = new ArrayList<OnlineCourse>();
		
	}
	
	public void setDepartmentName(String aName ) {
		name = aName;
	}
	
	public String getDepartmentName() {
		return name;	
	}
	
	public void addCourse(Course course) {
		departmentVal += "adding Normal course. ";
		courseList.add(course);
		course.setDepartment(this);
	}
	
	public void addCourse(CampusCourse cCourse) {
		departmentVal += "adding Campus course. ";
		cCourse.setDepartment(this);
		campusCourseList.add(cCourse);
	}
	public void addCourse(OnlineCourse oCourse) {
		departmentVal += "adding Online course. ";
		oCourse.setDepartment(this);
		onlineCourseList.add(oCourse);
	}
	
	public void addStudent(Student student) {
		student.setDepartment(this);
		departmentVal += "adding student ";
		studentList.add(student);
		
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public ArrayList<Course> getCourseList(){
		return courseList;
	}
	
	public void addStaff(Staff aStaff) {
		departmentVal += "adding Staff ";
		staffList.add(aStaff);
		aStaff.setDepartment(this);
	}
	
	public ArrayList<Professor> getProfessorList() {
		return professorList;
	}

	public void setProfessorList(ArrayList<Professor> professorList) {
		this.professorList = professorList;
	}
	
	public void printStudentList() {//need to fix this
		String print= "nothing";
		
		for(Student s : studentList) {
			print = s.getName();
			departmentVal += "adding student" + print;
			System.out.print(print);
		}
		
		/*
		for (int i = 0; i <= studentList.size()-1; i++) {
			  System.out.println(studentList.get(i).getName());
			}*/
	}
	
	public void printProfessorList() {//need to fix this
		String print= "nothing";
		
		for(Professor p : professorList) {
			print = p.getName();
			departmentVal += "adding prof" + print;
			System.out.println(print);
			
		}
		
		/*
		
		for (int i = 0; i <= professorList.size()-1; i++) {
			  System.out.println(professorList.get(i).getName());
			}*/
	}
	
	public void printCourseList() {
		String print = "nothing";
		String print2 = "nothing";
		
		for (CampusCourse cc: campusCourseList) {
			print = cc.getDepartment().getDepartmentName()+cc.getCourseNumber()+" "+cc.getName();
			departmentVal += "adding Campus COurse" + print;
			System.out.println(print);
		}

		for (OnlineCourse oc: onlineCourseList) {
			print2 = oc.getDepartment().getDepartmentName()+oc.getCourseNumber()+" "+oc.getName();
			departmentVal += "adding OnlineCourse" + print2;
			System.out.println(print2);
		}
		departmentVal += "fininshed printCourse";
	}
	
	
	public void addProfessor(Professor aProfessor){//check!!!
		professorList.add(aProfessor);
	}

	public ArrayList<CampusCourse> getCampusCourseList() {
		return campusCourseList;
	}

	public void setCampusCourseList(ArrayList<CampusCourse> campusCourseList) {
		this.campusCourseList = campusCourseList;
	}

	public ArrayList<OnlineCourse> getOnlineCourseList() {
		return onlineCourseList;
	}

	public void setOnlineCourseList(ArrayList<OnlineCourse> onlineCourseList) {
		this.onlineCourseList = onlineCourseList;
	}

	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}

	public String getDepartmentVal() {
		return departmentVal;
	}

	public void setDepartmentVal(String departmentVal) {
		this.departmentVal = departmentVal;
	}
	
}
